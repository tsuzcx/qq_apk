package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedFriendLikeDrawerUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "onBackPressed", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class r
  extends UIComponent
{
  public static final a BjS;
  FinderLikeDrawer BjR;
  
  static
  {
    AppMethodBeat.i(275412);
    BjS = new a((byte)0);
    AppMethodBeat.o(275412);
  }
  
  public r(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(275411);
    AppMethodBeat.o(275411);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(275408);
    if (this.BjR == null) {
      this.BjR = ((FinderLikeDrawer)getActivity().findViewById(b.f.finder_feed_friend_like_drawer));
    }
    if (this.BjR == null)
    {
      AppMethodBeat.o(275408);
      return false;
    }
    FinderLikeDrawer localFinderLikeDrawer = this.BjR;
    if (localFinderLikeDrawer == null) {
      p.iCn();
    }
    if (localFinderLikeDrawer.eis())
    {
      localFinderLikeDrawer = this.BjR;
      if (localFinderLikeDrawer == null) {
        p.iCn();
      }
      localFinderLikeDrawer.eir();
      AppMethodBeat.o(275408);
      return true;
    }
    AppMethodBeat.o(275408);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(275410);
    super.onPause();
    AppMethodBeat.o(275410);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(275409);
    super.onResume();
    AppMethodBeat.o(275409);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedFriendLikeDrawerUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.r
 * JD-Core Version:    0.7.0.1
 */