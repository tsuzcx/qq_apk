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
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.component.UIComponentActivity;
import d.g.b.p;
import d.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerCallback;", "", "()V", "DESC_onScrollStateChanged", "", "DESC_onScrolled", "NAME_onScrollStateChanged", "NAME_onScrolled", "SUPER_NAME", "TAG", "mClickCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback;", "mFinderFragmentCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback;", "mFragmentFeedStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FragmentFeedStatistics;", "mItemDecorationCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback;", "mListener", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "mListeners", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IRecyclerMonitorListener;", "mMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "Lkotlin/collections/HashMap;", "mRefreshLoadMoreCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "mShareStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderShareStatistics;", "mWaterfallsFlowMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor;", "fragmentFeedFlowOnFree", "", "activityName", "getCurFragmentOfFinderHomeUI", "Landroid/support/v4/app/Fragment;", "activity", "Landroid/app/Activity;", "monitor", "on7Event", "pageName", "hashCode", "", "timestamp", "", "on8Event", "onActivityCreate", "onFinderHomeUIPaused", "onFinderHomeUIResumed", "onFinishActivity", "onLoadMoreBegin", "onLoadMoreEnd", "className", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "onRefreshBegin", "onRefreshEnd", "onScrollStateChanged", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "registerClickListener", "listener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "registerFinderFragmentListener", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "registerListener", "startFinderFragmentMonitor", "startFragmentFeedFlowMonitor", "Landroid/support/v4/app/FragmentActivity;", "fragment", "fragmentEventId", "startItemDecorationMonitor", "startMonitorClick", "startWaterfallsFlowMonitor", "eventId", "stopFinderFragmentMonitor", "stopFragmentFeedFlowMonitor", "stopItemDecorationMonitor", "stopMonitorClick", "stopWaterfallsFlowMonitor", "unregisterClickListener", "unregisterFinderFragmentListener", "unregisterListener", "RecycylerScrollListener", "plugin-expt_release"})
public final class j
{
  private static final List<e> mListeners;
  private static com.tencent.mm.hellhoundlib.a.c qRO;
  private static final HashMap<String, List<Pair<String, String>>> qVC;
  private static final l qWA;
  private static final com.tencent.mm.plugin.expt.hellhound.a.b.c qWB;
  private static final com.tencent.mm.plugin.expt.hellhound.a.a.b qWC;
  private static final com.tencent.mm.plugin.expt.hellhound.a.b.d.d qWD;
  private static final a qWE;
  public static final j qWF;
  private static final k qWy;
  private static final b qWz;
  
  static
  {
    AppMethodBeat.i(210837);
    qWF = new j();
    qVC = new HashMap();
    mListeners = (List)new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V"));
    localArrayList.add(Pair.create("onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V"));
    ((Map)qVC).put("android/support/v7/widget/RecyclerView$OnScrollListener", localArrayList);
    qRO = (com.tencent.mm.hellhoundlib.a.c)new a();
    qWy = new k();
    qWz = new b();
    qWA = new l();
    qWB = new com.tencent.mm.plugin.expt.hellhound.a.b.c();
    qWC = new com.tencent.mm.plugin.expt.hellhound.a.a.b();
    qWD = new com.tencent.mm.plugin.expt.hellhound.a.b.d.d();
    qWE = new a();
    AppMethodBeat.o(210837);
  }
  
