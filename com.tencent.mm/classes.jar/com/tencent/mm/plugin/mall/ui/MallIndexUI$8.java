package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yt;
import com.tencent.mm.g.a.yt.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

final class MallIndexUI$8
  extends c<yt>
{
  MallIndexUI$8(MallIndexUI paramMallIndexUI)
  {
    AppMethodBeat.i(160813);
    this.__eventId = yt.class.getName().hashCode();
    AppMethodBeat.o(160813);
  }
  
  private static boolean a(yt paramyt)
  {
    AppMethodBeat.i(66105);
    paramyt = paramyt.dCG.diM;
    ac.i("MicorMsg.MallIndexUI", "get result %s", new Object[] { paramyt });
    if ("agree_privacy".equals(paramyt))
    {
      g.agS();
      g.agR().agA().set(ah.a.GRz, Boolean.TRUE);
    }
    AppMethodBeat.o(66105);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.8
 * JD-Core Version:    0.7.0.1
 */