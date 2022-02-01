package com.tencent.mm.plugin.brandservice.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;

public final class b
{
  private static long vYA;
  private static long vYB;
  private static boolean vYC;
  public static int vYz;
  
  static
  {
    AppMethodBeat.i(6235);
    com.tencent.mm.plugin.brandservice.model.h localh = com.tencent.mm.plugin.brandservice.model.h.vCa;
    vYz = com.tencent.mm.plugin.brandservice.model.h.dci();
    vYA = 43200000L;
    vYB = 0L;
    vYC = false;
    AppMethodBeat.o(6235);
  }
  
  public static boolean HX(int paramInt)
  {
    return (vYB & paramInt) != 0L;
  }
  
  public static boolean a(ab paramab, v paramv)
  {
    AppMethodBeat.i(6233);
    if (paramab == null)
    {
      AppMethodBeat.o(6233);
      return false;
    }
    paramab.acFw = g.ajf(paramab.field_talker);
    if ((paramv != null) && ((paramv.type == 5) || (paramv.type == 7) || (paramv.type == 10) || (paramv.type == 8)))
    {
      AppMethodBeat.o(6233);
      return true;
    }
    if (paramab.nG(1))
    {
      Log.d("MicroMsg.BizTimeLineConfigUtil", "biz flag %d return true, bizClientMsgId:%s", new Object[] { Integer.valueOf(paramab.field_bitFlag), paramab.field_bizClientMsgId });
      AppMethodBeat.o(6233);
      return true;
    }
    if ((HX(2)) && (paramab.acFw))
    {
      AppMethodBeat.o(6233);
      return true;
    }
    if (HX(1))
    {
      paramab = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramab.field_talker);
      if ((paramab != null) && (paramab.aSQ()))
      {
        AppMethodBeat.o(6233);
        return true;
      }
    }
    AppMethodBeat.o(6233);
    return false;
  }
  
  public static long dhO()
  {
    if (vYA <= 0L) {
      vYA = 43200000L;
    }
    return vYA;
  }
  
  public static void dhP()
  {
    AppMethodBeat.i(6234);
    vYC = true;
    Log.i("MicroMsg.BizTimeLineConfigUtil", "alvinluo initBizTimeLineShowDigest: %b", new Object[] { Boolean.valueOf(vYC) });
    AppMethodBeat.o(6234);
  }
  
  public static boolean dhQ()
  {
    return vYC;
  }
  
  public static boolean dhR()
  {
    return true;
  }
  
  public static void ks(long paramLong)
  {
    vYA = paramLong;
  }
  
  public static void kt(long paramLong)
  {
    vYB = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.b
 * JD-Core Version:    0.7.0.1
 */