package com.tencent.mm.plugin.appbrand.jsapi.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  implements a
{
  private static Boolean mqQ;
  private static Boolean mqR;
  
  public final boolean a(f paramf, bc parambc)
  {
    AppMethodBeat.i(226979);
    boolean bool;
    if ((paramf == null) || (!paramf.isRunning()) || (parambc == null)) {
      bool = false;
    }
    while (bool)
    {
      AppMethodBeat.o(226979);
      return true;
      if (!(paramf instanceof k))
      {
        Log.e("MicroMsg.SensorJsEventControllerWx", "hasPermission AppBrandComponentWithExtra");
        bool = false;
      }
      else
      {
        k localk = (k)paramf;
        if (localk.getRuntime() == null)
        {
          Log.e("MicroMsg.SensorJsEventControllerWx", "runtime is null, return");
          bool = false;
        }
        else if (!(localk.getRuntime() instanceof q))
        {
          Log.e("MicroMsg.SensorJsEventControllerWx", "hasPermission not AppBrandRuntimeWC");
          bool = false;
        }
        else
        {
          bool = ((q)localk.getRuntime()).cCn.a(paramf, parambc.getClass());
        }
      }
    }
    AppMethodBeat.o(226979);
    return false;
  }
  
  public final int bID()
  {
    return 5;
  }
  
  public final int bIE()
  {
    return 20;
  }
  
  public final boolean bIF()
  {
    AppMethodBeat.i(226980);
    if (mqQ == null) {
      if (((b)g.af(b.class)).a(b.a.rVI, 0) != 1) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      mqQ = Boolean.valueOf(bool);
      Log.i("MicroMsg.SensorJsEventControllerWx", "ignorePublishFrequencyLimit:%b", new Object[] { mqQ });
      bool = mqQ.booleanValue();
      AppMethodBeat.o(226980);
      return bool;
    }
  }
  
  public final boolean bIG()
  {
    AppMethodBeat.i(226981);
    if (mqR == null) {
      if (((b)g.af(b.class)).a(b.a.rVJ, 0) != 1) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      mqR = Boolean.valueOf(bool);
      Log.i("MicroMsg.SensorJsEventControllerWx", "useNewDeviceMotionStrategy:%b", new Object[] { mqR });
      bool = mqR.booleanValue();
      AppMethodBeat.o(226981);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.j
 * JD-Core Version:    0.7.0.1
 */