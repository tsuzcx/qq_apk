package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.a.o;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.f.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.component.UIComponentActivity;
import d.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerCallback;", "", "()V", "DESC_onScrollStateChanged", "", "DESC_onScrolled", "NAME_onScrollStateChanged", "NAME_onScrolled", "SUPER_NAME", "TAG", "mClickCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback;", "mFinderFragmentCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback;", "mFragmentFeedStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FragmentFeedStatistics;", "mItemDecorationCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback;", "mListener", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "mListeners", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IRecyclerMonitorListener;", "mMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "Lkotlin/collections/HashMap;", "mRefreshLoadMoreCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "mShareStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderShareStatistics;", "mWaterfallsFlowMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor;", "fragmentFeedFlowOnFree", "", "activityName", "getCurFragmentOfFinderHomeUI", "Landroid/support/v4/app/Fragment;", "activity", "Landroid/app/Activity;", "monitor", "on7Event", "pageName", "timestamp", "", "on8Event", "onActivityCreate", "onFinderHomeUIPaused", "onFinderHomeUIResumed", "onFinishActivity", "onLoadMoreBegin", "onLoadMoreEnd", "className", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "onRefreshBegin", "onRefreshEnd", "onScrollStateChanged", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "registerClickListener", "listener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "registerFinderFragmentListener", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "registerListener", "startFinderFragmentMonitor", "startFragmentFeedFlowMonitor", "Landroid/support/v4/app/FragmentActivity;", "fragment", "fragmentEventId", "startItemDecorationMonitor", "startMonitorClick", "startWaterfallsFlowMonitor", "eventId", "stopFinderFragmentMonitor", "stopFragmentFeedFlowMonitor", "stopItemDecorationMonitor", "stopMonitorClick", "stopWaterfallsFlowMonitor", "unregisterClickListener", "unregisterFinderFragmentListener", "unregisterListener", "RecycylerScrollListener", "plugin-expt_release"})
public final class j
{
  private static final HashMap<String, List<Pair<String, String>>> KGr;
  private static final k KHm;
  private static final b KHn;
  private static final l KHo;
  private static final com.tencent.mm.plugin.expt.hellhound.a.b.b KHp;
  private static final com.tencent.mm.plugin.expt.hellhound.a.a.b KHq;
  private static final com.tencent.mm.plugin.expt.hellhound.a.b.d.d KHr;
  private static final a KHs;
  public static final j KHt;
  private static final List<e> mListeners;
  private static com.tencent.mm.hellhoundlib.a.c pEV;
  
  static
  {
    AppMethodBeat.i(205232);
    KHt = new j();
    KGr = new HashMap();
    mListeners = (List)new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V"));
    localArrayList.add(Pair.create("onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V"));
    ((Map)KGr).put("android/support/v7/widget/RecyclerView$OnScrollListener", localArrayList);
    pEV = (com.tencent.mm.hellhoundlib.a.c)new a();
    KHm = new k();
    KHn = new b();
    KHo = new l();
    KHp = new com.tencent.mm.plugin.expt.hellhound.a.b.b();
    KHq = new com.tencent.mm.plugin.expt.hellhound.a.a.b();
    KHr = new com.tencent.mm.plugin.expt.hellhound.a.b.d.d();
    KHs = new a();
    AppMethodBeat.o(205232);
  }
  
