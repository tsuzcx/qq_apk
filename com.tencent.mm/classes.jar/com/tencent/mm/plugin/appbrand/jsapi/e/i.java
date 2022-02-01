package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
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
    if (!(this.jSl instanceof r))
    {
      ad.w("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "state manager not RuntimeLocationUpdateStateManagerWxa");
      paramq.h(paramInt, e("fail:system error", null));
      AppMethodBeat.o(138196);
      return;
    }
    final r localr = (r)this.jSl;
    paramJSONObject = localr.jSs;
    if (paramJSONObject != null) {
      paramJSONObject.bad();
    }
    if ((paramJSONObject == null) || (!localr.jSy)) {
      paramJSONObject = new p();
    }
    localr.jSs = paramJSONObject;
    paramJSONObject.ac(paramq.getRuntime());
    localr.jSz = new q.a()
    {
      public final void Ie(String paramAnonymousString)
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
          ad.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "STATE_LISTENING, start blink");
          if (localr.jSs != null)
          {
            localr.jSs.ac(paramq.getRuntime());
            AppMethodBeat.o(138194);
            return;
            ad.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "STATE_NOT_LISTENING, stop blink");
            if (localr.jSs != null) {
              localr.jSs.bac();
            }
          }
        }
      }
    };
    paramJSONObject = localr.jSE;
    if (paramJSONObject != null) {
      paramq.getRuntime().iDK.b(paramJSONObject);
    }
    if ((paramJSONObject == null) || (!localr.jSy)) {
      paramJSONObject = new c.a()
      {
        public final void a(String paramAnonymousString, b paramAnonymousb)
        {
          AppMethodBeat.i(138195);
          if (paramAnonymousb == b.iQN)
          {
            ad.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.DESTROYED, uninit");
            localr.quit();
            AppMethodBeat.o(138195);
            return;
          }
          if (paramAnonymousb == b.iQM)
          {
            ad.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.SUSPEND, suspendListening");
            localr.bae();
            AppMethodBeat.o(138195);
            return;
          }
          if (paramAnonymousb == b.iQK)
          {
            ad.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.FOREGROUND, resumeListening");
            localr.baf();
            AppMethodBeat.o(138195);
            return;
          }
          if (paramAnonymousb == b.iQL)
          {
            if (!localr.jSy)
            {
              ad.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.BACKGROUND, stopListening");
              localr.stopListening();
              AppMethodBeat.o(138195);
              return;
            }
            ad.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.BACKGROUND, do nothing");
          }
          AppMethodBeat.o(138195);
        }
      };
    }
    paramq.getRuntime().iDK.a(paramJSONObject);
    localr.jSE = paramJSONObject;
    localr.jSy = true;
    AppMethodBeat.o(138196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.i
 * JD-Core Version:    0.7.0.1
 */