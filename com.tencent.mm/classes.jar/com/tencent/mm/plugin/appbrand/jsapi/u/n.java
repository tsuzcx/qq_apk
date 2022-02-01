package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import org.json.JSONObject;

public final class n
  extends a
{
  public static final int CTRL_INDEX = 229;
  public static final String NAME = "setScreenBrightness";
  float kNf = (0.0F / 0.0F);
  float kNg;
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(137687);
    ac.d("MicroMsg.JsApiSetScreenBrightness", "JsApiSetScreenBrightness!");
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null", null));
      ac.e("MicroMsg.JsApiSetScreenBrightness", "data is null");
      AppMethodBeat.o(137687);
      return;
    }
    if (!(paramc.getContext() instanceof Activity))
    {
      ac.e("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
      paramc.h(paramInt, e("fail:context is not activity", null));
      AppMethodBeat.o(137687);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        float f = 0.01F;
        AppMethodBeat.i(137686);
        n.this.kNg = ((float)paramJSONObject.optDouble("value"));
        if ((Float.isNaN(n.this.kNg)) || (n.this.kNg < 0.0F) || (n.this.kNg > 1.0F))
        {
          paramc.h(paramInt, n.this.e("fail:value invalid", null));
          ac.e("MicroMsg.JsApiSetScreenBrightness", "value invalid");
          AppMethodBeat.o(137686);
          return;
        }
        Object localObject = paramc.getContext();
        if (localObject == null)
        {
          paramc.h(paramInt, n.this.e("fail", null));
          ac.e("MicroMsg.JsApiSetScreenBrightness", "context is null, invoke fail!");
          AppMethodBeat.o(137686);
          return;
        }
        if (!(paramc.getContext() instanceof Activity))
        {
          ac.e("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
          paramc.h(paramInt, n.this.e("fail:context is not activity", null));
          AppMethodBeat.o(137686);
          return;
        }
        localObject = (Activity)localObject;
        final WindowManager.LayoutParams localLayoutParams = ((Activity)localObject).getWindow().getAttributes();
        if (Float.isNaN(n.this.kNf))
        {
          n.this.kNf = localLayoutParams.screenBrightness;
          g.a(paramc.getAppId(), new g.c()
          {
            public final void a(g.d paramAnonymous2d)
            {
              AppMethodBeat.i(137684);
              localLayoutParams.screenBrightness = n.this.kNf;
              if ((this.val$activity != null) && (!this.val$activity.isFinishing()) && (this.val$activity.getWindow() != null)) {
                this.val$activity.getWindow().setAttributes(localLayoutParams);
              }
              AppMethodBeat.o(137684);
            }
            
            public final void onResume()
            {
              AppMethodBeat.i(137685);
              localLayoutParams.screenBrightness = n.this.kNg;
              if ((this.val$activity != null) && (!this.val$activity.isFinishing()) && (this.val$activity.getWindow() != null)) {
                this.val$activity.getWindow().setAttributes(localLayoutParams);
              }
              AppMethodBeat.o(137685);
            }
          });
        }
        if (n.this.kNg < 0.01F) {}
        for (;;)
        {
          localLayoutParams.screenBrightness = f;
          ((Activity)localObject).getWindow().setAttributes(localLayoutParams);
          paramc.h(paramInt, n.this.e("ok", null));
          AppMethodBeat.o(137686);
          return;
          f = n.this.kNg;
        }
      }
    });
    AppMethodBeat.o(137687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.n
 * JD-Core Version:    0.7.0.1
 */