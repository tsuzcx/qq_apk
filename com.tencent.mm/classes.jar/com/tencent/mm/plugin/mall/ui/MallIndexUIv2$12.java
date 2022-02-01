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

final class MallIndexUIv2$12
  extends IListener<aci>
{
  MallIndexUIv2$12(MallIndexUIv2 paramMallIndexUIv2)
  {
    AppMethodBeat.i(267576);
    this.__eventId = aci.class.getName().hashCode();
    AppMethodBeat.o(267576);
  }
  
  private static boolean a(aci paramaci)
  {
    AppMethodBeat.i(267577);
    paramaci = paramaci.gcD.fGw;
    Log.i("MicorMsg.MallIndexUIv2", "get result %s", new Object[] { paramaci });
    if ("agree_privacy".equals(paramaci))
    {
      h.aHH();
      h.aHG().aHp().set(ar.a.Vvq, Boolean.TRUE);
    }
    AppMethodBeat.o(267577);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2.12
 * JD-Core Version:    0.7.0.1
 */