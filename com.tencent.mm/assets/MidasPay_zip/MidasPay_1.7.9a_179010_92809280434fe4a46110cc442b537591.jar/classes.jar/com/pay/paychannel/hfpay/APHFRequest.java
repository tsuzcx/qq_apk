package com.pay.paychannel.hfpay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.pay.ui.channel.APHFSmsVercodeActivity;
import midas.x.w3;

public class APHFRequest
  extends APHFChannel
{
  public void a(Context paramContext, w3 paramw3)
  {
    paramw3 = new Bundle();
    paramw3.putString("show", "verCodeUI");
    paramw3.putString("phoneNumber", APHFChannel.s);
    paramw3.putString("hfPrice", APHFChannel.w);
    paramw3.putString("hfFeeType", APHFChannel.C);
    paramw3.putString("hfWarmTips", APHFChannel.D);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramw3);
    localIntent.setClass(paramContext, APHFSmsVercodeActivity.class);
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.hfpay.APHFRequest
 * JD-Core Version:    0.7.0.1
 */