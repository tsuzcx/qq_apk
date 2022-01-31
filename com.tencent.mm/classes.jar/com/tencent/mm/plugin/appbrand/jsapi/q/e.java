package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.t.t;
import com.tencent.mm.plugin.appbrand.t.t.a;
import com.tencent.mm.plugin.appbrand.t.t.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONObject;

public final class e
  extends u
{
  public static final int CTRL_INDEX = 472;
  public static final String NAME = "enableDeviceOrientationChangeListening";
  private boolean hYK;
  protected t hYL;
  private t.b hYM;
  
  public e()
  {
    AppMethodBeat.i(126380);
    this.hYK = false;
    this.hYM = new t.b()
    {
      public final void a(t.a paramAnonymousa1, t.a paramAnonymousa2)
      {
        AppMethodBeat.i(126379);
        ab.i("MicroMsg.JsApiEnableDeviceOrientation", "OrientationListener lastOrientation:" + paramAnonymousa1.name() + "; newOrientation:" + paramAnonymousa2.name());
        al.p(new e.1.1(this, paramAnonymousa2), 500L);
        AppMethodBeat.o(126379);
      }
    };
    AppMethodBeat.o(126380);
  }
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126381);
    if (paramJSONObject.optBoolean("enable", false))
    {
      h.u(paramc);
      if (!this.hYK)
      {
        this.hYL = new t(paramc.getContext(), this.hYM);
        this.hYL.enable();
        this.hYK = true;
      }
    }
    for (;;)
    {
      paramc = j("ok", null);
      AppMethodBeat.o(126381);
      return paramc;
      h.v(paramc);
      if (this.hYK)
      {
        this.hYL.disable();
        this.hYL = null;
        this.hYK = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.e
 * JD-Core Version:    0.7.0.1
 */