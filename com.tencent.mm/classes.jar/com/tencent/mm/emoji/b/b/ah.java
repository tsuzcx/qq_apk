package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "TAG", "", "lifeCycles", "Ljava/util/LinkedList;", "clear", "", "keep", "iLifeCycle", "plugin-emojisdk_release"})
public final class ah
  implements b<a>
{
  private final String TAG;
  private final LinkedList<a> jKd;
  
  public ah()
  {
    AppMethodBeat.i(226015);
    this.TAG = "MicroMsg.PanelLifeCycle";
    this.jKd = new LinkedList();
    AppMethodBeat.o(226015);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(226013);
    Log.i(this.TAG, "clear: ");
    Iterator localIterator = ((Iterable)this.jKd).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).dead();
    }
    this.jKd.clear();
    AppMethodBeat.o(226013);
  }
  
  public final void keep(a parama)
  {
    AppMethodBeat.i(226010);
    p.k(parama, "iLifeCycle");
    Log.i(this.TAG, "keep: ".concat(String.valueOf(parama)));
    if (!this.jKd.contains(parama)) {
      this.jKd.add(parama);
    }
    AppMethodBeat.o(226010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.ah
 * JD-Core Version:    0.7.0.1
 */