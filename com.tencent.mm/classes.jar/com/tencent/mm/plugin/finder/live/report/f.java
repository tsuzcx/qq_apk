package com.tencent.mm.plugin.finder.live.report;

import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ab;
import com.tencent.mm.plugin.finder.model.ah;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.search.FinderContactSearchUI;
import com.tencent.mm.plugin.finder.search.FinderContactSearchUI.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.d.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.ejv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/HellFeedSingleExposure;", "", "mCallback", "Lcom/tencent/mm/plugin/finder/live/report/IFeedEventCallback;", "(Lcom/tencent/mm/plugin/finder/live/report/IFeedEventCallback;)V", "TAG", "", "mAbsActionType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "mAdapterRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getMCallback", "()Lcom/tencent/mm/plugin/finder/live/report/IFeedEventCallback;", "mChatListener", "com/tencent/mm/plugin/finder/live/report/HellFeedSingleExposure$mChatListener$1", "Lcom/tencent/mm/plugin/finder/live/report/HellFeedSingleExposure$mChatListener$1;", "mCommentscene", "mFeedCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveFeed;", "Lkotlin/collections/HashMap;", "mFeedHorizontalCache", "mItemCache", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveItem;", "mLastVisible", "", "mLayoutRef", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mMixSearchAdapterRef", "Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter;", "Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;", "mMixSearchItemCache", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveMixSearchItem;", "mShareCaseList", "", "[Ljava/lang/String;", "mSnsListener", "com/tencent/mm/plugin/finder/live/report/HellFeedSingleExposure$mSnsListener$1", "Lcom/tencent/mm/plugin/finder/live/report/HellFeedSingleExposure$mSnsListener$1;", "monitor_method", "Ljava/lang/reflect/Method;", "onPauseState", "register_method", "unregister_method", "_doOnScroll", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "actionType", "commentscene", "pos", "", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "rvFeeds", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "rvFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "_doOnScrollHorizontal", "doDisappear", "", "doRunOnScroll", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "doRunOnScrollHorizontal", "doSnsEvent", "listView", "Landroid/widget/AbsListView;", "adapter", "Landroid/widget/BaseAdapter;", "firstVisibleItem", "visibleItemCount", "event", "Lcom/tencent/mm/plugin/finder/live/report/HELL_SCROLL_EVENT;", "isSns", "doSnsHorAppear", "handleChat", "handleSns", "onDestroy", "onFeedAllDisappear", "onItemAllDisappear", "onLiveFeedAppear", "hellFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/HellFeed;", "view", "Landroid/view/View;", "onMixSearchAllDisappear", "onScroll", "layoutManager", "onScrollHorizontal", "onSnsAdLiveFeedAppear", "run", "visibleState", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$VisiableState;", "headerShow", "plugin-finder_release"})
public final class f
{
  private final String TAG;
  WeakReference<FinderContactSearchUI.a> yAA;
  private final HashMap<String, i> yAB;
  boolean yAC;
  s.t yAD;
  String yAE;
  final String[] yAF;
  Method yAG;
  Method yAH;
  Method yAI;
  boolean yAJ;
  final a yAK;
  final b yAL;
  WeakReference<LinearLayoutManager> yAq;
  WeakReference<WxRecyclerAdapter<?>> yAr;
  private final HashMap<String, h> yAw;
  private final HashMap<String, j> yAx;
  final HashMap<String, h> yAy;
  final r yAz;
  
  public f(r paramr)
  {
    AppMethodBeat.i(223501);
    this.yAz = paramr;
    this.TAG = "HABBYGE-MALI.HellFeedSingleExposure";
    this.yAw = new HashMap();
    this.yAy = new HashMap();
    this.yAB = new HashMap();
    this.yAx = new HashMap();
    this.yAD = s.t.yGN;
    this.yAE = "";
    this.yAF = new String[] { "61", "temp_6" };
    try
    {
      paramr = Class.forName("com.tencent.mm.ui.chatting.monitor.ChatFeedMonitor");
      p.j(paramr, "Class.forName(className)");
      Method localMethod = paramr.getDeclaredMethod("monitor", new Class[] { AbsListView.class, BaseAdapter.class, Integer.TYPE, Integer.TYPE });
      p.j(localMethod, "monitor_clazz.getDeclare…         Int::class.java)");
      this.yAG = localMethod;
      localMethod = this.yAG;
      if (localMethod == null) {
        p.bGy("monitor_method");
      }
      localMethod.setAccessible(true);
      localMethod = paramr.getDeclaredMethod("registerListener", new Class[] { com.tencent.mm.plugin.expt.hellhound.a.g.a.class });
      p.j(localMethod, "monitor_clazz.getDeclare…FeedListener::class.java)");
      this.yAH = localMethod;
      localMethod = this.yAH;
      if (localMethod == null) {
        p.bGy("register_method");
      }
      localMethod.setAccessible(true);
      paramr = paramr.getDeclaredMethod("unregisterListener", new Class[] { com.tencent.mm.plugin.expt.hellhound.a.g.a.class });
      p.j(paramr, "monitor_clazz.getDeclare…FeedListener::class.java)");
      this.yAI = paramr;
      paramr = this.yAI;
      if (paramr == null) {
        p.bGy("unregister_method");
      }
      paramr.setAccessible(true);
    }
    catch (Exception paramr)
    {
      for (;;)
      {
        Log.e(this.TAG, "init crash: " + paramr.getMessage());
      }
    }
    this.yAK = new a(this);
    this.yAL = new b(this);
    AppMethodBeat.o(223501);
  }
  
  private final com.tencent.mm.vending.j.c<List<String>, List<String>> a(x paramx, s.t paramt, String paramString, int paramInt)
  {
    AppMethodBeat.i(223481);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramx.fmA.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (bu)localIterator.next();
      long l1 = ((bu)localObject1).mf();
      String str = b.Fw(l1);
      p.j(str, "HellhoundUtil.long2UnsignedString(feedIdL)");
      if (this.yAy.containsKey(str))
      {
        Object localObject2;
        if (!this.yAw.containsKey(str))
        {
          paramx = h.yAW;
          p.j(localObject1, "subRvFeed");
          localObject2 = h.a.a((bu)localObject1);
          if (!(localObject1 instanceof y)) {
            break label329;
          }
        }
        label329:
        for (paramx = ((y)localObject1).zAF.username;; paramx = "")
        {
          Object localObject3 = ((d)localObject2).ieT();
          p.j(localObject3, "liveIdTuple3.`$1`()");
          long l2 = ((Number)localObject3).longValue();
          localObject3 = ((d)localObject2).ieU();
          p.j(localObject3, "liveIdTuple3.`$2`()");
          int i = ((Number)localObject3).intValue();
          localObject3 = h.yAW;
          localObject3 = h.a.b((bu)localObject1);
          h.b localb = h.b.yAX;
          localObject2 = ((d)localObject2).ieV();
          p.j(localObject2, "liveIdTuple3.`$3`()");
          paramx = new h((bu)localObject1, paramx, paramInt, str, l1, l2, paramt, paramString, i, (String)localObject3, localb, ((Boolean)localObject2).booleanValue(), false, 0, null, null, null, 126976);
          if ((localObject1 instanceof ab)) {
            paramx.a(s.t.yGM);
          }
          ((Map)this.yAw).put(str, paramx);
          localObject1 = this.yAz;
          if (localObject1 != null) {
            ((r)localObject1).a(paramx, true);
          }
          localArrayList1.add(str);
          break;
        }
      }
      localArrayList2.add(str);
    }
    paramx = com.tencent.mm.vending.j.a.J(localArrayList1, localArrayList2);
    p.j(paramx, "Tuple.make(retIdList, needDelList)");
    AppMethodBeat.o(223481);
    return paramx;
  }
  
  final void a(FinderContactSearchUI.a parama, LinearLayoutManager paramLinearLayoutManager, s.t paramt, String paramString)
  {
    AppMethodBeat.i(223476);
    int j = paramLinearLayoutManager.kJ();
    int k = paramLinearLayoutManager.kL();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = FinderContactSearchUI.a(parama.Aae);
    int i;
    label68:
    Object localObject2;
    String str;
    if (!((Collection)localArrayList2).isEmpty())
    {
      i = 1;
      if ((i == 0) || (j > k)) {
        break label305;
      }
      i = j;
      if ((paramLinearLayoutManager.findViewByPosition(i) != null) && (localArrayList2.size() > i))
      {
        parama = localArrayList2.get(i);
        p.j(parama, "dataList[pos]");
        localObject2 = (bip)parama;
        parama = ((bip)localObject2).contact;
        if (parama != null)
        {
          str = parama.username;
          if (str != null) {
            break label161;
          }
        }
        parama = "";
      }
    }
    label161:
    do
    {
      localArrayList1.add(parama);
      if (i == k) {
        break label305;
      }
      i += 1;
      break label68;
      i = 0;
      break;
      p.j(str, "feed.contact?.username ?: return \"\"");
      parama = str;
    } while (this.yAx.containsKey(str));
    parama = ((bip)localObject2).contact;
    if ((parama != null) && (parama.liveStatus == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      parama = ((bip)localObject2).contact;
      if (parama != null)
      {
        localObject1 = parama.nickname;
        parama = (FinderContactSearchUI.a)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        parama = "";
      }
      Object localObject1 = new j((bip)localObject2, i, str, paramt, paramString, bool, parama);
      ((Map)this.yAx).put(str, localObject1);
      localObject2 = this.yAz;
      parama = str;
      if (localObject2 == null) {
        break;
      }
      ((r)localObject2).a((j)localObject1);
      parama = str;
      break;
    }
    label305:
    parama = this.yAx.entrySet().iterator();
    while (parama.hasNext())
    {
      paramLinearLayoutManager = parama.next();
      p.j(paramLinearLayoutManager, "iterator.next()");
      paramt = (Map.Entry)paramLinearLayoutManager;
      if (!localArrayList1.contains(paramt.getKey()))
      {
        parama.remove();
        paramLinearLayoutManager = this.yAz;
        if (paramLinearLayoutManager != null)
        {
          paramt = paramt.getValue();
          p.j(paramt, "hellFeedPair.value");
          paramLinearLayoutManager.b((j)paramt);
        }
      }
    }
    localArrayList1.clear();
    AppMethodBeat.o(223476);
  }
  
  final void a(WxRecyclerAdapter<?> paramWxRecyclerAdapter, LinearLayoutManager paramLinearLayoutManager, s.t paramt, String paramString)
  {
    AppMethodBeat.i(223468);
    int i = paramLinearLayoutManager.kJ();
    int j = paramLinearLayoutManager.kL();
    if (i == 0)
    {
      if (j < 2) {
        break label522;
      }
      j -= 1;
    }
    label522:
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      List localList = (List)paramWxRecyclerAdapter.data;
      int k;
      label69:
      label81:
      Object localObject1;
      if (!((Collection)localList).isEmpty())
      {
        k = 1;
        if ((k == 0) || (i > j)) {
          break label399;
        }
        if (localList.size() > i)
        {
          paramLinearLayoutManager = localList.get(i);
          paramWxRecyclerAdapter = paramLinearLayoutManager;
          if (!(paramLinearLayoutManager instanceof bu)) {
            paramWxRecyclerAdapter = null;
          }
          localObject1 = (bu)paramWxRecyclerAdapter;
          if (localObject1 != null) {
            break label162;
          }
        }
      }
      for (;;)
      {
        if (i == j) {
          break label399;
        }
        i += 1;
        break label81;
        i -= 1;
        j -= 1;
        break;
        k = 0;
        break label69;
        label162:
        long l1 = ((bu)localObject1).mf();
        paramLinearLayoutManager = b.Fw(l1);
        p.j(paramLinearLayoutManager, "HellhoundUtil.long2UnsignedString(feedIdL)");
        if (!this.yAy.containsKey(paramLinearLayoutManager))
        {
          paramWxRecyclerAdapter = h.yAW;
          Object localObject2 = h.a.a((bu)localObject1);
          paramWxRecyclerAdapter = "";
          if ((localObject1 instanceof BaseFinderFeed)) {
            paramWxRecyclerAdapter = ((BaseFinderFeed)localObject1).feedObject.getUserName();
          }
          Object localObject3 = ((d)localObject2).ieT();
          p.j(localObject3, "liveIdTuple3.`$1`()");
          long l2 = ((Number)localObject3).longValue();
          localObject2 = ((d)localObject2).ieU();
          p.j(localObject2, "liveIdTuple3.`$2`()");
          k = ((Number)localObject2).intValue();
          localObject2 = h.yAW;
          paramWxRecyclerAdapter = new h((bu)localObject1, paramWxRecyclerAdapter, i, paramLinearLayoutManager, l1, l2, paramt, paramString, k, h.a.b((bu)localObject1), h.b.yAX, true, false, 0, null, null, null, 126976);
          if ((localObject1 instanceof ab)) {
            paramWxRecyclerAdapter.a(s.t.yGM);
          }
          ((Map)this.yAy).put(paramLinearLayoutManager, paramWxRecyclerAdapter);
          ((Map)this.yAw).put(paramLinearLayoutManager, paramWxRecyclerAdapter);
          localObject1 = this.yAz;
          if (localObject1 != null) {
            ((r)localObject1).a(paramWxRecyclerAdapter, true);
          }
        }
        localArrayList.add(paramLinearLayoutManager);
      }
      label399:
      paramWxRecyclerAdapter = this.yAy.entrySet().iterator();
      while (paramWxRecyclerAdapter.hasNext())
      {
        paramLinearLayoutManager = paramWxRecyclerAdapter.next();
        p.j(paramLinearLayoutManager, "iterator.next()");
        paramt = (Map.Entry)paramLinearLayoutManager;
        if (!localArrayList.contains(paramt.getKey()))
        {
          paramWxRecyclerAdapter.remove();
          this.yAw.remove(paramt.getKey());
          paramLinearLayoutManager = this.yAz;
          if (paramLinearLayoutManager != null)
          {
            paramt = paramt.getValue();
            p.j(paramt, "hellFeedPair.value");
            paramLinearLayoutManager.b((h)paramt);
          }
        }
      }
      localArrayList.clear();
      AppMethodBeat.o(223468);
      return;
    }
  }
  
  final void b(WxRecyclerAdapter<?> paramWxRecyclerAdapter, LinearLayoutManager paramLinearLayoutManager, s.t paramt, String paramString)
  {
    AppMethodBeat.i(223473);
    int j = paramLinearLayoutManager.kJ();
    int k = paramLinearLayoutManager.kL();
    int m = paramWxRecyclerAdapter.YSk.size();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    List localList = (List)paramWxRecyclerAdapter.data;
    int i;
    if (!((Collection)localList).isEmpty())
    {
      i = 1;
      if ((i == 0) || (j > k)) {
        break label995;
      }
      i = j;
      label86:
      if (paramLinearLayoutManager.findViewByPosition(i) != null) {
        if (i - m >= 0) {
          break label200;
        }
      }
    }
    Object localObject2;
    label200:
    for (j = 0;; j = i - m)
    {
      if (localList.size() > j)
      {
        localObject2 = localList.get(j);
        if (!(localObject2 instanceof x)) {
          break label210;
        }
        paramWxRecyclerAdapter = a((x)localObject2, paramt, paramString, i);
        localArrayList1.addAll((Collection)paramWxRecyclerAdapter.ieT());
        localArrayList2.addAll((Collection)paramWxRecyclerAdapter.ieU());
      }
      if (i == k) {
        break label995;
      }
      i += 1;
      break label86;
      i = 0;
      break;
    }
    label210:
    Object localObject1;
    boolean bool;
    if ((localObject2 instanceof ah))
    {
      localObject1 = (ah)localObject2;
      paramWxRecyclerAdapter = ((ah)localObject1).contact.getUsername();
      if (!this.yAB.containsKey(paramWxRecyclerAdapter)) {
        if (((ah)localObject1).contact.field_liveStatus != 1) {
          break label333;
        }
      }
      label333:
      for (bool = true;; bool = false)
      {
        localObject1 = new i((ah)localObject1, i, paramWxRecyclerAdapter, paramt, paramString, bool, ((ah)localObject1).contact.getNickname());
        ((Map)this.yAB).put(paramWxRecyclerAdapter, localObject1);
        localObject2 = this.yAz;
        if (localObject2 != null) {
          ((r)localObject2).a((i)localObject1);
        }
        localArrayList1.add(paramWxRecyclerAdapter);
        break;
      }
    }
    if ((localObject2 instanceof BaseFinderFeed))
    {
      if (paramt != s.t.yGM) {
        break label1263;
      }
      if (p.h(paramString, s.l.yFP.scene))
      {
        paramWxRecyclerAdapter = s.t.yGO;
        localObject1 = "17";
      }
    }
    for (;;)
    {
      label377:
      localObject2 = (BaseFinderFeed)localObject2;
      Object localObject3 = ((BaseFinderFeed)localObject2).feedObject.getLiveInfo();
      if ((localObject3 != null) && (((bac)localObject3).liveStatus == 1))
      {
        j = 1;
        label411:
        bool = ((BaseFinderFeed)localObject2).feedObject.isLiveFeed();
        if (!bool) {
          break label711;
        }
        paramWxRecyclerAdapter = s.t.yGN;
      }
      label430:
      label711:
      label723:
      label995:
      label1260:
      for (;;)
      {
        long l1 = ((BaseFinderFeed)localObject2).mf();
        localObject3 = b.Fw(l1);
        p.j(localObject3, "HellhoundUtil.long2UnsignedString(feedIdL)");
        Object localObject4;
        Object localObject6;
        Object localObject5;
        Object localObject7;
        long l2;
        int n;
        if (!this.yAw.containsKey(localObject3))
        {
          localObject4 = h.yAW;
          localObject6 = h.a.a((bu)localObject2);
          localObject4 = (bu)localObject2;
          localObject5 = ((BaseFinderFeed)localObject2).feedObject.getUserName();
          localObject7 = ((d)localObject6).ieT();
          p.j(localObject7, "liveIdTuple3.`$1`()");
          l2 = ((Number)localObject7).longValue();
          localObject7 = ((d)localObject6).ieU();
          p.j(localObject7, "liveIdTuple3.`$2`()");
          n = ((Number)localObject7).intValue();
          localObject7 = h.yAW;
          localObject7 = h.a.b((bu)localObject2);
          if (j == 0) {
            break label723;
          }
        }
        for (localObject2 = h.b.yAY;; localObject2 = h.b.yAZ)
        {
          localObject6 = ((d)localObject6).ieV();
          p.j(localObject6, "liveIdTuple3.`$3`()");
          paramWxRecyclerAdapter = new h((bu)localObject4, (String)localObject5, i, (String)localObject3, l1, l2, paramWxRecyclerAdapter, (String)localObject1, n, (String)localObject7, (h.b)localObject2, bool, ((Boolean)localObject6).booleanValue(), 0, null, null, null, 122880);
          ((Map)this.yAw).put(localObject3, paramWxRecyclerAdapter);
          localObject1 = this.yAz;
          if (localObject1 != null) {
            ((r)localObject1).a(paramWxRecyclerAdapter, true);
          }
          localArrayList1.add(localObject3);
          break;
          if (!p.h(paramString, s.l.yFW.scene)) {
            break label1263;
          }
          paramWxRecyclerAdapter = s.t.yGO;
          localObject1 = "18";
          break label377;
          j = 0;
          break label411;
          if (j == 0) {
            break label1260;
          }
          paramWxRecyclerAdapter = s.t.yGO;
          break label430;
        }
        if (!(localObject2 instanceof bu)) {}
        for (paramWxRecyclerAdapter = null;; paramWxRecyclerAdapter = (WxRecyclerAdapter<?>)localObject2)
        {
          localObject2 = (bu)paramWxRecyclerAdapter;
          if (localObject2 == null) {
            break;
          }
          l1 = ((bu)localObject2).mf();
          localObject1 = b.Fw(l1);
          p.j(localObject1, "HellhoundUtil.long2UnsignedString(feedIdL)");
          if (!this.yAw.containsKey(localObject1))
          {
            paramWxRecyclerAdapter = h.yAW;
            localObject3 = h.a.a((bu)localObject2);
            paramWxRecyclerAdapter = "";
            if ((localObject2 instanceof BaseFinderFeed)) {
              paramWxRecyclerAdapter = ((BaseFinderFeed)localObject2).feedObject.getUserName();
            }
            localObject4 = ((d)localObject3).ieT();
            p.j(localObject4, "liveIdTuple3.`$1`()");
            l2 = ((Number)localObject4).longValue();
            localObject4 = ((d)localObject3).ieU();
            p.j(localObject4, "liveIdTuple3.`$2`()");
            j = ((Number)localObject4).intValue();
            localObject4 = h.yAW;
            localObject4 = h.a.b((bu)localObject2);
            localObject5 = h.b.yAX;
            localObject3 = ((d)localObject3).ieV();
            p.j(localObject3, "liveIdTuple3.`$3`()");
            paramWxRecyclerAdapter = new h((bu)localObject2, paramWxRecyclerAdapter, i, (String)localObject1, l1, l2, paramt, paramString, j, (String)localObject4, (h.b)localObject5, ((Boolean)localObject3).booleanValue(), false, 0, null, null, null, 126976);
            ((Map)this.yAw).put(localObject1, paramWxRecyclerAdapter);
            localObject2 = this.yAz;
            if (localObject2 != null) {
              ((r)localObject2).a(paramWxRecyclerAdapter, true);
            }
          }
          localArrayList1.add(localObject1);
          break;
          paramWxRecyclerAdapter = localArrayList2.iterator();
          while (paramWxRecyclerAdapter.hasNext())
          {
            paramLinearLayoutManager = (String)paramWxRecyclerAdapter.next();
            this.yAw.remove(paramLinearLayoutManager);
          }
          if (p.h(paramString, "12"))
          {
            paramWxRecyclerAdapter = this.yAB.entrySet().iterator();
            while (paramWxRecyclerAdapter.hasNext())
            {
              paramLinearLayoutManager = paramWxRecyclerAdapter.next();
              p.j(paramLinearLayoutManager, "iterator.next()");
              paramt = (Map.Entry)paramLinearLayoutManager;
              if (!localArrayList1.contains(paramt.getKey()))
              {
                paramWxRecyclerAdapter.remove();
                paramLinearLayoutManager = this.yAz;
                if (paramLinearLayoutManager != null)
                {
                  paramt = paramt.getValue();
                  p.j(paramt, "hellFeedPair.value");
                  paramLinearLayoutManager.b((i)paramt);
                }
              }
            }
          }
          paramWxRecyclerAdapter = this.yAw.entrySet().iterator();
          while (paramWxRecyclerAdapter.hasNext())
          {
            paramLinearLayoutManager = paramWxRecyclerAdapter.next();
            p.j(paramLinearLayoutManager, "iterator.next()");
            paramt = (Map.Entry)paramLinearLayoutManager;
            if (!localArrayList1.contains(paramt.getKey()))
            {
              paramWxRecyclerAdapter.remove();
              paramLinearLayoutManager = this.yAz;
              if (paramLinearLayoutManager != null)
              {
                paramt = paramt.getValue();
                p.j(paramt, "hellFeedPair.value");
                paramLinearLayoutManager.b((h)paramt);
              }
            }
          }
          localArrayList1.clear();
          localArrayList2.clear();
          AppMethodBeat.o(223473);
          return;
        }
      }
      label1263:
      localObject1 = paramString;
      paramWxRecyclerAdapter = paramt;
    }
  }
  
  final void dDa()
  {
    AppMethodBeat.i(223482);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.dca();
    if ((p.h(localObject1, "com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI3")) || (p.h(localObject1, "OccupyFinderUI3")))
    {
      AppMethodBeat.o(223482);
      return;
    }
    localObject1 = this.yAw.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      p.j(localObject2, "iterator.next()");
      Object localObject3 = (Map.Entry)localObject2;
      ((Iterator)localObject1).remove();
      localObject2 = this.yAz;
      if (localObject2 != null)
      {
        localObject3 = ((Map.Entry)localObject3).getValue();
        p.j(localObject3, "hellFeedPair.value");
        ((r)localObject2).b((h)localObject3);
      }
    }
    AppMethodBeat.o(223482);
  }
  
  final void dDb()
  {
    AppMethodBeat.i(223489);
    Iterator localIterator = this.yAx.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      p.j(localObject1, "iterator.next()");
      Object localObject2 = (Map.Entry)localObject1;
      localIterator.remove();
      localObject1 = this.yAz;
      if (localObject1 != null)
      {
        localObject2 = ((Map.Entry)localObject2).getValue();
        p.j(localObject2, "hellFeedPair.value");
        ((r)localObject1).b((j)localObject2);
      }
    }
    AppMethodBeat.o(223489);
  }
  
  final void dDc()
  {
    AppMethodBeat.i(223460);
    if (!((Map)this.yAy).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      Iterator localIterator = this.yAy.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = ((Map.Entry)localIterator.next()).getValue();
        p.j(localObject, "iterator.next().value");
        localObject = (h)localObject;
        r localr = this.yAz;
        if (localr != null) {
          localr.a((h)localObject, true);
        }
      }
    }
    AppMethodBeat.o(223460);
  }
  
  final void dDd()
  {
    AppMethodBeat.i(223461);
    if (!((Map)this.yAy).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      Iterator localIterator = this.yAy.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = ((Map.Entry)localIterator.next()).getValue();
        p.j(localObject, "iterator.next().value");
        localObject = (h)localObject;
        r localr = this.yAz;
        if (localr != null) {
          localr.b((h)localObject);
        }
      }
    }
    AppMethodBeat.o(223461);
  }
  
  final void dDe()
  {
    AppMethodBeat.i(223486);
    Iterator localIterator = this.yAB.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      p.j(localObject1, "iterator.next()");
      Object localObject2 = (Map.Entry)localObject1;
      localIterator.remove();
      localObject1 = this.yAz;
      if (localObject1 != null)
      {
        localObject2 = ((Map.Entry)localObject2).getValue();
        p.j(localObject2, "hellFeedPair.value");
        ((r)localObject1).b((i)localObject2);
      }
    }
    AppMethodBeat.o(223486);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/report/HellFeedSingleExposure$mChatListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/sns/ISnsFeedListener;", "onAppear", "", "adapter", "Landroid/widget/BaseAdapter;", "hellFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/HellFeed;", "view", "Landroid/view/View;", "onDisappear", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.plugin.expt.hellhound.a.g.a
  {
    public final void a(BaseAdapter paramBaseAdapter, com.tencent.mm.plugin.expt.hellhound.a.a.c paramc, View paramView)
    {
      AppMethodBeat.i(284845);
      if (paramc == null)
      {
        AppMethodBeat.o(284845);
        return;
      }
      String str1 = paramc.whE.userName;
      int i = paramc.position;
      String str2 = paramc.whE.feedId;
      p.j(str2, "hellFeed.feed.feedId");
      long l1 = Util.safeParseLong(paramc.whE.feedId);
      long l2 = Util.safeParseLong(paramc.kwM);
      s.t localt = this.yAM.yAD;
      String str3 = this.yAM.yAE;
      paramView = paramc.whE.nickName;
      paramBaseAdapter = paramView;
      if (paramView == null) {
        paramBaseAdapter = "";
      }
      if (paramc.liveStatus == 1) {}
      for (paramc = h.b.yAY;; paramc = h.b.yAZ)
      {
        paramBaseAdapter = new h(null, str1, i, str2, l1, l2, localt, str3, -1, paramBaseAdapter, paramc, true, true, s.ba.yKF.type, null, null, null, 114688);
        paramc = this.yAM.yAz;
        if (paramc == null) {
          break;
        }
        paramc.a(paramBaseAdapter, false);
        AppMethodBeat.o(284845);
        return;
      }
      AppMethodBeat.o(284845);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/report/HellFeedSingleExposure$mSnsListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/sns/ISnsFeedListener;", "onAppear", "", "adapter", "Landroid/widget/BaseAdapter;", "hellFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/HellFeed;", "view", "Landroid/view/View;", "onDisappear", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.plugin.expt.hellhound.a.g.a
  {
    public final void a(BaseAdapter paramBaseAdapter, com.tencent.mm.plugin.expt.hellhound.a.a.c paramc, View paramView)
    {
      AppMethodBeat.i(287137);
      if (paramBaseAdapter == null)
      {
        AppMethodBeat.o(287137);
        return;
      }
      if (paramc == null)
      {
        AppMethodBeat.o(287137);
        return;
      }
      if (paramView == null)
      {
        AppMethodBeat.o(287137);
        return;
      }
      if (!(paramBaseAdapter instanceof com.tencent.mm.plugin.sns.ui.a.c))
      {
        AppMethodBeat.o(287137);
        return;
      }
      if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        AppMethodBeat.o(287137);
        return;
      }
      Object localObject2;
      long l1;
      long l2;
      if (TextUtils.isEmpty((CharSequence)paramc.finderLiveId))
      {
        localObject2 = this.yAM;
        paramView = paramView.getTag();
        paramBaseAdapter = paramView;
        if (!(paramView instanceof d.a)) {
          paramBaseAdapter = null;
        }
        paramBaseAdapter = (d.a)paramBaseAdapter;
        if (paramBaseAdapter == null)
        {
          AppMethodBeat.o(287137);
          return;
        }
        paramBaseAdapter = paramBaseAdapter.timeLineObject;
        if (paramBaseAdapter == null)
        {
          AppMethodBeat.o(287137);
          return;
        }
        paramBaseAdapter = paramBaseAdapter.ContentObj;
        bcp localbcp;
        if (paramBaseAdapter != null)
        {
          localbcp = paramBaseAdapter.yNL;
          if (localbcp != null) {}
        }
        else
        {
          AppMethodBeat.o(287137);
          return;
        }
        paramView = localbcp.username;
        paramBaseAdapter = paramView;
        if (paramView == null) {
          paramBaseAdapter = "";
        }
        i = paramc.position;
        paramView = localbcp.feedId;
        paramc = paramView;
        if (paramView == null) {
          paramc = "";
        }
        l1 = Util.safeParseLong(localbcp.feedId);
        l2 = Util.safeParseLong(localbcp.kwM);
        s.t localt = s.t.yGN;
        String str = ((f)localObject2).yAE;
        localObject1 = localbcp.nickName;
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = "";
        }
        if (localbcp.liveStatus == 1) {}
        for (localObject1 = h.b.yAY;; localObject1 = h.b.yAZ)
        {
          paramBaseAdapter = new h(null, paramBaseAdapter, i, paramc, l1, l2, localt, str, -1, paramView, (h.b)localObject1, true, true, s.ba.yKH.type, null, null, null, 114688);
          paramc = ((f)localObject2).yAz;
          if (paramc == null) {
            break;
          }
          paramc.a(paramBaseAdapter, false);
          AppMethodBeat.o(287137);
          return;
        }
        AppMethodBeat.o(287137);
        return;
      }
      paramView = this.yAM;
      Object localObject1 = paramc.whH;
      int i = paramc.position;
      if (TextUtils.isEmpty((CharSequence)paramc.whI)) {}
      for (paramBaseAdapter = paramc.whE.feedId;; paramBaseAdapter = paramc.whI)
      {
        p.j(paramBaseAdapter, "if (TextUtils.isEmpty(he…      hellFeed.liveFeedId");
        l1 = Util.safeParseLong(paramc.whE.feedId);
        l2 = Util.safeParseLong(paramc.kwM);
        localObject2 = s.t.yGN;
        paramc = paramc.whE.userName;
        p.j(paramc, "hellFeed.feed.userName");
        paramBaseAdapter = new h(null, (String)localObject1, i, paramBaseAdapter, l1, l2, (s.t)localObject2, "37", -1, paramc, h.b.yAY, true, true, s.ba.yKH.type, null, null, null, 114688);
        paramc = paramView.yAz;
        if (paramc == null) {
          break;
        }
        paramc.a(paramBaseAdapter, false);
        AppMethodBeat.o(287137);
        return;
      }
      AppMethodBeat.o(287137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.f
 * JD-Core Version:    0.7.0.1
 */