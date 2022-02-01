package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.a.g;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.f.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.cym;
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

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerCallback;", "", "()V", "DESC_onScrollStateChanged", "", "DESC_onScrolled", "NAME_onScrollStateChanged", "NAME_onScrolled", "SUPER_NAME", "TAG", "mClickCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback;", "mFinderFragmentCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback;", "mFragmentFeedStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FragmentFeedStatistics;", "mItemDecorationCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback;", "mListener", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "mListeners", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IRecyclerMonitorListener;", "mMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "Lkotlin/collections/HashMap;", "mRefreshLoadMoreCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "mShareStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderShareStatistics;", "mSnsFinderMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/SnsFinderMonitor;", "mWaterfallsFlowMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor;", "begin19943OfsnsFinder", "", "session", "Lcom/tencent/mm/protocal/protobuf/PageSession;", "fragmentFeedFlowOnFree", "activityName", "getCurFragmentOfFinderHomeUI", "Landroid/support/v4/app/Fragment;", "activity", "Landroid/app/Activity;", "monitor", "on7Event", "pageName", "hashCode", "", "timestamp", "", "on8Event", "onActivityCreate", "onFinderHomeUIPaused", "onFinderHomeUIResumed", "onFinishActivity", "onLoadMoreBegin", "onLoadMoreEnd", "className", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "onRefreshBegin", "onRefreshEnd", "onScrollStateChanged", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "registerClickListener", "listener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "registerFinderFragmentListener", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "registerListener", "startFinderFragmentMonitor", "startFragmentFeedFlowMonitor", "Landroid/support/v4/app/FragmentActivity;", "fragment", "fragmentEventId", "startItemDecorationMonitor", "startMonitorClick", "startSnsFinderMonitor", "sPageName", "startWaterfallsFlowMonitor", "eventId", "stop19943OfsnsFinder", "curSession", "stopFinderFragmentMonitor", "stopFragmentFeedFlowMonitor", "stopItemDecorationMonitor", "stopMonitorClick", "stopSnsFinderMonitor", "stopWaterfallsFlowMonitor", "unregisterClickListener", "unregisterFinderFragmentListener", "unregisterListener", "RecycylerScrollListener", "plugin-expt_release"})
public final class k
{
  private static final List<e> mListeners;
  private static com.tencent.mm.hellhoundlib.a.c sAd;
  private static final HashMap<String, List<Pair<String, String>>> sEh;
  private static final l sFQ;
  private static final b sFR;
  private static final m sFS;
  private static final com.tencent.mm.plugin.expt.hellhound.a.b.c sFT;
  private static final com.tencent.mm.plugin.expt.hellhound.a.a.b sFU;
  private static final com.tencent.mm.plugin.expt.hellhound.a.b.d.d sFV;
  private static final a sFW;
  private static final n sFX;
  public static final k sFY;
  
  static
  {
    AppMethodBeat.i(220998);
    sFY = new k();
    sEh = new HashMap();
    mListeners = (List)new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V"));
    localArrayList.add(Pair.create("onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V"));
    ((Map)sEh).put("android/support/v7/widget/RecyclerView$OnScrollListener", localArrayList);
    sAd = (com.tencent.mm.hellhoundlib.a.c)new a();
    sFQ = new l();
    sFR = new b();
    sFS = new m();
    sFT = new com.tencent.mm.plugin.expt.hellhound.a.b.c();
    sFU = new com.tencent.mm.plugin.expt.hellhound.a.a.b();
    sFV = new com.tencent.mm.plugin.expt.hellhound.a.b.d.d();
    sFW = new a();
    sFX = new n();
    AppMethodBeat.o(220998);
  }
  
  public static final void a(Activity paramActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(220981);
    com.tencent.mm.plugin.expt.hellhound.a.b.c localc = sFT;
    Object localObject;
    if (paramFragment == null) {
      if (paramActivity != null)
      {
        localObject = paramActivity.getClass();
        if (localObject != null)
        {
          localObject = ((Class)localObject).getName();
          c.a locala = c.sFa;
          if (!c.cPe().contains(localObject)) {
            break label363;
          }
          Log.i("HABBYGE-MALI.WaterfallsFlowMonitor", "monitor: poageName=".concat(String.valueOf(localObject)));
          localc.sCH = ((String)localObject);
          sFY.a((e)localc.sCJ);
          localc.sCI = new com.tencent.mm.plugin.expt.hellhound.a.b.d.j(paramActivity, paramFragment);
          localObject = localc.sCI;
          if (localObject == null) {
            break label363;
          }
          if (paramFragment != null) {
            break label268;
          }
          if (paramActivity == null) {
            break label232;
          }
          paramFragment = paramActivity.getClass();
          if (paramFragment == null) {
            break label232;
          }
          paramFragment = paramFragment.getName();
          label138:
          if (!p.j(paramFragment, c.sEQ)) {
            break label249;
          }
          if (!p.j(paramFragment, c.sES)) {
            break label237;
          }
          Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: 7Event !!");
          ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).n(paramActivity, paramLong);
          label174:
          c.sER = null;
          c.sEQ = null;
        }
      }
    }
    for (;;)
    {
      paramActivity = (d)((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).sHI.sGV;
      p.h(paramActivity, "listener");
      sFW.a(paramActivity);
      AppMethodBeat.o(220981);
      return;
      localObject = null;
      break;
      localObject = paramFragment.getClass().getName();
      break;
      label232:
      paramFragment = null;
      break label138;
      label237:
      Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: startActivity !!");
      break label174;
      label249:
      Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: Back to activity !!");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).n(paramActivity, paramLong);
      break label174;
      switch (paramInt)
      {
      case 1: 
      default: 
        Log.printErrStackTrace("HABBYGE-MALI.WaterfallsFlowStatistics", (Throwable)new NullPointerException("startCompute, fragment, miss !!"), "", new Object[0]);
        break;
      case 0: 
        Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, resume !!");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).n(paramFragment, paramLong);
        break;
      case 2: 
        label268:
        Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, 7Event !!");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).n(paramFragment, paramLong);
      }
    }
    label363:
    AppMethodBeat.o(220981);
  }
  
