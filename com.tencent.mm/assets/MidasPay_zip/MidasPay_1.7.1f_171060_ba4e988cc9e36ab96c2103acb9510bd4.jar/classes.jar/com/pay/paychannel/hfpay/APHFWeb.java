package com.pay.paychannel.hfpay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.pay.ui.payWeb.jsbridge.APWebJSBridgeActivity;
import com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity;
import midas.x.dl;
import midas.x.fb;
import midas.x.fp;
import midas.x.hj;
import midas.x.hs;

public class APHFWeb
  extends APHFChannel
{
  private String B;
  
  public APHFWeb(String paramString)
  {
    this.B = paramString;
  }
  
  public void b(Context paramContext, dl paramdl)
  {
    paramdl = fp.a().ag();
    Bundle localBundle = new Bundle();
    if (fb.h(this.B)) {
      localBundle.putString("pageName", hj.D);
    } else if (fb.i(this.B)) {
      localBundle.putString("pageName", hj.E);
    }
    localBundle.putString("url", paramdl);
    c(paramContext, localBundle);
  }
  
  public void c(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    if (hs.b(paramContext)) {
      localIntent.setClass(paramContext, APX5WebJSBridgeActivity.class);
    } else {
      localIntent.setClass(paramContext, APWebJSBridgeActivity.class);
    }
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.hfpay.APHFWeb
 * JD-Core Version:    0.7.0.1
 */