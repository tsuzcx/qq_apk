package com.tencent.mm.ak;

import android.os.Looper;
import android.os.Message;
import com.tencent.mars.BaseEvent;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  extends ah
{
  b$1(b paramb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (aq.isConnected(ae.getContext()))
    {
      y.i("MicroMsg.CdnTransportService", "cdntra mm on network change to get dns.");
      h.nFQ.a(546L, 5L, 1L, true);
      BaseEvent.onNetworkChange();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ak.b.1
 * JD-Core Version:    0.7.0.1
 */