package com.tencent.mm.plugin.brandservice.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.z;

public final class a
{
  public static int sTj;
  private static long sTk;
  private static long sTl;
  private static boolean sTm;
  
  static
  {
    AppMethodBeat.i(6235);
    com.tencent.mm.plugin.brandservice.b.h localh = com.tencent.mm.plugin.brandservice.b.h.swx;
    sTj = com.tencent.mm.plugin.brandservice.b.h.czo();
    sTk = 43200000L;
    sTl = 0L;
    sTm = false;
    AppMethodBeat.o(6235);
  }
  
  public static boolean Hv(int paramInt)
  {
    return (sTl & paramInt) != 0L;
  }
  
  public static void Ia(long paramLong)
  {
    sTk = paramLong;
  }
  
  public static void Ib(long paramLong)
  {
    sTl = paramLong;
  }
  
  public static boolean a(z paramz, v paramv)
  {
    AppMethodBeat.i(6233);
    if (paramz == null)
    {
      AppMethodBeat.o(6233);
      return false;
    }
    paramz.Vec = g.apE(paramz.field_talker);
    if ((paramv != null) && ((paramv.type == 5) || (paramv.type == 7) || (paramv.type == 10) || (paramv.type == 8)))
    {
      AppMethodBeat.o(6233);
      return true;
    }
    if (paramz.jQ(1))
    {
      Log.d("MicroMsg.BizTimeLineConfigUtil", "biz flag %d return true, bizClientMsgId:%s", new Object[] { Integer.valueOf(paramz.field_bitFlag), paramz.field_bizClientMsgId });
      AppMethodBeat.o(6233);
      return true;
    }
    if ((Hv(2)) && (paramz.Vec))
    {
      AppMethodBeat.o(6233);
      return true;
    }
    if (Hv(1))
    {
      paramz = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramz.field_talker);
      if ((paramz != null) && (paramz.ayn()))
      {
        AppMethodBeat.o(6233);
        return true;
      }
    }
    AppMethodBeat.o(6233);
    return false;
  }
  
  public static long cEm()
  {
    if (sTk <= 0L) {
      sTk = 43200000L;
    }
    return sTk;
  }
  
  public static void cEn()
  {
    AppMethodBeat.i(6234);
    if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vGM, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      sTm = bool;
      if (MultiProcessMMKV.getSingleMMKV("brandService").decodeInt("BizTimeLineShowDigest", 0) == 1)
      {
        Log.i("MicroMsg.BizTimeLineConfigUtil", "alvinluo initBizTimeLineShowDigest force show");
        sTm = true;
      }
      Log.i("MicroMsg.BizTimeLineConfigUtil", "alvinluo initBizTimeLineShowDigest: %b", new Object[] { Boolean.valueOf(sTm) });
      AppMethodBeat.o(6234);
      return;
    }
  }
  
  public static boolean cEo()
  {
    return sTm;
  }
  
  public static boolean cEp()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.a
 * JD-Core Version:    0.7.0.1
 */