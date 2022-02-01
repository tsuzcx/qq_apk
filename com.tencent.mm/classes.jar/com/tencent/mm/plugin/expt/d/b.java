package com.tencent.mm.plugin.expt.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b
{
  private static Boolean qXy;
  private static ThreadPoolExecutor qXz;
  
  static
  {
    AppMethodBeat.i(195870);
    qXz = new ThreadPoolExecutor(1, 3, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    AppMethodBeat.o(195870);
  }
  
  public static ay coA()
  {
    AppMethodBeat.i(195864);
    Object localObject = new StringBuilder("mmkv_name_edge_computing_default_");
    d.ctr();
    localObject = ay.aRW(d.getUin());
    AppMethodBeat.o(195864);
    return localObject;
  }
  
  public static ay coB()
  {
    AppMethodBeat.i(195865);
    Object localObject = new StringBuilder("mmkv_name_edge_computing_cache_");
    d.ctr();
    localObject = ay.aRW(d.getUin());
    AppMethodBeat.o(195865);
    return localObject;
  }
  
  public static ay coC()
  {
    AppMethodBeat.i(195866);
    Object localObject = new StringBuilder("mmkv_name_edge_computing_instant_cache_");
    d.ctr();
    localObject = ay.aRW(d.getUin());
    AppMethodBeat.o(195866);
    return localObject;
  }
  
  public static ay coD()
  {
    AppMethodBeat.i(195867);
    Object localObject = new StringBuilder("mmkv_name_edge_computing_config_");
    d.ctr();
    localObject = ay.aRW(d.getUin());
    AppMethodBeat.o(195867);
    return localObject;
  }
  
  public static ay coE()
  {
    AppMethodBeat.i(195868);
    Object localObject = new StringBuilder("mmkv_name_edge_computing_breaker_");
    d.ctr();
    localObject = ay.aRW(d.getUin());
    AppMethodBeat.o(195868);
    return localObject;
  }
  
  public static ay coF()
  {
    AppMethodBeat.i(195869);
    Object localObject = new StringBuilder("mmkv_name_edge_computing_run_record_");
    d.ctr();
    localObject = ay.aRW(d.getUin());
    AppMethodBeat.o(195869);
    return localObject;
  }
  
  public static ThreadPoolExecutor coy()
  {
    return qXz;
  }
  
  public static boolean coz()
  {
    AppMethodBeat.i(195863);
    if (qXy == null) {
      qXy = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPt, true));
    }
    if (!qXy.booleanValue())
    {
      ae.i("EdgeComputingUtils", "[EdgeComputingUtils] isOpenEdgeComputing cloudSwitch isClose!");
      AppMethodBeat.o(195863);
      return false;
    }
    AppMethodBeat.o(195863);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.b
 * JD-Core Version:    0.7.0.1
 */