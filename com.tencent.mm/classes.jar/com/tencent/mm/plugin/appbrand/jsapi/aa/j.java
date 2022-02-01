package com.tencent.mm.plugin.appbrand.jsapi.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  implements a
{
  private static Boolean poX;
  private static Boolean poY;
  private static Boolean poZ;
  
  public final boolean a(e parame, az paramaz)
  {
    AppMethodBeat.i(271629);
    boolean bool;
    if ((parame == null) || (!parame.isRunning()) || (paramaz == null)) {
      bool = false;
    }
    while (bool)
    {
      AppMethodBeat.o(271629);
      return true;
      if (!(parame instanceof com.tencent.mm.plugin.appbrand.jsapi.j))
      {
        Log.e("MicroMsg.SensorJsEventControllerWx", "hasPermission AppBrandComponentWithExtra");
        bool = false;
      }
      else
      {
        com.tencent.mm.plugin.appbrand.jsapi.j localj = (com.tencent.mm.plugin.appbrand.jsapi.j)parame;
        if (localj.getRuntime() == null)
        {
          Log.e("MicroMsg.SensorJsEventControllerWx", "runtime is null, return");
          bool = false;
        }
        else if (!(localj.getRuntime() instanceof t))
        {
          Log.e("MicroMsg.SensorJsEventControllerWx", "hasPermission not AppBrandRuntimeWC");
          bool = false;
        }
        else
        {
          bool = ((t)localj.getRuntime()).cCQ.a(parame, paramaz.getClass());
        }
      }
    }
    AppMethodBeat.o(271629);
    return false;
  }
  
  public final int bUl()
  {
    return 5;
  }
  
  public final int bUm()
  {
    return 20;
  }
  
  public final boolean bUn()
  {
    AppMethodBeat.i(271631);
    if (poX == null)
    {
      poX = Boolean.TRUE;
      Log.i("MicroMsg.SensorJsEventControllerWx", "ignorePublishFrequencyLimit: true");
    }
    boolean bool = poX.booleanValue();
    AppMethodBeat.o(271631);
    return bool;
  }
  
  public final boolean bUo()
  {
    AppMethodBeat.i(271633);
    if (poY == null)
    {
      poY = Boolean.TRUE;
      Log.i("MicroMsg.SensorJsEventControllerWx", "useNewDeviceMotionStrategy: true");
    }
    boolean bool = poY.booleanValue();
    AppMethodBeat.o(271633);
    return bool;
  }
  
  public final boolean bUp()
  {
    AppMethodBeat.i(271636);
    if (poZ == null) {
      if (((b)h.ae(b.class)).a(b.a.vCi, 0) != 1) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      poZ = Boolean.valueOf(bool);
      Log.i("MicroMsg.SensorJsEventControllerWx", "disableDispatchJsApi:%b", new Object[] { poZ });
      bool = poZ.booleanValue();
      AppMethodBeat.o(271636);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.j
 * JD-Core Version:    0.7.0.1
 */