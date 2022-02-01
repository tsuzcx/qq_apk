package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.view.h;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.c;
import com.tencent.mm.plugin.finder.viewmodel.hometab.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.component.UIComponent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeNewUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragmentChangeListener", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "isCreated", "", "isFromSns", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "getActiveFragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "getActiveView", "Landroid/view/View;", "getCurrentTabType", "", "getFragmentByTabType", "tabType", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onStop", "selectType", "setCurrentTabType", "type", "args", "Companion", "plugin-finder_release"})
public final class FinderHomeNewUIC
  extends UIComponent
{
  public static final a wxe;
  private boolean dbG;
  private final FinderHomeTabStateVM tlCache;
  private boolean wxc;
  private h wxd;
  
  static
  {
    AppMethodBeat.i(255613);
    wxe = new a((byte)0);
    AppMethodBeat.o(255613);
  }
  
  public FinderHomeNewUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255612);
    paramAppCompatActivity = com.tencent.mm.ui.component.a.PRN;
    paramAppCompatActivity = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(paramAppCompatActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.tlCache = ((FinderHomeTabStateVM)paramAppCompatActivity);
    this.wxd = ((h)new b(this));
    AppMethodBeat.o(255612);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(255611);
    if (this.wxc)
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
      localIntent.putExtra("preferred_tab", 2);
      com.tencent.mm.br.c.f((Context)getActivity(), ".ui.LauncherUI", localIntent);
      getActivity().overridePendingTransition(MMFragmentActivity.a.ogo, MMFragmentActivity.a.ogp);
      AppMethodBeat.o(255611);
      return true;
    }
    AppMethodBeat.o(255611);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255607);
    super.onCreate(paramBundle);
    d.i((kotlin.g.a.a)c.wxg);
    int i = getIntent().getIntExtra("FROM_SCENE_KEY", 2);
    paramBundle = g.ah(PluginFinder.class);
    p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramBundle).getRedDotManager().Iw(i);
    paramBundle = com.tencent.mm.plugin.finder.storage.c.vCb;
    com.tencent.mm.plugin.finder.storage.c.dsk();
    if (getActivity().getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false))
    {
      i = 3;
      paramBundle = com.tencent.mm.plugin.finder.viewmodel.hometab.a.wBL;
      final int j = a.a.MK(i);
      paramBundle = com.tencent.mm.ui.component.a.PRN;
      paramBundle = ((FinderHomeTabUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderHomeTabUIC.class)).wAv;
      if (paramBundle != null) {
        paramBundle.post((Runnable)new d(this, j));
      }
      paramBundle = new StringBuilder("[selectType] lastTabType=").append(this.tlCache.dHR()).append(" index=");
      a.a locala = com.tencent.mm.plugin.finder.viewmodel.hometab.a.wBL;
      Log.i("Finder.HomeUIC", a.a.MK(i) + " tabType=" + i);
      paramBundle = as.uOL;
      as.startTimer();
      this.dbG = true;
      if ((getIntent().getLongExtra("key_finder_post_local_id", -1L) == -1L) || (!getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false))) {
        break label261;
      }
    }
    label261:
    for (boolean bool = true;; bool = false)
    {
      this.wxc = bool;
      AppMethodBeat.o(255607);
      return;
      i = this.tlCache.dHR();
      break;
    }
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(255608);
    super.onCreateAfter(paramBundle);
    paramBundle = com.tencent.mm.ui.component.a.PRN;
    ((FinderHomeTabUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderHomeTabUIC.class)).wxj.add(this.wxd);
    int i = this.tlCache.dHR();
    paramBundle = new Bundle();
    paramBundle.putInt("Source", 1);
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.hometab.a.wBL;
    int j = a.a.MK(i);
    if (j >= 0)
    {
      localObject = com.tencent.mm.ui.component.a.PRN;
      ((FinderHomeTabFragment)((FinderHomeTabUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderHomeTabUIC.class)).getFragments().get(j)).Ew = paramBundle;
      this.tlCache.wtW = i;
      paramBundle = com.tencent.mm.ui.component.a.PRN;
      FinderTabUIC.a((FinderHomeTabUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderHomeTabUIC.class), j);
    }
    AppMethodBeat.o(255608);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(255610);
    super.onDestroy();
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    localObject = ((FinderHomeTabUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderHomeTabUIC.class)).getActiveFragment();
    if (localObject != null)
    {
      this.tlCache.a(((FinderHomeTabFragment)localObject).dLS, FinderHomeTabStateVM.c.wuj);
      this.tlCache.Mp(((FinderHomeTabFragment)localObject).dLS);
    }
    localObject = as.uOL;
    as.stopTimer();
    localObject = g.ah(PluginFinder.class);
    p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().daC();
    AppMethodBeat.o(255610);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(255609);
    super.onStop();
    if (getActivity().isFinishing())
    {
      com.tencent.mm.kernel.b.a locala = g.ah(PluginFinder.class);
      p.g(locala, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)locala).getRedDotManager().daB();
    }
    AppMethodBeat.o(255609);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeNewUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeNewUIC$fragmentChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "plugin-finder_release"})
  public static final class b
    implements h
  {
    public final void D(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(255603);
      FinderHomeNewUIC.a(this.wxf).wtW = paramInt4;
      AppMethodBeat.o(255603);
    }
    
    public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
    {
      AppMethodBeat.i(255602);
      p.h(paramFinderHomeTabFragment, "fragment");
      AppMethodBeat.o(255602);
    }
    
    public final void onPageScrollStateChanged(int paramInt) {}
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final c wxg;
    
    static
    {
      AppMethodBeat.i(255605);
      wxg = new c();
      AppMethodBeat.o(255605);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeNewUIC$selectType$1$1"})
  static final class d
    implements Runnable
  {
    d(FinderHomeNewUIC paramFinderHomeNewUIC, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(255606);
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
      FinderTabUIC.a((FinderHomeTabUIC)com.tencent.mm.ui.component.a.b(this.wxf.getActivity()).get(FinderHomeTabUIC.class), j);
      AppMethodBeat.o(255606);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeNewUIC
 * JD-Core Version:    0.7.0.1
 */