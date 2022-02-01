package com.tencent.mobileqq.emosm.web;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletOpenObserver;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.profile.VipProfileCardPhotoHandlerActivity;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.mobileqq.vipav.VipFunCallObserver;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.AppService;

public class MessengerService
  extends AppService
  implements IPCConstants
{
  public static final String tag = "Q.emoji.web.MessengerService";
  private CardObserver cardObserver = new MessengerService.4(this);
  protected VipFunCallObserver fcObserver = new MessengerService.2(this);
  Messenger mClient = null;
  public EmoticonPackageDownloadListener mListener = new MessengerService.1(this);
  final Messenger mMessenger = new Messenger(new MessengerService.IncomingHandler(this));
  Bundle mOnCardDownloadBundle = null;
  private MessengerService.QWalletOpenMsgHandler mOpenMsgHandler = new MessengerService.QWalletOpenMsgHandler(this, null);
  private QWalletOpenObserver mOpenObserver = new QWalletOpenObserver(this.mOpenMsgHandler);
  private VipSpecialCareHandler mSpecialCareHandler = new MessengerService.6(this);
  DownloadListener mThemeDownloadListener = new MessengerService.5(this, "param_WIFIThemeDownloadFlow", "param_XGThemeDownloadFlow");
  IPCDownloadListener mVipIPCDownloadListener = new MessengerService.3(this);
  private Bundle rsqBundle = null;
  
  private void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.web.MessengerService", 2, paramString);
    }
  }
  
  private void startProfileCardPhotoHandler(String paramString)
  {
    Intent localIntent;
    if (!TextUtils.isEmpty(paramString))
    {
      localIntent = new Intent(this, VipProfileCardPhotoHandlerActivity.class);
      localIntent.setFlags(268435456);
      if (!paramString.equals("selectPhoto")) {
        break label49;
      }
      localIntent.putExtra("action", "select_photo");
    }
    for (;;)
    {
      startActivity(localIntent);
      return;
      label49:
      if (paramString.equals("takePhoto")) {
        localIntent.putExtra("action", "take_photo");
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService onBind");
    }
    return this.mMessenger.getBinder();
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService oncreate");
    }
    try
    {
      super.onCreate();
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        ((QQAppInterface)this.app).a(this.mSpecialCareHandler);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("Q.emoji.web.MessengerService", 1, "onCreate error! " + QLog.getStackTraceString(localThrowable));
      return;
    }
    if (this.app == null)
    {
      log("-->app is null");
      return;
    }
    log("-->app is not qqappinterface");
  }
  
  public void onDestroy()
  {
    this.mClient = null;
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService destroied");
    }
    if ((this.app != null) && ((this.app instanceof QQAppInterface)))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.app;
      EmojiManager localEmojiManager = (EmojiManager)this.app.getManager(42);
      if (localEmojiManager != null) {
        localEmojiManager.a.b(this.mListener);
      }
      if (this.mOpenObserver != null)
      {
        this.mOpenObserver.a();
        localQQAppInterface.c(this.mOpenObserver);
        this.mOpenObserver = null;
      }
      this.mOpenMsgHandler = null;
      if (this.cardObserver != null)
      {
        localQQAppInterface.c(this.cardObserver);
        this.cardObserver = null;
      }
      ((QQAppInterface)this.app).c(this.mSpecialCareHandler);
      this.mSpecialCareHandler.destroy();
    }
    this.app = null;
  }
  
  void onRespToClient(Bundle paramBundle)
  {
    if (this.mClient != null) {}
    try
    {
      Message localMessage = Message.obtain(null, 4);
      localMessage.setData(paramBundle);
      this.mClient.send(localMessage);
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.MessengerService", 2, "resp to sever: ");
      }
      return;
    }
    catch (RemoteException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService
 * JD-Core Version:    0.7.0.1
 */