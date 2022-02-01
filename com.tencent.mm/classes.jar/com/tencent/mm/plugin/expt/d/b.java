package com.tencent.mm.plugin.expt.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b
{
  private static Boolean qPF;
  private static ThreadPoolExecutor qPG;
  
  static
  {
    AppMethodBeat.i(210222);
    qPG = new ThreadPoolExecutor(1, 3, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    AppMethodBeat.o(210222);
  }
  
  public static ThreadPoolExecutor cnh()
  {
    return qPG;
  }
  
  public static boolean cni()
  {
    AppMethodBeat.i(210221);
    if (qPF == null) {
      qPF = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHN, true));
    }
    if (!qPF.booleanValue())
    {
      ad.i("EdgeComputingUtils", "[EdgeComputingUtils] isOpenEdgeComputing cloudSwitch isClose!");
      AppMethodBeat.o(210221);
      return false;
    }
    AppMethodBeat.o(210221);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.b
 * JD-Core Version:    0.7.0.1
 */