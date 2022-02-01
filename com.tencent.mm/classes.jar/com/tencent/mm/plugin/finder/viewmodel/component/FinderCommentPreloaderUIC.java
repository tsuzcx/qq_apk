package com.tencent.mm.plugin.finder.viewmodel.component;

import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderCommentPreloaderUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "plugin-finder_release"})
public final class FinderCommentPreloaderUIC
  extends UIComponent
{
  public final d rTq;
  
  public FinderCommentPreloaderUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(205499);
    paramFragment = paramFragment.getActivity();
    if (paramFragment == null)
    {
      paramFragment = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(205499);
      throw paramFragment;
    }
    this.rTq = new d((MMActivity)paramFragment);
    AppMethodBeat.o(205499);
  }
  
  public FinderCommentPreloaderUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(205498);
    this.rTq = new d(paramMMActivity);
    AppMethodBeat.o(205498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC
 * JD-Core Version:    0.7.0.1
 */