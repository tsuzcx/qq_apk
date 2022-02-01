package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedFriendLikeDrawerUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "onBackPressed", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class FinderFeedFriendLikeDrawerUIC
  extends UIComponent
{
  public static final a tbx;
  private FinderLikeDrawer tbw;
  
  static
  {
    AppMethodBeat.i(205547);
    tbx = new a((byte)0);
    AppMethodBeat.o(205547);
  }
  
  public FinderFeedFriendLikeDrawerUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(205546);
    AppMethodBeat.o(205546);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(205543);
    if (this.tbw == null) {
      this.tbw = ((FinderLikeDrawer)getActivity().findViewById(2131307397));
    }
    if (this.tbw == null)
    {
      AppMethodBeat.o(205543);
      return false;
    }
    FinderLikeDrawer localFinderLikeDrawer = this.tbw;
    if (localFinderLikeDrawer == null) {
      p.gfZ();
    }
    if (localFinderLikeDrawer.cMZ())
    {
      localFinderLikeDrawer = this.tbw;
      if (localFinderLikeDrawer == null) {
        p.gfZ();
      }
      localFinderLikeDrawer.cMY();
      AppMethodBeat.o(205543);
      return true;
    }
    AppMethodBeat.o(205543);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(205545);
    super.onPause();
    AppMethodBeat.o(205545);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(205544);
    super.onResume();
    AppMethodBeat.o(205544);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedFriendLikeDrawerUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedFriendLikeDrawerUIC
 * JD-Core Version:    0.7.0.1
 */