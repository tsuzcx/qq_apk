package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public class k
  extends g<com.tencent.mm.plugin.appbrand.r>
{
  private static final int CTRL_INDEX = 340;
  private static final String NAME = "enableLocationUpdate";
  
  public void b(final com.tencent.mm.plugin.appbrand.r paramr, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(138201);
    super.d(paramr, paramJSONObject, paramInt);
    if (!(this.kRV instanceof s))
    {
      ae.w("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "state manager not RuntimeLocationUpdateStateManagerWxa");
      paramr.h(paramInt, e("fail:system error", null));
      AppMethodBeat.o(138201);
      return;
    }
    final s locals = (s)this.kRV;
    paramJSONObject = locals.kSc;
    if (paramJSONObject != null) {
      paramJSONObject.bll();
    }
    if ((paramJSONObject == null) || (locals.kSo)) {
      paramJSONObject = new q();
    }
    locals.kSc = paramJSONObject;
    paramJSONObject.V(paramr.getRuntime());
    locals.kSp = new r.a()
    {
      public final void Qn(String paramAnonymousString)
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
          ae.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "STATE_LISTENING, start blink");
          if (locals.kSc != null)
          {
            locals.kSc.V(paramr.getRuntime());
            AppMethodBeat.o(138199);
            return;
            ae.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "STATE_NOT_LISTENING, stop blink");
            if (locals.kSc != null) {
              locals.kSc.blk();
            }
          }
        }
      }
    };
    paramJSONObject = locals.kSu;
    if (paramJSONObject != null) {
      paramr.getRuntime().jzQ.b(paramJSONObject);
    }
    if ((paramJSONObject == null) || (locals.kSo)) {
      paramJSONObject = new c.a()
      {
        public final void a(String paramAnonymousString, b paramAnonymousb)
        {
          AppMethodBeat.i(138200);
          if (paramAnonymousb == b.jOd)
          {
            ae.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.DESTROYED, uninit");
            locals.quit();
            AppMethodBeat.o(138200);
            return;
          }
          if (paramAnonymousb == b.jOc)
          {
            ae.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.SUSPEND, suspendListening");
            locals.blm();
            AppMethodBeat.o(138200);
            return;
          }
          if (paramAnonymousb == b.jOa)
          {
            ae.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.FOREGROUND, resumeListening");
            locals.bln();
            AppMethodBeat.o(138200);
            return;
          }
          if (paramAnonymousb == b.jOb)
          {
            if (!locals.kSo)
            {
              ae.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.BACKGROUND, stopListening");
              locals.stopListening();
              AppMethodBeat.o(138200);
              return;
            }
            ae.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.BACKGROUND, do nothing");
          }
          AppMethodBeat.o(138200);
        }
      };
    }
    paramr.getRuntime().jzQ.a(paramJSONObject);
    locals.kSu = paramJSONObject;
    locals.kSo = false;
    AppMethodBeat.o(138201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.k
 * JD-Core Version:    0.7.0.1
 */