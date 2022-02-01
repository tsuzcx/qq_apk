package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "TAG", "", "lifeCycles", "Ljava/util/LinkedList;", "clear", "", "keep", "iLifeCycle", "plugin-emojisdk_release"})
public final class af
  implements b<a>
{
  private final String TAG;
  private final LinkedList<a> goj;
  
  public af()
  {
    AppMethodBeat.i(188568);
    this.TAG = "MicroMsg.PanelLifeCycle";
    this.goj = new LinkedList();
    AppMethodBeat.o(188568);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(188567);
    ae.i(this.TAG, "clear: ");
    Iterator localIterator = ((Iterable)this.goj).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).dead();
    }
    this.goj.clear();
    AppMethodBeat.o(188567);
  }
  
  public final void keep(a parama)
  {
    AppMethodBeat.i(188566);
    p.h(parama, "iLifeCycle");
    ae.i(this.TAG, "keep: ".concat(String.valueOf(parama)));
    if (!this.goj.contains(parama)) {
      this.goj.add(parama);
    }
    AppMethodBeat.o(188566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.af
 * JD-Core Version:    0.7.0.1
 */