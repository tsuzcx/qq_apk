package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class f$i
  implements Runnable
{
  f$i(View paramView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(178114);
    View localView = this.qZV;
    k.g(localView, "maskView");
    localView.setVisibility(8);
    ac.i("Finder.FinderFeedCommentLevel2Convert", "maskView gone " + this.fOm);
    AppMethodBeat.o(178114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.f.i
 * JD-Core Version:    0.7.0.1
 */