package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment;
import com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import d.a.j;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "fragmentChangeListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "getFragmentChangeListeners", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "fragmentChangeObserver", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1;", "fragments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "getFragments", "()Ljava/util/ArrayList;", "isCreated", "", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "getActiveFragment", "getActiveView", "Landroid/view/View;", "getCurrentTabType", "", "getIndex", "type", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setCurrentTabType", "Companion", "plugin-finder_release"})
public final class FinderHomeUIC
  extends UIComponent
{
  public static final a Lip;
  private final FinderHomeTabStateVM KOa;
  final CopyOnWriteArraySet<com.tencent.mm.plugin.finder.view.g> Lin;
  private final c Lio;
  private boolean cCu;
  final ArrayList<FinderHomeTabFragment> fragments;
  private final com.tencent.mm.sdk.b.c<yo> xpb;
  
  static
  {
    AppMethodBeat.i(200424);
    Lip = new a((byte)0);
    AppMethodBeat.o(200424);
  }
  
  public FinderHomeUIC(final MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(200423);
    this.fragments = j.Z(new FinderHomeTabFragment[] { (FinderHomeTabFragment)new FinderFollowTabFragment(), (FinderHomeTabFragment)new FinderFriendTabFragment(), (FinderHomeTabFragment)new FinderMachineTabFragment() });
    Object localObject = com.tencent.mm.ui.component.a.LCX;
    localObject = com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class);
    k.g(localObject, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.KOa = ((FinderHomeTabStateVM)localObject);
    this.Lin = new CopyOnWriteArraySet();
    this.Lio = new c(this, paramMMActivity, paramMMActivity, (List)this.fragments);
    this.xpb = ((com.tencent.mm.sdk.b.c)new b(this));
    AppMethodBeat.o(200423);
  }
  
  private final int getIndex(int paramInt)
  {
    AppMethodBeat.i(200421);
    Iterator localIterator = ((List)this.fragments).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((FinderHomeTabFragment)localIterator.next()).IoU == paramInt)
      {
        j = 1;
        label50:
        if (j == 0) {
          break label96;
        }
      }
    }
    for (;;)
    {
      if (i >= 0) {
        break label108;
      }
      ad.e("Finder.HomeUIC", "[getIndex] type=" + paramInt + " is invalid.");
      AppMethodBeat.o(200421);
      return 0;
      j = 0;
      break label50;
      label96:
      i += 1;
      break;
      i = -1;
    }
    label108:
    AppMethodBeat.o(200421);
    return i;
  }
  
  public final void ahU(int paramInt)
  {
    AppMethodBeat.i(200419);
    int i = getIndex(paramInt);
    int j = this.fragments.size();
    if (i < 0)
    {
      AppMethodBeat.o(200419);
      return;
    }
    if (j > i)
    {
      FinderViewPager localFinderViewPager = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131307918);
      k.g(localFinderViewPager, "activity.viewPager");
      localFinderViewPager.setCurrentItem(i);
      this.KOa.Lha = paramInt;
    }
    AppMethodBeat.o(200419);
  }
  
  public final int fXm()
  {
    AppMethodBeat.i(200420);
    if (this.cCu)
    {
      i = getActiveFragment().IoU;
      AppMethodBeat.o(200420);
      return i;
    }
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.LCX;
    com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class);
    int i = FinderHomeTabStateVM.fXh();
    AppMethodBeat.o(200420);
    return i;
  }
  
  public final FinderHomeTabFragment getActiveFragment()
  {
    AppMethodBeat.i(200422);
    Object localObject = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131307918);
    k.g(localObject, "activity.viewPager");
    int i = ((FinderViewPager)localObject).getCurrentItem();
    localObject = this.fragments.get(i);
    k.g(localObject, "fragments[index]");
    localObject = (FinderHomeTabFragment)localObject;
    AppMethodBeat.o(200422);
    return localObject;
  }
  
  public final int getLayoutId()
  {
    return 2131496210;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(200417);
    com.tencent.mm.ad.c.b(null, (d.g.a.a)e.Lis);
    final int i = getIntent().getIntExtra("FROM_SCENE_KEY", 2);
    paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    k.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramBundle).getRedDotManager().Cy(i);
    i = FinderHomeTabStateVM.fXh();
    this.xpb.alive();
    paramBundle = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131307918);
    k.g(paramBundle, "this");
    android.support.v4.app.g localg = getActivity().getSupportFragmentManager();
    k.g(localg, "activity.supportFragmentManager");
    paramBundle.setAdapter((android.support.v4.view.q)new com.tencent.mm.plugin.finder.view.adapter.a(localg, (List)this.fragments));
    paramBundle.addOnPageChangeListener((ViewPager.OnPageChangeListener)this.Lio);
    paramBundle.setOffscreenPageLimit(4);
    paramBundle.post((Runnable)new d(this, i));
    ahU(i);
    paramBundle = com.tencent.mm.plugin.finder.model.q.qDO;
    com.tencent.mm.plugin.finder.model.q.startTimer();
    this.cCu = true;
    ad.i("Finder.HomeUIC", "[onCreate] lastTabType=" + FinderHomeTabStateVM.fXh() + " index=" + getIndex(i) + " tabType=" + i);
    AppMethodBeat.o(200417);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(200418);
    super.onDestroy();
    this.KOa.a(getActiveFragment().IoU, FinderHomeTabStateVM.c.Lhk);
    Object localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    k.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().fSI();
    this.xpb.dead();
    localObject = com.tencent.mm.plugin.finder.model.q.qDO;
    com.tencent.mm.plugin.finder.model.q.stopTimer();
    AppMethodBeat.o(200418);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$eventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.sdk.b.c<yo>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "plugin-finder_release"})
  public static final class c
    extends FinderFragmentChangeObserver
  {
    c(MMActivity paramMMActivity1, MMActivity paramMMActivity2, List paramList)
    {
      super(localList);
    }
    
    public final void X(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(200413);
      Object localObject = new b();
      ((b)localObject).lT(paramInt1);
      ((b)localObject).lT(paramInt2);
      ((b)localObject).lT(paramInt3);
      ((b)localObject).lT(paramInt4);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onFragmentChange", "(IIII)V", this, ((b)localObject).ado());
      FinderHomeUIC.b(this.Liq).Lha = paramInt4;
      localObject = com.tencent.mm.ui.component.a.LCX;
      localObject = com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderHomeActionBarUIC.class);
      k.g(localObject, "UICProvider.of(activity)…ActionBarUIC::class.java)");
      ((FinderHomeActionBarUIC)localObject).ahT(paramInt2);
      localObject = ((Iterable)this.Liq.Lin).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.finder.view.g)((Iterator)localObject).next()).X(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onFragmentChange", "(IIII)V");
      AppMethodBeat.o(200413);
    }
    
    public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
    {
      AppMethodBeat.i(200412);
      Object localObject = new b();
      ((b)localObject).du(paramBoolean);
      ((b)localObject).lT(paramInt);
      ((b)localObject).be(paramFinderHomeTabFragment);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", this, ((b)localObject).ado());
      k.h(paramFinderHomeTabFragment, "fragment");
      localObject = ((Iterable)this.Liq.Lin).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.finder.view.g)((Iterator)localObject).next()).a(paramBoolean, paramInt, paramFinderHomeTabFragment);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V");
      AppMethodBeat.o(200412);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$onCreate$2$1"})
  static final class d
    implements Runnable
  {
    d(FinderHomeUIC paramFinderHomeUIC, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(200414);
      Object localObject = com.tencent.mm.ui.component.a.LCX;
      localObject = com.tencent.mm.ui.component.a.s(this.Liq.getActivity()).get(FinderHomeActionBarUIC.class);
      k.g(localObject, "UICProvider.of(activity)…ActionBarUIC::class.java)");
      ((FinderHomeActionBarUIC)localObject).ahT(FinderHomeUIC.a(this.Liq, i));
      FinderHomeUIC.a(this.Liq).onPageSelected(FinderHomeUIC.a(this.Liq, i));
      AppMethodBeat.o(200414);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final e Lis;
    
    static
    {
      AppMethodBeat.i(200416);
      Lis = new e();
      AppMethodBeat.o(200416);
    }
    
    e()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC
 * JD-Core Version:    0.7.0.1
 */