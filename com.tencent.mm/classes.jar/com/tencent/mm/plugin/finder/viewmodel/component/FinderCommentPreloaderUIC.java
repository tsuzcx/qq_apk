package com.tencent.mm.plugin.finder.viewmodel.component;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.d;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderCommentPreloaderUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "plugin-finder_release"})
public final class FinderCommentPreloaderUIC
  extends UIComponent
{
  public final d tLy;
  
  public FinderCommentPreloaderUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(255448);
    paramFragment = paramFragment.getActivity();
    if (paramFragment == null)
    {
      paramFragment = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
      AppMethodBeat.o(255448);
      throw paramFragment;
    }
    this.tLy = new d((AppCompatActivity)paramFragment);
    AppMethodBeat.o(255448);
  }
  
  public FinderCommentPreloaderUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255447);
    this.tLy = new d(paramAppCompatActivity);
    AppMethodBeat.o(255447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC
 * JD-Core Version:    0.7.0.1
 */