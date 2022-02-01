package com.tencent.mm.plugin.finder.report.live;

import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.af;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.search.FinderContactSearchUI;
import com.tencent.mm.plugin.finder.search.FinderContactSearchUI.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.c.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.protocal.protobuf.dzv;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/HellFeedSingleExposure;", "", "mCallback", "Lcom/tencent/mm/plugin/finder/report/live/IFeedEventCallback;", "(Lcom/tencent/mm/plugin/finder/report/live/IFeedEventCallback;)V", "TAG", "", "mAbsActionType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "mAdapterRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getMCallback", "()Lcom/tencent/mm/plugin/finder/report/live/IFeedEventCallback;", "mChatListener", "com/tencent/mm/plugin/finder/report/live/HellFeedSingleExposure$mChatListener$1", "Lcom/tencent/mm/plugin/finder/report/live/HellFeedSingleExposure$mChatListener$1;", "mCommentscene", "mFeedCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveFeed;", "Lkotlin/collections/HashMap;", "mFeedHorizontalCache", "mItemCache", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveItem;", "mLastVisible", "", "mLayoutRef", "Landroid/support/v7/widget/LinearLayoutManager;", "mMixSearchAdapterRef", "Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter;", "Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;", "mMixSearchItemCache", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveMixSearchItem;", "mShareCaseList", "", "[Ljava/lang/String;", "mSnsListener", "com/tencent/mm/plugin/finder/report/live/HellFeedSingleExposure$mSnsListener$1", "Lcom/tencent/mm/plugin/finder/report/live/HellFeedSingleExposure$mSnsListener$1;", "monitor_method", "Ljava/lang/reflect/Method;", "onPauseState", "register_method", "unregister_method", "_doOnScroll", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "actionType", "commentscene", "pos", "", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "rvFeeds", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "rvFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "_doOnScrollHorizontal", "doDisappear", "", "doRunOnScroll", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "doRunOnScrollHorizontal", "doSnsEvent", "listView", "Landroid/widget/AbsListView;", "adapter", "Landroid/widget/BaseAdapter;", "firstVisibleItem", "visibleItemCount", "event", "Lcom/tencent/mm/plugin/finder/report/live/HELL_SCROLL_EVENT;", "isSns", "doSnsHorAppear", "handleChat", "handleSns", "onDestroy", "onFeedAllDisappear", "onItemAllDisappear", "onLiveFeedAppear", "hellFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/HellFeed;", "view", "Landroid/view/View;", "onMixSearchAllDisappear", "onScroll", "layoutManager", "onScrollHorizontal", "onSnsAdLiveFeedAppear", "run", "visibleState", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$VisiableState;", "headerShow", "plugin-finder_release"})
public final class f
{
  private final String TAG;
  s.p vjA;
  String vjB;
  final String[] vjC;
  Method vjD;
  Method vjE;
  Method vjF;
  boolean vjG;
  final a vjH;
  final b vjI;
  WeakReference<LinearLayoutManager> vjn;
  WeakReference<WxRecyclerAdapter<?>> vjo;
  private final HashMap<String, h> vjt;
  private final HashMap<String, j> vju;
  final HashMap<String, h> vjv;
  final r vjw;
  WeakReference<FinderContactSearchUI.a> vjx;
  private final HashMap<String, i> vjy;
  boolean vjz;
  
