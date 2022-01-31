package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

final class j$1
  implements Runnable
{
  j$1(j paramj, JSONObject paramJSONObject, c paramc, int paramInt) {}
  
  public final void run()
  {
    float f = 0.01F;
    this.gCo.gCn = ((float)this.gbZ.optDouble("value"));
    if ((Float.isNaN(this.gCo.gCn)) || (this.gCo.gCn < 0.0F) || (this.gCo.gCn > 1.0F))
    {
      this.ggH.C(this.dIS, this.gCo.h("fail:value invalid", null));
      y.e("MicroMsg.JsApiSetScreenBrightness", "value invalid");
      return;
    }
    Object localObject = this.ggH.getContext();
    if (localObject == null)
    {
      this.ggH.C(this.dIS, this.gCo.h("fail", null));
      y.e("MicroMsg.JsApiSetScreenBrightness", "context is null, invoke fail!");
      return;
    }
    if (!(this.ggH.getContext() instanceof Activity))
    {
      y.e("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
      this.ggH.C(this.dIS, this.gCo.h("fail:context is not activity", null));
      return;
    }
    localObject = (Activity)localObject;
    WindowManager.LayoutParams localLayoutParams = ((Activity)localObject).getWindow().getAttributes();
    if (Float.isNaN(this.gCo.gCm))
    {
      this.gCo.gCm = localLayoutParams.screenBrightness;
      g.a(this.ggH.getAppId(), new j.1.1(this, localLayoutParams, (Activity)localObject));
    }
    if (this.gCo.gCn < 0.01F) {}
    for (;;)
    {
      localLayoutParams.screenBrightness = f;
      ((Activity)localObject).getWindow().setAttributes(localLayoutParams);
      this.ggH.C(this.dIS, this.gCo.h("ok", null));
      return;
      f = this.gCo.gCn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.j.1
 * JD-Core Version:    0.7.0.1
 */