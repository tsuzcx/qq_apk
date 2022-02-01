package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.hr;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.view.h;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.component.UIComponent;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "fragmentChangeListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "getFragmentChangeListeners", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "fragmentChangeObserver", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1;", "fragments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "getFragments", "()Ljava/util/ArrayList;", "isCreated", "", "isFromSns", "lastIndex", "", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "getActiveFragment", "getActiveView", "Landroid/view/View;", "getCurrentTabType", "getFragmentByTabType", "tabType", "getIndex", "type", "getLayoutId", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onStop", "setCurrentTabType", "args", "Companion", "plugin-finder_release"})
public final class FinderHomeUIC
  extends UIComponent
{
  public static final FinderHomeUIC.a tmJ;
  private boolean cLi;
  final ArrayList<FinderHomeTabFragment> fragments;
  private int lastIndex;
  private final com.tencent.mm.sdk.b.c<hr> seA;
  private final FinderHomeTabStateVM sgM;
  private boolean tmG;
  final CopyOnWriteArraySet<h> tmH;
  private final c tmI;
  
  static
  {
    AppMethodBeat.i(206224);
    tmJ = new FinderHomeUIC.a((byte)0);
    AppMethodBeat.o(206224);
  }
  
  public FinderHomeUIC(final MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(206223);
    this.fragments = d.a.j.ab(new FinderHomeTabFragment[] { (FinderHomeTabFragment)new FinderFollowTabFragment(), (FinderHomeTabFragment)new FinderFriendTabFragment(), (FinderHomeTabFragment)new FinderMachineTabFragment() });
    Object localObject = com.tencent.mm.ui.component.a.KEX;
    localObject = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(localObject, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.sgM = ((FinderHomeTabStateVM)localObject);
    this.tmH = new CopyOnWriteArraySet();
    this.lastIndex = -1;
    this.tmI = new c(this, paramMMActivity, paramMMActivity, (List)this.fragments);
    this.seA = ((com.tencent.mm.sdk.b.c)new b(this));
    AppMethodBeat.o(206223);
  }
  
  private final int getIndex(int paramInt)
  {
    AppMethodBeat.i(206219);
    Iterator localIterator = ((List)this.fragments).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((FinderHomeTabFragment)localIterator.next()).dvm == paramInt)
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
      ae.e("Finder.HomeUIC", "[getIndex] type=" + paramInt + " is invalid.");
      AppMethodBeat.o(206219);
      return 0;
      j = 0;
      break label50;
      label96:
      i += 1;
      break;
      i = -1;
    }
    label108:
    AppMethodBeat.o(206219);
    return i;
  }
  
  public final FinderHomeTabFragment GO(int paramInt)
  {
    AppMethodBeat.i(206221);
    Object localObject = ((List)this.fragments).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject).hasNext()) {
      if (((FinderHomeTabFragment)((Iterator)localObject).next()).dvm == paramInt)
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
      ae.e("Finder.HomeUIC", "[getFragmentByTabType] type=" + paramInt + " is invalid.");
      AppMethodBeat.o(206221);
      return null;
      j = 0;
      break label50;
      label96:
      i += 1;
      break;
      i = -1;
    }
    label108:
    localObject = (FinderHomeTabFragment)this.fragments.get(i);
    AppMethodBeat.o(206221);
    return localObject;
  }
  
  public final void ad(Bundle paramBundle)
  {
    AppMethodBeat.i(206214);
    super.ad(paramBundle);
    int i = this.sgM.cQO();
    paramBundle = new Bundle();
    paramBundle.putInt("Source", 1);
    r(i, paramBundle);
    i = getIntent().getIntExtra("FROM_SCENE_KEY", 2);
    paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramBundle).getRedDotManager().EC(i);
    AppMethodBeat.o(206214);
  }
  
  public final int cQU()
  {
    AppMethodBeat.i(206218);
    if (this.cLi)
    {
      i = getActiveFragment().dvm;
      AppMethodBeat.o(206218);
      return i;
    }
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KEX;
    int i = ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).cQO();
    AppMethodBeat.o(206218);
    return i;
  }
  
  public final FinderHomeTabFragment getActiveFragment()
  {
    AppMethodBeat.i(206220);
    Object localObject = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131308061);
    if (localObject == null) {
      ae.e("Finder.HomeUIC", "[getActiveFragment] viewPager==null lastIndex=" + this.lastIndex);
    }
    if (localObject != null) {}
    for (int i = ((FinderViewPager)localObject).getCurrentItem();; i = this.lastIndex)
    {
      localObject = this.fragments.get(i);
      p.g(localObject, "fragments[index]");
      localObject = (FinderHomeTabFragment)localObject;
      AppMethodBeat.o(206220);
      return localObject;
    }
  }
  
  public final int getLayoutId()
  {
    return 2131496211;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(206222);
    if (this.tmG)
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
      localIntent.putExtra("preferred_tab", 2);
      d.f((Context)getActivity(), ".ui.LauncherUI", localIntent);
      getActivity().overridePendingTransition(MMFragmentActivity.a.mTk, MMFragmentActivity.a.mTl);
      AppMethodBeat.o(206222);
      return true;
    }
    AppMethodBeat.o(206222);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(206213);
    com.tencent.mm.ac.c.b(null, (d.g.a.a)FinderHomeUIC.e.tmM);
    paramBundle = com.tencent.mm.plugin.finder.storage.b.sHP;
    com.tencent.mm.plugin.finder.storage.b.cIE();
    final int i;
    if (getActivity().getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false))
    {
      i = 3;
      this.seA.alive();
      paramBundle = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131308061);
      p.g(paramBundle, "this");
      Object localObject = getActivity().getSupportFragmentManager();
      p.g(localObject, "activity.supportFragmentManager");
      paramBundle.setAdapter((q)new com.tencent.mm.plugin.finder.view.adapter.a((android.support.v4.app.g)localObject, (List)this.fragments));
      paramBundle.addOnPageChangeListener((ViewPager.OnPageChangeListener)this.tmI);
      paramBundle.setOffscreenPageLimit(4);
      paramBundle.post((Runnable)new d(this, i));
      localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
      int j = ((Number)com.tencent.mm.plugin.finder.storage.b.cJU().value()).intValue();
      if (j > 0)
      {
        localObject = s.sYo;
        s.a(paramBundle.getContext(), (FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131308061), j);
      }
      paramBundle = y.stw;
      y.startTimer();
      this.cLi = true;
      ae.i("Finder.HomeUIC", "[onCreate] lastTabType=" + this.sgM.cQO() + " index=" + getIndex(i) + " tabType=" + i);
      if ((getIntent().getLongExtra("key_finder_post_local_id", -1L) == -1L) || (!getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false))) {
        break label344;
      }
    }
    label344:
    for (boolean bool = true;; bool = false)
    {
      this.tmG = bool;
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().fG(14845, 7);
      AppMethodBeat.o(206213);
      return;
      i = this.sgM.cQO();
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(206216);
    super.onDestroy();
    this.sgM.a(getActiveFragment().dvm, FinderHomeTabStateVM.c.tkG);
    this.sgM.GG(getActiveFragment().dvm);
    this.seA.dead();
    Object localObject1 = y.stw;
    y.stopTimer();
    localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
    localObject1 = ((PluginFinder)localObject1).getRedDotManager();
    Object localObject2 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject2, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject2).ajA().set(am.a.JbQ, Long.valueOf(0L));
    ae.i("Finder.RedDotManager", "[resetPreFetchTime] done.");
    ((com.tencent.mm.plugin.finder.extension.reddot.e)localObject1).saD = (ch.aDc() - ((com.tencent.mm.plugin.finder.extension.reddot.e)localObject1).enterTime);
    long l;
    if ((((com.tencent.mm.plugin.finder.extension.reddot.e)localObject1).saF) && (((com.tencent.mm.plugin.finder.extension.reddot.e)localObject1).saE == 2))
    {
      l = ((com.tencent.mm.plugin.finder.extension.reddot.e)localObject1).saD;
      localObject2 = com.tencent.mm.plugin.finder.extension.reddot.j.sbM;
      if (l <= com.tencent.mm.plugin.finder.extension.reddot.j.cBX())
      {
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.j.sbM;
        int i = d.k.j.lx(com.tencent.mm.plugin.finder.extension.reddot.j.cCb() + 1, 3);
        ae.w("Finder.RedDotManager", "[exitFinder] current fastLevel=".concat(String.valueOf(i)));
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.j.sbM;
        com.tencent.mm.plugin.finder.extension.reddot.j.EI(i);
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.finder.extension.reddot.j.sbM;
      com.tencent.mm.plugin.finder.extension.reddot.j.cCd();
      AppMethodBeat.o(206216);
      return;
      l = ((com.tencent.mm.plugin.finder.extension.reddot.e)localObject1).saD;
      localObject1 = com.tencent.mm.plugin.finder.extension.reddot.j.sbM;
      if (l > com.tencent.mm.plugin.finder.extension.reddot.j.cBX())
      {
        ae.w("Finder.RedDotManager", "[exitFinder] revert fastLevel=0");
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.j.sbM;
        com.tencent.mm.plugin.finder.extension.reddot.j.EI(0);
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(206215);
    super.onStop();
    if (getActivity().isFinishing())
    {
      Object localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)localObject).getRedDotManager();
      ((com.tencent.mm.plugin.finder.extension.reddot.e)localObject).aih("FinderEntrance");
      ((com.tencent.mm.plugin.finder.extension.reddot.e)localObject).aih("Discovery");
    }
    AppMethodBeat.o(206215);
  }
  
  public final void r(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(206217);
    int i = getIndex(paramInt);
    int j = this.fragments.size();
    if (i < 0)
    {
      AppMethodBeat.o(206217);
      return;
    }
    if (j > i)
    {
      if (paramBundle != null) {
        ((FinderHomeTabFragment)this.fragments.get(i)).En = paramBundle;
      }
      this.sgM.tku = paramInt;
      paramBundle = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131308061);
      p.g(paramBundle, "activity.viewPager");
      paramBundle.setCurrentItem(i);
    }
    AppMethodBeat.o(206217);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$eventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.sdk.b.c<hr>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "plugin-finder_release"})
  public static final class c
    extends FinderFragmentChangeObserver
  {
    c(MMActivity paramMMActivity1, MMActivity paramMMActivity2, List paramList)
    {
      super(localList);
    }
    
    public final void D(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(206209);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramInt2);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramInt3);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramInt4);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onFragmentChange", "(IIII)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      FinderHomeUIC.b(this.tmK).tku = paramInt4;
      FinderHomeUIC.b(this.tmK, paramInt2);
      localObject = com.tencent.mm.ui.component.a.KEX;
      localObject = com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderHomeActionBarUIC.class);
      p.g(localObject, "UICProvider.of(activity)…ActionBarUIC::class.java)");
      ((FinderHomeActionBarUIC)localObject).GM(paramInt2);
      localObject = ((Iterable)this.tmK.tmH).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((h)((Iterator)localObject).next()).D(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onFragmentChange", "(IIII)V");
      AppMethodBeat.o(206209);
    }
    
    public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
    {
      AppMethodBeat.i(206208);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).dx(paramBoolean);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramInt);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramFinderHomeTabFragment);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      p.h(paramFinderHomeTabFragment, "fragment");
      localObject = ((Iterable)this.tmK.tmH).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((h)((Iterator)localObject).next()).a(paramBoolean, paramInt, paramFinderHomeTabFragment);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V");
      AppMethodBeat.o(206208);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$onCreate$2$1"})
  static final class d
    implements Runnable
  {
    d(FinderHomeUIC paramFinderHomeUIC, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(206210);
      Object localObject = com.tencent.mm.ui.component.a.KEX;
      localObject = com.tencent.mm.ui.component.a.s(this.tmK.getActivity()).get(FinderHomeActionBarUIC.class);
      p.g(localObject, "UICProvider.of(activity)…ActionBarUIC::class.java)");
      ((FinderHomeActionBarUIC)localObject).GM(FinderHomeUIC.a(this.tmK, i));
      FinderHomeUIC.a(this.tmK).onPageSelected(FinderHomeUIC.a(this.tmK, i));
      AppMethodBeat.o(206210);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC
 * JD-Core Version:    0.7.0.1
 */