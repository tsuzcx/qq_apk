package com.tencent.mm.plugin.mall.ui;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aef;
import com.tencent.mm.autogen.a.aef.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

class MallIndexUIv2$3
  extends IListener<aef>
{
  MallIndexUIv2$3(MallIndexUIv2 paramMallIndexUIv2, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(262417);
    this.__eventId = aef.class.getName().hashCode();
    AppMethodBeat.o(262417);
  }
  
  private static boolean a(aef paramaef)
  {
    AppMethodBeat.i(262421);
    paramaef = paramaef.iiP.hLS;
    Log.i("MicorMsg.MallIndexUIv2", "get result %s", new Object[] { paramaef });
    if ("agree_privacy".equals(paramaef))
    {
      h.baF();
      h.baE().ban().set(at.a.acWZ, Boolean.TRUE);
    }
    AppMethodBeat.o(262421);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2.3
 * JD-Core Version:    0.7.0.1
 */