  public f(r paramr)
  {
    AppMethodBeat.i(250929);
    this.vjw = paramr;
    this.TAG = "HABBYGE-MALI.HellFeedSingleExposure";
    this.vjt = new HashMap();
    this.vjv = new HashMap();
    this.vjy = new HashMap();
    this.vju = new HashMap();
    this.vjA = s.p.voA;
    this.vjB = "";
    this.vjC = new String[] { "61", "temp_6" };
    try
    {
      paramr = Class.forName("com.tencent.mm.ui.chatting.monitor.ChatFeedMonitor");
      p.g(paramr, "Class.forName(className)");
      Method localMethod = paramr.getDeclaredMethod("monitor", new Class[] { AbsListView.class, BaseAdapter.class, Integer.TYPE, Integer.TYPE });
      p.g(localMethod, "monitor_clazz.getDeclare…         Int::class.java)");
      this.vjD = localMethod;
      localMethod = this.vjD;
      if (localMethod == null) {
        p.btv("monitor_method");
      }
      localMethod.setAccessible(true);
      localMethod = paramr.getDeclaredMethod("registerListener", new Class[] { com.tencent.mm.plugin.expt.hellhound.a.g.a.class });
      p.g(localMethod, "monitor_clazz.getDeclare…FeedListener::class.java)");
      this.vjE = localMethod;
      localMethod = this.vjE;
      if (localMethod == null) {
        p.btv("register_method");
      }
      localMethod.setAccessible(true);
      paramr = paramr.getDeclaredMethod("unregisterListener", new Class[] { com.tencent.mm.plugin.expt.hellhound.a.g.a.class });
      p.g(paramr, "monitor_clazz.getDeclare…FeedListener::class.java)");
      this.vjF = paramr;
      paramr = this.vjF;
      if (paramr == null) {
        p.btv("unregister_method");
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
    this.vjH = new a(this);
    this.vjI = new b(this);
    AppMethodBeat.o(250929);
  }
  
  private final com.tencent.mm.vending.j.c<List<String>, List<String>> a(x paramx, s.p paramp, String paramString, int paramInt)
  {
    AppMethodBeat.i(250925);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramx.dtS.iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (y)localIterator.next();
      long l1 = ((y)localObject3).uOo.id;
      String str = b.zs(l1);
      p.g(str, "HellhoundUtil.long2UnsignedString(feedIdL)");
      if (this.vjv.containsKey(str))
      {
        if (!this.vjt.containsKey(str))
        {
          paramx = h.vjR;
          p.g(localObject3, "subRvFeed");
          Object localObject2 = h.a.a((bo)localObject3);
          bo localbo = (bo)localObject3;
          Object localObject1 = ((y)localObject3).uOo.username;
          paramx = (x)localObject1;
          if (localObject1 == null) {
            paramx = "";
          }
          localObject1 = ((d)localObject2).hdM();
          p.g(localObject1, "liveIdTuple3.`$1`()");
          long l2 = ((Number)localObject1).longValue();
          localObject1 = ((d)localObject2).hdN();
          p.g(localObject1, "liveIdTuple3.`$2`()");
          int i = ((Number)localObject1).intValue();
          localObject1 = h.vjR;
          localObject1 = h.a.b((bo)localObject3);
          localObject3 = h.b.vjS;
          localObject2 = ((d)localObject2).hdO();
          p.g(localObject2, "liveIdTuple3.`$3`()");
          paramx = new h(localbo, paramx, paramInt, str, l1, l2, paramp, paramString, i, (String)localObject1, (h.b)localObject3, ((Boolean)localObject2).booleanValue(), false, 12288, (byte)0);
          ((Map)this.vjt).put(str, paramx);
          localObject1 = this.vjw;
          if (localObject1 != null) {
            ((r)localObject1).a(paramx, true);
          }
        }
        localArrayList1.add(str);
      }
      else
      {
        localArrayList2.add(str);
      }
    }
    paramx = com.tencent.mm.vending.j.a.Q(localArrayList1, localArrayList2);
    p.g(paramx, "Tuple.make(retIdList, needDelList)");
    AppMethodBeat.o(250925);
    return paramx;
  }
  
  final void a(FinderContactSearchUI.a parama, LinearLayoutManager paramLinearLayoutManager, s.p paramp, String paramString)
  {
    AppMethodBeat.i(250924);
    int j = paramLinearLayoutManager.ks();
    int k = paramLinearLayoutManager.ku();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = FinderContactSearchUI.a(parama.vtT);
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
        p.g(parama, "dataList[pos]");
        localObject2 = (bbz)parama;
        parama = ((bbz)localObject2).contact;
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
      p.g(str, "feed.contact?.username ?: return \"\"");
      parama = str;
    } while (this.vju.containsKey(str));
    parama = ((bbz)localObject2).contact;
    if ((parama != null) && (parama.liveStatus == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      parama = ((bbz)localObject2).contact;
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
      Object localObject1 = new j((bbz)localObject2, i, str, paramp, paramString, bool, parama);
      ((Map)this.vju).put(str, localObject1);
      localObject2 = this.vjw;
      parama = str;
      if (localObject2 == null) {
        break;
      }
      ((r)localObject2).a((j)localObject1);
      parama = str;
      break;
    }
    label305:
    parama = this.vju.entrySet().iterator();
    while (parama.hasNext())
    {
      paramLinearLayoutManager = parama.next();
      p.g(paramLinearLayoutManager, "iterator.next()");
      paramp = (Map.Entry)paramLinearLayoutManager;
      if (!localArrayList1.contains(paramp.getKey()))
      {
        parama.remove();
        paramLinearLayoutManager = this.vjw;
        if (paramLinearLayoutManager != null)
        {
          paramp = paramp.getValue();
          p.g(paramp, "hellFeedPair.value");
          paramLinearLayoutManager.b((j)paramp);
        }
      }
    }
    localArrayList1.clear();
    AppMethodBeat.o(250924);
  }
  
  final void a(WxRecyclerAdapter<?> paramWxRecyclerAdapter, LinearLayoutManager paramLinearLayoutManager, s.p paramp, String paramString)
  {
    AppMethodBeat.i(250922);
    int i = paramLinearLayoutManager.ks();
    int j = paramLinearLayoutManager.ku();
    if (i == 0)
    {
      if (j < 2) {
        break label504;
      }
      j -= 1;
    }
    label69:
    label81:
    label504:
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      List localList = (List)paramWxRecyclerAdapter.data;
      int k;
      Object localObject1;
      if (!((Collection)localList).isEmpty())
      {
        k = 1;
        if ((k == 0) || (i > j)) {
          break label381;
        }
        if (localList.size() > i)
        {
          paramLinearLayoutManager = localList.get(i);
          paramWxRecyclerAdapter = paramLinearLayoutManager;
          if (!(paramLinearLayoutManager instanceof bo)) {
            paramWxRecyclerAdapter = null;
          }
          localObject1 = (bo)paramWxRecyclerAdapter;
          if (localObject1 != null) {
            break label162;
          }
        }
      }
      for (;;)
      {
        if (i == j) {
          break label381;
        }
        i += 1;
        break label81;
        i -= 1;
        j -= 1;
        break;
        k = 0;
        break label69;
        long l1 = ((bo)localObject1).lT();
        paramLinearLayoutManager = b.zs(l1);
        p.g(paramLinearLayoutManager, "HellhoundUtil.long2UnsignedString(feedIdL)");
        if (!this.vjv.containsKey(paramLinearLayoutManager))
        {
          paramWxRecyclerAdapter = h.vjR;
          Object localObject2 = h.a.a((bo)localObject1);
          paramWxRecyclerAdapter = "";
          if ((localObject1 instanceof BaseFinderFeed)) {
            paramWxRecyclerAdapter = ((BaseFinderFeed)localObject1).feedObject.getUserName();
          }
          Object localObject3 = ((d)localObject2).hdM();
          p.g(localObject3, "liveIdTuple3.`$1`()");
          long l2 = ((Number)localObject3).longValue();
          localObject2 = ((d)localObject2).hdN();
          p.g(localObject2, "liveIdTuple3.`$2`()");
          k = ((Number)localObject2).intValue();
          localObject2 = h.vjR;
          paramWxRecyclerAdapter = new h((bo)localObject1, paramWxRecyclerAdapter, i, paramLinearLayoutManager, l1, l2, paramp, paramString, k, h.a.b((bo)localObject1), h.b.vjS, true, false, 12288, (byte)0);
          ((Map)this.vjv).put(paramLinearLayoutManager, paramWxRecyclerAdapter);
          ((Map)this.vjt).put(paramLinearLayoutManager, paramWxRecyclerAdapter);
          localObject1 = this.vjw;
          if (localObject1 != null) {
            ((r)localObject1).a(paramWxRecyclerAdapter, true);
          }
        }
        localArrayList.add(paramLinearLayoutManager);
      }
      label381:
      paramWxRecyclerAdapter = this.vjv.entrySet().iterator();
      while (paramWxRecyclerAdapter.hasNext())
      {
        paramLinearLayoutManager = paramWxRecyclerAdapter.next();
        p.g(paramLinearLayoutManager, "iterator.next()");
        paramp = (Map.Entry)paramLinearLayoutManager;
        if (!localArrayList.contains(paramp.getKey()))
        {
          paramWxRecyclerAdapter.remove();
          this.vjt.remove(paramp.getKey());
          paramLinearLayoutManager = this.vjw;
          if (paramLinearLayoutManager != null)
          {
            paramp = paramp.getValue();
            p.g(paramp, "hellFeedPair.value");
            paramLinearLayoutManager.a((h)paramp);
          }
        }
      }
      localArrayList.clear();
      AppMethodBeat.o(250922);
      return;
    }
  }
  
