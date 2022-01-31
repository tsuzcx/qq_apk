package com.tencent.mm.plugin.appbrand.config;

import android.os.HandlerThread;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

final class o$3$2
  implements MessageQueue.IdleHandler
{
  o$3$2(o.3 param3) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(129874);
    this.hjy.hjx.oNc.quit();
    AppMethodBeat.o(129874);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.o.3.2
 * JD-Core Version:    0.7.0.1
 */