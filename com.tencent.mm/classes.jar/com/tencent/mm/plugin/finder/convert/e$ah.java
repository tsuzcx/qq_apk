package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderFeedExposeLayout;
import d.g.a.m;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class e$ah
  implements View.OnClickListener
{
  e$ah(FinderFeedExposeLayout paramFinderFeedExposeLayout, View paramView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(197401);
    paramView = this.KKD.getOnCommentClickListener();
    if (paramView != null)
    {
      View localView = this.KKE;
      k.g(localView, "selfCommentContainer");
      paramView.n(localView, null);
      AppMethodBeat.o(197401);
      return;
    }
    AppMethodBeat.o(197401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.e.ah
 * JD-Core Version:    0.7.0.1
 */