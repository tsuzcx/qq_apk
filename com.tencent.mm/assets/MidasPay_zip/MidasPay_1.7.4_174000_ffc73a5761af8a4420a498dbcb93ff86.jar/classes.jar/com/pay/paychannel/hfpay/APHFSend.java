package com.pay.paychannel.hfpay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.pay.ui.channel.APHFSmsOrderActivity;
import midas.x.dt;

public class APHFSend
  extends APHFChannel
{
  public void b(Context paramContext, dt paramdt)
  {
    paramdt = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("phoneNum", APHFChannel.l);
    localBundle.putString("operator", APHFChannel.s);
    localBundle.putString("area", APHFChannel.t);
    localBundle.putString("accessnum", APHFChannel.q);
    localBundle.putString("accessmsg", APHFChannel.r);
    localBundle.putString("hfFeeType", APHFChannel.w);
    localBundle.putString("hfWarmTips", APHFChannel.x);
    localBundle.putString("hfPrice", APHFChannel.p);
    localBundle.putString("hfTime", APHFChannel.u);
    paramdt.putExtras(localBundle);
    paramdt.setClass(paramContext, APHFSmsOrderActivity.class);
    paramContext.startActivity(paramdt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.hfpay.APHFSend
 * JD-Core Version:    0.7.0.1
 */