  final void b(WxRecyclerAdapter<?> paramWxRecyclerAdapter, LinearLayoutManager paramLinearLayoutManager, s.p paramp, String paramString)
  {
    AppMethodBeat.i(250923);
    int j = paramLinearLayoutManager.ks();
    int k = paramLinearLayoutManager.ku();
    int m = paramWxRecyclerAdapter.RqM.size();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    List localList = (List)paramWxRecyclerAdapter.data;
    int i;
    if (!((Collection)localList).isEmpty())
    {
      i = 1;
      if ((i == 0) || (j > k)) {
        break label989;
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
        paramWxRecyclerAdapter = a((x)localObject2, paramp, paramString, i);
        localArrayList1.addAll((Collection)paramWxRecyclerAdapter.hdM());
        localArrayList2.addAll((Collection)paramWxRecyclerAdapter.hdN());
      }
      if (i == k) {
        break label989;
      }
      i += 1;
      break label86;
      i = 0;
      break;
    }
    label210:
    Object localObject1;
    boolean bool;
    if ((localObject2 instanceof af))
    {
      localObject1 = (af)localObject2;
      paramWxRecyclerAdapter = ((af)localObject1).contact.getUsername();
      if (!this.vjy.containsKey(paramWxRecyclerAdapter)) {
        if (((af)localObject1).contact.field_liveStatus != 1) {
          break label333;
        }
      }
      label333:
      for (bool = true;; bool = false)
      {
        localObject1 = new i((af)localObject1, i, paramWxRecyclerAdapter, paramp, paramString, bool, ((af)localObject1).contact.getNickname());
        ((Map)this.vjy).put(paramWxRecyclerAdapter, localObject1);
        localObject2 = this.vjw;
        if (localObject2 != null) {
          ((r)localObject2).a((i)localObject1);
        }
        localArrayList1.add(paramWxRecyclerAdapter);
        break;
      }
    }
    if ((localObject2 instanceof BaseFinderFeed))
    {
      if (paramp != s.p.voz) {
        break label1257;
      }
      if (p.j(paramString, s.j.vnN.scene))
      {
        paramWxRecyclerAdapter = s.p.voB;
        localObject1 = "17";
      }
    }
    for (;;)
    {
      label377:
      localObject2 = (BaseFinderFeed)localObject2;
      Object localObject3 = ((BaseFinderFeed)localObject2).feedObject.getLiveInfo();
      if ((localObject3 != null) && (((awe)localObject3).liveStatus == 1))
      {
        j = 1;
        label411:
        bool = ((BaseFinderFeed)localObject2).feedObject.isLiveFeed();
        if (!bool) {
          break label708;
        }
        paramWxRecyclerAdapter = s.p.voA;
      }
      label430:
      label708:
      label720:
      label989:
      label1254:
      for (;;)
      {
        long l1 = ((BaseFinderFeed)localObject2).lT();
        localObject3 = b.zs(l1);
        p.g(localObject3, "HellhoundUtil.long2UnsignedString(feedIdL)");
        Object localObject4;
        Object localObject6;
        Object localObject5;
        Object localObject7;
        long l2;
        int n;
        if (!this.vjt.containsKey(localObject3))
        {
          localObject4 = h.vjR;
          localObject6 = h.a.a((bo)localObject2);
          localObject4 = (bo)localObject2;
          localObject5 = ((BaseFinderFeed)localObject2).feedObject.getUserName();
          localObject7 = ((d)localObject6).hdM();
          p.g(localObject7, "liveIdTuple3.`$1`()");
          l2 = ((Number)localObject7).longValue();
          localObject7 = ((d)localObject6).hdN();
          p.g(localObject7, "liveIdTuple3.`$2`()");
          n = ((Number)localObject7).intValue();
          localObject7 = h.vjR;
          localObject7 = h.a.b((bo)localObject2);
          if (j == 0) {
            break label720;
          }
        }
        for (localObject2 = h.b.vjT;; localObject2 = h.b.vjU)
        {
          localObject6 = ((d)localObject6).hdO();
          p.g(localObject6, "liveIdTuple3.`$3`()");
          paramWxRecyclerAdapter = new h((bo)localObject4, (String)localObject5, i, (String)localObject3, l1, l2, paramWxRecyclerAdapter, (String)localObject1, n, (String)localObject7, (h.b)localObject2, bool, ((Boolean)localObject6).booleanValue(), 8192, (byte)0);
          ((Map)this.vjt).put(localObject3, paramWxRecyclerAdapter);
          localObject1 = this.vjw;
          if (localObject1 != null) {
            ((r)localObject1).a(paramWxRecyclerAdapter, true);
          }
          localArrayList1.add(localObject3);
          break;
          if (!p.j(paramString, s.j.vnU.scene)) {
            break label1257;
          }
          paramWxRecyclerAdapter = s.p.voB;
          localObject1 = "18";
          break label377;
          j = 0;
          break label411;
          if (j == 0) {
            break label1254;
          }
          paramWxRecyclerAdapter = s.p.voB;
          break label430;
        }
        if (!(localObject2 instanceof bo)) {}
        for (paramWxRecyclerAdapter = null;; paramWxRecyclerAdapter = (WxRecyclerAdapter<?>)localObject2)
        {
          localObject2 = (bo)paramWxRecyclerAdapter;
          if (localObject2 == null) {
            break;
          }
          l1 = ((bo)localObject2).lT();
          localObject1 = b.zs(l1);
          p.g(localObject1, "HellhoundUtil.long2UnsignedString(feedIdL)");
          if (!this.vjt.containsKey(localObject1))
          {
            paramWxRecyclerAdapter = h.vjR;
            localObject3 = h.a.a((bo)localObject2);
            paramWxRecyclerAdapter = "";
            if ((localObject2 instanceof BaseFinderFeed)) {
              paramWxRecyclerAdapter = ((BaseFinderFeed)localObject2).feedObject.getUserName();
            }
            localObject4 = ((d)localObject3).hdM();
            p.g(localObject4, "liveIdTuple3.`$1`()");
            l2 = ((Number)localObject4).longValue();
            localObject4 = ((d)localObject3).hdN();
            p.g(localObject4, "liveIdTuple3.`$2`()");
            j = ((Number)localObject4).intValue();
            localObject4 = h.vjR;
            localObject4 = h.a.b((bo)localObject2);
            localObject5 = h.b.vjS;
            localObject3 = ((d)localObject3).hdO();
            p.g(localObject3, "liveIdTuple3.`$3`()");
            paramWxRecyclerAdapter = new h((bo)localObject2, paramWxRecyclerAdapter, i, (String)localObject1, l1, l2, paramp, paramString, j, (String)localObject4, (h.b)localObject5, ((Boolean)localObject3).booleanValue(), false, 12288, (byte)0);
            ((Map)this.vjt).put(localObject1, paramWxRecyclerAdapter);
            localObject2 = this.vjw;
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
            this.vjt.remove(paramLinearLayoutManager);
          }
          if (p.j(paramString, "12"))
          {
            paramWxRecyclerAdapter = this.vjy.entrySet().iterator();
            while (paramWxRecyclerAdapter.hasNext())
            {
              paramLinearLayoutManager = paramWxRecyclerAdapter.next();
              p.g(paramLinearLayoutManager, "iterator.next()");
              paramp = (Map.Entry)paramLinearLayoutManager;
              if (!localArrayList1.contains(paramp.getKey()))
              {
                paramWxRecyclerAdapter.remove();
                paramLinearLayoutManager = this.vjw;
                if (paramLinearLayoutManager != null)
                {
                  paramp = paramp.getValue();
                  p.g(paramp, "hellFeedPair.value");
                  paramLinearLayoutManager.b((i)paramp);
                }
              }
            }
          }
          paramWxRecyclerAdapter = this.vjt.entrySet().iterator();
          while (paramWxRecyclerAdapter.hasNext())
          {
            paramLinearLayoutManager = paramWxRecyclerAdapter.next();
            p.g(paramLinearLayoutManager, "iterator.next()");
            paramp = (Map.Entry)paramLinearLayoutManager;
            if (!localArrayList1.contains(paramp.getKey()))
            {
              paramWxRecyclerAdapter.remove();
              paramLinearLayoutManager = this.vjw;
              if (paramLinearLayoutManager != null)
              {
                paramp = paramp.getValue();
                p.g(paramp, "hellFeedPair.value");
                paramLinearLayoutManager.a((h)paramp);
              }
            }
          }
          localArrayList1.clear();
          localArrayList2.clear();
          AppMethodBeat.o(250923);
          return;
        }
      }
      label1257:
      localObject1 = paramString;
      paramWxRecyclerAdapter = paramp;
    }
  }
  
