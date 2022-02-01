package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yi;
import com.tencent.mm.g.a.yi.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

final class MallIndexUI$8
  extends c<yi>
{
  MallIndexUI$8(MallIndexUI paramMallIndexUI)
  {
    AppMethodBeat.i(160813);
    this.__eventId = yi.class.getName().hashCode();
    AppMethodBeat.o(160813);
  }
  
  private static boolean a(yi paramyi)
  {
    AppMethodBeat.i(66105);
    paramyi = paramyi.dEU.dld;
    ad.i("MicorMsg.MallIndexUI", "get result %s", new Object[] { paramyi });
    if ("agree_privacy".equals(paramyi))
    {
      g.afC();
      g.afB().afk().set(ae.a.FtF, Boolean.TRUE);
    }
    AppMethodBeat.o(66105);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.8
 * JD-Core Version:    0.7.0.1
 */