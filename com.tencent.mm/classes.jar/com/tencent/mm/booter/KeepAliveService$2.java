package com.tencent.mm.booter;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class KeepAliveService$2
  implements Runnable
{
  KeepAliveService$2(KeepAliveService paramKeepAliveService) {}
  
  public final void run()
  {
    AppMethodBeat.i(57761);
    nd localnd = new nd();
    a.ymk.a(localnd, Looper.getMainLooper());
    ab.i("MicroMsg.KeepAliveService", "onReceive() publish PushKeepAliveEvent");
    AppMethodBeat.o(57761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.booter.KeepAliveService.2
 * JD-Core Version:    0.7.0.1
 */