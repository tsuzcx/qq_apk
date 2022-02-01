package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.Map.Entry;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/event/base/EventDispatcher$doEvent$1$1"})
final class c$b
  implements Runnable
{
  c$b(Map.Entry paramEntry, c paramc, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(165552);
    ((d)this.rdk.getKey()).a(this.rdm);
    AppMethodBeat.o(165552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.c.b
 * JD-Core Version:    0.7.0.1
 */