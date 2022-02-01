package com.tencent.mm.plugin.brandservice.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.z;

public final class a
{
  public static int pMl;
  private static long pMm;
  private static long pMn;
  private static boolean pMo;
  
  static
  {
    AppMethodBeat.i(6235);
    com.tencent.mm.plugin.brandservice.b.g localg = com.tencent.mm.plugin.brandservice.b.g.pnw;
    pMl = com.tencent.mm.plugin.brandservice.b.g.clK();
    pMm = 43200000L;
    pMn = 0L;
    pMo = false;
    AppMethodBeat.o(6235);
  }
  
  public static void BR(long paramLong)
  {
    pMm = paramLong;
  }
  
  public static void BS(long paramLong)
  {
    pMn = paramLong;
  }
  
  public static boolean DV(int paramInt)
  {
    return (pMn & paramInt) != 0L;
  }
  
  public static boolean a(z paramz, v paramv)
  {
    AppMethodBeat.i(6233);
    if (paramz == null)
    {
      AppMethodBeat.o(6233);
      return false;
    }
    paramz.NQk = f.ahR(paramz.field_talker);
    if ((paramv != null) && ((paramv.type == 5) || (paramv.type == 7) || (paramv.type == 10) || (paramv.type == 8)))
    {
      AppMethodBeat.o(6233);
      return true;
    }
    if (paramz.iE(1))
    {
      Log.d("MicroMsg.BizTimeLineConfigUtil", "biz flag %d return true, bizClientMsgId:%s", new Object[] { Integer.valueOf(paramz.field_bitFlag), paramz.field_bizClientMsgId });
      AppMethodBeat.o(6233);
      return true;
    }
    if ((DV(2)) && (paramz.NQk))
    {
      AppMethodBeat.o(6233);
      return true;
    }
    if (DV(1))
    {
      paramz = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramz.field_talker);
      if ((paramz != null) && (paramz.arE()))
      {
        AppMethodBeat.o(6233);
        return true;
      }
    }
    AppMethodBeat.o(6233);
    return false;
  }
  
  public static long crd()
  {
    if (pMm <= 0L) {
      pMm = 43200000L;
    }
    return pMm;
  }
  
  public static void cre()
  {
    AppMethodBeat.i(6234);
    if (((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rZM, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      pMo = bool;
      if (MultiProcessMMKV.getSingleMMKV("brandService").decodeInt("BizTimeLineShowDigest", 0) == 1)
      {
        Log.i("MicroMsg.BizTimeLineConfigUtil", "alvinluo initBizTimeLineShowDigest force show");
        pMo = true;
      }
      Log.i("MicroMsg.BizTimeLineConfigUtil", "alvinluo initBizTimeLineShowDigest: %b", new Object[] { Boolean.valueOf(pMo) });
      AppMethodBeat.o(6234);
      return;
    }
  }
  
  public static boolean crf()
  {
    return pMo;
  }
  
  public static boolean crg()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.a
 * JD-Core Version:    0.7.0.1
 */