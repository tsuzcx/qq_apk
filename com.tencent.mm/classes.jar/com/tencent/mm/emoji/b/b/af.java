package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "TAG", "", "lifeCycles", "Ljava/util/LinkedList;", "clear", "", "keep", "iLifeCycle", "plugin-emojisdk_release"})
public final class af
  implements b<a>
{
  private final String TAG;
  private final LinkedList<a> gZd;
  
  public af()
  {
    AppMethodBeat.i(199925);
    this.TAG = "MicroMsg.PanelLifeCycle";
    this.gZd = new LinkedList();
    AppMethodBeat.o(199925);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(199924);
    Log.i(this.TAG, "clear: ");
    Iterator localIterator = ((Iterable)this.gZd).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).dead();
    }
    this.gZd.clear();
    AppMethodBeat.o(199924);
  }
  
  public final void keep(a parama)
  {
    AppMethodBeat.i(199923);
    p.h(parama, "iLifeCycle");
    Log.i(this.TAG, "keep: ".concat(String.valueOf(parama)));
    if (!this.gZd.contains(parama)) {
      this.gZd.add(parama);
    }
    AppMethodBeat.o(199923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.af
 * JD-Core Version:    0.7.0.1
 */