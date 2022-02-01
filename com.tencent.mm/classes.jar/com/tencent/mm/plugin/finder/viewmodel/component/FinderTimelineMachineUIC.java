package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.feed.aq.a;
import com.tencent.mm.plugin.finder.feed.aq.b;
import com.tencent.mm.plugin.finder.feed.ar;
import com.tencent.mm.plugin.finder.feed.ar.h;
import com.tencent.mm.plugin.finder.feed.as;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM.a;
import com.tencent.mm.protocal.protobuf.apa;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineMachineUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter;", "getLayoutId", "", "onActionbarClick", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinished", "onUserVisibleFocused", "Companion", "plugin-finder_release"})
public final class FinderTimelineMachineUIC
  extends UIComponent
{
  public static final a wAI;
  private ar wAH;
  
  static
  {
    AppMethodBeat.i(256003);
    wAI = new a((byte)0);
    AppMethodBeat.o(256003);
  }
  
  public FinderTimelineMachineUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(256002);
    AppMethodBeat.o(256002);
  }
  
  public final int getLayoutId()
  {
    return 2131494654;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(255998);
    getActivity().finish();
    AppMethodBeat.o(255998);
    return true;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255997);
    super.onCreate(paramBundle);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255997);
      throw paramBundle;
    }
    ((MMActivity)paramBundle).setMMTitle(2131759533);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255997);
      throw paramBundle;
    }
    ((MMActivity)paramBundle).setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255997);
      throw paramBundle;
    }
    this.wAH = new ar((MMActivity)paramBundle);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255997);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    ar localar = this.wAH;
    if (localar == null) {
      p.btv("presenter");
    }
    paramBundle = new as(paramBundle, (aq.a)localar, getRootView(), getFragment());
    localar = this.wAH;
    if (localar == null) {
      p.btv("presenter");
    }
    localar.a((aq.b)paramBundle);
    AppMethodBeat.o(255997);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(256001);
    super.onDestroy();
    ar localar = this.wAH;
    if (localar == null) {
      p.btv("presenter");
    }
    localar.onDetach();
    AppMethodBeat.o(256001);
  }
  
  public final void onFinished()
  {
    AppMethodBeat.i(256000);
    super.onFinished();
    Object localObject1 = this.wAH;
    if (localObject1 == null) {
      p.btv("presenter");
    }
    FinderHomeTabStateVM.a(((ar)localObject1).tlCache, 4, 0, ((ar)localObject1).totalDy, (ArrayList)((ar)localObject1).tRo.getDataListJustForAdapter());
    if (((ar)localObject1).tRI != null)
    {
      Object localObject2 = ((ar)localObject1).tRF;
      localObject1 = ((ar)localObject1).tRI;
      if (localObject1 == null) {
        p.hyc();
      }
      p.h(localObject1, "lastDataList");
      new StringBuilder("tabType=4 lastExitPosition=-1  lastDataList size=").append(((apa)localObject1).LBa.size()).append(' ');
      h.hkS();
      localObject2 = (Map)((FinderTagCacheVM)localObject2).wtV;
      FinderTagCacheVM.a locala = new FinderTagCacheVM.a();
      locala.wuU = -1;
      p.h(localObject1, "<set-?>");
      locala.wuT = ((apa)localObject1);
      ((Map)localObject2).put(Integer.valueOf(4), locala);
    }
    AppMethodBeat.o(256000);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(255999);
    super.onUserVisibleFocused();
    ar localar = this.wAH;
    if (localar == null) {
      p.btv("presenter");
    }
    d.i((a)new ar.h(localar));
    AppMethodBeat.o(255999);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineMachineUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderTimelineMachineUIC paramFinderTimelineMachineUIC) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(255996);
      boolean bool = this.wAJ.onBackPressed();
      AppMethodBeat.o(255996);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineMachineUIC
 * JD-Core Version:    0.7.0.1
 */