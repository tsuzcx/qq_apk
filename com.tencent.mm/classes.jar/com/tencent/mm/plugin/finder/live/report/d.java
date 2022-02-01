package com.tencent.mm.plugin.finder.live.report;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ab;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.search.f.a;
import com.tencent.mm.plugin.finder.search.g;
import com.tencent.mm.plugin.finder.search.g.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>;
import java.lang.ref.WeakReference;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/HellFeedExposure;", "", "mCallback", "Lcom/tencent/mm/plugin/finder/live/report/IFeedEventCallback;", "(Lcom/tencent/mm/plugin/finder/live/report/IFeedEventCallback;)V", "TAG", "", "mAdapterMixSearchRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;", "mAdapterProfileRef", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mAdapterRef", "getMCallback", "()Lcom/tencent/mm/plugin/finder/live/report/IFeedEventCallback;", "mFeedCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveFeed;", "Lkotlin/collections/HashMap;", "mFeedHorizontalCache", "mHorAdapterRef", "mHorLayoutRef", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mLayoutRef", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "mMixSearchItemCache", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveMixSearchItem;", "_doOnScroll", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "rvFeeds", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "actionType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "commentscene", "pos", "", "_doOnScrollHorizontal", "rvFeed", "doRunOnScroll", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "doRunOnScrollHorizontal", "onAppearCallback", "userName", "onDestroy", "onDisappearCallback", "curScrrenFeedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onFeedAllDisappear", "onMixSearchAllDisappear", "onMixSearchDisappearCallback", "onScroll", "adapter", "layoutManager", "fromProfile", "", "onScrollHorizontal", "onScrollMixSearch", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "run", "event", "Lcom/tencent/mm/plugin/finder/live/report/HELL_SCROLL_EVENT;", "plugin-finder_release"})
public final class d
{
  final String TAG;
  WeakReference<StaggeredGridLayoutManager> yAq;
  WeakReference<WxRecyclerAdapter<?>> yAr;
  WeakReference<g.b> yAs;
  WeakReference<WxRecyclerAdapter<bu>> yAt;
  WeakReference<LinearLayoutManager> yAu;
  WeakReference<WxRecyclerAdapter<?>> yAv;
  private final HashMap<String, h> yAw;
  private final HashMap<String, j> yAx;
  final HashMap<String, h> yAy;
  private final r yAz;
  
  public d(r paramr)
  {
    AppMethodBeat.i(281602);
    this.yAz = paramr;
    this.TAG = "HABBYGE-MALI.HellFeedExposure";
    this.yAw = new HashMap();
    this.yAx = new HashMap();
    this.yAy = new HashMap();
    AppMethodBeat.o(281602);
  }
  
