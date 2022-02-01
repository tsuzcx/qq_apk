package com.pay.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class APSendSMSReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = getResultCode();
    if (i != -1) {
      switch (i)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.broadcast.APSendSMSReceiver
 * JD-Core Version:    0.7.0.1
 */