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
import com.tencent.mm.protocal.protobuf.cct;
import com.tencent.mm.sdk.platformtools.ac;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerCallback;", "", "()V", "DESC_onScrollStateChanged", "", "DESC_onScrolled", "NAME_onScrollStateChanged", "NAME_onScrolled", "SUPER_NAME", "TAG", "mClickCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback;", "mFinderFragmentCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback;", "mFragmentFeedStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FragmentFeedStatistics;", "mItemDecorationCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback;", "mListener", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "mListeners", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IRecyclerMonitorListener;", "mMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "Lkotlin/collections/HashMap;", "mRefreshLoadMoreCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "mShareStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderShareStatistics;", "mWaterfallsFlowMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor;", "fragmentFeedFlowOnFree", "", "activityName", "getCurFragmentOfFinderHomeUI", "Landroid/support/v4/app/Fragment;", "activity", "Landroid/app/Activity;", "monitor", "on7Event", "pageName", "timestamp", "", "on8Event", "onActivityCreate", "onFinderHomeUIPaused", "onFinderHomeUIResumed", "onFinishActivity", "onLoadMoreBegin", "onLoadMoreEnd", "className", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "onRefreshBegin", "onRefreshEnd", "onScrollStateChanged", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "registerClickListener", "listener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "registerFinderFragmentListener", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "registerListener", "startFinderFragmentMonitor", "startFragmentFeedFlowMonitor", "Landroid/support/v4/app/FragmentActivity;", "fragment", "fragmentEventId", "startItemDecorationMonitor", "startMonitorClick", "startWaterfallsFlowMonitor", "eventId", "stopFinderFragmentMonitor", "stopFragmentFeedFlowMonitor", "stopItemDecorationMonitor", "stopMonitorClick", "stopWaterfallsFlowMonitor", "unregisterClickListener", "unregisterFinderFragmentListener", "unregisterListener", "RecycylerScrollListener", "plugin-expt_release"})
public final class j
{
  private static final List<e> mListeners;
  private static com.tencent.mm.hellhoundlib.a.c qjI;
  private static final HashMap<String, List<Pair<String, String>>> qmF;
  private static final k qnA;
  private static final b qnB;
  private static final l qnC;
  private static final com.tencent.mm.plugin.expt.hellhound.a.b.b qnD;
  private static final com.tencent.mm.plugin.expt.hellhound.a.a.b qnE;
  private static final com.tencent.mm.plugin.expt.hellhound.a.b.d.d qnF;
  private static final a qnG;
  public static final j qnH;
  
  static
  {
    AppMethodBeat.i(195491);
    qnH = new j();
    qmF = new HashMap();
    mListeners = (List)new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V"));
    localArrayList.add(Pair.create("onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V"));
    ((Map)qmF).put("android/support/v7/widget/RecyclerView$OnScrollListener", localArrayList);
    qjI = (com.tencent.mm.hellhoundlib.a.c)new a();
    qnA = new k();
    qnB = new b();
    qnC = new l();
    qnD = new com.tencent.mm.plugin.expt.hellhound.a.b.b();
    qnE = new com.tencent.mm.plugin.expt.hellhound.a.a.b();
    qnF = new com.tencent.mm.plugin.expt.hellhound.a.b.d.d();
    qnG = new a();
    AppMethodBeat.o(195491);
  }
  
  public static final void a(Activity paramActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(195478);
    com.tencent.mm.plugin.expt.hellhound.a.b.b localb = qnD;
    Object localObject;
    if (paramFragment == null) {
      if (paramActivity != null)
      {
        localObject = paramActivity.getClass();
        if (localObject != null)
        {
          localObject = ((Class)localObject).getName();
          c.a locala = c.qna;
          if (!c.cjP().contains(localObject)) {
            break label379;
          }
          ac.i("HABBYGE-MALI.WaterfallsFlowMonitor", "monitor: poageName=".concat(String.valueOf(localObject)));
          localb.qlg = ((String)localObject);
          qnH.a((e)localb.qli);
          localb.qlh = new com.tencent.mm.plugin.expt.hellhound.a.b.d.j(paramActivity, paramFragment);
          localObject = localb.qlh;
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
          ac.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute: pageName=".concat(String.valueOf(paramFragment)));
          if (!d.g.b.k.g(paramFragment, c.qmT)) {
            break label263;
          }
          if (!d.g.b.k.g(paramFragment, c.qmV)) {
            break label251;
          }
          ac.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: 7Event !!");
          ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).a(paramActivity, paramLong);
          label188:
          c.qmU = null;
          c.qmT = null;
        }
      }
    }
    for (;;)
    {
      paramActivity = (d)((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).qph.qoC;
      d.g.b.k.h(paramActivity, "listener");
      qnG.a(paramActivity);
      AppMethodBeat.o(195478);
      return;
      localObject = null;
      break;
      localObject = paramFragment.getClass().getName();
      break;
      label246:
      paramFragment = null;
      break label136;
      label251:
      ac.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: startActivity !!");
      break label188;
      label263:
      ac.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: Back to activity !!");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).a(paramActivity, paramLong);
      break label188;
      switch (paramInt)
      {
      case 1: 
      default: 
        ac.printErrStackTrace("HABBYGE-MALI.WaterfallsFlowStatistics", (Throwable)new NullPointerException("startCompute, fragment, miss !!"), "", new Object[0]);
        break;
      case 0: 
        ac.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, resume !!");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).a(paramFragment, paramLong);
        break;
      case 2: 
        label282:
        ac.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, 7Event !!");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).a(paramFragment, paramLong);
      }
    }
    label379:
    AppMethodBeat.o(195478);
  }
  
