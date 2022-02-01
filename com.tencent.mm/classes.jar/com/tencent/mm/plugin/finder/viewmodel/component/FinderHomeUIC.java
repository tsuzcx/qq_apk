package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.hq;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.component.UIComponent;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "fragmentChangeListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "getFragmentChangeListeners", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "fragmentChangeObserver", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1;", "fragments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "getFragments", "()Ljava/util/ArrayList;", "isCreated", "", "isFromSns", "lastIndex", "", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "getActiveFragment", "getActiveView", "Landroid/view/View;", "getCurrentTabType", "getFragmentByTabType", "tabType", "getIndex", "type", "getLayoutId", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onStop", "setCurrentTabType", "args", "Companion", "plugin-finder_release"})
public final class FinderHomeUIC
  extends UIComponent
{
  public static final a tbP;
  private boolean cKz;
  final ArrayList<FinderHomeTabFragment> fragments;
  private int lastIndex;
  private final com.tencent.mm.sdk.b.c<hq> rVT;
  private final FinderHomeTabStateVM rYa;
  private boolean tbM;
  final CopyOnWriteArraySet<com.tencent.mm.plugin.finder.view.h> tbN;
  private final c tbO;
  
  static
  {
    AppMethodBeat.i(205597);
    tbP = new a((byte)0);
    AppMethodBeat.o(205597);
  }
  
  public FinderHomeUIC(final MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(205596);
    this.fragments = d.a.j.ac(new FinderHomeTabFragment[] { (FinderHomeTabFragment)new FinderFollowTabFragment(), (FinderHomeTabFragment)new FinderFriendTabFragment(), (FinderHomeTabFragment)new FinderMachineTabFragment() });
    Object localObject = com.tencent.mm.ui.component.a.KiD;
    localObject = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(localObject, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.rYa = ((FinderHomeTabStateVM)localObject);
    this.tbN = new CopyOnWriteArraySet();
    this.lastIndex = -1;
    this.tbO = new c(this, paramMMActivity, paramMMActivity, (List)this.fragments);
    this.rVT = ((com.tencent.mm.sdk.b.c)new b(this));
    AppMethodBeat.o(205596);
  }
  
  private final int getIndex(int paramInt)
  {
    AppMethodBeat.i(205592);
    Iterator localIterator = ((List)this.fragments).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((FinderHomeTabFragment)localIterator.next()).duh == paramInt)
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
      AppMethodBeat.o(205592);
      return 0;
      j = 0;
      break label50;
      label96:
      i += 1;
      break;
      i = -1;
    }
    label108:
    AppMethodBeat.o(205592);
    return i;
  }
  
  public final FinderHomeTabFragment Gr(int paramInt)
  {
    AppMethodBeat.i(205594);
    Object localObject = ((List)this.fragments).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject).hasNext()) {
      if (((FinderHomeTabFragment)((Iterator)localObject).next()).duh == paramInt)
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
      ad.e("Finder.HomeUIC", "[getFragmentByTabType] type=" + paramInt + " is invalid.");
      AppMethodBeat.o(205594);
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
    AppMethodBeat.o(205594);
    return localObject;
  }
  
  public final void ac(Bundle paramBundle)
  {
    AppMethodBeat.i(205587);
    super.ac(paramBundle);
    int i = this.rYa.fsM();
    paramBundle = new Bundle();
    paramBundle.putInt("Source", 1);
    r(i, paramBundle);
    paramBundle = com.tencent.mm.util.c.LgD;
    if (com.tencent.mm.util.c.fNM())
    {
      paramBundle = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.thumbplayer.a.a.class);
      p.g(paramBundle, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
      if (((com.tencent.mm.plugin.thumbplayer.a.a)paramBundle).isOpenTPPlayer())
      {
        Toast.makeText((Context)getActivity(), (CharSequence)"Use TPPlayer（返回长按放大镜更改）", 0).show();
        AppMethodBeat.o(205587);
        return;
      }
      Toast.makeText((Context)getActivity(), (CharSequence)"Use MMPlayer（返回长按放大镜更改）", 0).show();
    }
    AppMethodBeat.o(205587);
  }
  
  public final int cOp()
  {
    AppMethodBeat.i(205591);
    if (this.cKz)
    {
      i = getActiveFragment().duh;
      AppMethodBeat.o(205591);
      return i;
    }
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KiD;
    int i = ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).fsM();
    AppMethodBeat.o(205591);
    return i;
  }
  
  public final FinderHomeTabFragment getActiveFragment()
  {
    AppMethodBeat.i(205593);
    Object localObject = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131308061);
    if (localObject == null) {
      ad.e("Finder.HomeUIC", "[getActiveFragment] viewPager==null lastIndex=" + this.lastIndex);
    }
    if (localObject != null) {}
    for (int i = ((FinderViewPager)localObject).getCurrentItem();; i = this.lastIndex)
    {
      localObject = this.fragments.get(i);
      p.g(localObject, "fragments[index]");
      localObject = (FinderHomeTabFragment)localObject;
      AppMethodBeat.o(205593);
      return localObject;
    }
  }
  
  public final int getLayoutId()
  {
    return 2131496211;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(205595);
    if (this.tbM)
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
      localIntent.putExtra("preferred_tab", 2);
      d.f((Context)getActivity(), ".ui.LauncherUI", localIntent);
      getActivity().overridePendingTransition(MMFragmentActivity.a.mOg, MMFragmentActivity.a.mOh);
      AppMethodBeat.o(205595);
      return true;
    }
    AppMethodBeat.o(205595);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(205586);
    com.tencent.mm.ad.c.b(null, (d.g.a.a)e.tbS);
    final int i = getIntent().getIntExtra("FROM_SCENE_KEY", 2);
    paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramBundle).getRedDotManager().Ep(i);
    paramBundle = com.tencent.mm.plugin.finder.storage.b.sxa;
    com.tencent.mm.plugin.finder.storage.b.cGH();
    if (getActivity().getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false))
    {
      i = 3;
      this.rVT.alive();
      paramBundle = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131308061);
      p.g(paramBundle, "this");
      Object localObject = getActivity().getSupportFragmentManager();
      p.g(localObject, "activity.supportFragmentManager");
      paramBundle.setAdapter((android.support.v4.view.q)new com.tencent.mm.plugin.finder.view.adapter.a((android.support.v4.app.g)localObject, (List)this.fragments));
      paramBundle.addOnPageChangeListener((ViewPager.OnPageChangeListener)this.tbO);
      paramBundle.setOffscreenPageLimit(4);
      paramBundle.post((Runnable)new d(this, i));
      localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
      int j = ((Number)com.tencent.mm.plugin.finder.storage.b.cHY().value()).intValue();
      if (j > 0)
      {
        localObject = s.sNd;
        s.a(paramBundle.getContext(), (FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131308061), j);
      }
      paramBundle = x.skz;
      x.startTimer();
      this.cKz = true;
      ad.i("Finder.HomeUIC", "[onCreate] lastTabType=" + this.rYa.fsM() + " index=" + getIndex(i) + " tabType=" + i);
      if ((getIntent().getLongExtra("key_finder_post_local_id", -1L) == -1L) || (!getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false))) {
        break label359;
      }
    }
    label359:
    for (boolean bool = true;; bool = false)
    {
      this.tbM = bool;
      AppMethodBeat.o(205586);
      return;
      i = this.rYa.fsM();
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(205589);
    super.onDestroy();
    this.rYa.a(getActiveFragment().duh, FinderHomeTabStateVM.c.sZs);
    this.rYa.Gh(getActiveFragment().duh);
    this.rVT.dead();
    Object localObject1 = x.skz;
    x.stopTimer();
    localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
    localObject1 = ((PluginFinder)localObject1).getRedDotManager();
    Object localObject2 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject2, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject2).ajl().set(al.a.IHn, Long.valueOf(0L));
    ad.i("Finder.RedDotManager", "[resetPreFetchTime] done.");
    ((com.tencent.mm.plugin.finder.extension.reddot.e)localObject1).rSa = (cf.aCM() - ((com.tencent.mm.plugin.finder.extension.reddot.e)localObject1).enterTime);
    long l;
    if ((((com.tencent.mm.plugin.finder.extension.reddot.e)localObject1).rSc) && (((com.tencent.mm.plugin.finder.extension.reddot.e)localObject1).rSb == 2))
    {
      l = ((com.tencent.mm.plugin.finder.extension.reddot.e)localObject1).rSa;
      localObject2 = com.tencent.mm.plugin.finder.extension.reddot.j.rTk;
      if (l <= com.tencent.mm.plugin.finder.extension.reddot.j.cAq())
      {
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.j.rTk;
        int i = d.k.h.lq(com.tencent.mm.plugin.finder.extension.reddot.j.cAu() + 1, 3);
        ad.w("Finder.RedDotManager", "[exitFinder] current fastLevel=".concat(String.valueOf(i)));
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.j.rTk;
        com.tencent.mm.plugin.finder.extension.reddot.j.Ev(i);
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.finder.extension.reddot.j.rTk;
      com.tencent.mm.plugin.finder.extension.reddot.j.cAw();
      AppMethodBeat.o(205589);
      return;
      l = ((com.tencent.mm.plugin.finder.extension.reddot.e)localObject1).rSa;
      localObject1 = com.tencent.mm.plugin.finder.extension.reddot.j.rTk;
      if (l > com.tencent.mm.plugin.finder.extension.reddot.j.cAq())
      {
        ad.w("Finder.RedDotManager", "[exitFinder] revert fastLevel=0");
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.j.rTk;
        com.tencent.mm.plugin.finder.extension.reddot.j.Ev(0);
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(205588);
    super.onStop();
    if (getActivity().isFinishing())
    {
      Object localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)localObject).getRedDotManager();
      ((com.tencent.mm.plugin.finder.extension.reddot.e)localObject).ahl("FinderEntrance");
      ((com.tencent.mm.plugin.finder.extension.reddot.e)localObject).ahl("Discovery");
    }
    AppMethodBeat.o(205588);
  }
  
  public final void r(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(205590);
    int i = getIndex(paramInt);
    int j = this.fragments.size();
    if (i < 0)
    {
      AppMethodBeat.o(205590);
      return;
    }
    if (j > i)
    {
      if (paramBundle != null) {
        ((FinderHomeTabFragment)this.fragments.get(i)).En = paramBundle;
      }
      this.rYa.sZg = paramInt;
      paramBundle = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131308061);
      p.g(paramBundle, "activity.viewPager");
      paramBundle.setCurrentItem(i);
    }
    AppMethodBeat.o(205590);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$eventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.sdk.b.c<hq>
  {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "plugin-finder_release"})
  public static final class c
    extends FinderFragmentChangeObserver
  {
    c(MMActivity paramMMActivity1, MMActivity paramMMActivity2, List paramList)
    {
      super(localList);
    }
    
    public final void D(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(205582);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramInt2);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramInt3);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramInt4);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onFragmentChange", "(IIII)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      FinderHomeUIC.b(this.tbQ).sZg = paramInt4;
      FinderHomeUIC.b(this.tbQ, paramInt2);
      localObject = com.tencent.mm.ui.component.a.KiD;
      localObject = com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderHomeActionBarUIC.class);
      p.g(localObject, "UICProvider.of(activity)…ActionBarUIC::class.java)");
      ((FinderHomeActionBarUIC)localObject).Gq(paramInt2);
      localObject = ((Iterable)this.tbQ.tbN).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.finder.view.h)((Iterator)localObject).next()).D(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onFragmentChange", "(IIII)V");
      AppMethodBeat.o(205582);
    }
    
    public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
    {
      AppMethodBeat.i(205581);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).dw(paramBoolean);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramInt);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramFinderHomeTabFragment);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      p.h(paramFinderHomeTabFragment, "fragment");
      localObject = ((Iterable)this.tbQ.tbN).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.finder.view.h)((Iterator)localObject).next()).a(paramBoolean, paramInt, paramFinderHomeTabFragment);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V");
      AppMethodBeat.o(205581);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$onCreate$2$1"})
  static final class d
    implements Runnable
  {
    d(FinderHomeUIC paramFinderHomeUIC, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(205583);
      Object localObject = com.tencent.mm.ui.component.a.KiD;
      localObject = com.tencent.mm.ui.component.a.s(this.tbQ.getActivity()).get(FinderHomeActionBarUIC.class);
      p.g(localObject, "UICProvider.of(activity)…ActionBarUIC::class.java)");
      ((FinderHomeActionBarUIC)localObject).Gq(FinderHomeUIC.a(this.tbQ, i));
      FinderHomeUIC.a(this.tbQ).onPageSelected(FinderHomeUIC.a(this.tbQ, i));
      AppMethodBeat.o(205583);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    public static final e tbS;
    
    static
    {
      AppMethodBeat.i(205585);
      tbS = new e();
      AppMethodBeat.o(205585);
    }
    
    e()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC
 * JD-Core Version:    0.7.0.1
 */