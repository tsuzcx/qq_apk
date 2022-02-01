package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.finder.feed.ah.a;
import com.tencent.mm.plugin.finder.feed.ah.b;
import com.tencent.mm.plugin.finder.feed.ai;
import com.tencent.mm.plugin.finder.feed.ai.h;
import com.tencent.mm.plugin.finder.feed.aj;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM.a;
import com.tencent.mm.protocal.protobuf.dyf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.SimpleUIComponent;
import com.tencent.mm.ui.component.UIComponent;
import d.g.a.a;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineMachineUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter;", "getLayoutId", "", "onActionbarClick", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishing", "onUserVisibleFocused", "Companion", "plugin-finder_release"})
public final class FinderTimelineMachineUIC
  extends UIComponent
{
  public static final a Ljy;
  private ai Ljx;
  
  static
  {
    AppMethodBeat.i(200516);
    Ljy = new a((byte)0);
    AppMethodBeat.o(200516);
  }
  
  public FinderTimelineMachineUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(200515);
    AppMethodBeat.o(200515);
  }
  
  public final void fTo()
  {
    AppMethodBeat.i(200512);
    super.fTo();
    ai localai = this.Ljx;
    if (localai == null) {
      k.aPZ("presenter");
    }
    c.b(null, (a)new ai.h(localai));
    AppMethodBeat.o(200512);
  }
  
  public final void fXy()
  {
    AppMethodBeat.i(200513);
    super.fXy();
    Object localObject1 = this.Ljx;
    if (localObject1 == null) {
      k.aPZ("presenter");
    }
    FinderHomeTabStateVM.a(((ai)localObject1).KOa, 4, 0, ((ai)localObject1).KOb, (ArrayList)((ai)localObject1).qrj.getDataListJustForAdapter());
    if (((ai)localObject1).KOJ != null)
    {
      Object localObject2 = ((ai)localObject1).KOH;
      localObject1 = ((ai)localObject1).KOJ;
      if (localObject1 == null) {
        k.fvU();
      }
      k.h(localObject1, "lastDataList");
      new StringBuilder("tabType=4 lastExitPosition=-1  lastDataList size=").append(((dyf)localObject1).Lxm.size()).append(' ');
      com.tencent.d.f.h.fmz();
      localObject2 = (Map)((FinderTagCacheVM)localObject2).LgZ;
      FinderTagCacheVM.a locala = new FinderTagCacheVM.a();
      locala.Lhw = -1;
      k.h(localObject1, "<set-?>");
      locala.Lhv = ((dyf)localObject1);
      ((Map)localObject2).put(Integer.valueOf(4), locala);
    }
    AppMethodBeat.o(200513);
  }
  
  public final int getLayoutId()
  {
    return 2131496265;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(200511);
    getActivity().finish();
    AppMethodBeat.o(200511);
    return true;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(200510);
    super.onCreate(paramBundle);
    getActivity().setMMTitle(2131759147);
    getActivity().setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    this.Ljx = new ai(getActivity());
    paramBundle = getActivity();
    ai localai = this.Ljx;
    if (localai == null) {
      k.aPZ("presenter");
    }
    paramBundle = new aj(paramBundle, (ah.a)localai, getRootView(), this.fragment);
    localai = this.Ljx;
    if (localai == null) {
      k.aPZ("presenter");
    }
    localai.a((ah.b)paramBundle);
    AppMethodBeat.o(200510);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(200514);
    super.onDestroy();
    ai localai = this.Ljx;
    if (localai == null) {
      k.aPZ("presenter");
    }
    localai.onDetach();
    AppMethodBeat.o(200514);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineMachineUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderTimelineMachineUIC paramFinderTimelineMachineUIC) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(200509);
      boolean bool = this.Ljz.onBackPressed();
      AppMethodBeat.o(200509);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineMachineUIC
 * JD-Core Version:    0.7.0.1
 */