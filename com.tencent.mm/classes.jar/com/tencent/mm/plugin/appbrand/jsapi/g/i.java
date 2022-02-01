package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public class i
  extends g<com.tencent.mm.plugin.appbrand.r>
{
  private static final int CTRL_INDEX = 586;
  private static final String NAME = "enableLocationUpdateBackground";
  
  public void b(final com.tencent.mm.plugin.appbrand.r paramr, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(138196);
    super.d(paramr, paramJSONObject, paramInt);
    if (!(this.kRV instanceof s))
    {
      ae.w("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "state manager not RuntimeLocationUpdateStateManagerWxa");
      paramr.h(paramInt, e("fail:system error", null));
      AppMethodBeat.o(138196);
      return;
    }
    final s locals = (s)this.kRV;
    paramJSONObject = locals.kSc;
    if (paramJSONObject != null) {
      paramJSONObject.bll();
    }
    if ((paramJSONObject == null) || (!locals.kSo)) {
      paramJSONObject = new q();
    }
    locals.kSc = paramJSONObject;
    paramJSONObject.V(paramr.getRuntime());
    locals.kSp = new r.a()
    {
      public final void Qn(String paramAnonymousString)
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
          ae.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "STATE_LISTENING, start blink");
          if (locals.kSc != null)
          {
            locals.kSc.V(paramr.getRuntime());
            AppMethodBeat.o(138194);
            return;
            ae.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "STATE_NOT_LISTENING, stop blink");
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
    if ((paramJSONObject == null) || (!locals.kSo)) {
      paramJSONObject = new c.a()
      {
        public final void a(String paramAnonymousString, b paramAnonymousb)
        {
          AppMethodBeat.i(138195);
          if (paramAnonymousb == b.jOd)
          {
            ae.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.DESTROYED, uninit");
            locals.quit();
            AppMethodBeat.o(138195);
            return;
          }
          if (paramAnonymousb == b.jOc)
          {
            ae.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.SUSPEND, suspendListening");
            locals.blm();
            AppMethodBeat.o(138195);
            return;
          }
          if (paramAnonymousb == b.jOa)
          {
            ae.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.FOREGROUND, resumeListening");
            locals.bln();
            AppMethodBeat.o(138195);
            return;
          }
          if (paramAnonymousb == b.jOb)
          {
            if (!locals.kSo)
            {
              ae.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.BACKGROUND, stopListening");
              locals.stopListening();
              AppMethodBeat.o(138195);
              return;
            }
            ae.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.BACKGROUND, do nothing");
          }
          AppMethodBeat.o(138195);
        }
      };
    }
    paramr.getRuntime().jzQ.a(paramJSONObject);
    locals.kSu = paramJSONObject;
    locals.kSo = true;
    AppMethodBeat.o(138196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.i
 * JD-Core Version:    0.7.0.1
 */