package com.tencent.mm.plugin.appbrand.jsapi.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  implements a
{
  private static Boolean stL;
  private static Boolean stM;
  private static Boolean stN;
  
  public final boolean a(f paramf, bc parambc)
  {
    AppMethodBeat.i(329497);
    boolean bool;
    if ((paramf == null) || (!paramf.isRunning()) || (parambc == null)) {
      bool = false;
    }
    while (bool)
    {
      AppMethodBeat.o(329497);
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
        else if (!(localk.getRuntime() instanceof w))
        {
          Log.e("MicroMsg.SensorJsEventControllerWx", "hasPermission not AppBrandRuntimeWC");
          bool = false;
        }
        else
        {
          bool = ((w)localk.getRuntime()).evw.a(paramf, parambc.getClass());
        }
      }
    }
    AppMethodBeat.o(329497);
    return false;
  }
  
  public final boolean cuA()
  {
    AppMethodBeat.i(329501);
    if (stL == null)
    {
      stL = Boolean.TRUE;
      Log.i("MicroMsg.SensorJsEventControllerWx", "ignorePublishFrequencyLimit: true");
    }
    boolean bool = stL.booleanValue();
    AppMethodBeat.o(329501);
    return bool;
  }
  
  public final boolean cuB()
  {
    AppMethodBeat.i(329506);
    if (stM == null)
    {
      stM = Boolean.TRUE;
      Log.i("MicroMsg.SensorJsEventControllerWx", "useNewDeviceMotionStrategy: true");
    }
    boolean bool = stM.booleanValue();
    AppMethodBeat.o(329506);
    return bool;
  }
  
  public final boolean cuC()
  {
    AppMethodBeat.i(329510);
    if (stN == null)
    {
      stN = Boolean.TRUE;
      Log.i("MicroMsg.SensorJsEventControllerWx", "disableDispatchJsApi:%b", new Object[] { stN });
    }
    boolean bool = stN.booleanValue();
    AppMethodBeat.o(329510);
    return bool;
  }
  
  public final int cuy()
  {
    return 5;
  }
  
  public final int cuz()
  {
    return 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.j
 * JD-Core Version:    0.7.0.1
 */