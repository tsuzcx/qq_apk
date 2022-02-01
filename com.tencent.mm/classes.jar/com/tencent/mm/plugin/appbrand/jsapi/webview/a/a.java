package com.tencent.mm.plugin.appbrand.jsapi.webview.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.c;
import com.tencent.mm.plugin.appbrand.ui.l;
import com.tencent.mm.plugin.webview.f.g;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.widget.MMWebView;

abstract class a
{
  protected final MMWebView lxa;
  protected e pGC;
  protected g pGD;
  protected final g.c pGN;
  
  public a(g.c paramc)
  {
    this.pGN = paramc;
    this.lxa = this.pGN.getWebView();
  }
  
  final void a(g paramg)
  {
    this.pGD = paramg;
  }
  
  final void a(e parame)
  {
    this.pGC = parame;
  }
  
  protected void aD(Context paramContext) {}
  
  protected final Context getContext()
  {
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.pGN.getAndroidContext());
    Object localObject = localActivity;
    if (localActivity == null) {
      localObject = l.en(MMApplicationContext.getContext());
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.a.a
 * JD-Core Version:    0.7.0.1
 */