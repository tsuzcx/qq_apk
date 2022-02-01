package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vipav.VipFunCallObserver;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.qphone.base.util.QLog;

class MessengerService$2
  extends VipFunCallObserver
{
  MessengerService$2(MessengerService paramMessengerService) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    try
    {
      localObject = (QQAppInterface)MessengerService.access$000(this.this$0);
      VipSetFunCallHandler localVipSetFunCallHandler = (VipSetFunCallHandler)((QQAppInterface)localObject).a(48);
      ((QQAppInterface)localObject).c(this);
      i = ((Bundle)paramObject).getInt("ret");
      switch (paramInt)
      {
      case 1: 
        paramObject = new Bundle();
        if (!paramBoolean) {
          break label159;
        }
        paramObject.putInt("isSuccess", 0);
      }
    }
    catch (Exception paramObject)
    {
      Object localObject;
      int i;
      while (QLog.isColorLevel())
      {
        QLog.d("Q.emoji.web.MessengerService", 2, paramObject.getMessage());
        return;
        label159:
        paramObject.putInt("isSuccess", i);
      }
    }
    paramObject.putInt("srcType", 7);
    if (this.this$0.mClient != null)
    {
      localObject = Message.obtain(null, 5);
      ((Message)localObject).setData(paramObject);
      try
      {
        this.this$0.mClient.send((Message)localObject);
        return;
      }
      catch (RemoteException paramObject)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d("Q.emoji.web.MessengerService", 2, paramObject.getMessage());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.2
 * JD-Core Version:    0.7.0.1
 */