  public static final void Bn(long paramLong)
  {
    AppMethodBeat.i(205218);
    ebj localebj = com.tencent.mm.plugin.expt.hellhound.a.b.d.f.KIv.fRM();
    int i;
    if (localebj != null)
    {
      LinkedList localLinkedList = localebj.LAi;
      d.g.b.k.g(localLinkedList, "statistics.stayTimeOnBackground");
      if (((Collection)localLinkedList).isEmpty()) {
        break label89;
      }
      i = 1;
      if (i != 0)
      {
        if (localebj.LAi.size() % 2 == 0) {
          break label94;
        }
        localebj.LAi.add(Long.valueOf(paramLong));
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.d.f.KIv.a(localebj);
      com.tencent.mm.plugin.expt.hellhound.a.b.d.d.Bo(paramLong);
      AppMethodBeat.o(205218);
      return;
      label89:
      i = 0;
      break;
      label94:
      localebj.LAi.removeLast();
      localebj.LAi.add(Long.valueOf(paramLong));
    }
  }
  
  public static final void a(Activity paramActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(205219);
    com.tencent.mm.plugin.expt.hellhound.a.b.b localb = KHp;
    Object localObject;
    if (paramFragment == null) {
      if (paramActivity != null)
      {
        localObject = paramActivity.getClass();
        if (localObject != null)
        {
          localObject = ((Class)localObject).getName();
          c.a locala = c.KGM;
          if (!c.fRI().contains(localObject)) {
            break label383;
          }
          ad.i("HABBYGE-MALI.WaterfallsFlowMonitor", "monitor: poageName=".concat(String.valueOf(localObject)));
          localb.KEV = ((String)localObject);
          KHt.a((e)localb.KEX);
          localb.KEW = new com.tencent.mm.plugin.expt.hellhound.a.b.d.j(paramActivity, paramFragment);
          localObject = localb.KEW;
          if (localObject == null) {
            break label383;
          }
          if (paramFragment != null) {
            break label286;
          }
          if (paramActivity == null) {
            break label250;
          }
          paramFragment = paramActivity.getClass();
          if (paramFragment == null) {
            break label250;
          }
          paramFragment = paramFragment.getName();
          label139:
          ad.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute: pageName=".concat(String.valueOf(paramFragment)));
          if (!d.g.b.k.g(paramFragment, c.KGF)) {
            break label267;
          }
          if (!d.g.b.k.g(paramFragment, c.KGH)) {
            break label255;
          }
          ad.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: 7Event !!");
          ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).a(paramActivity, paramLong);
          label191:
          c.KGG = null;
          c.KGF = null;
        }
      }
    }
    for (;;)
    {
      paramActivity = (d)((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).KIP.KIk;
      d.g.b.k.h(paramActivity, "listener");
      KHs.a(paramActivity);
      AppMethodBeat.o(205219);
      return;
      localObject = null;
      break;
      localObject = paramFragment.getClass().getName();
      break;
      label250:
      paramFragment = null;
      break label139;
      label255:
      ad.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: startActivity !!");
      break label191;
      label267:
      ad.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: Back to activity !!");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).a(paramActivity, paramLong);
      break label191;
      switch (paramInt)
      {
      case 1: 
      default: 
        ad.printErrStackTrace("HABBYGE-MALI.WaterfallsFlowStatistics", (Throwable)new NullPointerException("startCompute, fragment, miss !!"), "", new Object[0]);
        break;
      case 0: 
        ad.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, resume !!");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).a(paramFragment, paramLong);
        break;
      case 2: 
        label286:
        ad.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, 7Event !!");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).a(paramFragment, paramLong);
      }
    }
    label383:
    AppMethodBeat.o(205219);
  }
  
  public static void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(205224);
    d.g.b.k.h(paramFragmentActivity, "activity");
    d.g.b.k.h(paramFragment, "fragment");
    com.tencent.mm.plugin.expt.hellhound.a.a.b localb = KHq;
    d.g.b.k.h(paramFragmentActivity, "activity");
    d.g.b.k.h(paramFragment, "fragment");
    paramFragment = paramFragment.getClass().getName();
    ad.d("HABBYGE-MALI.FragmentFeedStatistics", "start: fragment:" + paramFragment + ", event=" + paramInt);
    if (paramFragment == null)
    {
      AppMethodBeat.o(205224);
      return;
    }
    switch (paramFragment.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(205224);
            return;
          } while (!paramFragment.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment"));
          if (localb.KEK == null) {
            localb.KEK = ((o)new com.tencent.mm.plugin.expt.hellhound.a.b.a.f((Activity)paramFragmentActivity));
          }
          paramFragmentActivity = localb.KEK;
          if (paramFragmentActivity == null) {
            break;
          }
          paramFragmentActivity.cdL();
          AppMethodBeat.o(205224);
          return;
        } while (!paramFragment.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment"));
        if (localb.KEM == null) {
          localb.KEM = ((o)new com.tencent.mm.plugin.expt.hellhound.a.b.a.j((Activity)paramFragmentActivity));
        }
        paramFragmentActivity = localb.KEM;
      } while (paramFragmentActivity == null);
      paramFragmentActivity.cdL();
      AppMethodBeat.o(205224);
      return;
    } while (!paramFragment.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment"));
    if (localb.KEL == null) {
      localb.KEL = ((o)new com.tencent.mm.plugin.expt.hellhound.a.b.a.g((Activity)paramFragmentActivity));
    }
    paramFragmentActivity = localb.KEL;
    if (paramFragmentActivity != null)
    {
      paramFragmentActivity.cdL();
      AppMethodBeat.o(205224);
      return;
      AppMethodBeat.o(205224);
      return;
    }
    AppMethodBeat.o(205224);
  }
  
