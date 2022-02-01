package com.tencent.mm.plugin.finder.live.report;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ac;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.findersdk.a.cj;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.lang.ref.WeakReference;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/HellFeedExposure;", "", "mCallback", "Lcom/tencent/mm/plugin/finder/live/report/IFeedEventCallback;", "(Lcom/tencent/mm/plugin/finder/live/report/IFeedEventCallback;)V", "TAG", "", "mAdapterMixSearchRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/findersdk/api/IMixSearchProfileAdapter;", "mAdapterProfileRef", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mAdapterRef", "getMCallback", "()Lcom/tencent/mm/plugin/finder/live/report/IFeedEventCallback;", "mFeedCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveFeed;", "Lkotlin/collections/HashMap;", "mFeedHorizontalCache", "mHorAdapterRef", "mHorLayoutRef", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mLayoutRef", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "mMixSearchItemCache", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveMixSearchItem;", "_doOnScroll", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "rvFeeds", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "actionType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "commentscene", "pos", "", "_doOnScrollHorizontal", "rvFeed", "doRunOnScroll", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "doRunOnScrollHorizontal", "onAppearCallback", "userName", "onDestroy", "onDisappearCallback", "curScrrenFeedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onFeedAllDisappear", "onMixSearchAllDisappear", "onMixSearchDisappearCallback", "onScroll", "adapter", "layoutManager", "fromProfile", "", "onScrollHorizontal", "onScrollMixSearch", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "run", "event", "Lcom/tencent/mm/plugin/finder/live/report/HELL_SCROLL_EVENT;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private final p Dnn;
  WeakReference<StaggeredGridLayoutManager> Dno;
  WeakReference<WxRecyclerAdapter<?>> Dnp;
  WeakReference<cj> Dnq;
  WeakReference<WxRecyclerAdapter<cc>> Dnr;
  WeakReference<LinearLayoutManager> Dns;
  WeakReference<WxRecyclerAdapter<?>> Dnt;
  private final HashMap<String, g> Dnu;
  private final HashMap<String, i> Dnv;
  final HashMap<String, g> Dnw;
  final String TAG;
  
  public e(p paramp)
  {
    AppMethodBeat.i(351835);
    this.Dnn = paramp;
    this.TAG = "HABBYGE-MALI.HellFeedExposure";
    this.Dnu = new HashMap();
    this.Dnv = new HashMap();
    this.Dnw = new HashMap();
    AppMethodBeat.o(351835);
  }
  
  private final c<List<String>, List<String>> a(y paramy, q.w paramw, String paramString, int paramInt)
  {
    AppMethodBeat.i(351851);
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
            break label326;
          }
        }
        label326:
        for (paramy = ((z)localObject1).ECN.username;; paramy = "")
        {
          Object localObject3 = ((com.tencent.mm.vending.j.b)localObject2).get(0);
          s.s(localObject3, "liveIdTuple3.`$1`()");
          long l2 = ((Number)localObject3).longValue();
          localObject3 = ((c)localObject2).get(1);
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
            ((p)localObject1).a(paramy, false);
          }
          localArrayList1.add(str);
          break;
        }
      }
      localArrayList2.add(str);
    }
    paramy = a.U(localArrayList1, localArrayList2);
    s.s(paramy, "make(retIdList, needDelList)");
    AppMethodBeat.o(351851);
    return paramy;
  }
  
  private final String a(cc paramcc, String paramString1, int paramInt, q.w paramw, String paramString2)
  {
    AppMethodBeat.i(351862);
    long l1 = paramcc.bZA();
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.hF(l1);
    s.s(str, "long2UnsignedString(feedIdL)");
    if (!this.Dnu.containsKey(str))
    {
      Object localObject1 = g.DnK;
      localObject1 = g.a.a(paramcc);
      Object localObject2 = ((com.tencent.mm.vending.j.b)localObject1).get(0);
      s.s(localObject2, "tuple3.`$1`()");
      long l2 = ((Number)localObject2).longValue();
      localObject2 = ((c)localObject1).get(1);
      s.s(localObject2, "tuple3.`$2`()");
      int i = ((Number)localObject2).intValue();
      localObject2 = g.DnK;
      localObject2 = g.a.b(paramcc);
      g.b localb = g.b.DnU;
      localObject1 = ((d)localObject1).get(2);
      s.s(localObject1, "tuple3.`$3`()");
      paramcc = new g(paramcc, paramString1, paramInt, str, l1, l2, paramw, paramString2, i, (String)localObject2, localb, false, ((Boolean)localObject1).booleanValue(), 0, null, null, null, null, 253952);
      ((Map)this.Dnu).put(str, paramcc);
      paramString1 = this.Dnn;
      if (paramString1 != null) {
        paramString1.a(paramcc, false);
      }
    }
    AppMethodBeat.o(351862);
    return str;
  }
  
  private final void ai(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(351870);
    Iterator localIterator = this.Dnu.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      s.s(localObject1, "iterator.next()");
      Object localObject2 = (Map.Entry)localObject1;
      if (!paramArrayList.contains(((Map.Entry)localObject2).getKey()))
      {
        localIterator.remove();
        localObject1 = this.Dnn;
        if (localObject1 != null)
        {
          localObject2 = ((Map.Entry)localObject2).getValue();
          s.s(localObject2, "hellFeedPair.value");
          ((p)localObject1).c((g)localObject2);
        }
      }
    }
    AppMethodBeat.o(351870);
  }
  
  private final void aj(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(351881);
    Iterator localIterator = this.Dnv.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      s.s(localObject1, "iterator.next()");
      Object localObject2 = (Map.Entry)localObject1;
      if (!paramArrayList.contains(((Map.Entry)localObject2).getKey()))
      {
        localIterator.remove();
        localObject1 = this.Dnn;
        if (localObject1 != null)
        {
          localObject2 = ((Map.Entry)localObject2).getValue();
          s.s(localObject2, "hellFeedPair.value");
          ((p)localObject1).b((i)localObject2);
        }
      }
    }
    paramArrayList.clear();
    AppMethodBeat.o(351881);
  }
  
  final void a(cj paramcj, StaggeredGridLayoutManager paramStaggeredGridLayoutManager, q.w paramw, String paramString)
  {
    AppMethodBeat.i(351930);
    Object localObject1 = new int[paramStaggeredGridLayoutManager.bWl];
    paramStaggeredGridLayoutManager.n((int[])localObject1);
    Object localObject2 = new int[paramStaggeredGridLayoutManager.bWl];
    paramStaggeredGridLayoutManager.o((int[])localObject2);
    int j = Math.min(localObject1[0], localObject1[1]);
    int k = Math.max(localObject2[0], localObject2[1]);
    ArrayList localArrayList = new ArrayList();
    List localList1 = paramcj.getData();
    List localList2 = paramcj.eOH();
    int i;
    label124:
    int m;
    int n;
    if (!((Collection)localList1).isEmpty())
    {
      i = 1;
      if (i == 0)
      {
        if (((Collection)localList2).isEmpty()) {
          break label233;
        }
        i = 1;
        if (i == 0) {}
      }
      else
      {
        m = localList2.size();
        n = localList1.size();
        if (j > k) {}
      }
    }
    for (;;)
    {
      if (paramStaggeredGridLayoutManager.findViewByPosition(j) != null) {
        switch (paramcj.getItemViewType(j))
        {
        }
      }
      label275:
      label558:
      for (;;)
      {
        if (j != k) {
          break label560;
        }
        ai(localArrayList);
        aj(localArrayList);
        localArrayList.clear();
        AppMethodBeat.o(351930);
        return;
        i = 0;
        break;
        label233:
        i = 0;
        break label124;
        if (j < m)
        {
          Object localObject4 = (buy)localList2.get(j);
          localObject1 = ((buy)localObject4).contact;
          if (localObject1 == null)
          {
            localObject1 = null;
            if (localObject1 != null) {
              break label306;
            }
            localObject2 = "";
          }
          label306:
          do
          {
            localArrayList.add(localObject2);
            break;
            localObject1 = ((FinderContact)localObject1).username;
            break label275;
            localObject2 = localObject1;
          } while (this.Dnv.containsKey(localObject1));
          q.w localw = q.w.DwO;
          localObject2 = ((buy)localObject4).contact;
          boolean bool;
          if ((localObject2 != null) && (((FinderContact)localObject2).liveStatus == 1))
          {
            bool = true;
            label351:
            localObject2 = ((buy)localObject4).contact;
            if (localObject2 != null) {
              break label446;
            }
            localObject2 = "";
          }
          for (;;)
          {
            Object localObject3 = new i((buy)localObject4, j, (String)localObject1, localw, "23", bool, (String)localObject2);
            ((Map)this.Dnv).put(localObject1, localObject3);
            localObject4 = this.Dnn;
            localObject2 = localObject1;
            if (localObject4 == null) {
              break;
            }
            ((p)localObject4).a((i)localObject3);
            localObject2 = localObject1;
            break;
            bool = false;
            break label351;
            label446:
            localObject3 = ((FinderContact)localObject2).nickname;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
          }
          int i1 = paramcj.Td(j);
          if (i1 >= 0) {
            if (i1 < n) {
              i = 1;
            }
          }
          for (;;)
          {
            if (i == 0) {
              break label558;
            }
            localArrayList.add(a((cc)localList1.get(i1), ((BaseFinderFeed)localList1.get(i1)).feedObject.getUserName(), i1, paramw, paramString));
            break;
            i = 0;
            continue;
            i = 0;
          }
        }
      }
      label560:
      j += 1;
    }
  }
  
  final void a(WxRecyclerAdapter<?> paramWxRecyclerAdapter, LinearLayoutManager paramLinearLayoutManager, q.w paramw, String paramString)
  {
    AppMethodBeat.i(351899);
    int i = paramLinearLayoutManager.Ju();
    int j = paramLinearLayoutManager.Jw();
    if (i == 0)
    {
      if (j < 2) {
        break label501;
      }
      j -= 1;
    }
    label69:
    label475:
    label492:
    label501:
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      List localList = (List)paramWxRecyclerAdapter.data;
      int k;
      if (!((Collection)localList).isEmpty())
      {
        k = 1;
        if ((k == 0) || (i > j)) {}
      }
      for (;;)
      {
        if (localList.size() > i)
        {
          paramWxRecyclerAdapter = localList.get(i);
          if (!(paramWxRecyclerAdapter instanceof cc)) {
            break label475;
          }
        }
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
              localObject1 = ((c)localObject1).get(1);
              s.s(localObject1, "liveIdTuple3.`$2`()");
              k = ((Number)localObject1).intValue();
              localObject1 = g.DnK;
              paramWxRecyclerAdapter = new g(paramWxRecyclerAdapter, paramLinearLayoutManager, i, str, l1, l2, paramw, paramString, k, g.a.b(paramWxRecyclerAdapter), g.b.DnU, true, false, 0, null, null, null, null, 258048);
              ((Map)this.Dnw).put(str, paramWxRecyclerAdapter);
              ((Map)this.Dnu).put(str, paramWxRecyclerAdapter);
              paramLinearLayoutManager = this.Dnn;
              if (paramLinearLayoutManager != null) {
                paramLinearLayoutManager.a(paramWxRecyclerAdapter, false);
              }
            }
            localArrayList.add(str);
          }
          if (i != j) {
            break label492;
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
        AppMethodBeat.o(351899);
        return;
        i += 1;
      }
    }
  }
  
  final void a(WxRecyclerAdapter<cc> paramWxRecyclerAdapter, StaggeredGridLayoutManager paramStaggeredGridLayoutManager, q.w paramw, String paramString)
  {
    AppMethodBeat.i(351910);
    Object localObject1 = new int[paramStaggeredGridLayoutManager.bWl];
    paramStaggeredGridLayoutManager.n((int[])localObject1);
    Object localObject2 = new int[paramStaggeredGridLayoutManager.bWl];
    paramStaggeredGridLayoutManager.o((int[])localObject2);
    int k = paramWxRecyclerAdapter.agOb.size();
    int j = Math.min(localObject1[0], localObject1[1]);
    int m = Math.max(localObject2[0], localObject2[1]);
    paramStaggeredGridLayoutManager = new ArrayList();
    localObject1 = (List)paramWxRecyclerAdapter.data;
    int i;
    if (!((Collection)localObject1).isEmpty())
    {
      i = 1;
      if ((i != 0) && (j <= m)) {
        i = j;
      }
    }
    for (;;)
    {
      if (i - k >= 0) {}
      for (j = i - k;; j = i)
      {
        if ((j < ((List)localObject1).size()) && (j >= 0)) {
          break label188;
        }
        if (i != m) {
          break label249;
        }
        ai(paramStaggeredGridLayoutManager);
        paramStaggeredGridLayoutManager.clear();
        AppMethodBeat.o(351910);
        return;
        i = 0;
        break;
      }
      label188:
      localObject2 = (cc)((List)localObject1).get(j);
      if ((localObject2 instanceof BaseFinderFeed)) {}
      for (paramWxRecyclerAdapter = ((BaseFinderFeed)localObject2).feedObject.getUserName();; paramWxRecyclerAdapter = "")
      {
        paramStaggeredGridLayoutManager.add(a((cc)localObject2, paramWxRecyclerAdapter, i, paramw, paramString));
        break;
      }
      label249:
      i += 1;
    }
  }
  
  final void b(WxRecyclerAdapter<?> paramWxRecyclerAdapter, StaggeredGridLayoutManager paramStaggeredGridLayoutManager, q.w paramw, String paramString)
  {
    AppMethodBeat.i(351947);
    Object localObject1 = new int[paramStaggeredGridLayoutManager.bWl];
    paramStaggeredGridLayoutManager.n((int[])localObject1);
    Object localObject2 = new int[paramStaggeredGridLayoutManager.bWl];
    paramStaggeredGridLayoutManager.o((int[])localObject2);
    int k = paramWxRecyclerAdapter.agOb.size();
    int j = Math.min(localObject1[0], localObject1[1]);
    int m = Math.max(localObject2[0], localObject2[1]);
    localObject2 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    List localList = (List)paramWxRecyclerAdapter.data;
    if (!((Collection)localList).isEmpty()) {}
    Object localObject3;
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (j <= m))
      {
        i = j;
        if (paramStaggeredGridLayoutManager.findViewByPosition(i) != null)
        {
          j = k + i;
          if (localList.size() > j)
          {
            localObject3 = localList.get(j);
            if (!(localObject3 instanceof y)) {
              break;
            }
            paramWxRecyclerAdapter = a((y)localObject3, paramw, paramString, i);
            ((ArrayList)localObject2).addAll((Collection)paramWxRecyclerAdapter.get(0));
            localArrayList.addAll((Collection)paramWxRecyclerAdapter.get(1));
          }
        }
        label220:
        if (i != m) {
          break label411;
        }
      }
      paramWxRecyclerAdapter = localArrayList.iterator();
      while (paramWxRecyclerAdapter.hasNext())
      {
        paramStaggeredGridLayoutManager = (String)paramWxRecyclerAdapter.next();
        this.Dnu.remove(paramStaggeredGridLayoutManager);
      }
    }
    String str;
    if ((localObject3 instanceof BaseFinderFeed))
    {
      str = ((BaseFinderFeed)localObject3).feedObject.getUserName();
      if (!s.p(paramString, q.n.DtB.scene)) {
        break label420;
      }
      paramWxRecyclerAdapter = q.w.DwP;
      localObject1 = "15";
    }
    for (;;)
    {
      ((ArrayList)localObject2).add(a((cc)localObject3, str, i, paramWxRecyclerAdapter, (String)localObject1));
      break label220;
      if ((localObject3 instanceof cc)) {}
      for (paramWxRecyclerAdapter = (cc)localObject3;; paramWxRecyclerAdapter = null)
      {
        if (paramWxRecyclerAdapter == null) {
          break label386;
        }
        ((ArrayList)localObject2).add(a((cc)localObject3, "", i, paramw, paramString));
        break;
      }
      label386:
      break label220;
      ai((ArrayList)localObject2);
      ((ArrayList)localObject2).clear();
      localArrayList.clear();
      AppMethodBeat.o(351947);
      return;
      label411:
      i += 1;
      break;
      label420:
      localObject1 = paramString;
      paramWxRecyclerAdapter = paramw;
    }
  }
  
  final void esZ()
  {
    AppMethodBeat.i(351957);
    Iterator localIterator = this.Dnu.entrySet().iterator();
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
        ((p)localObject1).c((g)localObject2);
      }
    }
    AppMethodBeat.o(351957);
  }
  
  final void eta()
  {
    AppMethodBeat.i(351968);
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
    AppMethodBeat.o(351968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.e
 * JD-Core Version:    0.7.0.1
 */