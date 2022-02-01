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

final class MallIndexUIv2$9
  extends c<zn>
{
  MallIndexUIv2$9(MallIndexUIv2 paramMallIndexUIv2)
  {
    AppMethodBeat.i(199056);
    this.__eventId = zn.class.getName().hashCode();
    AppMethodBeat.o(199056);
  }
  
  private static boolean a(zn paramzn)
  {
    AppMethodBeat.i(199057);
    paramzn = paramzn.dOT.duy;
    ad.i("MicorMsg.MallIndexNewUI", "get result %s", new Object[] { paramzn });
    if ("agree_privacy".equals(paramzn))
    {
      g.ajD();
      g.ajC().ajl().set(al.a.IEd, Boolean.TRUE);
    }
    AppMethodBeat.o(199057);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2.9
 * JD-Core Version:    0.7.0.1
 */