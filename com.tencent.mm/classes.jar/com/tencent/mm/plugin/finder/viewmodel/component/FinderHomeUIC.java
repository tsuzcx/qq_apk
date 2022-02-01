package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hj;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.d;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment;
import com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.view.f;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "fragmentChangeListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "getFragmentChangeListeners", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "fragmentChangeObserver", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1;", "fragments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "getFragments", "()Ljava/util/ArrayList;", "isCreated", "", "lastIndex", "", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "getActiveFragment", "getActiveView", "Landroid/view/View;", "getCurrentTabType", "getIndex", "type", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "setCurrentTabType", "Companion", "plugin-finder_release"})
public final class FinderHomeUIC
  extends UIComponent
{
  public static final FinderHomeUIC.a sdS;
  private boolean czD;
  final ArrayList<FinderHomeTabFragment> fragments;
  private int lastIndex;
  private final com.tencent.mm.sdk.b.c<hj> rhM;
  private final FinderHomeTabStateVM rjC;
  final CopyOnWriteArraySet<f> sdQ;
  private final c sdR;
  
  static
  {
    AppMethodBeat.i(204550);
    sdS = new FinderHomeUIC.a((byte)0);
    AppMethodBeat.o(204550);
  }
  
  public FinderHomeUIC(final MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(204549);
    this.fragments = j.ab(new FinderHomeTabFragment[] { (FinderHomeTabFragment)new FinderFollowTabFragment(), (FinderHomeTabFragment)new FinderFriendTabFragment(), (FinderHomeTabFragment)new FinderMachineTabFragment() });
    Object localObject = com.tencent.mm.ui.component.a.IrY;
    localObject = com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class);
    k.g(localObject, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.rjC = ((FinderHomeTabStateVM)localObject);
    this.sdQ = new CopyOnWriteArraySet();
    this.lastIndex = -1;
    this.sdR = new c(this, paramMMActivity, paramMMActivity, (List)this.fragments);
    this.rhM = ((com.tencent.mm.sdk.b.c)new b(this));
    AppMethodBeat.o(204549);
  }
  
  private final int getIndex(int paramInt)
  {
    AppMethodBeat.i(204547);
    Iterator localIterator = ((List)this.fragments).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((FinderHomeTabFragment)localIterator.next()).diw == paramInt)
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
      ac.e("Finder.HomeUIC", "[getIndex] type=" + paramInt + " is invalid.");
      AppMethodBeat.o(204547);
      return 0;
      j = 0;
      break label50;
      label96:
      i += 1;
      break;
      i = -1;
    }
    label108:
    AppMethodBeat.o(204547);
    return i;
  }
  
  public final void Fb(int paramInt)
  {
    AppMethodBeat.i(204545);
    int i = getIndex(paramInt);
    int j = this.fragments.size();
    if (i < 0)
    {
      AppMethodBeat.o(204545);
      return;
    }
    if (j > i)
    {
      FinderViewPager localFinderViewPager = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131308061);
      k.g(localFinderViewPager, "activity.viewPager");
      localFinderViewPager.setCurrentItem(i);
      this.rjC.sbQ = paramInt;
    }
    AppMethodBeat.o(204545);
  }
  
  public final void Z(Bundle paramBundle)
  {
    AppMethodBeat.i(204543);
    super.Z(paramBundle);
    Fb(this.rjC.cFJ());
    AppMethodBeat.o(204543);
  }
  
  public final int cFV()
  {
    AppMethodBeat.i(204546);
    if (this.czD)
    {
      i = getActiveFragment().diw;
      AppMethodBeat.o(204546);
      return i;
    }
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
    int i = ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class)).cFJ();
    AppMethodBeat.o(204546);
    return i;
  }
  
  public final FinderHomeTabFragment getActiveFragment()
  {
    AppMethodBeat.i(204548);
    Object localObject = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131308061);
    if (localObject == null) {
      ac.e("Finder.HomeUIC", "[getActiveFragment] viewPager==null lastIndex=" + this.lastIndex);
    }
    if (localObject != null) {}
    for (int i = ((FinderViewPager)localObject).getCurrentItem();; i = this.lastIndex)
    {
      localObject = this.fragments.get(i);
      k.g(localObject, "fragments[index]");
      localObject = (FinderHomeTabFragment)localObject;
      AppMethodBeat.o(204548);
      return localObject;
    }
  }
  
  public final int getLayoutId()
  {
    return 2131496211;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204542);
    com.tencent.mm.ac.c.b(null, (d.g.a.a)FinderHomeUIC.e.sdV);
    final int i = getIntent().getIntExtra("FROM_SCENE_KEY", 2);
    paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    k.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramBundle).getRedDotManager().Dw(i);
    paramBundle = com.tencent.mm.plugin.finder.storage.b.rCU;
    com.tencent.mm.plugin.finder.storage.b.cAo();
    i = this.rjC.cFJ();
    this.rhM.alive();
    paramBundle = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131308061);
    k.g(paramBundle, "this");
    android.support.v4.app.g localg = getActivity().getSupportFragmentManager();
    k.g(localg, "activity.supportFragmentManager");
    paramBundle.setAdapter((q)new com.tencent.mm.plugin.finder.view.adapter.a(localg, (List)this.fragments));
    paramBundle.addOnPageChangeListener((ViewPager.OnPageChangeListener)this.sdR);
    paramBundle.setOffscreenPageLimit(4);
    paramBundle.post((Runnable)new d(this, i));
    paramBundle = v.rve;
    v.startTimer();
    this.czD = true;
    ac.i("Finder.HomeUIC", "[onCreate] lastTabType=" + this.rjC.cFJ() + " index=" + getIndex(i) + " tabType=" + i);
    AppMethodBeat.o(204542);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204544);
    super.onDestroy();
    FinderHomeTabStateVM.a(getActiveFragment().diw, FinderHomeTabStateVM.c.sca);
    this.rjC.ET(getActiveFragment().diw);
    Object localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    k.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().ctH();
    this.rhM.dead();
    localObject = v.rve;
    v.stopTimer();
    AppMethodBeat.o(204544);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$eventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.sdk.b.c<hj>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "plugin-finder_release"})
  public static final class c
    extends FinderFragmentChangeObserver
  {
    c(MMActivity paramMMActivity1, MMActivity paramMMActivity2, List paramList)
    {
      super(localList);
    }
    
    public final void D(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(204538);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramInt2);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramInt3);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramInt4);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onFragmentChange", "(IIII)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aeE());
      FinderHomeUIC.b(this.sdT).sbQ = paramInt4;
      FinderHomeUIC.b(this.sdT, paramInt2);
      localObject = com.tencent.mm.ui.component.a.IrY;
      localObject = com.tencent.mm.ui.component.a.q(paramMMActivity).get(FinderHomeActionBarUIC.class);
      k.g(localObject, "UICProvider.of(activity)…ActionBarUIC::class.java)");
      ((FinderHomeActionBarUIC)localObject).Fa(paramInt2);
      localObject = ((Iterable)this.sdT.sdQ).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((f)((Iterator)localObject).next()).D(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onFragmentChange", "(IIII)V");
      AppMethodBeat.o(204538);
    }
    
    public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
    {
      AppMethodBeat.i(204537);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).du(paramBoolean);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramInt);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bb(paramFinderHomeTabFragment);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aeE());
      k.h(paramFinderHomeTabFragment, "fragment");
      localObject = ((Iterable)this.sdT.sdQ).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((f)((Iterator)localObject).next()).a(paramBoolean, paramInt, paramFinderHomeTabFragment);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V");
      AppMethodBeat.o(204537);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$onCreate$2$1"})
  static final class d
    implements Runnable
  {
    d(FinderHomeUIC paramFinderHomeUIC, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(204539);
      Object localObject = com.tencent.mm.ui.component.a.IrY;
      localObject = com.tencent.mm.ui.component.a.q(this.sdT.getActivity()).get(FinderHomeActionBarUIC.class);
      k.g(localObject, "UICProvider.of(activity)…ActionBarUIC::class.java)");
      ((FinderHomeActionBarUIC)localObject).Fa(FinderHomeUIC.a(this.sdT, i));
      FinderHomeUIC.a(this.sdT).onPageSelected(FinderHomeUIC.a(this.sdT, i));
      AppMethodBeat.o(204539);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC
 * JD-Core Version:    0.7.0.1
 */