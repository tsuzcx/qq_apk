package com.tencent.mm.plugin.appbrand.device_discovery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.plugin.appbrand.debugger.console.ConsoleDebugLogImpl;
import com.tencent.mm.plugin.appbrand.debugger.console.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/device_discovery/DeviceDiscoveryLog;", "", "()V", "LOG_TO_CONSOLE", "", "getLOG_TO_CONSOLE$annotations", "d", "", "tag", "", "msg", "e", "i", "v", "w", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a rfZ;
  private static final boolean rga;
  
  static
  {
    AppMethodBeat.i(321629);
    rfZ = new a();
    t localt = t.raH;
    if (t.bnM()) {}
    for (boolean bool = true;; bool = false)
    {
      rga = bool;
      AppMethodBeat.o(321629);
      return;
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(321603);
    s.u(paramString1, "tag");
    s.u(paramString2, "msg");
    Log.d(paramString1, paramString2);
    if (rga)
    {
      f localf = f.rfJ;
      f.cmg().logD(0L, null, null, null, 0, 0, 0L, 0L, paramString1 + ": " + paramString2);
    }
    AppMethodBeat.o(321603);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(321612);
    s.u(paramString1, "tag");
    s.u(paramString2, "msg");
    Log.i(paramString1, paramString2);
    if (rga)
    {
      f localf = f.rfJ;
      f.cmg().logI(0L, null, null, null, 0, 0, 0L, 0L, paramString1 + ": " + paramString2);
    }
    AppMethodBeat.o(321612);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(321622);
    s.u(paramString1, "tag");
    s.u(paramString2, "msg");
    Log.w(paramString1, paramString2);
    if (rga)
    {
      f localf = f.rfJ;
      f.cmg().logW(0L, null, null, null, 0, 0, 0L, 0L, paramString1 + ": " + paramString2);
    }
    AppMethodBeat.o(321622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.a
 * JD-Core Version:    0.7.0.1
 */