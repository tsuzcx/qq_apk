package com.tencent.mm.plugin.brandservice.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.t;

public final class a
{
  public static int nPA;
  private static long nPB;
  private static long nPC;
  private static boolean nPD;
  
  static
  {
    AppMethodBeat.i(6235);
    com.tencent.mm.plugin.brandservice.b.g localg = com.tencent.mm.plugin.brandservice.b.g.nvq;
    nPA = com.tencent.mm.plugin.brandservice.b.g.bJo();
    nPB = 43200000L;
    nPC = 0L;
    nPD = false;
    AppMethodBeat.o(6235);
  }
  
  public static boolean a(t paramt, v paramv)
  {
    AppMethodBeat.i(6233);
    if (paramt == null)
    {
      AppMethodBeat.o(6233);
      return false;
    }
    paramt.GCa = e.TA(paramt.field_talker);
    if ((paramv != null) && ((paramv.type == 5) || (paramv.type == 7) || (paramv.type == 10) || (paramv.type == 8)))
    {
      AppMethodBeat.o(6233);
      return true;
    }
    if (paramt.hc(1))
    {
      ac.d("MicroMsg.BizTimeLineConfigUtil", "biz flag %d return true, bizClientMsgId:%s", new Object[] { Integer.valueOf(paramt.field_bitFlag), paramt.field_bizClientMsgId });
      AppMethodBeat.o(6233);
      return true;
    }
    if ((zv(2)) && (paramt.GCa))
    {
      AppMethodBeat.o(6233);
      return true;
    }
    if (zv(1))
    {
      paramt = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(paramt.field_talker);
      if ((paramt != null) && (paramt.aaN()))
      {
        AppMethodBeat.o(6233);
        return true;
      }
    }
    AppMethodBeat.o(6233);
    return false;
  }
  
  public static long bNF()
  {
    if (nPB <= 0L) {
      nPB = 43200000L;
    }
    return nPB;
  }
  
  public static void bNG()
  {
    AppMethodBeat.i(6234);
    if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pUL, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      nPD = bool;
      if (aw.aKU("brandService").decodeInt("BizTimeLineShowDigest", 0) == 1)
      {
        ac.i("MicroMsg.BizTimeLineConfigUtil", "alvinluo initBizTimeLineShowDigest force show");
        nPD = true;
      }
      ac.i("MicroMsg.BizTimeLineConfigUtil", "alvinluo initBizTimeLineShowDigest: %b", new Object[] { Boolean.valueOf(nPD) });
      AppMethodBeat.o(6234);
      return;
    }
  }
  
  public static boolean bNH()
  {
    return nPD;
  }
  
  public static boolean bNI()
  {
    return true;
  }
  
  public static boolean f(t paramt)
  {
    AppMethodBeat.i(6232);
    boolean bool = a(paramt, null);
    AppMethodBeat.o(6232);
    return bool;
  }
  
  public static void rw(long paramLong)
  {
    nPB = paramLong;
  }
  
  public static void rx(long paramLong)
  {
    nPC = paramLong;
  }
  
  public static boolean zv(int paramInt)
  {
    return (nPC & paramInt) != 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.a
 * JD-Core Version:    0.7.0.1
 */