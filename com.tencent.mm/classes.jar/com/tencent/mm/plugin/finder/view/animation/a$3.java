package com.tencent.mm.plugin.finder.view.animation;

import android.support.v7.widget.RecyclerView.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

final class a$3
  implements Runnable
{
  a$3(a parama, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(168651);
    Iterator localIterator = this.akv.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.w localw = (RecyclerView.w)localIterator.next();
      this.sae.W(localw);
    }
    this.akv.clear();
    this.sae.akl.remove(this.akv);
    AppMethodBeat.o(168651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.a.3
 * JD-Core Version:    0.7.0.1
 */