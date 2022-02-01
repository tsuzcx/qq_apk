package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.finder.feed.ak.a;
import com.tencent.mm.plugin.finder.feed.ak.b;
import com.tencent.mm.plugin.finder.feed.al;
import com.tencent.mm.plugin.finder.feed.al.h;
import com.tencent.mm.plugin.finder.feed.am;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM.a;
import com.tencent.mm.protocal.protobuf.alm;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.SimpleUIComponent;
import com.tencent.mm.ui.component.UIComponent;
import d.g.a.a;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineMachineUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter;", "getLayoutId", "", "onActionbarClick", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishing", "onUserVisibleFocused", "Companion", "plugin-finder_release"})
public final class FinderTimelineMachineUIC
  extends UIComponent
{
  public static final a tda;
  private al tcZ;
  
  static
  {
    AppMethodBeat.i(205695);
    tda = new a((byte)0);
    AppMethodBeat.o(205695);
  }
  
  public FinderTimelineMachineUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(205694);
    AppMethodBeat.o(205694);
  }
  
  public final void cBA()
  {
    AppMethodBeat.i(205691);
    super.cBA();
    al localal = this.tcZ;
    if (localal == null) {
      p.bcb("presenter");
    }
    c.b(null, (a)new al.h(localal));
    AppMethodBeat.o(205691);
  }
  
  public final void cOA()
  {
    AppMethodBeat.i(205692);
    super.cOA();
    Object localObject1 = this.tcZ;
    if (localObject1 == null) {
      p.bcb("presenter");
    }
    FinderHomeTabStateVM.a(((al)localObject1).rYa, 4, 0, ((al)localObject1).rYc, (ArrayList)((al)localObject1).rYC.getDataListJustForAdapter());
    if (((al)localObject1).rYV != null)
    {
      Object localObject2 = ((al)localObject1).rYS;
      localObject1 = ((al)localObject1).rYV;
      if (localObject1 == null) {
        p.gfZ();
      }
      p.h(localObject1, "lastDataList");
      new StringBuilder("tabType=4 lastExitPosition=-1  lastDataList size=").append(((alm)localObject1).Glm.size()).append(' ');
      h.fUh();
      localObject2 = (Map)((FinderTagCacheVM)localObject2).sZf;
      FinderTagCacheVM.a locala = new FinderTagCacheVM.a();
      locala.taA = -1;
      p.h(localObject1, "<set-?>");
      locala.taz = ((alm)localObject1);
      ((Map)localObject2).put(Integer.valueOf(4), locala);
    }
    AppMethodBeat.o(205692);
  }
  
  public final int getLayoutId()
  {
    return 2131496266;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(205690);
    getActivity().finish();
    AppMethodBeat.o(205690);
    return true;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(205689);
    super.onCreate(paramBundle);
    getActivity().setMMTitle(2131759147);
    getActivity().setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    this.tcZ = new al(getActivity());
    paramBundle = getActivity();
    al localal = this.tcZ;
    if (localal == null) {
      p.bcb("presenter");
    }
    paramBundle = new am(paramBundle, (ak.a)localal, getRootView(), this.fragment);
    localal = this.tcZ;
    if (localal == null) {
      p.bcb("presenter");
    }
    localal.a((ak.b)paramBundle);
    AppMethodBeat.o(205689);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(205693);
    super.onDestroy();
    al localal = this.tcZ;
    if (localal == null) {
      p.bcb("presenter");
    }
    localal.onDetach();
    AppMethodBeat.o(205693);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineMachineUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderTimelineMachineUIC paramFinderTimelineMachineUIC) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(205688);
      boolean bool = this.tdb.onBackPressed();
      AppMethodBeat.o(205688);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineMachineUIC
 * JD-Core Version:    0.7.0.1
 */