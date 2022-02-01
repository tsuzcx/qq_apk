package com.tencent.mm.plugin.brandservice.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.w;

public final class a
{
  public static int osg;
  private static long osh;
  private static long osi;
  private static boolean osj;
  
  static
  {
    AppMethodBeat.i(6235);
    com.tencent.mm.plugin.brandservice.b.g localg = com.tencent.mm.plugin.brandservice.b.g.nWO;
    osg = com.tencent.mm.plugin.brandservice.b.g.bNH();
    osh = 43200000L;
    osi = 0L;
    osj = false;
    AppMethodBeat.o(6235);
  }
  
  public static boolean Ae(int paramInt)
  {
    return (osi & paramInt) != 0L;
  }
  
  public static boolean a(w paramw, v paramv)
  {
    AppMethodBeat.i(6233);
    if (paramw == null)
    {
      AppMethodBeat.o(6233);
      return false;
    }
    paramw.Ioo = e.Xh(paramw.field_talker);
    if ((paramv != null) && ((paramv.type == 5) || (paramv.type == 7) || (paramv.type == 10) || (paramv.type == 8)))
    {
      AppMethodBeat.o(6233);
      return true;
    }
    if (paramw.hj(1))
    {
      ad.d("MicroMsg.BizTimeLineConfigUtil", "biz flag %d return true, bizClientMsgId:%s", new Object[] { Integer.valueOf(paramw.field_bitFlag), paramw.field_bizClientMsgId });
      AppMethodBeat.o(6233);
      return true;
    }
    if ((Ae(2)) && (paramw.Ioo))
    {
      AppMethodBeat.o(6233);
      return true;
    }
    if (Ae(1))
    {
      paramw = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramw.field_talker);
      if ((paramw != null) && (paramw.adq()))
      {
        AppMethodBeat.o(6233);
        return true;
      }
    }
    AppMethodBeat.o(6233);
    return false;
  }
  
  public static long bSf()
  {
    if (osh <= 0L) {
      osh = 43200000L;
    }
    return osh;
  }
  
  public static void bSg()
  {
    AppMethodBeat.i(6234);
    if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qzr, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      osj = bool;
      if (ax.aQA("brandService").decodeInt("BizTimeLineShowDigest", 0) == 1)
      {
        ad.i("MicroMsg.BizTimeLineConfigUtil", "alvinluo initBizTimeLineShowDigest force show");
        osj = true;
      }
      ad.i("MicroMsg.BizTimeLineConfigUtil", "alvinluo initBizTimeLineShowDigest: %b", new Object[] { Boolean.valueOf(osj) });
      AppMethodBeat.o(6234);
      return;
    }
  }
  
  public static boolean bSh()
  {
    return osj;
  }
  
  public static boolean bSi()
  {
    return true;
  }
  
  public static boolean j(w paramw)
  {
    AppMethodBeat.i(6232);
    boolean bool = a(paramw, null);
    AppMethodBeat.o(6232);
    return bool;
  }
  
  public static void tv(long paramLong)
  {
    osh = paramLong;
  }
  
  public static void tw(long paramLong)
  {
    osi = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.a
 * JD-Core Version:    0.7.0.1
 */