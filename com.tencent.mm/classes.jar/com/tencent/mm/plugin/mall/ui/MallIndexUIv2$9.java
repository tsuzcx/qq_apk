package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.g.a.zt.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

final class MallIndexUIv2$9
  extends c<zt>
{
  MallIndexUIv2$9(MallIndexUIv2 paramMallIndexUIv2)
  {
    AppMethodBeat.i(189891);
    this.__eventId = zt.class.getName().hashCode();
    AppMethodBeat.o(189891);
  }
  
  private static boolean a(zt paramzt)
  {
    AppMethodBeat.i(189892);
    paramzt = paramzt.dQj.dvD;
    ae.i("MicorMsg.MallIndexNewUI", "get result %s", new Object[] { paramzt });
    if ("agree_privacy".equals(paramzt))
    {
      g.ajS();
      g.ajR().ajA().set(am.a.IYD, Boolean.TRUE);
    }
    AppMethodBeat.o(189892);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2.9
 * JD-Core Version:    0.7.0.1
 */