package com.tencent.mm.plugin.expt.hellhound.ext.b.b;

import android.app.Activity;
import android.content.Intent;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.b.a.g;
import com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.a;
import com.tencent.mm.plugin.expt.hellhound.ext.b.d.f.a;
import com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.a;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.eai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponentActivity;
import com.tencent.mm.ui.component.UIComponentFragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerCallback;", "", "()V", "DESC_onScrollStateChanged", "", "DESC_onScrolled", "NAME_onScrollStateChanged", "NAME_onScrolled", "SUPER_NAME", "TAG", "mClickCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback;", "mFinderFragmentCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback;", "mFragmentFeedStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FragmentFeedStatistics;", "mItemDecorationCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback;", "mListener", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "mListeners", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IRecyclerMonitorListener;", "mMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "Lkotlin/collections/HashMap;", "mRefreshLoadMoreCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "mShareStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderShareStatistics;", "mSnsFinderMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/SnsFinderMonitor;", "mWaterfallsFlowMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor;", "begin19943OfsnsFinder", "", "session", "Lcom/tencent/mm/protocal/protobuf/PageSession;", "fragmentFeedFlowOnFree", "activityName", "getCurFragmentOfFinderHomeUI", "Landroidx/fragment/app/Fragment;", "activity", "Landroid/app/Activity;", "monitor", "on7Event", "pageName", "hashCode", "", "timestamp", "", "on8Event", "onActivityCreate", "onFinderHomeUIPaused", "onFinderHomeUIResumed", "onFinishActivity", "onLoadMoreBegin", "onLoadMoreEnd", "className", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "onRefreshBegin", "onRefreshEnd", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "registerClickListener", "listener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "registerFinderFragmentListener", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "registerListener", "startFinderFragmentMonitor", "startFragmentFeedFlowMonitor", "Landroidx/fragment/app/FragmentActivity;", "fragment", "fragmentEventId", "startItemDecorationMonitor", "startMonitorClick", "startSnsFinderMonitor", "sPageName", "startWaterfallsFlowMonitor", "eventId", "stop19943OfsnsFinder", "curSession", "stopFinderFragmentMonitor", "stopFragmentFeedFlowMonitor", "stopItemDecorationMonitor", "stopMonitorClick", "stopSnsFinderMonitor", "stopWaterfallsFlowMonitor", "unregisterClickListener", "unregisterFinderFragmentListener", "unregisterListener", "RecycylerScrollListener", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  private static final List<e> mListeners;
  private static com.tencent.mm.hellhoundlib.a.d zBZ;
  private static final HashMap<String, List<Pair<String, String>>> zGg;
  public static final k zHQ;
  private static final l zHR;
  private static final b zHS;
  private static final m zHT;
  private static final com.tencent.mm.plugin.expt.hellhound.ext.b.c zHU;
  private static final com.tencent.mm.plugin.expt.hellhound.ext.a.b zHV;
  private static final com.tencent.mm.plugin.expt.hellhound.ext.b.d.d zHW;
  private static final a zHX;
  private static final n zHY;
  
  static
  {
    AppMethodBeat.i(300705);
    zHQ = new k();
    zGg = new HashMap();
    mListeners = (List)new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V"));
    localArrayList.add(Pair.create("onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V"));
    ((Map)zGg).put("androidx/recyclerview/widget/RecyclerView$OnScrollListener", localArrayList);
    zBZ = (com.tencent.mm.hellhoundlib.a.d)new k.a();
    zHR = new l();
    zHS = new b();
    zHT = new m();
    zHU = new com.tencent.mm.plugin.expt.hellhound.ext.b.c();
    zHV = new com.tencent.mm.plugin.expt.hellhound.ext.a.b();
    zHW = new com.tencent.mm.plugin.expt.hellhound.ext.b.d.d();
    zHX = new a();
    zHY = new n();
    AppMethodBeat.o(300705);
  }
  
  public static final void a(Activity paramActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(300673);
    com.tencent.mm.plugin.expt.hellhound.ext.b.c localc = zHU;
    Object localObject;
    if (paramFragment == null) {
      if (paramActivity == null)
      {
        localObject = null;
        c.a locala = c.zGj;
        if (c.dKH().contains(localObject))
        {
          Log.i("HABBYGE-MALI.WaterfallsFlowMonitor", s.X("monitor: poageName=", localObject));
          localc.zEF = ((String)localObject);
          zHQ.a((e)localc.zEH);
          localc.zEG = new com.tencent.mm.plugin.expt.hellhound.ext.b.d.j(paramActivity, paramFragment);
          localObject = localc.zEG;
          if (localObject != null)
          {
            if (paramFragment != null) {
              break label282;
            }
            if (paramActivity != null) {
              break label229;
            }
            paramFragment = null;
            label106:
            if (!s.p(paramFragment, c.zGQ)) {
              break label263;
            }
            if (!s.p(paramFragment, c.zGS)) {
              break label251;
            }
            Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: 7Event !!");
            ((com.tencent.mm.plugin.expt.hellhound.ext.b.d.j)localObject).s(paramActivity, paramLong);
            label142:
            paramActivity = c.zGj;
            c.zGR = null;
            paramActivity = c.zGj;
            c.zGQ = null;
          }
        }
      }
    }
    for (;;)
    {
      paramActivity = (d)((com.tencent.mm.plugin.expt.hellhound.ext.b.d.j)localObject).zJH.zIV;
      s.u(paramActivity, "listener");
      zHX.a(paramActivity);
      AppMethodBeat.o(300673);
      return;
      localObject = paramActivity.getClass();
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      localObject = ((Class)localObject).getName();
      break;
      localObject = paramFragment.getClass().getName();
      break;
      label229:
      paramFragment = paramActivity.getClass();
      if (paramFragment == null)
      {
        paramFragment = null;
        break label106;
      }
      paramFragment = paramFragment.getName();
      break label106;
      label251:
      Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: startActivity !!");
      break label142;
      label263:
      Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: Back to activity !!");
      ((com.tencent.mm.plugin.expt.hellhound.ext.b.d.j)localObject).s(paramActivity, paramLong);
      break label142;
      switch (paramInt)
      {
      case 1: 
      default: 
        Log.printErrStackTrace("HABBYGE-MALI.WaterfallsFlowStatistics", (Throwable)new NullPointerException("startCompute, fragment, miss !!"), "", new Object[0]);
        break;
      case 0: 
        Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, resume !!");
        ((com.tencent.mm.plugin.expt.hellhound.ext.b.d.j)localObject).s(paramFragment, paramLong);
        break;
      case 2: 
        label282:
        Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, 7Event !!");
        ((com.tencent.mm.plugin.expt.hellhound.ext.b.d.j)localObject).s(paramFragment, paramLong);
      }
    }
  }
  
  public static void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(300701);
    s.u(paramFragmentActivity, "activity");
    s.u(paramFragment, "fragment");
    com.tencent.mm.plugin.expt.hellhound.ext.a.b localb = zHV;
    s.u(paramFragmentActivity, "activity");
    s.u(paramFragment, "fragment");
    paramFragment = paramFragment.getClass().getName();
    Log.d("HABBYGE-MALI.FragmentFeedStatistics", "start: fragment:" + paramFragment + ", event=" + paramInt);
    if (paramFragment != null) {
      switch (paramFragment.hashCode())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(300701);
      return;
      if (!paramFragment.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment"))
      {
        AppMethodBeat.o(300701);
        return;
        if (paramFragment.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment")) {
          break label272;
        }
        AppMethodBeat.o(300701);
        return;
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment")) {
          AppMethodBeat.o(300701);
        }
      }
      else
      {
        if (localb.zDD == null) {
          localb.zDD = ((com.tencent.mm.plugin.expt.hellhound.ext.b.a.o)new com.tencent.mm.plugin.expt.hellhound.ext.b.a.f((Activity)paramFragmentActivity));
        }
        paramFragmentActivity = localb.zDD;
        if (paramFragmentActivity == null) {
          continue;
        }
        paramFragmentActivity.startMonitor();
        AppMethodBeat.o(300701);
        return;
      }
      if (localb.zDE == null) {
        localb.zDE = ((com.tencent.mm.plugin.expt.hellhound.ext.b.a.o)new g((Activity)paramFragmentActivity));
      }
      paramFragmentActivity = localb.zDE;
      if (paramFragmentActivity != null)
      {
        paramFragmentActivity.startMonitor();
        AppMethodBeat.o(300701);
        return;
        label272:
        if (localb.zDF == null) {
          localb.zDF = ((com.tencent.mm.plugin.expt.hellhound.ext.b.a.o)new com.tencent.mm.plugin.expt.hellhound.ext.b.a.j((Activity)paramFragmentActivity));
        }
        paramFragmentActivity = localb.zDF;
        if (paramFragmentActivity != null) {
          paramFragmentActivity.startMonitor();
        }
      }
    }
  }
  
  public static final void a(com.tencent.mm.plugin.expt.hellhound.core.d paramd)
  {
    AppMethodBeat.i(300628);
    s.u(paramd, "listener");
    Object localObject = zHS;
    s.u(paramd, "listener");
    localObject = ((b)localObject).zGa;
    if (localObject != null)
    {
      s.u(paramd, "listener");
      ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject).zBV = paramd;
    }
    AppMethodBeat.o(300628);
  }
  
  public static final void a(eah parameah)
  {
    AppMethodBeat.i(300691);
    if ((parameah != null) && ("143".equals(com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(parameah.sessionId))) && (c.zGl)) {
      Log.d("HABBYGE-MALI.SnsFinderMonitor", "begin19943, sessionId=%s, startTime=%s, endTime=%s", new Object[] { parameah.sessionId, Long.valueOf(parameah.startTime), Long.valueOf(parameah.endTime) });
    }
    AppMethodBeat.o(300691);
  }
  
  public static final Fragment ao(Activity paramActivity)
  {
    UIComponentFragment localUIComponentFragment = null;
    AppMethodBeat.i(300634);
    b localb = zHS;
    if (paramActivity == null)
    {
      paramActivity = null;
      if (paramActivity != null) {
        break label57;
      }
    }
    for (;;)
    {
      paramActivity = (Fragment)localUIComponentFragment;
      AppMethodBeat.o(300634);
      return paramActivity;
      paramActivity = paramActivity.getClass();
      if (paramActivity == null)
      {
        paramActivity = null;
        break;
      }
      paramActivity = paramActivity.getName();
      break;
      label57:
      if ((s.p(paramActivity, "com.tencent.mm.plugin.finder.ui.FinderHomeUI")) || (s.p(paramActivity, "com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI")) || (s.p(paramActivity, "com.tencent.mm.plugin.finder.ui.FinderConversationUI"))) {
        localUIComponentFragment = localb.s(null, -1);
      }
    }
  }
  
  public static final void arR(String paramString)
  {
    AppMethodBeat.i(300606);
    l locall = zHR;
    if (!l.asa(paramString))
    {
      Log.i("HABBYGE-MALI.RecyclerItemDecorationCallback", "monitor");
      paramString = locall.zDZ;
      if (paramString != null) {
        paramString.clear();
      }
      com.tencent.mm.hellhoundlib.a.aYh();
      com.tencent.mm.hellhoundlib.a.c((Map)locall.zGg, (com.tencent.mm.hellhoundlib.a.d)locall.zIa);
    }
    AppMethodBeat.o(300606);
  }
  
  public static final void arS(String paramString)
  {
    AppMethodBeat.i(300614);
    l locall = zHR;
    if (!l.asa(paramString))
    {
      Log.i("HABBYGE-MALI.RecyclerItemDecorationCallback", "unmonitor");
      paramString = locall.zDZ;
      if (paramString != null)
      {
        paramString = (RecyclerView)paramString.get();
        if (paramString != null) {
          paramString.b((RecyclerView.l)locall.zIb);
        }
      }
      paramString = locall.zDZ;
      if (paramString != null) {
        paramString.clear();
      }
      locall.zDZ = null;
      com.tencent.mm.hellhoundlib.a.aYh();
      com.tencent.mm.hellhoundlib.a.d((Map)locall.zGg, (com.tencent.mm.hellhoundlib.a.d)locall.zIa);
    }
    AppMethodBeat.o(300614);
  }
  
  public static final void arT(String arg0)
  {
    AppMethodBeat.i(300619);
    Object localObject1 = zHS;
    ((b)localObject1).zFW = ???;
    if ((s.p("com.tencent.mm.plugin.finder.ui.FinderHomeUI", ???)) || (s.p("com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI", ???)) || (s.p("com.tencent.mm.plugin.finder.ui.FinderConversationUI", ???)))
    {
      Log.i("HABBYGE-MALI.FinderFragmentCallback", "monitor...");
      ((b)localObject1).mI = -1;
      ((b)localObject1).zFY = true;
      ((b)localObject1).zFZ = false;
      synchronized (((b)localObject1).lock)
      {
        if (!((b)localObject1).zGf)
        {
          ((b)localObject1).zGf = true;
          com.tencent.mm.hellhoundlib.a.aYh();
          com.tencent.mm.hellhoundlib.a.c((Map)((b)localObject1).zGg, (com.tencent.mm.hellhoundlib.a.d)((b)localObject1).zGh);
        }
        localObject1 = ah.aiuX;
        AppMethodBeat.o(300619);
        return;
      }
    }
    AppMethodBeat.o(300619);
  }
  
  public static final void arU(String arg0)
  {
    AppMethodBeat.i(300625);
    Object localObject1 = zHS;
    ((b)localObject1).zFX = ???;
    if ((s.p("com.tencent.mm.plugin.finder.ui.FinderHomeUI", ???)) || (s.p("com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI", ???)) || (s.p("com.tencent.mm.plugin.finder.ui.FinderConversationUI", ???)))
    {
      Log.i("HABBYGE-MALI.FinderFragmentCallback", "unmonitor...");
      ((b)localObject1).zFY = false;
      ((b)localObject1).zFZ = true;
      synchronized (((b)localObject1).lock)
      {
        com.tencent.mm.hellhoundlib.a.aYh();
        com.tencent.mm.hellhoundlib.a.d((Map)((b)localObject1).zGg, (com.tencent.mm.hellhoundlib.a.d)((b)localObject1).zGh);
        ((b)localObject1).zGf = false;
        localObject1 = ah.aiuX;
        AppMethodBeat.o(300625);
        return;
      }
    }
    AppMethodBeat.o(300625);
  }
  
  public static final void arV(String paramString)
  {
    AppMethodBeat.i(300679);
    if ((s.p("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (s.p("com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI5", paramString)) || (s.p("com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI", paramString)) || (s.p("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)))
    {
      paramString = zHV;
      Log.i("HABBYGE-MALI.FragmentFeedStatistics", "stop: free...");
      com.tencent.mm.plugin.expt.hellhound.ext.b.a.o localo = paramString.zDD;
      if (localo != null) {
        localo.free();
      }
      paramString.zDD = null;
      localo = paramString.zDE;
      if (localo != null) {
        localo.free();
      }
      paramString.zDE = null;
      localo = paramString.zDF;
      if (localo != null) {
        localo.free();
      }
      paramString.zDF = null;
    }
    AppMethodBeat.o(300679);
  }
  
  public static final void arW(String paramString)
  {
    AppMethodBeat.i(300682);
    if ((s.p("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (s.p("com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI5", paramString)) || (s.p("com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI", paramString)) || (s.p("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)))
    {
      zHX.ayW();
      AppMethodBeat.o(300682);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.zKz;
    localObject = b.a.dLz();
    if (localObject != null) {
      switch (((String)localObject).hashCode())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(300682);
      return;
      if (!((String)localObject).equals("101"))
      {
        AppMethodBeat.o(300682);
        return;
        if (!((String)localObject).equals("123"))
        {
          AppMethodBeat.o(300682);
          return;
          if (!((String)localObject).equals("102"))
          {
            AppMethodBeat.o(300682);
            return;
            if (!((String)localObject).equals("999")) {
              continue;
            }
          }
        }
      }
      if ((s.p("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", paramString)) || (s.p("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", paramString)) || (s.p("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", paramString))) {
        zHX.ayW();
      }
    }
  }
  
  public static final void arX(String paramString)
  {
    AppMethodBeat.i(300685);
    if (s.p(paramString, "SnsTimeLineUI"))
    {
      zHY.ayW();
      AppMethodBeat.o(300685);
      return;
    }
    if (s.p(paramString, "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI")) {
      zHY.ayW();
    }
    AppMethodBeat.o(300685);
  }
  
  public static final void arY(String paramString)
  {
    AppMethodBeat.i(300687);
    if ((s.p("SnsTimeLineUI", paramString)) || (s.p("com.tencent.mm.plugin.sns.ui.SnsTimeLineUI", paramString)))
    {
      paramString = zHY;
      com.tencent.mm.hellhoundlib.a.aYh();
      com.tencent.mm.hellhoundlib.a.f(paramString.zCw, paramString.zIp);
    }
    AppMethodBeat.o(300687);
  }
  
  public static final void arZ(String paramString)
  {
    AppMethodBeat.i(300699);
    if ((s.p("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (s.p("com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI5", paramString)) || (s.p("com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI", paramString)) || (s.p("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)))
    {
      zHX.dKh();
      AppMethodBeat.o(300699);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.zKz;
    localObject = b.a.dLz();
    if (localObject != null) {
      switch (((String)localObject).hashCode())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(300699);
      return;
      if (!((String)localObject).equals("101"))
      {
        AppMethodBeat.o(300699);
        return;
        if (!((String)localObject).equals("123"))
        {
          AppMethodBeat.o(300699);
          return;
          if (!((String)localObject).equals("102"))
          {
            AppMethodBeat.o(300699);
            return;
            if (!((String)localObject).equals("999")) {
              continue;
            }
          }
        }
      }
      if ((s.p("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", paramString)) || (s.p("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", paramString)) || (s.p("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", paramString))) {
        zHX.dKh();
      }
    }
  }
  
  public static void ayW()
  {
    AppMethodBeat.i(300598);
    Log.i("HABBYGE-MALI.RecyclerCallback", "monitor...");
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((Map)zGg, zBZ);
    Object localObject1 = zHT;
    Log.i("HABBYGE-MALI.RefreshLoadMoreCallback", "startMonitor...");
    Object localObject2 = new i();
    Log.i("HABBYGE-MALI.RLBeginCallback", "startMonitor...");
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((Map)((i)localObject2).zGg, (com.tencent.mm.hellhoundlib.a.d)((i)localObject2).zHL);
    localObject2 = new j((m)localObject1);
    Log.i("HABBYGE-MALI.RLEndCallback", "startMonitor...");
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((Map)((j)localObject2).zGg, (com.tencent.mm.hellhoundlib.a.d)((j)localObject2).zHO);
    localObject1 = new o((m)localObject1);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((Map)((o)localObject1).zGg, (com.tencent.mm.hellhoundlib.a.d)((o)localObject1).zIt);
    new h();
    com.tencent.mm.plugin.expt.hellhound.ext.b.d.f.zJg.reset();
    com.tencent.mm.plugin.expt.hellhound.ext.b.d.f.zJg.dLa();
    AppMethodBeat.o(300598);
  }
  
  public static final void b(Activity paramActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(300678);
    com.tencent.mm.plugin.expt.hellhound.ext.b.c localc = zHU;
    Object localObject;
    if (paramFragment == null) {
      if (paramActivity == null)
      {
        localObject = null;
        c.a locala = c.zGj;
        if (c.dKH().contains(localObject))
        {
          Log.i("HABBYGE-MALI.WaterfallsFlowMonitor", s.X("unmonitor: poageName=", localObject));
          zHQ.b((e)localc.zEH);
          localObject = localc.zEG;
          if (localObject != null)
          {
            if (paramFragment != null) {
              break label305;
            }
            if (paramActivity != null) {
              break label225;
            }
            paramFragment = null;
            label87:
            Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", s.X("stopCompute: pageName=", paramFragment));
            if (!s.p(paramFragment, c.zGR)) {
              break label247;
            }
            Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: finish cur page !");
            ((com.tencent.mm.plugin.expt.hellhound.ext.b.d.j)localObject).zJB = 1;
            paramInt = 1;
            label128:
            ((com.tencent.mm.plugin.expt.hellhound.ext.b.d.j)localObject).t(paramActivity, paramLong);
            if (paramInt != 0)
            {
              paramActivity = c.zGj;
              c.a.dKN();
            }
          }
        }
      }
    }
    for (;;)
    {
      paramActivity = (d)((com.tencent.mm.plugin.expt.hellhound.ext.b.d.j)localObject).zJH.zIV;
      s.u(paramActivity, "listener");
      zHX.b(paramActivity);
      localc.zEG = null;
      AppMethodBeat.o(300678);
      return;
      localObject = paramActivity.getClass();
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      localObject = ((Class)localObject).getName();
      break;
      localObject = paramFragment.getClass().getName();
      break;
      label225:
      paramFragment = paramActivity.getClass();
      if (paramFragment == null)
      {
        paramFragment = null;
        break label87;
      }
      paramFragment = paramFragment.getName();
      break label87;
      label247:
      if ((!s.p(paramFragment, c.zGQ)) && (c.zGQ != null))
      {
        Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: startActivity another page !");
        ((com.tencent.mm.plugin.expt.hellhound.ext.b.d.j)localObject).zJB = 1;
        paramInt = 0;
        break label128;
      }
      Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: 8Event !");
      ((com.tencent.mm.plugin.expt.hellhound.ext.b.d.j)localObject).zJB = 2;
      paramInt = 0;
      break label128;
      switch (paramInt)
      {
      case 2: 
      default: 
        Log.printErrStackTrace("HABBYGE-MALI.WaterfallsFlowStatistics", (Throwable)new NullPointerException("startCompute, fragment, miss !!"), "", new Object[0]);
        break;
      case 1: 
        Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, pause !!");
        ((com.tencent.mm.plugin.expt.hellhound.ext.b.d.j)localObject).zJB = 1;
        ((com.tencent.mm.plugin.expt.hellhound.ext.b.d.j)localObject).t(paramFragment, paramLong);
        break;
      case 3: 
        label305:
        Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, 8Event !!");
        ((com.tencent.mm.plugin.expt.hellhound.ext.b.d.j)localObject).zJB = 2;
        ((com.tencent.mm.plugin.expt.hellhound.ext.b.d.j)localObject).t(paramFragment, paramLong);
      }
    }
  }
  
  public static void b(FragmentActivity paramFragmentActivity, Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(300703);
    s.u(paramFragmentActivity, "activity");
    s.u(paramFragment, "fragment");
    com.tencent.mm.plugin.expt.hellhound.ext.a.b localb = zHV;
    s.u(paramFragmentActivity, "activity");
    s.u(paramFragment, "fragment");
    paramFragmentActivity = paramFragment.getClass().getName();
    Log.d("HABBYGE-MALI.FragmentFeedStatistics", "stop: fragment:" + paramFragmentActivity + ", event=" + paramInt);
    if (paramFragmentActivity != null) {
      switch (paramFragmentActivity.hashCode())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(300703);
      return;
      if (!paramFragmentActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment"))
      {
        AppMethodBeat.o(300703);
        return;
        if (paramFragmentActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment")) {
          break label222;
        }
        AppMethodBeat.o(300703);
        return;
        if (!paramFragmentActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment")) {
          AppMethodBeat.o(300703);
        }
      }
      else
      {
        paramFragmentActivity = localb.zDD;
        if (paramFragmentActivity == null) {
          continue;
        }
        paramFragmentActivity.stopMonitor();
        AppMethodBeat.o(300703);
        return;
      }
      paramFragmentActivity = localb.zDE;
      if (paramFragmentActivity != null)
      {
        paramFragmentActivity.stopMonitor();
        AppMethodBeat.o(300703);
        return;
        label222:
        paramFragmentActivity = localb.zDF;
        if (paramFragmentActivity != null) {
          paramFragmentActivity.stopMonitor();
        }
      }
    }
  }
  
  public static final void b(eah parameah)
  {
    AppMethodBeat.i(300694);
    if (parameah != null)
    {
      String str = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(parameah.sessionId);
      if ((("143".equals(str)) || ("155".equals(str))) && (c.zGl))
      {
        Log.d("HABBYGE-MALI.SnsFinderMonitor", "stop19943, sessionId=%s, startTime=%s, endTime=%s", new Object[] { parameah.sessionId, Long.valueOf(parameah.startTime), Long.valueOf(parameah.endTime) });
        com.tencent.mm.plugin.expt.hellhound.ext.b.c.b localb = new com.tencent.mm.plugin.expt.hellhound.ext.b.c.b();
        localb.sessionId = com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD().dHN();
        localb.hJW = "All-Sns";
        localb.zIz = parameah.startTime;
        localb.zIA = parameah.endTime;
        localb.zIy = (parameah.endTime - parameah.startTime);
        localb.zIB = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
        localb.zIC = str;
        localb.hYb = c.b.zHc.value;
        com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.a(localb);
      }
    }
    AppMethodBeat.o(300694);
  }
  
  public static final void d(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(300642);
    Object localObject1;
    label64:
    com.tencent.mm.plugin.expt.hellhound.ext.b.d.d locald;
    Object localObject2;
    label341:
    boolean bool;
    if (paramActivity == null)
    {
      localObject1 = null;
      if (localObject1 != null) {}
      switch (((String)localObject1).hashCode())
      {
      default: 
        locald = zHW;
        Object localObject3;
        if (paramActivity != null)
        {
          localObject1 = paramActivity.getClass().getName();
          localObject2 = c.zGj;
          if ((c.dKG().contains(localObject1)) && (locald.zJa == null))
          {
            localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH((String)localObject1);
            if (localObject3 != null)
            {
              int i = paramActivity.hashCode();
              localObject2 = paramActivity.getIntent().getStringExtra("key_extra_info");
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.extraInfo = (String)localObject1;
              com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.a((String)localObject3, i, paramLong, com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.extraInfo);
              localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.extraInfo;
              Log.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV2, sPage=" + (String)localObject3 + ", hashCode=" + i);
              if (com.tencent.mm.plugin.expt.hellhound.ext.b.d.f.zJg.ek((String)localObject3, i) == null)
              {
                localObject2 = new eai();
                ((eai)localObject2).sessionId = com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD().dHN();
                ((eai)localObject2).hJW = ((String)localObject3);
                ((eai)localObject2).cHb = i;
                ((eai)localObject2).zIz = paramLong;
                b.a locala = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.zKz;
                ((eai)localObject2).zIC = b.a.dLz();
                ((eai)localObject2).hYb = c.b.zHc.value;
                ((eai)localObject2).extraInfo = ((String)localObject1);
                com.tencent.mm.plugin.expt.hellhound.ext.b.d.f.zJg.c((eai)localObject2);
                Log.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV2, YES, sPage=" + (String)localObject3 + ", hashCode=" + i);
                locald.zJa = ((String)localObject3);
              }
            }
          }
        }
        if (paramActivity == null)
        {
          localObject1 = null;
          if (localObject1 != null)
          {
            localObject2 = c.zGj;
            if ((c.dKF().contains(localObject1)) && ((locald.zIZ == null) || (s.p(localObject1, locald.zIZ))))
            {
              locald.zIZ = ((String)localObject1);
              locald.zIY = new com.tencent.mm.plugin.expt.hellhound.ext.b.c.b(null, null, 0L, 0L, 0L, null, null, 0, null, null, 4095);
              localObject3 = locald.zIY;
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                s.bIx("mStayTime");
                localObject2 = null;
              }
              ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject2).sessionId = com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD().dHN();
              localObject3 = locald.zIY;
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                s.bIx("mStayTime");
                localObject2 = null;
              }
              ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject2).hJW = com.tencent.mm.plugin.expt.hellhound.core.b.aqH((String)localObject1);
              localObject3 = locald.zIY;
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                s.bIx("mStayTime");
                localObject2 = null;
              }
              ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject2).zIz = paramLong;
              localObject3 = locald.zIY;
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                s.bIx("mStayTime");
                localObject2 = null;
              }
              localObject3 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.zKz;
              ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject2).zIC = b.a.dLz();
              localObject3 = locald.zIY;
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                s.bIx("mStayTime");
                localObject2 = null;
              }
              ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject2).hYb = c.b.zHb.value;
              localObject3 = locald.zIY;
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                s.bIx("mStayTime");
                localObject2 = null;
              }
              localObject3 = paramActivity.getIntent().getStringExtra("key_extra_info");
              paramActivity = (Activity)localObject3;
              if (localObject3 == null) {
                paramActivity = "";
              }
              ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject2).extraInfo = paramActivity;
              localObject2 = locald.zIY;
              paramActivity = (Activity)localObject2;
              if (localObject2 == null)
              {
                s.bIx("mStayTime");
                paramActivity = null;
              }
              localObject2 = paramActivity.extraInfo;
              paramActivity = (Activity)localObject2;
              if (localObject2 == null) {
                paramActivity = "";
              }
              com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.extraInfo = paramActivity;
              if (!s.p(localObject1, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
                break label1277;
              }
              localObject1 = locald.zIY;
              paramActivity = (Activity)localObject1;
              if (localObject1 == null)
              {
                s.bIx("mStayTime");
                paramActivity = null;
              }
              localObject1 = c.zGj;
              if (c.dKI() != c.d.zHl.value) {
                break label1271;
              }
              bool = true;
            }
          }
        }
        break;
      }
    }
    label745:
    for (paramActivity.zID = bool;; paramActivity.zID = false)
    {
      localObject1 = locald.zIY;
      paramActivity = (Activity)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mStayTime");
        paramActivity = null;
      }
      Log.i("HABBYGE-MALI.FinderShareStatistics", s.X("doPageResume: ", paramActivity.hJW));
      AppMethodBeat.o(300642);
      return;
      localObject1 = paramActivity.getClass();
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((Class)localObject1).getName();
      break;
      if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderHomeUI")) {
        break label64;
      }
      do
      {
        localObject1 = zHS;
        if (paramActivity != null) {
          break;
        }
        paramActivity = new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        AppMethodBeat.o(300642);
        throw paramActivity;
      } while (((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI"));
      if ((goto 64) || (!((String)localObject1).equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"))) {
        break label64;
      }
      localObject1 = zHS;
      if (paramActivity == null)
      {
        paramActivity = new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        AppMethodBeat.o(300642);
        throw paramActivity;
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderConversationUI")) {
          break label64;
        }
        localObject1 = zHS;
        if (paramActivity == null)
        {
          paramActivity = new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
          AppMethodBeat.o(300642);
          throw paramActivity;
        }
        ((b)localObject1).b((FragmentActivity)paramActivity, paramLong);
        AppMethodBeat.o(300642);
        return;
        ((b)localObject1).b((FragmentActivity)paramActivity, paramLong);
        AppMethodBeat.o(300642);
        return;
      }
      s.u((FragmentActivity)paramActivity, "activity");
      localObject2 = ((b)localObject1).zGa;
      if (localObject2 != null)
      {
        ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject2).zED = new com.tencent.mm.plugin.expt.hellhound.ext.b.c.b(null, null, 0L, 0L, 0L, null, null, 0, null, null, 4095);
        localObject1 = ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject2).zED;
        paramActivity = (Activity)localObject1;
        if (localObject1 == null)
        {
          s.bIx("statyTimeStaticLbsList");
          paramActivity = null;
        }
        paramActivity.sessionId = com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD().dHN();
        localObject1 = ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject2).zED;
        paramActivity = (Activity)localObject1;
        if (localObject1 == null)
        {
          s.bIx("statyTimeStaticLbsList");
          paramActivity = null;
        }
        paramActivity.hJW = com.tencent.mm.plugin.expt.hellhound.core.b.aqH("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI");
        localObject1 = ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject2).zED;
        paramActivity = (Activity)localObject1;
        if (localObject1 == null)
        {
          s.bIx("statyTimeStaticLbsList");
          paramActivity = null;
        }
        paramActivity.zIz = paramLong;
        localObject1 = ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject2).zED;
        paramActivity = (Activity)localObject1;
        if (localObject1 == null)
        {
          s.bIx("statyTimeStaticLbsList");
          paramActivity = null;
        }
        paramActivity.zIC = "143";
        localObject1 = ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject2).zED;
        paramActivity = (Activity)localObject1;
        if (localObject1 == null)
        {
          s.bIx("statyTimeStaticLbsList");
          paramActivity = null;
        }
        paramActivity.hYb = c.b.zHb.value;
        localObject1 = ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject2).zEC;
        paramActivity = (Activity)localObject1;
        if (localObject1 == null)
        {
          s.bIx("statyTimeStaticHome");
          paramActivity = null;
        }
        localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.zIX;
        paramActivity.extraInfo = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.dKW();
        Log.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderLbsStreamListUIResume...");
      }
      AppMethodBeat.o(300642);
      return;
      localObject1 = paramActivity.getClass();
      if (localObject1 == null)
      {
        localObject1 = null;
        break label341;
      }
      localObject1 = ((Class)localObject1).getName();
      break label341;
      label1271:
      bool = false;
      break label745;
      label1277:
      localObject1 = locald.zIY;
      paramActivity = (Activity)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mStayTime");
        paramActivity = null;
      }
    }
  }
  
  public static final Fragment dKR()
  {
    AppMethodBeat.i(300631);
    b localb = zHS;
    Object localObject1 = localb.zGa;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = localb.zGb;
        if (localObject1 != null) {
          break label81;
        }
      }
    }
    label81:
    for (localObject1 = null;; localObject1 = (UIComponentActivity)((WeakReference)localObject1).get())
    {
      localObject2 = (Fragment)localb.s(localObject1, -1);
      AppMethodBeat.o(300631);
      return localObject2;
      localObject1 = ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject1).zEA;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = (Fragment)((WeakReference)localObject1).get();
      break;
    }
  }
  
  public static final void dKS() {}
  
  public static final void e(Activity paramActivity, long paramLong)
  {
    Object localObject2 = null;
    com.tencent.mm.plugin.expt.hellhound.ext.b.b localb = null;
    AppMethodBeat.i(300650);
    Object localObject1;
    label72:
    label84:
    String str;
    Object localObject3;
    if (paramActivity == null)
    {
      localObject1 = null;
      if (localObject1 != null) {}
      switch (((String)localObject1).hashCode())
      {
      default: 
        com.tencent.mm.plugin.expt.hellhound.ext.b.d.d locald = zHW;
        if (paramActivity == null)
        {
          localObject1 = null;
          if (localObject1 != null)
          {
            localObject2 = c.zGj;
            if ((c.dKF().contains(localObject1)) && (locald.zIZ != null) && (s.p(localObject1, locald.zIZ)))
            {
              if (locald.zJa == null) {
                locald.zIZ = null;
              }
              str = com.tencent.mm.plugin.expt.hellhound.core.b.aqH((String)localObject1);
              localObject2 = locald.zIY;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("mStayTime");
                localObject1 = null;
              }
              if (s.p(((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1).hJW, str))
              {
                localObject2 = locald.zIY;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  s.bIx("mStayTime");
                  localObject1 = null;
                }
                ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1).zIA = paramLong;
                localObject2 = locald.zIY;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  s.bIx("mStayTime");
                  localObject1 = null;
                }
                localObject3 = locald.zIY;
                localObject2 = localObject3;
                if (localObject3 == null)
                {
                  s.bIx("mStayTime");
                  localObject2 = null;
                }
                paramLong = ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject2).zIA;
                localObject3 = locald.zIY;
                localObject2 = localObject3;
                if (localObject3 == null)
                {
                  s.bIx("mStayTime");
                  localObject2 = null;
                }
                ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1).zIy = (paramLong - ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject2).zIz);
                localObject2 = locald.zIY;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  s.bIx("mStayTime");
                  localObject1 = null;
                }
                ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1).zIB = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
                localObject2 = locald.zIY;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  s.bIx("mStayTime");
                  localObject1 = null;
                }
                localObject2 = paramActivity.getIntent().getStringExtra("key_enter_source_info");
                paramActivity = (Activity)localObject2;
                if (localObject2 == null) {
                  paramActivity = "";
                }
                ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1).zIE = paramActivity;
                paramActivity = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
                paramActivity = locald.zIY;
                if (paramActivity != null) {
                  break label970;
                }
                s.bIx("mStayTime");
                paramActivity = localb;
              }
            }
          }
        }
        break;
      }
    }
    label935:
    label940:
    label970:
    for (;;)
    {
      a.a.a(paramActivity);
      Log.i("HABBYGE-MALI.FinderShareStatistics", s.X("onPagePaused: ", str));
      AppMethodBeat.o(300650);
      return;
      localObject1 = paramActivity.getClass();
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((Class)localObject1).getName();
      break;
      if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderHomeUI")) {
        break label72;
      }
      do
      {
        localObject1 = zHS;
        if (paramActivity != null) {
          break;
        }
        paramActivity = new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        AppMethodBeat.o(300650);
        throw paramActivity;
      } while (((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI"));
      if ((goto 72) || (!((String)localObject1).equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"))) {
        break label72;
      }
      localObject1 = zHS;
      if (paramActivity == null)
      {
        paramActivity = new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        AppMethodBeat.o(300650);
        throw paramActivity;
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderConversationUI")) {
          break label72;
        }
        localObject1 = zHS;
        if (paramActivity == null)
        {
          paramActivity = new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
          AppMethodBeat.o(300650);
          throw paramActivity;
        }
        ((b)localObject1).c((FragmentActivity)paramActivity, paramLong);
        AppMethodBeat.o(300650);
        return;
        ((b)localObject1).c((FragmentActivity)paramActivity, paramLong);
        AppMethodBeat.o(300650);
        return;
      }
      s.u((FragmentActivity)paramActivity, "activity");
      localb = ((b)localObject1).zGa;
      int i;
      if (localb != null)
      {
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI");
        if (localb.zED == null) {
          break label935;
        }
        i = 1;
        if (i != 0)
        {
          localObject1 = localb.zED;
          paramActivity = (Activity)localObject1;
          if (localObject1 == null)
          {
            s.bIx("statyTimeStaticLbsList");
            paramActivity = null;
          }
          if (s.p(paramActivity.hJW, localObject3))
          {
            localObject1 = localb.zED;
            paramActivity = (Activity)localObject1;
            if (localObject1 == null)
            {
              s.bIx("statyTimeStaticLbsList");
              paramActivity = null;
            }
            paramActivity.zIA = paramLong;
            localObject1 = localb.zED;
            paramActivity = (Activity)localObject1;
            if (localObject1 == null)
            {
              s.bIx("statyTimeStaticLbsList");
              paramActivity = null;
            }
            paramLong = paramActivity.zIA;
            localObject1 = localb.zED;
            paramActivity = (Activity)localObject1;
            if (localObject1 == null)
            {
              s.bIx("statyTimeStaticLbsList");
              paramActivity = null;
            }
            long l = paramActivity.zIz;
            localObject1 = localb.zED;
            paramActivity = (Activity)localObject1;
            if (localObject1 == null)
            {
              s.bIx("statyTimeStaticLbsList");
              paramActivity = null;
            }
            paramActivity.zIy = (paramLong - l);
            localObject1 = localb.zED;
            paramActivity = (Activity)localObject1;
            if (localObject1 == null)
            {
              s.bIx("statyTimeStaticLbsList");
              paramActivity = null;
            }
            paramActivity.zIC = "143";
            localObject1 = localb.zED;
            paramActivity = (Activity)localObject1;
            if (localObject1 == null)
            {
              s.bIx("statyTimeStaticLbsList");
              paramActivity = null;
            }
            paramActivity.zIB = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
            paramActivity = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
            paramActivity = localb.zED;
            if (paramActivity != null) {
              break label940;
            }
            s.bIx("statyTimeStaticLbsList");
            paramActivity = (Activity)localObject2;
          }
        }
      }
      for (;;)
      {
        a.a.a(paramActivity);
        Log.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderLbsStreamListUIPause...");
        AppMethodBeat.o(300650);
        return;
        i = 0;
        break;
      }
      localObject1 = paramActivity.getClass();
      if (localObject1 == null)
      {
        localObject1 = null;
        break label84;
      }
      localObject1 = ((Class)localObject1).getName();
      break label84;
    }
  }
  
  public static final void f(Activity paramActivity, long paramLong)
  {
    long l1 = 0L;
    AppMethodBeat.i(300660);
    Object localObject3 = zHW;
    Object localObject1;
    Object localObject2;
    int i;
    long l2;
    if (paramActivity != null)
    {
      localObject1 = paramActivity.getClass().getName();
      localObject2 = c.zGj;
      if (c.dKG().contains(localObject1))
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH((String)localObject1);
        if (localObject2 != null)
        {
          i = paramActivity.hashCode();
          localObject1 = paramActivity.getIntent().getStringExtra("key_enter_source_info");
          paramActivity = (Activity)localObject1;
          if (localObject1 == null) {
            paramActivity = "";
          }
          ((com.tencent.mm.plugin.expt.hellhound.ext.b.d.d)localObject3).zJa = null;
          Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV1: sPage=" + (String)localObject2 + ", hashCode=" + i + ", enterSourceInfo=" + paramActivity);
          localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.d.f.zJg.ei((String)localObject2, i);
          if (localObject1 != null)
          {
            Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV1: compare, " + ((eai)localObject1).hJW + " == " + (String)localObject2 + ", " + ((eai)localObject1).cHb + " == " + i);
            ((eai)localObject1).zIA = paramLong;
            l2 = ((eai)localObject1).zIA;
            long l3 = ((eai)localObject1).zIz;
            localObject3 = ((eai)localObject1).abfA;
            s.s(localObject3, "statistics.stayTimeOnBackground");
            l2 = l2 - l3 - com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.ad((LinkedList)localObject3);
            if (l2 >= 0L) {
              break label598;
            }
          }
        }
      }
    }
    for (;;)
    {
      ((eai)localObject1).zIy = l1;
      ((eai)localObject1).zIB = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
      ((eai)localObject1).hYb = c.b.zHd.value;
      ((eai)localObject1).zIE = paramActivity;
      localObject3 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
      a.a.a(com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.a((eai)localObject1, c.b.zHd.value));
      com.tencent.mm.plugin.expt.hellhound.ext.b.d.f.zJg.ej((String)localObject2, i);
      Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV1: report, " + (String)localObject2 + ", " + i);
      Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV2: sPage=" + (String)localObject2 + ", hashCode=" + i + ", enterSourceInfo=" + paramActivity);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.d.f.zJg.ek((String)localObject2, i);
      if (localObject1 != null)
      {
        Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV2: compare, " + ((eai)localObject1).hJW + " == " + (String)localObject2 + ", " + ((eai)localObject1).cHb + " == " + i);
        ((eai)localObject1).zIA = paramLong;
        ((eai)localObject1).zIy = (((eai)localObject1).zIA - ((eai)localObject1).zIz);
        ((eai)localObject1).zIB = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
        ((eai)localObject1).hYb = c.b.zHc.value;
        ((eai)localObject1).zIE = paramActivity;
        paramActivity = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
        a.a.a(com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.a((eai)localObject1, c.b.zHc.value));
        com.tencent.mm.plugin.expt.hellhound.ext.b.d.f.zJg.el((String)localObject2, i);
        Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV2: report, " + (String)localObject2 + ", " + i);
      }
      AppMethodBeat.o(300660);
      return;
      label598:
      l1 = l2;
    }
  }
  
  public static final void n(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(300663);
    com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.q(paramString, paramInt, paramLong);
    Log.i("HABBYGE-MALI.FinderShareStatistics", "on8EventV2: pageName=" + paramString + ", hashCode=" + paramInt);
    if (com.tencent.mm.plugin.expt.hellhound.core.b.aqC(paramString))
    {
      com.tencent.mm.plugin.expt.hellhound.ext.b.d.f.zJg.dLa();
      AppMethodBeat.o(300663);
      return;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.ext.b.d.f.zJg.dKZ();
    if (paramString != null)
    {
      paramString.zIA = paramLong;
      paramString.zIy = (paramString.zIA - paramString.zIz);
      paramString.zIB = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
      paramString.hYb = c.b.zHc.value;
      Log.i("HABBYGE-MALI.FinderShareStatistics", "on8EventV2, statics: " + paramString.hJW + ", " + paramString.cHb);
      a.a locala = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
      a.a.a(com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.a(paramString, c.b.zHc.value));
      paramString.hYb = 8;
      com.tencent.mm.plugin.expt.hellhound.ext.b.d.f.zJg.d(paramString);
    }
    AppMethodBeat.o(300663);
  }
  
  public static final void o(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(300666);
    com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.p(paramString, paramInt, paramLong);
    com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.r(paramString, paramInt, paramLong);
    AppMethodBeat.o(300666);
  }
  
  public final void a(e parame)
  {
    try
    {
      AppMethodBeat.i(300708);
      s.u(parame, "listener");
      if (!mListeners.contains(parame)) {
        mListeners.add(parame);
      }
      AppMethodBeat.o(300708);
      return;
    }
    finally {}
  }
  
  public final void a(m.a parama)
  {
    try
    {
      AppMethodBeat.i(300716);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).a(parama);
      }
      AppMethodBeat.o(300716);
    }
    finally {}
  }
  
  public final void b(e parame)
  {
    try
    {
      AppMethodBeat.i(300710);
      s.u(parame, "listener");
      mListeners.remove(parame);
      AppMethodBeat.o(300710);
      return;
    }
    finally
    {
      parame = finally;
      throw parame;
    }
  }
  
  public final void d(RecyclerView paramRecyclerView, int paramInt)
  {
    try
    {
      AppMethodBeat.i(300713);
      s.u(paramRecyclerView, "recyclerView");
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).d(paramRecyclerView, paramInt);
      }
      AppMethodBeat.o(300713);
    }
    finally {}
  }
  
  public final void dKT()
  {
    try
    {
      AppMethodBeat.i(300717);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(300717);
    }
    finally {}
  }
  
  public final void dKe()
  {
    try
    {
      AppMethodBeat.i(300714);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).dKe();
      }
      AppMethodBeat.o(300714);
    }
    finally {}
  }
  
  public final void dKf()
  {
    try
    {
      AppMethodBeat.i(300718);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).dKf();
      }
      AppMethodBeat.o(300718);
    }
    finally {}
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    try
    {
      AppMethodBeat.i(300711);
      s.u(paramRecyclerView, "recyclerView");
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).onScrollStateChanged(paramRecyclerView, paramInt);
      }
      AppMethodBeat.o(300711);
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.b.k
 * JD-Core Version:    0.7.0.1
 */