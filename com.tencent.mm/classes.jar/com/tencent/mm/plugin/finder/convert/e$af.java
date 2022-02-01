package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.ViewModelProvider;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.ui.component.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
final class e$af
  implements Runnable
{
  e$af(BaseFinderFeed paramBaseFinderFeed, FinderCollapsibleTextView paramFinderCollapsibleTextView) {}
  
  public final void run()
  {
    AppMethodBeat.i(197399);
    if (this.qqO.isContentCollapsed)
    {
      Object localObject1 = this.KKC;
      Object localObject2 = ((FinderCollapsibleTextView)localObject1).getCollapseTextView();
      k.g(localObject2, "collapseTextView");
      if ((((TextView)localObject2).getVisibility() != 0) || (!((FinderCollapsibleTextView)localObject1).qVx))
      {
        AppMethodBeat.o(197399);
        return;
      }
      localObject2 = a.LCX;
      a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class);
      FinderHomeTabStateVM.fXj();
      localObject1 = ((FinderCollapsibleTextView)localObject1).getTipsTv();
      if (((View)localObject1).getVisibility() == 8)
      {
        ((View)localObject1).setVisibility(0);
        ((View)localObject1).setAlpha(0.0F);
        ((View)localObject1).animate().alpha(1.0F).setDuration(300L).start();
      }
    }
    AppMethodBeat.o(197399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.e.af
 * JD-Core Version:    0.7.0.1
 */