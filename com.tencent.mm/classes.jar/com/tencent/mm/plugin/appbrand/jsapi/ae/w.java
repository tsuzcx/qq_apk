package com.tencent.mm.plugin.appbrand.jsapi.ae;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONObject;

public final class w
  extends c
{
  public static final int CTRL_INDEX = 229;
  public static final String NAME = "setScreenBrightness";
  float sxh = (0.0F / 0.0F);
  float sxi;
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(137687);
    Log.d("MicroMsg.JsApiSetScreenBrightness", "JsApiSetScreenBrightness!");
    if (paramJSONObject == null)
    {
      paramf.callback(paramInt, ZP("fail:data is null"));
      Log.e("MicroMsg.JsApiSetScreenBrightness", "data is null");
      AppMethodBeat.o(137687);
      return;
    }
    if (!(paramf.getContext() instanceof Activity))
    {
      Log.e("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
      paramf.callback(paramInt, ZP("fail:context is not activity"));
      AppMethodBeat.o(137687);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        float f = 0.01F;
        AppMethodBeat.i(137686);
        w.this.sxi = ((float)paramJSONObject.optDouble("value"));
        if ((Float.isNaN(w.this.sxi)) || (w.this.sxi < 0.0F) || (w.this.sxi > 1.0F))
        {
          paramf.callback(paramInt, w.this.ZP("fail:value invalid"));
          Log.e("MicroMsg.JsApiSetScreenBrightness", "value invalid");
          AppMethodBeat.o(137686);
          return;
        }
        Object localObject = paramf.getContext();
        if (localObject == null)
        {
          paramf.callback(paramInt, w.this.ZP("fail"));
          Log.e("MicroMsg.JsApiSetScreenBrightness", "context is null, invoke fail!");
          AppMethodBeat.o(137686);
          return;
        }
        if (!(paramf.getContext() instanceof Activity))
        {
          Log.e("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
          paramf.callback(paramInt, w.this.ZP("fail:context is not activity"));
          AppMethodBeat.o(137686);
          return;
        }
        localObject = (Activity)localObject;
        final WindowManager.LayoutParams localLayoutParams = ((Activity)localObject).getWindow().getAttributes();
        if (Float.isNaN(w.this.sxh))
        {
          w.this.sxh = localLayoutParams.screenBrightness;
          k.a(paramf.getAppId(), new k.c()
          {
            public final void a(k.d paramAnonymous2d)
            {
              AppMethodBeat.i(137684);
              localLayoutParams.screenBrightness = w.this.sxh;
              if ((this.val$activity != null) && (!this.val$activity.isFinishing()) && (this.val$activity.getWindow() != null)) {
                this.val$activity.getWindow().setAttributes(localLayoutParams);
              }
              AppMethodBeat.o(137684);
            }
            
            public final void onResume()
            {
              AppMethodBeat.i(137685);
              localLayoutParams.screenBrightness = w.this.sxi;
              if ((this.val$activity != null) && (!this.val$activity.isFinishing()) && (this.val$activity.getWindow() != null)) {
                this.val$activity.getWindow().setAttributes(localLayoutParams);
              }
              AppMethodBeat.o(137685);
            }
          });
        }
        if (w.this.sxi < 0.01F) {}
        for (;;)
        {
          localLayoutParams.screenBrightness = f;
          ((Activity)localObject).getWindow().setAttributes(localLayoutParams);
          paramf.callback(paramInt, w.this.ZP("ok"));
          AppMethodBeat.o(137686);
          return;
          f = w.this.sxi;
        }
      }
    });
    AppMethodBeat.o(137687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.w
 * JD-Core Version:    0.7.0.1
 */