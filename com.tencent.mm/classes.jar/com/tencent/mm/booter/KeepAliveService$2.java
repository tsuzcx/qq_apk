package com.tencent.mm.booter;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pi;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;

final class KeepAliveService$2
  implements Runnable
{
  KeepAliveService$2(KeepAliveService paramKeepAliveService) {}
  
  public final void run()
  {
    AppMethodBeat.i(131877);
    pi localpi = new pi();
    a.IbL.a(localpi, Looper.getMainLooper());
    ad.i("MicroMsg.KeepAliveService", "onReceive() publish PushKeepAliveEvent");
    AppMethodBeat.o(131877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.KeepAliveService.2
 * JD-Core Version:    0.7.0.1
 */