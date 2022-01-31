package com.tencent.mm.al;

import android.os.Looper;
import android.os.Message;
import com.tencent.mars.BaseEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;

final class b$1
  extends ak
{
  b$1(b paramb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(78030);
    if (at.isConnected(ah.getContext()))
    {
      ab.i("MicroMsg.CdnTransportService", "cdntra mm on network change to get dns.");
      h.qsU.idkeyStat(546L, 5L, 1L, true);
      BaseEvent.onNetworkChange();
    }
    AppMethodBeat.o(78030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.b.1
 * JD-Core Version:    0.7.0.1
 */