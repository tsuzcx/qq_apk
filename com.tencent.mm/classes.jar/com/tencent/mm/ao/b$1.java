package com.tencent.mm.ao;

import android.os.Looper;
import android.os.Message;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;

final class b$1
  extends ap
{
  b$1(b paramb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(150391);
    if ((!aj.eFH()) && (ay.isConnected(aj.getContext())))
    {
      ad.i("MicroMsg.CdnTransportService", "cdntra mm on network change to get dns.");
      h.vKh.idkeyStat(546L, 5L, 1L, true);
      Mars.onNetworkChange();
    }
    AppMethodBeat.o(150391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ao.b.1
 * JD-Core Version:    0.7.0.1
 */