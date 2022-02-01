package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.QLog;

class MessengerService$3
  extends IPCDownloadListener
{
  MessengerService$3(MessengerService paramMessengerService) {}
  
  public void onDone(long paramLong, int paramInt, Bundle paramBundle)
  {
    if (this.this$0.mClient != null) {}
    try
    {
      Message localMessage = Message.obtain(null, 5);
      paramBundle.putInt("id", (int)paramLong);
      paramBundle.putInt("result", paramInt);
      localMessage.setData(paramBundle);
      this.this$0.mClient.send(localMessage);
      return;
    }
    catch (Exception paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.emoji.web.MessengerService", 2, paramBundle.getMessage());
    }
  }
  
  public void onResponse(Bundle paramBundle)
  {
    Message localMessage;
    if (this.this$0.mClient != null)
    {
      localMessage = Message.obtain(null, 5);
      localMessage.setData(paramBundle);
    }
    try
    {
      this.this$0.mClient.send(localMessage);
      return;
    }
    catch (RemoteException paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.emoji.web.MessengerService", 2, paramBundle.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.3
 * JD-Core Version:    0.7.0.1
 */