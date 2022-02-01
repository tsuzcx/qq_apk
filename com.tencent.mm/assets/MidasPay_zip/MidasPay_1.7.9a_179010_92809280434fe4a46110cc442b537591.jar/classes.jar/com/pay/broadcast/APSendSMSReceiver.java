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
    if ((i != -1) && (i != 1) && (i != 2) && (i != 3)) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.broadcast.APSendSMSReceiver
 * JD-Core Version:    0.7.0.1
 */