package com.tencent.mm.plugin.appbrand.jsapi.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.plugin.appbrand.utils.ad.a;
import com.tencent.mm.plugin.appbrand.utils.ad.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONObject;

public final class e
  extends ab
{
  public static final int CTRL_INDEX = 472;
  public static final String NAME = "enableDeviceOrientationChangeListening";
  protected ad mqA;
  private ad.b mqB;
  private boolean mqz;
  
  public e()
  {
    AppMethodBeat.i(137634);
    this.mqz = false;
    this.mqB = new ad.b()
    {
      public final void a(ad.a paramAnonymousa1, final ad.a paramAnonymousa2)
      {
        AppMethodBeat.i(137633);
        Log.i("MicroMsg.JsApiEnableDeviceOrientation", "OrientationListener lastOrientation:" + paramAnonymousa1.name() + "; newOrientation:" + paramAnonymousa2.name());
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
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
  
  public final String a(f paramf, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137635);
    if (paramJSONObject.optBoolean("enable", false))
    {
      h.A(paramf);
      if (!this.mqz)
      {
        this.mqA = new ad(paramf.getContext(), this.mqB);
        this.mqA.enable();
        this.mqz = true;
      }
    }
    for (;;)
    {
      paramf = h("ok", null);
      AppMethodBeat.o(137635);
      return paramf;
      h.B(paramf);
      if (this.mqz)
      {
        this.mqA.disable();
        this.mqA = null;
        this.mqz = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.e
 * JD-Core Version:    0.7.0.1
 */