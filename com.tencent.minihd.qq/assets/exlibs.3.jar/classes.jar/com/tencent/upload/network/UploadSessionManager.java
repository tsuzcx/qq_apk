package com.tencent.upload.network;

import android.os.Looper;
import android.util.SparseArray;
import com.tencent.upload.common.HandlerWapper;
import com.tencent.upload.common.LogPrint;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;
import com.tencent.upload.common.UploadLog;
import com.tencent.upload.network.action.ActionResponse;
import com.tencent.upload.network.action.IActionRequest;
import com.tencent.upload.network.route.IUploadRouteStrategy;
import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.network.session.IUploadSession;
import com.tencent.upload.network.session.IUploadSessionCallback;
import com.tencent.upload.network.session.IUploadSessionCallback.DetectionState;
import com.tencent.upload.network.session.IUploadSessionCallback.FailureCode;
import com.tencent.upload.network.session.UploadSession;
import com.tencent.upload.uinterface.IUploadAction;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class UploadSessionManager
  implements IUploadSessionManager, IUploadSessionCallback
{
  private static final boolean CANCEL_CLOSE_COUNTDOWN = false;
  private static final boolean NEED_REDIRECT = true;
  private static final boolean START_CLOSE_COUNTDOWN = true;
  private static final String TAG = "SessionManager";
  private ActionWrapper mActionWrapper;
  private ArrayList<IUploadAction> mCurrentActions;
  private volatile int mDetectionState;
  private UploadRoute mErrorRoute;
  private HandlerWapper mHandler;
  private final int mHashCode = hashCode();
  private HashMap<String, Integer> mIpTimeoutMap;
  private final byte[] mLock = new byte[0];
  private final WeakReference<IManagerCallback> mManagerCallback;
  private UploadConfiguration.NetworkStateObserver mNetworkStateObserver;
  private IUploadRouteStrategy mRouteStrategy;
  private SparseArray<IUploadAction> mUploadActionMap;
  private LinkedList<IUploadAction> mUploadActions;
  private String mUsedApn;
  
  public UploadSessionManager(IUploadRouteStrategy paramIUploadRouteStrategy, Looper paramLooper, IManagerCallback paramIManagerCallback)
  {
    this.mRouteStrategy = paramIUploadRouteStrategy;
    this.mHandler = new HandlerWapper(paramLooper);
    this.mManagerCallback = new WeakReference(paramIManagerCallback);
    this.mDetectionState = 0;
    this.mIpTimeoutMap = new HashMap();
    this.mActionWrapper = new ActionWrapper();
    this.mUploadActionMap = new SparseArray();
    this.mUploadActions = new LinkedList();
    this.mCurrentActions = new ArrayList(2);
    this.mNetworkStateObserver = new UploadConfiguration.NetworkStateObserver()
    {
      public void onStateChanged(boolean paramAnonymousBoolean)
      {
        UploadLog.w("SessionManager", UploadSessionManager.this.mHashCode + " " + LogPrint.serverCategory(UploadSessionManager.this.mRouteStrategy) + " NetworkStateObserver isConnected:" + paramAnonymousBoolean);
        if (!paramAnonymousBoolean)
        {
          UploadSessionManager.this.mHandler.post(new Runnable()
          {
            public void run()
            {
              if (UploadConfiguration.isNetworkAvailable()) {}
              while (UploadSessionManager.this.mUploadActions.size() == 0) {
                return;
              }
              ((IUploadAction)UploadSessionManager.this.mUploadActions.get(0)).onError(null, 35000, "no network notify", true);
            }
          });
          return;
        }
        UploadSessionManager.this.mHandler.post(new Runnable()
        {
          public void run()
          {
            if (!UploadConfiguration.isNetworkAvailable()) {}
            while (UploadSessionManager.this.mUploadActions.size() == 0) {
              return;
            }
            UploadSessionManager.this.doPerpare(true, 0);
          }
        });
      }
    };
    UploadConfiguration.registerNetworkStateObserver(this.mNetworkStateObserver);
  }
  
  private void doCancel(int paramInt1, int paramInt2)
  {
    Object localObject = (IUploadAction)this.mUploadActionMap.get(paramInt1);
    if (localObject == null) {}
    label265:
    label306:
    do
    {
      return;
      this.mUploadActions.remove(localObject);
      this.mUploadActionMap.delete(paramInt1);
      boolean bool2 = this.mCurrentActions.remove(localObject);
      boolean bool1;
      ActionWrapper localActionWrapper;
      if ((((IUploadAction)localObject).getSendState() != 1) && (((IUploadAction)localObject).getSendState() != 2))
      {
        bool1 = false;
        UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " doCancel: action:" + LogPrint.hashCode(localObject) + " actSeq:" + paramInt1 + " after remove, mUploadActions size:" + this.mUploadActions.size() + " mCurrentActions size:" + this.mCurrentActions.size() + " isRemoved:" + bool2 + " isInProcess:" + bool1);
        localActionWrapper = this.mActionWrapper;
        if ((!bool2) || (!bool1)) {
          break label265;
        }
        doCloseSession();
      }
      for (;;)
      {
        ((IUploadAction)localObject).onCancel(paramInt2);
        if (this.mUploadActions.size() == 0)
        {
          localObject = (IManagerCallback)this.mManagerCallback.get();
          if (localObject != null) {
            ((IManagerCallback)localObject).onCloseCountdown(this, true);
          }
        }
        if (this.mDetectionState != 2) {
          break label306;
        }
        doCloseDetectedSession();
        doDriveNext();
        return;
        bool1 = true;
        break;
        if (localActionWrapper.detectedSession != null) {
          localActionWrapper.detectedSession.cancel(paramInt1);
        }
        if (localActionWrapper.redirectSession != null) {
          localActionWrapper.redirectSession.cancel(paramInt1);
        }
      }
    } while ((this.mDetectionState == 1) || (this.mDetectionState != 0) || (this.mUploadActions.size() == 0) || (!UploadConfiguration.isNetworkAvailable()));
    doPerpare(true, 0);
  }
  
  private void doCloseDetectedSession()
  {
    ActionWrapper localActionWrapper = this.mActionWrapper;
    if ((localActionWrapper.redirectSession == null) || (localActionWrapper.detectedSession == null) || (!localActionWrapper.detectedSession.isIdle())) {
      return;
    }
    IUploadSession localIUploadSession = localActionWrapper.detectedSession;
    localActionWrapper.detectedSession = null;
    localIUploadSession.close();
    UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " doCloseDetectedSession, close detectedSe:" + LogPrint.hashCode(localIUploadSession) + " keep redirectSe:" + LogPrint.hashCode(localActionWrapper.redirectSession));
  }
  
  private void doCloseSession()
  {
    UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " doCloseSession");
    ActionWrapper localActionWrapper = this.mActionWrapper;
    doSetDetectionState(0);
    for (;;)
    {
      if (localActionWrapper.detectionSessions.size() <= 0)
      {
        IUploadSession localIUploadSession;
        if (localActionWrapper.detectedSession != null)
        {
          localIUploadSession = localActionWrapper.detectedSession;
          localActionWrapper.detectedSession = null;
          localIUploadSession.close();
        }
        if (localActionWrapper.redirectSession != null)
        {
          localIUploadSession = localActionWrapper.redirectSession;
          localActionWrapper.redirectSession = null;
          localIUploadSession.close();
        }
        return;
      }
      ((IUploadSession)localActionWrapper.detectionSessions.remove(0)).close();
    }
  }
  
  private void doDriveNext()
  {
    IUploadAction localIUploadAction = doRetrieveFrist();
    if (localIUploadAction == null) {}
    ActionWrapper localActionWrapper;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.mCurrentActions.contains(localIUploadAction));
        this.mCurrentActions.add(localIUploadAction);
        UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " doDriveNext doRetrieveFrist first action:" + LogPrint.hashCode(localIUploadAction) + " actSeq:" + LogPrint.actionSequence(localIUploadAction) + " mCurrentActions after add, size:" + this.mCurrentActions.size() + " mUploadActions size:" + this.mUploadActions.size());
        localActionWrapper = this.mActionWrapper;
        if (localActionWrapper.redirectSession == null) {
          break;
        }
      } while (localIUploadAction.onSend(localActionWrapper.redirectSession));
      UploadLog.w("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " doDriveNext: action.onSend redirect Se:" + LogPrint.hashCode(localActionWrapper.redirectSession) + " failed");
      return;
      if (localActionWrapper.detectedSession == null) {
        break;
      }
    } while (localIUploadAction.onSend(localActionWrapper.detectedSession));
    UploadLog.w("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " doDriveNext: action.onSend Se:" + LogPrint.hashCode(localActionWrapper.detectedSession) + " failed");
    return;
    UploadLog.e("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " doDriveNext: no available session");
  }
  
  private void doHandleError(IUploadSession paramIUploadSession, int paramInt, String paramString, boolean paramBoolean)
  {
    doSetDetectionState(0);
    doNotifyError(paramIUploadSession, paramInt, paramString, paramBoolean);
    if (this.mUploadActions.size() == 0)
    {
      paramIUploadSession = (IManagerCallback)this.mManagerCallback.get();
      if (paramIUploadSession != null)
      {
        UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " doHandleError, actions is zero, onCloseCountdown:" + true);
        paramIUploadSession.onCloseCountdown(this, true);
      }
    }
    while (!UploadConfiguration.isNetworkAvailable()) {
      return;
    }
    doPerpare(false, paramInt);
    this.mErrorRoute = null;
  }
  
  private void doNotifyError(IUploadSession paramIUploadSession, int paramInt, String paramString, boolean paramBoolean)
  {
    UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " doNotifyError, mCurrentActions size:" + this.mCurrentActions.size() + " mUploadActions size:" + this.mUploadActions.size() + " SeError:" + paramInt + " SeDes:" + paramString);
    if (this.mCurrentActions.isEmpty())
    {
      if (this.mUploadActions.isEmpty()) {
        return;
      }
      ((IUploadAction)this.mUploadActions.get(0)).onError(paramIUploadSession, paramInt, paramString, paramBoolean);
      return;
    }
    while (this.mCurrentActions.size() > 0) {
      ((IUploadAction)this.mCurrentActions.remove(0)).onError(paramIUploadSession, paramInt, paramString, paramBoolean);
    }
  }
  
  private void doOpenRedirectSession(IUploadSession paramIUploadSession, ActionWrapper paramActionWrapper)
  {
    paramIUploadSession = paramIUploadSession.getRedirectRoute();
    if (paramIUploadSession == null) {}
    UploadSession localUploadSession;
    do
    {
      return;
      localUploadSession = new UploadSession(false, this.mHandler.getLooper(), this);
    } while (!localUploadSession.open(paramIUploadSession));
    paramActionWrapper.detectionSessions.add(localUploadSession);
    UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " onOpen, start redirect Se:" + LogPrint.hashCode(localUploadSession) + " redirectRoute:" + paramIUploadSession);
  }
  
  private void doPerpare(boolean paramBoolean, int paramInt)
  {
    ActionWrapper localActionWrapper = this.mActionWrapper;
    if (this.mDetectionState != 0) {
      UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " doPerpare: detectionState != NO_DETECTION return");
    }
    Object localObject1;
    do
    {
      return;
      Object localObject2 = null;
      if (paramBoolean) {
        localObject1 = this.mRouteStrategy.reset();
      }
      Object localObject3;
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = this.mRouteStrategy.reset();
        }
        if ((localObject2 != null) && (localObject2.length != 0)) {
          break;
        }
        UploadLog.e("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " doPerpare: RouteStrategy reset no result");
        doNotifyError(null, 31000, "reset null, all route has failed", false);
        return;
        i = 0;
        if ((paramInt == 30400) || (paramInt == 30800)) {
          i = 3;
        }
        if (this.mErrorRoute != null)
        {
          localObject3 = (Integer)this.mIpTimeoutMap.get(this.mErrorRoute.getIp());
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (((Integer)localObject3).intValue() >= 2) {
              localObject1 = this.mRouteStrategy.next(this.mErrorRoute, i);
            }
          }
        }
        else
        {
          localObject1 = this.mRouteStrategy.next(this.mErrorRoute, i);
        }
      }
      int i = localObject2.length;
      paramInt = 0;
      for (;;)
      {
        if (paramInt >= i)
        {
          if (localActionWrapper.detectionSessions.size() != 0) {
            break;
          }
          UploadLog.w("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " doPerpare: detectionSessions.size() == 0");
          doNotifyError(null, 31000, "reset connection failed", false);
          return;
        }
        localObject1 = localObject2[paramInt];
        localObject3 = new UploadSession(true, this.mHandler.getLooper(), this);
        if (((IUploadSession)localObject3).open((UploadRoute)localObject1)) {
          localActionWrapper.detectionSessions.add(localObject3);
        }
        paramInt += 1;
      }
      doSetDetectionState(1);
      UploadLog.e("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " doPerpare: detect start, DETECTING");
      localObject1 = (IManagerCallback)this.mManagerCallback.get();
    } while (localObject1 == null);
    ((IManagerCallback)localObject1).onCloseCountdown(this, false);
  }
  
  private IUploadAction doRetrieveFrist()
  {
    if (this.mUploadActions.size() == 0) {
      return null;
    }
    return (IUploadAction)this.mUploadActions.getFirst();
  }
  
  private void doSetDetectionState(int paramInt)
  {
    if (this.mActionWrapper == null) {}
    while (this.mDetectionState == paramInt) {
      return;
    }
    this.mDetectionState = paramInt;
    if (1 == paramInt) {
      this.mCurrentActions.clear();
    }
    UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " setDetectionState:" + IUploadSessionCallback.DetectionState.print(paramInt));
  }
  
  private void doUpload(IUploadAction paramIUploadAction)
  {
    if (paramIUploadAction == null) {
      UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " doUpload: action null return");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.mUploadActionMap.get(paramIUploadAction.getActionSequence()) != null)
            {
              UploadLog.w("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " doUpload: duplicate, action:" + LogPrint.hashCode(paramIUploadAction) + " actSeq:" + paramIUploadAction.getActionSequence());
              return;
            }
            this.mUploadActions.addLast(paramIUploadAction);
            this.mUploadActionMap.put(paramIUploadAction.getActionSequence(), paramIUploadAction);
            UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " doUpload: action:" + LogPrint.hashCode(paramIUploadAction) + " actSeq:" + LogPrint.actionSequence(paramIUploadAction) + " after add, mUploadActions size:" + this.mUploadActions.size());
            localObject = this.mActionWrapper;
            if (this.mUploadActions.size() == 1)
            {
              IManagerCallback localIManagerCallback = (IManagerCallback)this.mManagerCallback.get();
              if (localIManagerCallback != null) {
                localIManagerCallback.onCloseCountdown(this, false);
              }
            }
            if (this.mDetectionState == 2)
            {
              doDriveNext();
              return;
            }
          } while ((this.mDetectionState == 1) || (this.mDetectionState != 0) || (!UploadConfiguration.isNetworkAvailable()));
          doPerpare(true, 0);
        } while (this.mDetectionState != 1);
        localObject = (IUploadSession)((ActionWrapper)localObject).detectionSessions.get(0);
      } while (localObject == null);
      localObject = ((IUploadSession)localObject).getUploadRoute();
    } while ((localObject == null) || (((UploadRoute)localObject).getProtocol() != 1));
    UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " doUpload: action:" + LogPrint.hashCode(paramIUploadAction) + " actSeq:" + LogPrint.actionSequence(paramIUploadAction) + " onConnecting");
    paramIUploadAction.onConnecting();
  }
  
  public boolean cancelAll(final int paramInt)
  {
    synchronized (this.mLock)
    {
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          int j = 0;
          for (;;)
          {
            if (UploadSessionManager.this.mUploadActions.size() <= 0)
            {
              UploadSessionManager.this.mUploadActions.clear();
              UploadSessionManager.this.mUploadActionMap.clear();
              UploadSessionManager.this.mCurrentActions.clear();
              if (j != 0) {
                UploadSessionManager.this.doCloseSession();
              }
            }
            synchronized (UploadSessionManager.this.mLock)
            {
              UploadSessionManager.this.mLock.notify();
              return;
              ??? = (IUploadAction)UploadSessionManager.this.mUploadActions.remove(0);
              if (??? == null) {
                continue;
              }
              int i = j;
              if (j == 0)
              {
                if ((((IUploadAction)???).getSendState() != 1) && (((IUploadAction)???).getSendState() != 2)) {
                  i = 0;
                }
              }
              else
              {
                UploadSessionManager.this.mUploadActionMap.remove(((IUploadAction)???).getActionSequence());
                ((IUploadAction)???).onCancel(paramInt);
                j = i;
                continue;
              }
              i = 1;
            }
          }
        }
      });
      try
      {
        this.mLock.wait();
        return true;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          UploadLog.e("SessionManager", localInterruptedException.toString());
        }
      }
    }
  }
  
  public boolean cancelAsync(final int paramInt1, final int paramInt2)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        UploadSessionManager.this.doCancel(paramInt1, paramInt2);
      }
    });
  }
  
  public void close()
  {
    UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " close");
    synchronized (this.mLock)
    {
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          UploadSessionManager.this.doCloseSession();
          synchronized (UploadSessionManager.this.mLock)
          {
            UploadSessionManager.this.mLock.notify();
            return;
          }
        }
      });
      try
      {
        this.mLock.wait();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          UploadLog.e("SessionManager", localInterruptedException.toString());
        }
      }
    }
  }
  
  public int getServerCategory()
  {
    return this.mRouteStrategy.getServerCategory();
  }
  
  public boolean isPerpared()
  {
    return this.mDetectionState == 2;
  }
  
  public void onClose(IUploadSession paramIUploadSession) {}
  
  public void onError(IUploadSession paramIUploadSession, int paramInt, String paramString)
  {
    boolean bool2;
    label32:
    Object localObject;
    int i;
    label189:
    String str;
    Integer localInteger;
    if (UploadConfiguration.isNetworkAvailable())
    {
      bool1 = false;
      if ((this.mUsedApn == null) || (this.mUsedApn.compareToIgnoreCase(UploadConfiguration.getCurrentApn()) != 0)) {
        break label332;
      }
      bool2 = false;
      UploadLog.w("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " detectionState:" + IUploadSessionCallback.DetectionState.print(this.mDetectionState) + " onError: Se:" + LogPrint.hashCode(paramIUploadSession) + " Se error:" + paramInt + " causedByNoNetwork:" + bool1 + " causedByApnChanged:" + bool2 + " currentApn:" + UploadConfiguration.getCurrentApn() + " oldApn:" + this.mUsedApn);
      this.mErrorRoute = null;
      if (paramIUploadSession != null)
      {
        localObject = paramIUploadSession.getUploadRoute();
        if ((paramInt == 30800) || (paramInt == 30400)) {
          break label338;
        }
        i = 0;
        if ((localObject != null) && (i != 0))
        {
          str = ((UploadRoute)localObject).getIp();
          localInteger = (Integer)this.mIpTimeoutMap.get(str);
          if (localInteger != null) {
            break label344;
          }
          this.mIpTimeoutMap.put(str, Integer.valueOf(1));
          label239:
          UploadConfiguration.addUploadIpTimeouts(((UploadRoute)localObject).getIp());
        }
        this.mErrorRoute = ((UploadRoute)localObject);
      }
      localObject = this.mActionWrapper;
      if (this.mDetectionState != 2) {
        break label547;
      }
      this.mCurrentActions.clear();
      paramIUploadSession.close();
      if (paramIUploadSession != ((ActionWrapper)localObject).redirectSession) {
        break label434;
      }
      ((ActionWrapper)localObject).redirectSession = null;
      if (((ActionWrapper)localObject).detectedSession != null) {
        break label373;
      }
      if ((bool1) || (bool2)) {
        break label367;
      }
      bool1 = false;
      label316:
      doHandleError(paramIUploadSession, paramInt, paramString, bool1);
    }
    label332:
    label338:
    label344:
    label367:
    label373:
    do
    {
      do
      {
        return;
        bool1 = true;
        break;
        bool2 = true;
        break label32;
        i = 1;
        break label189;
        this.mIpTimeoutMap.put(str, Integer.valueOf(localInteger.intValue() + 1));
        break label239;
        bool1 = true;
        break label316;
        UploadLog.w("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " onError: Se:" + LogPrint.hashCode(paramIUploadSession) + " redirect session error, but has detected session");
        doDriveNext();
        return;
      } while (paramIUploadSession != ((ActionWrapper)localObject).detectedSession);
      ((ActionWrapper)localObject).detectedSession = null;
      if (((ActionWrapper)localObject).redirectSession == null)
      {
        if ((!bool1) && (!bool2)) {}
        for (bool1 = false;; bool1 = true)
        {
          doHandleError(paramIUploadSession, paramInt, paramString, bool1);
          return;
        }
      }
      UploadLog.w("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " onError: Se:" + LogPrint.hashCode(paramIUploadSession) + " detected session error, but has redirect session");
      doDriveNext();
      return;
      if (this.mDetectionState != 1) {
        break label652;
      }
      if (paramIUploadSession != ((ActionWrapper)localObject).detectedSession)
      {
        UploadLog.w("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " session != wrapper.detectedSession");
        return;
      }
      ((ActionWrapper)localObject).detectedSession = null;
    } while (((ActionWrapper)localObject).detectionSessions.size() != 0);
    label434:
    if ((!bool1) && (!bool2)) {}
    label547:
    for (boolean bool1 = false;; bool1 = true)
    {
      onSetSessionNoDetection(paramIUploadSession, bool1);
      return;
    }
    label652:
    UploadLog.w("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " detectionState:" + IUploadSessionCallback.DetectionState.print(this.mDetectionState) + " mDetectionState is not DETECTING or DETECTED");
  }
  
  public void onFailToOpen(IUploadSession paramIUploadSession, int paramInt, boolean paramBoolean)
  {
    boolean bool1;
    boolean bool2;
    if ((UploadConfiguration.isNetworkAvailable()) && (!paramBoolean))
    {
      bool1 = false;
      bool2 = false;
      if (paramIUploadSession != null) {
        break label80;
      }
      UploadLog.e("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " onFailToOpen: dState:" + IUploadSessionCallback.DetectionState.print(this.mDetectionState));
    }
    label80:
    label472:
    label622:
    do
    {
      for (;;)
      {
        return;
        bool1 = true;
        break;
        UploadLog.w("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " onFailToOpen: dState:" + IUploadSessionCallback.DetectionState.print(this.mDetectionState) + " Se:" + LogPrint.hashCode(paramIUploadSession) + " failureCode:" + IUploadSessionCallback.FailureCode.print(paramInt) + " causedByNoNetwork:" + bool1 + " noNetwork:" + paramBoolean);
        ActionWrapper localActionWrapper = this.mActionWrapper;
        paramBoolean = localActionWrapper.detectionSessions.remove(paramIUploadSession);
        boolean bool3 = paramIUploadSession.isRedirect();
        paramIUploadSession.close();
        if (this.mDetectionState == 2)
        {
          UploadLog.w("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " onFailToOpen: Se:" + LogPrint.hashCode(paramIUploadSession) + " DETECTED, isRedirect:" + bool3 + " isContained:" + paramBoolean);
          return;
        }
        if (this.mDetectionState != 1) {
          break label622;
        }
        if (!paramBoolean)
        {
          UploadLog.w("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " onFailToOpen: Se:" + LogPrint.hashCode(paramIUploadSession) + " DETECTING, !isContained");
          return;
        }
        paramBoolean = bool2;
        Object localObject;
        if (!bool3)
        {
          paramBoolean = bool2;
          if (!bool1)
          {
            localObject = this.mRouteStrategy.next(paramIUploadSession.getUploadRoute(), paramInt);
            if (localObject == null) {
              break label526;
            }
            int i = localObject.length;
            paramInt = 0;
            if (paramInt < i) {
              break label472;
            }
            paramBoolean = bool2;
          }
        }
        for (;;)
        {
          if (localActionWrapper.detectionSessions.size() != 0) {
            break label597;
          }
          IUploadSession localIUploadSession = localActionWrapper.detectedSession;
          localObject = localIUploadSession;
          if (localIUploadSession == null)
          {
            localObject = localIUploadSession;
            if (localActionWrapper.redirectSession != null) {
              localObject = localActionWrapper.redirectSession;
            }
          }
          if (localObject == null) {
            break label599;
          }
          onSetSessionDetected((IUploadSession)localObject);
          return;
          localIUploadSession = localObject[paramInt];
          UploadSession localUploadSession = new UploadSession(true, this.mHandler.getLooper(), this);
          if (localUploadSession.open(localIUploadSession)) {
            localActionWrapper.detectionSessions.add(localUploadSession);
          }
          paramInt += 1;
          break;
          paramBoolean = this.mRouteStrategy.causedByApnChanged();
          UploadLog.w("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " onFailToOpen: Se:" + LogPrint.hashCode(paramIUploadSession) + " causedByApnChanged:" + paramBoolean);
        }
      }
      if ((!bool1) && (!paramBoolean)) {}
      for (paramBoolean = false;; paramBoolean = true)
      {
        onSetSessionNoDetection(paramIUploadSession, paramBoolean);
        return;
      }
    } while (this.mDetectionState != 0);
    label526:
    label597:
    label599:
    UploadLog.e("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " onFailToOpen: Se:" + LogPrint.hashCode(paramIUploadSession) + " NO_DETECTION");
  }
  
  public void onOpen(IUploadSession paramIUploadSession)
  {
    if (paramIUploadSession == null) {
      UploadLog.e("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " onOpen: dState:" + IUploadSessionCallback.DetectionState.print(this.mDetectionState));
    }
    do
    {
      for (;;)
      {
        return;
        UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " onOpen: dState:" + IUploadSessionCallback.DetectionState.print(this.mDetectionState) + " Se:" + LogPrint.hashCode(paramIUploadSession));
        ActionWrapper localActionWrapper = this.mActionWrapper;
        boolean bool1 = localActionWrapper.detectionSessions.remove(paramIUploadSession);
        boolean bool2 = paramIUploadSession.isRedirect();
        if (this.mDetectionState == 2)
        {
          paramIUploadSession.close();
          return;
        }
        if (this.mDetectionState != 1) {
          break;
        }
        if (!bool1)
        {
          paramIUploadSession.close();
          UploadLog.w("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " onOpen: Se:" + LogPrint.hashCode(paramIUploadSession) + " DETECTING, !isContained");
          return;
        }
        while (localActionWrapper.detectionSessions.size() > 0) {
          ((IUploadSession)localActionWrapper.detectionSessions.remove(0)).close();
        }
        if (bool2)
        {
          localActionWrapper.redirectSession = paramIUploadSession;
          doCloseDetectedSession();
          UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " onOpen, redirectSe establish:" + paramIUploadSession.hashCode());
        }
        while (localActionWrapper.detectionSessions.size() == 0)
        {
          onSetSessionDetected(paramIUploadSession);
          return;
          localActionWrapper.detectedSession = paramIUploadSession;
          doOpenRedirectSession(paramIUploadSession, localActionWrapper);
        }
      }
    } while (this.mDetectionState != 0);
    paramIUploadSession.close();
  }
  
  public void onReceive(IUploadSession paramIUploadSession, ActionResponse paramActionResponse)
  {
    if (this.mDetectionState == 2)
    {
      if (paramActionResponse == null)
      {
        UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " onReceive: Se:" + LogPrint.hashCode(paramIUploadSession) + " response == null, is Discarded...");
        return;
      }
      IUploadAction localIUploadAction = (IUploadAction)this.mUploadActionMap.get(paramActionResponse.getActionSequence());
      if (localIUploadAction == null)
      {
        UploadLog.w("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " detectionState:" + IUploadSessionCallback.DetectionState.print(this.mDetectionState) + " onReceive: Se:" + LogPrint.hashCode(paramIUploadSession) + " actSeq:" + LogPrint.actionSequence(paramActionResponse) + " cmd:" + LogPrint.commandId(paramActionResponse) + " is Discarded...");
        return;
      }
      if (paramActionResponse.isSuccessfulFinish()) {
        this.mRouteStrategy.save(paramIUploadSession.getUploadRoute());
      }
      localIUploadAction.onResponse(paramIUploadSession, paramActionResponse);
      return;
    }
    UploadLog.w("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " detectionState:" + IUploadSessionCallback.DetectionState.print(this.mDetectionState) + " onReceive: Se:" + LogPrint.hashCode(paramIUploadSession));
  }
  
  public void onReceiveTimeout(IUploadSession paramIUploadSession, IActionRequest paramIActionRequest)
  {
    UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " onReceiveTimeout Se: " + LogPrint.hashCode(paramIUploadSession) + " actSeq:" + LogPrint.actionSequence(paramIActionRequest) + " reqSeq:" + LogPrint.requestSequence(paramIActionRequest));
    if (paramIActionRequest == null) {}
    IUploadAction localIUploadAction;
    do
    {
      return;
      localIUploadAction = (IUploadAction)this.mUploadActionMap.get(paramIActionRequest.getActionSequence());
    } while (localIUploadAction == null);
    if (this.mDetectionState == 2)
    {
      localIUploadAction.onTimeout(paramIUploadSession, paramIActionRequest);
      return;
    }
    UploadLog.w("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " detectionState:" + IUploadSessionCallback.DetectionState.print(this.mDetectionState) + " onReceiveTimeout: Se:" + LogPrint.hashCode(paramIUploadSession));
  }
  
  public void onSend(IUploadSession paramIUploadSession, IActionRequest paramIActionRequest)
  {
    UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " onSend: Se:" + LogPrint.hashCode(paramIUploadSession) + " actSeq:" + LogPrint.actionSequence(paramIActionRequest) + " reqSeq:" + LogPrint.requestSequence(paramIActionRequest) + " cmd:" + LogPrint.commandId(paramIActionRequest));
    if (paramIActionRequest == null) {
      UploadLog.e("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " onSend: Se:" + LogPrint.hashCode(paramIUploadSession) + " request null");
    }
    IUploadAction localIUploadAction;
    do
    {
      return;
      localIUploadAction = (IUploadAction)this.mUploadActionMap.get(paramIActionRequest.getActionSequence());
    } while (localIUploadAction == null);
    if (this.mDetectionState == 2)
    {
      localIUploadAction.onRequest(paramIUploadSession, paramIActionRequest);
      return;
    }
    UploadLog.w("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " detectionState:" + IUploadSessionCallback.DetectionState.print(this.mDetectionState) + " onSend: Se:" + LogPrint.hashCode(paramIUploadSession));
  }
  
  public void onSetSessionDetected(IUploadSession paramIUploadSession)
  {
    doSetDetectionState(2);
    this.mUsedApn = UploadConfiguration.getCurrentApn();
    UploadLog.e("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " Detect end, DETECTED !!!!! detectedSe:" + paramIUploadSession.hashCode() + " currentApn:" + this.mUsedApn);
    String str = new StringBuilder(" openSession:").append(paramIUploadSession.getUploadRoute().toString()).append(" ").toString() + this.mRouteStrategy.getUsedRoutesDescription();
    IManagerCallback localIManagerCallback = (IManagerCallback)this.mManagerCallback.get();
    if (localIManagerCallback != null) {
      localIManagerCallback.onOpen(this, paramIUploadSession.getUploadRoute(), str);
    }
    if (this.mUploadActions.size() == 0)
    {
      if (localIManagerCallback != null)
      {
        UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " onSetSessionDetected, actions is zero, onCloseCountdown:" + true);
        localIManagerCallback.onCloseCountdown(this, true);
      }
      return;
    }
    doDriveNext();
  }
  
  public void onSetSessionNoDetection(IUploadSession paramIUploadSession, boolean paramBoolean)
  {
    doSetDetectionState(0);
    UploadLog.e("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " Detect end, NO_DETECTION !!!!!");
    String str = new StringBuilder("causedByNoNetwork:").append(paramBoolean).append(" falToOpenSession:").append(paramIUploadSession.getUploadRoute().toString()).append(" ").toString() + this.mRouteStrategy.getUsedRoutesDescription();
    IManagerCallback localIManagerCallback = (IManagerCallback)this.mManagerCallback.get();
    boolean bool1 = paramBoolean;
    if (!paramBoolean)
    {
      boolean bool2 = UploadConfiguration.openSessionTest();
      if (!bool2) {
        paramBoolean = true;
      }
      bool1 = paramBoolean;
      if (bool2)
      {
        bool1 = paramBoolean;
        if (localIManagerCallback != null)
        {
          localIManagerCallback.onFailToOpen(this, paramIUploadSession.getUploadRoute(), str);
          bool1 = paramBoolean;
        }
      }
    }
    doNotifyError(paramIUploadSession, 31000, "all session establish failed:" + str, bool1);
    if ((this.mUploadActions.size() == 0) && (localIManagerCallback != null))
    {
      UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " onSetSessionNoDetection, actions is zero, onCloseCountdown:" + true);
      localIManagerCallback.onCloseCountdown(this, true);
    }
  }
  
  public boolean perpareAsync()
  {
    UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " perpareAsync");
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (!UploadConfiguration.isNetworkAvailable()) {
          return;
        }
        UploadSessionManager.this.doPerpare(true, 0);
      }
    });
  }
  
  public boolean switchRouteStrategy(final IUploadRouteStrategy paramIUploadRouteStrategy)
  {
    UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " switchRouteStrategy");
    synchronized (this.mLock)
    {
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          UploadSessionManager.this.doCloseSession();
          do
          {
            synchronized (UploadSessionManager.this.mLock)
            {
              UploadSessionManager.this.mRouteStrategy = paramIUploadRouteStrategy;
              UploadSessionManager.this.mLock.notify();
              if (UploadSessionManager.this.mUploadActions.size() == 0) {
                return;
              }
            }
          } while (!UploadConfiguration.isNetworkAvailable());
          UploadSessionManager.this.doPerpare(true, 0);
        }
      });
      try
      {
        this.mLock.wait();
        return true;
      }
      catch (InterruptedException paramIUploadRouteStrategy)
      {
        for (;;)
        {
          UploadLog.e("SessionManager", paramIUploadRouteStrategy.toString());
        }
      }
    }
  }
  
  public boolean uploadAsync(final IUploadAction paramIUploadAction)
  {
    if (paramIUploadAction == null)
    {
      UploadLog.d("SessionManager", this.mHashCode + " " + LogPrint.serverCategory(this.mRouteStrategy) + " uploadAsync: action null");
      return false;
    }
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        UploadSessionManager.this.doUpload(paramIUploadAction);
      }
    });
  }
  
  private static final class ActionWrapper
  {
    public IUploadSession detectedSession;
    public ArrayList<IUploadSession> detectionSessions = new ArrayList();
    public IUploadSession redirectSession;
  }
  
  public static abstract interface IManagerCallback
  {
    public abstract void onCloseCountdown(IUploadSessionManager paramIUploadSessionManager, boolean paramBoolean);
    
    public abstract void onFailToOpen(IUploadSessionManager paramIUploadSessionManager, UploadRoute paramUploadRoute, String paramString);
    
    public abstract void onOpen(IUploadSessionManager paramIUploadSessionManager, UploadRoute paramUploadRoute, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.network.UploadSessionManager
 * JD-Core Version:    0.7.0.1
 */