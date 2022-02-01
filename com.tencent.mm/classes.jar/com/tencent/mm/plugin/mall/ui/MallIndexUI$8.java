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

final class MallIndexUI$8
  extends c<zt>
{
  MallIndexUI$8(MallIndexUI paramMallIndexUI)
  {
    AppMethodBeat.i(160813);
    this.__eventId = zt.class.getName().hashCode();
    AppMethodBeat.o(160813);
  }
  
  private static boolean a(zt paramzt)
  {
    AppMethodBeat.i(66105);
    paramzt = paramzt.dQj.dvD;
    ae.i("MicorMsg.MallIndexUI", "get result %s", new Object[] { paramzt });
    if ("agree_privacy".equals(paramzt))
    {
      g.ajS();
      g.ajR().ajA().set(am.a.IYD, Boolean.TRUE);
    }
    AppMethodBeat.o(66105);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.8
 * JD-Core Version:    0.7.0.1
 */