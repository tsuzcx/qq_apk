package com.pay.paychannel.hfpay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.pay.ui.channel.APHFSmsVercodeActivity;
import midas.x.dt;

public class APHFRequest
  extends APHFChannel
{
  public void b(Context paramContext, dt paramdt)
  {
    paramdt = new Bundle();
    paramdt.putString("show", "verCodeUI");
    paramdt.putString("phoneNumber", APHFChannel.l);
    paramdt.putString("hfPrice", APHFChannel.p);
    paramdt.putString("hfFeeType", APHFChannel.w);
    paramdt.putString("hfWarmTips", APHFChannel.x);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramdt);
    localIntent.setClass(paramContext, APHFSmsVercodeActivity.class);
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.hfpay.APHFRequest
 * JD-Core Version:    0.7.0.1
 */