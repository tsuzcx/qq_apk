package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedFriendLikeDrawerUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "onBackPressed", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class FinderFeedFriendLikeDrawerUIC
  extends UIComponent
{
  public static final a LhZ;
  private FinderLikeDrawer LhY;
  
  static
  {
    AppMethodBeat.i(200384);
    LhZ = new a((byte)0);
    AppMethodBeat.o(200384);
  }
  
  public FinderFeedFriendLikeDrawerUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(200383);
    AppMethodBeat.o(200383);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(200380);
    if (this.LhY == null) {
      this.LhY = ((FinderLikeDrawer)getActivity().findViewById(2131307328));
    }
    if (this.LhY == null)
    {
      AppMethodBeat.o(200380);
      return false;
    }
    FinderLikeDrawer localFinderLikeDrawer = this.LhY;
    if (localFinderLikeDrawer == null) {
      k.fvU();
    }
    if (localFinderLikeDrawer.fiQ())
    {
      localFinderLikeDrawer = this.LhY;
      if (localFinderLikeDrawer == null) {
        k.fvU();
      }
      localFinderLikeDrawer.csJ();
      AppMethodBeat.o(200380);
      return true;
    }
    AppMethodBeat.o(200380);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(200382);
    super.onPause();
    AppMethodBeat.o(200382);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(200381);
    super.onResume();
    AppMethodBeat.o(200381);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedFriendLikeDrawerUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedFriendLikeDrawerUIC
 * JD-Core Version:    0.7.0.1
 */