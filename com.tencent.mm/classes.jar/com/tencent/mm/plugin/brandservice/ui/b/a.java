package com.tencent.mm.plugin.brandservice.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.w;

public final class a
{
  public static int oyH;
  private static long oyI;
  private static long oyJ;
  private static boolean oyK;
  
  static
  {
    AppMethodBeat.i(6235);
    com.tencent.mm.plugin.brandservice.b.g localg = com.tencent.mm.plugin.brandservice.b.g.ocx;
    oyH = com.tencent.mm.plugin.brandservice.b.g.bOE();
    oyI = 43200000L;
    oyJ = 0L;
    oyK = false;
    AppMethodBeat.o(6235);
  }
  
  public static boolean Aq(int paramInt)
  {
    return (oyJ & paramInt) != 0L;
  }
  
  public static boolean a(w paramw, v paramv)
  {
    AppMethodBeat.i(6233);
    if (paramw == null)
    {
      AppMethodBeat.o(6233);
      return false;
    }
    paramw.IIE = e.XT(paramw.field_talker);
    if ((paramv != null) && ((paramv.type == 5) || (paramv.type == 7) || (paramv.type == 10) || (paramv.type == 8)))
    {
      AppMethodBeat.o(6233);
      return true;
    }
    if (paramw.hk(1))
    {
      ae.d("MicroMsg.BizTimeLineConfigUtil", "biz flag %d return true, bizClientMsgId:%s", new Object[] { Integer.valueOf(paramw.field_bitFlag), paramw.field_bizClientMsgId });
      AppMethodBeat.o(6233);
      return true;
    }
    if ((Aq(2)) && (paramw.IIE))
    {
      AppMethodBeat.o(6233);
      return true;
    }
    if (Aq(1))
    {
      paramw = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramw.field_talker);
      if ((paramw != null) && (paramw.adB()))
      {
        AppMethodBeat.o(6233);
        return true;
      }
    }
    AppMethodBeat.o(6233);
    return false;
  }
  
  public static long bTs()
  {
    if (oyI <= 0L) {
      oyI = 43200000L;
    }
    return oyI;
  }
  
  public static void bTt()
  {
    AppMethodBeat.i(6234);
    if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qGx, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      oyK = bool;
      if (ay.aRX("brandService").decodeInt("BizTimeLineShowDigest", 0) == 1)
      {
        ae.i("MicroMsg.BizTimeLineConfigUtil", "alvinluo initBizTimeLineShowDigest force show");
        oyK = true;
      }
      ae.i("MicroMsg.BizTimeLineConfigUtil", "alvinluo initBizTimeLineShowDigest: %b", new Object[] { Boolean.valueOf(oyK) });
      AppMethodBeat.o(6234);
      return;
    }
  }
  
  public static boolean bTu()
  {
    return oyK;
  }
  
  public static boolean bTv()
  {
    return true;
  }
  
  public static boolean k(w paramw)
  {
    AppMethodBeat.i(6232);
    boolean bool = a(paramw, null);
    AppMethodBeat.o(6232);
    return bool;
  }
  
  public static void tM(long paramLong)
  {
    oyI = paramLong;
  }
  
  public static void tN(long paramLong)
  {
    oyJ = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.a
 * JD-Core Version:    0.7.0.1
 */