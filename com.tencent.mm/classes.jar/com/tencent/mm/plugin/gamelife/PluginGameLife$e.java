package com.tencent.mm.plugin.gamelife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.a.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class PluginGameLife$e
  implements Runnable
{
  PluginGameLife$e(AtomicInteger paramAtomicInteger, LinkedList paramLinkedList, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(203114);
    if (this.DeW.incrementAndGet() == 2)
    {
      Log.i("GameLife.PluginGameLife", "checkSessionIdAndContact success: " + (String)this.DeX.get(0));
      this.jFa.invoke(this.DeX.get(0));
    }
    AppMethodBeat.o(203114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife.e
 * JD-Core Version:    0.7.0.1
 */