package com.tencent.mm.plugin.finder.ui.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.a;
import com.tencent.mm.plugin.finder.view.tabcomp.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleDynamicTabUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "selectTab", "Companion", "FinderDynamicSampleTabUIC", "FinderDynamicTabProvider", "plugin-finder_release"})
public final class FinderSampleDynamicTabUI
  extends MMFinderUI
{
  public static final a AyE;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(279310);
    AyE = new a((byte)0);
    AppMethodBeat.o(279310);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(279312);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(279312);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(279311);
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
    AppMethodBeat.o(279311);
    return localView1;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(279308);
    Set localSet = ak.setOf(b.class);
    AppMethodBeat.o(279308);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(279309);
    super.onCreate(paramBundle);
    paramBundle = g.Xox;
    FinderTabUIC.a((b)g.b((AppCompatActivity)this).i(b.class), 1);
    getContentView().postDelayed((Runnable)new d(this), 4000L);
    getContentView().postDelayed((Runnable)new e(this), 10000L);
    getContentView().postDelayed((Runnable)new f(this), 15000L);
    getContentView().postDelayed((Runnable)new g(this), 20000L);
    AppMethodBeat.o(279309);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleDynamicTabUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleDynamicTabUI$FinderDynamicSampleTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "plugin-finder_release"})
  public static final class b
    extends FinderTabUIC
  {
    public b(AppCompatActivity paramAppCompatActivity)
    {
      super();
      AppMethodBeat.i(286759);
      Log.i("Finder.FinderTabUIC", "FinderBizTabUIC init cons");
      AppMethodBeat.o(286759);
    }
    
    public final IFinderTabProvider dmS()
    {
      AppMethodBeat.i(286758);
      Log.i("Finder.FinderTabUIC", "FinderBizTabUIC generateProvider");
      IFinderTabProvider localIFinderTabProvider = (IFinderTabProvider)new FinderSampleDynamicTabUI.c();
      AppMethodBeat.o(286758);
      return localIFinderTabProvider;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleDynamicTabUI$FinderDynamicTabProvider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabProvider;", "()V", "isDynamic", "", "plugin-finder_release"})
  public static final class c
    extends FinderTabProvider
  {
    public final boolean isDynamic()
    {
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(FinderSampleDynamicTabUI paramFinderSampleDynamicTabUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(276020);
      Object localObject = g.Xox;
      localObject = (FinderSampleDynamicTabUI.b)g.b((AppCompatActivity)this.AyF).i(FinderSampleDynamicTabUI.b.class);
      a locala = (a)new c("A1");
      FinderSampleTabUI.FinderSampleTabFragment localFinderSampleTabFragment = new FinderSampleTabUI.FinderSampleTabFragment();
      localFinderSampleTabFragment.title = 201;
      FinderTabUIC.a((FinderTabUIC)localObject, 1, locala, (FinderHomeTabFragment)localFinderSampleTabFragment);
      localObject = g.Xox;
      localObject = (FinderSampleDynamicTabUI.b)g.b((AppCompatActivity)this.AyF).i(FinderSampleDynamicTabUI.b.class);
      locala = (a)new c("A2");
      localFinderSampleTabFragment = new FinderSampleTabUI.FinderSampleTabFragment();
      localFinderSampleTabFragment.title = 202;
      FinderTabUIC.a((FinderTabUIC)localObject, 2, locala, (FinderHomeTabFragment)localFinderSampleTabFragment);
      AppMethodBeat.o(276020);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(FinderSampleDynamicTabUI paramFinderSampleDynamicTabUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(285681);
      Object localObject = g.Xox;
      localObject = (FinderSampleDynamicTabUI.b)g.b((AppCompatActivity)this.AyF).i(FinderSampleDynamicTabUI.b.class);
      a locala = (a)new c("B1");
      FinderSampleTabUI.FinderSampleTabFragment localFinderSampleTabFragment = new FinderSampleTabUI.FinderSampleTabFragment();
      localFinderSampleTabFragment.title = 301;
      FinderTabUIC.a((FinderTabUIC)localObject, locala, (FinderHomeTabFragment)localFinderSampleTabFragment);
      localObject = g.Xox;
      localObject = (FinderSampleDynamicTabUI.b)g.b((AppCompatActivity)this.AyF).i(FinderSampleDynamicTabUI.b.class);
      locala = (a)new c("B2");
      localFinderSampleTabFragment = new FinderSampleTabUI.FinderSampleTabFragment();
      localFinderSampleTabFragment.title = 302;
      FinderTabUIC.a((FinderTabUIC)localObject, locala, (FinderHomeTabFragment)localFinderSampleTabFragment);
      localObject = g.Xox;
      localObject = (FinderSampleDynamicTabUI.b)g.b((AppCompatActivity)this.AyF).i(FinderSampleDynamicTabUI.b.class);
      locala = (a)new c("B3");
      localFinderSampleTabFragment = new FinderSampleTabUI.FinderSampleTabFragment();
      localFinderSampleTabFragment.title = 303;
      FinderTabUIC.a((FinderTabUIC)localObject, locala, (FinderHomeTabFragment)localFinderSampleTabFragment);
      AppMethodBeat.o(285681);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(FinderSampleDynamicTabUI paramFinderSampleDynamicTabUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(291292);
      g localg = g.Xox;
      FinderTabUIC.c((FinderSampleDynamicTabUI.b)g.b((AppCompatActivity)this.AyF).i(FinderSampleDynamicTabUI.b.class), 3);
      AppMethodBeat.o(291292);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(FinderSampleDynamicTabUI paramFinderSampleDynamicTabUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(263688);
      g localg = g.Xox;
      FinderTabUIC.c((FinderSampleDynamicTabUI.b)g.b((AppCompatActivity)this.AyF).i(FinderSampleDynamicTabUI.b.class), 0);
      localg = g.Xox;
      ((FinderSampleDynamicTabUI.b)g.b((AppCompatActivity)this.AyF).i(FinderSampleDynamicTabUI.b.class)).elv();
      localg = g.Xox;
      ((FinderSampleDynamicTabUI.b)g.b((AppCompatActivity)this.AyF).i(FinderSampleDynamicTabUI.b.class)).elv();
      AppMethodBeat.o(263688);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.sample.FinderSampleDynamicTabUI
 * JD-Core Version:    0.7.0.1
 */