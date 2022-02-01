package com.tencent.mm.plugin.finder.ui.sample;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleDynamicTabUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "selectTab", "Companion", "FinderDynamicSampleTabUIC", "FinderDynamicTabProvider", "plugin-finder_release"})
public final class FinderSampleDynamicTabUI
  extends MMFinderUI
{
  public static final a vRD;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(253026);
    vRD = new a((byte)0);
    AppMethodBeat.o(253026);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(253028);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(253028);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(253027);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(253027);
    return localView1;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(253024);
    Set localSet = ak.setOf(FinderDynamicSampleTabUIC.class);
    AppMethodBeat.o(253024);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(253025);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.ui.component.a.PRN;
    FinderTabUIC.a((FinderDynamicSampleTabUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderDynamicSampleTabUIC.class), 1);
    getContentView().postDelayed((Runnable)new c(this), 4000L);
    getContentView().postDelayed((Runnable)new d(this), 10000L);
    getContentView().postDelayed((Runnable)new e(this), 15000L);
    getContentView().postDelayed((Runnable)new f(this), 20000L);
    AppMethodBeat.o(253025);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleDynamicTabUI$FinderDynamicSampleTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "plugin-finder_release"})
  public static final class FinderDynamicSampleTabUIC
    extends FinderTabUIC
  {
    public FinderDynamicSampleTabUIC(AppCompatActivity paramAppCompatActivity)
    {
      super();
      AppMethodBeat.i(253019);
      Log.i("Finder.FinderTabUIC", "FinderBizTabUIC init cons");
      AppMethodBeat.o(253019);
    }
    
    public final IFinderTabProvider cXB()
    {
      AppMethodBeat.i(253018);
      Log.i("Finder.FinderTabUIC", "FinderBizTabUIC generateProvider");
      IFinderTabProvider localIFinderTabProvider = (IFinderTabProvider)new FinderSampleDynamicTabUI.b();
      AppMethodBeat.o(253018);
      return localIFinderTabProvider;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleDynamicTabUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleDynamicTabUI$FinderDynamicTabProvider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabProvider;", "()V", "isDynamic", "", "plugin-finder_release"})
  public static final class b
    extends FinderTabProvider
  {
    public final boolean isDynamic()
    {
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(FinderSampleDynamicTabUI paramFinderSampleDynamicTabUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(253020);
      Object localObject = com.tencent.mm.ui.component.a.PRN;
      localObject = (FinderSampleDynamicTabUI.FinderDynamicSampleTabUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.vRE).get(FinderSampleDynamicTabUI.FinderDynamicSampleTabUIC.class);
      com.tencent.mm.plugin.finder.view.tabcomp.a locala = (com.tencent.mm.plugin.finder.view.tabcomp.a)new c("A1");
      FinderSampleTabUI.FinderSampleTabFragment localFinderSampleTabFragment = new FinderSampleTabUI.FinderSampleTabFragment();
      localFinderSampleTabFragment.title = 201;
      FinderTabUIC.a((FinderTabUIC)localObject, 1, locala, (FinderHomeTabFragment)localFinderSampleTabFragment);
      localObject = com.tencent.mm.ui.component.a.PRN;
      localObject = (FinderSampleDynamicTabUI.FinderDynamicSampleTabUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.vRE).get(FinderSampleDynamicTabUI.FinderDynamicSampleTabUIC.class);
      locala = (com.tencent.mm.plugin.finder.view.tabcomp.a)new c("A2");
      localFinderSampleTabFragment = new FinderSampleTabUI.FinderSampleTabFragment();
      localFinderSampleTabFragment.title = 202;
      FinderTabUIC.a((FinderTabUIC)localObject, 2, locala, (FinderHomeTabFragment)localFinderSampleTabFragment);
      AppMethodBeat.o(253020);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(FinderSampleDynamicTabUI paramFinderSampleDynamicTabUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(253021);
      Object localObject = com.tencent.mm.ui.component.a.PRN;
      localObject = (FinderSampleDynamicTabUI.FinderDynamicSampleTabUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.vRE).get(FinderSampleDynamicTabUI.FinderDynamicSampleTabUIC.class);
      com.tencent.mm.plugin.finder.view.tabcomp.a locala = (com.tencent.mm.plugin.finder.view.tabcomp.a)new c("B1");
      FinderSampleTabUI.FinderSampleTabFragment localFinderSampleTabFragment = new FinderSampleTabUI.FinderSampleTabFragment();
      localFinderSampleTabFragment.title = 301;
      FinderTabUIC.a((FinderTabUIC)localObject, locala, (FinderHomeTabFragment)localFinderSampleTabFragment);
      localObject = com.tencent.mm.ui.component.a.PRN;
      localObject = (FinderSampleDynamicTabUI.FinderDynamicSampleTabUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.vRE).get(FinderSampleDynamicTabUI.FinderDynamicSampleTabUIC.class);
      locala = (com.tencent.mm.plugin.finder.view.tabcomp.a)new c("B2");
      localFinderSampleTabFragment = new FinderSampleTabUI.FinderSampleTabFragment();
      localFinderSampleTabFragment.title = 302;
      FinderTabUIC.a((FinderTabUIC)localObject, locala, (FinderHomeTabFragment)localFinderSampleTabFragment);
      localObject = com.tencent.mm.ui.component.a.PRN;
      localObject = (FinderSampleDynamicTabUI.FinderDynamicSampleTabUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.vRE).get(FinderSampleDynamicTabUI.FinderDynamicSampleTabUIC.class);
      locala = (com.tencent.mm.plugin.finder.view.tabcomp.a)new c("B3");
      localFinderSampleTabFragment = new FinderSampleTabUI.FinderSampleTabFragment();
      localFinderSampleTabFragment.title = 303;
      FinderTabUIC.a((FinderTabUIC)localObject, locala, (FinderHomeTabFragment)localFinderSampleTabFragment);
      AppMethodBeat.o(253021);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(FinderSampleDynamicTabUI paramFinderSampleDynamicTabUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(253022);
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
      FinderTabUIC.c((FinderSampleDynamicTabUI.FinderDynamicSampleTabUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.vRE).get(FinderSampleDynamicTabUI.FinderDynamicSampleTabUIC.class), 3);
      AppMethodBeat.o(253022);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(FinderSampleDynamicTabUI paramFinderSampleDynamicTabUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(253023);
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
      FinderTabUIC.c((FinderSampleDynamicTabUI.FinderDynamicSampleTabUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.vRE).get(FinderSampleDynamicTabUI.FinderDynamicSampleTabUIC.class), 0);
      locala = com.tencent.mm.ui.component.a.PRN;
      ((FinderSampleDynamicTabUI.FinderDynamicSampleTabUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.vRE).get(FinderSampleDynamicTabUI.FinderDynamicSampleTabUIC.class)).dIN();
      locala = com.tencent.mm.ui.component.a.PRN;
      ((FinderSampleDynamicTabUI.FinderDynamicSampleTabUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.vRE).get(FinderSampleDynamicTabUI.FinderDynamicSampleTabUIC.class)).dIN();
      AppMethodBeat.o(253023);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.sample.FinderSampleDynamicTabUI
 * JD-Core Version:    0.7.0.1
 */