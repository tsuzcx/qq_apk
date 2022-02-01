package com.tencent.mobileqq.emosm;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.qphone.base.util.QLog;

class Client$1
  implements ServiceConnection
{
  Client$1(Client paramClient) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      this.this$0.mIsBound = true;
      this.this$0.mService = new Messenger(paramIBinder);
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.Client", 2, "ServiceConnection Attached.");
      }
      WebIPCOperator.getInstance().onBindSuc();
      paramComponentName = Message.obtain(null, 1);
      paramComponentName.replyTo = this.this$0.mMessenger;
      this.this$0.mService.send(paramComponentName);
      return;
    }
    catch (Exception paramComponentName)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.emoji.web.Client", 2, paramComponentName.getMessage());
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.this$0.mService = null;
    this.this$0.onDisconnectWithService();
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.Client", 2, "Disconnected.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.Client.1
 * JD-Core Version:    0.7.0.1
 */