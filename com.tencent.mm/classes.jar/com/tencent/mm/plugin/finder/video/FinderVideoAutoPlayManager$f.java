package com.tencent.mm.plugin.finder.video;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.HashSet;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class FinderVideoAutoPlayManager$f
  implements Runnable
{
  FinderVideoAutoPlayManager$f(FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager, String paramString, RecyclerView paramRecyclerView) {}
  
  public final void run()
  {
    AppMethodBeat.i(210202);
    FinderVideoAutoPlayManager.a(this.rSn).add(this.kdj);
    FinderVideoAutoPlayManager.a(this.rSn, this.rbu);
    AppMethodBeat.o(210202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager.f
 * JD-Core Version:    0.7.0.1
 */