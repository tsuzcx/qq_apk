package com.tencent.mm.plugin.appbrand.jsapi.webview.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.c;
import com.tencent.mm.plugin.appbrand.ui.o;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.widget.MMWebView;

abstract class a
{
  protected final MMWebView ooz;
  protected e sLC;
  protected g sLD;
  protected final g.c sLN;
  
  public a(g.c paramc)
  {
    this.sLN = paramc;
    this.ooz = this.sLN.getWebView();
  }
  
  final void a(g paramg)
  {
    this.sLD = paramg;
  }
  
  final void a(e parame)
  {
    this.sLC = parame;
  }
  
  protected void bm(Context paramContext) {}
  
  protected final Context getContext()
  {
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.sLN.getAndroidContext());
    Object localObject = localActivity;
    if (localActivity == null) {
      localObject = o.fj(MMApplicationContext.getContext());
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.a.a
 * JD-Core Version:    0.7.0.1
 */