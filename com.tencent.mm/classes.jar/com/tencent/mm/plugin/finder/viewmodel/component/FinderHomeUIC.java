package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.if;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.e;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.i.a;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.report.live.s.j;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.view.h;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.c;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.component.UIComponent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "fragmentChangeListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "getFragmentChangeListeners", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "fragmentChangeObserver", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1;", "fragments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "getFragments", "()Ljava/util/ArrayList;", "isCreated", "", "isFromSns", "lastIndex", "", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "getActiveFragment", "getActiveView", "Landroid/view/View;", "getCurrentTabType", "getForceJumpTabType", "getFragmentByTabType", "tabType", "getIndex", "type", "getLayoutId", "isForceJump", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onPause", "onResume", "onStop", "setCurrentTabType", "args", "withAnim", "Companion", "plugin-finder_release"})
public final class FinderHomeUIC
  extends UIComponent
{
  public static final a wxl;
  private boolean dbG;
  final ArrayList<FinderHomeTabFragment> fragments;
  private int lastIndex;
  private final IListener<if> tOh;
  private final FinderHomeTabStateVM tlCache;
  private boolean wxc;
  final CopyOnWriteArraySet<h> wxj;
  private final c wxk;
  
  static
  {
    AppMethodBeat.i(255652);
    wxl = new a((byte)0);
    AppMethodBeat.o(255652);
  }
  
  public FinderHomeUIC(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255651);
    Object localObject = com.tencent.mm.kernel.g.af(ad.class);
    p.g(localObject, "MMKernel.service(IFinder…enModeConfig::class.java)");
    boolean bool = ((ad)localObject).dxX();
    if (bool == true) {}
    for (localObject = j.ac(new FinderHomeTabFragment[] { (FinderHomeTabFragment)new FinderFollowTabFragment() });; localObject = j.ac(new FinderHomeTabFragment[] { (FinderHomeTabFragment)new FinderFollowTabFragment(), (FinderHomeTabFragment)new FinderFriendTabFragment(), (FinderHomeTabFragment)new FinderMachineTabFragment() }))
    {
      this.fragments = ((ArrayList)localObject);
      localObject = com.tencent.mm.ui.component.a.PRN;
      localObject = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
      p.g(localObject, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
      this.tlCache = ((FinderHomeTabStateVM)localObject);
      this.wxj = new CopyOnWriteArraySet();
      this.lastIndex = -1;
      this.wxk = new c(this, paramAppCompatActivity, (MMActivity)paramAppCompatActivity, (List)this.fragments);
      this.tOh = ((IListener)new b(this));
      AppMethodBeat.o(255651);
      return;
      if (bool) {
        break;
      }
    }
    paramAppCompatActivity = new m();
    AppMethodBeat.o(255651);
    throw paramAppCompatActivity;
  }
  
  private final int dIg()
  {
    AppMethodBeat.i(255646);
    boolean bool1 = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);
    boolean bool2 = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB", false);
    boolean bool3 = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", false);
    if (bool1)
    {
      AppMethodBeat.o(255646);
      return 3;
    }
    if (bool2)
    {
      AppMethodBeat.o(255646);
      return 1;
    }
    if (bool3)
    {
      AppMethodBeat.o(255646);
      return 4;
    }
    AppMethodBeat.o(255646);
    return -1;
  }
  
  private final boolean dIh()
  {
    AppMethodBeat.i(255647);
    boolean bool1 = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);
    boolean bool2 = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB", false);
    boolean bool3 = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", false);
    if ((bool1) || (bool2) || (bool3))
    {
      AppMethodBeat.o(255647);
      return true;
    }
    AppMethodBeat.o(255647);
    return false;
  }
  
  public final void a(boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(255644);
    int i = getIndex(4);
    int j = this.fragments.size();
    if (i < 0)
    {
      AppMethodBeat.o(255644);
      return;
    }
    if (j > i)
    {
      ((FinderHomeTabFragment)this.fragments.get(i)).Ew = paramBundle;
      this.tlCache.wtW = 4;
      ((FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131309856)).setCurrentItem(i, paramBoolean);
    }
    AppMethodBeat.o(255644);
  }
  
  public final int dIf()
  {
    AppMethodBeat.i(255645);
    if (this.dbG)
    {
      i = getActiveFragment().dLS;
      AppMethodBeat.o(255645);
      return i;
    }
    if (dIh())
    {
      i = dIg();
      AppMethodBeat.o(255645);
      return i;
    }
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
    int i = ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).dHR();
    AppMethodBeat.o(255645);
    return i;
  }
  
  public final FinderHomeTabFragment getActiveFragment()
  {
    AppMethodBeat.i(255649);
    Object localObject = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131309856);
    if (localObject == null) {
      Log.e("Finder.HomeUIC", "[getActiveFragment] viewPager==null lastIndex=" + this.lastIndex);
    }
    if (localObject != null) {}
    for (int i = ((FinderViewPager)localObject).getCurrentItem();; i = this.lastIndex)
    {
      localObject = this.fragments.get(i);
      p.g(localObject, "fragments[index]");
      localObject = (FinderHomeTabFragment)localObject;
      AppMethodBeat.o(255649);
      return localObject;
    }
  }
  
  public final int getIndex(int paramInt)
  {
    AppMethodBeat.i(255648);
    Iterator localIterator = ((List)this.fragments).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((FinderHomeTabFragment)localIterator.next()).dLS == paramInt)
      {
        j = 1;
        label51:
        if (j == 0) {
          break label101;
        }
      }
    }
    for (;;)
    {
      if (i >= 0) {
        break label113;
      }
      Log.e("Finder.HomeUIC", "[getIndex] type=" + paramInt + " is invalid.");
      AppMethodBeat.o(255648);
      return 0;
      j = 0;
      break label51;
      label101:
      i += 1;
      break;
      i = -1;
    }
    label113:
    AppMethodBeat.o(255648);
    return i;
  }
  
  public final int getLayoutId()
  {
    return 2131494342;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(255650);
    if (this.wxc)
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
      localIntent.putExtra("preferred_tab", 2);
      com.tencent.mm.br.c.f((Context)getActivity(), ".ui.LauncherUI", localIntent);
      getActivity().overridePendingTransition(MMFragmentActivity.a.ogo, MMFragmentActivity.a.ogp);
      AppMethodBeat.o(255650);
      return true;
    }
    AppMethodBeat.o(255650);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    boolean bool3 = false;
    AppMethodBeat.i(255637);
    d.i((kotlin.g.a.a)e.wxo);
    paramBundle = com.tencent.mm.plugin.finder.cgi.report.a.tya;
    com.tencent.mm.plugin.finder.cgi.report.a.init();
    paramBundle = com.tencent.mm.plugin.finder.storage.c.vCb;
    com.tencent.mm.plugin.finder.storage.c.dsk();
    final int i;
    boolean bool1;
    if (getActivity().getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false))
    {
      i = 3;
      this.tOh.alive();
      paramBundle = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131309856);
      Object localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dsw().value()).intValue() != 1) {
        break label516;
      }
      localObject = y.vXH;
      if (!y.isAllHomeTabEnableFullScreenEnjoy()) {
        break label516;
      }
      bool1 = true;
      label109:
      paramBundle.setEnableViewPagerScroll(bool1);
      p.g(paramBundle, "this");
      localObject = getActivity().getSupportFragmentManager();
      p.g(localObject, "activity.supportFragmentManager");
      paramBundle.setAdapter((android.support.v4.view.q)new com.tencent.mm.plugin.finder.view.adapter.c((android.support.v4.app.g)localObject, (List)this.fragments));
      paramBundle.addOnPageChangeListener((ViewPager.OnPageChangeListener)this.wxk);
      paramBundle.setOffscreenPageLimit(4);
      paramBundle.post((Runnable)new d(this, i));
      localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      int j = ((Number)com.tencent.mm.plugin.finder.storage.c.dtL().value()).intValue();
      if (j > 0)
      {
        localObject = an.waE;
        an.a(paramBundle.getContext(), (FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131309856), j);
      }
      paramBundle = as.uOL;
      as.startTimer();
      this.dbG = true;
      paramBundle = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dvQ().value()).intValue() != 1) {
        break label522;
      }
      bool1 = true;
      label280:
      Log.i("Finder.HomeUIC", "[onCreate] lastTabType=" + this.tlCache.dHR() + " index=" + getIndex(i) + " tabType=" + i + " FIX_REINIT_SELECTOR_ENABLE_VALUE=" + bool1);
      boolean bool2 = bool3;
      if (getIntent().getLongExtra("key_finder_post_local_id", -1L) != -1L)
      {
        bool2 = bool3;
        if (getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false)) {
          bool2 = true;
        }
      }
      this.wxc = bool2;
      if (!bool1) {
        break label528;
      }
      ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().fX(48125, 7);
    }
    for (;;)
    {
      paramBundle = new Bundle();
      paramBundle.putInt("Source", 1);
      p(i, paramBundle);
      ((aj)com.tencent.mm.kernel.g.ah(aj.class)).checkLastLiveObject();
      AppMethodBeat.o(255637);
      return;
      if (getActivity().getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB", false))
      {
        i = 1;
        break;
      }
      if (getActivity().getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", false))
      {
        i = 4;
        break;
      }
      i = this.tlCache.dHR();
      break;
      label516:
      bool1 = false;
      break label109;
      label522:
      bool1 = false;
      break label280;
      label528:
      ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().fX(47613, 7);
    }
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(255638);
    super.onCreateAfter(paramBundle);
    if ((getIntent().getBooleanExtra("KEY_POST_DIRECTLY_FROM_SNS", false)) || (getIntent().getBooleanExtra("KEY_FROM_SHARE_REL", false)))
    {
      Object localObject = getIntent().getStringExtra("key_context_id");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      localObject = i.tLi;
      i.a.dw(paramBundle, 1);
    }
    int i = getIntent().getIntExtra("FROM_SCENE_KEY", 2);
    paramBundle = com.tencent.mm.kernel.g.ah(PluginFinder.class);
    p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramBundle).getRedDotManager().Iw(i);
    AppMethodBeat.o(255638);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(255642);
    super.onDestroy();
    switch (this.tlCache.wtW)
    {
    }
    for (;;)
    {
      this.tlCache.a(getActiveFragment().dLS, FinderHomeTabStateVM.c.wuj);
      this.tlCache.Mp(getActiveFragment().dLS);
      this.tOh.dead();
      Object localObject = as.uOL;
      as.stopTimer();
      localObject = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)localObject).getRedDotManager().daC();
      AppMethodBeat.o(255642);
      return;
      localObject = k.vkd;
      k.b(null, s.p.voz, s.j.vnN.scene, com.tencent.mm.plugin.finder.report.live.c.vjl);
      continue;
      localObject = k.vkd;
      k.b(null, s.p.voz, s.j.vnU.scene, com.tencent.mm.plugin.finder.report.live.c.vjl);
    }
  }
  
  public final void onPause()
  {
    Object localObject2 = null;
    WeakReference localWeakReference = null;
    Object localObject1 = null;
    AppMethodBeat.i(255640);
    super.onPause();
    switch (this.tlCache.wtW)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(255640);
      return;
      localObject2 = k.vkd;
      localObject2 = k.vkd;
      localObject2 = k.dpl().vmq;
      if (localObject2 != null) {
        localObject1 = (RecyclerView)((WeakReference)localObject2).get();
      }
      k.b((RecyclerView)localObject1, s.p.voz, s.j.vnN.scene, com.tencent.mm.plugin.finder.report.live.c.vjg);
      AppMethodBeat.o(255640);
      return;
      localObject1 = k.vkd;
      localObject1 = k.vkd;
      localWeakReference = k.dpl().vmq;
      localObject1 = localObject2;
      if (localWeakReference != null) {
        localObject1 = (RecyclerView)localWeakReference.get();
      }
      k.b((RecyclerView)localObject1, s.p.voz, s.j.vnU.scene, com.tencent.mm.plugin.finder.report.live.c.vjg);
      AppMethodBeat.o(255640);
      return;
      localObject1 = k.vkd;
      localObject1 = k.vkd;
      localObject2 = k.dpl().vmq;
      localObject1 = localWeakReference;
      if (localObject2 != null) {
        localObject1 = (RecyclerView)((WeakReference)localObject2).get();
      }
      k.b((RecyclerView)localObject1, s.p.voB, "20", com.tencent.mm.plugin.finder.report.live.c.vjg);
    }
  }
  
  public final void onResume()
  {
    Object localObject2 = null;
    WeakReference localWeakReference = null;
    Object localObject1 = null;
    AppMethodBeat.i(255639);
    super.onResume();
    switch (this.tlCache.wtW)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(255639);
      return;
      localObject2 = k.vkd;
      localObject2 = k.vkd;
      localObject2 = k.dpl().vmq;
      if (localObject2 != null) {
        localObject1 = (RecyclerView)((WeakReference)localObject2).get();
      }
      k.b((RecyclerView)localObject1, s.p.voz, s.j.vnN.scene, com.tencent.mm.plugin.finder.report.live.c.vjf);
      AppMethodBeat.o(255639);
      return;
      localObject1 = k.vkd;
      localObject1 = k.vkd;
      localWeakReference = k.dpl().vmq;
      localObject1 = localObject2;
      if (localWeakReference != null) {
        localObject1 = (RecyclerView)localWeakReference.get();
      }
      k.b((RecyclerView)localObject1, s.p.voz, s.j.vnU.scene, com.tencent.mm.plugin.finder.report.live.c.vjf);
      AppMethodBeat.o(255639);
      return;
      localObject1 = k.vkd;
      localObject1 = k.vkd;
      localObject2 = k.dpl().vmq;
      localObject1 = localWeakReference;
      if (localObject2 != null) {
        localObject1 = (RecyclerView)((WeakReference)localObject2).get();
      }
      k.b((RecyclerView)localObject1, s.p.voB, "20", com.tencent.mm.plugin.finder.report.live.c.vjf);
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(255641);
    super.onStop();
    if (getActivity().isFinishing())
    {
      com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(locala, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)locala).getRedDotManager().daB();
    }
    AppMethodBeat.o(255641);
  }
  
  public final void p(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(255643);
    int i = getIndex(paramInt);
    int j = this.fragments.size();
    if (i < 0)
    {
      AppMethodBeat.o(255643);
      return;
    }
    if (j > i)
    {
      if (paramBundle != null) {
        ((FinderHomeTabFragment)this.fragments.get(i)).Ew = paramBundle;
      }
      this.tlCache.wtW = paramInt;
      paramBundle = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131309856);
      p.g(paramBundle, "activity.viewPager");
      paramBundle.setCurrentItem(i);
    }
    AppMethodBeat.o(255643);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$eventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends IListener<if>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onPageScrollStateChanged", "state", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "plugin-finder_release"})
  public static final class c
    extends FinderFragmentChangeObserver
  {
    c(AppCompatActivity paramAppCompatActivity, MMActivity paramMMActivity, List paramList)
    {
      super(localList);
    }
    
    public final void D(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(255632);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt2);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt3);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt4);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onFragmentChange", "(IIII)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      FinderHomeUIC.b(this.wxm).wtW = paramInt4;
      FinderHomeUIC.a(this.wxm, paramInt2);
      localObject = com.tencent.mm.ui.component.a.PRN;
      localObject = com.tencent.mm.ui.component.a.b(paramAppCompatActivity).get(FinderHomeActionBarUIC.class);
      p.g(localObject, "UICProvider.of(activity)…ActionBarUIC::class.java)");
      ((FinderHomeActionBarUIC)localObject).Jx(paramInt2);
      localObject = ((Iterable)this.wxm.wxj).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((h)((Iterator)localObject).next()).D(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onFragmentChange", "(IIII)V");
      AppMethodBeat.o(255632);
    }
    
    public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
    {
      AppMethodBeat.i(255631);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).en(paramBoolean);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramFinderHomeTabFragment);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramFinderHomeTabFragment, "fragment");
      if (paramBoolean)
      {
        localObject = paramFinderHomeTabFragment.getClass().getName();
        p.g(localObject, "fragment.javaClass.name");
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEs = (String)localObject;
      }
      localObject = ((Iterable)this.wxm.wxj).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((h)((Iterator)localObject).next()).a(paramBoolean, paramInt, paramFinderHomeTabFragment);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V");
      AppMethodBeat.o(255631);
    }
    
    public final void onPageScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(255633);
      Iterator localIterator = ((Iterable)this.wxm.wxj).iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).onPageScrollStateChanged(paramInt);
      }
      AppMethodBeat.o(255633);
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(255630);
      super.onPageScrolled(paramInt1, paramFloat, paramInt2);
      Iterator localIterator = ((Iterable)this.wxm.wxj).iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
      AppMethodBeat.o(255630);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$onCreate$2$1"})
  static final class d
    implements Runnable
  {
    d(FinderHomeUIC paramFinderHomeUIC, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(255634);
      Object localObject = com.tencent.mm.ui.component.a.PRN;
      localObject = com.tencent.mm.ui.component.a.b(this.wxm.getActivity()).get(FinderHomeActionBarUIC.class);
      p.g(localObject, "UICProvider.of(activity)…ActionBarUIC::class.java)");
      ((FinderHomeActionBarUIC)localObject).Jx(this.wxm.getIndex(i));
      FinderHomeUIC.a(this.wxm).onPageSelected(this.wxm.getIndex(i));
      AppMethodBeat.o(255634);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final e wxo;
    
    static
    {
      AppMethodBeat.i(255636);
      wxo = new e();
      AppMethodBeat.o(255636);
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