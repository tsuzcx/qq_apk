package com.tencent.mm.plugin.finder.live.report;

import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ac;
import com.tencent.mm.plugin.finder.model.aj;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.findersdk.a.v;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.d.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.fed;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/HellFeedSingleExposure;", "", "mCallback", "Lcom/tencent/mm/plugin/finder/live/report/IFeedEventCallback;", "(Lcom/tencent/mm/plugin/finder/live/report/IFeedEventCallback;)V", "TAG", "", "mAbsActionType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "mAdapterRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getMCallback", "()Lcom/tencent/mm/plugin/finder/live/report/IFeedEventCallback;", "mChatListener", "com/tencent/mm/plugin/finder/live/report/HellFeedSingleExposure$mChatListener$1", "Lcom/tencent/mm/plugin/finder/live/report/HellFeedSingleExposure$mChatListener$1;", "mCommentscene", "mFeedCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveFeed;", "Lkotlin/collections/HashMap;", "mFeedHorizontalCache", "mItemCache", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveItem;", "mLastVisible", "", "mLayoutRef", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mMixSearchAdapterRef", "Lcom/tencent/mm/plugin/findersdk/api/IContactSearchProfileAdapter;", "mMixSearchItemCache", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveMixSearchItem;", "mShareCaseList", "", "[Ljava/lang/String;", "mSnsListener", "com/tencent/mm/plugin/finder/live/report/HellFeedSingleExposure$mSnsListener$1", "Lcom/tencent/mm/plugin/finder/live/report/HellFeedSingleExposure$mSnsListener$1;", "monitor_method", "Ljava/lang/reflect/Method;", "onPauseState", "register_method", "unregister_method", "_doOnScroll", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "actionType", "commentscene", "pos", "", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "rvFeeds", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "rvFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "_doOnScrollHorizontal", "doDisappear", "", "doRunOnScroll", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "doRunOnScrollHorizontal", "doSnsEvent", "listView", "Landroid/widget/AbsListView;", "adapter", "Landroid/widget/BaseAdapter;", "firstVisibleItem", "visibleItemCount", "event", "Lcom/tencent/mm/plugin/finder/live/report/HELL_SCROLL_EVENT;", "isSns", "doSnsHorAppear", "handleChat", "handleSns", "onDestroy", "onFeedAllDisappear", "onItemAllDisappear", "onLiveFeedAppear", "hellFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/HellFeed;", "view", "Landroid/view/View;", "onMixSearchAllDisappear", "onScroll", "layoutManager", "onScrollHorizontal", "onSnsAdLiveFeedAppear", "run", "visibleState", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$VisiableState;", "headerShow", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  q.w DnA;
  String DnB;
  final String[] DnC;
  Method DnD;
  Method DnE;
  Method DnF;
  boolean DnG;
  final b DnH;
  final c DnI;
  final p Dnn;
  WeakReference<LinearLayoutManager> Dno;
  WeakReference<WxRecyclerAdapter<?>> Dnp;
  private final HashMap<String, g> Dnu;
  private final HashMap<String, i> Dnv;
  final HashMap<String, g> Dnw;
  WeakReference<v> Dnx;
  private final HashMap<String, h> Dny;
  boolean Dnz;
  private final String TAG;
  
  public f(p paramp)
  {
    AppMethodBeat.i(351841);
    this.Dnn = paramp;
    this.TAG = "HABBYGE-MALI.HellFeedSingleExposure";
    this.Dnu = new HashMap();
    this.Dnw = new HashMap();
    this.Dny = new HashMap();
    this.Dnv = new HashMap();
    this.DnA = q.w.DwP;
    this.DnB = "";
    this.DnC = new String[] { "61", "temp_6" };
    for (;;)
    {
      try
      {
        Class localClass = Class.forName("com.tencent.mm.ui.chatting.monitor.ChatFeedMonitor");
        paramp = localClass.getDeclaredMethod("monitor", new Class[] { AbsListView.class, BaseAdapter.class, Integer.TYPE, Integer.TYPE });
        s.s(paramp, "monitor_clazz.getDeclare…         Int::class.java)");
        this.DnD = paramp;
        Method localMethod = this.DnD;
        paramp = localMethod;
        if (localMethod == null)
        {
          s.bIx("monitor_method");
          paramp = null;
        }
        paramp.setAccessible(true);
        paramp = localClass.getDeclaredMethod("registerListener", new Class[] { com.tencent.mm.plugin.expt.hellhound.ext.f.a.class });
        s.s(paramp, "monitor_clazz.getDeclare…FeedListener::class.java)");
        this.DnE = paramp;
        localMethod = this.DnE;
        paramp = localMethod;
        if (localMethod == null)
        {
          s.bIx("register_method");
          paramp = null;
        }
        paramp.setAccessible(true);
        paramp = localClass.getDeclaredMethod("unregisterListener", new Class[] { com.tencent.mm.plugin.expt.hellhound.ext.f.a.class });
        s.s(paramp, "monitor_clazz.getDeclare…FeedListener::class.java)");
        this.DnF = paramp;
        paramp = this.DnF;
        if (paramp != null) {
          continue;
        }
        s.bIx("unregister_method");
        paramp = localObject;
        paramp.setAccessible(true);
      }
      catch (Exception paramp)
      {
        Log.e(this.TAG, s.X("init crash: ", paramp.getMessage()));
        continue;
      }
      this.DnH = new b(this);
      this.DnI = new c(this);
      AppMethodBeat.o(351841);
      return;
    }
  }
  
  private final com.tencent.mm.vending.j.c<List<String>, List<String>> a(y paramy, q.w paramw, String paramString, int paramInt)
  {
    AppMethodBeat.i(351854);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramy.hqL.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (cc)localIterator.next();
      long l1 = ((cc)localObject1).bZA();
      String str = com.tencent.mm.plugin.expt.hellhound.core.b.hF(l1);
      s.s(str, "long2UnsignedString(feedIdL)");
      if (this.Dnw.containsKey(str))
      {
        Object localObject2;
        if (!this.Dnu.containsKey(str))
        {
          paramy = g.DnK;
          s.s(localObject1, "subRvFeed");
          localObject2 = g.a.a((cc)localObject1);
          if (!(localObject1 instanceof z)) {
            break label333;
          }
        }
        label333:
        for (paramy = ((z)localObject1).ECN.username;; paramy = "")
        {
          Object localObject3 = ((com.tencent.mm.vending.j.b)localObject2).get(0);
          s.s(localObject3, "liveIdTuple3.`$1`()");
          long l2 = ((Number)localObject3).longValue();
          localObject3 = ((com.tencent.mm.vending.j.c)localObject2).get(1);
          s.s(localObject3, "liveIdTuple3.`$2`()");
          int i = ((Number)localObject3).intValue();
          localObject3 = g.DnK;
          localObject3 = g.a.b((cc)localObject1);
          g.b localb = g.b.DnU;
          localObject2 = ((d)localObject2).get(2);
          s.s(localObject2, "liveIdTuple3.`$3`()");
          paramy = new g((cc)localObject1, paramy, paramInt, str, l1, l2, paramw, paramString, i, (String)localObject3, localb, ((Boolean)localObject2).booleanValue(), false, 0, null, null, null, null, 258048);
          if ((localObject1 instanceof ac)) {
            paramy.a(q.w.DwO);
          }
          ((Map)this.Dnu).put(str, paramy);
          localObject1 = this.Dnn;
          if (localObject1 != null) {
            ((p)localObject1).a(paramy, true);
          }
          localArrayList1.add(str);
          break;
        }
      }
      localArrayList2.add(str);
    }
    paramy = com.tencent.mm.vending.j.a.U(localArrayList1, localArrayList2);
    s.s(paramy, "make(retIdList, needDelList)");
    AppMethodBeat.o(351854);
    return paramy;
  }
  
  final void a(v paramv, LinearLayoutManager paramLinearLayoutManager, q.w paramw, String paramString)
  {
    AppMethodBeat.i(351949);
    int j = paramLinearLayoutManager.Ju();
    int k = paramLinearLayoutManager.Jw();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = paramv.dwi();
    int i;
    if (!((Collection)localArrayList2).isEmpty())
    {
      i = 1;
      if ((i != 0) && (j <= k)) {
        i = j;
      }
    }
    for (;;)
    {
      Object localObject3;
      if ((paramLinearLayoutManager.findViewByPosition(i) != null) && (localArrayList2.size() > i))
      {
        paramv = localArrayList2.get(i);
        s.s(paramv, "dataList[pos]");
        localObject3 = (buy)paramv;
        paramv = ((buy)localObject3).contact;
        if (paramv != null) {
          break label245;
        }
        paramv = null;
        label119:
        if (paramv != null) {
          break label253;
        }
        localObject1 = "";
      }
      label245:
      label253:
      do
      {
        localArrayList1.add(localObject1);
        if (i != k) {
          break label414;
        }
        paramv = this.Dnv.entrySet().iterator();
        while (paramv.hasNext())
        {
          paramLinearLayoutManager = paramv.next();
          s.s(paramLinearLayoutManager, "iterator.next()");
          paramw = (Map.Entry)paramLinearLayoutManager;
          if (!localArrayList1.contains(paramw.getKey()))
          {
            paramv.remove();
            paramLinearLayoutManager = this.Dnn;
            if (paramLinearLayoutManager != null)
            {
              paramw = paramw.getValue();
              s.s(paramw, "hellFeedPair.value");
              paramLinearLayoutManager.b((i)paramw);
            }
          }
        }
        i = 0;
        break;
        paramv = paramv.username;
        break label119;
        localObject1 = paramv;
      } while (this.Dnv.containsKey(paramv));
      Object localObject1 = ((buy)localObject3).contact;
      boolean bool;
      if ((localObject1 != null) && (((FinderContact)localObject1).liveStatus == 1))
      {
        bool = true;
        label291:
        localObject1 = ((buy)localObject3).contact;
        if (localObject1 != null) {
          break label379;
        }
        localObject1 = "";
      }
      for (;;)
      {
        Object localObject2 = new i((buy)localObject3, i, paramv, paramw, paramString, bool, (String)localObject1);
        ((Map)this.Dnv).put(paramv, localObject2);
        localObject3 = this.Dnn;
        localObject1 = paramv;
        if (localObject3 == null) {
          break;
        }
        ((p)localObject3).a((i)localObject2);
        localObject1 = paramv;
        break;
        bool = false;
        break label291;
        label379:
        localObject2 = ((FinderContact)localObject1).nickname;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      localArrayList1.clear();
      AppMethodBeat.o(351949);
      return;
      label414:
      i += 1;
    }
  }
  
  final void a(WxRecyclerAdapter<?> paramWxRecyclerAdapter, LinearLayoutManager paramLinearLayoutManager, q.w paramw, String paramString)
  {
    AppMethodBeat.i(351896);
    int i = paramLinearLayoutManager.Ju();
    int j = paramLinearLayoutManager.Jw();
    if (i == 0)
    {
      if (j < 2) {
        break label518;
      }
      j -= 1;
    }
    label518:
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      List localList = (List)paramWxRecyclerAdapter.data;
      int k;
      if (!((Collection)localList).isEmpty())
      {
        k = 1;
        label69:
        if ((k == 0) || (i > j)) {}
      }
      for (;;)
      {
        if (localList.size() > i)
        {
          paramWxRecyclerAdapter = localList.get(i);
          if (!(paramWxRecyclerAdapter instanceof cc)) {
            break label492;
          }
        }
        label492:
        for (paramWxRecyclerAdapter = (cc)paramWxRecyclerAdapter;; paramWxRecyclerAdapter = null)
        {
          if (paramWxRecyclerAdapter != null)
          {
            long l1 = paramWxRecyclerAdapter.bZA();
            String str = com.tencent.mm.plugin.expt.hellhound.core.b.hF(l1);
            s.s(str, "long2UnsignedString(feedIdL)");
            if (!this.Dnw.containsKey(str))
            {
              paramLinearLayoutManager = g.DnK;
              Object localObject1 = g.a.a(paramWxRecyclerAdapter);
              paramLinearLayoutManager = "";
              if ((paramWxRecyclerAdapter instanceof BaseFinderFeed)) {
                paramLinearLayoutManager = ((BaseFinderFeed)paramWxRecyclerAdapter).feedObject.getUserName();
              }
              Object localObject2 = ((com.tencent.mm.vending.j.b)localObject1).get(0);
              s.s(localObject2, "liveIdTuple3.`$1`()");
              long l2 = ((Number)localObject2).longValue();
              localObject1 = ((com.tencent.mm.vending.j.c)localObject1).get(1);
              s.s(localObject1, "liveIdTuple3.`$2`()");
              k = ((Number)localObject1).intValue();
              localObject1 = g.DnK;
              paramLinearLayoutManager = new g(paramWxRecyclerAdapter, paramLinearLayoutManager, i, str, l1, l2, paramw, paramString, k, g.a.b(paramWxRecyclerAdapter), g.b.DnU, true, false, 0, null, null, null, null, 258048);
              if ((paramWxRecyclerAdapter instanceof ac)) {
                paramLinearLayoutManager.a(q.w.DwO);
              }
              ((Map)this.Dnw).put(str, paramLinearLayoutManager);
              ((Map)this.Dnu).put(str, paramLinearLayoutManager);
              paramWxRecyclerAdapter = this.Dnn;
              if (paramWxRecyclerAdapter != null) {
                paramWxRecyclerAdapter.a(paramLinearLayoutManager, true);
              }
            }
            localArrayList.add(str);
          }
          if (i != j) {
            break label509;
          }
          paramWxRecyclerAdapter = this.Dnw.entrySet().iterator();
          while (paramWxRecyclerAdapter.hasNext())
          {
            paramLinearLayoutManager = paramWxRecyclerAdapter.next();
            s.s(paramLinearLayoutManager, "iterator.next()");
            paramw = (Map.Entry)paramLinearLayoutManager;
            if (!localArrayList.contains(paramw.getKey()))
            {
              paramWxRecyclerAdapter.remove();
              this.Dnu.remove(paramw.getKey());
              paramLinearLayoutManager = this.Dnn;
              if (paramLinearLayoutManager != null)
              {
                paramw = paramw.getValue();
                s.s(paramw, "hellFeedPair.value");
                paramLinearLayoutManager.c((g)paramw);
              }
            }
          }
          i -= 1;
          j -= 1;
          break;
          k = 0;
          break label69;
        }
        localArrayList.clear();
        AppMethodBeat.o(351896);
        return;
        label509:
        i += 1;
      }
    }
  }
  
  final void b(WxRecyclerAdapter<?> paramWxRecyclerAdapter, LinearLayoutManager paramLinearLayoutManager, q.w paramw, String paramString)
  {
    AppMethodBeat.i(351931);
    int j = paramLinearLayoutManager.Ju();
    int k = paramLinearLayoutManager.Jw();
    int m = paramWxRecyclerAdapter.agOb.size();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    List localList = (List)paramWxRecyclerAdapter.data;
    int i;
    if (!((Collection)localList).isEmpty())
    {
      i = 1;
      if ((i != 0) && (j <= k))
      {
        i = j;
        if (paramLinearLayoutManager.findViewByPosition(i) != null) {
          if (i - m >= 0) {
            break label230;
          }
        }
      }
    }
    Object localObject2;
    label180:
    label230:
    for (j = 0;; j = i - m)
    {
      if (localList.size() > j)
      {
        localObject2 = localList.get(j);
        if (!(localObject2 instanceof y)) {
          break label240;
        }
        paramWxRecyclerAdapter = a((y)localObject2, paramw, paramString, i);
        localArrayList1.addAll((Collection)paramWxRecyclerAdapter.get(0));
        localArrayList2.addAll((Collection)paramWxRecyclerAdapter.get(1));
      }
      if (i != k) {
        break label1255;
      }
      paramWxRecyclerAdapter = localArrayList2.iterator();
      while (paramWxRecyclerAdapter.hasNext())
      {
        paramLinearLayoutManager = (String)paramWxRecyclerAdapter.next();
        this.Dnu.remove(paramLinearLayoutManager);
      }
      i = 0;
      break;
    }
    label240:
    Object localObject1;
    boolean bool;
    if ((localObject2 instanceof aj))
    {
      localObject1 = (aj)localObject2;
      paramWxRecyclerAdapter = ((aj)localObject1).contact.getUsername();
      if (!this.Dny.containsKey(paramWxRecyclerAdapter)) {
        if (((aj)localObject1).contact.field_liveStatus != 1) {
          break label363;
        }
      }
      label363:
      for (bool = true;; bool = false)
      {
        localObject1 = new h((aj)localObject1, i, paramWxRecyclerAdapter, paramw, paramString, bool, ((aj)localObject1).contact.getNickname());
        ((Map)this.Dny).put(paramWxRecyclerAdapter, localObject1);
        localObject2 = this.Dnn;
        if (localObject2 != null) {
          ((p)localObject2).a((h)localObject1);
        }
        localArrayList1.add(paramWxRecyclerAdapter);
        break;
      }
    }
    if ((localObject2 instanceof BaseFinderFeed))
    {
      if (paramw != q.w.DwO) {
        break label1267;
      }
      if (s.p(paramString, q.n.Dtt.scene))
      {
        paramWxRecyclerAdapter = q.w.DwQ;
        localObject1 = "17";
      }
    }
    for (;;)
    {
      label407:
      localObject2 = (BaseFinderFeed)localObject2;
      Object localObject3 = ((BaseFinderFeed)localObject2).feedObject.getLiveInfo();
      if ((localObject3 != null) && (((bip)localObject3).liveStatus == 1))
      {
        j = 1;
        label441:
        bool = ((BaseFinderFeed)localObject2).feedObject.isLiveFeed();
        if (!bool) {
          break label745;
        }
        paramWxRecyclerAdapter = q.w.DwP;
      }
      label460:
      label745:
      label1264:
      for (;;)
      {
        long l1 = ((BaseFinderFeed)localObject2).bZA();
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.hF(l1);
        s.s(localObject3, "long2UnsignedString(feedIdL)");
        Object localObject4;
        Object localObject6;
        Object localObject5;
        Object localObject7;
        long l2;
        int n;
        if (!this.Dnu.containsKey(localObject3))
        {
          localObject4 = g.DnK;
          localObject6 = g.a.a((cc)localObject2);
          localObject4 = (cc)localObject2;
          localObject5 = ((BaseFinderFeed)localObject2).feedObject.getUserName();
          localObject7 = ((com.tencent.mm.vending.j.b)localObject6).get(0);
          s.s(localObject7, "liveIdTuple3.`$1`()");
          l2 = ((Number)localObject7).longValue();
          localObject7 = ((com.tencent.mm.vending.j.c)localObject6).get(1);
          s.s(localObject7, "liveIdTuple3.`$2`()");
          n = ((Number)localObject7).intValue();
          localObject7 = g.DnK;
          localObject7 = g.a.b((cc)localObject2);
          if (j == 0) {
            break label757;
          }
        }
        label757:
        for (localObject2 = g.b.DnV;; localObject2 = g.b.DnW)
        {
          localObject6 = ((d)localObject6).get(2);
          s.s(localObject6, "liveIdTuple3.`$3`()");
          paramWxRecyclerAdapter = new g((cc)localObject4, (String)localObject5, i, (String)localObject3, l1, l2, paramWxRecyclerAdapter, (String)localObject1, n, (String)localObject7, (g.b)localObject2, bool, ((Boolean)localObject6).booleanValue(), 0, null, null, null, null, 253952);
          ((Map)this.Dnu).put(localObject3, paramWxRecyclerAdapter);
          localObject1 = this.Dnn;
          if (localObject1 != null) {
            ((p)localObject1).a(paramWxRecyclerAdapter, true);
          }
          localArrayList1.add(localObject3);
          break;
          if (!s.p(paramString, q.n.DtA.scene)) {
            break label1267;
          }
          paramWxRecyclerAdapter = q.w.DwQ;
          localObject1 = "18";
          break label407;
          j = 0;
          break label441;
          if (j == 0) {
            break label1264;
          }
          paramWxRecyclerAdapter = q.w.DwQ;
          break label460;
        }
        if ((localObject2 instanceof cc)) {}
        for (paramWxRecyclerAdapter = (cc)localObject2;; paramWxRecyclerAdapter = null)
        {
          if (paramWxRecyclerAdapter == null) {
            break label1031;
          }
          l1 = paramWxRecyclerAdapter.bZA();
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.hF(l1);
          s.s(localObject2, "long2UnsignedString(feedIdL)");
          if (!this.Dnu.containsKey(localObject2))
          {
            localObject1 = g.DnK;
            localObject3 = g.a.a(paramWxRecyclerAdapter);
            localObject1 = "";
            if ((paramWxRecyclerAdapter instanceof BaseFinderFeed)) {
              localObject1 = ((BaseFinderFeed)paramWxRecyclerAdapter).feedObject.getUserName();
            }
            localObject4 = ((com.tencent.mm.vending.j.b)localObject3).get(0);
            s.s(localObject4, "liveIdTuple3.`$1`()");
            l2 = ((Number)localObject4).longValue();
            localObject4 = ((com.tencent.mm.vending.j.c)localObject3).get(1);
            s.s(localObject4, "liveIdTuple3.`$2`()");
            j = ((Number)localObject4).intValue();
            localObject4 = g.DnK;
            localObject4 = g.a.b(paramWxRecyclerAdapter);
            localObject5 = g.b.DnU;
            localObject3 = ((d)localObject3).get(2);
            s.s(localObject3, "liveIdTuple3.`$3`()");
            paramWxRecyclerAdapter = new g(paramWxRecyclerAdapter, (String)localObject1, i, (String)localObject2, l1, l2, paramw, paramString, j, (String)localObject4, (g.b)localObject5, ((Boolean)localObject3).booleanValue(), false, 0, null, null, null, null, 258048);
            ((Map)this.Dnu).put(localObject2, paramWxRecyclerAdapter);
            localObject1 = this.Dnn;
            if (localObject1 != null) {
              ((p)localObject1).a(paramWxRecyclerAdapter, true);
            }
          }
          localArrayList1.add(localObject2);
          break;
        }
        break label180;
        if (s.p(paramString, "12"))
        {
          paramWxRecyclerAdapter = this.Dny.entrySet().iterator();
          while (paramWxRecyclerAdapter.hasNext())
          {
            paramLinearLayoutManager = paramWxRecyclerAdapter.next();
            s.s(paramLinearLayoutManager, "iterator.next()");
            paramw = (Map.Entry)paramLinearLayoutManager;
            if (!localArrayList1.contains(paramw.getKey()))
            {
              paramWxRecyclerAdapter.remove();
              paramLinearLayoutManager = this.Dnn;
              if (paramLinearLayoutManager != null)
              {
                paramw = paramw.getValue();
                s.s(paramw, "hellFeedPair.value");
                paramLinearLayoutManager.b((h)paramw);
              }
            }
          }
        }
        paramWxRecyclerAdapter = this.Dnu.entrySet().iterator();
        while (paramWxRecyclerAdapter.hasNext())
        {
          paramLinearLayoutManager = paramWxRecyclerAdapter.next();
          s.s(paramLinearLayoutManager, "iterator.next()");
          paramw = (Map.Entry)paramLinearLayoutManager;
          if (!localArrayList1.contains(paramw.getKey()))
          {
            paramWxRecyclerAdapter.remove();
            paramLinearLayoutManager = this.Dnn;
            if (paramLinearLayoutManager != null)
            {
              paramw = paramw.getValue();
              s.s(paramw, "hellFeedPair.value");
              paramLinearLayoutManager.c((g)paramw);
            }
          }
        }
        localArrayList1.clear();
        localArrayList2.clear();
        AppMethodBeat.o(351931);
        return;
        i += 1;
        break;
      }
      label1031:
      label1255:
      label1267:
      localObject1 = paramString;
      paramWxRecyclerAdapter = paramw;
    }
  }
  
  final void esZ()
  {
    AppMethodBeat.i(351958);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.dIE();
    if ((s.p(localObject1, "com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI3")) || (s.p(localObject1, "OccupyFinderUI3")))
    {
      AppMethodBeat.o(351958);
      return;
    }
    localObject1 = this.Dnu.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      s.s(localObject2, "iterator.next()");
      Object localObject3 = (Map.Entry)localObject2;
      ((Iterator)localObject1).remove();
      localObject2 = this.Dnn;
      if (localObject2 != null)
      {
        localObject3 = ((Map.Entry)localObject3).getValue();
        s.s(localObject3, "hellFeedPair.value");
        ((p)localObject2).c((g)localObject3);
      }
    }
    AppMethodBeat.o(351958);
  }
  
  final void eta()
  {
    AppMethodBeat.i(351975);
    Iterator localIterator = this.Dnv.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      s.s(localObject1, "iterator.next()");
      Object localObject2 = (Map.Entry)localObject1;
      localIterator.remove();
      localObject1 = this.Dnn;
      if (localObject1 != null)
      {
        localObject2 = ((Map.Entry)localObject2).getValue();
        s.s(localObject2, "hellFeedPair.value");
        ((p)localObject1).b((i)localObject2);
      }
    }
    AppMethodBeat.o(351975);
  }
  
  final void etb()
  {
    AppMethodBeat.i(351863);
    if (!((Map)this.Dnw).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      Iterator localIterator = this.Dnw.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = ((Map.Entry)localIterator.next()).getValue();
        s.s(localObject, "iterator.next().value");
        localObject = (g)localObject;
        p localp = this.Dnn;
        if (localp != null) {
          localp.a((g)localObject, true);
        }
      }
    }
    AppMethodBeat.o(351863);
  }
  
  final void etc()
  {
    AppMethodBeat.i(351871);
    if (!((Map)this.Dnw).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      Iterator localIterator = this.Dnw.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = ((Map.Entry)localIterator.next()).getValue();
        s.s(localObject, "iterator.next().value");
        localObject = (g)localObject;
        p localp = this.Dnn;
        if (localp != null) {
          localp.c((g)localObject);
        }
      }
    }
    AppMethodBeat.o(351871);
  }
  
  final void etd()
  {
    AppMethodBeat.i(351970);
    Iterator localIterator = this.Dny.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      s.s(localObject1, "iterator.next()");
      Object localObject2 = (Map.Entry)localObject1;
      localIterator.remove();
      localObject1 = this.Dnn;
      if (localObject1 != null)
      {
        localObject2 = ((Map.Entry)localObject2).getValue();
        s.s(localObject2, "hellFeedPair.value");
        ((p)localObject1).b((h)localObject2);
      }
    }
    AppMethodBeat.o(351970);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/report/HellFeedSingleExposure$mChatListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/sns/ISnsFeedListener;", "onAppear", "", "adapter", "Landroid/widget/BaseAdapter;", "hellFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/HellFeed;", "view", "Landroid/view/View;", "onDisappear", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.expt.hellhound.ext.f.a
  {
    b(f paramf) {}
    
    public final void a(BaseAdapter paramBaseAdapter, com.tencent.mm.plugin.expt.hellhound.ext.a.c paramc, View paramView)
    {
      AppMethodBeat.i(351973);
      if (paramc == null)
      {
        AppMethodBeat.o(351973);
        return;
      }
      String str1 = paramc.zDG.userName;
      int i = paramc.position;
      String str2 = paramc.zDG.feedId;
      s.s(str2, "hellFeed.feed.feedId");
      long l1 = Util.safeParseLong(paramc.zDG.feedId);
      long l2 = Util.safeParseLong(paramc.liveId);
      q.w localw = this.DnJ.DnA;
      String str3 = this.DnJ.DnB;
      paramView = paramc.zDG.nickName;
      paramBaseAdapter = paramView;
      if (paramView == null) {
        paramBaseAdapter = "";
      }
      if (paramc.liveStatus == 1) {}
      for (paramView = g.b.DnV;; paramView = g.b.DnW)
      {
        paramBaseAdapter = new g(null, str1, i, str2, l1, l2, localw, str3, -1, paramBaseAdapter, paramView, true, true, q.bp.DBO.type, null, null, null, paramc.zDL, 114688);
        paramc = this.DnJ.Dnn;
        if (paramc != null) {
          paramc.a(paramBaseAdapter, false);
        }
        AppMethodBeat.o(351973);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/report/HellFeedSingleExposure$mSnsListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/sns/ISnsFeedListener;", "onAppear", "", "adapter", "Landroid/widget/BaseAdapter;", "hellFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/HellFeed;", "view", "Landroid/view/View;", "onDisappear", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.plugin.expt.hellhound.ext.f.a
  {
    c(f paramf) {}
    
    public final void a(BaseAdapter paramBaseAdapter, com.tencent.mm.plugin.expt.hellhound.ext.a.c paramc, View paramView)
    {
      AppMethodBeat.i(351969);
      if (paramBaseAdapter == null)
      {
        AppMethodBeat.o(351969);
        return;
      }
      if (paramc == null)
      {
        AppMethodBeat.o(351969);
        return;
      }
      if (paramView == null)
      {
        AppMethodBeat.o(351969);
        return;
      }
      if (!(paramBaseAdapter instanceof com.tencent.mm.plugin.sns.ui.a.c))
      {
        AppMethodBeat.o(351969);
        return;
      }
      if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        AppMethodBeat.o(351969);
        return;
      }
      label124:
      Object localObject2;
      long l1;
      long l2;
      String str1;
      if (TextUtils.isEmpty((CharSequence)paramc.finderLiveId))
      {
        f localf = this.DnJ;
        paramBaseAdapter = paramView.getTag();
        q.w localw;
        String str2;
        if ((paramBaseAdapter instanceof d.a))
        {
          paramBaseAdapter = (d.a)paramBaseAdapter;
          if (paramBaseAdapter != null)
          {
            paramBaseAdapter = paramBaseAdapter.timeLineObject;
            if (paramBaseAdapter != null)
            {
              paramBaseAdapter = paramBaseAdapter.ContentObj;
              if (paramBaseAdapter != null) {
                break label303;
              }
              paramView = null;
              if (paramView != null)
              {
                localObject1 = paramView.username;
                paramBaseAdapter = (BaseAdapter)localObject1;
                if (localObject1 == null) {
                  paramBaseAdapter = "";
                }
                i = paramc.position;
                localObject2 = paramView.feedId;
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = "";
                }
                l1 = Util.safeParseLong(paramView.feedId);
                l2 = Util.safeParseLong(paramView.liveId);
                localw = q.w.DwP;
                str2 = localf.DnB;
                str1 = paramView.nickName;
                localObject2 = str1;
                if (str1 == null) {
                  localObject2 = "";
                }
                if (paramView.liveStatus != 1) {
                  break label311;
                }
              }
            }
          }
        }
        label303:
        label311:
        for (paramView = g.b.DnV;; paramView = g.b.DnW)
        {
          paramBaseAdapter = new g(null, paramBaseAdapter, i, (String)localObject1, l1, l2, localw, str2, -1, (String)localObject2, paramView, true, true, q.bp.DBQ.type, null, null, null, paramc.zDL, 114688);
          paramc = localf.Dnn;
          if (paramc != null) {
            paramc.a(paramBaseAdapter, false);
          }
          AppMethodBeat.o(351969);
          return;
          paramBaseAdapter = null;
          break;
          paramView = paramBaseAdapter.DHa;
          break label124;
        }
      }
      paramView = this.DnJ;
      Object localObject1 = paramc.zDJ;
      int i = paramc.position;
      if (TextUtils.isEmpty((CharSequence)paramc.zDK)) {}
      for (paramBaseAdapter = paramc.zDG.feedId;; paramBaseAdapter = paramc.zDK)
      {
        s.s(paramBaseAdapter, "if (TextUtils.isEmpty(he…      hellFeed.liveFeedId");
        l1 = Util.safeParseLong(paramc.zDG.feedId);
        l2 = Util.safeParseLong(paramc.liveId);
        localObject2 = q.w.DwP;
        str1 = paramc.zDG.userName;
        s.s(str1, "hellFeed.feed.userName");
        paramBaseAdapter = new g(null, (String)localObject1, i, paramBaseAdapter, l1, l2, (q.w)localObject2, "37", -1, str1, g.b.DnV, true, true, q.bp.DBQ.type, null, null, null, paramc.zDL, 114688);
        paramc = paramView.Dnn;
        if (paramc != null) {
          paramc.a(paramBaseAdapter, false);
        }
        AppMethodBeat.o(351969);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.f
 * JD-Core Version:    0.7.0.1
 */