package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class d$d
  implements Runnable
{
  d$d(View paramView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(201257);
    View localView = this.qZV;
    k.g(localView, "maskView");
    localView.setVisibility(8);
    ac.i("Finder.FinderFeedCommentConvert", "maskView gone " + this.fOm);
    AppMethodBeat.o(201257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.d.d
 * JD-Core Version:    0.7.0.1
 */