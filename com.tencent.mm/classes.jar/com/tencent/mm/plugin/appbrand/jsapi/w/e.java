package com.tencent.mm.plugin.appbrand.jsapi.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.plugin.appbrand.utils.ad.a;
import com.tencent.mm.plugin.appbrand.utils.ad.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import org.json.JSONObject;

public final class e
  extends y
{
  public static final int CTRL_INDEX = 472;
  public static final String NAME = "enableDeviceOrientationChangeListening";
  private boolean lkO;
  protected ad lkP;
  private ad.b lkQ;
  
  public e()
  {
    AppMethodBeat.i(137634);
    this.lkO = false;
    this.lkQ = new ad.b()
    {
      public final void a(ad.a paramAnonymousa1, final ad.a paramAnonymousa2)
      {
        AppMethodBeat.i(137633);
        ae.i("MicroMsg.JsApiEnableDeviceOrientation", "OrientationListener lastOrientation:" + paramAnonymousa1.name() + "; newOrientation:" + paramAnonymousa2.name());
        ar.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(137632);
            h.c(paramAnonymousa2);
            AppMethodBeat.o(137632);
          }
        }, 500L);
        AppMethodBeat.o(137633);
      }
    };
    AppMethodBeat.o(137634);
  }
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137635);
    if (paramJSONObject.optBoolean("enable", false))
    {
      h.z(paramc);
      if (!this.lkO)
      {
        this.lkP = new ad(paramc.getContext(), this.lkQ);
        this.lkP.enable();
        this.lkO = true;
      }
    }
    for (;;)
    {
      paramc = e("ok", null);
      AppMethodBeat.o(137635);
      return paramc;
      h.A(paramc);
      if (this.lkO)
      {
        this.lkP.disable();
        this.lkP = null;
        this.lkO = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.e
 * JD-Core Version:    0.7.0.1
 */