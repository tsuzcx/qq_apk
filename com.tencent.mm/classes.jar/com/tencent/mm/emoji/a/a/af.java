package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "TAG", "", "lifeCycles", "Ljava/util/LinkedList;", "clear", "", "keep", "iLifeCycle", "plugin-emojisdk_release"})
public final class af
  implements b<a>
{
  private final String TAG;
  private final LinkedList<a> glO;
  
  public af()
  {
    AppMethodBeat.i(218954);
    this.TAG = "MicroMsg.PanelLifeCycle";
    this.glO = new LinkedList();
    AppMethodBeat.o(218954);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(218953);
    ad.i(this.TAG, "clear: ");
    Iterator localIterator = ((Iterable)this.glO).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).dead();
    }
    this.glO.clear();
    AppMethodBeat.o(218953);
  }
  
  public final void keep(a parama)
  {
    AppMethodBeat.i(218952);
    p.h(parama, "iLifeCycle");
    ad.i(this.TAG, "keep: ".concat(String.valueOf(parama)));
    if (!this.glO.contains(parama)) {
      this.glO.add(parama);
    }
    AppMethodBeat.o(218952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.af
 * JD-Core Version:    0.7.0.1
 */