  final void dpa()
  {
    AppMethodBeat.i(250926);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.cNi();
    if ((p.j(localObject1, "com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI3")) || (p.j(localObject1, "OccupyFinderUI3")))
    {
      AppMethodBeat.o(250926);
      return;
    }
    localObject1 = this.vjt.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      p.g(localObject2, "iterator.next()");
      Object localObject3 = (Map.Entry)localObject2;
      ((Iterator)localObject1).remove();
      localObject2 = this.vjw;
      if (localObject2 != null)
      {
        localObject3 = ((Map.Entry)localObject3).getValue();
        p.g(localObject3, "hellFeedPair.value");
        ((r)localObject2).a((h)localObject3);
      }
    }
    AppMethodBeat.o(250926);
  }
  
  final void dpb()
  {
    AppMethodBeat.i(250928);
    Iterator localIterator = this.vju.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      p.g(localObject1, "iterator.next()");
      Object localObject2 = (Map.Entry)localObject1;
      localIterator.remove();
      localObject1 = this.vjw;
      if (localObject1 != null)
      {
        localObject2 = ((Map.Entry)localObject2).getValue();
        p.g(localObject2, "hellFeedPair.value");
        ((r)localObject1).b((j)localObject2);
      }
    }
    AppMethodBeat.o(250928);
  }
  
  final void dpc()
  {
    AppMethodBeat.i(250920);
    if (!((Map)this.vjv).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      Iterator localIterator = this.vjv.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = ((Map.Entry)localIterator.next()).getValue();
        p.g(localObject, "iterator.next().value");
        localObject = (h)localObject;
        r localr = this.vjw;
        if (localr != null) {
          localr.a((h)localObject, true);
        }
      }
    }
    AppMethodBeat.o(250920);
  }
  
  final void dpd()
  {
    AppMethodBeat.i(250921);
    if (!((Map)this.vjv).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      Iterator localIterator = this.vjv.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = ((Map.Entry)localIterator.next()).getValue();
        p.g(localObject, "iterator.next().value");
        localObject = (h)localObject;
        r localr = this.vjw;
        if (localr != null) {
          localr.a((h)localObject);
        }
      }
    }
    AppMethodBeat.o(250921);
  }
  
  final void dpe()
  {
    AppMethodBeat.i(250927);
    Iterator localIterator = this.vjy.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      p.g(localObject1, "iterator.next()");
      Object localObject2 = (Map.Entry)localObject1;
      localIterator.remove();
      localObject1 = this.vjw;
      if (localObject1 != null)
      {
        localObject2 = ((Map.Entry)localObject2).getValue();
        p.g(localObject2, "hellFeedPair.value");
        ((r)localObject1).b((i)localObject2);
      }
    }
    AppMethodBeat.o(250927);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/report/live/HellFeedSingleExposure$mChatListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/sns/ISnsFeedListener;", "onAppear", "", "adapter", "Landroid/widget/BaseAdapter;", "hellFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/HellFeed;", "view", "Landroid/view/View;", "onDisappear", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.plugin.expt.hellhound.a.g.a
  {
    public final void a(BaseAdapter paramBaseAdapter, com.tencent.mm.plugin.expt.hellhound.a.a.c paramc, View paramView)
    {
      AppMethodBeat.i(250918);
      if (paramc == null)
      {
        AppMethodBeat.o(250918);
        return;
      }
      String str1 = paramc.sBK.userName;
      int i = paramc.position;
      String str2 = paramc.sBK.feedId;
      p.g(str2, "hellFeed.feed.feedId");
      long l1 = Util.safeParseLong(paramc.sBK.feedId);
      long l2 = Util.safeParseLong(paramc.hJs);
      s.p localp = this.vjJ.vjA;
      String str3 = this.vjJ.vjB;
      paramView = paramc.sBK.nickName;
      paramBaseAdapter = paramView;
      if (paramView == null) {
        paramBaseAdapter = "";
      }
      if (paramc.liveStatus == 1) {}
      for (paramc = h.b.vjT;; paramc = h.b.vjU)
      {
        paramBaseAdapter = new h(null, str1, i, str2, l1, l2, localp, str3, -1, paramBaseAdapter, paramc, true, true, s.ba.vsY.type);
        paramc = this.vjJ.vjw;
        if (paramc == null) {
          break;
        }
        paramc.a(paramBaseAdapter, false);
        AppMethodBeat.o(250918);
        return;
      }
      AppMethodBeat.o(250918);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/report/live/HellFeedSingleExposure$mSnsListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/sns/ISnsFeedListener;", "onAppear", "", "adapter", "Landroid/widget/BaseAdapter;", "hellFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/HellFeed;", "view", "Landroid/view/View;", "onDisappear", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.plugin.expt.hellhound.a.g.a
  {
    public final void a(BaseAdapter paramBaseAdapter, com.tencent.mm.plugin.expt.hellhound.a.a.c paramc, View paramView)
    {
      AppMethodBeat.i(250919);
      if (paramBaseAdapter == null)
      {
        AppMethodBeat.o(250919);
        return;
      }
      if (paramc == null)
      {
        AppMethodBeat.o(250919);
        return;
      }
      if (paramView == null)
      {
        AppMethodBeat.o(250919);
        return;
      }
      if (!(paramBaseAdapter instanceof com.tencent.mm.plugin.sns.ui.a.c))
      {
        AppMethodBeat.o(250919);
        return;
      }
      if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        AppMethodBeat.o(250919);
        return;
      }
      if (TextUtils.isEmpty((CharSequence)paramc.finderLiveId))
      {
        localObject = this.vjJ;
        paramView = paramView.getTag();
        paramBaseAdapter = paramView;
        if (!(paramView instanceof c.a)) {
          paramBaseAdapter = null;
        }
        paramBaseAdapter = (c.a)paramBaseAdapter;
        if (paramBaseAdapter == null)
        {
          AppMethodBeat.o(250919);
          return;
        }
        paramBaseAdapter = paramBaseAdapter.timeLineObject;
        if (paramBaseAdapter == null)
        {
          AppMethodBeat.o(250919);
          return;
        }
        paramBaseAdapter = paramBaseAdapter.ContentObj;
        if (paramBaseAdapter != null)
        {
          paramBaseAdapter = paramBaseAdapter.Lpc;
          if (paramBaseAdapter != null) {}
        }
        else
        {
          AppMethodBeat.o(250919);
          return;
        }
        paramView = paramBaseAdapter.username;
        i = paramc.position;
        paramc = paramBaseAdapter.feedId;
        p.g(paramc, "finderLiveShareObject.feedId");
        l1 = Util.safeParseLong(paramBaseAdapter.feedId);
        l2 = Util.safeParseLong(paramBaseAdapter.hJs);
        localp = s.p.voA;
        String str1 = ((f)localObject).vjB;
        String str2 = paramBaseAdapter.nickName;
        p.g(str2, "finderLiveShareObject.nickName");
        if (paramBaseAdapter.liveStatus == 1) {}
        for (paramBaseAdapter = h.b.vjT;; paramBaseAdapter = h.b.vjU)
        {
          paramBaseAdapter = new h(null, paramView, i, paramc, l1, l2, localp, str1, -1, str2, paramBaseAdapter, true, true, s.ba.vsY.type);
          paramc = ((f)localObject).vjw;
          if (paramc == null) {
            break;
          }
          paramc.a(paramBaseAdapter, false);
          AppMethodBeat.o(250919);
          return;
        }
        AppMethodBeat.o(250919);
        return;
      }
      paramBaseAdapter = this.vjJ;
      paramView = paramc.sBN;
      int i = paramc.position;
      Object localObject = paramc.sBK.feedId;
      p.g(localObject, "hellFeed.feed.feedId");
      long l1 = Util.safeParseLong(paramc.sBK.feedId);
      long l2 = Util.safeParseLong(paramc.hJs);
      s.p localp = s.p.voA;
      paramc = paramc.sBK.userName;
      p.g(paramc, "hellFeed.feed.userName");
      paramc = new h(null, paramView, i, (String)localObject, l1, l2, localp, "37", -1, paramc, h.b.vjT, true, true, s.ba.vsY.type);
      paramBaseAdapter = paramBaseAdapter.vjw;
      if (paramBaseAdapter != null)
      {
        paramBaseAdapter.a(paramc, false);
        AppMethodBeat.o(250919);
        return;
      }
      AppMethodBeat.o(250919);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.live.f
 * JD-Core Version:    0.7.0.1
 */