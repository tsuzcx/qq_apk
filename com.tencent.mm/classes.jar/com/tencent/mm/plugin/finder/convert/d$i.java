package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class d$i
  implements Runnable
{
  d$i(View paramView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(178114);
    View localView = this.qqn;
    k.g(localView, "maskView");
    localView.setVisibility(8);
    ad.i("Finder.FinderFeedCommentLevel2Convert", "maskView gone " + this.fKG);
    AppMethodBeat.o(178114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.d.i
 * JD-Core Version:    0.7.0.1
 */