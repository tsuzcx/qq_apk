package com.tencent.upload.network;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.upload.common.LogPrint;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadLog;
import com.tencent.upload.network.route.IUploadRouteStrategy;
import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.Utility.ServerCategory;
import com.tencent.upload.uinterface.Utility.TestServerCategory;
import java.lang.ref.WeakReference;

public final class UploadSessionService
  implements IUploadSessionService, UploadSessionManager.IManagerCallback
{
  private static final String TAG = "SessionService";
  private final SparseBooleanArray mCloseCountdownStateMap = new SparseBooleanArray();
  private final byte[] mLock = new byte[0];
  private Looper mLooper = null;
  private final SparseArray<IUploadSessionManager> mManagerMap = new SparseArray();
  private final WeakReference<ISessionServiceCallback> mSessionServiceCallback;
  
  public UploadSessionService(ISessionServiceCallback paramISessionServiceCallback)
  {
    this.mSessionServiceCallback = new WeakReference(paramISessionServiceCallback);
  }
  
  private IUploadSessionManager retrieveManager(int paramInt)
  {
    if (this.mLooper == null)
    {
      ??? = new HandlerThread("uploadCore");
      ((HandlerThread)???).start();
      this.mLooper = ((HandlerThread)???).getLooper();
    }
    ??? = (IUploadSessionManager)this.mManagerMap.get(paramInt);
    if (??? != null) {
      return ???;
    }
    int i = UploadConfiguration.getTestRouteServer();
    boolean bool = Utility.TestServerCategory.useTestServer(i);
    ??? = UploadConfiguration.createRouteStrategy(paramInt);
    if (bool) {
      ??? = UploadConfiguration.createTestRouteStrategy(paramInt, i);
    }
    if (??? == null) {
      return null;
    }
    UploadSessionManager localUploadSessionManager = new UploadSessionManager((IUploadRouteStrategy)???, this.mLooper, this);
    this.mManagerMap.put(paramInt, localUploadSessionManager);
    synchronized (this.mLock)
    {
      this.mCloseCountdownStateMap.append(paramInt, true);
      return localUploadSessionManager;
    }
  }
  
  public boolean cancel(int paramInt1, int paramInt2)
  {
    UploadLog.d("SessionService", hashCode() + " cancel: actionSequence:" + paramInt1 + " cancelState:" + paramInt2);
    int j = this.mManagerMap.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return true;
      }
      IUploadSessionManager localIUploadSessionManager = (IUploadSessionManager)this.mManagerMap.valueAt(i);
      if (localIUploadSessionManager != null) {
        localIUploadSessionManager.cancelAsync(paramInt1, paramInt2);
      }
      i += 1;
    }
  }
  
  public void cancelAll(int paramInt)
  {
    int j = this.mManagerMap.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      IUploadSessionManager localIUploadSessionManager = (IUploadSessionManager)this.mManagerMap.get(this.mManagerMap.keyAt(i));
      if (localIUploadSessionManager != null) {
        localIUploadSessionManager.cancelAll(paramInt);
      }
      i += 1;
    }
  }
  
  public void close()
  {
    UploadLog.d("SessionService", hashCode() + " close");
    for (;;)
    {
      if (this.mManagerMap.size() <= 0)
      {
        if (this.mLooper != null)
        {
          this.mLooper.quit();
          this.mLooper = null;
        }
        return;
      }
      IUploadSessionManager localIUploadSessionManager = (IUploadSessionManager)this.mManagerMap.valueAt(0);
      this.mManagerMap.delete(this.mManagerMap.keyAt(0));
      if (localIUploadSessionManager != null) {
        localIUploadSessionManager.close();
      }
    }
  }
  
  public void onCloseCountdown(IUploadSessionManager arg1, boolean paramBoolean)
  {
    int i = ???.getServerCategory();
    label150:
    label162:
    label163:
    label168:
    for (;;)
    {
      int j;
      int k;
      synchronized (this.mLock)
      {
        this.mCloseCountdownStateMap.put(i, paramBoolean);
        if (paramBoolean)
        {
          j = 1;
          k = this.mCloseCountdownStateMap.size();
          i = 0;
          break label150;
          if (i == 0)
          {
            return;
            if (this.mCloseCountdownStateMap.valueAt(i)) {
              break label163;
            }
            i = 0;
            continue;
          }
        }
        ISessionServiceCallback localISessionServiceCallback = (ISessionServiceCallback)this.mSessionServiceCallback.get();
        if (localISessionServiceCallback == null) {
          break label162;
        }
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(hashCode())).append(" callback onCloseCountdown:");
        if (paramBoolean)
        {
          ??? = "startCloseCountdown";
          UploadLog.d("SessionService", ???);
          localISessionServiceCallback.onSessionServiceStateChange(paramBoolean);
          return;
        }
      }
      ??? = "stopCloseCountdown";
      continue;
      for (;;)
      {
        if (i < k) {
          break label168;
        }
        i = j;
        break;
        return;
        i += 1;
      }
    }
  }
  
  public void onFailToOpen(IUploadSessionManager paramIUploadSessionManager, UploadRoute paramUploadRoute, String paramString)
  {
    int i = paramIUploadSessionManager.getServerCategory();
    paramIUploadSessionManager = (ISessionServiceCallback)this.mSessionServiceCallback.get();
    if (paramIUploadSessionManager == null) {
      return;
    }
    paramIUploadSessionManager.onFailToOpen(i, paramUploadRoute, "serverCategory:" + i + " " + paramString);
  }
  
  public void onOpen(IUploadSessionManager paramIUploadSessionManager, UploadRoute paramUploadRoute, String paramString)
  {
    int i = paramIUploadSessionManager.getServerCategory();
    paramIUploadSessionManager = (ISessionServiceCallback)this.mSessionServiceCallback.get();
    if (paramIUploadSessionManager == null) {
      return;
    }
    paramIUploadSessionManager.onOpen(i, paramUploadRoute, "serverCategory:" + i + " " + paramString);
  }
  
  public boolean perpare(int paramInt)
  {
    IUploadSessionManager localIUploadSessionManager = retrieveManager(paramInt);
    if (localIUploadSessionManager == null) {
      return false;
    }
    return localIUploadSessionManager.perpareAsync();
  }
  
  public boolean switchServer(int paramInt1, int paramInt2)
  {
    UploadLog.d("SessionService", hashCode() + " switchServer:" + Utility.ServerCategory.print(paramInt1) + " testServer:" + paramInt2);
    IUploadSessionManager localIUploadSessionManager = retrieveManager(paramInt1);
    if (localIUploadSessionManager == null) {}
    for (;;)
    {
      return false;
      if (Utility.TestServerCategory.useTestServer(paramInt2)) {}
      for (IUploadRouteStrategy localIUploadRouteStrategy = UploadConfiguration.createTestRouteStrategy(paramInt1, paramInt2); localIUploadRouteStrategy != null; localIUploadRouteStrategy = UploadConfiguration.createRouteStrategy(paramInt1)) {
        return localIUploadSessionManager.switchRouteStrategy(localIUploadRouteStrategy);
      }
    }
  }
  
  public boolean upload(IUploadAction paramIUploadAction)
  {
    if (paramIUploadAction == null) {}
    IUploadSessionManager localIUploadSessionManager;
    do
    {
      return false;
      int i = paramIUploadAction.getServerCategory();
      localIUploadSessionManager = retrieveManager(i);
      UploadLog.d("SessionService", hashCode() + " upload: " + LogPrint.getSimpleName(paramIUploadAction) + " actSeq:" + LogPrint.actionSequence(paramIUploadAction) + " " + Utility.ServerCategory.print(i));
    } while (localIUploadSessionManager == null);
    return localIUploadSessionManager.uploadAsync(paramIUploadAction);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.network.UploadSessionService
 * JD-Core Version:    0.7.0.1
 */