package com.tencent.mm.plugin.brandservice.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.s;

public final class a
{
  public static int nmA;
  private static long nmB;
  private static long nmC;
  private static boolean nmD;
  
  static
  {
    AppMethodBeat.i(6235);
    h localh = h.mSY;
    nmA = h.bCl();
    nmB = 43200000L;
    nmC = 0L;
    nmD = false;
    AppMethodBeat.o(6235);
  }
  
  public static boolean a(s params, v paramv)
  {
    AppMethodBeat.i(6233);
    if (params == null)
    {
      AppMethodBeat.o(6233);
      return false;
    }
    params.Feq = e.Pp(params.field_talker);
    if ((paramv != null) && ((paramv.type == 5) || (paramv.type == 7) || (paramv.type == 10) || (paramv.type == 8)))
    {
      AppMethodBeat.o(6233);
      return true;
    }
    if (params.eJT())
    {
      ad.d("MicroMsg.BizTimeLineConfigUtil", "biz flag %d return true, bizClientMsgId:%s", new Object[] { Integer.valueOf(params.field_bitFlag), params.field_bizClientMsgId });
      AppMethodBeat.o(6233);
      return true;
    }
    if ((yF(2)) && (params.Feq))
    {
      AppMethodBeat.o(6233);
      return true;
    }
    if (yF(1))
    {
      params = ((k)g.ab(k.class)).apM().aHY(params.field_talker);
      if ((params != null) && (params.ZS()))
      {
        AppMethodBeat.o(6233);
        return true;
      }
    }
    AppMethodBeat.o(6233);
    return false;
  }
  
  public static long bGs()
  {
    if (nmB <= 0L) {
      nmB = 43200000L;
    }
    return nmB;
  }
  
  public static void bGt()
  {
    AppMethodBeat.i(6234);
    if (((b)g.ab(b.class)).a(b.a.pqY, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      nmD = bool;
      if (ax.aFD("brandService").decodeInt("BizTimeLineShowDigest", 0) == 1)
      {
        ad.i("MicroMsg.BizTimeLineConfigUtil", "alvinluo initBizTimeLineShowDigest force show");
        nmD = true;
      }
      ad.i("MicroMsg.BizTimeLineConfigUtil", "alvinluo initBizTimeLineShowDigest: %b", new Object[] { Boolean.valueOf(nmD) });
      AppMethodBeat.o(6234);
      return;
    }
  }
  
  public static boolean bGu()
  {
    return nmD;
  }
  
  public static boolean bGv()
  {
    return true;
  }
  
  public static boolean f(s params)
  {
    AppMethodBeat.i(6232);
    boolean bool = a(params, null);
    AppMethodBeat.o(6232);
    return bool;
  }
  
  public static void nK(long paramLong)
  {
    nmB = paramLong;
  }
  
  public static void nL(long paramLong)
  {
    nmC = paramLong;
  }
  
  public static boolean yF(int paramInt)
  {
    return (nmC & paramInt) != 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.a
 * JD-Core Version:    0.7.0.1
 */