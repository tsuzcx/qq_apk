package com.tencent.mm.plugin.brandservice.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.d;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public final class a
{
  public static int kiQ = 180;
  private static long kiR = 43200000L;
  private static long kiS = 0L;
  private static boolean kiT = false;
  
  public static boolean a(com.tencent.mm.storage.q paramq, com.tencent.mm.af.q paramq1)
  {
    AppMethodBeat.i(152661);
    if (paramq == null)
    {
      AppMethodBeat.o(152661);
      return false;
    }
    paramq.ywB = d.GO(paramq.field_talker);
    if ((paramq1 != null) && ((paramq1.type == 5) || (paramq1.type == 7) || (paramq1.type == 8)))
    {
      AppMethodBeat.o(152661);
      return true;
    }
    if (paramq.dvZ())
    {
      AppMethodBeat.o(152661);
      return true;
    }
    if ((sM(2)) && (paramq.ywB))
    {
      AppMethodBeat.o(152661);
      return true;
    }
    if (sM(1))
    {
      paramq = ((j)g.E(j.class)).YA().arw(paramq.field_talker);
      if ((paramq != null) && (paramq.Oa()))
      {
        AppMethodBeat.o(152661);
        return true;
      }
    }
    AppMethodBeat.o(152661);
    return false;
  }
  
  public static long aZU()
  {
    if (kiR <= 0L) {
      kiR = 43200000L;
    }
    return kiR;
  }
  
  public static void aZV()
  {
    AppMethodBeat.i(152662);
    if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lWe, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      kiT = bool;
      if (as.eu("brandService", 1).decodeInt("BizTimeLineShowDigest", 0) == 1)
      {
        ab.i("MicroMsg.BizTimeLineConfigUtil", "alvinluo initBizTimeLineShowDigest force show");
        kiT = true;
      }
      ab.i("MicroMsg.BizTimeLineConfigUtil", "alvinluo initBizTimeLineShowDigest: %b", new Object[] { Boolean.valueOf(kiT) });
      AppMethodBeat.o(152662);
      return;
    }
  }
  
  public static boolean aZW()
  {
    return kiT;
  }
  
  public static boolean f(com.tencent.mm.storage.q paramq)
  {
    AppMethodBeat.i(14446);
    boolean bool = a(paramq, null);
    AppMethodBeat.o(14446);
    return bool;
  }
  
  public static void ic(long paramLong)
  {
    kiR = paramLong;
  }
  
  public static void id(long paramLong)
  {
    kiS = paramLong;
  }
  
  public static boolean sM(int paramInt)
  {
    return (kiS & paramInt) != 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.a
 * JD-Core Version:    0.7.0.1
 */