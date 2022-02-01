package com.tencent.mm.plugin.finder.viewmodel.component;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.i;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderCommentPreloaderUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends UIComponent
{
  public final i Aye;
  
  public j(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(337771);
    this.Aye = new i(paramAppCompatActivity);
    AppMethodBeat.o(337771);
  }
  
  public j(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(337780);
    paramFragment = paramFragment.getActivity();
    if (paramFragment == null)
    {
      paramFragment = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
      AppMethodBeat.o(337780);
      throw paramFragment;
    }
    this.Aye = new i((AppCompatActivity)paramFragment);
    AppMethodBeat.o(337780);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.j
 * JD-Core Version:    0.7.0.1
 */