  public static final void a(com.tencent.mm.plugin.expt.hellhound.core.d paramd)
  {
    AppMethodBeat.i(205210);
    d.g.b.k.h(paramd, "listener");
    Object localObject = KHn;
    d.g.b.k.h(paramd, "listener");
    localObject = ((b)localObject).KGm;
    if (localObject != null)
    {
      d.g.b.k.h(paramd, "listener");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject).pEP = paramd;
      AppMethodBeat.o(205210);
      return;
    }
    AppMethodBeat.o(205210);
  }
  
  public static final void aUW(String paramString)
  {
    AppMethodBeat.i(205206);
    k localk = KHm;
    if (!k.aVd(paramString))
    {
      ad.i("HABBYGE-MALI.RecyclerItemDecorationCallback", "monitor");
      paramString = localk.pFP;
      if (paramString != null) {
        paramString.clear();
      }
      com.tencent.mm.hellhoundlib.a.adm();
      com.tencent.mm.hellhoundlib.a.c((Map)localk.KGr, (com.tencent.mm.hellhoundlib.a.c)localk.KHu);
    }
    AppMethodBeat.o(205206);
  }
  
  public static final void aUX(String paramString)
  {
    AppMethodBeat.i(205207);
    k localk = KHm;
    if (!k.aVd(paramString))
    {
      ad.i("HABBYGE-MALI.RecyclerItemDecorationCallback", "unmonitor");
      paramString = localk.pFP;
      if (paramString != null)
      {
        paramString = (RecyclerView)paramString.get();
        if (paramString != null) {
          paramString.b((RecyclerView.m)localk.KHv);
        }
      }
      paramString = localk.pFP;
      if (paramString != null) {
        paramString.clear();
      }
      localk.pFP = null;
      com.tencent.mm.hellhoundlib.a.adm();
      com.tencent.mm.hellhoundlib.a.d((Map)localk.KGr, (com.tencent.mm.hellhoundlib.a.c)localk.KHu);
    }
    AppMethodBeat.o(205207);
  }
  
  public static final void aUY(String paramString)
  {
    AppMethodBeat.i(205208);
    b localb = KHn;
    localb.KGi = paramString;
    if ((!(d.g.b.k.g("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString) ^ true)) || (!(d.g.b.k.g("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString) ^ true)))
    {
      ad.i("HABBYGE-MALI.FinderFragmentCallback", "monitor...");
      localb.acD = -1;
      localb.KGk = true;
      localb.KGl = false;
      com.tencent.mm.hellhoundlib.a.adm();
      com.tencent.mm.hellhoundlib.a.c((Map)localb.KGr, (com.tencent.mm.hellhoundlib.a.c)localb.KGs);
    }
    AppMethodBeat.o(205208);
  }
  
  public static final void aUZ(String paramString)
  {
    AppMethodBeat.i(205209);
    b localb = KHn;
    localb.KGj = paramString;
    if ((!(d.g.b.k.g("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString) ^ true)) || (!(d.g.b.k.g("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString) ^ true)))
    {
      ad.i("HABBYGE-MALI.FinderFragmentCallback", "unmonitor...");
      localb.KGk = false;
      localb.KGl = true;
      com.tencent.mm.hellhoundlib.a.adm();
      com.tencent.mm.hellhoundlib.a.d((Map)localb.KGr, (com.tencent.mm.hellhoundlib.a.c)localb.KGs);
    }
    AppMethodBeat.o(205209);
  }
  
  public static final void aVa(String paramString)
  {
    AppMethodBeat.i(205221);
    if ((d.g.b.k.g("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (d.g.b.k.g("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)))
    {
      paramString = KHq;
      ad.i("HABBYGE-MALI.FragmentFeedStatistics", "stop: free...");
      o localo = paramString.KEK;
      if (localo != null) {
        localo.free();
      }
      paramString.KEK = null;
      localo = paramString.KEL;
      if (localo != null) {
        localo.free();
      }
      paramString.KEL = null;
      localo = paramString.KEM;
      if (localo != null) {
        localo.free();
      }
      paramString.KEM = null;
    }
    AppMethodBeat.o(205221);
  }
  
  public static final void aVb(String paramString)
  {
    AppMethodBeat.i(205222);
    if ((d.g.b.k.g("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (d.g.b.k.g("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)))
    {
      KHs.ccE();
      AppMethodBeat.o(205222);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.pHq;
    localObject = b.a.ccR();
    if (((d.g.b.k.g(localObject, "999")) || (d.g.b.k.g(localObject, "101")) || (d.g.b.k.g(localObject, "102")) || (d.g.b.k.g(localObject, "123"))) && ((d.g.b.k.g("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", paramString)) || (d.g.b.k.g("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", paramString)) || (d.g.b.k.g("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", paramString)))) {
      KHs.ccE();
    }
    AppMethodBeat.o(205222);
  }
  
  public static final void aVc(String paramString)
  {
    AppMethodBeat.i(205223);
    if ((d.g.b.k.g("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (d.g.b.k.g("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)))
    {
      KHs.fRu();
      AppMethodBeat.o(205223);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.pHq;
    localObject = b.a.ccR();
    if (((d.g.b.k.g(localObject, "999")) || (d.g.b.k.g(localObject, "101")) || (d.g.b.k.g(localObject, "102")) || (d.g.b.k.g(localObject, "123"))) && ((d.g.b.k.g("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", paramString)) || (d.g.b.k.g("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", paramString)) || (d.g.b.k.g("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", paramString)))) {
      KHs.fRu();
    }
    AppMethodBeat.o(205223);
  }
  
  public static final void b(Activity paramActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(205220);
    com.tencent.mm.plugin.expt.hellhound.a.b.b localb = KHp;
    Object localObject;
    if (paramFragment == null) {
      if (paramActivity != null)
      {
        localObject = paramActivity.getClass();
        if (localObject != null)
        {
          localObject = ((Class)localObject).getName();
          c.a locala = c.KGM;
          if (c.fRI().contains(localObject))
          {
            ad.i("HABBYGE-MALI.WaterfallsFlowMonitor", "unmonitor: poageName=".concat(String.valueOf(localObject)));
            KHt.b((e)localb.KEX);
            localObject = localb.KEW;
            if (localObject != null)
            {
              if (paramFragment != null) {
                break label303;
              }
              if (paramActivity == null) {
                break label238;
              }
              paramFragment = paramActivity.getClass();
              if (paramFragment == null) {
                break label238;
              }
              paramFragment = paramFragment.getName();
              label118:
              ad.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: pageName=".concat(String.valueOf(paramFragment)));
              if (!d.g.b.k.g(paramFragment, c.KGG)) {
                break label243;
              }
              ad.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: finish cur page !");
              ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).KIJ = 1;
              paramInt = 1;
              label162:
              ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).b(paramActivity, paramLong);
              if (paramInt != 0)
              {
                paramActivity = c.KGM;
                c.a.fRK();
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      paramActivity = (d)((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).KIP.KIk;
      d.g.b.k.h(paramActivity, "listener");
      KHs.b(paramActivity);
      localb.KEW = null;
      AppMethodBeat.o(205220);
      return;
      localObject = null;
      break;
      localObject = paramFragment.getClass().getName();
      break;
      label238:
      paramFragment = null;
      break label118;
      label243:
      if (((d.g.b.k.g(paramFragment, c.KGF) ^ true)) && (c.KGF != null))
      {
        ad.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: startActivity another page !");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).KIJ = 1;
        paramInt = 0;
        break label162;
      }
      ad.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: 8Event !");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).KIJ = 2;
      paramInt = 0;
      break label162;
      switch (paramInt)
      {
      case 2: 
      default: 
        ad.printErrStackTrace("HABBYGE-MALI.WaterfallsFlowStatistics", (Throwable)new NullPointerException("startCompute, fragment, miss !!"), "", new Object[0]);
        break;
      case 1: 
        ad.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, pause !!");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).KIJ = 1;
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).b(paramFragment, paramLong);
        break;
      case 3: 
        label303:
        ad.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, 8Event !!");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).KIJ = 2;
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).b(paramFragment, paramLong);
      }
    }
  }
  
  public static void b(FragmentActivity paramFragmentActivity, Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(205225);
    d.g.b.k.h(paramFragmentActivity, "activity");
    d.g.b.k.h(paramFragment, "fragment");
    com.tencent.mm.plugin.expt.hellhound.a.a.b localb = KHq;
    d.g.b.k.h(paramFragmentActivity, "activity");
    d.g.b.k.h(paramFragment, "fragment");
    paramFragmentActivity = paramFragment.getClass().getName();
    ad.d("HABBYGE-MALI.FragmentFeedStatistics", "stop: fragment:" + paramFragmentActivity + ", event=" + paramInt);
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(205225);
      return;
    }
    switch (paramFragmentActivity.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(205225);
            return;
          } while (!paramFragmentActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment"));
          paramFragmentActivity = localb.KEK;
          if (paramFragmentActivity == null) {
            break;
          }
          paramFragmentActivity.ccd();
          AppMethodBeat.o(205225);
          return;
        } while (!paramFragmentActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment"));
        paramFragmentActivity = localb.KEM;
      } while (paramFragmentActivity == null);
      paramFragmentActivity.ccd();
      AppMethodBeat.o(205225);
      return;
    } while (!paramFragmentActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment"));
    paramFragmentActivity = localb.KEL;
    if (paramFragmentActivity != null)
    {
      paramFragmentActivity.ccd();
      AppMethodBeat.o(205225);
      return;
      AppMethodBeat.o(205225);
      return;
    }
    AppMethodBeat.o(205225);
  }
  
  public static final Fragment bt(Activity paramActivity)
  {
    Object localObject2 = null;
    AppMethodBeat.i(205212);
    b localb = KHn;
    Object localObject1 = localObject2;
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getClass();
      localObject1 = localObject2;
      if (paramActivity != null)
      {
        paramActivity = paramActivity.getName();
        if (paramActivity != null) {
          break label53;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      paramActivity = (Fragment)localObject1;
      AppMethodBeat.o(205212);
      return paramActivity;
      label53:
      if ((d.g.b.k.g(paramActivity, "com.tencent.mm.plugin.finder.ui.FinderHomeUI") ^ true))
      {
        localObject1 = localObject2;
        if ((d.g.b.k.g(paramActivity, "com.tencent.mm.plugin.finder.ui.FinderConversationUI") ^ true)) {}
      }
      else
      {
        localObject1 = localb.n(null, -1);
      }
    }
  }
  
  public static void ccE()
  {
    AppMethodBeat.i(205203);
    ad.i("HABBYGE-MALI.RecyclerCallback", "monitor...");
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.a((Map)KGr, pEV);
    Object localObject1 = KHo;
    ad.i("HABBYGE-MALI.RefreshLoadMoreCallback", "startMonitor...");
    Object localObject2 = new h();
    ad.i("HABBYGE-MALI.RLBeginCallback", "startMonitor...");
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.a((Map)((h)localObject2).KGr, (com.tencent.mm.hellhoundlib.a.c)((h)localObject2).KHg);
    localObject2 = new i((l)localObject1);
    ad.i("HABBYGE-MALI.RLEndCallback", "startMonitor...");
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.a((Map)((i)localObject2).KGr, (com.tencent.mm.hellhoundlib.a.c)((i)localObject2).KHi);
    localObject1 = new m((l)localObject1);
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.a((Map)((m)localObject1).KGr, (com.tencent.mm.hellhoundlib.a.c)((m)localObject1).KHK);
    new g();
    com.tencent.mm.plugin.expt.hellhound.a.b.d.f.KIv.reset();
    com.tencent.mm.plugin.expt.hellhound.a.b.d.f.KIv.fRO();
    AppMethodBeat.o(205203);
  }
  
  public static final void cj(String paramString, long paramLong)
  {
    AppMethodBeat.i(205217);
    ebj localebj = com.tencent.mm.plugin.expt.hellhound.a.b.d.f.KIv.fRM();
    if (localebj != null)
    {
      if (!localebj.LAi.isEmpty()) {
        break label166;
      }
      localebj.LAi.add(Long.valueOf(paramLong));
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.d.f.KIv.a(localebj);
      localebj = com.tencent.mm.plugin.expt.hellhound.a.b.d.f.KIv.fRN();
      if (localebj != null)
      {
        localebj.KHV = paramLong;
        localebj.xBr = (localebj.KHV - localebj.KHU);
        localebj.KHW = com.tencent.mm.plugin.expt.hellhound.core.b.fRm();
        localebj.dvJ = c.b.KGO.value;
        a.a locala = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.KHO;
        a.a.a(com.tencent.mm.plugin.expt.hellhound.a.b.d.d.a(localebj, c.b.KGO.value));
        localebj.dvJ = 8;
        com.tencent.mm.plugin.expt.hellhound.a.b.d.f.KIv.b(localebj);
        ad.i("HABBYGE-MALI.FinderShareStatistics", "doOn8EventV2: " + paramString + ", " + localebj.aFj);
      }
      AppMethodBeat.o(205217);
      return;
      label166:
      if (localebj.LAi.size() % 2 == 0)
      {
        localebj.LAi.add(Long.valueOf(paramLong));
      }
      else
      {
        localebj.LAi.removeLast();
        localebj.LAi.add(Long.valueOf(paramLong));
      }
    }
  }
  
  public static final void d(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(205213);
    Object localObject1;
    label66:
    boolean bool;
    if (paramActivity != null)
    {
      localObject1 = paramActivity.getClass();
      if (localObject1 != null)
      {
        localObject1 = ((Class)localObject1).getName();
        if (localObject1 != null) {
          break label340;
        }
        localObject1 = KHr;
        Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.pHq;
        localObject2 = b.a.ccR();
        if (paramActivity == null) {
          break label717;
        }
        paramActivity = paramActivity.getClass();
        if (paramActivity == null) {
          break label717;
        }
        paramActivity = paramActivity.getName();
        Object localObject3 = c.KGM;
        if (d.a.j.a((Iterable)c.fRG(), paramActivity))
        {
          ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).KIo = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).KIo;
          if (localObject3 == null) {
            d.g.b.k.aPZ("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.ccM().cbk();
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).KIo;
          if (localObject3 == null) {
            d.g.b.k.aPZ("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).DDP = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramActivity);
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).KIo;
          if (localObject3 == null) {
            d.g.b.k.aPZ("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).KHU = paramLong;
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).KIo;
          if (localObject3 == null) {
            d.g.b.k.aPZ("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).pZX = ((String)localObject2);
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).KIo;
          if (localObject2 == null) {
            d.g.b.k.aPZ("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).dvJ = c.b.KGN.value;
          if (!d.g.b.k.g(paramActivity, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
            break label727;
          }
          paramActivity = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).KIo;
          if (paramActivity == null) {
            d.g.b.k.aPZ("mStayTime");
          }
          localObject2 = c.KGM;
          if (c.fRJ() != c.c.KGS.value) {
            break label722;
          }
          bool = true;
        }
      }
    }
    label275:
    label717:
    label722:
    for (paramActivity.KHX = bool;; paramActivity.KHX = false)
    {
      paramActivity = new StringBuilder("doPageResume: ");
      localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).KIo;
      if (localObject1 == null) {
        d.g.b.k.aPZ("mStayTime");
      }
      ad.i("HABBYGE-MALI.FinderShareStatistics", ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).DDP);
      AppMethodBeat.o(205213);
      return;
      localObject1 = null;
      break;
      label340:
      switch (((String)localObject1).hashCode())
      {
      default: 
        break;
      case -2055689330: 
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderHomeUI")) {
          break;
        }
        localObject1 = KHn;
        if (paramActivity == null)
        {
          paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
          AppMethodBeat.o(205213);
          throw paramActivity;
        }
      case -936307702: 
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI")) {
          break;
        }
        localObject1 = KHn;
        if (paramActivity == null)
        {
          paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
          AppMethodBeat.o(205213);
          throw paramActivity;
        }
      case -2013384910: 
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderConversationUI")) {
          break;
        }
        localObject1 = KHn;
        if (paramActivity == null)
        {
          paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
          AppMethodBeat.o(205213);
          throw paramActivity;
        }
        ((b)localObject1).a((FragmentActivity)paramActivity, paramLong);
        AppMethodBeat.o(205213);
        return;
        ((b)localObject1).a((FragmentActivity)paramActivity, paramLong);
        AppMethodBeat.o(205213);
        return;
        d.g.b.k.h((FragmentActivity)paramActivity, "activity");
        paramActivity = ((b)localObject1).KGm;
        if (paramActivity != null)
        {
          paramActivity.KET = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
          localObject1 = paramActivity.KET;
          if (localObject1 == null) {
            d.g.b.k.aPZ("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.ccM().cbk();
          localObject1 = paramActivity.KET;
          if (localObject1 == null) {
            d.g.b.k.aPZ("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).DDP = com.tencent.mm.plugin.expt.hellhound.core.b.Vy("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI");
          localObject1 = paramActivity.KET;
          if (localObject1 == null) {
            d.g.b.k.aPZ("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).KHU = paramLong;
          localObject1 = paramActivity.KET;
          if (localObject1 == null) {
            d.g.b.k.aPZ("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).pZX = "143";
          paramActivity = paramActivity.KET;
          if (paramActivity == null) {
            d.g.b.k.aPZ("statyTimeStaticLbsList");
          }
          paramActivity.dvJ = c.b.KGN.value;
          ad.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderLbsStreamListUIResume...");
          AppMethodBeat.o(205213);
          return;
        }
        AppMethodBeat.o(205213);
        return;
        paramActivity = null;
        break label66;
        bool = false;
        break label275;
        label727:
        paramActivity = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).KIo;
        if (paramActivity == null) {
          d.g.b.k.aPZ("mStayTime");
        }
        break;
      }
    }
  }
  
  public static final void e(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(205214);
    Object localObject1;
    if (paramActivity != null)
    {
      localObject1 = paramActivity.getClass();
      if (localObject1 != null)
      {
        localObject1 = ((Class)localObject1).getName();
        if (localObject1 != null) {
          break label288;
        }
        localObject1 = KHr;
        if (paramActivity == null) {
          break label754;
        }
        paramActivity = paramActivity.getClass();
        if (paramActivity == null) {
          break label754;
        }
      }
    }
    label288:
    label754:
    for (paramActivity = paramActivity.getName();; paramActivity = null)
    {
      Object localObject2 = c.KGM;
      if (d.a.j.a((Iterable)c.fRG(), paramActivity))
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramActivity);
        localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).KIo;
        if (localObject2 == null) {
          d.g.b.k.aPZ("mStayTime");
        }
        if (d.g.b.k.g(((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).DDP, paramActivity))
        {
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).KIo;
          if (localObject2 == null) {
            d.g.b.k.aPZ("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).KHV = paramLong;
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).KIo;
          if (localObject2 == null) {
            d.g.b.k.aPZ("mStayTime");
          }
          com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).KIo;
          if (localb == null) {
            d.g.b.k.aPZ("mStayTime");
          }
          paramLong = localb.KHV;
          localb = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).KIo;
          if (localb == null) {
            d.g.b.k.aPZ("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).xBr = (paramLong - localb.KHU);
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).KIo;
          if (localObject2 == null) {
            d.g.b.k.aPZ("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).KHW = com.tencent.mm.plugin.expt.hellhound.core.b.fRm();
          localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.KHO;
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).KIo;
          if (localObject1 == null) {
            d.g.b.k.aPZ("mStayTime");
          }
          a.a.a((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1);
          ad.i("HABBYGE-MALI.FinderShareStatistics", "onPagePaused: ".concat(String.valueOf(paramActivity)));
        }
      }
      AppMethodBeat.o(205214);
      return;
      localObject1 = null;
      break;
      switch (((String)localObject1).hashCode())
      {
      default: 
        break;
      case -2055689330: 
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderHomeUI")) {
          break;
        }
        localObject1 = KHn;
        if (paramActivity == null)
        {
          paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
          AppMethodBeat.o(205214);
          throw paramActivity;
        }
      case -936307702: 
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI")) {
          break;
        }
        localObject1 = KHn;
        if (paramActivity == null)
        {
          paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
          AppMethodBeat.o(205214);
          throw paramActivity;
        }
      case -2013384910: 
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderConversationUI")) {
          break;
        }
        localObject1 = KHn;
        if (paramActivity == null)
        {
          paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
          AppMethodBeat.o(205214);
          throw paramActivity;
        }
        ((b)localObject1).b((FragmentActivity)paramActivity, paramLong);
        AppMethodBeat.o(205214);
        return;
        ((b)localObject1).b((FragmentActivity)paramActivity, paramLong);
        AppMethodBeat.o(205214);
        return;
        d.g.b.k.h((FragmentActivity)paramActivity, "activity");
        paramActivity = ((b)localObject1).KGm;
        if (paramActivity != null)
        {
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI");
          if (((com.tencent.mm.plugin.expt.hellhound.a.b.a)paramActivity).KET != null) {}
          for (int i = 1;; i = 0)
          {
            if (i != 0)
            {
              localObject2 = paramActivity.KET;
              if (localObject2 == null) {
                d.g.b.k.aPZ("statyTimeStaticLbsList");
              }
              if (d.g.b.k.g(((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).DDP, localObject1))
              {
                localObject1 = paramActivity.KET;
                if (localObject1 == null) {
                  d.g.b.k.aPZ("statyTimeStaticLbsList");
                }
                ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).KHV = paramLong;
                localObject1 = paramActivity.KET;
                if (localObject1 == null) {
                  d.g.b.k.aPZ("statyTimeStaticLbsList");
                }
                paramLong = ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).KHV;
                localObject1 = paramActivity.KET;
                if (localObject1 == null) {
                  d.g.b.k.aPZ("statyTimeStaticLbsList");
                }
                long l = ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).KHU;
                localObject1 = paramActivity.KET;
                if (localObject1 == null) {
                  d.g.b.k.aPZ("statyTimeStaticLbsList");
                }
                ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).xBr = (paramLong - l);
                localObject1 = paramActivity.KET;
                if (localObject1 == null) {
                  d.g.b.k.aPZ("statyTimeStaticLbsList");
                }
                ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).pZX = "143";
                localObject1 = paramActivity.KET;
                if (localObject1 == null) {
                  d.g.b.k.aPZ("statyTimeStaticLbsList");
                }
                ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).KHW = com.tencent.mm.plugin.expt.hellhound.core.b.fRm();
                localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.KHO;
                paramActivity = paramActivity.KET;
                if (paramActivity == null) {
                  d.g.b.k.aPZ("statyTimeStaticLbsList");
                }
                a.a.a(paramActivity);
                ad.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderLbsStreamListUIPause...");
              }
            }
            AppMethodBeat.o(205214);
            return;
          }
        }
        AppMethodBeat.o(205214);
        return;
      }
    }
  }
  
  public static final void f(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(205215);
    Object localObject1;
    Object localObject2;
    if (com.tencent.mm.plugin.expt.hellhound.a.b.d.f.KIv.fRM() == null)
    {
      if (paramActivity == null) {
        break label192;
      }
      localObject1 = paramActivity.getClass();
      if (localObject1 == null) {
        break label192;
      }
      localObject1 = ((Class)localObject1).getName();
      localObject2 = c.KGM;
      if (d.a.j.a((Iterable)c.fRH(), localObject1))
      {
        localObject2 = new ebj();
        ((ebj)localObject2).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.ccM().cbk();
        ((ebj)localObject2).DDP = com.tencent.mm.plugin.expt.hellhound.core.b.Vy((String)localObject1);
        if (paramActivity == null) {
          break label198;
        }
      }
    }
    label192:
    label198:
    for (int i = paramActivity.hashCode();; i = 0)
    {
      ((ebj)localObject2).aFj = i;
      ((ebj)localObject2).KHU = paramLong;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.pHq;
      ((ebj)localObject2).pZX = b.a.ccR();
      ((ebj)localObject2).dvJ = c.b.KGP.value;
      com.tencent.mm.plugin.expt.hellhound.a.b.d.f.KIv.a((ebj)localObject2);
      ad.i("HABBYGE-MALI.FinderShareStatistics", "onStartActivity: " + ((ebj)localObject2).DDP + ", " + ((ebj)localObject2).aFj);
      com.tencent.mm.plugin.expt.hellhound.a.b.d.d.h(paramActivity, paramLong);
      AppMethodBeat.o(205215);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public static final Fragment fRo()
  {
    AppMethodBeat.i(205211);
    b localb = KHn;
    Object localObject1 = localb.KGm;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).KEQ;
      if (localObject1 != null)
      {
        localObject1 = (Fragment)((WeakReference)localObject1).get();
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject1 = localb.KGn;
          if (localObject1 == null) {
            break label87;
          }
        }
      }
    }
    label87:
    for (localObject1 = (UIComponentActivity)((WeakReference)localObject1).get();; localObject1 = null)
    {
      localObject2 = (Fragment)localb.n(localObject1, -1);
      AppMethodBeat.o(205211);
      return localObject2;
      localObject1 = null;
      break;
      localObject1 = null;
      break;
    }
  }
  
  public static final void g(Activity paramActivity, long paramLong)
  {
    c.a locala = null;
    AppMethodBeat.i(205216);
    ebj localebj = com.tencent.mm.plugin.expt.hellhound.a.b.d.f.KIv.fRM();
    Object localObject1;
    Object localObject2;
    int j;
    if (localebj != null)
    {
      if (paramActivity == null) {
        break label469;
      }
      localObject1 = paramActivity.getClass();
      if (localObject1 == null) {
        break label469;
      }
      localObject1 = ((Class)localObject1).getName();
      localObject2 = c.KGM;
      if (d.a.j.a((Iterable)c.fRH(), localObject1))
      {
        localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy((String)localObject1);
        if (d.g.b.k.g(localebj.DDP, localObject1))
        {
          j = localebj.aFj;
          if (paramActivity == null) {
            break label475;
          }
          i = paramActivity.hashCode();
          label99:
          if (j == i)
          {
            localebj.KHV = paramLong;
            long l1 = localebj.KHV;
            long l2 = localebj.KHU;
            localObject2 = localebj.LAi;
            d.g.b.k.g(localObject2, "statistics.stayTimeOnBackground");
            l2 = l1 - l2 - com.tencent.mm.plugin.expt.hellhound.a.b.d.d.ac((LinkedList)localObject2);
            l1 = l2;
            if (l2 < 0L) {
              l1 = 0L;
            }
            localebj.xBr = l1;
            localebj.KHW = com.tencent.mm.plugin.expt.hellhound.core.b.fRm();
            localebj.dvJ = c.b.KGP.value;
            localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.KHO;
            a.a.a(com.tencent.mm.plugin.expt.hellhound.a.b.d.d.a(localebj, c.b.KGP.value));
            com.tencent.mm.plugin.expt.hellhound.a.b.d.f.KIv.reset();
            ad.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivity: " + (String)localObject1 + ", " + localebj.aFj);
          }
        }
      }
    }
    localebj = com.tencent.mm.plugin.expt.hellhound.a.b.d.f.KIv.fRN();
    if (localebj != null)
    {
      localObject1 = locala;
      if (paramActivity != null)
      {
        localObject2 = paramActivity.getClass();
        localObject1 = locala;
        if (localObject2 != null) {
          localObject1 = ((Class)localObject2).getName();
        }
      }
      locala = c.KGM;
      if (d.a.j.a((Iterable)c.fRH(), localObject1))
      {
        localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy((String)localObject1);
        if (d.g.b.k.g(localebj.DDP, localObject1))
        {
          j = localebj.aFj;
          if (paramActivity == null) {
            break label480;
          }
        }
      }
    }
    label469:
    label475:
    label480:
    for (int i = paramActivity.hashCode();; i = 0)
    {
      if (j == i)
      {
        localebj.KHV = paramLong;
        localebj.xBr = (localebj.KHV - localebj.KHU);
        localebj.KHW = com.tencent.mm.plugin.expt.hellhound.core.b.fRm();
        localebj.dvJ = c.b.KGO.value;
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.KHO;
        a.a.a(com.tencent.mm.plugin.expt.hellhound.a.b.d.d.a(localebj, c.b.KGO.value));
        com.tencent.mm.plugin.expt.hellhound.a.b.d.f.KIv.fRO();
        ad.i("HABBYGE-MALI.FinderShareStatistics", "doOnFinishActivityV2: " + (String)localObject1 + ", " + localebj.aFj);
      }
      AppMethodBeat.o(205216);
      return;
      localObject1 = null;
      break;
      i = 0;
      break label99;
    }
  }
  
  public final void a(e parame)
  {
    try
    {
      AppMethodBeat.i(205204);
      d.g.b.k.h(parame, "listener");
      if (!mListeners.contains(parame)) {
        mListeners.add(parame);
      }
      AppMethodBeat.o(205204);
      return;
    }
    finally {}
  }
  
  public final void a(l.a parama)
  {
    try
    {
      AppMethodBeat.i(205229);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).a(parama);
      }
      AppMethodBeat.o(205229);
    }
    finally {}
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    try
    {
      AppMethodBeat.i(205226);
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).b(paramRecyclerView, paramInt);
      }
      AppMethodBeat.o(205226);
    }
    finally {}
  }
  
  public final void b(e parame)
  {
    try
    {
      AppMethodBeat.i(205205);
      d.g.b.k.h(parame, "listener");
      mListeners.remove(parame);
      AppMethodBeat.o(205205);
      return;
    }
    finally
    {
      parame = finally;
      throw parame;
    }
  }
  
  public final void bMu()
  {
    try
    {
      AppMethodBeat.i(205230);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(205230);
    }
    finally {}
  }
  
  public final void f(RecyclerView paramRecyclerView, int paramInt)
  {
    try
    {
      AppMethodBeat.i(205227);
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).f(paramRecyclerView, paramInt);
      }
      AppMethodBeat.o(205227);
    }
    finally {}
  }
  
  public final void fRs()
  {
    try
    {
      AppMethodBeat.i(205228);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).fRs();
      }
      AppMethodBeat.o(205228);
    }
    finally {}
  }
  
  public final void fRt()
  {
    try
    {
      AppMethodBeat.i(205231);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).fRt();
      }
      AppMethodBeat.o(205231);
    }
    finally {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerCallback$RecycylerScrollListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "()V", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  static final class a
    implements com.tencent.mm.hellhoundlib.a.c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(205202);
      if ((d.g.b.k.g("onScrollStateChanged", paramString2)) && (d.g.b.k.g("(Landroid/support/v7/widget/RecyclerView;I)V", paramString3)))
      {
        if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
        {
          paramString2 = paramArrayOfObject[0];
          if ((paramString2 instanceof RecyclerView))
          {
            paramString1 = j.KHt;
            paramString2 = (RecyclerView)paramString2;
            paramString3 = paramArrayOfObject[1];
            if (paramString3 == null)
            {
              paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(205202);
              throw paramString1;
            }
            paramString1.b(paramString2, ((Integer)paramString3).intValue());
          }
        }
        AppMethodBeat.o(205202);
        return;
      }
      if ((d.g.b.k.g("onScrolled", paramString2)) && (d.g.b.k.g("(Landroid/support/v7/widget/RecyclerView;II)V", paramString3)) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 3))
      {
        paramString2 = paramArrayOfObject[0];
        if ((paramString2 instanceof RecyclerView))
        {
          paramString1 = j.KHt;
          paramString2 = (RecyclerView)paramString2;
          paramString3 = paramArrayOfObject[1];
          if (paramString3 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(205202);
            throw paramString1;
          }
          ((Integer)paramString3).intValue();
          paramString3 = paramArrayOfObject[2];
          if (paramString3 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(205202);
            throw paramString1;
          }
          paramString1.f(paramString2, ((Integer)paramString3).intValue());
        }
      }
      AppMethodBeat.o(205202);
    }
    
    public final void g(String paramString, Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.j
 * JD-Core Version:    0.7.0.1
 */