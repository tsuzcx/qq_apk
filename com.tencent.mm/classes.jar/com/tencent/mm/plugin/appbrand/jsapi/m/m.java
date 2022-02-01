package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class m
  extends i<y>
{
  private static final int CTRL_INDEX = 340;
  private static final String NAME = "enableLocationUpdate";
  
  public void b(final y paramy, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(138201);
    super.d(paramy, paramJSONObject, paramInt);
    if (!(this.rZZ instanceof v))
    {
      Log.w("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "state manager not RuntimeLocationUpdateStateManagerWxa");
      paramy.callback(paramInt, ZP("fail:system error"));
      AppMethodBeat.o(138201);
      return;
    }
    final v localv = (v)this.rZZ;
    paramJSONObject = localv.sag;
    if (paramJSONObject != null) {
      paramJSONObject.css();
    }
    if ((paramJSONObject == null) || (localv.sax)) {
      paramJSONObject = new s();
    }
    localv.sag = paramJSONObject;
    paramJSONObject.al(paramy.getRuntime());
    localv.say = new u.a()
    {
      public final void aaB(String paramAnonymousString)
      {
        AppMethodBeat.i(138199);
        s locals = localv.sag;
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
          if (locals != null)
          {
            locals.al(paramy.getRuntime());
            AppMethodBeat.o(138199);
            return;
            Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "STATE_NOT_LISTENING, stop blink");
            if (locals != null)
            {
              paramy.getRuntime();
              locals.csr();
            }
          }
        }
      }
    };
    paramJSONObject = localv.saD;
    if (paramJSONObject != null) {
      paramy.getRuntime().qsB.b(paramJSONObject);
    }
    if ((paramJSONObject == null) || (localv.sax)) {
      paramJSONObject = new c.a()
      {
        public final void onRunningStateChanged(String paramAnonymousString, b paramAnonymousb)
        {
          AppMethodBeat.i(138200);
          if (paramAnonymousb == b.qKz)
          {
            Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.DESTROYED, uninit");
            localv.quit();
            AppMethodBeat.o(138200);
            return;
          }
          if (paramAnonymousb == b.qKy)
          {
            Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.SUSPEND, suspendListening");
            localv.cst();
            AppMethodBeat.o(138200);
            return;
          }
          if (paramAnonymousb == b.qKw)
          {
            Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.FOREGROUND, resumeListening");
            localv.csu();
            AppMethodBeat.o(138200);
            return;
          }
          if (paramAnonymousb == b.qKx)
          {
            if (!localv.sax)
            {
              Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.BACKGROUND, stopListening");
              localv.csv();
              AppMethodBeat.o(138200);
              return;
            }
            Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.BACKGROUND, do nothing");
          }
          AppMethodBeat.o(138200);
        }
      };
    }
    paramy.getRuntime().qsB.a(paramJSONObject);
    localv.saD = paramJSONObject;
    localv.sax = false;
    AppMethodBeat.o(138201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.m
 * JD-Core Version:    0.7.0.1
 */