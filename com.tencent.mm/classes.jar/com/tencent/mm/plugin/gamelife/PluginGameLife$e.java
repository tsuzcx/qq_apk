package com.tencent.mm.plugin.gamelife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.b;
import d.l;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class PluginGameLife$e
  implements Runnable
{
  PluginGameLife$e(AtomicInteger paramAtomicInteger, LinkedList paramLinkedList, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(211957);
    if (this.uIe.incrementAndGet() == 2)
    {
      ae.i("GameLife.PluginGameLife", "checkSessionIdAndContact success: " + (String)this.uIf.get(0));
      this.gll.invoke(this.uIf.get(0));
    }
    AppMethodBeat.o(211957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife.e
 * JD-Core Version:    0.7.0.1
 */