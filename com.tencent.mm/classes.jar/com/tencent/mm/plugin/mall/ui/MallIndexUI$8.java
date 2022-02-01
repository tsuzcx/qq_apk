package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aci;
import com.tencent.mm.f.a.aci.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class MallIndexUI$8
  extends IListener<aci>
{
  MallIndexUI$8(MallIndexUI paramMallIndexUI)
  {
    AppMethodBeat.i(160813);
    this.__eventId = aci.class.getName().hashCode();
    AppMethodBeat.o(160813);
  }
  
  private static boolean a(aci paramaci)
  {
    AppMethodBeat.i(66105);
    paramaci = paramaci.gcD.fGw;
    Log.i("MicorMsg.MallIndexUI", "get result %s", new Object[] { paramaci });
    if ("agree_privacy".equals(paramaci))
    {
      h.aHH();
      h.aHG().aHp().set(ar.a.Vvq, Boolean.TRUE);
    }
    AppMethodBeat.o(66105);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.8
 * JD-Core Version:    0.7.0.1
 */