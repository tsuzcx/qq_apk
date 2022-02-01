package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ng;
import com.tencent.mm.f.b.a.nh;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Reporter;", "", "()V", "FallbackActionReportFallbackSceneStore", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "FallbackActionReportStructStore", "Lcom/tencent/mm/autogen/mmdata/rpt/WAAppTaskVersionFallBackActionStruct;", "attachFallbackActionReportStruct", "", "instanceId", "reportStruct", "reportUpdateResultAfterVersionFallbackIfNeed", "updateSucceed", "", "updateCostTimeInMs", "", "setFallbackScene", "scene", "FallbackScene", "plugin-appbrand-integration_release"})
public final class ah$b
{
  private static final ConcurrentHashMap<String, nh> pWA;
  private static final ConcurrentHashMap<String, Integer> pWB;
  public static final b pWC;
  
  static
  {
    AppMethodBeat.i(280416);
    pWC = new b();
    pWA = new ConcurrentHashMap();
    pWB = new ConcurrentHashMap();
    AppMethodBeat.o(280416);
  }
  
  public static final void a(String paramString, nh paramnh)
  {
    AppMethodBeat.i(280413);
    p.k(paramString, "instanceId");
    p.k(paramnh, "reportStruct");
    ((Map)pWA).put(paramString, paramnh);
    AppMethodBeat.o(280413);
  }
  
  public static final void b(String paramString, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(280415);
    p.k(paramString, "instanceId");
    Object localObject = (nh)pWA.remove(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(280415);
      return;
    }
    p.j(localObject, "FallbackActionReportStru…ove(instanceId) ?: return");
    ng localng = new ng();
    localng.Eb(((nh)localObject).getAppid());
    localng.Ec(((nh)localObject).getUsername());
    localng.Ed(((nh)localObject).anX());
    localng.zl(((nh)localObject).anR());
    localng.zm(((nh)localObject).anS());
    localng.zn(((nh)localObject).anT());
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localng.zo(i);
      localng.zp(paramLong);
      localng.zq(((nh)localObject).anU());
      localng.Ee(((nh)localObject).anV());
      localng.zr(((nh)localObject).anW());
      localObject = (Integer)pWB.remove(paramString);
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = Integer.valueOf(10000);
      }
      localng.zs(paramString.intValue());
      localng.bpa();
      AppMethodBeat.o(280415);
      return;
    }
  }
  
  public static final void ct(String paramString, int paramInt)
  {
    AppMethodBeat.i(280414);
    p.k(paramString, "instanceId");
    ((Map)pWB).put(paramString, Integer.valueOf(paramInt));
    AppMethodBeat.o(280414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ah.b
 * JD-Core Version:    0.7.0.1
 */