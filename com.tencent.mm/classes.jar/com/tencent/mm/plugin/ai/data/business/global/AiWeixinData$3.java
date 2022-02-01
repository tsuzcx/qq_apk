package com.tencent.mm.plugin.ai.data.business.global;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.mh;
import com.tencent.mm.autogen.a.mh.a;
import com.tencent.mm.autogen.mmdata.rpt.k;
import com.tencent.mm.plugin.ai.d.d;
import com.tencent.mm.plugin.ai.d.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

class AiWeixinData$3
  extends IListener<mh>
{
  AiWeixinData$3(f paramf, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(267540);
    this.__eventId = mh.class.getName().hashCode();
    AppMethodBeat.o(267540);
  }
  
  private boolean a(mh parammh)
  {
    AppMethodBeat.i(267550);
    long l = Util.currentTicks();
    if (parammh != null) {}
    try
    {
      if (parammh.hOs != null)
      {
        k localk = this.qmK.qmI;
        localk.ikx = parammh.hOs.hOt;
        localk = localk.ep(parammh.hOs.hOu);
        localk.ikz = parammh.hOs.hOv;
        localk.ke(parammh.hOs.latitude).kd(parammh.hOs.longitude);
        parammh = this.qmK.qmI;
        e.caH().qpt.save("last_gps_info", parammh.aIE());
      }
      label141:
      Log.i("MicroMsg.AiWeixinData", "note gps info cost [%s]", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(267550);
      return false;
    }
    catch (Exception parammh)
    {
      break label141;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.global.AiWeixinData.3
 * JD-Core Version:    0.7.0.1
 */