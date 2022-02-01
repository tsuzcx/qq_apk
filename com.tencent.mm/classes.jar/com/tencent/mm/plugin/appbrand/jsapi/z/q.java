package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONObject;

public final class q
  extends d
{
  public static final int CTRL_INDEX = 229;
  public static final String NAME = "setScreenBrightness";
  float mud = (0.0F / 0.0F);
  float mue;
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(137687);
    Log.d("MicroMsg.JsApiSetScreenBrightness", "JsApiSetScreenBrightness!");
    if (paramJSONObject == null)
    {
      paramf.i(paramInt, h("fail:data is null", null));
      Log.e("MicroMsg.JsApiSetScreenBrightness", "data is null");
      AppMethodBeat.o(137687);
      return;
    }
    if (!(paramf.getContext() instanceof Activity))
    {
      Log.e("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
      paramf.i(paramInt, h("fail:context is not activity", null));
      AppMethodBeat.o(137687);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        float f = 0.01F;
        AppMethodBeat.i(137686);
        q.this.mue = ((float)paramJSONObject.optDouble("value"));
        if ((Float.isNaN(q.this.mue)) || (q.this.mue < 0.0F) || (q.this.mue > 1.0F))
        {
          paramf.i(paramInt, q.this.h("fail:value invalid", null));
          Log.e("MicroMsg.JsApiSetScreenBrightness", "value invalid");
          AppMethodBeat.o(137686);
          return;
        }
        Object localObject = paramf.getContext();
        if (localObject == null)
        {
          paramf.i(paramInt, q.this.h("fail", null));
          Log.e("MicroMsg.JsApiSetScreenBrightness", "context is null, invoke fail!");
          AppMethodBeat.o(137686);
          return;
        }
        if (!(paramf.getContext() instanceof Activity))
        {
          Log.e("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
          paramf.i(paramInt, q.this.h("fail:context is not activity", null));
          AppMethodBeat.o(137686);
          return;
        }
        localObject = (Activity)localObject;
        final WindowManager.LayoutParams localLayoutParams = ((Activity)localObject).getWindow().getAttributes();
        if (Float.isNaN(q.this.mud))
        {
          q.this.mud = localLayoutParams.screenBrightness;
          h.a(paramf.getAppId(), new h.c()
          {
            public final void a(h.d paramAnonymous2d)
            {
              AppMethodBeat.i(137684);
              localLayoutParams.screenBrightness = q.this.mud;
              if ((this.val$activity != null) && (!this.val$activity.isFinishing()) && (this.val$activity.getWindow() != null)) {
                this.val$activity.getWindow().setAttributes(localLayoutParams);
              }
              AppMethodBeat.o(137684);
            }
            
            public final void onResume()
            {
              AppMethodBeat.i(137685);
              localLayoutParams.screenBrightness = q.this.mue;
              if ((this.val$activity != null) && (!this.val$activity.isFinishing()) && (this.val$activity.getWindow() != null)) {
                this.val$activity.getWindow().setAttributes(localLayoutParams);
              }
              AppMethodBeat.o(137685);
            }
          });
        }
        if (q.this.mue < 0.01F) {}
        for (;;)
        {
          localLayoutParams.screenBrightness = f;
          ((Activity)localObject).getWindow().setAttributes(localLayoutParams);
          paramf.i(paramInt, q.this.h("ok", null));
          AppMethodBeat.o(137686);
          return;
          f = q.this.mue;
        }
      }
    });
    AppMethodBeat.o(137687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.q
 * JD-Core Version:    0.7.0.1
 */