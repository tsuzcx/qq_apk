package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.jr;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.extension.reddot.m.a;
import com.tencent.mm.plugin.finder.feed.aw.b;
import com.tencent.mm.plugin.finder.feed.aw.b.a;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI5;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.report.o;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment;
import com.tencent.mm.plugin.finder.utils.bp;
import com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.viewmodel.d.a;
import com.tencent.mm.plugin.finder.viewmodel.d.c;
import com.tencent.mm.plugin.finder.viewmodel.d.d;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.by;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.e;
import com.tencent.mm.ui.component.k.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "currentIsMobileData", "", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "fragmentChangeListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "getFragmentChangeListeners", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "fragmentChangeObserver", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1;", "fragments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "getFragments", "()Ljava/util/ArrayList;", "isCreated", "isFromShareToTimeline", "isFromSns", "isRefreshOnTeenModeBack", "lastIndex", "", "networkReceiver", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$networkReceiver$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$networkReceiver$1;", "teenModeDataChangedListener", "Lcom/tencent/mm/plugin/teenmode/api/TeenModeDataChangedListener;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "checkShowNotWifiHint", "", "checkTimesLimit", "getActiveFragment", "getActiveView", "Landroid/view/View;", "getCurrentTabType", "getForceJumpTabType", "getFragmentByTabType", "tabType", "getIndex", "type", "getLayoutId", "isForceJump", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onPause", "onResume", "onStop", "reportShareFeedClick", "setCurrentTabType", "args", "withAnim", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderHomeUIC
  extends UIComponent
{
  public static final a GRy;
  private final com.tencent.mm.plugin.finder.viewmodel.d AZj;
  private boolean Btk;
  private boolean GRA;
  final CopyOnWriteArraySet<com.tencent.mm.plugin.finder.view.h> GRB;
  private final b GRC;
  private boolean GRD;
  private final networkReceiver.1 GRE;
  private boolean GRz;
  private boolean feX;
  public final ArrayList<FinderHomeTabFragment> fragments;
  private int lastIndex;
  private com.tencent.mm.plugin.teenmode.a.g qCv;
  private final IListener<jr> qmO;
  
  static
  {
    AppMethodBeat.i(338778);
    GRy = new a((byte)0);
    AppMethodBeat.o(338778);
  }
  
  public FinderHomeUIC(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338657);
    this.fragments = kotlin.a.p.al(new FinderHomeTabFragment[] { (FinderHomeTabFragment)new FinderFollowTabFragment(), (FinderHomeTabFragment)new FinderFriendTabFragment(), (FinderHomeTabFragment)new FinderMachineTabFragment() });
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class);
    s.s(localObject, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.AZj = ((com.tencent.mm.plugin.finder.viewmodel.d)localObject);
    this.GRB = new CopyOnWriteArraySet();
    this.lastIndex = -1;
    this.GRC = new b(this, paramAppCompatActivity, this.fragments);
    this.qmO = ((IListener)new IListener(com.tencent.mm.app.f.hfK) {});
    this.GRE = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(338684);
        boolean bool = NetStatusUtil.isMobile(MMApplicationContext.getContext());
        Log.i("Finder.HomeUIC", "on network change callback， oldIsMobileData = " + FinderHomeUIC.d(this.GRF) + ", nowIsMobileData = " + bool);
        if ((FinderHomeUIC.d(this.GRF) != bool) && (!FinderHomeUIC.d(this.GRF))) {
          this.GRF.vp(false);
        }
        FinderHomeUIC.a(this.GRF, bool);
        AppMethodBeat.o(338684);
      }
    };
    this.qCv = new FinderHomeUIC..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(338657);
  }
  
  private int Ni(int paramInt)
  {
    AppMethodBeat.i(338693);
    Iterator localIterator = ((List)this.fragments).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((FinderHomeTabFragment)localIterator.next()).hJx == paramInt)
      {
        j = 1;
        label50:
        if (j == 0) {
          break label99;
        }
      }
    }
    for (;;)
    {
      if (i >= 0) {
        break label111;
      }
      Log.e("Finder.HomeUIC", "[getIndex] type=" + paramInt + " is invalid.");
      AppMethodBeat.o(338693);
      return 0;
      j = 0;
      break label50;
      label99:
      i += 1;
      break;
      i = -1;
    }
    label111:
    AppMethodBeat.o(338693);
    return i;
  }
  
  private static final void a(FinderHomeUIC paramFinderHomeUIC, ah.d paramd)
  {
    AppMethodBeat.i(338705);
    s.u(paramFinderHomeUIC, "this$0");
    s.u(paramd, "$tabType");
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = com.tencent.mm.ui.component.k.d(paramFinderHomeUIC.getActivity()).q(af.class);
    s.s(localObject1, "UICProvider.of(activity)…ActionBarUIC::class.java)");
    ((af)localObject1).Qw(paramFinderHomeUIC.Ni(paramd.aixb));
    paramFinderHomeUIC.GRC.onPageSelected(paramFinderHomeUIC.Ni(paramd.aixb));
    localObject1 = ((Iterable)paramFinderHomeUIC.fragments).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (FinderHomeTabFragment)((Iterator)localObject1).next();
      if (((FinderHomeTabFragment)localObject3).hJx != paramd.aixb)
      {
        Object localObject2 = com.tencent.mm.ui.component.k.aeZF;
        localObject2 = (ay)com.tencent.mm.ui.component.k.d(paramFinderHomeUIC.getActivity()).q(ay.class);
        int i = ((FinderHomeTabFragment)localObject3).hJx;
        Log.i("FinderTabPreloadUIC", "startPreload: delayTimeSec = " + ((ay)localObject2).fpb() + ", tabType = " + i);
        if (((ay)localObject2).fpb() > 0L)
        {
          if (((com.tencent.mm.plugin.finder.viewmodel.d)((ay)localObject2).EVT.getValue()).Rp(i))
          {
            localObject3 = new ay.f((ay)localObject2, i);
            ((Map)((ay)localObject2).GVe).put(Integer.valueOf(i), localObject3);
            ((ay)localObject2).getHandler().postDelayed((Runnable)localObject3, ((ay)localObject2).fpb());
          }
          localObject3 = com.tencent.mm.ui.component.k.aeZF;
          localObject3 = ((FinderHomeUIC)com.tencent.mm.ui.component.k.d(((ay)localObject2).getActivity()).q(FinderHomeUIC.class)).GRB;
          if (!((CopyOnWriteArraySet)localObject3).contains(localObject2)) {
            ((CopyOnWriteArraySet)localObject3).add(localObject2);
          }
        }
      }
    }
    paramFinderHomeUIC.vp(true);
    AppMethodBeat.o(338705);
  }
  
  private static final void b(FinderHomeUIC paramFinderHomeUIC)
  {
    AppMethodBeat.i(338733);
    s.u(paramFinderHomeUIC, "this$0");
    if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()) {
      paramFinderHomeUIC.GRA = true;
    }
    AppMethodBeat.o(338733);
  }
  
  private final int fnY()
  {
    AppMethodBeat.i(338668);
    boolean bool1 = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);
    boolean bool2 = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB", false);
    boolean bool3 = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", false);
    if (bool1)
    {
      AppMethodBeat.o(338668);
      return 3;
    }
    if (bool2)
    {
      AppMethodBeat.o(338668);
      return 1;
    }
    if (bool3)
    {
      AppMethodBeat.o(338668);
      return 4;
    }
    AppMethodBeat.o(338668);
    return -1;
  }
  
  private final boolean fnZ()
  {
    AppMethodBeat.i(338678);
    boolean bool1 = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);
    boolean bool2 = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB", false);
    boolean bool3 = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", false);
    if ((bool1) || (bool2) || (bool3))
    {
      AppMethodBeat.o(338678);
      return true;
    }
    AppMethodBeat.o(338678);
    return false;
  }
  
  private static final void foa()
  {
    AppMethodBeat.i(338720);
    if (!com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adfd, false))
    {
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eWw().bmg()).intValue() == 1) {
        ((com.tencent.mm.plugin.wallet.wecoin.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wallet.wecoin.a.d.class)).b((com.tencent.mm.plugin.wallet.wecoin.a.i)new d());
      }
    }
    AppMethodBeat.o(338720);
  }
  
  public final FinderHomeTabFragment Vi(int paramInt)
  {
    AppMethodBeat.i(339013);
    Object localObject = ((List)this.fragments).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject).hasNext()) {
      if (((FinderHomeTabFragment)((Iterator)localObject).next()).hJx == paramInt)
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
      Log.e("Finder.HomeUIC", "[getFragmentByTabType] type=" + paramInt + " is invalid.");
      AppMethodBeat.o(339013);
      return null;
      j = 0;
      break label51;
      label101:
      i += 1;
      break;
      i = -1;
    }
    label113:
    localObject = (FinderHomeTabFragment)this.fragments.get(i);
    AppMethodBeat.o(339013);
    return localObject;
  }
  
  public final void a(boolean paramBoolean, Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(338985);
    int k = Ni(4);
    int i = j;
    if (k >= 0)
    {
      i = j;
      if (k < this.fragments.size()) {
        i = 1;
      }
    }
    if (i != 0)
    {
      ((FinderHomeTabFragment)this.fragments.get(k)).EHy = paramBundle;
      this.AZj.GKp = 4;
      this.AZj.GKq = 4;
      ((FinderViewPager)getActivity().findViewById(e.e.viewPager)).setCurrentItem(k, paramBoolean);
    }
    AppMethodBeat.o(338985);
  }
  
  public final int fnX()
  {
    AppMethodBeat.i(338999);
    if ((getActivity() instanceof OccupyFinderUI5))
    {
      AppMethodBeat.o(338999);
      return 1;
    }
    if (this.feX)
    {
      i = getActiveFragment().hJx;
      AppMethodBeat.o(338999);
      return i;
    }
    if (fnZ())
    {
      i = fnY();
      AppMethodBeat.o(338999);
      return i;
    }
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    int i = ((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).fmM();
    AppMethodBeat.o(338999);
    return i;
  }
  
  public final FinderHomeTabFragment getActiveFragment()
  {
    AppMethodBeat.i(339006);
    Object localObject = (FinderViewPager)getActivity().findViewById(e.e.viewPager);
    if (localObject == null) {
      Log.e("Finder.HomeUIC", s.X("[getActiveFragment] viewPager==null lastIndex=", Integer.valueOf(this.lastIndex)));
    }
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label98;
      }
    }
    label98:
    for (int i = this.lastIndex;; i = ((Integer)localObject).intValue())
    {
      localObject = this.fragments.get(i);
      s.s(localObject, "fragments[index]");
      localObject = (FinderHomeTabFragment)localObject;
      AppMethodBeat.o(339006);
      return localObject;
      localObject = Integer.valueOf(((FinderViewPager)localObject).getCurrentItem());
      break;
    }
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_home_ui;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(339021);
    if (this.GRz)
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
      localIntent.putExtra("preferred_tab", 2);
      com.tencent.mm.br.c.g((Context)getActivity(), ".ui.LauncherUI", localIntent);
      getActivity().overridePendingTransition(MMFragmentActivity.a.upW, MMFragmentActivity.a.upX);
      AppMethodBeat.o(339021);
      return true;
    }
    AppMethodBeat.o(339021);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(338867);
    com.tencent.mm.ae.d.B((kotlin.g.a.a)c.GRG);
    paramBundle = com.tencent.mm.plugin.findersdk.b.a.a.HcR;
    com.tencent.mm.plugin.findersdk.b.a.a.init();
    paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
    com.tencent.mm.plugin.finder.storage.d.eRO();
    Object localObject1 = new ah.d();
    int i;
    Object localObject2;
    boolean bool1;
    label158:
    label321:
    boolean bool2;
    label414:
    label439:
    label484:
    int j;
    long l;
    if (getActivity().getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false))
    {
      i = 3;
      ((ah.d)localObject1).aixb = i;
      this.qmO.alive();
      if (this.AZj.Rp(((ah.d)localObject1).aixb))
      {
        paramBundle = com.tencent.mm.ui.component.k.aeZF;
        paramBundle = (com.tencent.mm.plugin.finder.viewmodel.l)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.l.class);
        Log.i("Finder.VideoStateCacheVM", "[clearProgress]");
        paramBundle.GLA.clear();
      }
      paramBundle = (FinderViewPager)getActivity().findViewById(e.e.viewPager);
      localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eSh().bmg()).intValue() != 1) {
        break label772;
      }
      bool1 = true;
      paramBundle.setEnableViewPagerScroll(bool1);
      localObject2 = getActivity().getSupportFragmentManager();
      s.s(localObject2, "activity.supportFragmentManager");
      paramBundle.setAdapter((androidx.viewpager.widget.a)new com.tencent.mm.plugin.finder.view.adapter.c((FragmentManager)localObject2, (List)this.fragments));
      paramBundle.addOnPageChangeListener((ViewPager.OnPageChangeListener)this.GRC);
      paramBundle.setOffscreenPageLimit(4);
      paramBundle.post(new FinderHomeUIC..ExternalSyntheticLambda1(this, (ah.d)localObject1));
      localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
      i = ((Number)com.tencent.mm.plugin.finder.storage.d.eTt().bmg()).intValue();
      if (i > 0)
      {
        localObject2 = bp.Gmq;
        bp.a(paramBundle.getContext(), (ViewPager)getActivity().findViewById(e.e.viewPager), i);
      }
      paramBundle = com.tencent.mm.plugin.finder.model.ay.EDk;
      com.tencent.mm.plugin.finder.model.ay.startTimer();
      this.feX = true;
      paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eVe().bmg()).intValue() != 1) {
        break label778;
      }
      bool1 = true;
      Log.i("Finder.HomeUIC", "[onCreate] index=" + Ni(((ah.d)localObject1).aixb) + " tabType=" + ((ah.d)localObject1).aixb + " FIX_REINIT_SELECTOR_ENABLE_VALUE=" + bool1);
      if ((getIntent().getLongExtra("key_finder_post_local_id", -1L) == -1L) || (!getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false))) {
        break label784;
      }
      bool2 = true;
      this.GRz = bool2;
      if (getIntent().getIntExtra("FROM_SCENE_KEY", 2) != 6) {
        break label790;
      }
      bool2 = true;
      this.Btk = bool2;
      if (!bool1) {
        break label804;
      }
      localObject2 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderSyncExtension();
      paramBundle = as.GSQ;
      paramBundle = as.a.hu((Context)getContext());
      if (paramBundle != null) {
        break label796;
      }
      paramBundle = null;
      ((com.tencent.mm.plugin.finder.api.j)localObject2).a(113661, 7, paramBundle);
      i = ((ah.d)localObject1).aixb;
      paramBundle = new Bundle();
      paramBundle.putInt("Source", 1);
      paramBundle.putBoolean("IsFirstEnterTab", true);
      localObject1 = ah.aiuX;
      u(i, paramBundle);
      ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).checkLastLiveObject((Context)getActivity(), null);
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(this.qCv);
      com.tencent.threadpool.h.ahAA.bo(FinderHomeUIC..ExternalSyntheticLambda2.INSTANCE);
      paramBundle = com.tencent.mm.plugin.finder.report.g.Foo;
      com.tencent.mm.plugin.finder.report.g.gN((Context)getContext());
      if (this.Btk)
      {
        paramBundle = getIntent().getStringExtra("from_user");
        i = getIntent().getIntExtra("report_scene", 0);
        j = getIntent().getIntExtra("report_uitype", 2);
        l = getIntent().getLongExtra("KEY_OBJECT_ID", 0L);
        localObject1 = z.FrZ;
        localObject1 = paramBundle;
        if (paramBundle == null) {
          localObject1 = "";
        }
        paramBundle = as.GSQ;
        paramBundle = as.a.hu((Context)getContext());
        if (paramBundle != null) {
          break label862;
        }
        paramBundle = null;
      }
    }
    for (;;)
    {
      z.a(l, i, 1L, (String)localObject1, 1, j, null, paramBundle);
      AppMethodBeat.o(338867);
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
      i = this.AZj.fmM();
      break;
      label772:
      bool1 = false;
      break label158;
      label778:
      bool1 = false;
      break label321;
      label784:
      bool2 = false;
      break label414;
      label790:
      bool2 = false;
      break label439;
      label796:
      paramBundle = paramBundle.fou();
      break label484;
      label804:
      localObject2 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderSyncExtension();
      paramBundle = as.GSQ;
      paramBundle = as.a.hu((Context)getContext());
      if (paramBundle == null) {}
      for (paramBundle = null;; paramBundle = paramBundle.fou())
      {
        ((com.tencent.mm.plugin.finder.api.j)localObject2).a(113149, 7, paramBundle);
        break;
      }
      label862:
      paramBundle = paramBundle.fou();
      if (paramBundle == null) {
        paramBundle = null;
      } else {
        paramBundle = paramBundle.zIO;
      }
    }
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(338885);
    super.onCreateAfter(paramBundle);
    if ((getIntent().getBooleanExtra("KEY_POST_DIRECTLY_FROM_SNS", false)) || (getIntent().getBooleanExtra("KEY_FROM_SHARE_REL", false)))
    {
      localObject = getIntent().getStringExtra("key_context_id");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      i = getIntent().getIntExtra("key_auto_trigger_type", 0);
      localObject = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
      m.a.ai(paramBundle, 1, i);
    }
    int i = getIntent().getIntExtra("FROM_SCENE_KEY", 2);
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Ns(i);
    paramBundle = getIntent().getStringExtra("KEY_TASK_ID");
    Object localObject = (CharSequence)paramBundle;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { paramBundle, "finder_home_ui_create_after", Long.valueOf(System.currentTimeMillis()), "", Integer.valueOf(1), Integer.valueOf(1) });
      }
      AppMethodBeat.o(338885);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(338959);
    super.onDestroy();
    Object localObject;
    long l;
    switch (this.AZj.GKp)
    {
    case 2: 
    default: 
      if ((!this.Btk) || (getActiveFragment().hJx != 4)) {
        this.AZj.a(getActiveFragment().hJx, d.c.GKF);
      }
      if (this.Btk) {
        this.AZj.UV(4).a(d.d.GKL);
      }
      this.qmO.dead();
      localObject = com.tencent.mm.plugin.finder.model.ay.EDk;
      com.tencent.mm.plugin.finder.model.ay.stopTimer();
      localObject = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager();
      ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject).DIg.clear();
      ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject).AQE = (cn.bDw() - ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject).enterTime);
      if ((((com.tencent.mm.plugin.finder.extension.reddot.i)localObject).AQG) && (((com.tencent.mm.plugin.finder.extension.reddot.i)localObject).AQF == 2))
      {
        l = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject).AQE;
        com.tencent.mm.plugin.finder.extension.reddot.q localq = com.tencent.mm.plugin.finder.extension.reddot.q.ASF;
        if (l <= com.tencent.mm.plugin.finder.extension.reddot.q.eaJ())
        {
          localObject = com.tencent.mm.plugin.finder.extension.reddot.q.ASF;
          int i = kotlin.k.k.qv(com.tencent.mm.plugin.finder.extension.reddot.q.eaN() + 1, 3);
          Log.w("Finder.RedDotManager", s.X("[exitFinder] current fastLevel=", Integer.valueOf(i)));
          localObject = com.tencent.mm.plugin.finder.extension.reddot.q.ASF;
          com.tencent.mm.plugin.finder.extension.reddot.q.NB(i);
        }
      }
      break;
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.extension.reddot.q.ASF;
      com.tencent.mm.plugin.finder.extension.reddot.q.eaU();
      localObject = o.FpJ;
      if (!o.cng())
      {
        o.FpK = false;
        o.AuP = true;
        o.APX = 0;
        o.hJx = 0;
        o.FpL.clear();
        o.FpM.clear();
      }
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).b(this.qCv);
      AppMethodBeat.o(338959);
      return;
      ((ce)com.tencent.mm.kernel.h.ax(ce.class)).b(null, q.w.DwO, q.n.Dtt.scene, com.tencent.mm.plugin.finder.live.report.d.Dnl);
      break;
      ((ce)com.tencent.mm.kernel.h.ax(ce.class)).b(null, q.w.DwO, q.n.DtA.scene, com.tencent.mm.plugin.finder.live.report.d.Dnl);
      break;
      l = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject).AQE;
      localObject = com.tencent.mm.plugin.finder.extension.reddot.q.ASF;
      if (l > com.tencent.mm.plugin.finder.extension.reddot.q.eaJ())
      {
        Log.w("Finder.RedDotManager", "[exitFinder] revert fastLevel=0");
        localObject = com.tencent.mm.plugin.finder.extension.reddot.q.ASF;
        com.tencent.mm.plugin.finder.extension.reddot.q.NB(0);
      }
    }
  }
  
  public final void onPause()
  {
    ce localce = null;
    Object localObject1 = null;
    AppMethodBeat.i(338929);
    super.onPause();
    MMApplicationContext.getContext().unregisterReceiver((BroadcastReceiver)this.GRE);
    switch (this.AZj.GKp)
    {
    case 2: 
    default: 
      localObject1 = o.FpJ;
      localObject1 = (Context)getContext();
      int i = this.AZj.GKp;
      s.u(localObject1, "context");
      if (!o.cng())
      {
        Log.i("Finder.HomeActionReporter", s.X("[onLeavePage] tabType:", Integer.valueOf(i)));
        o.hJx = i;
        o.FpK = false;
        o.id(i, 2);
        o.a((Context)localObject1, i, new kotlin.r(Integer.valueOf(2), Integer.valueOf(1)), true);
      }
      AppMethodBeat.o(338929);
      return;
    case 3: 
      localce = (ce)com.tencent.mm.kernel.h.ax(ce.class);
      localObject1 = ((ce)com.tencent.mm.kernel.h.ax(ce.class)).etm().Dqx;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = (RecyclerView)((WeakReference)localObject1).get())
      {
        localce.b((RecyclerView)localObject1, q.w.DwO, q.n.Dtt.scene, com.tencent.mm.plugin.finder.live.report.d.Dng);
        break;
      }
    case 1: 
      localce = (ce)com.tencent.mm.kernel.h.ax(ce.class);
      localObject2 = ((ce)com.tencent.mm.kernel.h.ax(ce.class)).etm().Dqx;
      if (localObject2 == null) {}
      for (;;)
      {
        localce.b((RecyclerView)localObject1, q.w.DwO, q.n.DtA.scene, com.tencent.mm.plugin.finder.live.report.d.Dng);
        break;
        localObject1 = (RecyclerView)((WeakReference)localObject2).get();
      }
    }
    Object localObject2 = (ce)com.tencent.mm.kernel.h.ax(ce.class);
    localObject1 = ((ce)com.tencent.mm.kernel.h.ax(ce.class)).etm().Dqx;
    if (localObject1 == null) {}
    for (localObject1 = localce;; localObject1 = (RecyclerView)((WeakReference)localObject1).get())
    {
      ((ce)localObject2).b((RecyclerView)localObject1, q.w.DwQ, "20", com.tencent.mm.plugin.finder.live.report.d.Dng);
      break;
    }
  }
  
  public final void onResume()
  {
    Object localObject2 = null;
    AppMethodBeat.i(338915);
    super.onResume();
    this.GRD = NetStatusUtil.isMobile(MMApplicationContext.getContext());
    Object localObject1 = new IntentFilter();
    ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
    MMApplicationContext.getContext().registerReceiver((BroadcastReceiver)this.GRE, (IntentFilter)localObject1);
    if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).eZF())
    {
      Log.i("Finder.HomeUIC", s.X("onResume: isTeenModeAndViewNothing finish, isMultiTaskOpen = ", Boolean.valueOf(getActivity() instanceof FinderHomeAffinityUI)));
      if ((getActivity() instanceof FinderHomeAffinityUI)) {
        getActivity().finishAndRemoveTask();
      }
    }
    else
    {
      switch (this.AZj.GKp)
      {
      case 2: 
      default: 
        localObject1 = o.FpJ;
        localObject1 = (Context)getContext();
        int i = this.AZj.GKp;
        s.u(localObject1, "context");
        if (!o.cng())
        {
          Log.i("Finder.HomeActionReporter", s.X("[onEnterPage] tabType:", Integer.valueOf(i)));
          o.APX = i;
          o.hJx = i;
          o.FpK = true;
          o.id(i, 1);
          o.a((Context)localObject1, i, new kotlin.r(Integer.valueOf(1), Integer.valueOf(0)));
        }
        if ((this.GRA) && (((bw)com.tencent.mm.kernel.h.ax(bw.class)).eZE()))
        {
          localObject1 = ((bd)getActiveFragment().component(bd.class)).AZO;
          if (localObject1 != null) {
            break label517;
          }
          s.bIx("viewCallback");
          localObject1 = localObject2;
        }
        break;
      }
    }
    label517:
    for (;;)
    {
      aw.b.a.a((aw.b)localObject1, 150L);
      this.GRA = false;
      AppMethodBeat.o(338915);
      return;
      getActivity().finish();
      break;
      ce localce = (ce)com.tencent.mm.kernel.h.ax(ce.class);
      localObject1 = ((ce)com.tencent.mm.kernel.h.ax(ce.class)).etm().Dqx;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = (RecyclerView)((WeakReference)localObject1).get())
      {
        localce.b((RecyclerView)localObject1, q.w.DwO, q.n.Dtt.scene, com.tencent.mm.plugin.finder.live.report.d.Dnf);
        break;
      }
      localce = (ce)com.tencent.mm.kernel.h.ax(ce.class);
      localObject1 = ((ce)com.tencent.mm.kernel.h.ax(ce.class)).etm().Dqx;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = (RecyclerView)((WeakReference)localObject1).get())
      {
        localce.b((RecyclerView)localObject1, q.w.DwO, q.n.DtA.scene, com.tencent.mm.plugin.finder.live.report.d.Dnf);
        break;
      }
      localce = (ce)com.tencent.mm.kernel.h.ax(ce.class);
      localObject1 = ((ce)com.tencent.mm.kernel.h.ax(ce.class)).etm().Dqx;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = (RecyclerView)((WeakReference)localObject1).get())
      {
        localce.b((RecyclerView)localObject1, q.w.DwQ, "20", com.tencent.mm.plugin.finder.live.report.d.Dnf);
        break;
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(338943);
    super.onStop();
    com.tencent.mm.plugin.finder.extension.reddot.i locali;
    Object localObject1;
    com.tencent.mm.plugin.finder.extension.reddot.p localp;
    Object localObject2;
    label132:
    int i;
    if (getActivity().isFinishing())
    {
      locali = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager();
      Activity localActivity = (Activity)getActivity();
      s.u(localActivity, "activity");
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((com.tencent.mm.plugin.finder.storage.d.eXD()) && (((com.tencent.mm.plugin.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.l.class)).D(localActivity)))
      {
        localp = locali.Su("FinderEntrance");
        if (localp != null) {
          break label294;
        }
        localObject1 = null;
        if ((localp != null) && (localObject1 != null))
        {
          localObject2 = w.FrV;
          localObject2 = as.GSQ;
          localObject2 = as.a.hu((Context)localActivity);
          if (localObject2 != null) {
            break label306;
          }
          localObject2 = null;
          w.a("2", localp, (bxq)localObject1, 2, (bui)localObject2, 1, 0, null, 0, 1, null, 0, 3520);
        }
      }
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      i = ((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).fmM();
      if (localActivity.getIntent().getIntExtra("FROM_SCENE_KEY", 2) != 6) {
        break label316;
      }
    }
    label294:
    label306:
    label316:
    for (boolean bool = true;; bool = false)
    {
      if (!bool)
      {
        locali.TL("FinderEntrance");
        locali.TL("Discovery");
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.d.APW;
        com.tencent.mm.plugin.finder.extension.reddot.d.c(null);
      }
      Log.i("Finder.RedDotManager", "[exitFinderBefore] isSourceFromShareToTimeline=" + bool + " tabType=" + i);
      if ((this.Btk) && (getActiveFragment().hJx == 4)) {
        break label321;
      }
      this.AZj.UT(getActiveFragment().hJx);
      AppMethodBeat.o(338943);
      return;
      localObject1 = localp.avK("FinderEntrance");
      break;
      localObject2 = ((as)localObject2).fou();
      break label132;
    }
    label321:
    this.AZj.UU(getActiveFragment().hJx);
    AppMethodBeat.o(338943);
  }
  
  public final void u(int paramInt, Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(338974);
    int k = Ni(paramInt);
    int i = j;
    if (k >= 0)
    {
      i = j;
      if (k < this.fragments.size()) {
        i = 1;
      }
    }
    if (i != 0)
    {
      if (paramBundle != null) {
        ((FinderHomeTabFragment)this.fragments.get(k)).EHy = paramBundle;
      }
      this.AZj.GKp = paramInt;
      this.AZj.GKq = paramInt;
      ((FinderViewPager)getActivity().findViewById(e.e.viewPager)).setCurrentItem(k);
    }
    AppMethodBeat.o(338974);
  }
  
  public final void vp(boolean paramBoolean)
  {
    AppMethodBeat.i(339033);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = (bf)com.tencent.mm.ui.component.k.d(getActivity()).q(bf.class);
    ((bf)localObject).fragments = ((List)this.fragments);
    e.launch$default((e)localObject, null, null, (kotlin.g.a.m)new bf.b((bf)localObject, paramBoolean, null), 3, null);
    AppMethodBeat.o(339033);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onPageScrollStateChanged", "state", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends FinderFragmentChangeObserver
  {
    b(FinderHomeUIC paramFinderHomeUIC, AppCompatActivity paramAppCompatActivity, ArrayList<FinderHomeTabFragment> paramArrayList)
    {
      super((List)paramArrayList);
      AppMethodBeat.i(338667);
      AppMethodBeat.o(338667);
    }
    
    public final void N(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(338690);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt2);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt3);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt4);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onFragmentChange", "(IIII)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      if (paramInt1 != -1)
      {
        localObject = com.tencent.mm.plugin.finder.report.r.Fqi;
        com.tencent.mm.plugin.finder.report.r.c(true, false, 2);
      }
      FinderHomeUIC.c(this.GRF).GKp = paramInt4;
      FinderHomeUIC.c(this.GRF).GKq = paramInt4;
      FinderHomeUIC.a(this.GRF, paramInt2);
      localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = com.tencent.mm.ui.component.k.d(paramAppCompatActivity).q(af.class);
      s.s(localObject, "UICProvider.of(activity)…ActionBarUIC::class.java)");
      ((af)localObject).Qw(paramInt2);
      localObject = ((Iterable)this.GRF.GRB).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.finder.view.h)((Iterator)localObject).next()).N(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      if (paramInt1 != -1)
      {
        localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eXj().bmg()).intValue() == 0)
        {
          localObject = com.tencent.mm.ui.component.k.aeZF;
          ((by)com.tencent.mm.ui.component.k.d(paramAppCompatActivity).cq(by.class)).fpm();
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onFragmentChange", "(IIII)V");
      AppMethodBeat.o(338690);
    }
    
    public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
    {
      AppMethodBeat.i(338681);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).fv(paramBoolean);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramFinderHomeTabFragment);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      s.u(paramFinderHomeTabFragment, "fragment");
      if (paramBoolean)
      {
        localObject = paramFinderHomeTabFragment.getClass().getName();
        s.s(localObject, "fragment.javaClass.name");
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGs = (String)localObject;
      }
      localObject = ((Iterable)this.GRF.GRB).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.finder.view.h)((Iterator)localObject).next()).a(paramBoolean, paramInt, paramFinderHomeTabFragment);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V");
      AppMethodBeat.o(338681);
    }
    
    public final void onPageScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(338695);
      Iterator localIterator = ((Iterable)this.GRF.GRB).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.finder.view.h)localIterator.next()).onPageScrollStateChanged(paramInt);
      }
      AppMethodBeat.o(338695);
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(338673);
      super.onPageScrolled(paramInt1, paramFloat, paramInt2);
      Iterator localIterator = ((Iterable)this.GRF.GRB).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.finder.view.h)localIterator.next()).onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
      AppMethodBeat.o(338673);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final c GRG;
    
    static
    {
      AppMethodBeat.i(338674);
      GRG = new c();
      AppMethodBeat.o(338674);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$onCreate$4$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "onFailed", "", "p0", "", "p1", "p2", "", "onSuccess", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.plugin.wallet.wecoin.a.i<Long>
  {
    public final void s(int paramInt1, int paramInt2, String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC
 * JD-Core Version:    0.7.0.1
 */