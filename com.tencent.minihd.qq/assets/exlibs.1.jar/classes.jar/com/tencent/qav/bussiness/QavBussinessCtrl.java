package com.tencent.qav.bussiness;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.common.app.AppInterface;
import com.tencent.qav.QavSDK;
import com.tencent.qav.activity.Qav3rdInviteActivity;
import com.tencent.qav.activity.QavInviteActivity;
import com.tencent.qav.controller.c2c.IC2COperator;
import com.tencent.qav.ipc.QavCallbackObserver;
import com.tencent.qav.ipc.QavCallbackWrapper;
import com.tencent.qav.ipc.QavMsgRecord;
import com.tencent.qav.ipc.QavState;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.monitor.PhoneStatusMonitor;
import com.tencent.qav.monitor.PhoneStatusMonitor.PhoneStatusListener;
import com.tencent.qav.notification.QavNotification;
import com.tencent.qav.observer.ObserverDispatcher;
import com.tencent.qav.session.QavSession;
import com.tencent.qav.session.QavSession.SessionStatus;
import com.tencent.qav.session.QavSessionManager;
import com.tencent.qav.thread.ThreadManager;
import liw;
import lix;
import liy;
import liz;

public class QavBussinessCtrl
  extends BaseBussinessCtrl
  implements PhoneStatusMonitor.PhoneStatusListener
{
  private static QavBussinessCtrl jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl = new QavBussinessCtrl();
  private static final String jdField_a_of_type_JavaLangString = "QavBussinessCtrl";
  private static final long jdField_b_of_type_Long = 1000L;
  int jdField_a_of_type_Int = 0;
  private MediaPlayer.OnCompletionListener jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = new liw(this);
  private IC2COperator jdField_a_of_type_ComTencentQavControllerC2cIC2COperator = QavSDK.getInstance().getC2COperator();
  private QavCallbackObserver jdField_a_of_type_ComTencentQavIpcQavCallbackObserver;
  private QavCallbackWrapper jdField_a_of_type_ComTencentQavIpcQavCallbackWrapper = new QavCallbackWrapper();
  private PhoneStatusMonitor jdField_a_of_type_ComTencentQavMonitorPhoneStatusMonitor = new PhoneStatusMonitor(this.jdField_a_of_type_AndroidContentContext, this);
  private QavNotification jdField_a_of_type_ComTencentQavNotificationQavNotification = new QavNotification(this.jdField_a_of_type_AndroidContentContext);
  private QavSessionManager jdField_a_of_type_ComTencentQavSessionQavSessionManager = new QavSessionManager();
  private Runnable jdField_a_of_type_JavaLangRunnable;
  boolean jdField_a_of_type_Boolean = false;
  private MediaPlayer.OnCompletionListener jdField_b_of_type_AndroidMediaMediaPlayer$OnCompletionListener;
  private long c;
  
  private QavBussinessCtrl()
  {
    this.b = new lix(this);
    f();
  }
  
  private int a(int paramInt, long paramLong)
  {
    int k = 64;
    int m = 5;
    int j = m;
    int i = k;
    switch (paramInt)
    {
    default: 
      j = m;
    case 6: 
    case 7: 
    case 13: 
    case 16: 
    case 17: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
      i = j;
    case 21: 
    case 0: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          return i;
          return 0;
          j = 2;
          if (paramLong == 9L) {
            return 43;
          }
          if (paramLong == 10L) {
            return 54;
          }
          if (paramLong == 5L) {
            return 49;
          }
          if ((paramLong == 12L) || (paramLong == 16L)) {
            return 52;
          }
          if (paramLong == 13L) {
            return 50;
          }
          if (paramLong == 14L) {
            return 51;
          }
          if (paramLong == 15L) {
            return 55;
          }
          if (paramLong == 17L) {
            return 56;
          }
          i = k;
        } while (paramLong == 6L);
        if (paramLong == 7L) {
          return 24;
        }
        if (paramLong != 983055L) {
          break;
        }
        return 63;
        i = 3;
      } while ((paramLong != 3L) && (paramLong != 65535L));
      return 42;
    case 14: 
      return 5;
    case 5: 
      return 25;
    case 12: 
      return 9;
    case 3: 
      return 1;
    case 4: 
      return 4;
    case 18: 
      return 10;
    case 10: 
      return 28;
    case 11: 
      return 29;
    case 19: 
      return 39;
    case 15: 
      return 35;
    case 8: 
    case 9: 
      return 12;
    case 20: 
      return 21;
    }
    return 62;
  }
  
  private long a(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return l;
    }
    catch (Exception paramString)
    {
      AVLog.e("QavBussinessCtrl", "parseStringToLong fail.", paramString);
    }
    return 0L;
  }
  
  public static QavBussinessCtrl a()
  {
    if (jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl == null) {
        jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl = new QavBussinessCtrl();
      }
      return jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl;
    }
    finally {}
  }
  
  private void a(QavSession paramQavSession)
  {
    AVLog.d("QavBussinessCtrl", String.format("notifyStartVideoChat sessionId=%s sessionState=%s", new Object[] { paramQavSession.jdField_a_of_type_JavaLangString, paramQavSession.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus }));
    paramQavSession = new QavState(paramQavSession);
    this.jdField_a_of_type_ComTencentQavIpcQavCallbackWrapper.a(paramQavSession);
  }
  
  private void a(QavSession paramQavSession, int paramInt)
  {
    boolean bool3 = true;
    AVLog.d("QavBussinessCtrl", String.format("sendC2CVideoMsgRecord sessionId=%s, msgType=%s, sessionType=%s ", new Object[] { paramQavSession.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt), Integer.valueOf(paramQavSession.jdField_a_of_type_Int) }));
    boolean bool2;
    label73:
    QavMsgRecord localQavMsgRecord;
    if (paramQavSession.jdField_a_of_type_Int == 2)
    {
      bool1 = true;
      if (((!paramQavSession.b()) || (paramInt != 1)) && (!paramQavSession.d())) {
        break label165;
      }
      bool2 = true;
      localQavMsgRecord = new QavMsgRecord();
      localQavMsgRecord.jdField_a_of_type_Int = paramInt;
      localQavMsgRecord.jdField_a_of_type_Boolean = bool1;
      localQavMsgRecord.jdField_b_of_type_Boolean = bool2;
      if (paramQavSession.jdField_b_of_type_Boolean) {
        break label171;
      }
    }
    label165:
    label171:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      localQavMsgRecord.jdField_c_of_type_Boolean = bool1;
      localQavMsgRecord.jdField_a_of_type_Long = paramQavSession.jdField_b_of_type_Long;
      localQavMsgRecord.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
      localQavMsgRecord.jdField_b_of_type_JavaLangString = String.valueOf(paramQavSession.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentQavIpcQavCallbackWrapper.a(localQavMsgRecord);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label73;
    }
  }
  
  private void b()
  {
    int i = 47;
    QavSession localQavSession = a();
    if ((localQavSession != null) && ((localQavSession.jdField_a_of_type_Int == 1) || (localQavSession.jdField_a_of_type_Int == 2)))
    {
      if (!localQavSession.jdField_b_of_type_Boolean) {
        break label168;
      }
      if (!localQavSession.b()) {
        break label154;
      }
      if (!localQavSession.jdField_c_of_type_Boolean) {
        break label148;
      }
      i = 45;
    }
    for (;;)
    {
      String str = this.jdField_a_of_type_ComTencentQavIpcQavCallbackWrapper.a(0, String.valueOf(localQavSession.jdField_a_of_type_Long));
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentQavIpcQavCallbackWrapper.a(0, String.valueOf(localQavSession.jdField_a_of_type_Long));
      AVLog.d("QavBussinessCtrl", String.format("updateNotification sessionId=%s sessionStatus=%s type=%s displayName=%s", new Object[] { localQavSession.jdField_a_of_type_JavaLangString, localQavSession.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus, Integer.valueOf(i), str }));
      this.jdField_a_of_type_ComTencentQavNotificationQavNotification.a(localQavSession, i, str, localBitmap);
      if (localQavSession.d()) {
        d();
      }
      return;
      label148:
      i = 40;
      continue;
      label154:
      if (localQavSession.jdField_a_of_type_Int != 1)
      {
        i = 42;
        continue;
        label168:
        if (localQavSession.d())
        {
          if (localQavSession.jdField_a_of_type_Int != 1) {
            i = 42;
          }
        }
        else if (localQavSession.jdField_a_of_type_Int == 1) {
          i = 46;
        } else {
          i = 41;
        }
      }
    }
  }
  
  private void b(QavSession paramQavSession)
  {
    paramQavSession = new QavState(paramQavSession);
    this.jdField_a_of_type_ComTencentQavIpcQavCallbackWrapper.b(paramQavSession);
  }
  
  private void c()
  {
    AVLog.d("QavBussinessCtrl", "cancelNotification");
    this.jdField_a_of_type_ComTencentQavNotificationQavNotification.a();
  }
  
  private void c(QavSession paramQavSession)
  {
    AVLog.d("QavBussinessCtrl", String.format("notifyStopVideoChat sessionId=%s sessionState=%s", new Object[] { paramQavSession.jdField_a_of_type_JavaLangString, paramQavSession.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus }));
    paramQavSession = new QavState(paramQavSession);
    this.jdField_a_of_type_ComTencentQavIpcQavCallbackWrapper.c(paramQavSession);
  }
  
  private void c(String paramString, int paramInt)
  {
    int j = 2131165192;
    boolean bool1 = false;
    AVLog.d("QavBussinessCtrl", String.format("doCloseVideo peerUin=%s msgType=%s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    Object localObject = QavSession.a(3, Long.valueOf(paramString).longValue());
    localObject = this.jdField_a_of_type_ComTencentQavSessionQavSessionManager.a((String)localObject);
    int i;
    if ((localObject != null) && (!((QavSession)localObject).e()) && (!((QavSession)localObject).f()))
    {
      boolean bool2 = ((QavSession)localObject).jdField_a_of_type_Boolean;
      i = this.jdField_a_of_type_ComTencentQavSessionQavSessionManager.a();
      if ((!bool2) || (i != 1)) {
        break label296;
      }
      if (((QavSession)localObject).b()) {
        i = 0;
      }
    }
    for (;;)
    {
      RingtoneHelper.a();
      RingtoneHelper.a(this.jdField_a_of_type_AndroidContentContext);
      e();
      ((QavSession)localObject).jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus = QavSession.SessionStatus.CLOSING;
      ((QavSession)localObject).jdField_e_of_type_Int = paramInt;
      e(paramString, paramInt);
      if (i != 0) {
        if (i != 2131165194) {
          break label249;
        }
      }
      label249:
      for (localObject = this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener;; localObject = this.b)
      {
        bool1 = RingtoneHelper.a(this.jdField_a_of_type_AndroidContentContext, i, 1, (MediaPlayer.OnCompletionListener)localObject);
        if (!bool1) {
          d(paramString, paramInt);
        }
        return;
        i = j;
        if (!((QavSession)localObject).a()) {
          break;
        }
        switch (paramInt)
        {
        default: 
          i = j;
          break;
        case 3: 
        case 42: 
        case 43: 
          i = 2131165194;
          break;
        }
      }
      if (localObject == null)
      {
        AVLog.w("QavBussinessCtrl", "doCloseVideo session is null");
        return;
      }
      AVLog.w("QavBussinessCtrl", String.format("doCloseVideo session has closed. sessionStatus=%s", new Object[] { ((QavSession)localObject).jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus }));
      return;
      label296:
      i = 0;
    }
  }
  
  private boolean c()
  {
    KeyguardManager localKeyguardManager = (KeyguardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("keyguard");
    if (localKeyguardManager != null) {
      return localKeyguardManager.inKeyguardRestrictedInputMode();
    }
    return false;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new liy(this);
    }
    if (this.c == 0L)
    {
      this.c = System.currentTimeMillis();
      ThreadManager.executeOnSubThreadDelay(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  private void d(String paramString, int paramInt)
  {
    AVLog.d("QavBussinessCtrl", String.format("closeSession peerUin=%s msgType=%s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    String str = QavSession.a(3, Long.valueOf(paramString).longValue());
    QavSession localQavSession = this.jdField_a_of_type_ComTencentQavSessionQavSessionManager.a(str);
    if (localQavSession != null)
    {
      a(localQavSession, paramInt);
      boolean bool = localQavSession.jdField_a_of_type_Boolean;
      localQavSession.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus = QavSession.SessionStatus.CLOSED;
      this.jdField_a_of_type_ComTencentQavSessionQavSessionManager.b(str);
      if (bool)
      {
        c(localQavSession);
        c();
      }
      f(paramString, paramInt);
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_JavaLangRunnable != null) && (this.c != 0L))
    {
      ThreadManager.removeSubThreadCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.c = 0L;
    }
  }
  
  private void e(String paramString, int paramInt)
  {
    AVLog.d("QavBussinessCtrl", String.format("notifyVideoClosed peerUin=%s msgType=%s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    ObserverDispatcher.instance().notifyObservers(QavBussinessObserver.class, 27, new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentQavIpcQavCallbackObserver == null) {
      this.jdField_a_of_type_ComTencentQavIpcQavCallbackObserver = new liz(this);
    }
    QavSDK.getInstance().addObserver(this.jdField_a_of_type_ComTencentQavIpcQavCallbackObserver);
  }
  
  private void f(String paramString, int paramInt)
  {
    AVLog.d("QavBussinessCtrl", String.format("notifySessionClosed peerUin=%s msgType=%s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    ObserverDispatcher.instance().notifyObservers(QavBussinessObserver.class, 28, new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentQavIpcQavCallbackObserver != null)
    {
      QavSDK.getInstance().removeObserver(this.jdField_a_of_type_ComTencentQavIpcQavCallbackObserver);
      this.jdField_a_of_type_ComTencentQavIpcQavCallbackObserver = null;
    }
  }
  
  private void h()
  {
    AudioManager localAudioManager = (AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio");
    if (localAudioManager != null) {
      localAudioManager.requestAudioFocus(null, 3, 1);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentQavControllerC2cIC2COperator.getAudioRoute();
  }
  
  public QavCallbackWrapper a()
  {
    return this.jdField_a_of_type_ComTencentQavIpcQavCallbackWrapper;
  }
  
  public QavSession a()
  {
    return this.jdField_a_of_type_ComTencentQavSessionQavSessionManager.a();
  }
  
  public QavSession a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentQavSessionQavSessionManager.a(paramString);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentQavMonitorPhoneStatusMonitor != null)
    {
      this.jdField_a_of_type_ComTencentQavMonitorPhoneStatusMonitor.a();
      this.jdField_a_of_type_ComTencentQavMonitorPhoneStatusMonitor = null;
    }
    g();
    jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl = null;
  }
  
  public void a(int paramInt)
  {
    boolean bool = true;
    AVLog.d("QavBussinessCtrl", String.format("setAudioRoute route=%s", new Object[] { Integer.valueOf(paramInt) }));
    this.jdField_a_of_type_ComTencentQavControllerC2cIC2COperator.setAudioRoute(paramInt);
    QavSession localQavSession = this.jdField_a_of_type_ComTencentQavSessionQavSessionManager.a();
    if (localQavSession != null) {
      if (paramInt != 1) {
        break label57;
      }
    }
    for (;;)
    {
      localQavSession.jdField_d_of_type_Boolean = bool;
      return;
      label57:
      bool = false;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    AVLog.d("QavBussinessCtrl", String.format("rejectC2CCall peerUin=%s rejectReason=%s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    if (a(paramString) == 0L)
    {
      AVLog.e("QavBussinessCtrl", "rejectC2CCall invalid args.");
      return;
    }
    this.jdField_a_of_type_ComTencentQavControllerC2cIC2COperator.rejectCall(paramString, paramInt);
    c(paramString, 1);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    int i = 2;
    AVLog.e("QavBussinessCtrl", String.format("startC2CCall peerUin=%s isOnlyAudio=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    long l = a(paramString);
    if (l == 0L)
    {
      AVLog.e("QavBussinessCtrl", "startC2CCall invalid args.");
      return;
    }
    Object localObject = QavSession.a(3, l);
    QavSession localQavSession = a();
    if (localQavSession != null)
    {
      AVLog.w("QavBussinessCtrl", String.format("startC2CCall there is a call already exist. oldSessionId=%s newSessionId=%s", new Object[] { localQavSession.jdField_a_of_type_JavaLangString, localObject }));
      return;
    }
    if (paramBoolean) {
      i = 1;
    }
    localObject = this.jdField_a_of_type_ComTencentQavSessionQavSessionManager.a(i, (String)localObject, true);
    ((QavSession)localObject).jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus = QavSession.SessionStatus.INVITING;
    ((QavSession)localObject).jdField_c_of_type_Int = 3;
    ((QavSession)localObject).jdField_a_of_type_Long = l;
    ((QavSession)localObject).jdField_b_of_type_Boolean = false;
    ((QavSession)localObject).jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentQavControllerC2cIC2COperator.startCall(paramString, paramBoolean);
    a((QavSession)localObject);
    b();
    h();
    b(((QavSession)localObject).jdField_d_of_type_Int);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentQavControllerC2cIC2COperator.enableLocalAudio(paramBoolean);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentQavMonitorPhoneStatusMonitor != null) {
      return this.jdField_a_of_type_ComTencentQavMonitorPhoneStatusMonitor.a();
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentQavControllerC2cIC2COperator.setBeautyLevel(paramInt);
    QavSession localQavSession = this.jdField_a_of_type_ComTencentQavSessionQavSessionManager.a();
    if (localQavSession != null) {
      localQavSession.jdField_d_of_type_Int = paramInt;
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    AVLog.d("QavBussinessCtrl", String.format("closeC2CCall peerUin=%s closeReason=%s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    if (a(paramString) == 0L)
    {
      AVLog.e("QavBussinessCtrl", "closeC2CCall invalid args.");
      return;
    }
    this.jdField_a_of_type_ComTencentQavControllerC2cIC2COperator.closeCall(paramString, paramInt);
    c(paramString, 0);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    AVLog.d("QavBussinessCtrl", String.format("acceptC2CCall peerUin=%s isOnlyAudio=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    long l = a(paramString);
    if (l == 0L) {
      AVLog.e("QavBussinessCtrl", "acceptC2CCall invalid args.");
    }
    String str;
    QavSession localQavSession;
    do
    {
      return;
      str = QavSession.a(3, l);
      localQavSession = this.jdField_a_of_type_ComTencentQavSessionQavSessionManager.a(str);
    } while (localQavSession == null);
    if (localQavSession.jdField_a_of_type_Int == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.jdField_a_of_type_ComTencentQavControllerC2cIC2COperator.acceptCall(paramString, paramBoolean);
      localQavSession.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus = QavSession.SessionStatus.CONNECTING;
      this.jdField_a_of_type_ComTencentQavSessionQavSessionManager.a(str);
      b();
      b(localQavSession.jdField_d_of_type_Int);
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentQavControllerC2cIC2COperator.enableRemoteAudio(paramBoolean);
    QavSession localQavSession = this.jdField_a_of_type_ComTencentQavSessionQavSessionManager.a();
    if (localQavSession != null) {
      if (paramBoolean) {
        break label34;
      }
    }
    label34:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localQavSession.jdField_e_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    ObserverDispatcher.instance().notifyObservers(QavBussinessObserver.class, 31, new Object[] { paramString, Boolean.valueOf(paramBoolean) });
  }
  
  public void c(boolean paramBoolean)
  {
    AVLog.d("QavBussinessCtrl", String.format("onCallStateChanged isCalling=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    QavSession localQavSession;
    String str;
    if (paramBoolean)
    {
      localQavSession = a();
      if (localQavSession != null) {
        str = String.valueOf(localQavSession.jdField_a_of_type_Long);
      }
    }
    switch (lja.a[localQavSession.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus.ordinal()])
    {
    default: 
      return;
    case 1: 
      b(str, 0);
      return;
    case 2: 
      a(str, 65535);
      return;
    }
    b(str, 65535);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onAcceptedVideo(String paramString)
  {
    paramString = QavSession.a(3, Long.valueOf(paramString).longValue());
    this.jdField_a_of_type_ComTencentQavSessionQavSessionManager.a(paramString).jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus = QavSession.SessionStatus.CONNECTING;
    b();
  }
  
  public void onAnotherHaveAccept(String paramString)
  {
    c(paramString, 7);
  }
  
  public void onAnotherHaveReject(String paramString)
  {
    c(paramString, 7);
  }
  
  public void onChannelReady(String paramString)
  {
    Object localObject = QavSession.a(3, Long.valueOf(paramString).longValue());
    localObject = this.jdField_a_of_type_ComTencentQavSessionQavSessionManager.a((String)localObject);
    if (localObject != null)
    {
      ((QavSession)localObject).jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus = QavSession.SessionStatus.CONNECTED;
      a((QavSession)localObject);
      b();
    }
    ObserverDispatcher.instance().notifyObservers(QavBussinessObserver.class, 21, new Object[] { paramString });
    RingtoneHelper.a();
    RingtoneHelper.a(this.jdField_a_of_type_AndroidContentContext);
    RingtoneHelper.a(this.jdField_a_of_type_AndroidContentContext, true);
  }
  
  public void onCloseVideo(String paramString, int paramInt, long paramLong)
  {
    AVLog.d("QavBussinessCtrl", String.format("onCloseVideo fromUin=%s reason=%s extraParam=%s", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
    c(paramString, a(paramInt, paramLong));
  }
  
  public void onInviteReached(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    AVLog.d("QavBussinessCtrl", String.format("onInviteReached fromUin=%s friendState=0x%X extraParam=%s", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
    paramArrayOfByte = a();
    if ((paramArrayOfByte != null) && (paramArrayOfByte.jdField_f_of_type_Int == -1))
    {
      paramArrayOfByte.jdField_f_of_type_Int = 0;
      if ((0x10000 & paramInt) <= 0) {
        break label204;
      }
      paramArrayOfByte.i = true;
      if (((0x100000 & paramInt) <= 0) || ((0x40000 & paramInt) <= 0)) {
        break label152;
      }
      if ((0xFFFF & paramInt & 0x1) > 0) {
        paramArrayOfByte.jdField_f_of_type_Int = 1;
      }
      RingtoneHelper.a(this.jdField_a_of_type_AndroidContentContext, 2131165195, -1, null);
    }
    for (;;)
    {
      ObserverDispatcher.instance().notifyObservers(QavBussinessObserver.class, 1, new Object[] { paramString });
      if (!paramArrayOfByte.i) {
        b(paramString, 12);
      }
      return;
      label152:
      paramInt = 0xFFFF & paramInt;
      if ((paramInt & 0x2) > 0)
      {
        paramArrayOfByte.jdField_f_of_type_Int = 2;
        break;
      }
      if ((paramInt & 0x4) > 0)
      {
        paramArrayOfByte.jdField_f_of_type_Int = 3;
        break;
      }
      if ((paramInt & 0x8) <= 0) {
        break;
      }
      paramArrayOfByte.jdField_f_of_type_Int = 4;
      break;
      label204:
      paramArrayOfByte.i = false;
    }
  }
  
  public void onPauseAudio(String paramString)
  {
    QavSession localQavSession = a();
    if (localQavSession != null) {
      localQavSession.g = true;
    }
    ObserverDispatcher.instance().notifyObservers(QavBussinessObserver.class, 26, new Object[] { paramString });
  }
  
  public void onPauseVideo(String paramString)
  {
    QavSession localQavSession = a();
    boolean bool;
    if ((localQavSession != null) && (localQavSession.h))
    {
      localQavSession.h = false;
      if (localQavSession.jdField_f_of_type_Boolean) {
        break label77;
      }
      bool = true;
      localQavSession.jdField_c_of_type_Boolean = bool;
      if (!localQavSession.jdField_c_of_type_Boolean) {
        break label82;
      }
    }
    label77:
    label82:
    for (int i = 1;; i = 2)
    {
      localQavSession.jdField_a_of_type_Int = i;
      ObserverDispatcher.instance().notifyObservers(QavBussinessObserver.class, 24, new Object[] { paramString });
      return;
      bool = false;
      break;
    }
  }
  
  public void onReceiveFirstVideoFrame(String paramString)
  {
    QavSession localQavSession = a();
    if ((localQavSession != null) && (!localQavSession.h))
    {
      localQavSession.h = true;
      localQavSession.jdField_c_of_type_Boolean = false;
      localQavSession.jdField_a_of_type_Int = 2;
      ObserverDispatcher.instance().notifyObservers(QavBussinessObserver.class, 22, new Object[] { paramString });
    }
  }
  
  public void onRequestVideo(int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean, String paramString3, int paramInt2, int paramInt3)
  {
    paramInt2 = this.jdField_a_of_type_ComTencentQavSessionQavSessionManager.a();
    boolean bool2;
    long l;
    if (a() != null)
    {
      bool1 = true;
      bool2 = c();
      AVLog.d("QavBussinessCtrl", String.format("onRequestVideo sessionCount=%s sessionExist=%s isScreenLocked=%s", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      l = Long.valueOf(paramString1).longValue();
      if (!paramBoolean) {
        break label235;
      }
      paramInt1 = 1;
      label80:
      paramString2 = QavSession.a(3, l);
      paramArrayOfByte = this.jdField_a_of_type_ComTencentQavSessionQavSessionManager.a(paramString2);
      if (paramArrayOfByte != null)
      {
        if ((!paramArrayOfByte.e()) && (!paramArrayOfByte.f())) {
          break label246;
        }
        RingtoneHelper.a();
        d(paramString1, paramArrayOfByte.jdField_e_of_type_Int);
        paramInt2 = this.jdField_a_of_type_ComTencentQavSessionQavSessionManager.a();
        if (a() == null) {
          break label240;
        }
      }
    }
    label235:
    label240:
    for (boolean bool1 = true;; bool1 = false)
    {
      AVLog.w("QavBussinessCtrl", "onRequestVideo session has closed");
      paramString2 = this.jdField_a_of_type_ComTencentQavSessionQavSessionManager.a(paramInt1, paramString2, false);
      paramString2.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus = QavSession.SessionStatus.BE_INVITING;
      paramString2.jdField_c_of_type_Int = 3;
      paramString2.jdField_a_of_type_Long = l;
      paramString2.jdField_b_of_type_Boolean = true;
      paramString2.jdField_c_of_type_Boolean = paramBoolean;
      if ((paramInt2 < 2) && ((!bool1) || (!bool2))) {
        break label255;
      }
      a(String.valueOf(paramString2.jdField_a_of_type_Long), 65536);
      return;
      bool1 = false;
      break;
      paramInt1 = 2;
      break label80;
    }
    label246:
    AVLog.w("QavBussinessCtrl", "onRequestVideo session has exist");
    return;
    label255:
    if (bool1)
    {
      paramString2 = new Intent(this.jdField_a_of_type_AndroidContentContext, Qav3rdInviteActivity.class);
      paramString2.addFlags(268435456);
      paramString2.putExtra("key_peer_uin", paramString1);
      paramString2.putExtra("key_only_audio", paramBoolean);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramString2);
      AVLog.d("QavBussinessCtrl", "onRequestVideo start Qav3rdInviteActivity");
      return;
    }
    paramArrayOfByte = new Intent(this.jdField_a_of_type_AndroidContentContext, QavInviteActivity.class);
    paramArrayOfByte.addFlags(268435456);
    paramArrayOfByte.putExtra("key_peer_uin", paramString1);
    paramArrayOfByte.putExtra("key_only_audio", paramBoolean);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramArrayOfByte);
    AVLog.d("QavBussinessCtrl", "onRequestVideo start QavInviteActivity");
    a(paramString2);
    b();
    h();
    RingtoneHelper.a(this.jdField_a_of_type_AndroidContentContext, 2131165193, -1, null);
    RingtoneHelper.a(this.jdField_a_of_type_AndroidContentContext, false);
  }
  
  public void onResumeAudio(String paramString)
  {
    QavSession localQavSession = a();
    if (localQavSession != null) {
      localQavSession.g = false;
    }
    ObserverDispatcher.instance().notifyObservers(QavBussinessObserver.class, 25, new Object[] { paramString });
  }
  
  public void onResumeVideo(String paramString) {}
  
  public void onUpdateNetLevel(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    ObserverDispatcher.instance().notifyObservers(QavBussinessObserver.class, 29, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.bussiness.QavBussinessCtrl
 * JD-Core Version:    0.7.0.1
 */