  public static final void a(Activity paramActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(210824);
    com.tencent.mm.plugin.expt.hellhound.a.b.c localc = qWB;
    Object localObject;
    if (paramFragment == null) {
      if (paramActivity != null)
      {
        localObject = paramActivity.getClass();
        if (localObject != null)
        {
          localObject = ((Class)localObject).getName();
          c.a locala = c.qVY;
          if (!c.cpa().contains(localObject)) {
            break label379;
          }
          ad.i("HABBYGE-MALI.WaterfallsFlowMonitor", "monitor: poageName=".concat(String.valueOf(localObject)));
          localc.qUd = ((String)localObject);
          qWF.a((e)localc.qUf);
          localc.qUe = new com.tencent.mm.plugin.expt.hellhound.a.b.d.j(paramActivity, paramFragment);
          localObject = localc.qUe;
          if (localObject == null) {
            break label379;
          }
          if (paramFragment != null) {
            break label282;
          }
          if (paramActivity == null) {
            break label246;
          }
          paramFragment = paramActivity.getClass();
          if (paramFragment == null) {
            break label246;
          }
          paramFragment = paramFragment.getName();
          label136:
          ad.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute: pageName=".concat(String.valueOf(paramFragment)));
          if (!p.i(paramFragment, c.qVQ)) {
            break label263;
          }
          if (!p.i(paramFragment, c.qVS)) {
            break label251;
          }
          ad.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: 7Event !!");
          ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).a(paramActivity, paramLong);
          label188:
          c.qVR = null;
          c.qVQ = null;
        }
      }
    }
    for (;;)
    {
      paramActivity = (d)((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).qYg.qXz;
      p.h(paramActivity, "listener");
      qWE.a(paramActivity);
      AppMethodBeat.o(210824);
      return;
      localObject = null;
      break;
      localObject = paramFragment.getClass().getName();
      break;
      label246:
      paramFragment = null;
      break label136;
      label251:
      ad.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: startActivity !!");
      break label188;
      label263:
      ad.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: Back to activity !!");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).a(paramActivity, paramLong);
      break label188;
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
        label282:
        ad.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, 7Event !!");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).a(paramFragment, paramLong);
      }
    }
    label379:
    AppMethodBeat.o(210824);
  }
  
  public static void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(210829);
    p.h(paramFragmentActivity, "activity");
    p.h(paramFragment, "fragment");
    com.tencent.mm.plugin.expt.hellhound.a.a.b localb = qWC;
    p.h(paramFragmentActivity, "activity");
    p.h(paramFragment, "fragment");
    paramFragment = paramFragment.getClass().getName();
    ad.d("HABBYGE-MALI.FragmentFeedStatistics", "start: fragment:" + paramFragment + ", event=" + paramInt);
    if (paramFragment == null)
    {
      AppMethodBeat.o(210829);
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
            AppMethodBeat.o(210829);
            return;
          } while (!paramFragment.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment"));
          if (localb.qTt == null) {
            localb.qTt = ((o)new com.tencent.mm.plugin.expt.hellhound.a.b.a.f((Activity)paramFragmentActivity));
          }
          paramFragmentActivity = localb.qTt;
          if (paramFragmentActivity == null) {
            break;
          }
          paramFragmentActivity.coL();
          AppMethodBeat.o(210829);
          return;
        } while (!paramFragment.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment"));
        if (localb.qTv == null) {
          localb.qTv = ((o)new com.tencent.mm.plugin.expt.hellhound.a.b.a.j((Activity)paramFragmentActivity));
        }
        paramFragmentActivity = localb.qTv;
      } while (paramFragmentActivity == null);
      paramFragmentActivity.coL();
      AppMethodBeat.o(210829);
      return;
    } while (!paramFragment.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment"));
    if (localb.qTu == null) {
      localb.qTu = ((o)new com.tencent.mm.plugin.expt.hellhound.a.b.a.g((Activity)paramFragmentActivity));
    }
    paramFragmentActivity = localb.qTu;
    if (paramFragmentActivity != null)
    {
      paramFragmentActivity.coL();
      AppMethodBeat.o(210829);
      return;
      AppMethodBeat.o(210829);
      return;
    }
    AppMethodBeat.o(210829);
  }
  
  public static final void a(com.tencent.mm.plugin.expt.hellhound.core.d paramd)
  {
    AppMethodBeat.i(210816);
    p.h(paramd, "listener");
    Object localObject = qWz;
    p.h(paramd, "listener");
    localObject = ((b)localObject).qVx;
    if (localObject != null)
    {
      p.h(paramd, "listener");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject).qRK = paramd;
      AppMethodBeat.o(210816);
      return;
    }
    AppMethodBeat.o(210816);
  }
  
  public static final Fragment ac(Activity paramActivity)
  {
    Object localObject2 = null;
    AppMethodBeat.i(210818);
    b localb = qWz;
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
      AppMethodBeat.o(210818);
      return paramActivity;
      label53:
      if ((p.i(paramActivity, "com.tencent.mm.plugin.finder.ui.FinderHomeUI") ^ true))
      {
        localObject1 = localObject2;
        if ((p.i(paramActivity, "com.tencent.mm.plugin.finder.ui.FinderConversationUI") ^ true)) {}
      }
      else
      {
        localObject1 = localb.j(null, -1);
      }
    }
  }
  
  public static final void aei(String paramString)
  {
    AppMethodBeat.i(210812);
    k localk = qWy;
    if (!k.aep(paramString))
    {
      ad.i("HABBYGE-MALI.RecyclerItemDecorationCallback", "monitor");
      paramString = localk.qTE;
      if (paramString != null) {
        paramString.clear();
      }
      com.tencent.mm.hellhoundlib.a.aho();
      com.tencent.mm.hellhoundlib.a.c((Map)localk.qVC, (com.tencent.mm.hellhoundlib.a.c)localk.qWG);
    }
    AppMethodBeat.o(210812);
  }
  
  public static final void aej(String paramString)
  {
    AppMethodBeat.i(210813);
    k localk = qWy;
    if (!k.aep(paramString))
    {
      ad.i("HABBYGE-MALI.RecyclerItemDecorationCallback", "unmonitor");
      paramString = localk.qTE;
      if (paramString != null)
      {
        paramString = (RecyclerView)paramString.get();
        if (paramString != null) {
          paramString.b((RecyclerView.m)localk.qWH);
        }
      }
      paramString = localk.qTE;
      if (paramString != null) {
        paramString.clear();
      }
      localk.qTE = null;
      com.tencent.mm.hellhoundlib.a.aho();
      com.tencent.mm.hellhoundlib.a.d((Map)localk.qVC, (com.tencent.mm.hellhoundlib.a.c)localk.qWG);
    }
    AppMethodBeat.o(210813);
  }
  
  public static final void aek(String paramString)
  {
    AppMethodBeat.i(210814);
    b localb = qWz;
    localb.qVt = paramString;
    if ((!(p.i("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString) ^ true)) || (!(p.i("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString) ^ true)))
    {
      ad.i("HABBYGE-MALI.FinderFragmentCallback", "monitor...");
      localb.afo = -1;
      localb.qVv = true;
      localb.qVw = false;
      com.tencent.mm.hellhoundlib.a.aho();
      com.tencent.mm.hellhoundlib.a.c((Map)localb.qVC, (com.tencent.mm.hellhoundlib.a.c)localb.qVD);
    }
    AppMethodBeat.o(210814);
  }
  
  public static final void ael(String paramString)
  {
    AppMethodBeat.i(210815);
    b localb = qWz;
    localb.qVu = paramString;
    if ((!(p.i("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString) ^ true)) || (!(p.i("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString) ^ true)))
    {
      ad.i("HABBYGE-MALI.FinderFragmentCallback", "unmonitor...");
      localb.qVv = false;
      localb.qVw = true;
      com.tencent.mm.hellhoundlib.a.aho();
      com.tencent.mm.hellhoundlib.a.d((Map)localb.qVC, (com.tencent.mm.hellhoundlib.a.c)localb.qVD);
    }
    AppMethodBeat.o(210815);
  }
  
  public static final void aem(String paramString)
  {
    AppMethodBeat.i(210826);
    if ((p.i("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (p.i("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)))
    {
      paramString = qWC;
      ad.i("HABBYGE-MALI.FragmentFeedStatistics", "stop: free...");
      o localo = paramString.qTt;
      if (localo != null) {
        localo.free();
      }
      paramString.qTt = null;
      localo = paramString.qTu;
      if (localo != null) {
        localo.free();
      }
      paramString.qTu = null;
      localo = paramString.qTv;
      if (localo != null) {
        localo.free();
      }
      paramString.qTv = null;
    }
    AppMethodBeat.o(210826);
  }
  
  public static final void aen(String paramString)
  {
    AppMethodBeat.i(210827);
    if ((p.i("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (p.i("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)))
    {
      qWE.cnf();
      AppMethodBeat.o(210827);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qYW;
    localObject = b.a.cpG();
    if (((p.i(localObject, "999")) || (p.i(localObject, "101")) || (p.i(localObject, "102")) || (p.i(localObject, "123"))) && ((p.i("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", paramString)) || (p.i("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", paramString)) || (p.i("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", paramString)))) {
      qWE.cnf();
    }
    AppMethodBeat.o(210827);
  }
  
  public static final void aeo(String paramString)
  {
    AppMethodBeat.i(210828);
    if ((p.i("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (p.i("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)))
    {
      qWE.coM();
      AppMethodBeat.o(210828);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qYW;
    localObject = b.a.cpG();
    if (((p.i(localObject, "999")) || (p.i(localObject, "101")) || (p.i(localObject, "102")) || (p.i(localObject, "123"))) && ((p.i("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", paramString)) || (p.i("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", paramString)) || (p.i("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", paramString)))) {
      qWE.coM();
    }
    AppMethodBeat.o(210828);
  }
  
  public static final void b(Activity paramActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(210825);
    com.tencent.mm.plugin.expt.hellhound.a.b.c localc = qWB;
    Object localObject;
    if (paramFragment == null) {
      if (paramActivity != null)
      {
        localObject = paramActivity.getClass();
        if (localObject != null)
        {
          localObject = ((Class)localObject).getName();
          c.a locala = c.qVY;
          if (c.cpa().contains(localObject))
          {
            ad.i("HABBYGE-MALI.WaterfallsFlowMonitor", "unmonitor: poageName=".concat(String.valueOf(localObject)));
            qWF.b((e)localc.qUf);
            localObject = localc.qUe;
            if (localObject != null)
            {
              if (paramFragment != null) {
                break label302;
              }
              if (paramActivity == null) {
                break label237;
              }
              paramFragment = paramActivity.getClass();
              if (paramFragment == null) {
                break label237;
              }
              paramFragment = paramFragment.getName();
              label117:
              ad.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: pageName=".concat(String.valueOf(paramFragment)));
              if (!p.i(paramFragment, c.qVR)) {
                break label242;
              }
              ad.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: finish cur page !");
              ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).qYa = 1;
              paramInt = 1;
              label161:
              ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).b(paramActivity, paramLong);
              if (paramInt != 0)
              {
                paramActivity = c.qVY;
                c.a.cpc();
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      paramActivity = (d)((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).qYg.qXz;
      p.h(paramActivity, "listener");
      qWE.b(paramActivity);
      localc.qUe = null;
      AppMethodBeat.o(210825);
      return;
      localObject = null;
      break;
      localObject = paramFragment.getClass().getName();
      break;
      label237:
      paramFragment = null;
      break label117;
      label242:
      if (((p.i(paramFragment, c.qVQ) ^ true)) && (c.qVQ != null))
      {
        ad.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: startActivity another page !");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).qYa = 1;
        paramInt = 0;
        break label161;
      }
      ad.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: 8Event !");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).qYa = 2;
      paramInt = 0;
      break label161;
      switch (paramInt)
      {
      case 2: 
      default: 
        ad.printErrStackTrace("HABBYGE-MALI.WaterfallsFlowStatistics", (Throwable)new NullPointerException("startCompute, fragment, miss !!"), "", new Object[0]);
        break;
      case 1: 
        ad.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, pause !!");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).qYa = 1;
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).b(paramFragment, paramLong);
        break;
      case 3: 
        label302:
        ad.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, 8Event !!");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).qYa = 2;
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).b(paramFragment, paramLong);
      }
    }
  }
  
  public static void b(FragmentActivity paramFragmentActivity, Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(210830);
    p.h(paramFragmentActivity, "activity");
    p.h(paramFragment, "fragment");
    com.tencent.mm.plugin.expt.hellhound.a.a.b localb = qWC;
    p.h(paramFragmentActivity, "activity");
    p.h(paramFragment, "fragment");
    paramFragmentActivity = paramFragment.getClass().getName();
    ad.d("HABBYGE-MALI.FragmentFeedStatistics", "stop: fragment:" + paramFragmentActivity + ", event=" + paramInt);
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(210830);
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
            AppMethodBeat.o(210830);
            return;
          } while (!paramFragmentActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment"));
          paramFragmentActivity = localb.qTt;
          if (paramFragmentActivity == null) {
            break;
          }
          paramFragmentActivity.coC();
          AppMethodBeat.o(210830);
          return;
        } while (!paramFragmentActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment"));
        paramFragmentActivity = localb.qTv;
      } while (paramFragmentActivity == null);
      paramFragmentActivity.coC();
      AppMethodBeat.o(210830);
      return;
    } while (!paramFragmentActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment"));
    paramFragmentActivity = localb.qTu;
    if (paramFragmentActivity != null)
    {
      paramFragmentActivity.coC();
      AppMethodBeat.o(210830);
      return;
      AppMethodBeat.o(210830);
      return;
    }
    AppMethodBeat.o(210830);
  }
  
  public static void cnf()
  {
    AppMethodBeat.i(210809);
    ad.i("HABBYGE-MALI.RecyclerCallback", "monitor...");
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a((Map)qVC, qRO);
    Object localObject1 = qWA;
    ad.i("HABBYGE-MALI.RefreshLoadMoreCallback", "startMonitor...");
    Object localObject2 = new h();
    ad.i("HABBYGE-MALI.RLBeginCallback", "startMonitor...");
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a((Map)((h)localObject2).qVC, (com.tencent.mm.hellhoundlib.a.c)((h)localObject2).qWs);
    localObject2 = new i((l)localObject1);
    ad.i("HABBYGE-MALI.RLEndCallback", "startMonitor...");
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a((Map)((i)localObject2).qVC, (com.tencent.mm.hellhoundlib.a.c)((i)localObject2).qWu);
    localObject1 = new m((l)localObject1);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a((Map)((m)localObject1).qVC, (com.tencent.mm.hellhoundlib.a.c)((m)localObject1).qWW);
    new g();
    com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qXM.reset();
    com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qXM.cpi();
    AppMethodBeat.o(210809);
  }
  
  public static final Fragment cop()
  {
    AppMethodBeat.i(210817);
    b localb = qWz;
    Object localObject1 = localb.qVx;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).qTY;
      if (localObject1 != null)
      {
        localObject1 = (Fragment)((WeakReference)localObject1).get();
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject1 = localb.qVy;
          if (localObject1 == null) {
            break label87;
          }
        }
      }
    }
    label87:
    for (localObject1 = (UIComponentActivity)((WeakReference)localObject1).get();; localObject1 = null)
    {
      localObject2 = (Fragment)localb.j(localObject1, -1);
      AppMethodBeat.o(210817);
      return localObject2;
      localObject1 = null;
      break;
      localObject1 = null;
      break;
    }
  }
  
  public static final void cpe() {}
  
  public static final void d(Activity paramActivity, long paramLong)
  {
    boolean bool = false;
    AppMethodBeat.i(210819);
    Object localObject1;
    Object localObject3;
    if (paramActivity != null)
    {
      localObject1 = paramActivity.getClass();
      if (localObject1 != null)
      {
        localObject1 = ((Class)localObject1).getName();
        if (localObject1 != null) {
          break label125;
        }
        localObject1 = qWD;
        if (paramActivity != null)
        {
          localObject2 = paramActivity.getClass().getName();
          localObject3 = c.qVY;
          if ((c.coZ().contains(localObject2)) && (((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXF == null))
          {
            localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.adx((String)localObject2);
            if (localObject2 != null) {
              break label501;
            }
          }
        }
      }
    }
    label501:
    for (;;)
    {
      if (paramActivity != null)
      {
        paramActivity = paramActivity.getClass();
        if (paramActivity != null)
        {
          paramActivity = paramActivity.getName();
          if (paramActivity != null) {
            break label682;
          }
        }
      }
      AppMethodBeat.o(210819);
      return;
      localObject1 = null;
      break;
      label125:
      switch (((String)localObject1).hashCode())
      {
      default: 
        break;
      case -2055689330: 
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderHomeUI")) {
          break;
        }
        localObject1 = qWz;
        if (paramActivity == null)
        {
          paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
          AppMethodBeat.o(210819);
          throw paramActivity;
        }
      case -936307702: 
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI")) {
          break;
        }
        localObject1 = qWz;
        if (paramActivity == null)
        {
          paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
          AppMethodBeat.o(210819);
          throw paramActivity;
        }
      case -2013384910: 
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderConversationUI")) {
          break;
        }
        localObject1 = qWz;
        if (paramActivity == null)
        {
          paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
          AppMethodBeat.o(210819);
          throw paramActivity;
        }
        ((b)localObject1).b((FragmentActivity)paramActivity, paramLong);
        AppMethodBeat.o(210819);
        return;
        ((b)localObject1).b((FragmentActivity)paramActivity, paramLong);
        AppMethodBeat.o(210819);
        return;
        p.h((FragmentActivity)paramActivity, "activity");
        paramActivity = ((b)localObject1).qVx;
        if (paramActivity != null)
        {
          paramActivity.qUb = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
          localObject1 = paramActivity.qUb;
          if (localObject1 == null) {
            p.bcb("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cpK().cnc();
          localObject1 = paramActivity.qUb;
          if (localObject1 == null) {
            p.bcb("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).dtL = com.tencent.mm.plugin.expt.hellhound.core.b.adx("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI");
          localObject1 = paramActivity.qUb;
          if (localObject1 == null) {
            p.bcb("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).qXh = paramLong;
          localObject1 = paramActivity.qUb;
          if (localObject1 == null) {
            p.bcb("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).qXk = "143";
          paramActivity = paramActivity.qUb;
          if (paramActivity == null) {
            p.bcb("statyTimeStaticLbsList");
          }
          paramActivity.dFx = c.b.qVZ.value;
          ad.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderLbsStreamListUIResume...");
          AppMethodBeat.o(210819);
          return;
        }
        AppMethodBeat.o(210819);
        return;
        p.g(localObject2, "HellhoundUtil.getShortNa…fPage(pageName) ?: return");
        int i = paramActivity.hashCode();
        com.tencent.mm.plugin.expt.hellhound.a.b.d.d.p((String)localObject2, i, paramLong);
        ad.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV2, sPage=" + (String)localObject2 + ", hashCode=" + i);
        if (com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qXM.dc((String)localObject2, i) == null)
        {
          localObject3 = new chl();
          ((chl)localObject3).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cpK().cnc();
          ((chl)localObject3).dtL = ((String)localObject2);
          ((chl)localObject3).aHQ = i;
          ((chl)localObject3).qXh = paramLong;
          b.a locala = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qYW;
          ((chl)localObject3).qXk = b.a.cpG();
          ((chl)localObject3).dFx = c.b.qWa.value;
          com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qXM.c((chl)localObject3);
          ad.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV2, YES, sPage=" + (String)localObject2 + ", hashCode=" + i);
          ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXF = ((String)localObject2);
        }
        break;
      }
    }
    label682:
    Object localObject2 = c.qVY;
    if ((c.coY().contains(paramActivity)) && ((((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXE == null) || (!(p.i(paramActivity, ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXE) ^ true))))
    {
      ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXE = paramActivity;
      ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXD = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXD;
      if (localObject2 == null) {
        p.bcb("mStayTime");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cpK().cnc();
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXD;
      if (localObject2 == null) {
        p.bcb("mStayTime");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).dtL = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramActivity);
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXD;
      if (localObject2 == null) {
        p.bcb("mStayTime");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).qXh = paramLong;
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXD;
      if (localObject2 == null) {
        p.bcb("mStayTime");
      }
      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qYW;
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).qXk = b.a.cpG();
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXD;
      if (localObject2 == null) {
        p.bcb("mStayTime");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).dFx = c.b.qVZ.value;
      if (!p.i(paramActivity, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
        break label983;
      }
      paramActivity = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXD;
      if (paramActivity == null) {
        p.bcb("mStayTime");
      }
      localObject2 = c.qVY;
      if (c.cpb() == c.c.qWe.value) {
        bool = true;
      }
    }
    for (paramActivity.qXl = bool;; paramActivity.qXl = false)
    {
      paramActivity = new StringBuilder("doPageResume: ");
      localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXD;
      if (localObject1 == null) {
        p.bcb("mStayTime");
      }
      ad.i("HABBYGE-MALI.FinderShareStatistics", ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).dtL);
      AppMethodBeat.o(210819);
      return;
      label983:
      paramActivity = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXD;
      if (paramActivity == null) {
        p.bcb("mStayTime");
      }
    }
  }
  
  public static final void e(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(210820);
    if (paramActivity != null)
    {
      localObject1 = paramActivity.getClass();
      if (localObject1 != null)
      {
        localObject1 = ((Class)localObject1).getName();
        if (localObject1 != null) {
          break label73;
        }
      }
    }
    label73:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            localObject1 = qWD;
            if (paramActivity != null)
            {
              paramActivity = paramActivity.getClass();
              if (paramActivity != null)
              {
                paramActivity = paramActivity.getName();
                if (paramActivity != null) {
                  break label538;
                }
              }
            }
            AppMethodBeat.o(210820);
            return;
            localObject1 = null;
            break;
            switch (((String)localObject1).hashCode())
            {
            }
          }
        } while (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderHomeUI"));
        localObject1 = qWz;
        if (paramActivity != null) {
          break label249;
        }
        paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
        AppMethodBeat.o(210820);
        throw paramActivity;
      } while (!((String)localObject1).equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
      localObject1 = qWz;
      if (paramActivity != null) {
        break label266;
      }
      paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
      AppMethodBeat.o(210820);
      throw paramActivity;
    } while (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderConversationUI"));
    Object localObject1 = qWz;
    if (paramActivity == null)
    {
      paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
      AppMethodBeat.o(210820);
      throw paramActivity;
    }
    ((b)localObject1).c((FragmentActivity)paramActivity, paramLong);
    AppMethodBeat.o(210820);
    return;
    label249:
    ((b)localObject1).c((FragmentActivity)paramActivity, paramLong);
    AppMethodBeat.o(210820);
    return;
    label266:
    p.h((FragmentActivity)paramActivity, "activity");
    paramActivity = ((b)localObject1).qVx;
    if (paramActivity != null)
    {
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.adx("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI");
      if (((com.tencent.mm.plugin.expt.hellhound.a.b.b)paramActivity).qUb != null) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          localObject2 = paramActivity.qUb;
          if (localObject2 == null) {
            p.bcb("statyTimeStaticLbsList");
          }
          if (p.i(((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).dtL, localObject1))
          {
            localObject1 = paramActivity.qUb;
            if (localObject1 == null) {
              p.bcb("statyTimeStaticLbsList");
            }
            ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).qXi = paramLong;
            localObject1 = paramActivity.qUb;
            if (localObject1 == null) {
              p.bcb("statyTimeStaticLbsList");
            }
            paramLong = ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).qXi;
            localObject1 = paramActivity.qUb;
            if (localObject1 == null) {
              p.bcb("statyTimeStaticLbsList");
            }
            long l = ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).qXh;
            localObject1 = paramActivity.qUb;
            if (localObject1 == null) {
              p.bcb("statyTimeStaticLbsList");
            }
            ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).qXg = (paramLong - l);
            localObject1 = paramActivity.qUb;
            if (localObject1 == null) {
              p.bcb("statyTimeStaticLbsList");
            }
            ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).qXk = "143";
            localObject1 = paramActivity.qUb;
            if (localObject1 == null) {
              p.bcb("statyTimeStaticLbsList");
            }
            ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).qXj = com.tencent.mm.plugin.expt.hellhound.core.b.cnG();
            localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.qXa;
            paramActivity = paramActivity.qUb;
            if (paramActivity == null) {
              p.bcb("statyTimeStaticLbsList");
            }
            a.a.a(paramActivity);
            ad.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderLbsStreamListUIPause...");
          }
        }
        AppMethodBeat.o(210820);
        return;
      }
    }
    AppMethodBeat.o(210820);
    return;
    label538:
    Object localObject2 = c.qVY;
    if (c.coY().contains(paramActivity))
    {
      if (((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXE == null)
      {
        AppMethodBeat.o(210820);
        return;
      }
      if (!(p.i(paramActivity, ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXE) ^ true))
      {
        if (((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXF == null) {
          ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXE = null;
        }
        paramActivity = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramActivity);
        localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXD;
        if (localObject2 == null) {
          p.bcb("mStayTime");
        }
        if (p.i(((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).dtL, paramActivity))
        {
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXD;
          if (localObject2 == null) {
            p.bcb("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).qXi = paramLong;
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXD;
          if (localObject2 == null) {
            p.bcb("mStayTime");
          }
          com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXD;
          if (localb == null) {
            p.bcb("mStayTime");
          }
          paramLong = localb.qXi;
          localb = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXD;
          if (localb == null) {
            p.bcb("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).qXg = (paramLong - localb.qXh);
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXD;
          if (localObject2 == null) {
            p.bcb("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).qXj = com.tencent.mm.plugin.expt.hellhound.core.b.cnG();
          localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.qXa;
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qXD;
          if (localObject1 == null) {
            p.bcb("mStayTime");
          }
          a.a.a((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1);
          ad.i("HABBYGE-MALI.FinderShareStatistics", "onPagePaused: ".concat(String.valueOf(paramActivity)));
        }
      }
    }
    AppMethodBeat.o(210820);
  }
  
  public static final void f(Activity paramActivity, long paramLong)
  {
    long l1 = 0L;
    AppMethodBeat.i(210821);
    Object localObject = qWD;
    if (paramActivity == null)
    {
      AppMethodBeat.o(210821);
      return;
    }
    String str = paramActivity.getClass().getName();
    c.a locala = c.qVY;
    if (c.coZ().contains(str))
    {
      str = com.tencent.mm.plugin.expt.hellhound.core.b.adx(str);
      if (str == null)
      {
        AppMethodBeat.o(210821);
        return;
      }
      p.g(str, "HellhoundUtil.getShortNa…fPage(pageName) ?: return");
      int i = paramActivity.hashCode();
      ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject).qXF = null;
      ad.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV1: sPage=" + str + ", hashCode=" + i);
      paramActivity = com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qXM.da(str, i);
      if (paramActivity == null)
      {
        ad.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV2: sPage=" + str + ", hashCode=" + i);
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qXM.dc(str, i);
        if (paramActivity == null) {
          AppMethodBeat.o(210821);
        }
      }
      else
      {
        ad.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV1: compare, " + paramActivity.dtL + " == " + str + ", " + paramActivity.aHQ + " == " + i);
        paramActivity.qXi = paramLong;
        long l2 = paramActivity.qXi;
        long l3 = paramActivity.qXh;
        localObject = paramActivity.HaX;
        p.g(localObject, "statistics.stayTimeOnBackground");
        l2 = l2 - l3 - com.tencent.mm.plugin.expt.hellhound.a.b.d.d.aa((LinkedList)localObject);
        if (l2 < 0L) {}
        for (;;)
        {
          paramActivity.qXg = l1;
          paramActivity.qXj = com.tencent.mm.plugin.expt.hellhound.core.b.cnG();
          paramActivity.dFx = c.b.qWb.value;
          localObject = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.qXa;
          a.a.a(com.tencent.mm.plugin.expt.hellhound.a.b.d.d.a(paramActivity, c.b.qWb.value));
          com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qXM.db(str, i);
          ad.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV1: report, " + str + ", " + i);
          break;
          l1 = l2;
        }
      }
      ad.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV2: compare, " + paramActivity.dtL + " == " + str + ", " + paramActivity.aHQ + " == " + i);
      paramActivity.qXi = paramLong;
      paramActivity.qXg = (paramActivity.qXi - paramActivity.qXh);
      paramActivity.qXj = com.tencent.mm.plugin.expt.hellhound.core.b.cnG();
      paramActivity.dFx = c.b.qWa.value;
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.qXa;
      a.a.a(com.tencent.mm.plugin.expt.hellhound.a.b.d.d.a(paramActivity, c.b.qWa.value));
      com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qXM.dd(str, i);
      ad.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV2: report, " + str + ", " + i);
    }
    AppMethodBeat.o(210821);
  }
  
  public static final void n(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210822);
    com.tencent.mm.plugin.expt.hellhound.a.b.d.d.r(paramString, paramInt, paramLong);
    ad.i("HABBYGE-MALI.FinderShareStatistics", "on8EventV2: pageName=" + paramString + ", hashCode=" + paramInt);
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.ads(paramString))
    {
      paramString = com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qXM.cph();
      if (paramString == null)
      {
        AppMethodBeat.o(210822);
        return;
      }
      paramString.qXi = paramLong;
      paramString.qXg = (paramString.qXi - paramString.qXh);
      paramString.qXj = com.tencent.mm.plugin.expt.hellhound.core.b.cnG();
      paramString.dFx = c.b.qWa.value;
      ad.i("HABBYGE-MALI.FinderShareStatistics", "on8EventV2, statics: " + paramString.dtL + ", " + paramString.aHQ);
      a.a locala = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.qXa;
      a.a.a(com.tencent.mm.plugin.expt.hellhound.a.b.d.d.a(paramString, c.b.qWa.value));
      paramString.dFx = 8;
      com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qXM.d(paramString);
    }
    AppMethodBeat.o(210822);
  }
  
  public static final void o(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210823);
    com.tencent.mm.plugin.expt.hellhound.a.b.d.d.q(paramString, paramInt, paramLong);
    com.tencent.mm.plugin.expt.hellhound.a.b.d.d.s(paramString, paramInt, paramLong);
    AppMethodBeat.o(210823);
  }
  
  public final void a(e parame)
  {
    try
    {
      AppMethodBeat.i(210810);
      p.h(parame, "listener");
      if (!mListeners.contains(parame)) {
        mListeners.add(parame);
      }
      AppMethodBeat.o(210810);
      return;
    }
    finally {}
  }
  
  public final void a(l.a parama)
  {
    try
    {
      AppMethodBeat.i(210834);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).a(parama);
      }
      AppMethodBeat.o(210834);
    }
    finally {}
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    try
    {
      AppMethodBeat.i(210831);
      p.h(paramRecyclerView, "recyclerView");
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).b(paramRecyclerView, paramInt);
      }
      AppMethodBeat.o(210831);
    }
    finally {}
  }
  
  public final void b(e parame)
  {
    try
    {
      AppMethodBeat.i(210811);
      p.h(parame, "listener");
      mListeners.remove(parame);
      AppMethodBeat.o(210811);
      return;
    }
    finally
    {
      parame = finally;
      throw parame;
    }
  }
  
  public final void bYl()
  {
    try
    {
      AppMethodBeat.i(210835);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(210835);
    }
    finally {}
  }
  
  public final void coJ()
  {
    try
    {
      AppMethodBeat.i(210833);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).coJ();
      }
      AppMethodBeat.o(210833);
    }
    finally {}
  }
  
  public final void coK()
  {
    try
    {
      AppMethodBeat.i(210836);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).coK();
      }
      AppMethodBeat.o(210836);
    }
    finally {}
  }
  
  public final void f(RecyclerView paramRecyclerView, int paramInt)
  {
    try
    {
      AppMethodBeat.i(210832);
      p.h(paramRecyclerView, "recyclerView");
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).f(paramRecyclerView, paramInt);
      }
      AppMethodBeat.o(210832);
    }
    finally {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerCallback$RecycylerScrollListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "()V", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  static final class a
    implements com.tencent.mm.hellhoundlib.a.c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(210808);
      if ((p.i("onScrollStateChanged", paramString2)) && (p.i("(Landroid/support/v7/widget/RecyclerView;I)V", paramString3)))
      {
        if (paramArrayOfObject != null)
        {
          if (paramArrayOfObject.length >= 2)
          {
            paramString2 = paramArrayOfObject[0];
            if ((paramString2 instanceof RecyclerView))
            {
              paramString1 = j.qWF;
              paramString2 = (RecyclerView)paramString2;
              paramString3 = paramArrayOfObject[1];
              if (paramString3 == null)
              {
                paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(210808);
                throw paramString1;
              }
              paramString1.b(paramString2, ((Integer)paramString3).intValue());
            }
          }
          AppMethodBeat.o(210808);
          return;
        }
        AppMethodBeat.o(210808);
        return;
      }
      if ((p.i("onScrolled", paramString2)) && (p.i("(Landroid/support/v7/widget/RecyclerView;II)V", paramString3)) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 3))
      {
        paramString2 = paramArrayOfObject[0];
        if ((paramString2 instanceof RecyclerView))
        {
          paramString1 = j.qWF;
          paramString2 = (RecyclerView)paramString2;
          paramString3 = paramArrayOfObject[1];
          if (paramString3 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(210808);
            throw paramString1;
          }
          ((Integer)paramString3).intValue();
          paramString3 = paramArrayOfObject[2];
          if (paramString3 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(210808);
            throw paramString1;
          }
          paramString1.f(paramString2, ((Integer)paramString3).intValue());
        }
      }
      AppMethodBeat.o(210808);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.j
 * JD-Core Version:    0.7.0.1
 */