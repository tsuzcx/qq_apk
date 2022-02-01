package com.pay.paychannel.hfpay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.pay.ui.channel.APHFSmsOrderActivity;
import midas.x.dl;

public class APHFSend
  extends APHFChannel
{
  public void b(Context paramContext, dl paramdl)
  {
    paramdl = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("phoneNum", APHFChannel.k);
    localBundle.putString("operator", APHFChannel.r);
    localBundle.putString("area", APHFChannel.s);
    localBundle.putString("accessnum", APHFChannel.p);
    localBundle.putString("accessmsg", APHFChannel.q);
    localBundle.putString("hfFeeType", APHFChannel.v);
    localBundle.putString("hfWarmTips", APHFChannel.x);
    localBundle.putString("hfPrice", APHFChannel.o);
    localBundle.putString("hfTime", APHFChannel.t);
    paramdl.putExtras(localBundle);
    paramdl.setClass(paramContext, APHFSmsOrderActivity.class);
    paramContext.startActivity(paramdl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.hfpay.APHFSend
 * JD-Core Version:    0.7.0.1
 */