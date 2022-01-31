package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

final class k$1
  implements Runnable
{
  k$1(k paramk, JSONObject paramJSONObject, c paramc, int paramInt) {}
  
  public final void run()
  {
    float f = 0.01F;
    AppMethodBeat.i(126431);
    this.iaX.iaW = ((float)this.bBa.optDouble("value"));
    if ((Float.isNaN(this.iaX.iaW)) || (this.iaX.iaW < 0.0F) || (this.iaX.iaW > 1.0F))
    {
      this.hxW.h(this.bAX, this.iaX.j("fail:value invalid", null));
      ab.e("MicroMsg.JsApiSetScreenBrightness", "value invalid");
      AppMethodBeat.o(126431);
      return;
    }
    Object localObject = this.hxW.getContext();
    if (localObject == null)
    {
      this.hxW.h(this.bAX, this.iaX.j("fail", null));
      ab.e("MicroMsg.JsApiSetScreenBrightness", "context is null, invoke fail!");
      AppMethodBeat.o(126431);
      return;
    }
    if (!(this.hxW.getContext() instanceof Activity))
    {
      ab.e("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
      this.hxW.h(this.bAX, this.iaX.j("fail:context is not activity", null));
      AppMethodBeat.o(126431);
      return;
    }
    localObject = (Activity)localObject;
    WindowManager.LayoutParams localLayoutParams = ((Activity)localObject).getWindow().getAttributes();
    if (Float.isNaN(this.iaX.iaV))
    {
      this.iaX.iaV = localLayoutParams.screenBrightness;
      e.a(this.hxW.getAppId(), new k.1.1(this, localLayoutParams, (Activity)localObject));
    }
    if (this.iaX.iaW < 0.01F) {}
    for (;;)
    {
      localLayoutParams.screenBrightness = f;
      ((Activity)localObject).getWindow().setAttributes(localLayoutParams);
      this.hxW.h(this.bAX, this.iaX.j("ok", null));
      AppMethodBeat.o(126431);
      return;
      f = this.iaX.iaW;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.k.1
 * JD-Core Version:    0.7.0.1
 */