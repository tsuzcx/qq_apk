package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aba;
import com.tencent.mm.g.a.aba.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class MallIndexUI$8
  extends IListener<aba>
{
  MallIndexUI$8(MallIndexUI paramMallIndexUI)
  {
    AppMethodBeat.i(160813);
    this.__eventId = aba.class.getName().hashCode();
    AppMethodBeat.o(160813);
  }
  
  private static boolean a(aba paramaba)
  {
    AppMethodBeat.i(66105);
    paramaba = paramaba.eim.dNk;
    Log.i("MicorMsg.MallIndexUI", "get result %s", new Object[] { paramaba });
    if ("agree_privacy".equals(paramaba))
    {
      g.aAi();
      g.aAh().azQ().set(ar.a.Oha, Boolean.TRUE);
    }
    AppMethodBeat.o(66105);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.8
 * JD-Core Version:    0.7.0.1
 */