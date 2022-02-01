package com.tencent.mm.emoji.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "TAG", "", "lifeCycles", "Ljava/util/LinkedList;", "clear", "", "keep", "iLifeCycle", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
  implements b<a>
{
  private final String TAG;
  private final LinkedList<a> mju;
  
  public ah()
  {
    AppMethodBeat.i(242703);
    this.TAG = "MicroMsg.PanelLifeCycle";
    this.mju = new LinkedList();
    AppMethodBeat.o(242703);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(242707);
    Log.i(this.TAG, "clear: ");
    Iterator localIterator = ((Iterable)this.mju).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).dead();
    }
    this.mju.clear();
    AppMethodBeat.o(242707);
  }
  
  public final void keep(a parama)
  {
    AppMethodBeat.i(242705);
    s.u(parama, "iLifeCycle");
    Log.i(this.TAG, s.X("keep: ", parama));
    if (!this.mju.contains(parama)) {
      this.mju.add(parama);
    }
    AppMethodBeat.o(242705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.ah
 * JD-Core Version:    0.7.0.1
 */