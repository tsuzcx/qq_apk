package com.tencent.mm.plugin.appbrand.jsapi.x;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import org.json.JSONObject;

public final class n
  extends a
{
  public static final int CTRL_INDEX = 229;
  public static final String NAME = "setScreenBrightness";
  float lnv = (0.0F / 0.0F);
  float lnw;
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(137687);
    ae.d("MicroMsg.JsApiSetScreenBrightness", "JsApiSetScreenBrightness!");
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null", null));
      ae.e("MicroMsg.JsApiSetScreenBrightness", "data is null");
      AppMethodBeat.o(137687);
      return;
    }
    if (!(paramc.getContext() instanceof Activity))
    {
      ae.e("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
      paramc.h(paramInt, e("fail:context is not activity", null));
      AppMethodBeat.o(137687);
      return;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        float f = 0.01F;
        AppMethodBeat.i(137686);
        n.this.lnw = ((float)paramJSONObject.optDouble("value"));
        if ((Float.isNaN(n.this.lnw)) || (n.this.lnw < 0.0F) || (n.this.lnw > 1.0F))
        {
          paramc.h(paramInt, n.this.e("fail:value invalid", null));
          ae.e("MicroMsg.JsApiSetScreenBrightness", "value invalid");
          AppMethodBeat.o(137686);
          return;
        }
        Object localObject = paramc.getContext();
        if (localObject == null)
        {
          paramc.h(paramInt, n.this.e("fail", null));
          ae.e("MicroMsg.JsApiSetScreenBrightness", "context is null, invoke fail!");
          AppMethodBeat.o(137686);
          return;
        }
        if (!(paramc.getContext() instanceof Activity))
        {
          ae.e("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
          paramc.h(paramInt, n.this.e("fail:context is not activity", null));
          AppMethodBeat.o(137686);
          return;
        }
        localObject = (Activity)localObject;
        final WindowManager.LayoutParams localLayoutParams = ((Activity)localObject).getWindow().getAttributes();
        if (Float.isNaN(n.this.lnv))
        {
          n.this.lnv = localLayoutParams.screenBrightness;
          h.a(paramc.getAppId(), new h.c()
          {
            public final void a(h.d paramAnonymous2d)
            {
              AppMethodBeat.i(137684);
              localLayoutParams.screenBrightness = n.this.lnv;
              if ((this.val$activity != null) && (!this.val$activity.isFinishing()) && (this.val$activity.getWindow() != null)) {
                this.val$activity.getWindow().setAttributes(localLayoutParams);
              }
              AppMethodBeat.o(137684);
            }
            
            public final void onResume()
            {
              AppMethodBeat.i(137685);
              localLayoutParams.screenBrightness = n.this.lnw;
              if ((this.val$activity != null) && (!this.val$activity.isFinishing()) && (this.val$activity.getWindow() != null)) {
                this.val$activity.getWindow().setAttributes(localLayoutParams);
              }
              AppMethodBeat.o(137685);
            }
          });
        }
        if (n.this.lnw < 0.01F) {}
        for (;;)
        {
          localLayoutParams.screenBrightness = f;
          ((Activity)localObject).getWindow().setAttributes(localLayoutParams);
          paramc.h(paramInt, n.this.e("ok", null));
          AppMethodBeat.o(137686);
          return;
          f = n.this.lnw;
        }
      }
    });
    AppMethodBeat.o(137687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.n
 * JD-Core Version:    0.7.0.1
 */