  private final c<List<String>, List<String>> a(x paramx, s.t paramt, String paramString, int paramInt)
  {
    AppMethodBeat.i(281596);
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
            break label322;
          }
        }
        label322:
        for (paramx = ((y)localObject1).zAF.username;; paramx = "")
        {
          Object localObject3 = ((com.tencent.mm.vending.j.d)localObject2).ieT();
          p.j(localObject3, "liveIdTuple3.`$1`()");
          long l2 = ((Number)localObject3).longValue();
          localObject3 = ((com.tencent.mm.vending.j.d)localObject2).ieU();
          p.j(localObject3, "liveIdTuple3.`$2`()");
          int i = ((Number)localObject3).intValue();
          localObject3 = h.yAW;
          localObject3 = h.a.b((bu)localObject1);
          h.b localb = h.b.yAX;
          localObject2 = ((com.tencent.mm.vending.j.d)localObject2).ieV();
          p.j(localObject2, "liveIdTuple3.`$3`()");
          paramx = new h((bu)localObject1, paramx, paramInt, str, l1, l2, paramt, paramString, i, (String)localObject3, localb, ((Boolean)localObject2).booleanValue(), false, 0, null, null, null, 126976);
          if ((localObject1 instanceof ab)) {
            paramx.a(s.t.yGM);
          }
          ((Map)this.yAw).put(str, paramx);
          localObject1 = this.yAz;
          if (localObject1 != null) {
            ((r)localObject1).a(paramx, false);
          }
          localArrayList1.add(str);
          break;
        }
      }
      localArrayList2.add(str);
    }
    paramx = a.J(localArrayList1, localArrayList2);
    p.j(paramx, "Tuple.make(retIdList, needDelList)");
    AppMethodBeat.o(281596);
    return paramx;
  }
  
  private final String a(bu parambu, String paramString1, int paramInt, s.t paramt, String paramString2)
  {
    AppMethodBeat.i(281597);
    long l1 = parambu.mf();
    String str = b.Fw(l1);
    p.j(str, "HellhoundUtil.long2UnsignedString(feedIdL)");
    if (!this.yAw.containsKey(str))
    {
      Object localObject1 = h.yAW;
      localObject1 = h.a.a(parambu);
      Object localObject2 = ((com.tencent.mm.vending.j.d)localObject1).ieT();
      p.j(localObject2, "tuple3.`$1`()");
      long l2 = ((Number)localObject2).longValue();
      localObject2 = ((com.tencent.mm.vending.j.d)localObject1).ieU();
      p.j(localObject2, "tuple3.`$2`()");
      int i = ((Number)localObject2).intValue();
      localObject2 = h.yAW;
      localObject2 = h.a.b(parambu);
      h.b localb = h.b.yAX;
      localObject1 = ((com.tencent.mm.vending.j.d)localObject1).ieV();
      p.j(localObject1, "tuple3.`$3`()");
      parambu = new h(parambu, paramString1, paramInt, str, l1, l2, paramt, paramString2, i, (String)localObject2, localb, false, ((Boolean)localObject1).booleanValue(), 0, null, null, null, 122880);
      ((Map)this.yAw).put(str, parambu);
      paramString1 = this.yAz;
      if (paramString1 != null) {
        paramString1.a(parambu, false);
      }
    }
    AppMethodBeat.o(281597);
    return str;
  }
  
  private final void af(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(281600);
    Iterator localIterator = this.yAw.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      p.j(localObject1, "iterator.next()");
      Object localObject2 = (Map.Entry)localObject1;
      if (!paramArrayList.contains(((Map.Entry)localObject2).getKey()))
      {
        localIterator.remove();
        localObject1 = this.yAz;
        if (localObject1 != null)
        {
          localObject2 = ((Map.Entry)localObject2).getValue();
          p.j(localObject2, "hellFeedPair.value");
          ((r)localObject1).b((h)localObject2);
        }
      }
    }
    AppMethodBeat.o(281600);
  }
  
  private final void ag(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(281601);
    Iterator localIterator = this.yAx.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      p.j(localObject1, "iterator.next()");
      Object localObject2 = (Map.Entry)localObject1;
      if (!paramArrayList.contains(((Map.Entry)localObject2).getKey()))
      {
        localIterator.remove();
        localObject1 = this.yAz;
        if (localObject1 != null)
        {
          localObject2 = ((Map.Entry)localObject2).getValue();
          p.j(localObject2, "hellFeedPair.value");
          ((r)localObject1).b((j)localObject2);
        }
      }
    }
    paramArrayList.clear();
    AppMethodBeat.o(281601);
  }
  
  final void a(g.b paramb, StaggeredGridLayoutManager paramStaggeredGridLayoutManager, s.t paramt, String paramString)
  {
    AppMethodBeat.i(281594);
    Object localObject1 = new int[paramStaggeredGridLayoutManager.ku()];
    paramStaggeredGridLayoutManager.k((int[])localObject1);
    Object localObject2 = new int[paramStaggeredGridLayoutManager.ku()];
    paramStaggeredGridLayoutManager.l((int[])localObject2);
    int j = Math.min(localObject1[0], localObject1[1]);
    int k = Math.max(localObject2[0], localObject2[1]);
    ArrayList localArrayList = new ArrayList();
    List localList1 = paramb.dQT();
    List localList2 = g.a(paramb.AbB).dQN();
    int i;
    label128:
    int m;
    int n;
    if (!((Collection)localList1).isEmpty())
    {
      i = 1;
      if (i == 0)
      {
        if (((Collection)localList2).isEmpty()) {
          break label226;
        }
        i = 1;
        if (i == 0) {
          break label525;
        }
      }
      m = localList2.size();
      n = localList1.size();
      if (j > k) {
        break label525;
      }
      i = j;
      label162:
      if (paramStaggeredGridLayoutManager.findViewByPosition(i) != null) {
        switch (paramb.getItemViewType(i))
        {
        }
      }
    }
    for (;;)
    {
      if (i == k) {
        break label525;
      }
      i += 1;
      break label162;
      i = 0;
      break;
      label226:
      i = 0;
      break label128;
      if (i < m)
      {
        Object localObject4 = (bip)localList2.get(i);
        localObject1 = ((bip)localObject4).contact;
        if (localObject1 != null)
        {
          localObject2 = ((FinderContact)localObject1).username;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        do
        {
          localArrayList.add(localObject1);
          break;
          p.j(localObject2, "contact.contact?.username ?: return \"\"");
          localObject1 = localObject2;
        } while (this.yAx.containsKey(localObject2));
        s.t localt = s.t.yGM;
        localObject1 = ((bip)localObject4).contact;
        if ((localObject1 != null) && (((FinderContact)localObject1).liveStatus == 1)) {}
        for (boolean bool = true;; bool = false)
        {
          localObject1 = ((bip)localObject4).contact;
          if (localObject1 != null)
          {
            localObject3 = ((FinderContact)localObject1).nickname;
            localObject1 = localObject3;
            if (localObject3 != null) {}
          }
          else
          {
            localObject1 = "";
          }
          Object localObject3 = new j((bip)localObject4, i, (String)localObject2, localt, "23", bool, (String)localObject1);
          ((Map)this.yAx).put(localObject2, localObject3);
          localObject4 = this.yAz;
          localObject1 = localObject2;
          if (localObject4 == null) {
            break;
          }
          ((r)localObject4).a((j)localObject3);
          localObject1 = localObject2;
          break;
        }
        j = paramb.PW(i);
        if ((j >= 0) && (n > j)) {
          localArrayList.add(a((bu)localList1.get(j), ((BaseFinderFeed)localList1.get(j)).feedObject.getUserName(), j, paramt, paramString));
        }
      }
    }
    label525:
    af(localArrayList);
    ag(localArrayList);
    localArrayList.clear();
    AppMethodBeat.o(281594);
  }
  
  final void a(WxRecyclerAdapter<?> paramWxRecyclerAdapter, LinearLayoutManager paramLinearLayoutManager, s.t paramt, String paramString)
  {
    AppMethodBeat.i(281592);
    int i = paramLinearLayoutManager.kJ();
    int j = paramLinearLayoutManager.kL();
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
          break label381;
        }
        i += 1;
        break label81;
        i -= 1;
        j -= 1;
        break;
        k = 0;
        break label69;
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
          Object localObject3 = ((com.tencent.mm.vending.j.d)localObject2).ieT();
          p.j(localObject3, "liveIdTuple3.`$1`()");
          long l2 = ((Number)localObject3).longValue();
          localObject2 = ((com.tencent.mm.vending.j.d)localObject2).ieU();
          p.j(localObject2, "liveIdTuple3.`$2`()");
          k = ((Number)localObject2).intValue();
          localObject2 = h.yAW;
          paramWxRecyclerAdapter = new h((bu)localObject1, paramWxRecyclerAdapter, i, paramLinearLayoutManager, l1, l2, paramt, paramString, k, h.a.b((bu)localObject1), h.b.yAX, true, false, 0, null, null, null, 126976);
          ((Map)this.yAy).put(paramLinearLayoutManager, paramWxRecyclerAdapter);
          ((Map)this.yAw).put(paramLinearLayoutManager, paramWxRecyclerAdapter);
          localObject1 = this.yAz;
          if (localObject1 != null) {
            ((r)localObject1).a(paramWxRecyclerAdapter, false);
          }
        }
        localArrayList.add(paramLinearLayoutManager);
      }
      label381:
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
      AppMethodBeat.o(281592);
      return;
    }
  }
  
  final void a(WxRecyclerAdapter<bu> paramWxRecyclerAdapter, StaggeredGridLayoutManager paramStaggeredGridLayoutManager, s.t paramt, String paramString)
  {
    AppMethodBeat.i(281593);
    Object localObject1 = new int[paramStaggeredGridLayoutManager.ku()];
    paramStaggeredGridLayoutManager.k((int[])localObject1);
    Object localObject2 = new int[paramStaggeredGridLayoutManager.ku()];
    paramStaggeredGridLayoutManager.l((int[])localObject2);
    int k = paramWxRecyclerAdapter.YSk.size();
    int j = Math.min(localObject1[0], localObject1[1]);
    int m = Math.max(localObject2[0], localObject2[1]);
    paramStaggeredGridLayoutManager = new ArrayList();
    localObject1 = (List)paramWxRecyclerAdapter.data;
    int i;
    if (!((Collection)localObject1).isEmpty())
    {
      i = 1;
      if ((i == 0) || (j > m)) {
        break label242;
      }
      i = j;
      label120:
      if (i - k < 0) {
        break label174;
      }
    }
    label174:
    for (j = i - k;; j = i)
    {
      if ((j < ((List)localObject1).size()) && (j >= 0)) {
        break label181;
      }
      if (i == m) {
        break label242;
      }
      i += 1;
      break label120;
      i = 0;
      break;
    }
    label181:
    localObject2 = (bu)((List)localObject1).get(j);
    if ((localObject2 instanceof BaseFinderFeed)) {}
    for (paramWxRecyclerAdapter = ((BaseFinderFeed)localObject2).feedObject.getUserName();; paramWxRecyclerAdapter = "")
    {
      paramStaggeredGridLayoutManager.add(a((bu)localObject2, paramWxRecyclerAdapter, i, paramt, paramString));
      break;
    }
    label242:
    af(paramStaggeredGridLayoutManager);
    paramStaggeredGridLayoutManager.clear();
    AppMethodBeat.o(281593);
  }
  
  final void b(WxRecyclerAdapter<?> paramWxRecyclerAdapter, StaggeredGridLayoutManager paramStaggeredGridLayoutManager, s.t paramt, String paramString)
  {
    AppMethodBeat.i(281595);
    Object localObject1 = new int[paramStaggeredGridLayoutManager.ku()];
    paramStaggeredGridLayoutManager.k((int[])localObject1);
    Object localObject2 = new int[paramStaggeredGridLayoutManager.ku()];
    paramStaggeredGridLayoutManager.l((int[])localObject2);
    int k = paramWxRecyclerAdapter.YSk.size();
    int j = Math.min(localObject1[0], localObject1[1]);
    int m = Math.max(localObject2[0], localObject2[1]);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    List localList = (List)paramWxRecyclerAdapter.data;
    int i;
    if (!((Collection)localList).isEmpty()) {
      i = 1;
    }
    String str;
    for (;;)
    {
      if ((i != 0) && (j <= m))
      {
        i = j;
        for (;;)
        {
          if (paramStaggeredGridLayoutManager.findViewByPosition(i) != null)
          {
            j = k + i;
            if (localList.size() > j)
            {
              localObject2 = localList.get(j);
              if (!(localObject2 instanceof x)) {
                break;
              }
              paramWxRecyclerAdapter = a((x)localObject2, paramt, paramString, i);
              localArrayList1.addAll((Collection)paramWxRecyclerAdapter.ieT());
              localArrayList2.addAll((Collection)paramWxRecyclerAdapter.ieU());
            }
          }
          if (i == m) {
            break label352;
          }
          i += 1;
        }
        i = 0;
        continue;
        if ((localObject2 instanceof BaseFinderFeed))
        {
          str = ((BaseFinderFeed)localObject2).feedObject.getUserName();
          if (!p.h(paramString, s.l.yFX.scene)) {
            break label418;
          }
          paramWxRecyclerAdapter = s.t.yGN;
          localObject1 = "15";
        }
      }
    }
    for (;;)
    {
      localArrayList1.add(a((bu)localObject2, str, i, paramWxRecyclerAdapter, (String)localObject1));
      break;
      if (!(localObject2 instanceof bu)) {}
      for (paramWxRecyclerAdapter = null;; paramWxRecyclerAdapter = (WxRecyclerAdapter<?>)localObject2)
      {
        if ((bu)paramWxRecyclerAdapter == null) {
          break label416;
        }
        localArrayList1.add(a((bu)localObject2, "", i, paramt, paramString));
        break;
        label352:
        paramWxRecyclerAdapter = localArrayList2.iterator();
        while (paramWxRecyclerAdapter.hasNext())
        {
          paramStaggeredGridLayoutManager = (String)paramWxRecyclerAdapter.next();
          this.yAw.remove(paramStaggeredGridLayoutManager);
        }
        af(localArrayList1);
        localArrayList1.clear();
        localArrayList2.clear();
        AppMethodBeat.o(281595);
        return;
      }
      label416:
      break;
      label418:
      localObject1 = paramString;
      paramWxRecyclerAdapter = paramt;
    }
  }
  
  final void dDa()
  {
    AppMethodBeat.i(281598);
    Iterator localIterator = this.yAw.entrySet().iterator();
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
        ((r)localObject1).b((h)localObject2);
      }
    }
    AppMethodBeat.o(281598);
  }
  
  final void dDb()
  {
    AppMethodBeat.i(281599);
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
    AppMethodBeat.o(281599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.d
 * JD-Core Version:    0.7.0.1
 */