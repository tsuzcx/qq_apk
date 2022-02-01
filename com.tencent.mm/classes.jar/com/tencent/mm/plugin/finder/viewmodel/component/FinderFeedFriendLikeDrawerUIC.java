package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedFriendLikeDrawerUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "onBackPressed", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class FinderFeedFriendLikeDrawerUIC
  extends UIComponent
{
  public static final FinderFeedFriendLikeDrawerUIC.a sdC;
  private FinderLikeDrawer sdB;
  
  static
  {
    AppMethodBeat.i(204509);
    sdC = new FinderFeedFriendLikeDrawerUIC.a((byte)0);
    AppMethodBeat.o(204509);
  }
  
  public FinderFeedFriendLikeDrawerUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(204508);
    AppMethodBeat.o(204508);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(204505);
    if (this.sdB == null) {
      this.sdB = ((FinderLikeDrawer)getActivity().findViewById(2131307397));
    }
    if (this.sdB == null)
    {
      AppMethodBeat.o(204505);
      return false;
    }
    FinderLikeDrawer localFinderLikeDrawer = this.sdB;
    if (localFinderLikeDrawer == null) {
      k.fOy();
    }
    if (localFinderLikeDrawer.cEG())
    {
      localFinderLikeDrawer = this.sdB;
      if (localFinderLikeDrawer == null) {
        k.fOy();
      }
      localFinderLikeDrawer.cEF();
      AppMethodBeat.o(204505);
      return true;
    }
    AppMethodBeat.o(204505);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(204507);
    super.onPause();
    AppMethodBeat.o(204507);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(204506);
    super.onResume();
    AppMethodBeat.o(204506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedFriendLikeDrawerUIC
 * JD-Core Version:    0.7.0.1
 */