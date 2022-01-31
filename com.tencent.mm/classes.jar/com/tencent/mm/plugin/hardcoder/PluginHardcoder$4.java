package com.tencent.mm.plugin.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class PluginHardcoder$4
  implements Runnable
{
  PluginHardcoder$4(PluginHardcoder paramPluginHardcoder) {}
  
  public final void run()
  {
    AppMethodBeat.i(60255);
    ab.i("MicroMsg.PluginHardcoder", "reportHardcoderRunnable start to run");
    g.RM();
    long l1 = ((Long)g.RL().Ru().get(ac.a.yDv, Long.valueOf(0L))).longValue();
    long l2 = System.currentTimeMillis();
    if ((l2 - l1 > 86400000L) || (l1 > l2))
    {
      g.RM();
      g.RL().Ru().set(ac.a.yDv, Long.valueOf(l2));
      d.post(new PluginHardcoder.4.1(this), "reportHardCoder");
    }
    AppMethodBeat.o(60255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hardcoder.PluginHardcoder.4
 * JD-Core Version:    0.7.0.1
 */