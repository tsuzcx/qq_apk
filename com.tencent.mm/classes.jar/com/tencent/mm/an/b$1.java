package com.tencent.mm.an;

import android.os.Looper;
import android.os.Message;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.az;

final class b$1
  extends aq
{
  b$1(b paramb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(150391);
    if ((!ak.foA()) && (az.isConnected(ak.getContext())))
    {
      ae.i("MicroMsg.CdnTransportService", "cdntra mm on network change to get dns.");
      g.yxI.idkeyStat(546L, 5L, 1L, true);
      Mars.onNetworkChange();
    }
    AppMethodBeat.o(150391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.an.b.1
 * JD-Core Version:    0.7.0.1
 */