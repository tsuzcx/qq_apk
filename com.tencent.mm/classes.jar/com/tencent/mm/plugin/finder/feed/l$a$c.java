package com.tencent.mm.plugin.finder.feed;

import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class l$a$c
  implements Runnable
{
  l$a$c(RecyclerView.i parami, a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(198095);
    ((StaggeredGridLayoutManager)this.KOl).af(0, 0);
    a locala = this.KOV;
    if (locala != null)
    {
      locala.invoke();
      AppMethodBeat.o(198095);
      return;
    }
    AppMethodBeat.o(198095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.l.a.c
 * JD-Core Version:    0.7.0.1
 */