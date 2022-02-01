package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public class k
  extends g<com.tencent.mm.plugin.appbrand.q>
{
  private static final int CTRL_INDEX = 340;
  private static final String NAME = "enableLocationUpdate";
  
  public void b(final com.tencent.mm.plugin.appbrand.q paramq, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(138201);
    super.d(paramq, paramJSONObject, paramInt);
    if (!(this.kOt instanceof r))
    {
      ad.w("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "state manager not RuntimeLocationUpdateStateManagerWxa");
      paramq.h(paramInt, e("fail:system error", null));
      AppMethodBeat.o(138201);
      return;
    }
    final r localr = (r)this.kOt;
    paramJSONObject = localr.kOA;
    if (paramJSONObject != null) {
      paramJSONObject.bkB();
    }
    if ((paramJSONObject == null) || (localr.kOG)) {
      paramJSONObject = new p();
    }
    localr.kOA = paramJSONObject;
    paramJSONObject.W(paramq.getRuntime());
    localr.kOH = new q.a()
    {
      public final void PF(String paramAnonymousString)
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
          ad.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "STATE_LISTENING, start blink");
          if (localr.kOA != null)
          {
            localr.kOA.W(paramq.getRuntime());
            AppMethodBeat.o(138199);
            return;
            ad.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "STATE_NOT_LISTENING, stop blink");
            if (localr.kOA != null) {
              localr.kOA.bkA();
            }
          }
        }
      }
    };
    paramJSONObject = localr.kOM;
    if (paramJSONObject != null) {
      paramq.getRuntime().jwS.b(paramJSONObject);
    }
    if ((paramJSONObject == null) || (localr.kOG)) {
      paramJSONObject = new c.a()
      {
        public final void a(String paramAnonymousString, b paramAnonymousb)
        {
          AppMethodBeat.i(138200);
          if (paramAnonymousb == b.jKR)
          {
            ad.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.DESTROYED, uninit");
            localr.quit();
            AppMethodBeat.o(138200);
            return;
          }
          if (paramAnonymousb == b.jKQ)
          {
            ad.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.SUSPEND, suspendListening");
            localr.bkC();
            AppMethodBeat.o(138200);
            return;
          }
          if (paramAnonymousb == b.jKO)
          {
            ad.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.FOREGROUND, resumeListening");
            localr.bkD();
            AppMethodBeat.o(138200);
            return;
          }
          if (paramAnonymousb == b.jKP)
          {
            if (!localr.kOG)
            {
              ad.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.BACKGROUND, stopListening");
              localr.stopListening();
              AppMethodBeat.o(138200);
              return;
            }
            ad.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.BACKGROUND, do nothing");
          }
          AppMethodBeat.o(138200);
        }
      };
    }
    paramq.getRuntime().jwS.a(paramJSONObject);
    localr.kOM = paramJSONObject;
    localr.kOG = false;
    AppMethodBeat.o(138201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.k
 * JD-Core Version:    0.7.0.1
 */