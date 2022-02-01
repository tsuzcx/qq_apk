package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class m
  extends i<v>
{
  private static final int CTRL_INDEX = 340;
  private static final String NAME = "enableLocationUpdate";
  
  public void b(final v paramv, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(138201);
    super.c(paramv, paramJSONObject, paramInt);
    if (!(this.oUM instanceof u))
    {
      Log.w("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "state manager not RuntimeLocationUpdateStateManagerWxa");
      paramv.j(paramInt, h("fail:system error", null));
      AppMethodBeat.o(138201);
      return;
    }
    final u localu = (u)this.oUM;
    paramJSONObject = localu.oUT;
    if (paramJSONObject != null) {
      paramJSONObject.bSn();
    }
    if ((paramJSONObject == null) || (localu.oVh)) {
      paramJSONObject = new s();
    }
    localu.oUT = paramJSONObject;
    paramJSONObject.X(paramv.getRuntime());
    localu.oVi = new t.a()
    {
      public final void ahE(String paramAnonymousString)
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
          if (localu.oUT != null)
          {
            localu.oUT.X(paramv.getRuntime());
            AppMethodBeat.o(138199);
            return;
            Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "STATE_NOT_LISTENING, stop blink");
            if (localu.oUT != null)
            {
              paramAnonymousString = localu.oUT;
              paramv.getRuntime();
              paramAnonymousString.bSm();
            }
          }
        }
      }
    };
    paramJSONObject = localu.oVn;
    if (paramJSONObject != null) {
      paramv.getRuntime().ntR.b(paramJSONObject);
    }
    if ((paramJSONObject == null) || (localu.oVh)) {
      paramJSONObject = new c.a()
      {
        public final void a(String paramAnonymousString, b paramAnonymousb)
        {
          AppMethodBeat.i(138200);
          if (paramAnonymousb == b.nKS)
          {
            Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.DESTROYED, uninit");
            localu.quit();
            AppMethodBeat.o(138200);
            return;
          }
          if (paramAnonymousb == b.nKR)
          {
            Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.SUSPEND, suspendListening");
            localu.bSo();
            AppMethodBeat.o(138200);
            return;
          }
          if (paramAnonymousb == b.nKP)
          {
            Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.FOREGROUND, resumeListening");
            localu.bSp();
            AppMethodBeat.o(138200);
            return;
          }
          if (paramAnonymousb == b.nKQ)
          {
            if (!localu.oVh)
            {
              Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.BACKGROUND, stopListening");
              localu.bSq();
              AppMethodBeat.o(138200);
              return;
            }
            Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.BACKGROUND, do nothing");
          }
          AppMethodBeat.o(138200);
        }
      };
    }
    paramv.getRuntime().ntR.a(paramJSONObject);
    localu.oVn = paramJSONObject;
    localu.oVh = false;
    AppMethodBeat.o(138201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.m
 * JD-Core Version:    0.7.0.1
 */