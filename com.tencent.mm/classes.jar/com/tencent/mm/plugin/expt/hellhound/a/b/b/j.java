package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.app.Activity;
import android.content.Intent;
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
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.cif;
import com.tencent.mm.sdk.platformtools.ae;
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

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerCallback;", "", "()V", "DESC_onScrollStateChanged", "", "DESC_onScrolled", "NAME_onScrollStateChanged", "NAME_onScrolled", "SUPER_NAME", "TAG", "mClickCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback;", "mFinderFragmentCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback;", "mFragmentFeedStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FragmentFeedStatistics;", "mItemDecorationCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback;", "mListener", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "mListeners", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IRecyclerMonitorListener;", "mMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "Lkotlin/collections/HashMap;", "mRefreshLoadMoreCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "mShareStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderShareStatistics;", "mSnsFinderMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/SnsFinderMonitor;", "mWaterfallsFlowMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor;", "begin19943OfsnsFinder", "", "session", "Lcom/tencent/mm/protocal/protobuf/PageSession;", "fragmentFeedFlowOnFree", "activityName", "getCurFragmentOfFinderHomeUI", "Landroid/support/v4/app/Fragment;", "activity", "Landroid/app/Activity;", "monitor", "on7Event", "pageName", "hashCode", "", "timestamp", "", "on8Event", "onActivityCreate", "onFinderHomeUIPaused", "onFinderHomeUIResumed", "onFinishActivity", "onLoadMoreBegin", "onLoadMoreEnd", "className", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "onRefreshBegin", "onRefreshEnd", "onScrollStateChanged", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "registerClickListener", "listener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "registerFinderFragmentListener", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "registerListener", "startFinderFragmentMonitor", "startFragmentFeedFlowMonitor", "Landroid/support/v4/app/FragmentActivity;", "fragment", "fragmentEventId", "startItemDecorationMonitor", "startMonitorClick", "startSnsFinderMonitor", "sPageName", "startWaterfallsFlowMonitor", "eventId", "stop19943OfsnsFinder", "curSession", "stopFinderFragmentMonitor", "stopFragmentFeedFlowMonitor", "stopItemDecorationMonitor", "stopMonitorClick", "stopSnsFinderMonitor", "stopWaterfallsFlowMonitor", "unregisterClickListener", "unregisterFinderFragmentListener", "unregisterListener", "RecycylerScrollListener", "plugin-expt_release"})
public final class j
{
  private static final List<e> mListeners;
  private static com.tencent.mm.hellhoundlib.a.c qZM;
  private static final HashMap<String, List<Pair<String, String>>> rdA;
  private static final k reA;
  private static final b reB;
  private static final l reC;
  private static final com.tencent.mm.plugin.expt.hellhound.a.b.c reD;
  private static final com.tencent.mm.plugin.expt.hellhound.a.a.b reE;
  private static final com.tencent.mm.plugin.expt.hellhound.a.b.d.d reF;
  private static final a reG;
  private static final m reH;
  public static final j reI;
  
  static
  {
    AppMethodBeat.i(196508);
    reI = new j();
    rdA = new HashMap();
    mListeners = (List)new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V"));
    localArrayList.add(Pair.create("onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V"));
    ((Map)rdA).put("android/support/v7/widget/RecyclerView$OnScrollListener", localArrayList);
    qZM = (com.tencent.mm.hellhoundlib.a.c)new a();
    reA = new k();
    reB = new b();
    reC = new l();
    reD = new com.tencent.mm.plugin.expt.hellhound.a.b.c();
    reE = new com.tencent.mm.plugin.expt.hellhound.a.a.b();
    reF = new com.tencent.mm.plugin.expt.hellhound.a.b.d.d();
    reG = new a();
    reH = new m();
    AppMethodBeat.o(196508);
  }
  
  public static final void a(Activity paramActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(196491);
    com.tencent.mm.plugin.expt.hellhound.a.b.c localc = reD;
    Object localObject;
    if (paramFragment == null) {
      if (paramActivity != null)
      {
        localObject = paramActivity.getClass();
        if (localObject != null)
        {
          localObject = ((Class)localObject).getName();
          c.a locala = c.rdX;
          if (!c.cqC().contains(localObject)) {
            break label379;
          }
          ae.i("HABBYGE-MALI.WaterfallsFlowMonitor", "monitor: poageName=".concat(String.valueOf(localObject)));
          localc.rcb = ((String)localObject);
          reI.a((e)localc.rcd);
          localc.rcc = new com.tencent.mm.plugin.expt.hellhound.a.b.d.j(paramActivity, paramFragment);
          localObject = localc.rcc;
          if (localObject == null) {
            break label379;
          }
          if (paramFragment != null) {
            break label284;
          }
          if (paramActivity == null) {
            break label248;
          }
          paramFragment = paramActivity.getClass();
          if (paramFragment == null) {
            break label248;
          }
          paramFragment = paramFragment.getName();
          label138:
          ae.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute: pageName=".concat(String.valueOf(paramFragment)));
          if (!p.i(paramFragment, c.rdP)) {
            break label265;
          }
          if (!p.i(paramFragment, c.rdR)) {
            break label253;
          }
          ae.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: 7Event !!");
          ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).a(paramActivity, paramLong);
          label190:
          c.rdQ = null;
          c.rdP = null;
        }
      }
    }
    for (;;)
    {
      paramActivity = (d)((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).rgm.rfF;
      p.h(paramActivity, "listener");
      reG.a(paramActivity);
      AppMethodBeat.o(196491);
      return;
      localObject = null;
      break;
      localObject = paramFragment.getClass().getName();
      break;
      label248:
      paramFragment = null;
      break label138;
      label253:
      ae.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: startActivity !!");
      break label190;
      label265:
      ae.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: Back to activity !!");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).a(paramActivity, paramLong);
      break label190;
      switch (paramInt)
      {
      case 1: 
      default: 
        ae.printErrStackTrace("HABBYGE-MALI.WaterfallsFlowStatistics", (Throwable)new NullPointerException("startCompute, fragment, miss !!"), "", new Object[0]);
        break;
      case 0: 
        ae.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, resume !!");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).a(paramFragment, paramLong);
        break;
      case 2: 
        label284:
        ae.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, 7Event !!");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).a(paramFragment, paramLong);
      }
    }
    label379:
    AppMethodBeat.o(196491);
  }
  
