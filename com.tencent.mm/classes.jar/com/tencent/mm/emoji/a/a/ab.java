package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "lifeCycles", "Ljava/util/LinkedList;", "clear", "", "keep", "iLifeCycle", "plugin-emojisdk_release"})
public final class ab
  implements b<a>
{
  private final LinkedList<a> fOz;
  
  public ab()
  {
    AppMethodBeat.i(193394);
    this.fOz = new LinkedList();
    AppMethodBeat.o(193394);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(193393);
    Iterator localIterator = ((Iterable)this.fOz).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).dead();
    }
    this.fOz.clear();
    AppMethodBeat.o(193393);
  }
  
  public final void keep(a parama)
  {
    AppMethodBeat.i(193392);
    k.h(parama, "iLifeCycle");
    if (!this.fOz.contains(parama)) {
      this.fOz.add(parama);
    }
    AppMethodBeat.o(193392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.ab
 * JD-Core Version:    0.7.0.1
 */