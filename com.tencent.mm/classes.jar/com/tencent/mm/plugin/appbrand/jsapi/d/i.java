package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public class i
  extends g<com.tencent.mm.plugin.appbrand.q>
{
  private static final int CTRL_INDEX = 586;
  private static final String NAME = "enableLocationUpdateBackground";
  
  public void b(final com.tencent.mm.plugin.appbrand.q paramq, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(138196);
    super.d(paramq, paramJSONObject, paramInt);
    if (!(this.ksX instanceof r))
    {
      ac.w("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "state manager not RuntimeLocationUpdateStateManagerWxa");
      paramq.h(paramInt, e("fail:system error", null));
      AppMethodBeat.o(138196);
      return;
    }
    final r localr = (r)this.ksX;
    paramJSONObject = localr.kte;
    if (paramJSONObject != null) {
      paramJSONObject.bgW();
    }
    if ((paramJSONObject == null) || (!localr.ktk)) {
      paramJSONObject = new p();
    }
    localr.kte = paramJSONObject;
    paramJSONObject.ac(paramq.getRuntime());
    localr.ktl = new q.a()
    {
      public final void Mj(String paramAnonymousString)
      {
        AppMethodBeat.i(138194);
        int i = -1;
        switch (paramAnonymousString.hashCode())
        {
        default: 
          switch (i)
          {
          }
          break;
        }
        for (;;)
        {
          AppMethodBeat.o(138194);
          return;
          if (!paramAnonymousString.equals("StateListening")) {
            break;
          }
          i = 0;
          break;
          if (!paramAnonymousString.equals("StateNotListening")) {
            break;
          }
          i = 1;
          break;
          if (!paramAnonymousString.equals("StateSuspend")) {
            break;
          }
          i = 2;
          break;
          ac.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "STATE_LISTENING, start blink");
          if (localr.kte != null)
          {
            localr.kte.ac(paramq.getRuntime());
            AppMethodBeat.o(138194);
            return;
            ac.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "STATE_NOT_LISTENING, stop blink");
            if (localr.kte != null) {
              localr.kte.bgV();
            }
          }
        }
      }
    };
    paramJSONObject = localr.ktq;
    if (paramJSONObject != null) {
      paramq.getRuntime().jdK.b(paramJSONObject);
    }
    if ((paramJSONObject == null) || (!localr.ktk)) {
      paramJSONObject = new c.a()
      {
        public final void a(String paramAnonymousString, b paramAnonymousb)
        {
          AppMethodBeat.i(138195);
          if (paramAnonymousb == b.jqX)
          {
            ac.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.DESTROYED, uninit");
            localr.quit();
            AppMethodBeat.o(138195);
            return;
          }
          if (paramAnonymousb == b.jqW)
          {
            ac.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.SUSPEND, suspendListening");
            localr.bgX();
            AppMethodBeat.o(138195);
            return;
          }
          if (paramAnonymousb == b.jqU)
          {
            ac.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.FOREGROUND, resumeListening");
            localr.bgY();
            AppMethodBeat.o(138195);
            return;
          }
          if (paramAnonymousb == b.jqV)
          {
            if (!localr.ktk)
            {
              ac.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.BACKGROUND, stopListening");
              localr.stopListening();
              AppMethodBeat.o(138195);
              return;
            }
            ac.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.BACKGROUND, do nothing");
          }
          AppMethodBeat.o(138195);
        }
      };
    }
    paramq.getRuntime().jdK.a(paramJSONObject);
    localr.ktq = paramJSONObject;
    localr.ktk = true;
    AppMethodBeat.o(138196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.i
 * JD-Core Version:    0.7.0.1
 */