  public static void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(196500);
    p.h(paramFragmentActivity, "activity");
    p.h(paramFragment, "fragment");
    com.tencent.mm.plugin.expt.hellhound.a.a.b localb = reE;
    p.h(paramFragmentActivity, "activity");
    p.h(paramFragment, "fragment");
    paramFragment = paramFragment.getClass().getName();
    ae.d("HABBYGE-MALI.FragmentFeedStatistics", "start: fragment:" + paramFragment + ", event=" + paramInt);
    if (paramFragment == null)
    {
      AppMethodBeat.o(196500);
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
            AppMethodBeat.o(196500);
            return;
          } while (!paramFragment.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment"));
          if (localb.rbr == null) {
            localb.rbr = ((o)new com.tencent.mm.plugin.expt.hellhound.a.b.a.f((Activity)paramFragmentActivity));
          }
          paramFragmentActivity = localb.rbr;
          if (paramFragmentActivity == null) {
            break;
          }
          paramFragmentActivity.cqn();
          AppMethodBeat.o(196500);
          return;
        } while (!paramFragment.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment"));
        if (localb.rbt == null) {
          localb.rbt = ((o)new com.tencent.mm.plugin.expt.hellhound.a.b.a.j((Activity)paramFragmentActivity));
        }
        paramFragmentActivity = localb.rbt;
      } while (paramFragmentActivity == null);
      paramFragmentActivity.cqn();
      AppMethodBeat.o(196500);
      return;
    } while (!paramFragment.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment"));
    if (localb.rbs == null) {
      localb.rbs = ((o)new com.tencent.mm.plugin.expt.hellhound.a.b.a.g((Activity)paramFragmentActivity));
    }
    paramFragmentActivity = localb.rbs;
    if (paramFragmentActivity != null)
    {
      paramFragmentActivity.cqn();
      AppMethodBeat.o(196500);
      return;
      AppMethodBeat.o(196500);
      return;
    }
    AppMethodBeat.o(196500);
  }
  
  public static final void a(com.tencent.mm.plugin.expt.hellhound.core.d paramd)
  {
    AppMethodBeat.i(196483);
    p.h(paramd, "listener");
    Object localObject = reB;
    p.h(paramd, "listener");
    localObject = ((b)localObject).rdv;
    if (localObject != null)
    {
      p.h(paramd, "listener");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject).qZI = paramd;
      AppMethodBeat.o(196483);
      return;
    }
    AppMethodBeat.o(196483);
  }
  
  public static final void a(cie paramcie)
  {
    AppMethodBeat.i(196497);
    m.c(paramcie);
    AppMethodBeat.o(196497);
  }
  
  public static final Fragment ad(Activity paramActivity)
  {
    Object localObject2 = null;
    AppMethodBeat.i(196485);
    b localb = reB;
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
      AppMethodBeat.o(196485);
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
  
  public static final void afc(String paramString)
  {
    AppMethodBeat.i(196479);
    k localk = reA;
    if (!k.afl(paramString))
    {
      ae.i("HABBYGE-MALI.RecyclerItemDecorationCallback", "monitor");
      paramString = localk.rbC;
      if (paramString != null) {
        paramString.clear();
      }
      com.tencent.mm.hellhoundlib.a.ahD();
      com.tencent.mm.hellhoundlib.a.c((Map)localk.rdA, (com.tencent.mm.hellhoundlib.a.c)localk.reJ);
    }
    AppMethodBeat.o(196479);
  }
  
  public static final void afd(String paramString)
  {
    AppMethodBeat.i(196480);
    k localk = reA;
    if (!k.afl(paramString))
    {
      ae.i("HABBYGE-MALI.RecyclerItemDecorationCallback", "unmonitor");
      paramString = localk.rbC;
      if (paramString != null)
      {
        paramString = (RecyclerView)paramString.get();
        if (paramString != null) {
          paramString.b((RecyclerView.m)localk.reK);
        }
      }
      paramString = localk.rbC;
      if (paramString != null) {
        paramString.clear();
      }
      localk.rbC = null;
      com.tencent.mm.hellhoundlib.a.ahD();
      com.tencent.mm.hellhoundlib.a.d((Map)localk.rdA, (com.tencent.mm.hellhoundlib.a.c)localk.reJ);
    }
    AppMethodBeat.o(196480);
  }
  
  public static final void afe(String paramString)
  {
    AppMethodBeat.i(196481);
    b localb = reB;
    localb.rdr = paramString;
    if ((!(p.i("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString) ^ true)) || (!(p.i("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString) ^ true)))
    {
      ae.i("HABBYGE-MALI.FinderFragmentCallback", "monitor...");
      localb.afo = -1;
      localb.rdt = true;
      localb.rdu = false;
      com.tencent.mm.hellhoundlib.a.ahD();
      com.tencent.mm.hellhoundlib.a.c((Map)localb.rdA, (com.tencent.mm.hellhoundlib.a.c)localb.rdB);
    }
    AppMethodBeat.o(196481);
  }
  
  public static final void aff(String paramString)
  {
    AppMethodBeat.i(196482);
    b localb = reB;
    localb.rds = paramString;
    if ((!(p.i("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString) ^ true)) || (!(p.i("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString) ^ true)))
    {
      ae.i("HABBYGE-MALI.FinderFragmentCallback", "unmonitor...");
      localb.rdt = false;
      localb.rdu = true;
      com.tencent.mm.hellhoundlib.a.ahD();
      com.tencent.mm.hellhoundlib.a.d((Map)localb.rdA, (com.tencent.mm.hellhoundlib.a.c)localb.rdB);
    }
    AppMethodBeat.o(196482);
  }
  
  public static final void afg(String paramString)
  {
    AppMethodBeat.i(196493);
    if ((p.i("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (p.i("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)))
    {
      paramString = reE;
      ae.i("HABBYGE-MALI.FragmentFeedStatistics", "stop: free...");
      o localo = paramString.rbr;
      if (localo != null) {
        localo.free();
      }
      paramString.rbr = null;
      localo = paramString.rbs;
      if (localo != null) {
        localo.free();
      }
      paramString.rbs = null;
      localo = paramString.rbt;
      if (localo != null) {
        localo.free();
      }
      paramString.rbt = null;
    }
    AppMethodBeat.o(196493);
  }
  
  public static final void afh(String paramString)
  {
    AppMethodBeat.i(196494);
    if ((p.i("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (p.i("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)))
    {
      reG.cov();
      AppMethodBeat.o(196494);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.rhc;
    localObject = b.a.cri();
    if (((p.i(localObject, "999")) || (p.i(localObject, "101")) || (p.i(localObject, "102")) || (p.i(localObject, "123"))) && ((p.i("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", paramString)) || (p.i("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", paramString)) || (p.i("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", paramString)))) {
      reG.cov();
    }
    AppMethodBeat.o(196494);
  }
  
  public static final void afi(String paramString)
  {
    AppMethodBeat.i(196495);
    if (paramString == null)
    {
      AppMethodBeat.o(196495);
      return;
    }
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(196495);
      return;
      if (paramString.equals("SnsTimeLineUI"))
      {
        reH.cov();
        AppMethodBeat.o(196495);
        return;
        if (paramString.equals("com.tencent.mm.plugin.sns.ui.SnsTimeLineUI")) {
          reH.cov();
        }
      }
    }
  }
  
  public static final void afj(String paramString)
  {
    AppMethodBeat.i(196496);
    if ((p.i("SnsTimeLineUI", paramString)) || (p.i("com.tencent.mm.plugin.sns.ui.SnsTimeLineUI", paramString))) {
      reH.cqo();
    }
    AppMethodBeat.o(196496);
  }
  
  public static final void afk(String paramString)
  {
    AppMethodBeat.i(196499);
    if ((p.i("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (p.i("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)))
    {
      reG.cqo();
      AppMethodBeat.o(196499);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.rhc;
    localObject = b.a.cri();
    if (((p.i(localObject, "999")) || (p.i(localObject, "101")) || (p.i(localObject, "102")) || (p.i(localObject, "123"))) && ((p.i("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", paramString)) || (p.i("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", paramString)) || (p.i("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", paramString)))) {
      reG.cqo();
    }
    AppMethodBeat.o(196499);
  }
  
  public static final void b(Activity paramActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(196492);
    com.tencent.mm.plugin.expt.hellhound.a.b.c localc = reD;
    Object localObject;
    if (paramFragment == null) {
      if (paramActivity != null)
      {
        localObject = paramActivity.getClass();
        if (localObject != null)
        {
          localObject = ((Class)localObject).getName();
          c.a locala = c.rdX;
          if (c.cqC().contains(localObject))
          {
            ae.i("HABBYGE-MALI.WaterfallsFlowMonitor", "unmonitor: poageName=".concat(String.valueOf(localObject)));
            reI.b((e)localc.rcd);
            localObject = localc.rcc;
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
              ae.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: pageName=".concat(String.valueOf(paramFragment)));
              if (!p.i(paramFragment, c.rdQ)) {
                break label243;
              }
              ae.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: finish cur page !");
              ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).rgg = 1;
              paramInt = 1;
              label162:
              ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).b(paramActivity, paramLong);
              if (paramInt != 0)
              {
                paramActivity = c.rdX;
                c.a.cqE();
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      paramActivity = (d)((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).rgm.rfF;
      p.h(paramActivity, "listener");
      reG.b(paramActivity);
      localc.rcc = null;
      AppMethodBeat.o(196492);
      return;
      localObject = null;
      break;
      localObject = paramFragment.getClass().getName();
      break;
      label238:
      paramFragment = null;
      break label118;
      label243:
      if (((p.i(paramFragment, c.rdP) ^ true)) && (c.rdP != null))
      {
        ae.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: startActivity another page !");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).rgg = 1;
        paramInt = 0;
        break label162;
      }
      ae.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: 8Event !");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).rgg = 2;
      paramInt = 0;
      break label162;
      switch (paramInt)
      {
      case 2: 
      default: 
        ae.printErrStackTrace("HABBYGE-MALI.WaterfallsFlowStatistics", (Throwable)new NullPointerException("startCompute, fragment, miss !!"), "", new Object[0]);
        break;
      case 1: 
        ae.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, pause !!");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).rgg = 1;
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).b(paramFragment, paramLong);
        break;
      case 3: 
        label303:
        ae.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, 8Event !!");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).rgg = 2;
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).b(paramFragment, paramLong);
      }
    }
  }
  
  public static void b(FragmentActivity paramFragmentActivity, Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(196501);
    p.h(paramFragmentActivity, "activity");
    p.h(paramFragment, "fragment");
    com.tencent.mm.plugin.expt.hellhound.a.a.b localb = reE;
    p.h(paramFragmentActivity, "activity");
    p.h(paramFragment, "fragment");
    paramFragmentActivity = paramFragment.getClass().getName();
    ae.d("HABBYGE-MALI.FragmentFeedStatistics", "stop: fragment:" + paramFragmentActivity + ", event=" + paramInt);
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(196501);
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
            AppMethodBeat.o(196501);
            return;
          } while (!paramFragmentActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment"));
          paramFragmentActivity = localb.rbr;
          if (paramFragmentActivity == null) {
            break;
          }
          paramFragmentActivity.cqe();
          AppMethodBeat.o(196501);
          return;
        } while (!paramFragmentActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment"));
        paramFragmentActivity = localb.rbt;
      } while (paramFragmentActivity == null);
      paramFragmentActivity.cqe();
      AppMethodBeat.o(196501);
      return;
    } while (!paramFragmentActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment"));
    paramFragmentActivity = localb.rbs;
    if (paramFragmentActivity != null)
    {
      paramFragmentActivity.cqe();
      AppMethodBeat.o(196501);
      return;
      AppMethodBeat.o(196501);
      return;
    }
    AppMethodBeat.o(196501);
  }
  
  public static final void b(cie paramcie)
  {
    AppMethodBeat.i(196498);
    m.d(paramcie);
    AppMethodBeat.o(196498);
  }
  
  public static void cov()
  {
    AppMethodBeat.i(196476);
    ae.i("HABBYGE-MALI.RecyclerCallback", "monitor...");
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.a((Map)rdA, qZM);
    Object localObject1 = reC;
    ae.i("HABBYGE-MALI.RefreshLoadMoreCallback", "startMonitor...");
    Object localObject2 = new h();
    ae.i("HABBYGE-MALI.RLBeginCallback", "startMonitor...");
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.a((Map)((h)localObject2).rdA, (com.tencent.mm.hellhoundlib.a.c)((h)localObject2).reu);
    localObject2 = new i((l)localObject1);
    ae.i("HABBYGE-MALI.RLEndCallback", "startMonitor...");
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.a((Map)((i)localObject2).rdA, (com.tencent.mm.hellhoundlib.a.c)((i)localObject2).rew);
    localObject1 = new n((l)localObject1);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.a((Map)((n)localObject1).rdA, (com.tencent.mm.hellhoundlib.a.c)((n)localObject1).rfb);
    new g();
    com.tencent.mm.plugin.expt.hellhound.a.b.d.f.rfS.reset();
    com.tencent.mm.plugin.expt.hellhound.a.b.d.f.rfS.cqK();
    AppMethodBeat.o(196476);
  }
  
  public static final Fragment cpR()
  {
    AppMethodBeat.i(196484);
    b localb = reB;
    Object localObject1 = localb.rdv;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).rbW;
      if (localObject1 != null)
      {
        localObject1 = (Fragment)((WeakReference)localObject1).get();
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject1 = localb.rdw;
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
      AppMethodBeat.o(196484);
      return localObject2;
      localObject1 = null;
      break;
      localObject1 = null;
      break;
    }
  }
  
  public static final void cqG() {}
  
  public static final void d(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(196486);
    com.tencent.mm.plugin.expt.hellhound.a.b.d.d locald;
    Object localObject2;
    Object localObject3;
    if (paramActivity != null)
    {
      localObject1 = paramActivity.getClass();
      if (localObject1 != null)
      {
        localObject1 = ((Class)localObject1).getName();
        if (localObject1 != null) {
          break label127;
        }
        locald = reF;
        if (paramActivity != null)
        {
          localObject1 = paramActivity.getClass().getName();
          localObject2 = c.rdX;
          if ((c.cqB().contains(localObject1)) && (locald.rfL == null))
          {
            localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.aer((String)localObject1);
            if (localObject3 != null) {
              break label505;
            }
          }
        }
      }
    }
    label505:
    for (;;)
    {
      if (paramActivity != null)
      {
        localObject1 = paramActivity.getClass();
        if (localObject1 != null)
        {
          localObject2 = ((Class)localObject1).getName();
          if (localObject2 != null) {
            break label721;
          }
        }
      }
      AppMethodBeat.o(196486);
      return;
      localObject1 = null;
      break;
      label127:
      switch (((String)localObject1).hashCode())
      {
      default: 
        break;
      case -2055689330: 
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderHomeUI")) {
          break;
        }
        localObject1 = reB;
        if (paramActivity == null)
        {
          paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
          AppMethodBeat.o(196486);
          throw paramActivity;
        }
      case -936307702: 
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI")) {
          break;
        }
        localObject1 = reB;
        if (paramActivity == null)
        {
          paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
          AppMethodBeat.o(196486);
          throw paramActivity;
        }
      case -2013384910: 
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderConversationUI")) {
          break;
        }
        localObject1 = reB;
        if (paramActivity == null)
        {
          paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
          AppMethodBeat.o(196486);
          throw paramActivity;
        }
        ((b)localObject1).b((FragmentActivity)paramActivity, paramLong);
        AppMethodBeat.o(196486);
        return;
        ((b)localObject1).b((FragmentActivity)paramActivity, paramLong);
        AppMethodBeat.o(196486);
        return;
        p.h((FragmentActivity)paramActivity, "activity");
        paramActivity = ((b)localObject1).rdv;
        if (paramActivity != null)
        {
          paramActivity.rbZ = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
          localObject1 = paramActivity.rbZ;
          if (localObject1 == null) {
            p.bdF("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.crm().cos();
          localObject1 = paramActivity.rbZ;
          if (localObject1 == null) {
            p.bdF("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).duQ = com.tencent.mm.plugin.expt.hellhound.core.b.aer("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI");
          localObject1 = paramActivity.rbZ;
          if (localObject1 == null) {
            p.bdF("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).rfm = paramLong;
          localObject1 = paramActivity.rbZ;
          if (localObject1 == null) {
            p.bdF("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).rfp = "143";
          paramActivity = paramActivity.rbZ;
          if (paramActivity == null) {
            p.bdF("statyTimeStaticLbsList");
          }
          paramActivity.dGC = c.b.rdY.value;
          ae.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderLbsStreamListUIResume...");
          AppMethodBeat.o(196486);
          return;
        }
        AppMethodBeat.o(196486);
        return;
        p.g(localObject3, "HellhoundUtil.getShortNa…fPage(pageName) ?: return");
        int i = paramActivity.hashCode();
        localObject2 = paramActivity.getIntent().getStringExtra("key_ad_extra_info");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        com.tencent.mm.plugin.expt.hellhound.a.b.d.d.a((String)localObject3, i, paramLong, (String)localObject1);
        ae.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV2, sPage=" + (String)localObject3 + ", hashCode=" + i);
        if (com.tencent.mm.plugin.expt.hellhound.a.b.d.f.rfS.dg((String)localObject3, i) == null)
        {
          localObject2 = new cif();
          ((cif)localObject2).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.crm().cos();
          ((cif)localObject2).duQ = ((String)localObject3);
          ((cif)localObject2).aHQ = i;
          ((cif)localObject2).rfm = paramLong;
          b.a locala = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.rhc;
          ((cif)localObject2).rfp = b.a.cri();
          ((cif)localObject2).dGC = c.b.rdZ.value;
          ((cif)localObject2).extraInfo = ((String)localObject1);
          com.tencent.mm.plugin.expt.hellhound.a.b.d.f.rfS.c((cif)localObject2);
          ae.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV2, YES, sPage=" + (String)localObject3 + ", hashCode=" + i);
          locald.rfL = ((String)localObject3);
        }
        break;
      }
    }
    label721:
    Object localObject1 = c.rdX;
    boolean bool;
    if ((c.cqA().contains(localObject2)) && ((locald.rfK == null) || (!(p.i(localObject2, locald.rfK) ^ true))))
    {
      locald.rfK = ((String)localObject2);
      locald.rfJ = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
      localObject1 = locald.rfJ;
      if (localObject1 == null) {
        p.bdF("mStayTime");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.crm().cos();
      localObject1 = locald.rfJ;
      if (localObject1 == null) {
        p.bdF("mStayTime");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).duQ = com.tencent.mm.plugin.expt.hellhound.core.b.aer((String)localObject2);
      localObject1 = locald.rfJ;
      if (localObject1 == null) {
        p.bdF("mStayTime");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).rfm = paramLong;
      localObject1 = locald.rfJ;
      if (localObject1 == null) {
        p.bdF("mStayTime");
      }
      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.rhc;
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).rfp = b.a.cri();
      localObject1 = locald.rfJ;
      if (localObject1 == null) {
        p.bdF("mStayTime");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).dGC = c.b.rdY.value;
      localObject3 = locald.rfJ;
      if (localObject3 == null) {
        p.bdF("mStayTime");
      }
      localObject1 = paramActivity.getIntent().getStringExtra("key_ad_extra_info");
      paramActivity = (Activity)localObject1;
      if (localObject1 == null) {
        paramActivity = "";
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).extraInfo = paramActivity;
      if (!p.i(localObject2, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
        break label1081;
      }
      paramActivity = locald.rfJ;
      if (paramActivity == null) {
        p.bdF("mStayTime");
      }
      localObject1 = c.rdX;
      if (c.cqD() != c.c.red.value) {
        break label1075;
      }
      bool = true;
    }
    for (paramActivity.rfq = bool;; paramActivity.rfq = false)
    {
      paramActivity = new StringBuilder("doPageResume: ");
      localObject1 = locald.rfJ;
      if (localObject1 == null) {
        p.bdF("mStayTime");
      }
      ae.i("HABBYGE-MALI.FinderShareStatistics", ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).duQ);
      AppMethodBeat.o(196486);
      return;
      label1075:
      bool = false;
      break;
      label1081:
      paramActivity = locald.rfJ;
      if (paramActivity == null) {
        p.bdF("mStayTime");
      }
    }
  }
  
  public static final void e(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(196487);
    if (paramActivity != null)
    {
      localObject1 = paramActivity.getClass();
      if (localObject1 != null)
      {
        localObject1 = ((Class)localObject1).getName();
        if (localObject1 != null) {
          break label78;
        }
      }
    }
    Object localObject2;
    label78:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            localObject2 = reF;
            if (paramActivity != null)
            {
              localObject1 = paramActivity.getClass();
              if (localObject1 != null)
              {
                localObject1 = ((Class)localObject1).getName();
                if (localObject1 != null) {
                  break label542;
                }
              }
            }
            AppMethodBeat.o(196487);
            return;
            localObject1 = null;
            break;
            switch (((String)localObject1).hashCode())
            {
            }
          }
        } while (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderHomeUI"));
        localObject1 = reB;
        if (paramActivity != null) {
          break label253;
        }
        paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
        AppMethodBeat.o(196487);
        throw paramActivity;
      } while (!((String)localObject1).equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
      localObject1 = reB;
      if (paramActivity != null) {
        break label270;
      }
      paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
      AppMethodBeat.o(196487);
      throw paramActivity;
    } while (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderConversationUI"));
    Object localObject1 = reB;
    if (paramActivity == null)
    {
      paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
      AppMethodBeat.o(196487);
      throw paramActivity;
    }
    ((b)localObject1).c((FragmentActivity)paramActivity, paramLong);
    AppMethodBeat.o(196487);
    return;
    label253:
    ((b)localObject1).c((FragmentActivity)paramActivity, paramLong);
    AppMethodBeat.o(196487);
    return;
    label270:
    p.h((FragmentActivity)paramActivity, "activity");
    paramActivity = ((b)localObject1).rdv;
    if (paramActivity != null)
    {
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aer("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI");
      if (((com.tencent.mm.plugin.expt.hellhound.a.b.b)paramActivity).rbZ != null) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          localObject2 = paramActivity.rbZ;
          if (localObject2 == null) {
            p.bdF("statyTimeStaticLbsList");
          }
          if (p.i(((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).duQ, localObject1))
          {
            localObject1 = paramActivity.rbZ;
            if (localObject1 == null) {
              p.bdF("statyTimeStaticLbsList");
            }
            ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).rfn = paramLong;
            localObject1 = paramActivity.rbZ;
            if (localObject1 == null) {
              p.bdF("statyTimeStaticLbsList");
            }
            paramLong = ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).rfn;
            localObject1 = paramActivity.rbZ;
            if (localObject1 == null) {
              p.bdF("statyTimeStaticLbsList");
            }
            long l = ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).rfm;
            localObject1 = paramActivity.rbZ;
            if (localObject1 == null) {
              p.bdF("statyTimeStaticLbsList");
            }
            ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).rfl = (paramLong - l);
            localObject1 = paramActivity.rbZ;
            if (localObject1 == null) {
              p.bdF("statyTimeStaticLbsList");
            }
            ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).rfp = "143";
            localObject1 = paramActivity.rbZ;
            if (localObject1 == null) {
              p.bdF("statyTimeStaticLbsList");
            }
            ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).rfo = com.tencent.mm.plugin.expt.hellhound.core.b.cpi();
            localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.rff;
            paramActivity = paramActivity.rbZ;
            if (paramActivity == null) {
              p.bdF("statyTimeStaticLbsList");
            }
            a.a.a(paramActivity);
            ae.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderLbsStreamListUIPause...");
          }
        }
        AppMethodBeat.o(196487);
        return;
      }
    }
    AppMethodBeat.o(196487);
    return;
    label542:
    Object localObject3 = c.rdX;
    if (c.cqA().contains(localObject1))
    {
      if (((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).rfK == null)
      {
        AppMethodBeat.o(196487);
        return;
      }
      if (!(p.i(localObject1, ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).rfK) ^ true))
      {
        if (((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).rfL == null) {
          ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).rfK = null;
        }
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.aer((String)localObject1);
        localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).rfJ;
        if (localObject1 == null) {
          p.bdF("mStayTime");
        }
        if (p.i(((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).duQ, localObject3))
        {
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).rfJ;
          if (localObject1 == null) {
            p.bdF("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).rfn = paramLong;
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).rfJ;
          if (localObject1 == null) {
            p.bdF("mStayTime");
          }
          com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).rfJ;
          if (localb == null) {
            p.bdF("mStayTime");
          }
          paramLong = localb.rfn;
          localb = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).rfJ;
          if (localb == null) {
            p.bdF("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).rfl = (paramLong - localb.rfm);
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).rfJ;
          if (localObject1 == null) {
            p.bdF("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).rfo = com.tencent.mm.plugin.expt.hellhound.core.b.cpi();
          localb = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).rfJ;
          if (localb == null) {
            p.bdF("mStayTime");
          }
          localObject1 = paramActivity.getIntent().getStringExtra("key_ad_enter_source_info");
          paramActivity = (Activity)localObject1;
          if (localObject1 == null) {
            paramActivity = "";
          }
          localb.rfr = paramActivity;
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.rff;
          paramActivity = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).rfJ;
          if (paramActivity == null) {
            p.bdF("mStayTime");
          }
          a.a.a(paramActivity);
          ae.i("HABBYGE-MALI.FinderShareStatistics", "onPagePaused: ".concat(String.valueOf(localObject3)));
        }
      }
    }
    AppMethodBeat.o(196487);
  }
  
  public static final void f(Activity paramActivity, long paramLong)
  {
    long l1 = 0L;
    AppMethodBeat.i(196488);
    Object localObject3 = reF;
    if (paramActivity == null)
    {
      AppMethodBeat.o(196488);
      return;
    }
    Object localObject1 = paramActivity.getClass().getName();
    Object localObject2 = c.rdX;
    if (c.cqB().contains(localObject1))
    {
      localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.aer((String)localObject1);
      if (localObject2 == null)
      {
        AppMethodBeat.o(196488);
        return;
      }
      p.g(localObject2, "HellhoundUtil.getShortNa…fPage(pageName) ?: return");
      int i = paramActivity.hashCode();
      localObject1 = paramActivity.getIntent().getStringExtra("key_ad_enter_source_info");
      paramActivity = (Activity)localObject1;
      if (localObject1 == null) {
        paramActivity = "";
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject3).rfL = null;
      ae.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV1: sPage=" + (String)localObject2 + ", hashCode=" + i + ", enterSourceInfo=" + paramActivity);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.d.f.rfS.de((String)localObject2, i);
      if (localObject1 == null)
      {
        ae.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV2: sPage=" + (String)localObject2 + ", hashCode=" + i + ", enterSourceInfo=" + paramActivity);
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.d.f.rfS.dg((String)localObject2, i);
        if (localObject1 == null) {
          AppMethodBeat.o(196488);
        }
      }
      else
      {
        ae.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV1: compare, " + ((cif)localObject1).duQ + " == " + (String)localObject2 + ", " + ((cif)localObject1).aHQ + " == " + i);
        ((cif)localObject1).rfn = paramLong;
        long l2 = ((cif)localObject1).rfn;
        long l3 = ((cif)localObject1).rfm;
        localObject3 = ((cif)localObject1).Hux;
        p.g(localObject3, "statistics.stayTimeOnBackground");
        l2 = l2 - l3 - com.tencent.mm.plugin.expt.hellhound.a.b.d.d.aa((LinkedList)localObject3);
        if (l2 < 0L) {}
        for (;;)
        {
          ((cif)localObject1).rfl = l1;
          ((cif)localObject1).rfo = com.tencent.mm.plugin.expt.hellhound.core.b.cpi();
          ((cif)localObject1).dGC = c.b.rea.value;
          ((cif)localObject1).rfr = paramActivity;
          localObject3 = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.rff;
          a.a.a(com.tencent.mm.plugin.expt.hellhound.a.b.d.d.a((cif)localObject1, c.b.rea.value));
          com.tencent.mm.plugin.expt.hellhound.a.b.d.f.rfS.df((String)localObject2, i);
          ae.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV1: report, " + (String)localObject2 + ", " + i);
          break;
          l1 = l2;
        }
      }
      ae.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV2: compare, " + ((cif)localObject1).duQ + " == " + (String)localObject2 + ", " + ((cif)localObject1).aHQ + " == " + i);
      ((cif)localObject1).rfn = paramLong;
      ((cif)localObject1).rfl = (((cif)localObject1).rfn - ((cif)localObject1).rfm);
      ((cif)localObject1).rfo = com.tencent.mm.plugin.expt.hellhound.core.b.cpi();
      ((cif)localObject1).dGC = c.b.rdZ.value;
      ((cif)localObject1).rfr = paramActivity;
      paramActivity = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.rff;
      a.a.a(com.tencent.mm.plugin.expt.hellhound.a.b.d.d.a((cif)localObject1, c.b.rdZ.value));
      com.tencent.mm.plugin.expt.hellhound.a.b.d.f.rfS.dh((String)localObject2, i);
      ae.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV2: report, " + (String)localObject2 + ", " + i);
    }
    AppMethodBeat.o(196488);
  }
  
  public static final void n(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(196489);
    com.tencent.mm.plugin.expt.hellhound.a.b.d.d.q(paramString, paramInt, paramLong);
    ae.i("HABBYGE-MALI.FinderShareStatistics", "on8EventV2: pageName=" + paramString + ", hashCode=" + paramInt);
    if (com.tencent.mm.plugin.expt.hellhound.core.b.aem(paramString))
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.d.f.rfS.cqK();
      AppMethodBeat.o(196489);
      return;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.a.b.d.f.rfS.cqJ();
    if (paramString == null)
    {
      AppMethodBeat.o(196489);
      return;
    }
    paramString.rfn = paramLong;
    paramString.rfl = (paramString.rfn - paramString.rfm);
    paramString.rfo = com.tencent.mm.plugin.expt.hellhound.core.b.cpi();
    paramString.dGC = c.b.rdZ.value;
    ae.i("HABBYGE-MALI.FinderShareStatistics", "on8EventV2, statics: " + paramString.duQ + ", " + paramString.aHQ);
    a.a locala = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.rff;
    a.a.a(com.tencent.mm.plugin.expt.hellhound.a.b.d.d.a(paramString, c.b.rdZ.value));
    paramString.dGC = 8;
    com.tencent.mm.plugin.expt.hellhound.a.b.d.f.rfS.d(paramString);
    AppMethodBeat.o(196489);
  }
  
  public static final void o(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(196490);
    com.tencent.mm.plugin.expt.hellhound.a.b.d.d.p(paramString, paramInt, paramLong);
    com.tencent.mm.plugin.expt.hellhound.a.b.d.d.r(paramString, paramInt, paramLong);
    AppMethodBeat.o(196490);
  }
  
  public final void a(e parame)
  {
    try
    {
      AppMethodBeat.i(196477);
      p.h(parame, "listener");
      if (!mListeners.contains(parame)) {
        mListeners.add(parame);
      }
      AppMethodBeat.o(196477);
      return;
    }
    finally {}
  }
  
  public final void a(l.a parama)
  {
    try
    {
      AppMethodBeat.i(196505);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).a(parama);
      }
      AppMethodBeat.o(196505);
    }
    finally {}
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    try
    {
      AppMethodBeat.i(196502);
      p.h(paramRecyclerView, "recyclerView");
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).b(paramRecyclerView, paramInt);
      }
      AppMethodBeat.o(196502);
    }
    finally {}
  }
  
  public final void b(e parame)
  {
    try
    {
      AppMethodBeat.i(196478);
      p.h(parame, "listener");
      mListeners.remove(parame);
      AppMethodBeat.o(196478);
      return;
    }
    finally
    {
      parame = finally;
      throw parame;
    }
  }
  
  public final void bZA()
  {
    try
    {
      AppMethodBeat.i(196506);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(196506);
    }
    finally {}
  }
  
  public final void cql()
  {
    try
    {
      AppMethodBeat.i(196504);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).cql();
      }
      AppMethodBeat.o(196504);
    }
    finally {}
  }
  
  public final void cqm()
  {
    try
    {
      AppMethodBeat.i(196507);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).cqm();
      }
      AppMethodBeat.o(196507);
    }
    finally {}
  }
  
  public final void f(RecyclerView paramRecyclerView, int paramInt)
  {
    try
    {
      AppMethodBeat.i(196503);
      p.h(paramRecyclerView, "recyclerView");
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).f(paramRecyclerView, paramInt);
      }
      AppMethodBeat.o(196503);
    }
    finally {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerCallback$RecycylerScrollListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "()V", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  static final class a
    implements com.tencent.mm.hellhoundlib.a.c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(196475);
      if ((p.i("onScrollStateChanged", paramString2)) && (p.i("(Landroid/support/v7/widget/RecyclerView;I)V", paramString3)))
      {
        if (paramArrayOfObject != null)
        {
          if (paramArrayOfObject.length >= 2)
          {
            paramString2 = paramArrayOfObject[0];
            if ((paramString2 instanceof RecyclerView))
            {
              paramString1 = j.reI;
              paramString2 = (RecyclerView)paramString2;
              paramString3 = paramArrayOfObject[1];
              if (paramString3 == null)
              {
                paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(196475);
                throw paramString1;
              }
              paramString1.b(paramString2, ((Integer)paramString3).intValue());
            }
          }
          AppMethodBeat.o(196475);
          return;
        }
        AppMethodBeat.o(196475);
        return;
      }
      if ((p.i("onScrolled", paramString2)) && (p.i("(Landroid/support/v7/widget/RecyclerView;II)V", paramString3)) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 3))
      {
        paramString2 = paramArrayOfObject[0];
        if ((paramString2 instanceof RecyclerView))
        {
          paramString1 = j.reI;
          paramString2 = (RecyclerView)paramString2;
          paramString3 = paramArrayOfObject[1];
          if (paramString3 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(196475);
            throw paramString1;
          }
          ((Integer)paramString3).intValue();
          paramString3 = paramArrayOfObject[2];
          if (paramString3 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(196475);
            throw paramString1;
          }
          paramString1.f(paramString2, ((Integer)paramString3).intValue());
        }
      }
      AppMethodBeat.o(196475);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.j
 * JD-Core Version:    0.7.0.1
 */