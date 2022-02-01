package com.tencent.mm.an;

import android.os.Looper;
import android.os.Message;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

final class b$1
  extends MMHandler
{
  b$1(b paramb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(150391);
    if ((!MMApplicationContext.isPushProcess()) && (NetStatusUtil.isConnected(MMApplicationContext.getContext())))
    {
      Log.i("MicroMsg.CdnTransportService", "cdntra mm on network change to get dns.");
      h.CyF.idkeyStat(546L, 5L, 1L, true);
      Mars.onNetworkChange();
    }
    AppMethodBeat.o(150391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.b.1
 * JD-Core Version:    0.7.0.1
 */