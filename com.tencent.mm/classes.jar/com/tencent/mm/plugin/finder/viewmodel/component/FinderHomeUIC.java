package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.iu;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.extension.reddot.i.a;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s;
import com.tencent.mm.plugin.finder.live.report.s.l;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.au;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.ay;
import com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.viewmodel.b.d;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "fragmentChangeListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "getFragmentChangeListeners", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "fragmentChangeObserver", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1;", "fragments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "getFragments", "()Ljava/util/ArrayList;", "isCreated", "", "isFromSns", "lastIndex", "", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "getActiveFragment", "getActiveView", "Landroid/view/View;", "getCurrentTabType", "getForceJumpTabType", "getFragmentByTabType", "tabType", "getIndex", "type", "getLayoutId", "isForceJump", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onPause", "onResume", "onStop", "setCurrentTabType", "args", "withAnim", "Companion", "plugin-finder_release"})
public final class FinderHomeUIC
  extends UIComponent
{
  public static final a Blu;
  private boolean Blr;
  final CopyOnWriteArraySet<com.tencent.mm.plugin.finder.view.i> Bls;
  private final c Blt;
  private boolean dfI;
  public final ArrayList<FinderHomeTabFragment> fragments;
  private int lastIndex;
  private final com.tencent.mm.plugin.finder.viewmodel.b tlCache;
  private final IListener<iu> xyI;
  
  static
  {
    AppMethodBeat.i(269967);
    Blu = new a((byte)0);
    AppMethodBeat.o(269967);
  }
  
  public FinderHomeUIC(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(269965);
    Object localObject = com.tencent.mm.kernel.h.ae(ae.class);
    p.j(localObject, "MMKernel.service(IFinder…enModeConfig::class.java)");
    boolean bool = ((ae)localObject).dYT();
    if (bool == true) {}
    for (localObject = j.ag(new FinderHomeTabFragment[] { (FinderHomeTabFragment)new FinderFollowTabFragment() });; localObject = j.ag(new FinderHomeTabFragment[] { (FinderHomeTabFragment)new FinderFollowTabFragment(), (FinderHomeTabFragment)new FinderFriendTabFragment(), (FinderHomeTabFragment)new FinderMachineTabFragment() }))
    {
      this.fragments = ((ArrayList)localObject);
      localObject = com.tencent.mm.ui.component.g.Xox;
      localObject = com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class);
      p.j(localObject, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
      this.tlCache = ((com.tencent.mm.plugin.finder.viewmodel.b)localObject);
      this.Bls = new CopyOnWriteArraySet();
      this.lastIndex = -1;
      this.Blt = new c(this, paramAppCompatActivity, (MMActivity)paramAppCompatActivity, (List)this.fragments);
      this.xyI = ((IListener)new b(this));
      AppMethodBeat.o(269965);
      return;
      if (bool) {
        break;
      }
    }
    paramAppCompatActivity = new kotlin.m();
    AppMethodBeat.o(269965);
    throw paramAppCompatActivity;
  }
  
  private final int ekM()
  {
    AppMethodBeat.i(269959);
    boolean bool1 = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);
    boolean bool2 = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB", false);
    boolean bool3 = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", false);
    if (bool1)
    {
      AppMethodBeat.o(269959);
      return 3;
    }
    if (bool2)
    {
      AppMethodBeat.o(269959);
      return 1;
    }
    if (bool3)
    {
      AppMethodBeat.o(269959);
      return 4;
    }
    AppMethodBeat.o(269959);
    return -1;
  }
  
  private final boolean ekN()
  {
    AppMethodBeat.i(269960);
    boolean bool1 = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);
    boolean bool2 = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB", false);
    boolean bool3 = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", false);
    if ((bool1) || (bool2) || (bool3))
    {
      AppMethodBeat.o(269960);
      return true;
    }
    AppMethodBeat.o(269960);
    return false;
  }
  
  public final int Me(int paramInt)
  {
    AppMethodBeat.i(269961);
    Iterator localIterator = ((List)this.fragments).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((FinderHomeTabFragment)localIterator.next()).fEH == paramInt)
      {
        j = 1;
        label50:
        if (j == 0) {
          break label98;
        }
      }
    }
    for (;;)
    {
      if (i >= 0) {
        break label110;
      }
      Log.e("Finder.HomeUIC", "[getIndex] type=" + paramInt + " is invalid.");
      AppMethodBeat.o(269961);
      return 0;
      j = 0;
      break label50;
      label98:
      i += 1;
      break;
      i = -1;
    }
    label110:
    AppMethodBeat.o(269961);
    return i;
  }
  
  public final FinderHomeTabFragment RR(int paramInt)
  {
    AppMethodBeat.i(269963);
    Object localObject = ((List)this.fragments).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject).hasNext()) {
      if (((FinderHomeTabFragment)((Iterator)localObject).next()).fEH == paramInt)
      {
        j = 1;
        label51:
        if (j == 0) {
          break label100;
        }
      }
    }
    for (;;)
    {
      if (i >= 0) {
        break label112;
      }
      Log.e("Finder.HomeUIC", "[getFragmentByTabType] type=" + paramInt + " is invalid.");
      AppMethodBeat.o(269963);
      return null;
      j = 0;
      break label51;
      label100:
      i += 1;
      break;
      i = -1;
    }
    label112:
    localObject = (FinderHomeTabFragment)this.fragments.get(i);
    AppMethodBeat.o(269963);
    return localObject;
  }
  
  public final void a(boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(269957);
    int i = Me(4);
    int j = this.fragments.size();
    if (i < 0)
    {
      AppMethodBeat.o(269957);
      return;
    }
    if (j > i)
    {
      ((FinderHomeTabFragment)this.fragments.get(i)).zDr = paramBundle;
      this.tlCache.Bgp = 4;
      this.tlCache.Bgq = 4;
      ((FinderViewPager)((FragmentActivity)getActivity()).findViewById(b.f.viewPager)).setCurrentItem(i, paramBoolean);
    }
    AppMethodBeat.o(269957);
  }
  
  public final int ekL()
  {
    AppMethodBeat.i(269958);
    if (this.dfI)
    {
      i = getActiveFragment().fEH;
      AppMethodBeat.o(269958);
      return i;
    }
    if (ekN())
    {
      i = ekM();
      AppMethodBeat.o(269958);
      return i;
    }
    com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
    int i = ((com.tencent.mm.plugin.finder.viewmodel.b)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class)).ekb();
    AppMethodBeat.o(269958);
    return i;
  }
  
  public final FinderHomeTabFragment getActiveFragment()
  {
    AppMethodBeat.i(269962);
    Object localObject = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(b.f.viewPager);
    if (localObject == null) {
      Log.e("Finder.HomeUIC", "[getActiveFragment] viewPager==null lastIndex=" + this.lastIndex);
    }
    if (localObject != null) {}
    for (int i = ((FinderViewPager)localObject).getCurrentItem();; i = this.lastIndex)
    {
      localObject = this.fragments.get(i);
      p.j(localObject, "fragments[index]");
      localObject = (FinderHomeTabFragment)localObject;
      AppMethodBeat.o(269962);
      return localObject;
    }
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_home_ui;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(269964);
    if (this.Blr)
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
      localIntent.putExtra("preferred_tab", 2);
      com.tencent.mm.by.c.f((Context)getActivity(), ".ui.LauncherUI", localIntent);
      getActivity().overridePendingTransition(MMFragmentActivity.a.ria, MMFragmentActivity.a.rib);
      AppMethodBeat.o(269964);
      return true;
    }
    AppMethodBeat.o(269964);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    boolean bool3 = false;
    AppMethodBeat.i(269950);
    com.tencent.mm.ae.d.h((kotlin.g.a.a)e.Blx);
    paramBundle = com.tencent.mm.plugin.findersdk.b.a.a.BvR;
    com.tencent.mm.plugin.findersdk.b.a.a.init();
    paramBundle = com.tencent.mm.plugin.finder.storage.d.AjH;
    com.tencent.mm.plugin.finder.storage.d.dTz();
    final int i;
    boolean bool1;
    if (getActivity().getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false))
    {
      i = 3;
      this.xyI.alive();
      paramBundle = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(b.f.viewPager);
      Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dTP().aSr()).intValue() != 1) {
        break label524;
      }
      localObject = aj.AGc;
      if (!aj.isAllHomeTabEnableFullScreenEnjoy()) {
        break label524;
      }
      bool1 = true;
      label110:
      paramBundle.setEnableViewPagerScroll(bool1);
      p.j(paramBundle, "this");
      localObject = getActivity().getSupportFragmentManager();
      p.j(localObject, "activity.supportFragmentManager");
      paramBundle.setAdapter((androidx.viewpager.widget.a)new com.tencent.mm.plugin.finder.view.adapter.c((androidx.fragment.app.e)localObject, (List)this.fragments));
      paramBundle.addOnPageChangeListener((ViewPager.OnPageChangeListener)this.Blt);
      paramBundle.setOffscreenPageLimit(4);
      paramBundle.post((Runnable)new d(this, i));
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      int j = ((Number)com.tencent.mm.plugin.finder.storage.d.dUU().aSr()).intValue();
      if (j > 0)
      {
        localObject = ay.AJC;
        ay.a(paramBundle.getContext(), (FinderViewPager)((FragmentActivity)getActivity()).findViewById(b.f.viewPager), j);
      }
      paramBundle = au.zBf;
      au.startTimer();
      this.dfI = true;
      paramBundle = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dWt().aSr()).intValue() != 1) {
        break label530;
      }
      bool1 = true;
      label282:
      Log.i("Finder.HomeUIC", "[onCreate] index=" + Me(i) + " tabType=" + i + " FIX_REINIT_SELECTOR_ENABLE_VALUE=" + bool1);
      boolean bool2 = bool3;
      if (getIntent().getLongExtra("key_finder_post_local_id", -1L) != -1L)
      {
        bool2 = bool3;
        if (getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false)) {
          bool2 = true;
        }
      }
      this.Blr = bool2;
      if (!bool1) {
        break label536;
      }
      ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderSyncExtension().gu(113661, 7);
    }
    for (;;)
    {
      paramBundle = new Bundle();
      paramBundle.putInt("Source", 1);
      r(i, paramBundle);
      ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).checkLastLiveObject((Context)getActivity(), null);
      com.tencent.e.h.ZvG.bg((Runnable)f.Bly);
      AppMethodBeat.o(269950);
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
      i = this.tlCache.ekb();
      break;
      label524:
      bool1 = false;
      break label110;
      label530:
      bool1 = false;
      break label282;
      label536:
      ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderSyncExtension().gu(113149, 7);
    }
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(269951);
    super.onCreateAfter(paramBundle);
    if ((getIntent().getBooleanExtra("KEY_POST_DIRECTLY_FROM_SNS", false)) || (getIntent().getBooleanExtra("KEY_FROM_SHARE_REL", false)))
    {
      Object localObject = getIntent().getStringExtra("key_context_id");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      localObject = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
      i.a.dQ(paramBundle, 1);
    }
    int i = getIntent().getIntExtra("FROM_SCENE_KEY", 2);
    paramBundle = com.tencent.mm.kernel.h.ag(PluginFinder.class);
    p.j(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramBundle).getRedDotManager().Mn(i);
    AppMethodBeat.o(269951);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(269955);
    super.onDestroy();
    Object localObject;
    long l;
    switch (this.tlCache.Bgp)
    {
    case 2: 
    default: 
      this.tlCache.a(getActiveFragment().fEH, b.d.BgH);
      this.tlCache.RH(getActiveFragment().fEH);
      this.xyI.dead();
      localObject = au.zBf;
      au.stopTimer();
      localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)localObject).getRedDotManager();
      ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject).xsS = (cm.bfE() - ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject).enterTime);
      if ((((com.tencent.mm.plugin.finder.extension.reddot.f)localObject).xsU) && (((com.tencent.mm.plugin.finder.extension.reddot.f)localObject).xsT == 2))
      {
        l = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject).xsS;
        com.tencent.mm.plugin.finder.extension.reddot.m localm = com.tencent.mm.plugin.finder.extension.reddot.m.xuU;
        if (l <= com.tencent.mm.plugin.finder.extension.reddot.m.drT())
        {
          localObject = com.tencent.mm.plugin.finder.extension.reddot.m.xuU;
          int i = kotlin.k.i.ow(com.tencent.mm.plugin.finder.extension.reddot.m.drX() + 1, 3);
          Log.w("Finder.RedDotManager", "[exitFinder] current fastLevel=".concat(String.valueOf(i)));
          localObject = com.tencent.mm.plugin.finder.extension.reddot.m.xuU;
          com.tencent.mm.plugin.finder.extension.reddot.m.Mu(i);
        }
      }
      break;
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.extension.reddot.m.xuU;
      com.tencent.mm.plugin.finder.extension.reddot.m.dsc();
      AppMethodBeat.o(269955);
      return;
      localObject = k.yBj;
      k.b(null, s.t.yGM, s.l.yFP.scene, com.tencent.mm.plugin.finder.live.report.c.yAo);
      break;
      localObject = k.yBj;
      k.b(null, s.t.yGM, s.l.yFW.scene, com.tencent.mm.plugin.finder.live.report.c.yAo);
      break;
      l = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject).xsS;
      localObject = com.tencent.mm.plugin.finder.extension.reddot.m.xuU;
      if (l > com.tencent.mm.plugin.finder.extension.reddot.m.drT())
      {
        Log.w("Finder.RedDotManager", "[exitFinder] revert fastLevel=0");
        localObject = com.tencent.mm.plugin.finder.extension.reddot.m.xuU;
        com.tencent.mm.plugin.finder.extension.reddot.m.Mu(0);
      }
    }
  }
  
  public final void onPause()
  {
    Object localObject2 = null;
    WeakReference localWeakReference = null;
    Object localObject1 = null;
    AppMethodBeat.i(269953);
    super.onPause();
    switch (this.tlCache.Bgp)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(269953);
      return;
      localObject2 = k.yBj;
      localObject2 = k.yBj;
      localObject2 = k.dDm().yDD;
      if (localObject2 != null) {
        localObject1 = (RecyclerView)((WeakReference)localObject2).get();
      }
      k.b((RecyclerView)localObject1, s.t.yGM, s.l.yFP.scene, com.tencent.mm.plugin.finder.live.report.c.yAj);
      AppMethodBeat.o(269953);
      return;
      localObject1 = k.yBj;
      localObject1 = k.yBj;
      localWeakReference = k.dDm().yDD;
      localObject1 = localObject2;
      if (localWeakReference != null) {
        localObject1 = (RecyclerView)localWeakReference.get();
      }
      k.b((RecyclerView)localObject1, s.t.yGM, s.l.yFW.scene, com.tencent.mm.plugin.finder.live.report.c.yAj);
      AppMethodBeat.o(269953);
      return;
      localObject1 = k.yBj;
      localObject1 = k.yBj;
      localObject2 = k.dDm().yDD;
      localObject1 = localWeakReference;
      if (localObject2 != null) {
        localObject1 = (RecyclerView)((WeakReference)localObject2).get();
      }
      k.b((RecyclerView)localObject1, s.t.yGO, "20", com.tencent.mm.plugin.finder.live.report.c.yAj);
    }
  }
  
  public final void onResume()
  {
    Object localObject2 = null;
    WeakReference localWeakReference = null;
    Object localObject1 = null;
    AppMethodBeat.i(269952);
    super.onResume();
    switch (this.tlCache.Bgp)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(269952);
      return;
      localObject2 = k.yBj;
      localObject2 = k.yBj;
      localObject2 = k.dDm().yDD;
      if (localObject2 != null) {
        localObject1 = (RecyclerView)((WeakReference)localObject2).get();
      }
      k.b((RecyclerView)localObject1, s.t.yGM, s.l.yFP.scene, com.tencent.mm.plugin.finder.live.report.c.yAi);
      AppMethodBeat.o(269952);
      return;
      localObject1 = k.yBj;
      localObject1 = k.yBj;
      localWeakReference = k.dDm().yDD;
      localObject1 = localObject2;
      if (localWeakReference != null) {
        localObject1 = (RecyclerView)localWeakReference.get();
      }
      k.b((RecyclerView)localObject1, s.t.yGM, s.l.yFW.scene, com.tencent.mm.plugin.finder.live.report.c.yAi);
      AppMethodBeat.o(269952);
      return;
      localObject1 = k.yBj;
      localObject1 = k.yBj;
      localObject2 = k.dDm().yDD;
      localObject1 = localWeakReference;
      if (localObject2 != null) {
        localObject1 = (RecyclerView)((WeakReference)localObject2).get();
      }
      k.b((RecyclerView)localObject1, s.t.yGO, "20", com.tencent.mm.plugin.finder.live.report.c.yAi);
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(269954);
    super.onStop();
    if (getActivity().isFinishing())
    {
      Object localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)localObject).getRedDotManager();
      ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject).aBd("FinderEntrance");
      ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject).aBd("Discovery");
    }
    AppMethodBeat.o(269954);
  }
  
  public final void r(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(269956);
    int i = Me(paramInt);
    int j = this.fragments.size();
    if (i < 0)
    {
      AppMethodBeat.o(269956);
      return;
    }
    if (j > i)
    {
      if (paramBundle != null) {
        ((FinderHomeTabFragment)this.fragments.get(i)).zDr = paramBundle;
      }
      this.tlCache.Bgp = paramInt;
      this.tlCache.Bgq = paramInt;
      paramBundle = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(b.f.viewPager);
      p.j(paramBundle, "activity.viewPager");
      paramBundle.setCurrentItem(i);
    }
    AppMethodBeat.o(269956);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$eventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends IListener<iu>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onPageScrollStateChanged", "state", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "plugin-finder_release"})
  public static final class c
    extends FinderFragmentChangeObserver
  {
    c(AppCompatActivity paramAppCompatActivity, MMActivity paramMMActivity, List paramList)
    {
      super(localList);
    }
    
    public final void H(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(267211);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt2);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt3);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt4);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onFragmentChange", "(IIII)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      FinderHomeUIC.b(this.Blv).Bgp = paramInt4;
      FinderHomeUIC.b(this.Blv).Bgq = paramInt4;
      FinderHomeUIC.a(this.Blv, paramInt2);
      localObject = com.tencent.mm.ui.component.g.Xox;
      localObject = com.tencent.mm.ui.component.g.b(paramAppCompatActivity).i(aa.class);
      p.j(localObject, "UICProvider.of(activity)…ActionBarUIC::class.java)");
      ((aa)localObject).Ok(paramInt2);
      localObject = ((Iterable)this.Blv.Bls).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.finder.view.i)((Iterator)localObject).next()).H(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      if (paramInt1 != -1)
      {
        localObject = com.tencent.mm.ui.component.g.Xox;
        ((an)com.tencent.mm.ui.component.g.b(paramAppCompatActivity).i(an.class)).elx();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onFragmentChange", "(IIII)V");
      AppMethodBeat.o(267211);
    }
    
    public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
    {
      AppMethodBeat.i(267209);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).eL(paramBoolean);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramFinderHomeTabFragment);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramFinderHomeTabFragment, "fragment");
      if (paramBoolean)
      {
        localObject = paramFinderHomeTabFragment.getClass().getName();
        p.j(localObject, "fragment.javaClass.name");
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkn = (String)localObject;
      }
      localObject = ((Iterable)this.Blv.Bls).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.finder.view.i)((Iterator)localObject).next()).a(paramBoolean, paramInt, paramFinderHomeTabFragment);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V");
      AppMethodBeat.o(267209);
    }
    
    public final void onPageScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(267213);
      Iterator localIterator = ((Iterable)this.Blv.Bls).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.finder.view.i)localIterator.next()).onPageScrollStateChanged(paramInt);
      }
      AppMethodBeat.o(267213);
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(267208);
      super.onPageScrolled(paramInt1, paramFloat, paramInt2);
      Iterator localIterator = ((Iterable)this.Blv.Bls).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.finder.view.i)localIterator.next()).onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
      AppMethodBeat.o(267208);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$onCreate$2$1"})
  static final class d
    implements Runnable
  {
    d(FinderHomeUIC paramFinderHomeUIC, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(285642);
      Object localObject = com.tencent.mm.ui.component.g.Xox;
      localObject = com.tencent.mm.ui.component.g.b(this.Blv.getActivity()).i(aa.class);
      p.j(localObject, "UICProvider.of(activity)…ActionBarUIC::class.java)");
      ((aa)localObject).Ok(this.Blv.Me(i));
      FinderHomeUIC.a(this.Blv).onPageSelected(this.Blv.Me(i));
      AppMethodBeat.o(285642);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final e Blx;
    
    static
    {
      AppMethodBeat.i(271089);
      Blx = new e();
      AppMethodBeat.o(271089);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    public static final f Bly;
    
    static
    {
      AppMethodBeat.i(276299);
      Bly = new f();
      AppMethodBeat.o(276299);
    }
    
    public final void run()
    {
      AppMethodBeat.i(276298);
      Object localObject = com.tencent.mm.kernel.h.aHG();
      p.j(localObject, "MMKernel.storage()");
      if (!((com.tencent.mm.kernel.f)localObject).aHp().getBoolean(ar.a.VCo, false))
      {
        localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.dXE().aSr()).intValue() == 1) {
          ((com.tencent.mm.plugin.wallet.wecoin.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).b((com.tencent.mm.plugin.wallet.wecoin.a.e)new com.tencent.mm.plugin.wallet.wecoin.a.e()
          {
            public final void p(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString) {}
          });
        }
      }
      AppMethodBeat.o(276298);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC
 * JD-Core Version:    0.7.0.1
 */