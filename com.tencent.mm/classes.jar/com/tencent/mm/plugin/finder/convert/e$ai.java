package com.tencent.mm.plugin.finder.convert;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class e$ai
  implements View.OnClickListener
{
  e$ai(e parame, BaseFinderFeed paramBaseFinderFeed) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(197402);
    Context localContext = this.nGG.getContext();
    paramView = localContext;
    if (!(localContext instanceof Activity)) {
      paramView = null;
    }
    paramView = (Activity)paramView;
    if (paramView != null) {}
    for (paramView = (FinderLikeDrawer)paramView.findViewById(2131307327);; paramView = null)
    {
      if (paramView == null) {
        k.fvU();
      }
      paramView.p(this.qqO.feedObject);
      AppMethodBeat.o(197402);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.e.ai
 * JD-Core Version:    0.7.0.1
 */