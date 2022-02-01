package com.tencent.mm.plugin.finder.viewmodel.component;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.i;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderCommentPreloaderUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "plugin-finder_release"})
public final class l
  extends UIComponent
{
  public final i xve;
  
  public l(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(274736);
    this.xve = new i(paramAppCompatActivity);
    AppMethodBeat.o(274736);
  }
  
  public l(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(274738);
    paramFragment = paramFragment.getActivity();
    if (paramFragment == null)
    {
      paramFragment = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
      AppMethodBeat.o(274738);
      throw paramFragment;
    }
    this.xve = new i((AppCompatActivity)paramFragment);
    AppMethodBeat.o(274738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.l
 * JD-Core Version:    0.7.0.1
 */