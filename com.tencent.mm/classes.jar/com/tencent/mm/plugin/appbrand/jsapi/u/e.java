package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.appbrand.utils.z;
import com.tencent.mm.plugin.appbrand.utils.z.a;
import com.tencent.mm.plugin.appbrand.utils.z.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import org.json.JSONObject;

public final class e
  extends y
{
  public static final int CTRL_INDEX = 472;
  public static final String NAME = "enableDeviceOrientationChangeListening";
  private boolean kjm;
  protected z kjn;
  private z.b kjo;
  
  public e()
  {
    AppMethodBeat.i(137634);
    this.kjm = false;
    this.kjo = new z.b()
    {
      public final void a(z.a paramAnonymousa1, final z.a paramAnonymousa2)
      {
        AppMethodBeat.i(137633);
        ad.i("MicroMsg.JsApiEnableDeviceOrientation", "OrientationListener lastOrientation:" + paramAnonymousa1.name() + "; newOrientation:" + paramAnonymousa2.name());
        aq.n(new Runnable()
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
      if (!this.kjm)
      {
        this.kjn = new z(paramc.getContext(), this.kjo);
        this.kjn.enable();
        this.kjm = true;
      }
    }
    for (;;)
    {
      paramc = e("ok", null);
      AppMethodBeat.o(137635);
      return paramc;
      h.A(paramc);
      if (this.kjm)
      {
        this.kjn.disable();
        this.kjn = null;
        this.kjm = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.e
 * JD-Core Version:    0.7.0.1
 */