  public static void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(220990);
    p.h(paramFragmentActivity, "activity");
    p.h(paramFragment, "fragment");
    com.tencent.mm.plugin.expt.hellhound.a.a.b localb = sFU;
    p.h(paramFragmentActivity, "activity");
    p.h(paramFragment, "fragment");
    paramFragment = paramFragment.getClass().getName();
    p.g(paramFragment, "fragment.javaClass.name");
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
            AppMethodBeat.o(220990);
            return;
          } while (!paramFragment.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment"));
          if (localb.sBG == null) {
            localb.sBG = ((com.tencent.mm.plugin.expt.hellhound.a.b.a.o)new com.tencent.mm.plugin.expt.hellhound.a.b.a.f((Activity)paramFragmentActivity));
          }
          paramFragmentActivity = localb.sBG;
          if (paramFragmentActivity == null) {
            break;
          }
          paramFragmentActivity.startMonitor();
          AppMethodBeat.o(220990);
          return;
        } while (!paramFragment.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment"));
        if (localb.sBI == null) {
          localb.sBI = ((com.tencent.mm.plugin.expt.hellhound.a.b.a.o)new com.tencent.mm.plugin.expt.hellhound.a.b.a.j((Activity)paramFragmentActivity));
        }
        paramFragmentActivity = localb.sBI;
      } while (paramFragmentActivity == null);
      paramFragmentActivity.startMonitor();
      AppMethodBeat.o(220990);
      return;
    } while (!paramFragment.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment"));
    if (localb.sBH == null) {
      localb.sBH = ((com.tencent.mm.plugin.expt.hellhound.a.b.a.o)new g((Activity)paramFragmentActivity));
    }
    paramFragmentActivity = localb.sBH;
    if (paramFragmentActivity != null)
    {
      paramFragmentActivity.startMonitor();
      AppMethodBeat.o(220990);
      return;
      AppMethodBeat.o(220990);
      return;
    }
    AppMethodBeat.o(220990);
  }
  
  public static final void a(com.tencent.mm.plugin.expt.hellhound.core.d paramd)
  {
    AppMethodBeat.i(220973);
    p.h(paramd, "listener");
    Object localObject = sFR;
    p.h(paramd, "listener");
    localObject = ((b)localObject).sEc;
    if (localObject != null)
    {
      p.h(paramd, "listener");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject).szZ = paramd;
      AppMethodBeat.o(220973);
      return;
    }
    AppMethodBeat.o(220973);
  }
  
  public static final void a(cyl paramcyl)
  {
    AppMethodBeat.i(220987);
    n.c(paramcyl);
    AppMethodBeat.o(220987);
  }
  
  public static final Fragment ab(Activity paramActivity)
  {
    Object localObject2 = null;
    AppMethodBeat.i(220975);
    b localb = sFR;
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
      AppMethodBeat.o(220975);
      return paramActivity;
      label53:
      p.g(paramActivity, "activity?.javaClass?.name ?: return null");
      if ((p.j(paramActivity, "com.tencent.mm.plugin.finder.ui.FinderHomeUI") ^ true))
      {
        localObject1 = localObject2;
        if ((p.j(paramActivity, "com.tencent.mm.plugin.finder.ui.FinderConversationUI") ^ true)) {}
      }
      else
      {
        localObject1 = localb.l(null, -1);
      }
    }
  }
  
  public static final void apN(String paramString)
  {
    AppMethodBeat.i(220969);
    l locall = sFQ;
    if (!l.apW(paramString))
    {
      Log.i("HABBYGE-MALI.RecyclerItemDecorationCallback", "monitor");
      paramString = locall.sCb;
      if (paramString != null) {
        paramString.clear();
      }
      com.tencent.mm.hellhoundlib.a.axP();
      com.tencent.mm.hellhoundlib.a.c((Map)locall.sEh, (com.tencent.mm.hellhoundlib.a.c)locall.sFZ);
    }
    AppMethodBeat.o(220969);
  }
  
  public static final void apO(String paramString)
  {
    AppMethodBeat.i(220970);
    l locall = sFQ;
    if (!l.apW(paramString))
    {
      Log.i("HABBYGE-MALI.RecyclerItemDecorationCallback", "unmonitor");
      paramString = locall.sCb;
      if (paramString != null)
      {
        paramString = (RecyclerView)paramString.get();
        if (paramString != null) {
          paramString.b((RecyclerView.l)locall.sGa);
        }
      }
      paramString = locall.sCb;
      if (paramString != null) {
        paramString.clear();
      }
      locall.sCb = null;
      com.tencent.mm.hellhoundlib.a.axP();
      com.tencent.mm.hellhoundlib.a.d((Map)locall.sEh, (com.tencent.mm.hellhoundlib.a.c)locall.sFZ);
    }
    AppMethodBeat.o(220970);
  }
  
  public static final void apP(String paramString)
  {
    AppMethodBeat.i(220971);
    b localb = sFR;
    localb.sDY = paramString;
    if ((!(p.j("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString) ^ true)) || (!(p.j("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString) ^ true)))
    {
      Log.i("HABBYGE-MALI.FinderFragmentCallback", "monitor...");
      localb.afB = -1;
      localb.sEa = true;
      localb.sEb = false;
      com.tencent.mm.hellhoundlib.a.axP();
      com.tencent.mm.hellhoundlib.a.c((Map)localb.sEh, (com.tencent.mm.hellhoundlib.a.c)localb.sEi);
    }
    AppMethodBeat.o(220971);
  }
  
  public static final void apQ(String paramString)
  {
    AppMethodBeat.i(220972);
    b localb = sFR;
    localb.sDZ = paramString;
    if ((!(p.j("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString) ^ true)) || (!(p.j("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString) ^ true)))
    {
      Log.i("HABBYGE-MALI.FinderFragmentCallback", "unmonitor...");
      localb.sEa = false;
      localb.sEb = true;
      com.tencent.mm.hellhoundlib.a.axP();
      com.tencent.mm.hellhoundlib.a.d((Map)localb.sEh, (com.tencent.mm.hellhoundlib.a.c)localb.sEi);
    }
    AppMethodBeat.o(220972);
  }
  
  public static final void apR(String paramString)
  {
    AppMethodBeat.i(220983);
    if ((p.j("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (p.j("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)))
    {
      paramString = sFU;
      Log.i("HABBYGE-MALI.FragmentFeedStatistics", "stop: free...");
      com.tencent.mm.plugin.expt.hellhound.a.b.a.o localo = paramString.sBG;
      if (localo != null) {
        localo.free();
      }
      paramString.sBG = null;
      localo = paramString.sBH;
      if (localo != null) {
        localo.free();
      }
      paramString.sBH = null;
      localo = paramString.sBI;
      if (localo != null) {
        localo.free();
      }
      paramString.sBI = null;
    }
    AppMethodBeat.o(220983);
  }
  
  public static final void apS(String paramString)
  {
    AppMethodBeat.i(220984);
    if ((p.j("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (p.j("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)))
    {
      sFW.cMH();
      AppMethodBeat.o(220984);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.sIy;
    localObject = b.a.cPQ();
    if (((p.j(localObject, "999")) || (p.j(localObject, "101")) || (p.j(localObject, "102")) || (p.j(localObject, "123"))) && ((p.j("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", paramString)) || (p.j("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", paramString)) || (p.j("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", paramString)))) {
      sFW.cMH();
    }
    AppMethodBeat.o(220984);
  }
  
  public static final void apT(String paramString)
  {
    AppMethodBeat.i(220985);
    if (paramString == null)
    {
      AppMethodBeat.o(220985);
      return;
    }
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(220985);
      return;
      if (paramString.equals("SnsTimeLineUI"))
      {
        sFX.cMH();
        AppMethodBeat.o(220985);
        return;
        if (paramString.equals("com.tencent.mm.plugin.sns.ui.SnsTimeLineUI")) {
          sFX.cMH();
        }
      }
    }
  }
  
  public static final void apU(String paramString)
  {
    AppMethodBeat.i(220986);
    if ((p.j("SnsTimeLineUI", paramString)) || (p.j("com.tencent.mm.plugin.sns.ui.SnsTimeLineUI", paramString))) {
      sFX.cOG();
    }
    AppMethodBeat.o(220986);
  }
  
  public static final void apV(String paramString)
  {
    AppMethodBeat.i(220989);
    if ((p.j("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (p.j("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)))
    {
      sFW.cOG();
      AppMethodBeat.o(220989);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.sIy;
    localObject = b.a.cPQ();
    if (((p.j(localObject, "999")) || (p.j(localObject, "101")) || (p.j(localObject, "102")) || (p.j(localObject, "123"))) && ((p.j("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", paramString)) || (p.j("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", paramString)) || (p.j("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", paramString)))) {
      sFW.cOG();
    }
    AppMethodBeat.o(220989);
  }
  
  public static final void b(Activity paramActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(220982);
    com.tencent.mm.plugin.expt.hellhound.a.b.c localc = sFT;
    Object localObject;
    if (paramFragment == null) {
      if (paramActivity != null)
      {
        localObject = paramActivity.getClass();
        if (localObject != null)
        {
          localObject = ((Class)localObject).getName();
          c.a locala = c.sFa;
          if (c.cPe().contains(localObject))
          {
            Log.i("HABBYGE-MALI.WaterfallsFlowMonitor", "unmonitor: poageName=".concat(String.valueOf(localObject)));
            sFY.b((e)localc.sCJ);
            localObject = localc.sCI;
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
              if (!p.j(paramFragment, c.sER)) {
                break label243;
              }
              Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: finish cur page !");
              ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).sHC = 1;
              paramInt = 1;
              label162:
              ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).o(paramActivity, paramLong);
              if (paramInt != 0)
              {
                paramActivity = c.sFa;
                c.a.cPj();
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      paramActivity = (d)((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).sHI.sGV;
      p.h(paramActivity, "listener");
      sFW.b(paramActivity);
      localc.sCI = null;
      AppMethodBeat.o(220982);
      return;
      localObject = null;
      break;
      localObject = paramFragment.getClass().getName();
      break;
      label238:
      paramFragment = null;
      break label118;
      label243:
      if (((p.j(paramFragment, c.sEQ) ^ true)) && (c.sEQ != null))
      {
        Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: startActivity another page !");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).sHC = 1;
        paramInt = 0;
        break label162;
      }
      Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: 8Event !");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).sHC = 2;
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
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).sHC = 1;
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).o(paramFragment, paramLong);
        break;
      case 3: 
        label303:
        Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, 8Event !!");
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).sHC = 2;
        ((com.tencent.mm.plugin.expt.hellhound.a.b.d.j)localObject).o(paramFragment, paramLong);
      }
    }
  }
  
  public static void b(FragmentActivity paramFragmentActivity, Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(220991);
    p.h(paramFragmentActivity, "activity");
    p.h(paramFragment, "fragment");
    com.tencent.mm.plugin.expt.hellhound.a.a.b localb = sFU;
    p.h(paramFragmentActivity, "activity");
    p.h(paramFragment, "fragment");
    paramFragmentActivity = paramFragment.getClass().getName();
    p.g(paramFragmentActivity, "fragment.javaClass.name");
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
            AppMethodBeat.o(220991);
            return;
          } while (!paramFragmentActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment"));
          paramFragmentActivity = localb.sBG;
          if (paramFragmentActivity == null) {
            break;
          }
          paramFragmentActivity.stopMonitor();
          AppMethodBeat.o(220991);
          return;
        } while (!paramFragmentActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment"));
        paramFragmentActivity = localb.sBI;
      } while (paramFragmentActivity == null);
      paramFragmentActivity.stopMonitor();
      AppMethodBeat.o(220991);
      return;
    } while (!paramFragmentActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment"));
    paramFragmentActivity = localb.sBH;
    if (paramFragmentActivity != null)
    {
      paramFragmentActivity.stopMonitor();
      AppMethodBeat.o(220991);
      return;
      AppMethodBeat.o(220991);
      return;
    }
    AppMethodBeat.o(220991);
  }
  
  public static final void b(cyl paramcyl)
  {
    AppMethodBeat.i(220988);
    n.d(paramcyl);
    AppMethodBeat.o(220988);
  }
  
  public static void cMH()
  {
    AppMethodBeat.i(220966);
    Log.i("HABBYGE-MALI.RecyclerCallback", "monitor...");
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.a((Map)sEh, sAd);
    Object localObject1 = sFS;
    Log.i("HABBYGE-MALI.RefreshLoadMoreCallback", "startMonitor...");
    Object localObject2 = new i();
    Log.i("HABBYGE-MALI.RLBeginCallback", "startMonitor...");
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.a((Map)((i)localObject2).sEh, (com.tencent.mm.hellhoundlib.a.c)((i)localObject2).sFK);
    localObject2 = new j((m)localObject1);
    Log.i("HABBYGE-MALI.RLEndCallback", "startMonitor...");
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.a((Map)((j)localObject2).sEh, (com.tencent.mm.hellhoundlib.a.c)((j)localObject2).sFM);
    localObject1 = new o((m)localObject1);
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.a((Map)((o)localObject1).sEh, (com.tencent.mm.hellhoundlib.a.c)((o)localObject1).sGr);
    new h();
    com.tencent.mm.plugin.expt.hellhound.a.b.d.f.sHi.reset();
    com.tencent.mm.plugin.expt.hellhound.a.b.d.f.sHi.cPr();
    AppMethodBeat.o(220966);
  }
  
  public static final Fragment cOk()
  {
    AppMethodBeat.i(220974);
    b localb = sFR;
    Object localObject1 = localb.sEc;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).sCC;
      if (localObject1 != null)
      {
        localObject1 = (Fragment)((WeakReference)localObject1).get();
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject1 = localb.sEd;
          if (localObject1 == null) {
            break label87;
          }
        }
      }
    }
    label87:
    for (localObject1 = (UIComponentActivity)((WeakReference)localObject1).get();; localObject1 = null)
    {
      localObject2 = (Fragment)localb.l(localObject1, -1);
      AppMethodBeat.o(220974);
      return localObject2;
      localObject1 = null;
      break;
      localObject1 = null;
      break;
    }
  }
  
  public static final void cPn() {}
  
  public static final void d(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(220976);
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
        locald = sFV;
        if (paramActivity != null)
        {
          localObject1 = paramActivity.getClass().getName();
          p.g(localObject1, "activity.javaClass.name");
          localObject2 = c.sFa;
          if ((c.cPd().contains(localObject1)) && (locald.sHb == null))
          {
            localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE((String)localObject1);
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
      AppMethodBeat.o(220976);
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
        localObject1 = sFR;
        if (paramActivity == null)
        {
          paramActivity = new t("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
          AppMethodBeat.o(220976);
          throw paramActivity;
        }
      case -936307702: 
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI")) {
          break;
        }
        localObject1 = sFR;
        if (paramActivity == null)
        {
          paramActivity = new t("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
          AppMethodBeat.o(220976);
          throw paramActivity;
        }
      case -2013384910: 
        if (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderConversationUI")) {
          break;
        }
        localObject1 = sFR;
        if (paramActivity == null)
        {
          paramActivity = new t("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
          AppMethodBeat.o(220976);
          throw paramActivity;
        }
        ((b)localObject1).b((FragmentActivity)paramActivity, paramLong);
        AppMethodBeat.o(220976);
        return;
        ((b)localObject1).b((FragmentActivity)paramActivity, paramLong);
        AppMethodBeat.o(220976);
        return;
        p.h((FragmentActivity)paramActivity, "activity");
        paramActivity = ((b)localObject1).sEc;
        if (paramActivity != null)
        {
          paramActivity.sCF = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
          localObject1 = paramActivity.sCF;
          if (localObject1 == null) {
            p.btv("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
          localObject1 = paramActivity.sCF;
          if (localObject1 == null) {
            p.btv("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).dMl = com.tencent.mm.plugin.expt.hellhound.core.b.aoE("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI");
          localObject1 = paramActivity.sCF;
          if (localObject1 == null) {
            p.btv("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).sGC = paramLong;
          localObject1 = paramActivity.sCF;
          if (localObject1 == null) {
            p.btv("statyTimeStaticLbsList");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).sGF = "143";
          paramActivity = paramActivity.sCF;
          if (paramActivity == null) {
            p.btv("statyTimeStaticLbsList");
          }
          paramActivity.dYn = c.b.sFb.value;
          Log.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderLbsStreamListUIResume...");
          AppMethodBeat.o(220976);
          return;
        }
        AppMethodBeat.o(220976);
        return;
        p.g(localObject3, "HellhoundUtil.getShortNa…fPage(pageName) ?: return");
        int i = paramActivity.hashCode();
        localObject2 = paramActivity.getIntent().getStringExtra("key_extra_info");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        com.tencent.mm.plugin.expt.hellhound.a.b.d.d.a((String)localObject3, i, paramLong, (String)localObject1);
        Log.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV2, sPage=" + (String)localObject3 + ", hashCode=" + i);
        if (com.tencent.mm.plugin.expt.hellhound.a.b.d.f.sHi.dm((String)localObject3, i) == null)
        {
          localObject2 = new cym();
          ((cym)localObject2).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
          ((cym)localObject2).dMl = ((String)localObject3);
          ((cym)localObject2).aHK = i;
          ((cym)localObject2).sGC = paramLong;
          b.a locala = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.sIy;
          ((cym)localObject2).sGF = b.a.cPQ();
          ((cym)localObject2).dYn = c.b.sFc.value;
          ((cym)localObject2).extraInfo = ((String)localObject1);
          com.tencent.mm.plugin.expt.hellhound.a.b.d.f.sHi.c((cym)localObject2);
          Log.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV2, YES, sPage=" + (String)localObject3 + ", hashCode=" + i);
          locald.sHb = ((String)localObject3);
        }
        break;
      }
    }
    label729:
    p.g(localObject2, "activity?.javaClass?.name ?: return");
    Object localObject1 = c.sFa;
    boolean bool;
    if ((c.cPc().contains(localObject2)) && ((locald.sHa == null) || (!(p.j(localObject2, locald.sHa) ^ true))))
    {
      locald.sHa = ((String)localObject2);
      locald.sGZ = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
      localObject1 = locald.sGZ;
      if (localObject1 == null) {
        p.btv("mStayTime");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
      localObject1 = locald.sGZ;
      if (localObject1 == null) {
        p.btv("mStayTime");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).dMl = com.tencent.mm.plugin.expt.hellhound.core.b.aoE((String)localObject2);
      localObject1 = locald.sGZ;
      if (localObject1 == null) {
        p.btv("mStayTime");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).sGC = paramLong;
      localObject1 = locald.sGZ;
      if (localObject1 == null) {
        p.btv("mStayTime");
      }
      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.sIy;
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).sGF = b.a.cPQ();
      localObject1 = locald.sGZ;
      if (localObject1 == null) {
        p.btv("mStayTime");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).dYn = c.b.sFb.value;
      localObject3 = locald.sGZ;
      if (localObject3 == null) {
        p.btv("mStayTime");
      }
      localObject1 = paramActivity.getIntent().getStringExtra("key_extra_info");
      paramActivity = (Activity)localObject1;
      if (localObject1 == null) {
        paramActivity = "";
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).extraInfo = paramActivity;
      if (!p.j(localObject2, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
        break label1097;
      }
      paramActivity = locald.sGZ;
      if (paramActivity == null) {
        p.btv("mStayTime");
      }
      localObject1 = c.sFa;
      if (c.cPf() != c.d.sFl.value) {
        break label1091;
      }
      bool = true;
    }
    for (paramActivity.sGG = bool;; paramActivity.sGG = false)
    {
      paramActivity = new StringBuilder("doPageResume: ");
      localObject1 = locald.sGZ;
      if (localObject1 == null) {
        p.btv("mStayTime");
      }
      Log.i("HABBYGE-MALI.FinderShareStatistics", ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).dMl);
      AppMethodBeat.o(220976);
      return;
      label1091:
      bool = false;
      break;
      label1097:
      paramActivity = locald.sGZ;
      if (paramActivity == null) {
        p.btv("mStayTime");
      }
    }
  }
  
  public static final void e(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(220977);
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
            localObject2 = sFV;
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
            AppMethodBeat.o(220977);
            return;
            localObject1 = null;
            break;
            switch (((String)localObject1).hashCode())
            {
            }
          }
        } while (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderHomeUI"));
        localObject1 = sFR;
        if (paramActivity != null) {
          break label253;
        }
        paramActivity = new t("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
        AppMethodBeat.o(220977);
        throw paramActivity;
      } while (!((String)localObject1).equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
      localObject1 = sFR;
      if (paramActivity != null) {
        break label270;
      }
      paramActivity = new t("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
      AppMethodBeat.o(220977);
      throw paramActivity;
    } while (!((String)localObject1).equals("com.tencent.mm.plugin.finder.ui.FinderConversationUI"));
    Object localObject1 = sFR;
    if (paramActivity == null)
    {
      paramActivity = new t("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
      AppMethodBeat.o(220977);
      throw paramActivity;
    }
    ((b)localObject1).c((FragmentActivity)paramActivity, paramLong);
    AppMethodBeat.o(220977);
    return;
    label253:
    ((b)localObject1).c((FragmentActivity)paramActivity, paramLong);
    AppMethodBeat.o(220977);
    return;
    label270:
    p.h((FragmentActivity)paramActivity, "activity");
    paramActivity = ((b)localObject1).sEc;
    if (paramActivity != null)
    {
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI");
      if (((com.tencent.mm.plugin.expt.hellhound.a.b.b)paramActivity).sCF != null) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          localObject2 = paramActivity.sCF;
          if (localObject2 == null) {
            p.btv("statyTimeStaticLbsList");
          }
          if (p.j(((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).dMl, localObject1))
          {
            localObject1 = paramActivity.sCF;
            if (localObject1 == null) {
              p.btv("statyTimeStaticLbsList");
            }
            ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).sGD = paramLong;
            localObject1 = paramActivity.sCF;
            if (localObject1 == null) {
              p.btv("statyTimeStaticLbsList");
            }
            paramLong = ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).sGD;
            localObject1 = paramActivity.sCF;
            if (localObject1 == null) {
              p.btv("statyTimeStaticLbsList");
            }
            long l = ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).sGC;
            localObject1 = paramActivity.sCF;
            if (localObject1 == null) {
              p.btv("statyTimeStaticLbsList");
            }
            ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).sGB = (paramLong - l);
            localObject1 = paramActivity.sCF;
            if (localObject1 == null) {
              p.btv("statyTimeStaticLbsList");
            }
            ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).sGF = "143";
            localObject1 = paramActivity.sCF;
            if (localObject1 == null) {
              p.btv("statyTimeStaticLbsList");
            }
            ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).sGE = com.tencent.mm.plugin.expt.hellhound.core.b.cNB();
            localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.sGv;
            paramActivity = paramActivity.sCF;
            if (paramActivity == null) {
              p.btv("statyTimeStaticLbsList");
            }
            a.a.a(paramActivity);
            Log.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderLbsStreamListUIPause...");
          }
        }
        AppMethodBeat.o(220977);
        return;
      }
    }
    AppMethodBeat.o(220977);
    return;
    label542:
    p.g(localObject1, "activity?.javaClass?.name ?: return");
    Object localObject3 = c.sFa;
    if (c.cPc().contains(localObject1))
    {
      if (((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).sHa == null)
      {
        AppMethodBeat.o(220977);
        return;
      }
      if (!(p.j(localObject1, ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).sHa) ^ true))
      {
        if (((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).sHb == null) {
          ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).sHa = null;
        }
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE((String)localObject1);
        localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).sGZ;
        if (localObject1 == null) {
          p.btv("mStayTime");
        }
        if (p.j(((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).dMl, localObject3))
        {
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).sGZ;
          if (localObject1 == null) {
            p.btv("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).sGD = paramLong;
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).sGZ;
          if (localObject1 == null) {
            p.btv("mStayTime");
          }
          com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).sGZ;
          if (localb == null) {
            p.btv("mStayTime");
          }
          paramLong = localb.sGD;
          localb = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).sGZ;
          if (localb == null) {
            p.btv("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).sGB = (paramLong - localb.sGC);
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).sGZ;
          if (localObject1 == null) {
            p.btv("mStayTime");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).sGE = com.tencent.mm.plugin.expt.hellhound.core.b.cNB();
          localb = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).sGZ;
          if (localb == null) {
            p.btv("mStayTime");
          }
          localObject1 = paramActivity.getIntent().getStringExtra("key_enter_source_info");
          paramActivity = (Activity)localObject1;
          if (localObject1 == null) {
            paramActivity = "";
          }
          localb.sGH = paramActivity;
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.sGv;
          paramActivity = ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject2).sGZ;
          if (paramActivity == null) {
            p.btv("mStayTime");
          }
          a.a.a(paramActivity);
          Log.i("HABBYGE-MALI.FinderShareStatistics", "onPagePaused: ".concat(String.valueOf(localObject3)));
        }
      }
    }
    AppMethodBeat.o(220977);
  }
  
  public static final void f(Activity paramActivity, long paramLong)
  {
    long l1 = 0L;
    AppMethodBeat.i(220978);
    Object localObject3 = sFV;
    if (paramActivity == null)
    {
      AppMethodBeat.o(220978);
      return;
    }
    Object localObject1 = paramActivity.getClass().getName();
    p.g(localObject1, "activity.javaClass.name");
    Object localObject2 = c.sFa;
    if (c.cPd().contains(localObject1))
    {
      localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE((String)localObject1);
      if (localObject2 == null)
      {
        AppMethodBeat.o(220978);
        return;
      }
      p.g(localObject2, "HellhoundUtil.getShortNa…fPage(pageName) ?: return");
      int i = paramActivity.hashCode();
      localObject1 = paramActivity.getIntent().getStringExtra("key_enter_source_info");
      paramActivity = (Activity)localObject1;
      if (localObject1 == null) {
        paramActivity = "";
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.d.d)localObject3).sHb = null;
      Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV1: sPage=" + (String)localObject2 + ", hashCode=" + i + ", enterSourceInfo=" + paramActivity);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.d.f.sHi.dk((String)localObject2, i);
      if (localObject1 == null)
      {
        Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV2: sPage=" + (String)localObject2 + ", hashCode=" + i + ", enterSourceInfo=" + paramActivity);
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.d.f.sHi.dm((String)localObject2, i);
        if (localObject1 == null) {
          AppMethodBeat.o(220978);
        }
      }
      else
      {
        Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV1: compare, " + ((cym)localObject1).dMl + " == " + (String)localObject2 + ", " + ((cym)localObject1).aHK + " == " + i);
        ((cym)localObject1).sGD = paramLong;
        long l2 = ((cym)localObject1).sGD;
        long l3 = ((cym)localObject1).sGC;
        localObject3 = ((cym)localObject1).MDv;
        p.g(localObject3, "statistics.stayTimeOnBackground");
        l2 = l2 - l3 - com.tencent.mm.plugin.expt.hellhound.a.b.d.d.ab((LinkedList)localObject3);
        if (l2 < 0L) {}
        for (;;)
        {
          ((cym)localObject1).sGB = l1;
          ((cym)localObject1).sGE = com.tencent.mm.plugin.expt.hellhound.core.b.cNB();
          ((cym)localObject1).dYn = c.b.sFd.value;
          ((cym)localObject1).sGH = paramActivity;
          localObject3 = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.sGv;
          a.a.a(com.tencent.mm.plugin.expt.hellhound.a.b.d.d.a((cym)localObject1, c.b.sFd.value));
          com.tencent.mm.plugin.expt.hellhound.a.b.d.f.sHi.dl((String)localObject2, i);
          Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV1: report, " + (String)localObject2 + ", " + i);
          break;
          l1 = l2;
        }
      }
      Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV2: compare, " + ((cym)localObject1).dMl + " == " + (String)localObject2 + ", " + ((cym)localObject1).aHK + " == " + i);
      ((cym)localObject1).sGD = paramLong;
      ((cym)localObject1).sGB = (((cym)localObject1).sGD - ((cym)localObject1).sGC);
      ((cym)localObject1).sGE = com.tencent.mm.plugin.expt.hellhound.core.b.cNB();
      ((cym)localObject1).dYn = c.b.sFc.value;
      ((cym)localObject1).sGH = paramActivity;
      paramActivity = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.sGv;
      a.a.a(com.tencent.mm.plugin.expt.hellhound.a.b.d.d.a((cym)localObject1, c.b.sFc.value));
      com.tencent.mm.plugin.expt.hellhound.a.b.d.f.sHi.dn((String)localObject2, i);
      Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV2: report, " + (String)localObject2 + ", " + i);
    }
    AppMethodBeat.o(220978);
  }
  
  public static final void m(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220979);
    com.tencent.mm.plugin.expt.hellhound.a.b.d.d.p(paramString, paramInt, paramLong);
    Log.i("HABBYGE-MALI.FinderShareStatistics", "on8EventV2: pageName=" + paramString + ", hashCode=" + paramInt);
    if (com.tencent.mm.plugin.expt.hellhound.core.b.aoz(paramString))
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.d.f.sHi.cPr();
      AppMethodBeat.o(220979);
      return;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.a.b.d.f.sHi.cPq();
    if (paramString == null)
    {
      AppMethodBeat.o(220979);
      return;
    }
    paramString.sGD = paramLong;
    paramString.sGB = (paramString.sGD - paramString.sGC);
    paramString.sGE = com.tencent.mm.plugin.expt.hellhound.core.b.cNB();
    paramString.dYn = c.b.sFc.value;
    Log.i("HABBYGE-MALI.FinderShareStatistics", "on8EventV2, statics: " + paramString.dMl + ", " + paramString.aHK);
    a.a locala = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.sGv;
    a.a.a(com.tencent.mm.plugin.expt.hellhound.a.b.d.d.a(paramString, c.b.sFc.value));
    paramString.dYn = 8;
    com.tencent.mm.plugin.expt.hellhound.a.b.d.f.sHi.d(paramString);
    AppMethodBeat.o(220979);
  }
  
  public static final void n(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220980);
    com.tencent.mm.plugin.expt.hellhound.a.b.d.d.o(paramString, paramInt, paramLong);
    com.tencent.mm.plugin.expt.hellhound.a.b.d.d.q(paramString, paramInt, paramLong);
    AppMethodBeat.o(220980);
  }
  
  public final void a(e parame)
  {
    try
    {
      AppMethodBeat.i(220967);
      p.h(parame, "listener");
      if (!mListeners.contains(parame)) {
        mListeners.add(parame);
      }
      AppMethodBeat.o(220967);
      return;
    }
    finally {}
  }
  
  public final void a(m.a parama)
  {
    try
    {
      AppMethodBeat.i(220995);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).a(parama);
      }
      AppMethodBeat.o(220995);
    }
    finally {}
  }
  
  public final void b(e parame)
  {
    try
    {
      AppMethodBeat.i(220968);
      p.h(parame, "listener");
      mListeners.remove(parame);
      AppMethodBeat.o(220968);
      return;
    }
    finally
    {
      parame = finally;
      throw parame;
    }
  }
  
  public final void cOE()
  {
    try
    {
      AppMethodBeat.i(220994);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).cOE();
      }
      AppMethodBeat.o(220994);
    }
    finally {}
  }
  
  public final void cOF()
  {
    try
    {
      AppMethodBeat.i(220997);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).cOF();
      }
      AppMethodBeat.o(220997);
    }
    finally {}
  }
  
  public final void cxo()
  {
    try
    {
      AppMethodBeat.i(220996);
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(220996);
    }
    finally {}
  }
  
  public final void e(RecyclerView paramRecyclerView, int paramInt)
  {
    try
    {
      AppMethodBeat.i(220993);
      p.h(paramRecyclerView, "recyclerView");
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).e(paramRecyclerView, paramInt);
      }
      AppMethodBeat.o(220993);
    }
    finally {}
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    try
    {
      AppMethodBeat.i(220992);
      p.h(paramRecyclerView, "recyclerView");
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).onScrollStateChanged(paramRecyclerView, paramInt);
      }
      AppMethodBeat.o(220992);
    }
    finally {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerCallback$RecycylerScrollListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "()V", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  static final class a
    implements com.tencent.mm.hellhoundlib.a.c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(220965);
      if ((paramString1 != null) && (kotlin.n.n.J(paramString1, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$", false)))
      {
        AppMethodBeat.o(220965);
        return;
      }
      if ((p.j("onScrollStateChanged", paramString2)) && (p.j("(Landroid/support/v7/widget/RecyclerView;I)V", paramString3)))
      {
        if (paramArrayOfObject != null)
        {
          if (paramArrayOfObject.length >= 2)
          {
            paramString2 = paramArrayOfObject[0];
            if ((paramString2 instanceof RecyclerView))
            {
              paramString1 = k.sFY;
              paramString2 = (RecyclerView)paramString2;
              paramString3 = paramArrayOfObject[1];
              if (paramString3 == null)
              {
                paramString1 = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(220965);
                throw paramString1;
              }
              paramString1.onScrollStateChanged(paramString2, ((Integer)paramString3).intValue());
            }
          }
          AppMethodBeat.o(220965);
          return;
        }
        AppMethodBeat.o(220965);
        return;
      }
      if ((p.j("onScrolled", paramString2)) && (p.j("(Landroid/support/v7/widget/RecyclerView;II)V", paramString3)) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 3))
      {
        paramString2 = paramArrayOfObject[0];
        if ((paramString2 instanceof RecyclerView))
        {
          paramString1 = k.sFY;
          paramString2 = (RecyclerView)paramString2;
          paramString3 = paramArrayOfObject[1];
          if (paramString3 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(220965);
            throw paramString1;
          }
          ((Integer)paramString3).intValue();
          paramString3 = paramArrayOfObject[2];
          if (paramString3 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(220965);
            throw paramString1;
          }
          paramString1.e(paramString2, ((Integer)paramString3).intValue());
        }
      }
      AppMethodBeat.o(220965);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.k
 * JD-Core Version:    0.7.0.1
 */