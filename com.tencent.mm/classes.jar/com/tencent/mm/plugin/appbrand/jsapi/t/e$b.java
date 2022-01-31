package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.webview.ui.tools.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.k;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

final class e$b
  extends k
{
  e$b(e parame, MMWebView paramMMWebView)
  {
    super(paramMMWebView);
  }
  
  protected final void a(com.tencent.mm.plugin.webview.stub.d paramd, f paramf)
  {
    e.a(this.gGA, paramd);
    e.a(this.gGA, paramf);
    try
    {
      paramf = new Bundle();
      paramf.putString("key_webview_container_env", "miniProgram");
      Bundle localBundle = new Bundle();
      localBundle.putBundle("jsapiargs", paramf);
      paramd.a(20, localBundle, this.dYF.hashCode());
      return;
    }
    catch (RemoteException paramd)
    {
      y.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onServiceConnected, invoke AC_SET_INITIAL_ARGS, ex = " + paramd.getMessage());
    }
  }
  
  protected final void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.d paramd)
  {
    super.a(paramd);
    if ((paramd != null) && (e.b(this.gGA) != null)) {
      paramd.rkx = e.b(this.gGA).getAppId();
    }
  }
  
  public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    e.b(this.gGA).k(paramString2, paramInt, paramString1);
  }
  
  protected final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    e.a(this.gGA, paramString);
    e.b(this.gGA).uJ(paramString);
  }
  
  protected final m all()
  {
    return e.a(this.gGA);
  }
  
  protected final int alm()
  {
    if (e.b(this.gGA).alj()) {
      return 55;
    }
    return 49;
  }
  
  protected final void e(WebView paramWebView, String paramString)
  {
    e.a(this.gGA, paramString);
    e.b(this.gGA).bd(paramString);
  }
  
  protected final void f(Bundle paramBundle, String paramString)
  {
    super.f(paramBundle, paramString);
    paramBundle.putString("geta8key_data_appid", e.b(this.gGA).getAppId());
  }
  
  protected final boolean jh(String paramString)
  {
    Intent localIntent;
    if (paramString.startsWith("tel:"))
    {
      localIntent = new Intent("android.intent.action.DIAL");
      localIntent.setData(Uri.parse(paramString));
      this.dYF.getContext().startActivity(localIntent);
      return true;
    }
    if ((paramString.startsWith("sms:")) || (paramString.startsWith("smsto:")))
    {
      localIntent = new Intent("android.intent.action.SENDTO");
      localIntent.setData(Uri.parse(paramString));
      this.dYF.getContext().startActivity(localIntent);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.e.b
 * JD-Core Version:    0.7.0.1
 */