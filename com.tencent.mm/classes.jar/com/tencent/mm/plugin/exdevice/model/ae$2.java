package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

final class ae$2
  implements t
{
  ae$2(ae paramae) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(235692);
    Log.i("MicroMsg.exdevice.SubCoreExDevice", "iLinkDeviceUpdateListener onNewXmlReceived");
    i.vfP.a(null, null);
    AppMethodBeat.o(235692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ae.2
 * JD-Core Version:    0.7.0.1
 */