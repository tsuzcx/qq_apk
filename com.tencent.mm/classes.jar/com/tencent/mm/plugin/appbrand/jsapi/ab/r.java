package com.tencent.mm.plugin.appbrand.jsapi.ab;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONObject;

public final class r
  extends c
{
  public static final int CTRL_INDEX = 229;
  public static final String NAME = "setScreenBrightness";
  float pso = (0.0F / 0.0F);
  float psp;
  
  public final void a(final e parame, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(137687);
    Log.d("MicroMsg.JsApiSetScreenBrightness", "JsApiSetScreenBrightness!");
    if (paramJSONObject == null)
    {
      parame.j(paramInt, h("fail:data is null", null));
      Log.e("MicroMsg.JsApiSetScreenBrightness", "data is null");
      AppMethodBeat.o(137687);
      return;
    }
    if (!(parame.getContext() instanceof Activity))
    {
      Log.e("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
      parame.j(paramInt, h("fail:context is not activity", null));
      AppMethodBeat.o(137687);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        float f = 0.01F;
        AppMethodBeat.i(137686);
        r.this.psp = ((float)paramJSONObject.optDouble("value"));
        if ((Float.isNaN(r.this.psp)) || (r.this.psp < 0.0F) || (r.this.psp > 1.0F))
        {
          parame.j(paramInt, r.this.h("fail:value invalid", null));
          Log.e("MicroMsg.JsApiSetScreenBrightness", "value invalid");
          AppMethodBeat.o(137686);
          return;
        }
        Object localObject = parame.getContext();
        if (localObject == null)
        {
          parame.j(paramInt, r.this.h("fail", null));
          Log.e("MicroMsg.JsApiSetScreenBrightness", "context is null, invoke fail!");
          AppMethodBeat.o(137686);
          return;
        }
        if (!(parame.getContext() instanceof Activity))
        {
          Log.e("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
          parame.j(paramInt, r.this.h("fail:context is not activity", null));
          AppMethodBeat.o(137686);
          return;
        }
        localObject = (Activity)localObject;
        final WindowManager.LayoutParams localLayoutParams = ((Activity)localObject).getWindow().getAttributes();
        if (Float.isNaN(r.this.pso))
        {
          r.this.pso = localLayoutParams.screenBrightness;
          k.a(parame.getAppId(), new k.c()
          {
            public final void a(k.d paramAnonymous2d)
            {
              AppMethodBeat.i(137684);
              localLayoutParams.screenBrightness = r.this.pso;
              if ((this.val$activity != null) && (!this.val$activity.isFinishing()) && (this.val$activity.getWindow() != null)) {
                this.val$activity.getWindow().setAttributes(localLayoutParams);
              }
              AppMethodBeat.o(137684);
            }
            
            public final void onResume()
            {
              AppMethodBeat.i(137685);
              localLayoutParams.screenBrightness = r.this.psp;
              if ((this.val$activity != null) && (!this.val$activity.isFinishing()) && (this.val$activity.getWindow() != null)) {
                this.val$activity.getWindow().setAttributes(localLayoutParams);
              }
              AppMethodBeat.o(137685);
            }
          });
        }
        if (r.this.psp < 0.01F) {}
        for (;;)
        {
          localLayoutParams.screenBrightness = f;
          ((Activity)localObject).getWindow().setAttributes(localLayoutParams);
          parame.j(paramInt, r.this.h("ok", null));
          AppMethodBeat.o(137686);
          return;
          f = r.this.psp;
        }
      }
    });
    AppMethodBeat.o(137687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.r
 * JD-Core Version:    0.7.0.1
 */