package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedFriendLikeDrawerUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "onBackPressed", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class FinderFeedFriendLikeDrawerUIC
  extends UIComponent
{
  public static final FinderFeedFriendLikeDrawerUIC.a tmm;
  private FinderLikeDrawer tml;
  
  static
  {
    AppMethodBeat.i(206157);
    tmm = new FinderFeedFriendLikeDrawerUIC.a((byte)0);
    AppMethodBeat.o(206157);
  }
  
  public FinderFeedFriendLikeDrawerUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(206156);
    AppMethodBeat.o(206156);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(206153);
    if (this.tml == null) {
      this.tml = ((FinderLikeDrawer)getActivity().findViewById(2131307397));
    }
    if (this.tml == null)
    {
      AppMethodBeat.o(206153);
      return false;
    }
    FinderLikeDrawer localFinderLikeDrawer = this.tml;
    if (localFinderLikeDrawer == null) {
      p.gkB();
    }
    if (localFinderLikeDrawer.cPI())
    {
      localFinderLikeDrawer = this.tml;
      if (localFinderLikeDrawer == null) {
        p.gkB();
      }
      localFinderLikeDrawer.cPH();
      AppMethodBeat.o(206153);
      return true;
    }
    AppMethodBeat.o(206153);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(206155);
    super.onPause();
    AppMethodBeat.o(206155);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(206154);
    super.onResume();
    AppMethodBeat.o(206154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedFriendLikeDrawerUIC
 * JD-Core Version:    0.7.0.1
 */