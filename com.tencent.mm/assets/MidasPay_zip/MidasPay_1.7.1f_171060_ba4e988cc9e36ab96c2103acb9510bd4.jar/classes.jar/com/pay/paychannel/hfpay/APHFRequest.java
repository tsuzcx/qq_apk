package com.pay.paychannel.hfpay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.pay.ui.channel.APHFSmsVercodeActivity;
import midas.x.dl;

public class APHFRequest
  extends APHFChannel
{
  public void b(Context paramContext, dl paramdl)
  {
    paramdl = new Bundle();
    paramdl.putString("show", "verCodeUI");
    paramdl.putString("phoneNumber", APHFChannel.k);
    paramdl.putString("hfPrice", APHFChannel.o);
    paramdl.putString("hfFeeType", APHFChannel.v);
    paramdl.putString("hfWarmTips", APHFChannel.x);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramdl);
    localIntent.setClass(paramContext, APHFSmsVercodeActivity.class);
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.hfpay.APHFRequest
 * JD-Core Version:    0.7.0.1
 */