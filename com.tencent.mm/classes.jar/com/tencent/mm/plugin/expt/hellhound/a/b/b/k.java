package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.app.Activity;
import android.content.Intent;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.a.g;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.f.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.protocal.protobuf.dhy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerCallback;", "", "()V", "DESC_onScrollStateChanged", "", "DESC_onScrolled", "NAME_onScrollStateChanged", "NAME_onScrolled", "SUPER_NAME", "TAG", "mClickCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback;", "mFinderFragmentCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback;", "mFragmentFeedStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FragmentFeedStatistics;", "mItemDecorationCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback;", "mListener", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "mListeners", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IRecyclerMonitorListener;", "mMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "Lkotlin/collections/HashMap;", "mRefreshLoadMoreCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "mShareStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderShareStatistics;", "mSnsFinderMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/SnsFinderMonitor;", "mWaterfallsFlowMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor;", "begin19943OfsnsFinder", "", "session", "Lcom/tencent/mm/protocal/protobuf/PageSession;", "fragmentFeedFlowOnFree", "activityName", "getCurFragmentOfFinderHomeUI", "Landroidx/fragment/app/Fragment;", "activity", "Landroid/app/Activity;", "monitor", "on7Event", "pageName", "hashCode", "", "timestamp", "", "on8Event", "onActivityCreate", "onFinderHomeUIPaused", "onFinderHomeUIResumed", "onFinishActivity", "onLoadMoreBegin", "onLoadMoreEnd", "className", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "onRefreshBegin", "onRefreshEnd", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "registerClickListener", "listener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "registerFinderFragmentListener", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "registerListener", "startFinderFragmentMonitor", "startFragmentFeedFlowMonitor", "Landroidx/fragment/app/FragmentActivity;", "fragment", "fragmentEventId", "startItemDecorationMonitor", "startMonitorClick", "startSnsFinderMonitor", "sPageName", "startWaterfallsFlowMonitor", "eventId", "stop19943OfsnsFinder", "curSession", "stopFinderFragmentMonitor", "stopFragmentFeedFlowMonitor", "stopItemDecorationMonitor", "stopMonitorClick", "stopSnsFinderMonitor", "stopWaterfallsFlowMonitor", "unregisterClickListener", "unregisterFinderFragmentListener", "unregisterListener", "RecycylerScrollListener", "plugin-expt_release"})
public final class k
{
  private static final List<e> mListeners;
  private static com.tencent.mm.hellhoundlib.a.d wfX;
  private static final HashMap<String, List<Pair<String, String>>> wkb;
  private static final l wlL;
  private static final b wlM;
  private static final m wlN;
  private static final com.tencent.mm.plugin.expt.hellhound.a.b.c wlO;
  private static final com.tencent.mm.plugin.expt.hellhound.a.a.b wlP;
  private static final com.tencent.mm.plugin.expt.hellhound.a.b.d.d wlQ;
  private static final a wlR;
  private static final n wlS;
  public static final k wlT;
  
  static
  {
    AppMethodBeat.i(253534);
    wlT = new k();
    wkb = new HashMap();
    mListeners = (List)new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V"));
    localArrayList.add(Pair.create("onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V"));
    ((Map)wkb).put("androidx/recyclerview/widget/RecyclerView$OnScrollListener", localArrayList);
    wfX = (com.tencent.mm.hellhoundlib.a.d)new a();
    wlL = new l();
    wlM = new b();
    wlN = new m();
    wlO = new com.tencent.mm.plugin.expt.hellhound.a.b.c();
    wlP = new com.tencent.mm.plugin.expt.hellhound.a.a.b();
    wlQ = new com.tencent.mm.plugin.expt.hellhound.a.b.d.d();
    wlR = new a();
    wlS = new n();
    AppMethodBeat.o(253534);
  }
  
  public static void Xr()
  {
    AppMethodBeat.i(253472);
    Log.i("HABBYGE-MALI.RecyclerCallback", "monitor...");
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a((Map)wkb, wfX);
    Object localObject1 = wlN;
    Log.i("HABBYGE-MALI.RefreshLoadMoreCallback", "startMonitor...");
    Object localObject2 = new i();
    Log.i("HABBYGE-MALI.RLBeginCallback", "startMonitor...");
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a((Map)((i)localObject2).wkb, (com.tencent.mm.hellhoundlib.a.d)((i)localObject2).wlF);
    localObject2 = new j((m)localObject1);
    Log.i("HABBYGE-MALI.RLEndCallback", "startMonitor...");
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a((Map)((j)localObject2).wkb, (com.tencent.mm.hellhoundlib.a.d)((j)localObject2).wlH);
    localObject1 = new o((m)localObject1);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a((Map)((o)localObject1).wkb, (com.tencent.mm.hellhoundlib.a.d)((o)localObject1).wmm);
    new h();
    com.tencent.mm.plugin.expt.hellhound.a.b.d.f.wnd.reset();
    com.tencent.mm.plugin.expt.hellhound.a.b.d.f.wnd.del();
    AppMethodBeat.o(253472);
  }
  
