package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.arb;

final class JsApiLaunchApplication$1$1$2
  implements Runnable
{
  JsApiLaunchApplication$1$1$2(JsApiLaunchApplication.1.1 param1, Intent paramIntent, arb paramarb, JsApiLaunchApplication.a parama) {}
  
  public final void run()
  {
    boolean bool = g.a(this.ggj.ggi.gcp.getContext(), this.val$intent, null, this.ggk.tmN, this.ggl, this.ggj.ggi.ggd);
    this.ggl.cX(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.1.1.2
 * JD-Core Version:    0.7.0.1
 */