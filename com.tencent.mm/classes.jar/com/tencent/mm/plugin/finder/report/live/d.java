package com.tencent.mm.plugin.finder.report.live;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.search.e.a;
import com.tencent.mm.plugin.finder.search.f;
import com.tencent.mm.plugin.finder.search.f.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>;
import com.tencent.mm.view.recyclerview.g;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/HellFeedExposure;", "", "mCallback", "Lcom/tencent/mm/plugin/finder/report/live/IFeedEventCallback;", "(Lcom/tencent/mm/plugin/finder/report/live/IFeedEventCallback;)V", "TAG", "", "mAdapterMixSearchRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;", "mAdapterProfileRef", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mAdapterRef", "getMCallback", "()Lcom/tencent/mm/plugin/finder/report/live/IFeedEventCallback;", "mFeedCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveFeed;", "Lkotlin/collections/HashMap;", "mFeedHorizontalCache", "mHorAdapterRef", "mHorLayoutRef", "Landroid/support/v7/widget/LinearLayoutManager;", "mLayoutRef", "Landroid/support/v7/widget/StaggeredGridLayoutManager;", "mMixSearchItemCache", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveMixSearchItem;", "_doOnScroll", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "rvFeeds", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "actionType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "commentscene", "pos", "", "_doOnScrollHorizontal", "rvFeed", "doRunOnScroll", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "doRunOnScrollHorizontal", "onAppearCallback", "userName", "onDestroy", "onDisappearCallback", "curScrrenFeedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onFeedAllDisappear", "onMixSearchAllDisappear", "onMixSearchDisappearCallback", "onScroll", "adapter", "layoutManager", "fromProfile", "", "onScrollHorizontal", "onScrollMixSearch", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "run", "event", "Lcom/tencent/mm/plugin/finder/report/live/HELL_SCROLL_EVENT;", "plugin-finder_release"})
public final class d
{
  final String TAG;
  WeakReference<StaggeredGridLayoutManager> vjn;
  WeakReference<WxRecyclerAdapter<?>> vjo;
  WeakReference<f.b> vjp;
  WeakReference<WxRecyclerAdapter<bo>> vjq;
  WeakReference<LinearLayoutManager> vjr;
  WeakReference<WxRecyclerAdapter<?>> vjs;
  private final HashMap<String, h> vjt;
  private final HashMap<String, j> vju;
  final HashMap<String, h> vjv;
  private final r vjw;
  
  public d(r paramr)
  {
    AppMethodBeat.i(250916);
    this.vjw = paramr;
    this.TAG = "HABBYGE-MALI.HellFeedExposure";
    this.vjt = new HashMap();
    this.vju = new HashMap();
    this.vjv = new HashMap();
    AppMethodBeat.o(250916);
  }
  
