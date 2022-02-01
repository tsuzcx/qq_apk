package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.finder.feed.ad.a;
import com.tencent.mm.plugin.finder.feed.ad.b;
import com.tencent.mm.plugin.finder.feed.ae;
import com.tencent.mm.plugin.finder.feed.ae.h;
import com.tencent.mm.plugin.finder.feed.af;
import com.tencent.mm.plugin.finder.feed.model.m;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM.a;
import com.tencent.mm.protocal.protobuf.aiw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.SimpleUIComponent;
import com.tencent.mm.ui.component.UIComponent;
import d.g.a.a;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineMachineUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter;", "getLayoutId", "", "onActionbarClick", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishing", "onUserVisibleFocused", "Companion", "plugin-finder_release"})
public final class FinderTimelineMachineUIC
  extends UIComponent
{
  public static final FinderTimelineMachineUIC.a sfe;
  private ae sfd;
  
  static
  {
    AppMethodBeat.i(204646);
    sfe = new FinderTimelineMachineUIC.a((byte)0);
    AppMethodBeat.o(204646);
  }
  
  public FinderTimelineMachineUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(204645);
    AppMethodBeat.o(204645);
  }
  
  public final void cGh()
  {
    AppMethodBeat.i(204643);
    super.cGh();
    Object localObject1 = this.sfd;
    if (localObject1 == null) {
      k.aVY("presenter");
    }
    FinderHomeTabStateVM.a(((ae)localObject1).rjC, 4, 0, ((ae)localObject1).rjE, (ArrayList)((ae)localObject1).rke.getDataListJustForAdapter());
    if (((ae)localObject1).rku != null)
    {
      Object localObject2 = ((ae)localObject1).rkr;
      localObject1 = ((ae)localObject1).rku;
      if (localObject1 == null) {
        k.fOy();
      }
      k.h(localObject1, "lastDataList");
      new StringBuilder("tabType=4 lastExitPosition=-1  lastDataList size=").append(((aiw)localObject1).EDC.size()).append(' ');
      h.fCP();
      localObject2 = (Map)((FinderTagCacheVM)localObject2).sbP;
      FinderTagCacheVM.a locala = new FinderTagCacheVM.a();
      locala.scZ = -1;
      k.h(localObject1, "<set-?>");
      locala.scY = ((aiw)localObject1);
      ((Map)localObject2).put(Integer.valueOf(4), locala);
    }
    AppMethodBeat.o(204643);
  }
  
  public final void cvj()
  {
    AppMethodBeat.i(204642);
    super.cvj();
    ae localae = this.sfd;
    if (localae == null) {
      k.aVY("presenter");
    }
    c.b(null, (a)new ae.h(localae));
    AppMethodBeat.o(204642);
  }
  
  public final int getLayoutId()
  {
    return 2131496266;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(204641);
    getActivity().finish();
    AppMethodBeat.o(204641);
    return true;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204640);
    super.onCreate(paramBundle);
    getActivity().setMMTitle(2131759147);
    getActivity().setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    this.sfd = new ae(getActivity());
    paramBundle = getActivity();
    ae localae = this.sfd;
    if (localae == null) {
      k.aVY("presenter");
    }
    paramBundle = new af(paramBundle, (ad.a)localae, getRootView(), this.fragment);
    localae = this.sfd;
    if (localae == null) {
      k.aVY("presenter");
    }
    localae.a((ad.b)paramBundle);
    AppMethodBeat.o(204640);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204644);
    super.onDestroy();
    ae localae = this.sfd;
    if (localae == null) {
      k.aVY("presenter");
    }
    localae.onDetach();
    AppMethodBeat.o(204644);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderTimelineMachineUIC paramFinderTimelineMachineUIC) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(204639);
      boolean bool = this.sff.onBackPressed();
      AppMethodBeat.o(204639);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineMachineUIC
 * JD-Core Version:    0.7.0.1
 */