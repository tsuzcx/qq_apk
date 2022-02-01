package com.tencent.mm.plugin.finder.view.animation;

import androidx.recyclerview.widget.RecyclerView.v;
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
    Iterator localIterator = this.bUT.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.v localv = (RecyclerView.v)localIterator.next();
      this.GGj.X(localv);
    }
    this.bUT.clear();
    this.GGj.bUJ.remove(this.bUT);
    AppMethodBeat.o(168651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.a.3
 * JD-Core Version:    0.7.0.1
 */