package com.pay.paychannel.hfpay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.pay.ui.payWeb.jsbridge.APWebJSBridgeActivity;
import com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity;
import midas.x.c6;
import midas.x.h8;
import midas.x.w3;
import midas.x.y7;

public class APHFWeb
  extends APHFChannel
{
  public String K;
  
  public APHFWeb(String paramString)
  {
    this.K = paramString;
  }
  
  public void a(Context paramContext, w3 paramw3)
  {
    String str = c6.s0().u();
    Bundle localBundle = new Bundle();
    localBundle.putString("pageName", y7.A);
    localBundle.putString("url", str);
    localBundle.putString("subChannelId", this.K);
    localBundle.putInt("webSolutionType", paramw3.u());
    c(paramContext, localBundle);
  }
  
  public void c(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    if (h8.d(paramContext)) {
      localIntent.setClass(paramContext, APX5WebJSBridgeActivity.class);
    } else {
      localIntent.setClass(paramContext, APWebJSBridgeActivity.class);
    }
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.hfpay.APHFWeb
 * JD-Core Version:    0.7.0.1
 */