  public static void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(195483);
    d.g.b.k.h(paramFragmentActivity, "activity");
    d.g.b.k.h(paramFragment, "fragment");
    com.tencent.mm.plugin.expt.hellhound.a.a.b localb = qnE;
    d.g.b.k.h(paramFragmentActivity, "activity");
    d.g.b.k.h(paramFragment, "fragment");
    paramFragment = paramFragment.getClass().getName();
    ac.d("HABBYGE-MALI.FragmentFeedStatistics", "start: fragment:" + paramFragment + ", event=" + paramInt);
    if (paramFragment == null)
    {
      AppMethodBeat.o(195483);
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
            AppMethodBeat.o(195483);
            return;
          } while (!paramFragment.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment"));
          if (localb.qkx == null) {
            localb.qkx = ((o)new com.tencent.mm.plugin.expt.hellhound.a.b.a.f((Activity)paramFragmentActivity));
          }
          paramFragmentActivity = localb.qkx;
          if (paramFragmentActivity == null) {
            break;
          }
          paramFragmentActivity.cjz();
          AppMethodBeat.o(195483);
          return;
        } while (!paramFragment.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment"));
        if (localb.qkz == null) {
          localb.qkz = ((o)new com.tencent.mm.plugin.expt.hellhound.a.b.a.j((Activity)paramFragmentActivity));
        }
        paramFragmentActivity = localb.qkz;
      } while (paramFragmentActivity == null);
      paramFragmentActivity.cjz();
      AppMethodBeat.o(195483);
      return;
    } while (!paramFragment.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment"));
    if (localb.qky == null) {
      localb.qky = ((o)new com.tencent.mm.plugin.expt.hellhound.a.b.a.g((Activity)paramFragmentActivity));
    }
    paramFragmentActivity = localb.qky;
    if (paramFragmentActivity != null)
    {
      paramFragmentActivity.cjz();
      AppMethodBeat.o(195483);
      return;
      AppMethodBeat.o(195483);
      return;
    }
    AppMethodBeat.o(195483);
  }
  
  public static final void a(com.tencent.mm.plugin.expt.hellhound.core.d paramd)
  {
    AppMethodBeat.i(195469);
    d.g.b.k.h(paramd, "listener");
    Object localObject = qnB;
    d.g.b.k.h(paramd, "listener");
    localObject = ((b)localObject).qmA;
    if (localObject != null)
    {
      d.g.b.k.h(paramd, "listener");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject).qjC = paramd;
      AppMethodBeat.o(195469);
      return;
    }
    AppMethodBeat.o(195469);
  }
  
  public static final void aaA(String paramString)
  {
    AppMethodBeat.i(195482);
    if ((d.g.b.k.g("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (d.g.b.k.g("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)))
    {
      qnG.cjB();
      AppMethodBeat.o(195482);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qpX;
    localObject = b.a.ckz();
    if (((d.g.b.k.g(localObject, "999")) || (d.g.b.k.g(localObject, "101")) || (d.g.b.k.g(localObject, "102")) || (d.g.b.k.g(localObject, "123"))) && ((d.g.b.k.g("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", paramString)) || (d.g.b.k.g("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", paramString)) || (d.g.b.k.g("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", paramString)))) {
      qnG.cjB();
    }
    AppMethodBeat.o(195482);
  }
  
  public static final void aau(String paramString)
  {
    AppMethodBeat.i(195465);
    k localk = qnA;
    if (!k.aaB(paramString))
    {
      ac.i("HABBYGE-MALI.RecyclerItemDecorationCallback", "monitor");
      paramString = localk.qkI;
      if (paramString != null) {
        paramString.clear();
      }
      com.tencent.mm.hellhoundlib.a.aeC();
      com.tencent.mm.hellhoundlib.a.c((Map)localk.qmF, (com.tencent.mm.hellhoundlib.a.c)localk.qnI);
    }
    AppMethodBeat.o(195465);
  }
  
  public static final void aav(String paramString)
  {
    AppMethodBeat.i(195466);
    k localk = qnA;
    if (!k.aaB(paramString))
    {
      ac.i("HABBYGE-MALI.RecyclerItemDecorationCallback", "unmonitor");
      paramString = localk.qkI;
      if (paramString != null)
      {
        paramString = (RecyclerView)paramString.get();
        if (paramString != null) {
          paramString.b((RecyclerView.m)localk.qnJ);
        }
      }
      paramString = localk.qkI;
      if (paramString != null) {
        paramString.clear();
      }
      localk.qkI = null;
      com.tencent.mm.hellhoundlib.a.aeC();
      com.tencent.mm.hellhoundlib.a.d((Map)localk.qmF, (com.tencent.mm.hellhoundlib.a.c)localk.qnI);
    }
    AppMethodBeat.o(195466);
  }
  
  public static final void aaw(String paramString)
  {
    AppMethodBeat.i(195467);
    b localb = qnB;
    localb.qmw = paramString;
    if ((!(d.g.b.k.g("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString) ^ true)) || (!(d.g.b.k.g("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString) ^ true)))
    {
      ac.i("HABBYGE-MALI.FinderFragmentCallback", "monitor...");
      localb.adx = -1;
      localb.qmy = true;
      localb.qmz = false;
      com.tencent.mm.hellhoundlib.a.aeC();
      com.tencent.mm.hellhoundlib.a.c((Map)localb.qmF, (com.tencent.mm.hellhoundlib.a.c)localb.qmG);
    }
    AppMethodBeat.o(195467);
  }
  
  public static final void aax(String paramString)
  {
    AppMethodBeat.i(195468);
    b localb = qnB;
    localb.qmx = paramString;
    if ((!(d.g.b.k.g("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString) ^ true)) || (!(d.g.b.k.g("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString) ^ true)))
    {
      ac.i("HABBYGE-MALI.FinderFragmentCallback", "unmonitor...");
      localb.qmy = false;
      localb.qmz = true;
      com.tencent.mm.hellhoundlib.a.aeC();
      com.tencent.mm.hellhoundlib.a.d((Map)localb.qmF, (com.tencent.mm.hellhoundlib.a.c)localb.qmG);
    }
    AppMethodBeat.o(195468);
  }
  
  public static final void aay(String paramString)
  {
    AppMethodBeat.i(195480);
    if ((d.g.b.k.g("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (d.g.b.k.g("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)))
    {
      paramString = qnE;
      ac.i("HABBYGE-MALI.FragmentFeedStatistics", "stop: free...");
      o localo = paramString.qkx;
      if (localo != null) {
        localo.free();
      }
      paramString.qkx = null;
      localo = paramString.qky;
      if (localo != null) {
        localo.free();
      }
      paramString.qky = null;
      localo = paramString.qkz;
      if (localo != null) {
        localo.free();
      }
      paramString.qkz = null;
    }
    AppMethodBeat.o(195480);
  }
  
  public static final void aaz(String paramString)
  {
    AppMethodBeat.i(195481);
    if ((d.g.b.k.g("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (d.g.b.k.g("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)))
    {
      qnG.cjA();
      AppMethodBeat.o(195481);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qpX;
    localObject = b.a.ckz();
    if (((d.g.b.k.g(localObject, "999")) || (d.g.b.k.g(localObject, "101")) || (d.g.b.k.g(localObject, "102")) || (d.g.b.k.g(localObject, "123"))) && ((d.g.b.k.g("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", paramString)) || (d.g.b.k.g("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", paramString)) || (d.g.b.k.g("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", paramString)))) {
      qnG.cjA();
    }
    AppMethodBeat.o(195481);
  }
  
  public static final void ab(String paramString, long paramLong)
  {
    AppMethodBeat.i(195476);
    cct localcct = com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qoN.cjT();
    if (localcct != null)
    {
      if (!localcct.Frk.isEmpty()) {
        break label166;
      }
      localcct.Frk.add(Long.valueOf(paramLong));
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qoN.a(localcct);
      localcct = com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qoN.cjU();
      if (localcct != null)
      {
        localcct.qol = paramLong;
        localcct.qoj = (localcct.qol - localcct.qok);
        localcct.qom = com.tencent.mm.plugin.expt.hellhound.core.b.ciI();
        localcct.dtw = c.b.qnc.value;
        a.a locala = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.qoc;
        a.a.a(com.tencent.mm.plugin.expt.hellhound.a.b.d.d.a(localcct, c.b.qnc.value));
        localcct.dtw = 8;
        com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qoN.b(localcct);
        ac.i("HABBYGE-MALI.FinderShareStatistics", "doOn8EventV2: " + paramString + ", " + localcct.aFZ);
      }
      AppMethodBeat.o(195476);
      return;
      label166:
      if (localcct.Frk.size() % 2 == 0)
      {
        localcct.Frk.add(Long.valueOf(paramLong));
      }
      else
      {
        localcct.Frk.removeLast();
        localcct.Frk.add(Long.valueOf(paramLong));
      }
    }
  }
  
  public static final Fragment ac(Activity paramActivity)
  {
    Object localObject2 = null;
    AppMethodBeat.i(195471);
    b localb = qnB;
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
      AppMethodBeat.o(195471);
      return paramActivity;
      label53:
      if ((d.g.b.k.g(paramActivity, "com.tencent.mm.plugin.finder.ui.FinderHomeUI") ^ true))
      {
        localObject1 = localObject2;
        if ((d.g.b.k.g(paramActivity, "com.tencent.mm.plugin.finder.ui.FinderConversationUI") ^ true)) {}
      }
      else
      {
        localObject1 = localb.i(null, -1);
      }
    }
  }
  
  public static final void b(Activity paramActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(195479);
    com.tencent.mm.plugin.expt.hellhound.a.b.b localb = qnD;
    Object localObject;
    if (paramFragment == null) {
      if (paramActivity != null)
      {
        localObject = paramActivity.getClass();
        if (localObject != null)
        {
          localObject = ((Class)localObject).getName();
          c.a locala = c.qna;
          if (c.cjP().contains(localObject))
          {
            ac.i("HABBYGE-MALI.WaterfallsFlowMonitor", "unmonitor: poageName=".concat(String.valueOf(localObject)));
            qnH.b((e)localb.qli);
            localObject = localb.qlh;
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
              ac.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: pageName=".concat(String.valueOf(paramFragment)));
              if (!d.g.b.k.g(paramFragment, c.qmU)) {
                break label242;
              }
              ac.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: finish cur page !");
              ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).qpb = 1;
              paramInt = 1;
              label161:
              ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).b(paramActivity, paramLong);
              if (paramInt != 0)
              {
                paramActivity = c.qna;
                c.a.cjR();
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      paramActivity = (d)((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).qph.qoC;
      d.g.b.k.h(paramActivity, "listener");
      qnG.b(paramActivity);
      localb.qlh = null;
      AppMethodBeat.o(195479);
      return;
      localObject = null;
      break;
      localObject = paramFragment.getClass().getName();
      break;
      label237:
      paramFragment = null;
      break label117;
      label242:
      if (((d.g.b.k.g(paramFragment, c.qmT) ^ true)) && (c.qmT != null))
      {
        ac.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: startActivity another page !");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).qpb = 1;
        paramInt = 0;
        break label161;
      }
      ac.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: 8Event !");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).qpb = 2;
      paramInt = 0;
      break label161;
      switch (paramInt)
      {
      case 2: 
      default: 
        ac.printErrStackTrace("HABBYGE-MALI.WaterfallsFlowStatistics", (Throwable)new NullPointerException("startCompute, fragment, miss !!"), "", new Object[0]);
        break;
      case 1: 
        ac.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, pause !!");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).qpb = 1;
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).b(paramFragment, paramLong);
        break;
      case 3: 
        label302:
        ac.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, 8Event !!");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).qpb = 2;
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).b(paramFragment, paramLong);
      }
    }
  }
  
  public static void b(FragmentActivity paramFragmentActivity, Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(195484);
    d.g.b.k.h(paramFragmentActivity, "activity");
    d.g.b.k.h(paramFragment, "fragment");
    com.tencent.mm.plugin.expt.hellhound.a.a.b localb = qnE;
    d.g.b.k.h(paramFragmentActivity, "activity");
    d.g.b.k.h(paramFragment, "fragment");
    paramFragmentActivity = paramFragment.getClass().getName();
    ac.d("HABBYGE-MALI.FragmentFeedStatistics", "stop: fragment:" + paramFragmentActivity + ", event=" + paramInt);
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(195484);
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
            AppMethodBeat.o(195484);
            return;
          } while (!paramFragmentActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment"));
          paramFragmentActivity = localb.qkx;
          if (paramFragmentActivity == null) {
            break;
          }
          paramFragmentActivity.cjq();
          AppMethodBeat.o(195484);
          return;
        } while (!paramFragmentActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment"));
        paramFragmentActivity = localb.qkz;
      } while (paramFragmentActivity == null);
      paramFragmentActivity.cjq();
      AppMethodBeat.o(195484);
      return;
    } while (!paramFragmentActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment"));
    paramFragmentActivity = localb.qky;
    if (paramFragmentActivity != null)
    {
      paramFragmentActivity.cjq();
      AppMethodBeat.o(195484);
      return;
      AppMethodBeat.o(195484);
      return;
    }
    AppMethodBeat.o(195484);
  }
  
  public static void cjA()
  {
    AppMethodBeat.i(195462);
    ac.i("HABBYGE-MALI.RecyclerCallback", "monitor...");
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.a((Map)qmF, qjI);
    Object localObject1 = qnC;
    ac.i("HABBYGE-MALI.RefreshLoadMoreCallback", "startMonitor...");
    Object localObject2 = new h();
    ac.i("HABBYGE-MALI.RLBeginCallback", "startMonitor...");
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.a((Map)((h)localObject2).qmF, (com.tencent.mm.hellhoundlib.a.c)((h)localObject2).qnu);
    localObject2 = new i((l)localObject1);
    ac.i("HABBYGE-MALI.RLEndCallback", "startMonitor...");
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.a((Map)((i)localObject2).qmF, (com.tencent.mm.hellhoundlib.a.c)((i)localObject2).qnw);
    localObject1 = new m((l)localObject1);
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.a((Map)((m)localObject1).qmF, (com.tencent.mm.hellhoundlib.a.c)((m)localObject1).qnY);
    new g();
    com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qoN.reset();
    com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qoN.cjV();
    AppMethodBeat.o(195462);
  }
  
  public static final Fragment cji()
  {
    AppMethodBeat.i(195470);
    b localb = qnB;
    Object localObject1 = localb.qmA;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).qlb;
      if (localObject1 != null)
      {
        localObject1 = (Fragment)((WeakReference)localObject1).get();
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject1 = localb.qmB;
          if (localObject1 == null) {
            break label87;
          }
        }
      }
    }
    label87:
    for (localObject1 = (UIComponentActivity)((WeakReference)localObject1).get();; localObject1 = null)
    {
      localObject2 = (Fragment)localb.i(localObject1, -1);
      AppMethodBeat.o(195470);
      return localObject2;
      localObject1 = null;
      break;
      localObject1 = null;
      break;
    }
  }
  
  public static final void d(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(195472);
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
        localObject1 = qnF;
        Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qpX;
        localObject2 = b.a.ckz();
        if (paramActivity == null) {
          break label717;
        }
        paramActivity = paramActivity.getClass();
        if (paramActivity == null) {
          break label717;
        }
        paramActivity = paramActivity.getName();
        Object localObject3 = c.qna;
        if (d.a.j.a((Iterable)c.cjN(), paramActivity))
        {
          ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qoG = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qoG;
          if (localObject3 == null) {
            d.g.b.k.aVY("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cku().cit();
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qoG;
          if (localObject3 == null) {
            d.g.b.k.aVY("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).qoi = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramActivity);
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qoG;
          if (localObject3 == null) {
            d.g.b.k.aVY("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).qok = paramLong;
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qoG;
          if (localObject3 == null) {
            d.g.b.k.aVY("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).qon = ((String)localObject2);
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qoG;
          if (localObject2 == null) {
            d.g.b.k.aVY("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).dtw = c.b.qnb.value;
          if (!d.g.b.k.g(paramActivity, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
            break label727;
          }
          paramActivity = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qoG;
          if (paramActivity == null) {
            d.g.b.k.aVY("mStayTime");
          }
          localObject2 = c.qna;
          if (c.cjQ() != c.c.qng.value) {
            break label722;
          }
          bool = true;
        }
      }
    }
    label275:
    label717:
    label722:
    for (paramActivity.qoo = bool;; paramActivity.qoo = false)
    {
      paramActivity = new StringBuilder("doPageResume: ");
      localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qoG;
      if (localObject1 == null) {
        d.g.b.k.aVY("mStayTime");
      }
      ac.i("HABBYGE-MALI.FinderShareStatistics", ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).qoi);
      AppMethodBeat.o(195472);
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
        localObject1 = qnB;
        if (paramActivity == null)
        {
          paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
          AppMethodBeat.o(195472);
          throw paramActivity;
        }
      case -936307702: 
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI")) {
          break;
        }
        localObject1 = qnB;
        if (paramActivity == null)
        {
          paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
          AppMethodBeat.o(195472);
          throw paramActivity;
        }
      case -2013384910: 
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderConversationUI")) {
          break;
        }
        localObject1 = qnB;
        if (paramActivity == null)
        {
          paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
          AppMethodBeat.o(195472);
          throw paramActivity;
        }
        ((b)localObject1).a((FragmentActivity)paramActivity, paramLong);
        AppMethodBeat.o(195472);
        return;
        ((b)localObject1).a((FragmentActivity)paramActivity, paramLong);
        AppMethodBeat.o(195472);
        return;
        d.g.b.k.h((FragmentActivity)paramActivity, "activity");
        paramActivity = ((b)localObject1).qmA;
        if (paramActivity != null)
        {
          paramActivity.qle = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
          localObject1 = paramActivity.qle;
          if (localObject1 == null) {
            d.g.b.k.aVY("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cku().cit();
          localObject1 = paramActivity.qle;
          if (localObject1 == null) {
            d.g.b.k.aVY("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).qoi = com.tencent.mm.plugin.expt.hellhound.core.b.ZK("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI");
          localObject1 = paramActivity.qle;
          if (localObject1 == null) {
            d.g.b.k.aVY("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).qok = paramLong;
          localObject1 = paramActivity.qle;
          if (localObject1 == null) {
            d.g.b.k.aVY("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).qon = "143";
          paramActivity = paramActivity.qle;
          if (paramActivity == null) {
            d.g.b.k.aVY("statyTimeStaticLbsList");
          }
          paramActivity.dtw = c.b.qnb.value;
          ac.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderLbsStreamListUIResume...");
          AppMethodBeat.o(195472);
          return;
        }
        AppMethodBeat.o(195472);
        return;
        paramActivity = null;
        break label66;
        bool = false;
        break label275;
        label727:
        paramActivity = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qoG;
        if (paramActivity == null) {
          d.g.b.k.aVY("mStayTime");
        }
        break;
      }
    }
  }
  
  public static final void e(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(195473);
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
        localObject1 = qnF;
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
      Object localObject2 = c.qna;
      if (d.a.j.a((Iterable)c.cjN(), paramActivity))
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramActivity);
        localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qoG;
        if (localObject2 == null) {
          d.g.b.k.aVY("mStayTime");
        }
        if (d.g.b.k.g(((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).qoi, paramActivity))
        {
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qoG;
          if (localObject2 == null) {
            d.g.b.k.aVY("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).qol = paramLong;
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qoG;
          if (localObject2 == null) {
            d.g.b.k.aVY("mStayTime");
          }
          com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qoG;
          if (localb == null) {
            d.g.b.k.aVY("mStayTime");
          }
          paramLong = localb.qol;
          localb = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qoG;
          if (localb == null) {
            d.g.b.k.aVY("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).qoj = (paramLong - localb.qok);
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qoG;
          if (localObject2 == null) {
            d.g.b.k.aVY("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).qom = com.tencent.mm.plugin.expt.hellhound.core.b.ciI();
          localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.qoc;
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject1).qoG;
          if (localObject1 == null) {
            d.g.b.k.aVY("mStayTime");
          }
          a.a.a((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1);
          ac.i("HABBYGE-MALI.FinderShareStatistics", "onPagePaused: ".concat(String.valueOf(paramActivity)));
        }
      }
      AppMethodBeat.o(195473);
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
        localObject1 = qnB;
        if (paramActivity == null)
        {
          paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
          AppMethodBeat.o(195473);
          throw paramActivity;
        }
      case -936307702: 
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI")) {
          break;
        }
        localObject1 = qnB;
        if (paramActivity == null)
        {
          paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
          AppMethodBeat.o(195473);
          throw paramActivity;
        }
      case -2013384910: 
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderConversationUI")) {
          break;
        }
        localObject1 = qnB;
        if (paramActivity == null)
        {
          paramActivity = new v("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
          AppMethodBeat.o(195473);
          throw paramActivity;
        }
        ((b)localObject1).b((FragmentActivity)paramActivity, paramLong);
        AppMethodBeat.o(195473);
        return;
        ((b)localObject1).b((FragmentActivity)paramActivity, paramLong);
        AppMethodBeat.o(195473);
        return;
        d.g.b.k.h((FragmentActivity)paramActivity, "activity");
        paramActivity = ((b)localObject1).qmA;
        if (paramActivity != null)
        {
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI");
          if (((com.tencent.mm.plugin.expt.hellhound.a.b.a)paramActivity).qle != null) {}
          for (int i = 1;; i = 0)
          {
            if (i != 0)
            {
              localObject2 = paramActivity.qle;
              if (localObject2 == null) {
                d.g.b.k.aVY("statyTimeStaticLbsList");
              }
              if (d.g.b.k.g(((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).qoi, localObject1))
              {
                localObject1 = paramActivity.qle;
                if (localObject1 == null) {
                  d.g.b.k.aVY("statyTimeStaticLbsList");
                }
                ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).qol = paramLong;
                localObject1 = paramActivity.qle;
                if (localObject1 == null) {
                  d.g.b.k.aVY("statyTimeStaticLbsList");
                }
                paramLong = ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).qol;
                localObject1 = paramActivity.qle;
                if (localObject1 == null) {
                  d.g.b.k.aVY("statyTimeStaticLbsList");
                }
                long l = ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).qok;
                localObject1 = paramActivity.qle;
                if (localObject1 == null) {
                  d.g.b.k.aVY("statyTimeStaticLbsList");
                }
                ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).qoj = (paramLong - l);
                localObject1 = paramActivity.qle;
                if (localObject1 == null) {
                  d.g.b.k.aVY("statyTimeStaticLbsList");
                }
                ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).qon = "143";
                localObject1 = paramActivity.qle;
                if (localObject1 == null) {
                  d.g.b.k.aVY("statyTimeStaticLbsList");
                }
                ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).qom = com.tencent.mm.plugin.expt.hellhound.core.b.ciI();
                localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.qoc;
                paramActivity = paramActivity.qle;
                if (paramActivity == null) {
                  d.g.b.k.aVY("statyTimeStaticLbsList");
                }
                a.a.a(paramActivity);
                ac.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderLbsStreamListUIPause...");
              }
            }
            AppMethodBeat.o(195473);
            return;
          }
        }
        AppMethodBeat.o(195473);
        return;
      }
    }
  }
  
  public static final void f(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(195474);
    Object localObject1;
    Object localObject2;
    if (com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qoN.cjT() == null)
    {
      if (paramActivity == null) {
        break label192;
      }
      localObject1 = paramActivity.getClass();
      if (localObject1 == null) {
        break label192;
      }
      localObject1 = ((Class)localObject1).getName();
      localObject2 = c.qna;
      if (d.a.j.a((Iterable)c.cjO(), localObject1))
      {
        localObject2 = new cct();
        ((cct)localObject2).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cku().cit();
        ((cct)localObject2).qoi = com.tencent.mm.plugin.expt.hellhound.core.b.ZK((String)localObject1);
        if (paramActivity == null) {
          break label198;
        }
      }
    }
    label192:
    label198:
    for (int i = paramActivity.hashCode();; i = 0)
    {
      ((cct)localObject2).aFZ = i;
      ((cct)localObject2).qok = paramLong;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qpX;
      ((cct)localObject2).qon = b.a.ckz();
      ((cct)localObject2).dtw = c.b.qnd.value;
      com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qoN.a((cct)localObject2);
      ac.i("HABBYGE-MALI.FinderShareStatistics", "onStartActivity: " + ((cct)localObject2).qoi + ", " + ((cct)localObject2).aFZ);
      com.tencent.mm.plugin.expt.hellhound.a.b.d.d.h(paramActivity, paramLong);
      AppMethodBeat.o(195474);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public static final void g(Activity paramActivity, long paramLong)
  {
    c.a locala = null;
    AppMethodBeat.i(195475);
    cct localcct = com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qoN.cjT();
    Object localObject1;
    Object localObject2;
    int j;
    if (localcct != null)
    {
      if (paramActivity == null) {
        break label470;
      }
      localObject1 = paramActivity.getClass();
      if (localObject1 == null) {
        break label470;
      }
      localObject1 = ((Class)localObject1).getName();
      localObject2 = c.qna;
      if (d.a.j.a((Iterable)c.cjO(), localObject1))
      {
        localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK((String)localObject1);
        if (d.g.b.k.g(localcct.qoi, localObject1))
        {
          j = localcct.aFZ;
          if (paramActivity == null) {
            break label476;
          }
          i = paramActivity.hashCode();
          label99:
          if (j == i)
          {
            localcct.qol = paramLong;
            long l1 = localcct.qol;
            long l2 = localcct.qok;
            localObject2 = localcct.Frk;
            d.g.b.k.g(localObject2, "statistics.stayTimeOnBackground");
            l2 = l1 - l2 - com.tencent.mm.plugin.expt.hellhound.a.b.d.d.Z((LinkedList)localObject2);
            l1 = l2;
            if (l2 < 0L) {
              l1 = 0L;
            }
            localcct.qoj = l1;
            localcct.qom = com.tencent.mm.plugin.expt.hellhound.core.b.ciI();
            localcct.dtw = c.b.qnd.value;
            localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.qoc;
            a.a.a(com.tencent.mm.plugin.expt.hellhound.a.b.d.d.a(localcct, c.b.qnd.value));
            com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qoN.reset();
            ac.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivity: " + (String)localObject1 + ", " + localcct.aFZ);
          }
        }
      }
    }
    localcct = com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qoN.cjU();
    if (localcct != null)
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
      locala = c.qna;
      if (d.a.j.a((Iterable)c.cjO(), localObject1))
      {
        localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK((String)localObject1);
        if (d.g.b.k.g(localcct.qoi, localObject1))
        {
          j = localcct.aFZ;
          if (paramActivity == null) {
            break label481;
          }
        }
      }
    }
    label470:
    label476:
    label481:
    for (int i = paramActivity.hashCode();; i = 0)
    {
      if (j == i)
      {
        localcct.qol = paramLong;
        localcct.qoj = (localcct.qol - localcct.qok);
        localcct.qom = com.tencent.mm.plugin.expt.hellhound.core.b.ciI();
        localcct.dtw = c.b.qnc.value;
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.qoc;
        a.a.a(com.tencent.mm.plugin.expt.hellhound.a.b.d.d.a(localcct, c.b.qnc.value));
        com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qoN.cjV();
        ac.i("HABBYGE-MALI.FinderShareStatistics", "doOnFinishActivityV2: " + (String)localObject1 + ", " + localcct.aFZ);
      }
      AppMethodBeat.o(195475);
      return;
      localObject1 = null;
      break;
      i = 0;
      break label99;
    }
  }
  
  public static final void sU(long paramLong)
  {
    AppMethodBeat.i(195477);
    cct localcct = com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qoN.cjT();
    int i;
    if (localcct != null)
    {
      LinkedList localLinkedList = localcct.Frk;
      d.g.b.k.g(localLinkedList, "statistics.stayTimeOnBackground");
      if (((Collection)localLinkedList).isEmpty()) {
        break label92;
      }
      i = 1;
      if (i != 0)
      {
        if (localcct.Frk.size() % 2 == 0) {
          break label97;
        }
        localcct.Frk.add(Long.valueOf(paramLong));
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.d.f.qoN.a(localcct);
      com.tencent.mm.plugin.expt.hellhound.a.b.d.d.sV(paramLong);
      AppMethodBeat.o(195477);
      return;
      label92:
      i = 0;
      break;
      label97:
      localcct.Frk.removeLast();
      localcct.Frk.add(Long.valueOf(paramLong));
    }
  }
  
  public final void a(e parame)
  {
    try
    {
      AppMethodBeat.i(195463);
      d.g.b.k.h(parame, "listener");
      if (!mListeners.contains(parame)) {
        mListeners.add(parame);
      }
      AppMethodBeat.o(195463);
      return;
    }
    finally {}
  }
  
  public final void a(l.a parama)
  {
    try
    {
      AppMethodBeat.i(195488);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).a(parama);
      }
      AppMethodBeat.o(195488);
    }
    finally {}
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    try
    {
      AppMethodBeat.i(195485);
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).b(paramRecyclerView, paramInt);
      }
      AppMethodBeat.o(195485);
    }
    finally {}
  }
  
  public final void b(e parame)
  {
    try
    {
      AppMethodBeat.i(195464);
      d.g.b.k.h(parame, "listener");
      mListeners.remove(parame);
      AppMethodBeat.o(195464);
      return;
    }
    finally
    {
      parame = finally;
      throw parame;
    }
  }
  
  public final void bTG()
  {
    try
    {
      AppMethodBeat.i(195489);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(195489);
    }
    finally {}
  }
  
  public final void cjx()
  {
    try
    {
      AppMethodBeat.i(195487);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).cjx();
      }
      AppMethodBeat.o(195487);
    }
    finally {}
  }
  
  public final void cjy()
  {
    try
    {
      AppMethodBeat.i(195490);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).cjy();
      }
      AppMethodBeat.o(195490);
    }
    finally {}
  }
  
  public final void f(RecyclerView paramRecyclerView, int paramInt)
  {
    try
    {
      AppMethodBeat.i(195486);
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).f(paramRecyclerView, paramInt);
      }
      AppMethodBeat.o(195486);
    }
    finally {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerCallback$RecycylerScrollListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "()V", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  static final class a
    implements com.tencent.mm.hellhoundlib.a.c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(195461);
      if ((d.g.b.k.g("onScrollStateChanged", paramString2)) && (d.g.b.k.g("(Landroid/support/v7/widget/RecyclerView;I)V", paramString3)))
      {
        if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
        {
          paramString2 = paramArrayOfObject[0];
          if ((paramString2 instanceof RecyclerView))
          {
            paramString1 = j.qnH;
            paramString2 = (RecyclerView)paramString2;
            paramString3 = paramArrayOfObject[1];
            if (paramString3 == null)
            {
              paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(195461);
              throw paramString1;
            }
            paramString1.b(paramString2, ((Integer)paramString3).intValue());
          }
        }
        AppMethodBeat.o(195461);
        return;
      }
      if ((d.g.b.k.g("onScrolled", paramString2)) && (d.g.b.k.g("(Landroid/support/v7/widget/RecyclerView;II)V", paramString3)) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 3))
      {
        paramString2 = paramArrayOfObject[0];
        if ((paramString2 instanceof RecyclerView))
        {
          paramString1 = j.qnH;
          paramString2 = (RecyclerView)paramString2;
          paramString3 = paramArrayOfObject[1];
          if (paramString3 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(195461);
            throw paramString1;
          }
          ((Integer)paramString3).intValue();
          paramString3 = paramArrayOfObject[2];
          if (paramString3 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(195461);
            throw paramString1;
          }
          paramString1.f(paramString2, ((Integer)paramString3).intValue());
        }
      }
      AppMethodBeat.o(195461);
    }
    
    public final void f(String paramString, Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.j
 * JD-Core Version:    0.7.0.1
 */