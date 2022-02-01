package com.tencent.mm.plugin.appbrand.jsapi.v;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import org.json.JSONObject;

public final class m
  extends a
{
  public static final int CTRL_INDEX = 229;
  public static final String NAME = "setScreenBrightness";
  float klN = (0.0F / 0.0F);
  float klO;
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(137687);
    ad.d("MicroMsg.JsApiSetScreenBrightness", "JsApiSetScreenBrightness!");
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null", null));
      ad.e("MicroMsg.JsApiSetScreenBrightness", "data is null");
      AppMethodBeat.o(137687);
      return;
    }
    if (!(paramc.getContext() instanceof Activity))
    {
      ad.e("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
      paramc.h(paramInt, e("fail:context is not activity", null));
      AppMethodBeat.o(137687);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        float f = 0.01F;
        AppMethodBeat.i(137686);
        m.this.klO = ((float)paramJSONObject.optDouble("value"));
        if ((Float.isNaN(m.this.klO)) || (m.this.klO < 0.0F) || (m.this.klO > 1.0F))
        {
          paramc.h(paramInt, m.this.e("fail:value invalid", null));
          ad.e("MicroMsg.JsApiSetScreenBrightness", "value invalid");
          AppMethodBeat.o(137686);
          return;
        }
        Object localObject = paramc.getContext();
        if (localObject == null)
        {
          paramc.h(paramInt, m.this.e("fail", null));
          ad.e("MicroMsg.JsApiSetScreenBrightness", "context is null, invoke fail!");
          AppMethodBeat.o(137686);
          return;
        }
        if (!(paramc.getContext() instanceof Activity))
        {
          ad.e("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
          paramc.h(paramInt, m.this.e("fail:context is not activity", null));
          AppMethodBeat.o(137686);
          return;
        }
        localObject = (Activity)localObject;
        final WindowManager.LayoutParams localLayoutParams = ((Activity)localObject).getWindow().getAttributes();
        if (Float.isNaN(m.this.klN))
        {
          m.this.klN = localLayoutParams.screenBrightness;
          g.a(paramc.getAppId(), new g.c()
          {
            public final void a(g.d paramAnonymous2d)
            {
              AppMethodBeat.i(137684);
              localLayoutParams.screenBrightness = m.this.klN;
              if ((this.val$activity != null) && (!this.val$activity.isFinishing()) && (this.val$activity.getWindow() != null)) {
                this.val$activity.getWindow().setAttributes(localLayoutParams);
              }
              AppMethodBeat.o(137684);
            }
            
            public final void onResume()
            {
              AppMethodBeat.i(137685);
              localLayoutParams.screenBrightness = m.this.klO;
              if ((this.val$activity != null) && (!this.val$activity.isFinishing()) && (this.val$activity.getWindow() != null)) {
                this.val$activity.getWindow().setAttributes(localLayoutParams);
              }
              AppMethodBeat.o(137685);
            }
          });
        }
        if (m.this.klO < 0.01F) {}
        for (;;)
        {
          localLayoutParams.screenBrightness = f;
          ((Activity)localObject).getWindow().setAttributes(localLayoutParams);
          paramc.h(paramInt, m.this.e("ok", null));
          AppMethodBeat.o(137686);
          return;
          f = m.this.klO;
        }
      }
    });
    AppMethodBeat.o(137687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.m
 * JD-Core Version:    0.7.0.1
 */