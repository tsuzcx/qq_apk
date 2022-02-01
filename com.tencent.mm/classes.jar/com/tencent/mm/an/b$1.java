package com.tencent.mm.an;

import android.os.Looper;
import android.os.Message;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;

final class b$1
  extends ao
{
  b$1(b paramb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(150391);
    if ((!ai.eVb()) && (ax.isConnected(ai.getContext())))
    {
      ac.i("MicroMsg.CdnTransportService", "cdntra mm on network change to get dns.");
      h.wUl.idkeyStat(546L, 5L, 1L, true);
      Mars.onNetworkChange();
    }
    AppMethodBeat.o(150391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.an.b.1
 * JD-Core Version:    0.7.0.1
 */