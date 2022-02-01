package com.pay.paychannel.hfpay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.pay.ui.channel.APHFSmsOrderActivity;
import midas.x.w3;

public class APHFSend
  extends APHFChannel
{
  public void a(Context paramContext, w3 paramw3)
  {
    paramw3 = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("phoneNum", APHFChannel.s);
    localBundle.putString("operator", APHFChannel.z);
    localBundle.putString("area", APHFChannel.A);
    localBundle.putString("accessnum", APHFChannel.x);
    localBundle.putString("accessmsg", APHFChannel.y);
    localBundle.putString("hfFeeType", APHFChannel.C);
    localBundle.putString("hfWarmTips", APHFChannel.D);
    localBundle.putString("hfPrice", APHFChannel.w);
    localBundle.putString("hfTime", APHFChannel.B);
    paramw3.putExtras(localBundle);
    paramw3.setClass(paramContext, APHFSmsOrderActivity.class);
    paramContext.startActivity(paramw3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.hfpay.APHFSend
 * JD-Core Version:    0.7.0.1
 */