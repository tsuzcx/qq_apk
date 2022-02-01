package com.tencent.mm.plugin.appbrand.jsapi.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.utils.af;
import com.tencent.mm.plugin.appbrand.utils.af.a;
import com.tencent.mm.plugin.appbrand.utils.af.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONObject;

public final class e
  extends aa
{
  public static final int CTRL_INDEX = 472;
  public static final String NAME = "enableDeviceOrientationChangeListening";
  private boolean poG;
  protected af poH;
  private af.b poI;
  
  public e()
  {
    AppMethodBeat.i(137634);
    this.poG = false;
    this.poI = new af.b()
    {
      public final void a(af.a paramAnonymousa1, final af.a paramAnonymousa2)
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
  
  public final String a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137635);
    if (paramJSONObject.optBoolean("enable", false))
    {
      h.D(parame);
      if (!this.poG)
      {
        this.poH = new af(parame.getContext(), this.poI);
        this.poH.enable();
        this.poG = true;
      }
    }
    for (;;)
    {
      parame = h("ok", null);
      AppMethodBeat.o(137635);
      return parame;
      h.E(parame);
      if (this.poG)
      {
        this.poH.disable();
        this.poH = null;
        this.poG = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.e
 * JD-Core Version:    0.7.0.1
 */