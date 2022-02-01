package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.appbrand.utils.aa;
import com.tencent.mm.plugin.appbrand.utils.aa.a;
import com.tencent.mm.plugin.appbrand.utils.aa.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import org.json.JSONObject;

public final class e
  extends y
{
  public static final int CTRL_INDEX = 472;
  public static final String NAME = "enableDeviceOrientationChangeListening";
  private boolean kKD;
  protected aa kKE;
  private aa.b kKF;
  
  public e()
  {
    AppMethodBeat.i(137634);
    this.kKD = false;
    this.kKF = new aa.b()
    {
      public final void a(aa.a paramAnonymousa1, final aa.a paramAnonymousa2)
      {
        AppMethodBeat.i(137633);
        ac.i("MicroMsg.JsApiEnableDeviceOrientation", "OrientationListener lastOrientation:" + paramAnonymousa1.name() + "; newOrientation:" + paramAnonymousa2.name());
        ap.n(new Runnable()
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
      if (!this.kKD)
      {
        this.kKE = new aa(paramc.getContext(), this.kKF);
        this.kKE.enable();
        this.kKD = true;
      }
    }
    for (;;)
    {
      paramc = e("ok", null);
      AppMethodBeat.o(137635);
      return paramc;
      h.A(paramc);
      if (this.kKD)
      {
        this.kKE.disable();
        this.kKE = null;
        this.kKD = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.e
 * JD-Core Version:    0.7.0.1
 */