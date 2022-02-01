package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zn;
import com.tencent.mm.g.a.zn.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

final class MallIndexUI$8
  extends c<zn>
{
  MallIndexUI$8(MallIndexUI paramMallIndexUI)
  {
    AppMethodBeat.i(160813);
    this.__eventId = zn.class.getName().hashCode();
    AppMethodBeat.o(160813);
  }
  
  private static boolean a(zn paramzn)
  {
    AppMethodBeat.i(66105);
    paramzn = paramzn.dOT.duy;
    ad.i("MicorMsg.MallIndexUI", "get result %s", new Object[] { paramzn });
    if ("agree_privacy".equals(paramzn))
    {
      g.ajD();
      g.ajC().ajl().set(al.a.IEd, Boolean.TRUE);
    }
    AppMethodBeat.o(66105);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.8
 * JD-Core Version:    0.7.0.1
 */