  public static final void a(Activity paramActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(253508);
    com.tencent.mm.plugin.expt.hellhound.a.b.c localc = wlO;
    Object localObject;
    if (paramFragment == null) {
      if (paramActivity != null)
      {
        localObject = paramActivity.getClass();
        if (localObject != null)
        {
          localObject = ((Class)localObject).getName();
          c.a locala = c.wkV;
          if (!c.ddX().contains(localObject)) {
            break label367;
          }
          Log.i("HABBYGE-MALI.WaterfallsFlowMonitor", "monitor: poageName=".concat(String.valueOf(localObject)));
          localc.wiB = ((String)localObject);
          wlT.a((e)localc.wiD);
          localc.wiC = new com.tencent.mm.plugin.expt.hellhound.a.b.d.j(paramActivity, paramFragment);
          localObject = localc.wiC;
          if (localObject == null) {
            break label367;
          }
          if (paramFragment != null) {
            break label270;
          }
          if (paramActivity == null) {
            break label234;
          }
          paramFragment = paramActivity.getClass();
          if (paramFragment == null) {
            break label234;
          }
          paramFragment = paramFragment.getName();
          label139:
          if (!p.h(paramFragment, c.wkL)) {
            break label251;
          }
          if (!p.h(paramFragment, c.wkN)) {
            break label239;
          }
          Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: 7Event !!");
          ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).k(paramActivity, paramLong);
          label175:
          c.wkM = null;
          c.wkL = null;
        }
      }
    }
    for (;;)
    {
      paramActivity = (d)((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).wnD.wmQ;
      p.k(paramActivity, "listener");
      wlR.a(paramActivity);
      AppMethodBeat.o(253508);
      return;
      localObject = null;
      break;
      localObject = paramFragment.getClass().getName();
      break;
      label234:
      paramFragment = null;
      break label139;
      label239:
      Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: startActivity !!");
      break label175;
      label251:
      Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: Back to activity !!");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).k(paramActivity, paramLong);
      break label175;
      switch (paramInt)
      {
      case 1: 
      default: 
        Log.printErrStackTrace("HABBYGE-MALI.WaterfallsFlowStatistics", (Throwable)new NullPointerException("startCompute, fragment, miss !!"), "", new Object[0]);
        break;
      case 0: 
        Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, resume !!");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).k(paramFragment, paramLong);
        break;
      case 2: 
        label270:
        Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, 7Event !!");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).k(paramFragment, paramLong);
      }
    }
    label367:
    AppMethodBeat.o(253508);
  }
  
