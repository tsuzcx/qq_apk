package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.io.Serializable;

class MessengerService$QWalletOpenMsgHandler
  extends Handler
{
  private MessengerService$QWalletOpenMsgHandler(MessengerService paramMessengerService) {}
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    int i = paramMessage.what;
    if ((i != 1) && (i != 2)) {
      return;
    }
    Bundle localBundle = new Bundle();
    if (i == 1)
    {
      localBundle.putString("cmd", "qwalletOpenOpenid");
      localBundle.putInt("openpay.type", i);
      if (paramMessage.arg1 != 1) {
        break label106;
      }
    }
    for (;;)
    {
      localBundle.putBoolean("openpay.isSuccess", bool);
      localBundle.putSerializable("openpay.data", (Serializable)paramMessage.obj);
      this.this$0.onRespToClient(localBundle);
      return;
      if (i != 2) {
        break;
      }
      localBundle.putString("cmd", "qwalletOpenToken");
      break;
      label106:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.QWalletOpenMsgHandler
 * JD-Core Version:    0.7.0.1
 */