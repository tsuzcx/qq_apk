package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.finder.feed.ak.a;
import com.tencent.mm.plugin.finder.feed.ak.b;
import com.tencent.mm.plugin.finder.feed.al;
import com.tencent.mm.plugin.finder.feed.al.h;
import com.tencent.mm.plugin.finder.feed.am;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM.a;
import com.tencent.mm.protocal.protobuf.aly;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.SimpleUIComponent;
import com.tencent.mm.ui.component.UIComponent;
import d.g.a.a;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineMachineUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter;", "getLayoutId", "", "onActionbarClick", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishing", "onUserVisibleFocused", "Companion", "plugin-finder_release"})
public final class FinderTimelineMachineUIC
  extends UIComponent
{
  public static final FinderTimelineMachineUIC.a tnU;
  private al tnT;
  
  static
  {
    AppMethodBeat.i(206324);
    tnU = new FinderTimelineMachineUIC.a((byte)0);
    AppMethodBeat.o(206324);
  }
  
  public FinderTimelineMachineUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(206323);
    AppMethodBeat.o(206323);
  }
  
  public final void cDm()
  {
    AppMethodBeat.i(206320);
    super.cDm();
    al localal = this.tnT;
    if (localal == null) {
      p.bdF("presenter");
    }
    c.b(null, (a)new al.h(localal));
    AppMethodBeat.o(206320);
  }
  
  public final void cRf()
  {
    AppMethodBeat.i(206321);
    super.cRf();
    Object localObject1 = this.tnT;
    if (localObject1 == null) {
      p.bdF("presenter");
    }
    FinderHomeTabStateVM.a(((al)localObject1).sgM, 4, 0, ((al)localObject1).sgO, (ArrayList)((al)localObject1).sho.getDataListJustForAdapter());
    if (((al)localObject1).shH != null)
    {
      Object localObject2 = ((al)localObject1).shE;
      localObject1 = ((al)localObject1).shH;
      if (localObject1 == null) {
        p.gkB();
      }
      p.h(localObject1, "lastDataList");
      new StringBuilder("tabType=4 lastExitPosition=-1  lastDataList size=").append(((aly)localObject1).GEo.size()).append(' ');
      h.fYG();
      localObject2 = (Map)((FinderTagCacheVM)localObject2).tkt;
      FinderTagCacheVM.a locala = new FinderTagCacheVM.a();
      locala.tlo = -1;
      p.h(localObject1, "<set-?>");
      locala.tln = ((aly)localObject1);
      ((Map)localObject2).put(Integer.valueOf(4), locala);
    }
    AppMethodBeat.o(206321);
  }
  
  public final int getLayoutId()
  {
    return 2131496266;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(206319);
    getActivity().finish();
    AppMethodBeat.o(206319);
    return true;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(206318);
    super.onCreate(paramBundle);
    getActivity().setMMTitle(2131759147);
    getActivity().setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    this.tnT = new al(getActivity());
    paramBundle = getActivity();
    al localal = this.tnT;
    if (localal == null) {
      p.bdF("presenter");
    }
    paramBundle = new am(paramBundle, (ak.a)localal, getRootView(), this.fragment);
    localal = this.tnT;
    if (localal == null) {
      p.bdF("presenter");
    }
    localal.a((ak.b)paramBundle);
    AppMethodBeat.o(206318);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(206322);
    super.onDestroy();
    al localal = this.tnT;
    if (localal == null) {
      p.bdF("presenter");
    }
    localal.onDetach();
    AppMethodBeat.o(206322);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderTimelineMachineUIC paramFinderTimelineMachineUIC) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(206317);
      boolean bool = this.tnV.onBackPressed();
      AppMethodBeat.o(206317);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineMachineUIC
 * JD-Core Version:    0.7.0.1
 */