  public static void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(253523);
    p.k(paramFragmentActivity, "activity");
    p.k(paramFragment, "fragment");
    com.tencent.mm.plugin.expt.hellhound.a.a.b localb = wlP;
    p.k(paramFragmentActivity, "activity");
    p.k(paramFragment, "fragment");
    paramFragment = paramFragment.getClass().getName();
    p.j(paramFragment, "fragment.javaClass.name");
    Log.d("HABBYGE-MALI.FragmentFeedStatistics", "start: fragment:" + paramFragment + ", event=" + paramInt);
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
            AppMethodBeat.o(253523);
            return;
          } while (!paramFragment.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment"));
          if (localb.whA == null) {
            localb.whA = ((com.tencent.mm.plugin.expt.hellhound.a.b.a.o)new com.tencent.mm.plugin.expt.hellhound.a.b.a.f((Activity)paramFragmentActivity));
          }
          paramFragmentActivity = localb.whA;
          if (paramFragmentActivity == null) {
            break;
          }
          paramFragmentActivity.startMonitor();
          AppMethodBeat.o(253523);
          return;
        } while (!paramFragment.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment"));
        if (localb.whC == null) {
          localb.whC = ((com.tencent.mm.plugin.expt.hellhound.a.b.a.o)new com.tencent.mm.plugin.expt.hellhound.a.b.a.j((Activity)paramFragmentActivity));
        }
        paramFragmentActivity = localb.whC;
      } while (paramFragmentActivity == null);
      paramFragmentActivity.startMonitor();
      AppMethodBeat.o(253523);
      return;
    } while (!paramFragment.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment"));
    if (localb.whB == null) {
      localb.whB = ((com.tencent.mm.plugin.expt.hellhound.a.b.a.o)new g((Activity)paramFragmentActivity));
    }
    paramFragmentActivity = localb.whB;
    if (paramFragmentActivity != null)
    {
      paramFragmentActivity.startMonitor();
      AppMethodBeat.o(253523);
      return;
      AppMethodBeat.o(253523);
      return;
    }
    AppMethodBeat.o(253523);
  }
  
  public static final void a(com.tencent.mm.plugin.expt.hellhound.core.d paramd)
  {
    AppMethodBeat.i(253488);
    p.k(paramd, "listener");
    Object localObject = wlM;
    p.k(paramd, "listener");
    localObject = ((b)localObject).wjW;
    if (localObject != null)
    {
      p.k(paramd, "listener");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject).wfT = paramd;
      AppMethodBeat.o(253488);
      return;
    }
    AppMethodBeat.o(253488);
  }
  
  public static final void a(dhx paramdhx)
  {
    AppMethodBeat.i(253519);
    n.c(paramdhx);
    AppMethodBeat.o(253519);
  }
  
  public static final Fragment ac(Activity paramActivity)
  {
    Object localObject2 = null;
    AppMethodBeat.i(253491);
    b localb = wlM;
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
      AppMethodBeat.o(253491);
      return paramActivity;
      label53:
      p.j(paramActivity, "activity?.javaClass?.name ?: return null");
      if ((p.h(paramActivity, "com.tencent.mm.plugin.finder.ui.FinderHomeUI") ^ true))
      {
        localObject1 = localObject2;
        if ((p.h(paramActivity, "com.tencent.mm.plugin.finder.ui.FinderConversationUI") ^ true)) {}
      }
      else
      {
        localObject1 = localb.p(null, -1);
      }
    }
  }
  
  public static final void axN(String paramString)
  {
    AppMethodBeat.i(253482);
    l locall = wlL;
    if (!l.axW(paramString))
    {
      Log.i("HABBYGE-MALI.RecyclerItemDecorationCallback", "monitor");
      paramString = locall.whW;
      if (paramString != null) {
        paramString.clear();
      }
      com.tencent.mm.hellhoundlib.a.aFg();
      com.tencent.mm.hellhoundlib.a.c((Map)locall.wkb, (com.tencent.mm.hellhoundlib.a.d)locall.wlU);
    }
    AppMethodBeat.o(253482);
  }
  
  public static final void axO(String paramString)
  {
    AppMethodBeat.i(253484);
    l locall = wlL;
    if (!l.axW(paramString))
    {
      Log.i("HABBYGE-MALI.RecyclerItemDecorationCallback", "unmonitor");
      paramString = locall.whW;
      if (paramString != null)
      {
        paramString = (RecyclerView)paramString.get();
        if (paramString != null) {
          paramString.b((RecyclerView.l)locall.wlV);
        }
      }
      paramString = locall.whW;
      if (paramString != null) {
        paramString.clear();
      }
      locall.whW = null;
      com.tencent.mm.hellhoundlib.a.aFg();
      com.tencent.mm.hellhoundlib.a.d((Map)locall.wkb, (com.tencent.mm.hellhoundlib.a.d)locall.wlU);
    }
    AppMethodBeat.o(253484);
  }
  
  public static final void axP(String paramString)
  {
    AppMethodBeat.i(253485);
    b localb = wlM;
    localb.wjS = paramString;
    if ((!(p.h("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString) ^ true)) || (!(p.h("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString) ^ true)))
    {
      Log.i("HABBYGE-MALI.FinderFragmentCallback", "monitor...");
      localb.lL = -1;
      localb.wjU = true;
      localb.wjV = false;
      com.tencent.mm.hellhoundlib.a.aFg();
      com.tencent.mm.hellhoundlib.a.c((Map)localb.wkb, (com.tencent.mm.hellhoundlib.a.d)localb.wkc);
    }
    AppMethodBeat.o(253485);
  }
  
  public static final void axQ(String paramString)
  {
    AppMethodBeat.i(253487);
    b localb = wlM;
    localb.wjT = paramString;
    if ((!(p.h("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString) ^ true)) || (!(p.h("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString) ^ true)))
    {
      Log.i("HABBYGE-MALI.FinderFragmentCallback", "unmonitor...");
      localb.wjU = false;
      localb.wjV = true;
      com.tencent.mm.hellhoundlib.a.aFg();
      com.tencent.mm.hellhoundlib.a.d((Map)localb.wkb, (com.tencent.mm.hellhoundlib.a.d)localb.wkc);
    }
    AppMethodBeat.o(253487);
  }
  
  public static final void axR(String paramString)
  {
    AppMethodBeat.i(253513);
    if ((p.h("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (p.h("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)))
    {
      paramString = wlP;
      Log.i("HABBYGE-MALI.FragmentFeedStatistics", "stop: free...");
      com.tencent.mm.plugin.expt.hellhound.a.b.a.o localo = paramString.whA;
      if (localo != null) {
        localo.free();
      }
      paramString.whA = null;
      localo = paramString.whB;
      if (localo != null) {
        localo.free();
      }
      paramString.whB = null;
      localo = paramString.whC;
      if (localo != null) {
        localo.free();
      }
      paramString.whC = null;
    }
    AppMethodBeat.o(253513);
  }
  
  public static final void axS(String paramString)
  {
    AppMethodBeat.i(253515);
    if ((p.h("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (p.h("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)))
    {
      wlR.Xr();
      AppMethodBeat.o(253515);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.wov;
    localObject = b.a.deK();
    if (((p.h(localObject, "999")) || (p.h(localObject, "101")) || (p.h(localObject, "102")) || (p.h(localObject, "123"))) && ((p.h("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", paramString)) || (p.h("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", paramString)) || (p.h("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", paramString)))) {
      wlR.Xr();
    }
    AppMethodBeat.o(253515);
  }
  
  public static final void axT(String paramString)
  {
    AppMethodBeat.i(253517);
    if (paramString == null)
    {
      AppMethodBeat.o(253517);
      return;
    }
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(253517);
      return;
      if (paramString.equals("SnsTimeLineUI"))
      {
        wlS.Xr();
        AppMethodBeat.o(253517);
        return;
        if (paramString.equals("com.tencent.mm.plugin.sns.ui.SnsTimeLineUI")) {
          wlS.Xr();
        }
      }
    }
  }
  
  public static final void axU(String paramString)
  {
    AppMethodBeat.i(253518);
    if ((p.h("SnsTimeLineUI", paramString)) || (p.h("com.tencent.mm.plugin.sns.ui.SnsTimeLineUI", paramString))) {
      wlS.ddy();
    }
    AppMethodBeat.o(253518);
  }
  
  public static final void axV(String paramString)
  {
    AppMethodBeat.i(253521);
    if ((p.h("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (p.h("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)))
    {
      wlR.ddy();
      AppMethodBeat.o(253521);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.wov;
    localObject = b.a.deK();
    if (((p.h(localObject, "999")) || (p.h(localObject, "101")) || (p.h(localObject, "102")) || (p.h(localObject, "123"))) && ((p.h("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", paramString)) || (p.h("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", paramString)) || (p.h("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", paramString)))) {
      wlR.ddy();
    }
    AppMethodBeat.o(253521);
  }
  
  public static final void b(Activity paramActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(253511);
    com.tencent.mm.plugin.expt.hellhound.a.b.c localc = wlO;
    Object localObject;
    if (paramFragment == null) {
      if (paramActivity != null)
      {
        localObject = paramActivity.getClass();
        if (localObject != null)
        {
          localObject = ((Class)localObject).getName();
          c.a locala = c.wkV;
          if (c.ddX().contains(localObject))
          {
            Log.i("HABBYGE-MALI.WaterfallsFlowMonitor", "unmonitor: poageName=".concat(String.valueOf(localObject)));
            wlT.b((e)localc.wiD);
            localObject = localc.wiC;
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
              Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: pageName=".concat(String.valueOf(paramFragment)));
              if (!p.h(paramFragment, c.wkM)) {
                break label243;
              }
              Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: finish cur page !");
              ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).wnx = 1;
              paramInt = 1;
              label162:
              ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).l(paramActivity, paramLong);
              if (paramInt != 0)
              {
                paramActivity = c.wkV;
                c.a.ded();
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      paramActivity = (d)((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).wnD.wmQ;
      p.k(paramActivity, "listener");
      wlR.b(paramActivity);
      localc.wiC = null;
      AppMethodBeat.o(253511);
      return;
      localObject = null;
      break;
      localObject = paramFragment.getClass().getName();
      break;
      label238:
      paramFragment = null;
      break label118;
      label243:
      if (((p.h(paramFragment, c.wkL) ^ true)) && (c.wkL != null))
      {
        Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: startActivity another page !");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).wnx = 1;
        paramInt = 0;
        break label162;
      }
      Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: 8Event !");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).wnx = 2;
      paramInt = 0;
      break label162;
      switch (paramInt)
      {
      case 2: 
      default: 
        Log.printErrStackTrace("HABBYGE-MALI.WaterfallsFlowStatistics", (Throwable)new NullPointerException("startCompute, fragment, miss !!"), "", new Object[0]);
        break;
      case 1: 
        Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, pause !!");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).wnx = 1;
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).l(paramFragment, paramLong);
        break;
      case 3: 
        label303:
        Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, 8Event !!");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).wnx = 2;
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).l(paramFragment, paramLong);
      }
    }
  }
  
  public static void b(FragmentActivity paramFragmentActivity, Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(253524);
    p.k(paramFragmentActivity, "activity");
    p.k(paramFragment, "fragment");
    com.tencent.mm.plugin.expt.hellhound.a.a.b localb = wlP;
    p.k(paramFragmentActivity, "activity");
    p.k(paramFragment, "fragment");
    paramFragmentActivity = paramFragment.getClass().getName();
    p.j(paramFragmentActivity, "fragment.javaClass.name");
    Log.d("HABBYGE-MALI.FragmentFeedStatistics", "stop: fragment:" + paramFragmentActivity + ", event=" + paramInt);
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
            AppMethodBeat.o(253524);
            return;
          } while (!paramFragmentActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment"));
          paramFragmentActivity = localb.whA;
          if (paramFragmentActivity == null) {
            break;
          }
          paramFragmentActivity.stopMonitor();
          AppMethodBeat.o(253524);
          return;
        } while (!paramFragmentActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment"));
        paramFragmentActivity = localb.whC;
      } while (paramFragmentActivity == null);
      paramFragmentActivity.stopMonitor();
      AppMethodBeat.o(253524);
      return;
    } while (!paramFragmentActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment"));
    paramFragmentActivity = localb.whB;
    if (paramFragmentActivity != null)
    {
      paramFragmentActivity.stopMonitor();
      AppMethodBeat.o(253524);
      return;
      AppMethodBeat.o(253524);
      return;
    }
    AppMethodBeat.o(253524);
  }
  
  public static final void b(dhx paramdhx)
  {
    AppMethodBeat.i(253520);
    n.d(paramdhx);
    AppMethodBeat.o(253520);
  }
  
  public static final void d(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(253494);
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
          break label135;
        }
        locald = wlQ;
        if (paramActivity != null)
        {
          localObject1 = paramActivity.getClass().getName();
          p.j(localObject1, "activity.javaClass.name");
          localObject2 = c.wkV;
          if ((c.ddW().contains(localObject1)) && (locald.wmW == null))
          {
            localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.awD((String)localObject1);
            if (localObject3 != null) {
              break label513;
            }
          }
        }
      }
    }
    label513:
    for (;;)
    {
      if (paramActivity != null)
      {
        localObject1 = paramActivity.getClass();
        if (localObject1 != null)
        {
          localObject2 = ((Class)localObject1).getName();
          if (localObject2 != null) {
            break label729;
          }
        }
      }
      AppMethodBeat.o(253494);
      return;
      localObject1 = null;
      break;
      label135:
      switch (((String)localObject1).hashCode())
      {
      default: 
        break;
      case -2055689330: 
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderHomeUI")) {
          break;
        }
        localObject1 = wlM;
        if (paramActivity == null)
        {
          paramActivity = new t("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
          AppMethodBeat.o(253494);
          throw paramActivity;
        }
      case -936307702: 
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI")) {
          break;
        }
        localObject1 = wlM;
        if (paramActivity == null)
        {
          paramActivity = new t("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
          AppMethodBeat.o(253494);
          throw paramActivity;
        }
      case -2013384910: 
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderConversationUI")) {
          break;
        }
        localObject1 = wlM;
        if (paramActivity == null)
        {
          paramActivity = new t("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
          AppMethodBeat.o(253494);
          throw paramActivity;
        }
        ((b)localObject1).b((FragmentActivity)paramActivity, paramLong);
        AppMethodBeat.o(253494);
        return;
        ((b)localObject1).b((FragmentActivity)paramActivity, paramLong);
        AppMethodBeat.o(253494);
        return;
        p.k((FragmentActivity)paramActivity, "activity");
        paramActivity = ((b)localObject1).wjW;
        if (paramActivity != null)
        {
          paramActivity.wiz = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
          localObject1 = paramActivity.wiz;
          if (localObject1 == null) {
            p.bGy("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.deO().dbr();
          localObject1 = paramActivity.wiz;
          if (localObject1 == null) {
            p.bGy("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).fFe = com.tencent.mm.plugin.expt.hellhound.core.b.awD("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI");
          localObject1 = paramActivity.wiz;
          if (localObject1 == null) {
            p.bGy("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).wmx = paramLong;
          localObject1 = paramActivity.wiz;
          if (localObject1 == null) {
            p.bGy("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).wmA = "143";
          paramActivity = paramActivity.wiz;
          if (paramActivity == null) {
            p.bGy("statyTimeStaticLbsList");
          }
          paramActivity.fSe = c.b.wkW.value;
          Log.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderLbsStreamListUIResume...");
          AppMethodBeat.o(253494);
          return;
        }
        AppMethodBeat.o(253494);
        return;
        p.j(localObject3, "HellhoundUtil.getShortNa…fPage(pageName) ?: return");
        int i = paramActivity.hashCode();
        localObject2 = paramActivity.getIntent().getStringExtra("key_extra_info");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        com.tencent.mm.plugin.expt.hellhound.a.b.d.d.a((String)localObject3, i, paramLong, (String)localObject1);
        Log.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV2, sPage=" + (String)localObject3 + ", hashCode=" + i);
        if (com.tencent.mm.plugin.expt.hellhound.a.b.d.f.wnd.dH((String)localObject3, i) == null)
        {
          localObject2 = new dhy();
          ((dhy)localObject2).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.deO().dbr();
          ((dhy)localObject2).fFe = ((String)localObject3);
          ((dhy)localObject2).aNf = i;
          ((dhy)localObject2).wmx = paramLong;
          b.a locala = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.wov;
          ((dhy)localObject2).wmA = b.a.deK();
          ((dhy)localObject2).fSe = c.b.wkX.value;
          ((dhy)localObject2).extraInfo = ((String)localObject1);
          com.tencent.mm.plugin.expt.hellhound.a.b.d.f.wnd.c((dhy)localObject2);
          Log.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV2, YES, sPage=" + (String)localObject3 + ", hashCode=" + i);
          locald.wmW = ((String)localObject3);
        }
        break;
      }
    }
    label729:
    p.j(localObject2, "activity?.javaClass?.name ?: return");
    Object localObject1 = c.wkV;
    boolean bool;
    if ((c.ddV().contains(localObject2)) && ((locald.wmV == null) || (!(p.h(localObject2, locald.wmV) ^ true))))
    {
      locald.wmV = ((String)localObject2);
      locald.wmU = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
      localObject1 = locald.wmU;
      if (localObject1 == null) {
        p.bGy("mStayTime");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.deO().dbr();
      localObject1 = locald.wmU;
      if (localObject1 == null) {
        p.bGy("mStayTime");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).fFe = com.tencent.mm.plugin.expt.hellhound.core.b.awD((String)localObject2);
      localObject1 = locald.wmU;
      if (localObject1 == null) {
        p.bGy("mStayTime");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).wmx = paramLong;
      localObject1 = locald.wmU;
      if (localObject1 == null) {
        p.bGy("mStayTime");
      }
      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.wov;
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).wmA = b.a.deK();
      localObject1 = locald.wmU;
      if (localObject1 == null) {
        p.bGy("mStayTime");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).fSe = c.b.wkW.value;
      localObject3 = locald.wmU;
      if (localObject3 == null) {
        p.bGy("mStayTime");
      }
      localObject1 = paramActivity.getIntent().getStringExtra("key_extra_info");
      paramActivity = (Activity)localObject1;
      if (localObject1 == null) {
        paramActivity = "";
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).extraInfo = paramActivity;
      if (!p.h(localObject2, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
        break label1097;
      }
      paramActivity = locald.wmU;
      if (paramActivity == null) {
        p.bGy("mStayTime");
      }
      localObject1 = c.wkV;
      if (c.ddY() != c.d.wlg.value) {
        break label1091;
      }
      bool = true;
    }
    for (paramActivity.wmB = bool;; paramActivity.wmB = false)
    {
      paramActivity = new StringBuilder("doPageResume: ");
      localObject1 = locald.wmU;
      if (localObject1 == null) {
        p.bGy("mStayTime");
      }
      Log.i("HABBYGE-MALI.FinderShareStatistics", ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).fFe);
      AppMethodBeat.o(253494);
      return;
      label1091:
      bool = false;
      break;
      label1097:
      paramActivity = locald.wmU;
      if (paramActivity == null) {
        p.bGy("mStayTime");
      }
    }
  }
  
  public static final Fragment ddc()
  {
    AppMethodBeat.i(253489);
    b localb = wlM;
    Object localObject1 = localb.wjW;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).wiw;
      if (localObject1 != null)
      {
        localObject1 = (Fragment)((WeakReference)localObject1).get();
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject1 = localb.wjX;
          if (localObject1 == null) {
            break label87;
          }
        }
      }
    }
    label87:
    for (localObject1 = (UIComponentActivity)((WeakReference)localObject1).get();; localObject1 = null)
    {
      localObject2 = (Fragment)localb.p(localObject1, -1);
      AppMethodBeat.o(253489);
      return localObject2;
      localObject1 = null;
      break;
      localObject1 = null;
      break;
    }
  }
  
  public static final void deh() {}
  
  public static final void e(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(253498);
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
            localObject2 = wlQ;
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
            AppMethodBeat.o(253498);
            return;
            localObject1 = null;
            break;
            switch (((String)localObject1).hashCode())
            {
            }
          }
        } while (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderHomeUI"));
        localObject1 = wlM;
        if (paramActivity != null) {
          break label253;
        }
        paramActivity = new t("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        AppMethodBeat.o(253498);
        throw paramActivity;
      } while (!((String)localObject1).equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
      localObject1 = wlM;
      if (paramActivity != null) {
        break label270;
      }
      paramActivity = new t("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
      AppMethodBeat.o(253498);
      throw paramActivity;
    } while (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderConversationUI"));
    Object localObject1 = wlM;
    if (paramActivity == null)
    {
      paramActivity = new t("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
      AppMethodBeat.o(253498);
      throw paramActivity;
    }
    ((b)localObject1).c((FragmentActivity)paramActivity, paramLong);
    AppMethodBeat.o(253498);
    return;
    label253:
    ((b)localObject1).c((FragmentActivity)paramActivity, paramLong);
    AppMethodBeat.o(253498);
    return;
    label270:
    p.k((FragmentActivity)paramActivity, "activity");
    paramActivity = ((b)localObject1).wjW;
    if (paramActivity != null)
    {
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.awD("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI");
      if (((com.tencent.mm.plugin.expt.hellhound.a.b.b)paramActivity).wiz != null) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          localObject2 = paramActivity.wiz;
          if (localObject2 == null) {
            p.bGy("statyTimeStaticLbsList");
          }
          if (p.h(((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).fFe, localObject1))
          {
            localObject1 = paramActivity.wiz;
            if (localObject1 == null) {
              p.bGy("statyTimeStaticLbsList");
            }
            ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).wmy = paramLong;
            localObject1 = paramActivity.wiz;
            if (localObject1 == null) {
              p.bGy("statyTimeStaticLbsList");
            }
            paramLong = ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).wmy;
            localObject1 = paramActivity.wiz;
            if (localObject1 == null) {
              p.bGy("statyTimeStaticLbsList");
            }
            long l = ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).wmx;
            localObject1 = paramActivity.wiz;
            if (localObject1 == null) {
              p.bGy("statyTimeStaticLbsList");
            }
            ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).wmw = (paramLong - l);
            localObject1 = paramActivity.wiz;
            if (localObject1 == null) {
              p.bGy("statyTimeStaticLbsList");
            }
            ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).wmA = "143";
            localObject1 = paramActivity.wiz;
            if (localObject1 == null) {
              p.bGy("statyTimeStaticLbsList");
            }
            ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).wmz = com.tencent.mm.plugin.expt.hellhound.core.b.dct();
            localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.wmq;
            paramActivity = paramActivity.wiz;
            if (paramActivity == null) {
              p.bGy("statyTimeStaticLbsList");
            }
            a.a.a(paramActivity);
            Log.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderLbsStreamListUIPause...");
          }
        }
        AppMethodBeat.o(253498);
        return;
      }
    }
    AppMethodBeat.o(253498);
    return;
    label542:
    p.j(localObject1, "activity?.javaClass?.name ?: return");
    Object localObject3 = c.wkV;
    if (c.ddV().contains(localObject1))
    {
      if (((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).wmV == null)
      {
        AppMethodBeat.o(253498);
        return;
      }
      if (!(p.h(localObject1, ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).wmV) ^ true))
      {
        if (((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).wmW == null) {
          ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).wmV = null;
        }
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.awD((String)localObject1);
        localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).wmU;
        if (localObject1 == null) {
          p.bGy("mStayTime");
        }
        if (p.h(((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).fFe, localObject3))
        {
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).wmU;
          if (localObject1 == null) {
            p.bGy("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).wmy = paramLong;
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).wmU;
          if (localObject1 == null) {
            p.bGy("mStayTime");
          }
          com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).wmU;
          if (localb == null) {
            p.bGy("mStayTime");
          }
          paramLong = localb.wmy;
          localb = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).wmU;
          if (localb == null) {
            p.bGy("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).wmw = (paramLong - localb.wmx);
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).wmU;
          if (localObject1 == null) {
            p.bGy("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).wmz = com.tencent.mm.plugin.expt.hellhound.core.b.dct();
          localb = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).wmU;
          if (localb == null) {
            p.bGy("mStayTime");
          }
          localObject1 = paramActivity.getIntent().getStringExtra("key_enter_source_info");
          paramActivity = (Activity)localObject1;
          if (localObject1 == null) {
            paramActivity = "";
          }
          localb.wmC = paramActivity;
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.wmq;
          paramActivity = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).wmU;
          if (paramActivity == null) {
            p.bGy("mStayTime");
          }
          a.a.a(paramActivity);
          Log.i("HABBYGE-MALI.FinderShareStatistics", "onPagePaused: ".concat(String.valueOf(localObject3)));
        }
      }
    }
    AppMethodBeat.o(253498);
  }
  
  public static final void f(Activity paramActivity, long paramLong)
  {
    long l1 = 0L;
    AppMethodBeat.i(253503);
    Object localObject3 = wlQ;
    if (paramActivity == null)
    {
      AppMethodBeat.o(253503);
      return;
    }
    Object localObject1 = paramActivity.getClass().getName();
    p.j(localObject1, "activity.javaClass.name");
    Object localObject2 = c.wkV;
    if (c.ddW().contains(localObject1))
    {
      localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.awD((String)localObject1);
      if (localObject2 == null)
      {
        AppMethodBeat.o(253503);
        return;
      }
      p.j(localObject2, "HellhoundUtil.getShortNa…fPage(pageName) ?: return");
      int i = paramActivity.hashCode();
      localObject1 = paramActivity.getIntent().getStringExtra("key_enter_source_info");
      paramActivity = (Activity)localObject1;
      if (localObject1 == null) {
        paramActivity = "";
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject3).wmW = null;
      Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV1: sPage=" + (String)localObject2 + ", hashCode=" + i + ", enterSourceInfo=" + paramActivity);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.d.f.wnd.dF((String)localObject2, i);
      if (localObject1 == null)
      {
        Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV2: sPage=" + (String)localObject2 + ", hashCode=" + i + ", enterSourceInfo=" + paramActivity);
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.d.f.wnd.dH((String)localObject2, i);
        if (localObject1 == null) {
          AppMethodBeat.o(253503);
        }
      }
      else
      {
        Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV1: compare, " + ((dhy)localObject1).fFe + " == " + (String)localObject2 + ", " + ((dhy)localObject1).aNf + " == " + i);
        ((dhy)localObject1).wmy = paramLong;
        long l2 = ((dhy)localObject1).wmy;
        long l3 = ((dhy)localObject1).wmx;
        localObject3 = ((dhy)localObject1).TPe;
        p.j(localObject3, "statistics.stayTimeOnBackground");
        l2 = l2 - l3 - com.tencent.mm.plugin.expt.hellhound.a.b.d.d.Z((LinkedList)localObject3);
        if (l2 < 0L) {}
        for (;;)
        {
          ((dhy)localObject1).wmw = l1;
          ((dhy)localObject1).wmz = com.tencent.mm.plugin.expt.hellhound.core.b.dct();
          ((dhy)localObject1).fSe = c.b.wkY.value;
          ((dhy)localObject1).wmC = paramActivity;
          localObject3 = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.wmq;
          a.a.a(com.tencent.mm.plugin.expt.hellhound.a.b.d.d.a((dhy)localObject1, c.b.wkY.value));
          com.tencent.mm.plugin.expt.hellhound.a.b.d.f.wnd.dG((String)localObject2, i);
          Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV1: report, " + (String)localObject2 + ", " + i);
          break;
          l1 = l2;
        }
      }
      Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV2: compare, " + ((dhy)localObject1).fFe + " == " + (String)localObject2 + ", " + ((dhy)localObject1).aNf + " == " + i);
      ((dhy)localObject1).wmy = paramLong;
      ((dhy)localObject1).wmw = (((dhy)localObject1).wmy - ((dhy)localObject1).wmx);
      ((dhy)localObject1).wmz = com.tencent.mm.plugin.expt.hellhound.core.b.dct();
      ((dhy)localObject1).fSe = c.b.wkX.value;
      ((dhy)localObject1).wmC = paramActivity;
      paramActivity = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.wmq;
      a.a.a(com.tencent.mm.plugin.expt.hellhound.a.b.d.d.a((dhy)localObject1, c.b.wkX.value));
      com.tencent.mm.plugin.expt.hellhound.a.b.d.f.wnd.dI((String)localObject2, i);
      Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV2: report, " + (String)localObject2 + ", " + i);
    }
    AppMethodBeat.o(253503);
  }
  
  public static final void n(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(253504);
    com.tencent.mm.plugin.expt.hellhound.a.b.d.d.q(paramString, paramInt, paramLong);
    Log.i("HABBYGE-MALI.FinderShareStatistics", "on8EventV2: pageName=" + paramString + ", hashCode=" + paramInt);
    if (com.tencent.mm.plugin.expt.hellhound.core.b.awy(paramString))
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.d.f.wnd.del();
      AppMethodBeat.o(253504);
      return;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.a.b.d.f.wnd.dek();
    if (paramString == null)
    {
      AppMethodBeat.o(253504);
      return;
    }
    paramString.wmy = paramLong;
    paramString.wmw = (paramString.wmy - paramString.wmx);
    paramString.wmz = com.tencent.mm.plugin.expt.hellhound.core.b.dct();
    paramString.fSe = c.b.wkX.value;
    Log.i("HABBYGE-MALI.FinderShareStatistics", "on8EventV2, statics: " + paramString.fFe + ", " + paramString.aNf);
    a.a locala = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.wmq;
    a.a.a(com.tencent.mm.plugin.expt.hellhound.a.b.d.d.a(paramString, c.b.wkX.value));
    paramString.fSe = 8;
    com.tencent.mm.plugin.expt.hellhound.a.b.d.f.wnd.d(paramString);
    AppMethodBeat.o(253504);
  }
  
  public static final void o(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(253505);
    com.tencent.mm.plugin.expt.hellhound.a.b.d.d.p(paramString, paramInt, paramLong);
    com.tencent.mm.plugin.expt.hellhound.a.b.d.d.r(paramString, paramInt, paramLong);
    AppMethodBeat.o(253505);
  }
  
  public final void a(e parame)
  {
    try
    {
      AppMethodBeat.i(253476);
      p.k(parame, "listener");
      if (!mListeners.contains(parame)) {
        mListeners.add(parame);
      }
      AppMethodBeat.o(253476);
      return;
    }
    finally {}
  }
  
  public final void a(m.a parama)
  {
    try
    {
      AppMethodBeat.i(253531);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).a(parama);
      }
      AppMethodBeat.o(253531);
    }
    finally {}
  }
  
  public final void b(e parame)
  {
    try
    {
      AppMethodBeat.i(253479);
      p.k(parame, "listener");
      mListeners.remove(parame);
      AppMethodBeat.o(253479);
      return;
    }
    finally
    {
      parame = finally;
      throw parame;
    }
  }
  
  public final void cKQ()
  {
    try
    {
      AppMethodBeat.i(253532);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(253532);
    }
    finally {}
  }
  
  public final void d(RecyclerView paramRecyclerView, int paramInt)
  {
    try
    {
      AppMethodBeat.i(253528);
      p.k(paramRecyclerView, "recyclerView");
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).d(paramRecyclerView, paramInt);
      }
      AppMethodBeat.o(253528);
    }
    finally {}
  }
  
  public final void ddw()
  {
    try
    {
      AppMethodBeat.i(253530);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).ddw();
      }
      AppMethodBeat.o(253530);
    }
    finally {}
  }
  
  public final void ddx()
  {
    try
    {
      AppMethodBeat.i(253533);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).ddx();
      }
      AppMethodBeat.o(253533);
    }
    finally {}
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    try
    {
      AppMethodBeat.i(253526);
      p.k(paramRecyclerView, "recyclerView");
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).onScrollStateChanged(paramRecyclerView, paramInt);
      }
      AppMethodBeat.o(253526);
    }
    finally {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerCallback$RecycylerScrollListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "()V", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  static final class a
    implements com.tencent.mm.hellhoundlib.a.d
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(256348);
      if ((paramString1 != null) && (kotlin.n.n.M(paramString1, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$", false)))
      {
        AppMethodBeat.o(256348);
        return;
      }
      if ((p.h("onScrollStateChanged", paramString2)) && (p.h("(Landroidx/recyclerview/widget/RecyclerView;I)V", paramString3)))
      {
        if (paramArrayOfObject != null)
        {
          if (paramArrayOfObject.length >= 2)
          {
            paramString2 = paramArrayOfObject[0];
            if ((paramString2 instanceof RecyclerView))
            {
              paramString1 = k.wlT;
              paramString2 = (RecyclerView)paramString2;
              paramString3 = paramArrayOfObject[1];
              if (paramString3 == null)
              {
                paramString1 = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(256348);
                throw paramString1;
              }
              paramString1.onScrollStateChanged(paramString2, ((Integer)paramString3).intValue());
            }
          }
          AppMethodBeat.o(256348);
          return;
        }
        AppMethodBeat.o(256348);
        return;
      }
      if ((p.h("onScrolled", paramString2)) && (p.h("(Landroidx/recyclerview/widget/RecyclerView;II)V", paramString3)) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 3))
      {
        paramString2 = paramArrayOfObject[0];
        if ((paramString2 instanceof RecyclerView))
        {
          paramString1 = k.wlT;
          paramString2 = (RecyclerView)paramString2;
          paramString3 = paramArrayOfObject[1];
          if (paramString3 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(256348);
            throw paramString1;
          }
          ((Integer)paramString3).intValue();
          paramString3 = paramArrayOfObject[2];
          if (paramString3 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(256348);
            throw paramString1;
          }
          paramString1.d(paramString2, ((Integer)paramString3).intValue());
        }
      }
      AppMethodBeat.o(256348);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.k
 * JD-Core Version:    0.7.0.1
 */