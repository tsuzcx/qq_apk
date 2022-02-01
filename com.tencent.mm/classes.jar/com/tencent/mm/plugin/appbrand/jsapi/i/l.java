package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class l
  extends h<com.tencent.mm.plugin.appbrand.s>
{
  private static final int CTRL_INDEX = 340;
  private static final String NAME = "enableLocationUpdate";
  
  public void b(final com.tencent.mm.plugin.appbrand.s params, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(138201);
    super.d(params, paramJSONObject, paramInt);
    if (!(this.lXb instanceof t))
    {
      Log.w("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "state manager not RuntimeLocationUpdateStateManagerWxa");
      params.i(paramInt, h("fail:system error", null));
      AppMethodBeat.o(138201);
      return;
    }
    final t localt = (t)this.lXb;
    paramJSONObject = localt.lXi;
    if (paramJSONObject != null) {
      paramJSONObject.bGH();
    }
    if ((paramJSONObject == null) || (localt.lXu)) {
      paramJSONObject = new r();
    }
    localt.lXi = paramJSONObject;
    paramJSONObject.W(params.getRuntime());
    localt.lXv = new s.a()
    {
      public final void ZO(String paramAnonymousString)
      {
        AppMethodBeat.i(138199);
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
          AppMethodBeat.o(138199);
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
          Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "STATE_LISTENING, start blink");
          if (localt.lXi != null)
          {
            localt.lXi.W(params.getRuntime());
            AppMethodBeat.o(138199);
            return;
            Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "STATE_NOT_LISTENING, stop blink");
            if (localt.lXi != null) {
              localt.lXi.bGG();
            }
          }
        }
      }
    };
    paramJSONObject = localt.lXA;
    if (paramJSONObject != null) {
      params.getRuntime().kAH.b(paramJSONObject);
    }
    if ((paramJSONObject == null) || (localt.lXu)) {
      paramJSONObject = new c.a()
      {
        public final void a(String paramAnonymousString, b paramAnonymousb)
        {
          AppMethodBeat.i(138200);
          if (paramAnonymousb == b.kQK)
          {
            Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.DESTROYED, uninit");
            localt.quit();
            AppMethodBeat.o(138200);
            return;
          }
          if (paramAnonymousb == b.kQJ)
          {
            Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.SUSPEND, suspendListening");
            localt.bGI();
            AppMethodBeat.o(138200);
            return;
          }
          if (paramAnonymousb == b.kQH)
          {
            Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.FOREGROUND, resumeListening");
            localt.bGJ();
            AppMethodBeat.o(138200);
            return;
          }
          if (paramAnonymousb == b.kQI)
          {
            if (!localt.lXu)
            {
              Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.BACKGROUND, stopListening");
              localt.stopListening();
              AppMethodBeat.o(138200);
              return;
            }
            Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.BACKGROUND, do nothing");
          }
          AppMethodBeat.o(138200);
        }
      };
    }
    params.getRuntime().kAH.a(paramJSONObject);
    localt.lXA = paramJSONObject;
    localt.lXu = false;
    AppMethodBeat.o(138201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.l
 * JD-Core Version:    0.7.0.1
 */