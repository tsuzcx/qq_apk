package com.tencent.mm.plugin.hardcoder;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class PluginHardcoder$1
  implements Runnable
{
  PluginHardcoder$1(PluginHardcoder paramPluginHardcoder) {}
  
  public final void run()
  {
    AppMethodBeat.i(60249);
    Thread localThread = Thread.currentThread();
    long l1 = SystemClock.elapsedRealtime();
    WXHardCoderJNI.initHardCoder(a.bHO(), a.bHO());
    long l2 = SystemClock.elapsedRealtime();
    ab.i("MicroMsg.PluginHardcoder", "configure initHardCoder[%d %d %d %d] take[%d]ms tid[%s, %s]", new Object[] { Long.valueOf(com.tencent.mm.kernel.a.a.eIU), Long.valueOf(com.tencent.mm.kernel.a.a.eIV), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - com.tencent.mm.kernel.a.a.eIU), localThread.getName(), Long.valueOf(localThread.getId()) });
    if (ah.brt()) {
      WXHardCoderJNI.registerSystemEventCallback(new PluginHardcoder.1.1(this));
    }
    AppMethodBeat.o(60249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hardcoder.PluginHardcoder.1
 * JD-Core Version:    0.7.0.1
 */