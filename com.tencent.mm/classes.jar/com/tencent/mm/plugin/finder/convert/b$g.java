package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class b$g
  implements Runnable
{
  b$g(View paramView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(197382);
    View localView = this.qqn;
    k.g(localView, "maskView");
    localView.setVisibility(8);
    ad.i("Finder.FinderFeedCommentConvert", "maskView gone " + this.fKG);
    AppMethodBeat.o(197382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.b.g
 * JD-Core Version:    0.7.0.1
 */