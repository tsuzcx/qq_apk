package com.pay.paychannel.hfpay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.pay.ui.payWeb.jsbridge.APWebJSBridgeActivity;
import com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity;
import midas.x.dt;
import midas.x.fy;
import midas.x.hu;
import midas.x.id;

public class APHFWeb
  extends APHFChannel
{
  private String G;
  
  public APHFWeb(String paramString)
  {
    this.G = paramString;
  }
  
  public void b(Context paramContext, dt paramdt)
  {
    String str = fy.a().ag();
    Bundle localBundle = new Bundle();
    localBundle.putString("pageName", hu.D);
    localBundle.putString("url", str);
    localBundle.putString("subChannelId", this.G);
    localBundle.putInt("webSolutionType", paramdt.R());
    c(paramContext, localBundle);
  }
  
  public void c(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    if (id.b(paramContext)) {
      localIntent.setClass(paramContext, APX5WebJSBridgeActivity.class);
    } else {
      localIntent.setClass(paramContext, APWebJSBridgeActivity.class);
    }
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.hfpay.APHFWeb
 * JD-Core Version:    0.7.0.1
 */