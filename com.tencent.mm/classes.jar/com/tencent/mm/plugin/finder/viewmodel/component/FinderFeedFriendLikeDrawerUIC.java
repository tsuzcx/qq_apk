package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedFriendLikeDrawerUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "onBackPressed", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class FinderFeedFriendLikeDrawerUIC
  extends UIComponent
{
  public static final a wwa;
  FinderLikeDrawer wvZ;
  
  static
  {
    AppMethodBeat.i(255497);
    wwa = new a((byte)0);
    AppMethodBeat.o(255497);
  }
  
  public FinderFeedFriendLikeDrawerUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255496);
    AppMethodBeat.o(255496);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(255493);
    if (this.wvZ == null) {
      this.wvZ = ((FinderLikeDrawer)getActivity().findViewById(2131300826));
    }
    if (this.wvZ == null)
    {
      AppMethodBeat.o(255493);
      return false;
    }
    FinderLikeDrawer localFinderLikeDrawer = this.wvZ;
    if (localFinderLikeDrawer == null) {
      p.hyc();
    }
    if (localFinderLikeDrawer.dGs())
    {
      localFinderLikeDrawer = this.wvZ;
      if (localFinderLikeDrawer == null) {
        p.hyc();
      }
      localFinderLikeDrawer.dGr();
      AppMethodBeat.o(255493);
      return true;
    }
    AppMethodBeat.o(255493);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(255495);
    super.onPause();
    AppMethodBeat.o(255495);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(255494);
    super.onResume();
    AppMethodBeat.o(255494);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedFriendLikeDrawerUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedFriendLikeDrawerUIC
 * JD-Core Version:    0.7.0.1
 */