  private final c<List<String>, List<String>> a(x paramx, s.p paramp, String paramString, int paramInt)
  {
    AppMethodBeat.i(250910);
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
          localObject1 = ((com.tencent.mm.vending.j.d)localObject2).hdM();
          p.g(localObject1, "liveIdTuple3.`$1`()");
          long l2 = ((Number)localObject1).longValue();
          localObject1 = ((com.tencent.mm.vending.j.d)localObject2).hdN();
          p.g(localObject1, "liveIdTuple3.`$2`()");
          int i = ((Number)localObject1).intValue();
          localObject1 = h.vjR;
          localObject1 = h.a.b((bo)localObject3);
          localObject3 = h.b.vjS;
          localObject2 = ((com.tencent.mm.vending.j.d)localObject2).hdO();
          p.g(localObject2, "liveIdTuple3.`$3`()");
          paramx = new h(localbo, paramx, paramInt, str, l1, l2, paramp, paramString, i, (String)localObject1, (h.b)localObject3, ((Boolean)localObject2).booleanValue(), false, 12288, (byte)0);
          ((Map)this.vjt).put(str, paramx);
          localObject1 = this.vjw;
          if (localObject1 != null) {
            ((r)localObject1).a(paramx, false);
          }
        }
        localArrayList1.add(str);
      }
      else
      {
        localArrayList2.add(str);
      }
    }
    paramx = a.Q(localArrayList1, localArrayList2);
    p.g(paramx, "Tuple.make(retIdList, needDelList)");
    AppMethodBeat.o(250910);
    return paramx;
  }
  
  private final String a(bo parambo, String paramString1, int paramInt, s.p paramp, String paramString2)
  {
    AppMethodBeat.i(250911);
    long l1 = parambo.lT();
    String str = b.zs(l1);
    p.g(str, "HellhoundUtil.long2UnsignedString(feedIdL)");
    if (!this.vjt.containsKey(str))
    {
      Object localObject1 = h.vjR;
      localObject1 = h.a.a(parambo);
      Object localObject2 = ((com.tencent.mm.vending.j.d)localObject1).hdM();
      p.g(localObject2, "tuple3.`$1`()");
      long l2 = ((Number)localObject2).longValue();
      localObject2 = ((com.tencent.mm.vending.j.d)localObject1).hdN();
      p.g(localObject2, "tuple3.`$2`()");
      int i = ((Number)localObject2).intValue();
      localObject2 = h.vjR;
      localObject2 = h.a.b(parambo);
      h.b localb = h.b.vjS;
      localObject1 = ((com.tencent.mm.vending.j.d)localObject1).hdO();
      p.g(localObject1, "tuple3.`$3`()");
      parambo = new h(parambo, paramString1, paramInt, str, l1, l2, paramp, paramString2, i, (String)localObject2, localb, false, ((Boolean)localObject1).booleanValue(), 8192, (byte)0);
      ((Map)this.vjt).put(str, parambo);
      paramString1 = this.vjw;
      if (paramString1 != null) {
        paramString1.a(parambo, false);
      }
    }
    AppMethodBeat.o(250911);
    return str;
  }
  
  private final void ai(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(250914);
    Iterator localIterator = this.vjt.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      p.g(localObject1, "iterator.next()");
      Object localObject2 = (Map.Entry)localObject1;
      if (!paramArrayList.contains(((Map.Entry)localObject2).getKey()))
      {
        localIterator.remove();
        localObject1 = this.vjw;
        if (localObject1 != null)
        {
          localObject2 = ((Map.Entry)localObject2).getValue();
          p.g(localObject2, "hellFeedPair.value");
          ((r)localObject1).a((h)localObject2);
        }
      }
    }
    AppMethodBeat.o(250914);
  }
  
  private final void aj(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(250915);
    Iterator localIterator = this.vju.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      p.g(localObject1, "iterator.next()");
      Object localObject2 = (Map.Entry)localObject1;
      if (!paramArrayList.contains(((Map.Entry)localObject2).getKey()))
      {
        localIterator.remove();
        localObject1 = this.vjw;
        if (localObject1 != null)
        {
          localObject2 = ((Map.Entry)localObject2).getValue();
          p.g(localObject2, "hellFeedPair.value");
          ((r)localObject1).b((j)localObject2);
        }
      }
    }
    paramArrayList.clear();
    AppMethodBeat.o(250915);
  }
  
  final void a(f.b paramb, StaggeredGridLayoutManager paramStaggeredGridLayoutManager, s.p paramp, String paramString)
  {
    AppMethodBeat.i(250908);
    Object localObject1 = new int[paramStaggeredGridLayoutManager.ki()];
    paramStaggeredGridLayoutManager.n((int[])localObject1);
    Object localObject2 = new int[paramStaggeredGridLayoutManager.ki()];
    paramStaggeredGridLayoutManager.o((int[])localObject2);
    int j = Math.min(localObject1[0], localObject1[1]);
    int k = Math.max(localObject2[0], localObject2[1]);
    ArrayList localArrayList = new ArrayList();
    List localList1 = paramb.dpH();
    List localList2 = f.a(paramb.vuE).dpA();
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
          break label523;
        }
      }
      m = localList2.size();
      n = localList1.size();
      if (j > k) {
        break label523;
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
        break label523;
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
        Object localObject4 = (bbz)localList2.get(i);
        localObject1 = ((bbz)localObject4).contact;
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
          p.g(localObject2, "contact.contact?.username ?: return \"\"");
          localObject1 = localObject2;
        } while (this.vju.containsKey(localObject2));
        s.p localp = s.p.voz;
        localObject1 = ((bbz)localObject4).contact;
        if ((localObject1 != null) && (((FinderContact)localObject1).liveStatus == 1)) {}
        for (boolean bool = true;; bool = false)
        {
          localObject1 = ((bbz)localObject4).contact;
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
          Object localObject3 = new j((bbz)localObject4, i, (String)localObject2, localp, "23", bool, (String)localObject1);
          ((Map)this.vju).put(localObject2, localObject3);
          localObject4 = this.vjw;
          localObject1 = localObject2;
          if (localObject4 == null) {
            break;
          }
          ((r)localObject4).a((j)localObject3);
          localObject1 = localObject2;
          break;
        }
        j = paramb.KL(i);
        if ((j >= 0) && (n > j)) {
          localArrayList.add(a((bo)localList1.get(j), ((BaseFinderFeed)localList1.get(j)).feedObject.getUserName(), j, paramp, paramString));
        }
      }
    }
    label523:
    ai(localArrayList);
    aj(localArrayList);
    localArrayList.clear();
    AppMethodBeat.o(250908);
  }
  
  final void a(WxRecyclerAdapter<?> paramWxRecyclerAdapter, LinearLayoutManager paramLinearLayoutManager, s.p paramp, String paramString)
  {
    AppMethodBeat.i(250906);
    int i = paramLinearLayoutManager.ks();
    int j = paramLinearLayoutManager.ku();
    if (i == 0)
    {
      if (j < 2) {
        break label501;
      }
      j -= 1;
    }
    label69:
    label81:
    label501:
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
          break label378;
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
          break label378;
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
          Object localObject3 = ((com.tencent.mm.vending.j.d)localObject2).hdM();
          p.g(localObject3, "liveIdTuple3.`$1`()");
          long l2 = ((Number)localObject3).longValue();
          localObject2 = ((com.tencent.mm.vending.j.d)localObject2).hdN();
          p.g(localObject2, "liveIdTuple3.`$2`()");
          k = ((Number)localObject2).intValue();
          localObject2 = h.vjR;
          paramWxRecyclerAdapter = new h((bo)localObject1, paramWxRecyclerAdapter, i, paramLinearLayoutManager, l1, l2, paramp, paramString, k, h.a.b((bo)localObject1), h.b.vjS, true, false, 12288, (byte)0);
          ((Map)this.vjv).put(paramLinearLayoutManager, paramWxRecyclerAdapter);
          ((Map)this.vjt).put(paramLinearLayoutManager, paramWxRecyclerAdapter);
          localObject1 = this.vjw;
          if (localObject1 != null) {
            ((r)localObject1).a(paramWxRecyclerAdapter, false);
          }
        }
        localArrayList.add(paramLinearLayoutManager);
      }
      label378:
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
      AppMethodBeat.o(250906);
      return;
    }
  }
  
  final void a(WxRecyclerAdapter<bo> paramWxRecyclerAdapter, StaggeredGridLayoutManager paramStaggeredGridLayoutManager, s.p paramp, String paramString)
  {
    AppMethodBeat.i(250907);
    Object localObject1 = new int[paramStaggeredGridLayoutManager.ki()];
    paramStaggeredGridLayoutManager.n((int[])localObject1);
    Object localObject2 = new int[paramStaggeredGridLayoutManager.ki()];
    paramStaggeredGridLayoutManager.o((int[])localObject2);
    int k = paramWxRecyclerAdapter.RqM.size();
    int j = Math.min(localObject1[0], localObject1[1]);
    int m = Math.max(localObject2[0], localObject2[1]);
    paramStaggeredGridLayoutManager = new ArrayList();
    localObject1 = (List)paramWxRecyclerAdapter.data;
    int i;
    if (!((Collection)localObject1).isEmpty())
    {
      i = 1;
      if ((i == 0) || (j > m)) {
        break label241;
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
        break label241;
      }
      i += 1;
      break label120;
      i = 0;
      break;
    }
    label181:
    localObject2 = (bo)((List)localObject1).get(j);
    if ((localObject2 instanceof BaseFinderFeed)) {}
    for (paramWxRecyclerAdapter = ((BaseFinderFeed)localObject2).feedObject.getUserName();; paramWxRecyclerAdapter = "")
    {
      paramStaggeredGridLayoutManager.add(a((bo)localObject2, paramWxRecyclerAdapter, i, paramp, paramString));
      break;
    }
    label241:
    ai(paramStaggeredGridLayoutManager);
    paramStaggeredGridLayoutManager.clear();
    AppMethodBeat.o(250907);
  }
  
  final void b(WxRecyclerAdapter<?> paramWxRecyclerAdapter, StaggeredGridLayoutManager paramStaggeredGridLayoutManager, s.p paramp, String paramString)
  {
    AppMethodBeat.i(250909);
    Object localObject1 = new int[paramStaggeredGridLayoutManager.ki()];
    paramStaggeredGridLayoutManager.n((int[])localObject1);
    Object localObject2 = new int[paramStaggeredGridLayoutManager.ki()];
    paramStaggeredGridLayoutManager.o((int[])localObject2);
    int k = paramWxRecyclerAdapter.RqM.size();
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
              paramWxRecyclerAdapter = a((x)localObject2, paramp, paramString, i);
              localArrayList1.addAll((Collection)paramWxRecyclerAdapter.hdM());
              localArrayList2.addAll((Collection)paramWxRecyclerAdapter.hdN());
            }
          }
          if (i == m) {
            break label351;
          }
          i += 1;
        }
        i = 0;
        continue;
        if ((localObject2 instanceof BaseFinderFeed))
        {
          str = ((BaseFinderFeed)localObject2).feedObject.getUserName();
          if (!p.j(paramString, s.j.vnV.scene)) {
            break label417;
          }
          paramWxRecyclerAdapter = s.p.voA;
          localObject1 = "15";
        }
      }
    }
    for (;;)
    {
      localArrayList1.add(a((bo)localObject2, str, i, paramWxRecyclerAdapter, (String)localObject1));
      break;
      if (!(localObject2 instanceof bo)) {}
      for (paramWxRecyclerAdapter = null;; paramWxRecyclerAdapter = (WxRecyclerAdapter<?>)localObject2)
      {
        if ((bo)paramWxRecyclerAdapter == null) {
          break label415;
        }
        localArrayList1.add(a((bo)localObject2, "", i, paramp, paramString));
        break;
        label351:
        paramWxRecyclerAdapter = localArrayList2.iterator();
        while (paramWxRecyclerAdapter.hasNext())
        {
          paramStaggeredGridLayoutManager = (String)paramWxRecyclerAdapter.next();
          this.vjt.remove(paramStaggeredGridLayoutManager);
        }
        ai(localArrayList1);
        localArrayList1.clear();
        localArrayList2.clear();
        AppMethodBeat.o(250909);
        return;
      }
      label415:
      break;
      label417:
      localObject1 = paramString;
      paramWxRecyclerAdapter = paramp;
    }
  }
  
  final void dpa()
  {
    AppMethodBeat.i(250912);
    Iterator localIterator = this.vjt.entrySet().iterator();
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
        ((r)localObject1).a((h)localObject2);
      }
    }
    AppMethodBeat.o(250912);
  }
  
  final void dpb()
  {
    AppMethodBeat.i(250913);
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
    AppMethodBeat.o(250913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.live.d
 * JD-Core Version:    0.7.0.1
 */