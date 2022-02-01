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

class MallIndexUI$3
  extends IListener<aef>
{
  MallIndexUI$3(MallIndexUI paramMallIndexUI, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(262397);
    this.__eventId = aef.class.getName().hashCode();
    AppMethodBeat.o(262397);
  }
  
  private static boolean a(aef paramaef)
  {
    AppMethodBeat.i(66105);
    paramaef = paramaef.iiP.hLS;
    Log.i("MicorMsg.MallIndexUI", "get result %s", new Object[] { paramaef });
    if ("agree_privacy".equals(paramaef))
    {
      h.baF();
      h.baE().ban().set(at.a.acWZ, Boolean.TRUE);
    }
    AppMethodBeat.o(66105);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.3
 * JD-Core Version:    0.7.0.1
 */