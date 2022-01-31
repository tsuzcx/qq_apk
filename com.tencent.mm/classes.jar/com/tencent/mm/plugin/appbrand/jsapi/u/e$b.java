package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

final class e$b
  extends com.tencent.mm.plugin.webview.ui.tools.widget.k
{
  e$b(e parame, MMWebView paramMMWebView)
  {
    super(paramMMWebView);
  }
  
  public final String De(String paramString)
  {
    AppMethodBeat.i(17049);
    if ((e.c(this.ihi) != null) && (e.c(this.ihi).equals(paramString)))
    {
      AppMethodBeat.o(17049);
      return "";
    }
    paramString = e.c(this.ihi);
    AppMethodBeat.o(17049);
    return paramString;
  }
  
  public final void a(com.tencent.mm.plugin.webview.stub.d paramd, com.tencent.mm.plugin.webview.ui.tools.k paramk)
  {
    AppMethodBeat.i(17043);
    e.a(this.ihi, paramd);
    e.a(this.ihi, paramk);
    try
    {
      paramk = new Bundle();
      paramk.putString("key_webview_container_env", "miniProgram");
      Bundle localBundle = new Bundle();
      localBundle.putBundle("jsapiargs", paramk);
      paramd.a(20, localBundle, this.foJ.hashCode());
      AppMethodBeat.o(17043);
      return;
    }
    catch (RemoteException paramd)
    {
      ab.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onServiceConnected, invoke AC_SET_INITIAL_ARGS, ex = " + paramd.getMessage());
      AppMethodBeat.o(17043);
    }
  }
  
  public final void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.d paramd)
  {
    AppMethodBeat.i(17052);
    super.a(paramd);
    if ((paramd != null) && (e.b(this.ihi) != null)) {
      paramd.uZS = e.b(this.ihi).getAppId();
    }
    e.a(this.ihi, paramd);
    AppMethodBeat.o(17052);
  }
  
  public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(17051);
    e.b(this.ihi).m(paramString2, paramInt, paramString1);
    AppMethodBeat.o(17051);
  }
  
  public final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(17045);
    e.a(this.ihi, paramString);
    e.b(this.ihi).Db(paramString);
    AppMethodBeat.o(17045);
  }
  
  public final m aGm()
  {
    AppMethodBeat.i(17042);
    m localm = e.a(this.ihi);
    AppMethodBeat.o(17042);
    return localm;
  }
  
  public final int aGn()
  {
    AppMethodBeat.i(17047);
    if (e.b(this.ihi).aGk())
    {
      AppMethodBeat.o(17047);
      return 55;
    }
    AppMethodBeat.o(17047);
    return 49;
  }
  
  public final int aGo()
  {
    AppMethodBeat.i(17048);
    if (e.b(this.ihi).aGk())
    {
      AppMethodBeat.o(17048);
      return 55;
    }
    AppMethodBeat.o(17048);
    return 49;
  }
  
  public final void e(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(17046);
    e.a(this.ihi, paramString);
    e.b(this.ihi).bF(paramString);
    AppMethodBeat.o(17046);
  }
  
  public final void g(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(17050);
    super.g(paramBundle, paramString);
    paramBundle.putString("geta8key_data_appid", e.b(this.ihi).getAppId());
    AppMethodBeat.o(17050);
  }
  
  public final boolean pV(String paramString)
  {
    AppMethodBeat.i(17044);
    if (paramString.startsWith("file:///android_asset"))
    {
      ab.w("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "handleUrlLoading found %s", new Object[] { paramString });
      AppMethodBeat.o(17044);
      return true;
    }
    Intent localIntent;
    if (paramString.startsWith("tel:"))
    {
      localIntent = new Intent("android.intent.action.DIAL");
      localIntent.setData(Uri.parse(paramString));
      this.foJ.getContext().startActivity(localIntent);
      AppMethodBeat.o(17044);
      return true;
    }
    if ((paramString.startsWith("sms:")) || (paramString.startsWith("smsto:")))
    {
      localIntent = new Intent("android.intent.action.SENDTO");
      localIntent.setData(Uri.parse(paramString));
      this.foJ.getContext().startActivity(localIntent);
      AppMethodBeat.o(17044);
      return true;
    }
    if ((URLUtil.isHttpUrl(paramString)) || (URLUtil.isHttpsUrl(paramString)) || (bo.nullAsNil(paramString).startsWith("weixin"))) {}
    for (int i = 1; i == 0; i = 0)
    {
      ab.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "handleUrlLoading found unacceptable %s", new Object[] { paramString });
      AppMethodBeat.o(17044);
      return true;
    }
    AppMethodBeat.o(17044);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.e.b
 * JD-Core Version:    0.7.0.1
 */