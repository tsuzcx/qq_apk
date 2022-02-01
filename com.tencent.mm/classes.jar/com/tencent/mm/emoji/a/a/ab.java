package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "TAG", "", "lifeCycles", "Ljava/util/LinkedList;", "clear", "", "keep", "iLifeCycle", "plugin-emojisdk_release"})
public final class ab
  implements b<a>
{
  private final String TAG;
  private final LinkedList<a> fSk;
  
  public ab()
  {
    AppMethodBeat.i(209829);
    this.TAG = "MicroMsg.PanelLifeCycle";
    this.fSk = new LinkedList();
    AppMethodBeat.o(209829);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(209828);
    ac.i(this.TAG, "clear: ");
    Iterator localIterator = ((Iterable)this.fSk).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).dead();
    }
    this.fSk.clear();
    AppMethodBeat.o(209828);
  }
  
  public final void keep(a parama)
  {
    AppMethodBeat.i(209827);
    k.h(parama, "iLifeCycle");
    ac.i(this.TAG, "keep: ".concat(String.valueOf(parama)));
    if (!this.fSk.contains(parama)) {
      this.fSk.add(parama);
    }
    AppMethodBeat.o(209827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.ab
 * JD-Core Version:    0.7.0.1
 */