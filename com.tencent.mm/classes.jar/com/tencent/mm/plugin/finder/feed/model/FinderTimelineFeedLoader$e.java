package com.tencent.mm.plugin.finder.feed.model;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.p.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.q;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isDebug", "", "cleanDataList", "", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "finallyHandleMergeList", "srcList", "Ljava/util/ArrayList;", "newList", "Ljava/util/LinkedList;", "insertIndex", "", "cmd", "request", "", "findMergeIndex", "", "mergeDataAndNotify", "Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeResult;", "insList", "isNeedClear", "mergeInsert", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "mergeLoadMore", "mergeRefresh", "needCleanWhenRefresh", "plugin-finder_release"})
public final class FinderTimelineFeedLoader$e
  extends BaseFeedLoader<am>.a
{
  private final boolean cFS;
  
  FinderTimelineFeedLoader$e()
  {
    super(localBaseFeedLoader);
    AppMethodBeat.i(202944);
    if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.a.b.fnF())) {}
    for (boolean bool = true;; bool = false)
    {
      this.cFS = bool;
      AppMethodBeat.o(202944);
      return;
    }
  }
  
  public final void cleanDataList(DataBuffer<am> paramDataBuffer)
  {
    AppMethodBeat.i(202938);
    d.g.b.p.h(paramDataBuffer, "dataList");
    super.cleanDataList(paramDataBuffer);
    Object localObject = com.tencent.mm.ui.component.a.KEX;
    localObject = (FinderTabStreamUnreadVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTabStreamUnreadVM.class);
    int i = this.skL.skH.dvm;
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
    paramDataBuffer = com.tencent.mm.plugin.finder.utils.p.a((List)paramDataBuffer, BaseFinderFeed.class);
    d.g.b.p.h(paramDataBuffer, "deprecatedList");
    com.tencent.mm.ac.c.b(null, (d.g.a.a)new FinderTabStreamUnreadVM.c((FinderTabStreamUnreadVM)localObject, i, paramDataBuffer));
    AppMethodBeat.o(202938);
  }
  
  public final boolean finallyHandleMergeList(ArrayList<am> paramArrayList, LinkedList<am> paramLinkedList, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(202942);
    d.g.b.p.h(paramArrayList, "srcList");
    d.g.b.p.h(paramLinkedList, "newList");
    long l;
    Object localObject1;
    Object localObject2;
    if ((paramInt2 == 8) && ((paramObject instanceof FinderTimelineFeedLoader.b)))
    {
      if ((paramInt1 <= 0) && (!((FinderTimelineFeedLoader.b)paramObject).skQ))
      {
        paramArrayList = com.tencent.mm.plugin.finder.storage.data.g.sKQ;
        paramArrayList = ((FinderTimelineFeedLoader.b)paramObject).rZB;
        if (paramArrayList != null)
        {
          paramArrayList = paramArrayList.feedObject;
          if (paramArrayList == null) {}
        }
        for (l = paramArrayList.getId();; l = 0L)
        {
          com.tencent.mm.plugin.finder.storage.data.g.xs(l);
          paramArrayList = com.tencent.mm.plugin.finder.utils.p.sXz;
          paramInt1 = this.skL.skH.dvm;
          paramArrayList = com.tencent.mm.plugin.finder.utils.p.sXz;
          com.tencent.mm.plugin.finder.utils.p.a(paramInt1, com.tencent.mm.plugin.finder.utils.p.a((List)paramLinkedList, BaseFinderFeed.class), this.skL.getContextObj());
          paramLinkedList.clear();
          AppMethodBeat.o(202942);
          return false;
        }
      }
      localObject1 = this.skL.gpr;
      if (localObject1 != null)
      {
        localObject1 = ((RecyclerView)localObject1).getAdapter();
        localObject2 = localObject1;
        if (!(localObject1 instanceof WxRecyclerAdapter)) {
          localObject2 = null;
        }
        localObject1 = (WxRecyclerAdapter)localObject2;
        if (localObject1 != null)
        {
          localObject1 = ((WxRecyclerAdapter)localObject1).LSF;
          if (localObject1 != null) {
            break label968;
          }
        }
        localObject1 = new LongSparseArray();
      }
    }
    label263:
    label284:
    label548:
    label937:
    label939:
    label962:
    label965:
    label968:
    for (;;)
    {
      LinkedList localLinkedList = new LinkedList((Collection)paramArrayList.subList(0, Math.min(paramInt1, paramArrayList.size())));
      Object localObject3;
      Object localObject4;
      if (paramInt1 < paramArrayList.size())
      {
        localObject2 = new LinkedList((Collection)paramArrayList.subList(paramInt1, paramArrayList.size()));
        paramInt1 = -1;
        localObject3 = (Iterable)localLinkedList;
        paramInt2 = 0;
        localObject3 = ((Iterable)localObject3).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label359;
        }
        localObject4 = ((Iterator)localObject3).next();
        if (paramInt2 < 0) {
          d.a.j.gkd();
        }
        if (((LongSparseArray)localObject1).indexOfKey(((am)localObject4).lP()) < 0) {
          break label965;
        }
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        paramInt2 += 1;
        break label284;
        localObject1 = null;
        break;
        localObject2 = new LinkedList();
        break label263;
        label359:
        if (paramInt1 >= 0) {}
        int j;
        Object localObject5;
        for (int i = localLinkedList.size() - paramInt1 - 1;; i = 0)
        {
          j = ((FinderTimelineFeedLoader.b)paramObject).skP - i;
          localObject3 = new LinkedList();
          localObject4 = new LinkedList();
          ((LinkedList)localObject4).addAll((Collection)paramLinkedList);
          ((LinkedList)localObject4).addAll((Collection)localObject2);
          ((LinkedList)localObject3).addAll((Collection)localObject4);
          localObject2 = ((LinkedList)localObject3).iterator();
          d.g.b.p.g(localObject2, "increment.iterator()");
          paramInt2 = 0;
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label548;
            }
            localObject5 = ((Iterator)localObject2).next();
            d.g.b.p.g(localObject5, "iterator.next()");
            localObject5 = (am)localObject5;
            if ((!(localObject5 instanceof BaseFinderFeed)) || (((LongSparseArray)localObject1).indexOfKey(((BaseFinderFeed)localObject5).feedObject.getId()) >= 0)) {
              break label962;
            }
            if (paramInt2 < j) {
              break;
            }
            ((Iterator)localObject2).remove();
          }
        }
        paramInt2 += 1;
        for (;;)
        {
          break;
          localObject2 = ((LinkedList)localObject4).subList(((LinkedList)localObject3).size(), ((LinkedList)localObject4).size());
          d.g.b.p.g(localObject2, "after.subList(increment.size, after.size)");
          localObject5 = this.skL.getTAG();
          StringBuilder localStringBuilder = new StringBuilder("[finallyHandleMergeList] feed=");
          Object localObject6 = ((FinderTimelineFeedLoader.b)paramObject).rZB;
          if (localObject6 != null)
          {
            localObject6 = ((BaseFinderFeed)localObject6).feedObject;
            if (localObject6 != null)
            {
              l = ((FinderItem)localObject6).getId();
              ae.i((String)localObject5, com.tencent.mm.ac.c.rp(l) + ' ' + "rawBefore=" + localLinkedList.size() + " raw=" + paramArrayList.size() + " readIndex=" + paramInt1 + " unreadCount=" + i + " maxUnreadCount=" + ((FinderTimelineFeedLoader.b)paramObject).skP + " limitUnreadCount=" + j + ' ' + "afterSize=" + ((LinkedList)localObject4).size() + " incrementCount=" + ((LinkedList)localObject3).size() + " remain=" + ((List)localObject2).size() + ' ' + "hasVisibleFeeds=" + FinderTimelineFeedLoader.a((LongSparseArray)localObject1));
              paramArrayList.clear();
              paramArrayList.addAll((Collection)localLinkedList);
              paramLinkedList.clear();
              paramLinkedList.addAll((Collection)localObject3);
              paramArrayList = com.tencent.mm.plugin.finder.utils.p.sXz;
              paramInt2 = this.skL.skH.dvm;
              paramLinkedList = (Iterable)localObject2;
              paramArrayList = (Collection)new ArrayList();
              paramLinkedList = paramLinkedList.iterator();
            }
          }
          for (;;)
          {
            label863:
            if (!paramLinkedList.hasNext()) {
              break label939;
            }
            paramObject = paramLinkedList.next();
            localObject2 = (am)paramObject;
            if (((localObject2 instanceof BaseFinderFeed)) && (((LongSparseArray)localObject1).indexOfKey(((am)localObject2).lP()) < 0)) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if (paramInt1 == 0) {
                break label937;
              }
              paramArrayList.add(paramObject);
              break label863;
              l = 0L;
              break;
            }
          }
          com.tencent.mm.plugin.finder.utils.p.a(paramInt2, (List)paramArrayList, this.skL.getContextObj());
          AppMethodBeat.o(202942);
          return true;
        }
      }
    }
  }
  
  public final int findMergeIndex(ArrayList<am> paramArrayList, List<? extends am> paramList, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(202941);
    d.g.b.p.h(paramArrayList, "srcList");
    d.g.b.p.h(paramList, "newList");
    Object localObject1;
    long l;
    int i;
    label128:
    label136:
    label166:
    label200:
    label237:
    Object localObject2;
    label265:
    label312:
    int j;
    if ((paramInt == 8) && ((paramObject instanceof FinderTimelineFeedLoader.b)))
    {
      paramList = (List)paramArrayList;
      paramInt = 0;
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        localObject1 = (am)paramList.next();
        if ((localObject1 instanceof BaseFinderFeed))
        {
          l = ((BaseFinderFeed)localObject1).feedObject.getId();
          localObject1 = ((FinderTimelineFeedLoader.b)paramObject).rZB;
          if (localObject1 != null)
          {
            localObject1 = ((BaseFinderFeed)localObject1).feedObject;
            if ((localObject1 != null) && (l == ((FinderItem)localObject1).getId()))
            {
              i = 1;
              if (i == 0) {
                break label523;
              }
              i = paramInt;
              paramList = ((FinderTimelineFeedLoader.b)paramObject).rZP;
              if (paramList == null) {
                break label536;
              }
              paramList = paramList.feedObject;
              if (paramList == null) {
                break label536;
              }
              paramList = Long.valueOf(paramList.getId());
              localObject1 = this.skL.gpr;
              if (localObject1 == null) {
                break label541;
              }
              paramList = com.tencent.mm.plugin.finder.utils.p.sXz;
              paramList = Long.valueOf(com.tencent.mm.plugin.finder.utils.p.b((RecyclerView)localObject1, 0, 0, 14).duw);
              localObject1 = ((FinderTimelineFeedLoader.b)paramObject).rZB;
              if (localObject1 == null) {
                break label544;
              }
              localObject1 = ((BaseFinderFeed)localObject1).feedObject;
              if (localObject1 == null) {
                break label544;
              }
              localObject1 = Long.valueOf(((FinderItem)localObject1).getId());
              if (!(d.g.b.p.i(paramList, localObject1) ^ true)) {
                break label1106;
              }
              localObject1 = (List)paramArrayList;
              paramInt = 0;
              localObject1 = ((List)localObject1).iterator();
              if (!((Iterator)localObject1).hasNext()) {
                break label573;
              }
              localObject2 = (am)((Iterator)localObject1).next();
              if ((localObject2 instanceof BaseFinderFeed))
              {
                l = ((BaseFinderFeed)localObject2).feedObject.getId();
                if (paramList != null) {
                  break label550;
                }
              }
              j = 0;
              label315:
              if (j == 0) {
                break label566;
              }
              label320:
              ae.i(this.skL.getTAG(), "[findMergeIndex] centerFeedId=" + i + " newCenterIndex=" + paramInt);
            }
          }
        }
      }
    }
    label523:
    label536:
    label541:
    label544:
    label550:
    label566:
    label573:
    label719:
    label1106:
    for (int m = paramInt;; m = i)
    {
      if (i != m) {
        com.tencent.mm.plugin.report.service.g.yxI.f(20198, new Object[] { Integer.valueOf(1) });
      }
      int i1;
      int k;
      int n;
      for (;;)
      {
        i1 = Math.max(m, i);
        paramInt = Math.max(0, Math.min(paramArrayList.size(), i1));
        paramList = ((Iterable)paramArrayList).iterator();
        k = 0;
        for (j = 0;; j = 2)
        {
          n = j;
          if (!paramList.hasNext()) {
            break label642;
          }
          localObject1 = paramList.next();
          n = k + 1;
          if (k < 0) {
            d.a.j.gkd();
          }
          localObject1 = (am)localObject1;
          if ((!(localObject1 instanceof BaseFinderFeed)) || (k < i1) || (!((BaseFinderFeed)localObject1).feedObject.isRelatedItem())) {
            break;
          }
          paramInt += 1;
          if (j != 0) {
            break label1103;
          }
          k = n;
        }
        i = 0;
        break label128;
        paramInt += 1;
        break;
        i = -1;
        break label136;
        paramList = null;
        break label166;
        break label200;
        localObject1 = null;
        break label237;
        if (l != paramList.longValue()) {
          break label312;
        }
        j = 1;
        break label315;
        paramInt += 1;
        break label265;
        paramInt = -1;
        break label320;
        com.tencent.mm.plugin.report.service.g.yxI.f(20198, new Object[] { Integer.valueOf(2) });
      }
      label729:
      label762:
      boolean bool;
      if (((localObject1 instanceof BaseFinderFeed)) && (k >= i1) && (!((BaseFinderFeed)localObject1).feedObject.isRelatedItem()))
      {
        n = j;
        if (j == 0) {
          n = 1;
        }
        if (n != 2) {
          break label1039;
        }
        j = 0;
        k = paramInt + j;
        paramInt = -2;
        localObject2 = this.skL.gpr;
        if (localObject2 != null)
        {
          paramList = this.skL.gpr;
          if (paramList == null) {
            break label1045;
          }
          paramList = paramList.getLayoutManager();
          localObject1 = paramList;
          if (!(paramList instanceof LinearLayoutManager)) {
            localObject1 = null;
          }
          paramList = (LinearLayoutManager)localObject1;
          if (paramList == null) {
            break label1050;
          }
          paramInt = paramList.km();
          if (paramList == null) {
            break label1055;
          }
          j = paramList.ko();
          paramList = com.tencent.mm.plugin.finder.utils.p.sXz;
          localObject2 = com.tencent.mm.plugin.finder.utils.p.b((RecyclerView)localObject2, paramInt, j, 8);
          paramList = this.skL.gpr;
          if (paramList == null) {
            break label1061;
          }
          paramList = paramList.getAdapter();
          localObject1 = paramList;
          if (!(paramList instanceof WxRecyclerAdapter)) {
            localObject1 = null;
          }
          paramList = (WxRecyclerAdapter)localObject1;
          if (paramList == null) {
            break label1066;
          }
          paramInt = paramList.LRV.size();
          paramInt = ((p.a)localObject2).sXB - paramInt;
          paramList = (FinderTimelineFeedLoader.b)paramObject;
          if (k <= paramInt) {
            break label1071;
          }
          bool = true;
          paramList.skQ = bool;
          if (!((FinderTimelineFeedLoader.b)paramObject).skQ) {
            ae.w(this.skL.getTAG(), "[finallyHandleMergeList] insertIndex is invalid. resultIndex=" + k + " focusedPosition=" + paramInt);
          }
        }
        ae.i(this.skL.getTAG(), "[findMergeIndex] tabType=" + this.skL.skH.dvm + " requestIndex=" + i + " centerIndex=" + m + " fixIndex=" + i1 + " resultIndex=" + k + ' ' + "focusedPosition=" + paramInt + " isConsume=" + ((FinderTimelineFeedLoader.b)paramObject).skQ + " size=" + paramArrayList.size() + " source=" + n + ' ');
        if (!((FinderTimelineFeedLoader.b)paramObject).skQ) {
          break label1077;
        }
        AppMethodBeat.o(202941);
        return k;
      }
      for (;;)
      {
        k = n;
        break;
        j = 1;
        break label651;
        paramList = null;
        break label691;
        paramInt = -1;
        break label719;
        j = -1;
        break label729;
        paramList = null;
        break label762;
        paramInt = 0;
        break label793;
        bool = false;
        break label816;
        AppMethodBeat.o(202941);
        return 0;
        paramInt = super.findMergeIndex(paramArrayList, paramList, paramInt, paramObject);
        AppMethodBeat.o(202941);
        return paramInt;
      }
    }
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.j mergeDataAndNotify(int paramInt, List<? extends am> paramList, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(202940);
    label102:
    Object localObject2;
    label153:
    label204:
    label210:
    label216:
    label222:
    Iterator localIterator;
    if (((paramObject instanceof FinderTimelineFeedLoader.b)) && (this.skL.gpr != null))
    {
      localObject1 = ((FinderTimelineFeedLoader.b)paramObject).rZB;
      if (localObject1 != null)
      {
        localObject1 = ((BaseFinderFeed)localObject1).feedObject;
        if ((localObject1 != null) && (!((FinderItem)localObject1).isRelatedItem()))
        {
          localObject1 = ((FinderTimelineFeedLoader.b)paramObject).rZB;
          long l;
          int i;
          if (localObject1 != null)
          {
            l = ((BaseFinderFeed)localObject1).lP();
            localObject1 = this.skL.gpr;
            if (localObject1 == null) {
              break label204;
            }
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            localObject2 = localObject1;
            if (!(localObject1 instanceof WxRecyclerAdapter)) {
              localObject2 = null;
            }
            localObject1 = (WxRecyclerAdapter)localObject2;
            if (localObject1 == null) {
              break label210;
            }
            localObject1 = (e)d.c((d)localObject1, l);
            if (localObject1 == null) {
              break label210;
            }
            i = ((e)localObject1).lN();
            localObject1 = this.skL.gpr;
            if (localObject1 == null) {
              break label216;
            }
          }
          for (localObject1 = ((RecyclerView)localObject1).getLayoutManager();; localObject1 = null)
          {
            if (localObject1 != null) {
              break label222;
            }
            paramList = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
            AppMethodBeat.o(202940);
            throw paramList;
            l = 0L;
            break;
            localObject1 = null;
            break label102;
            i = -1;
            break label153;
          }
          localObject1 = (LinearLayoutManager)localObject1;
          int j = ((LinearLayoutManager)localObject1).km();
          int k = ((LinearLayoutManager)localObject1).ko();
          boolean bool;
          if ((i >= 0) && (j <= i) && (i <= k))
          {
            bool = true;
            ae.i(this.skL.getTAG(), "[mergeDataAndNotify] tabType=" + this.skL.skH.dvm + " position=" + i + " first=" + j + " last=" + k + " isConsume=" + bool);
            if (!bool) {
              break label525;
            }
            paramObject = super.mergeDataAndNotify(paramInt, paramList, paramBoolean, paramObject);
            if (!this.cFS) {
              break label516;
            }
            localObject1 = this.skL.getTAG() + "#insert";
            paramList = (Iterable)this.skL.getDataList();
            localObject2 = (Collection)new ArrayList(d.a.j.a(paramList, 10));
            localIterator = paramList.iterator();
            label433:
            if (!localIterator.hasNext()) {
              break label503;
            }
            paramList = (am)localIterator.next();
            if (!(paramList instanceof BaseFinderFeed)) {
              break label496;
            }
          }
          label496:
          for (paramList = com.tencent.mm.ac.c.rp(((BaseFinderFeed)paramList).feedObject.getFeedObject().id);; paramList = "")
          {
            ((Collection)localObject2).add(paramList);
            break label433;
            bool = false;
            break;
          }
          label503:
          ae.i((String)localObject1, String.valueOf((List)localObject2));
          label516:
          AppMethodBeat.o(202940);
          return paramObject;
          label525:
          if (paramList != null)
          {
            paramObject = com.tencent.mm.plugin.finder.storage.data.g.sKQ;
            com.tencent.mm.plugin.finder.storage.data.g.xs(l);
            paramObject = com.tencent.mm.plugin.finder.utils.p.sXz;
            paramInt = this.skL.skH.dvm;
            paramObject = com.tencent.mm.plugin.finder.utils.p.sXz;
            com.tencent.mm.plugin.finder.utils.p.a(paramInt, com.tencent.mm.plugin.finder.utils.p.a(paramList, BaseFinderFeed.class), this.skL.getContextObj());
          }
          paramList = new com.tencent.mm.plugin.finder.feed.model.internal.j(new LinkedList());
          AppMethodBeat.o(202940);
          return paramList;
        }
      }
    }
    Object localObject1 = super.mergeDataAndNotify(paramInt, paramList, paramBoolean, paramObject);
    if (this.cFS)
    {
      if (!(paramObject instanceof FinderTimelineFeedLoader.b)) {
        break label777;
      }
      paramObject = this.skL.getTAG() + "#insert";
      paramList = (Iterable)this.skL.getDataList();
      localObject2 = (Collection)new ArrayList(d.a.j.a(paramList, 10));
      localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        paramList = (am)localIterator.next();
        if ((paramList instanceof BaseFinderFeed)) {}
        for (paramList = com.tencent.mm.ac.c.rp(((BaseFinderFeed)paramList).feedObject.getFeedObject().id);; paramList = "")
        {
          ((Collection)localObject2).add(paramList);
          break;
        }
      }
      ae.i(paramObject, String.valueOf((List)localObject2));
    }
    for (;;)
    {
      AppMethodBeat.o(202940);
      return localObject1;
      label777:
      if ((this.skL.skH.dvm == 4) && (paramInt == 1))
      {
        paramObject = this.skL.getTAG() + "#loadMore";
        paramList = (Iterable)this.skL.getDataList();
        localObject2 = (Collection)new ArrayList(d.a.j.a(paramList, 10));
        localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          paramList = (am)localIterator.next();
          if ((paramList instanceof BaseFinderFeed)) {}
          for (paramList = com.tencent.mm.ac.c.rp(((BaseFinderFeed)paramList).feedObject.getFeedObject().id);; paramList = "")
          {
            ((Collection)localObject2).add(paramList);
            break;
          }
        }
        ae.i(paramObject, String.valueOf((List)localObject2));
      }
      else if ((this.skL.skH.dvm == 4) && (paramInt == 4))
      {
        paramObject = this.skL.getTAG() + "#refresh";
        paramList = (Iterable)this.skL.getDataList();
        localObject2 = (Collection)new ArrayList(d.a.j.a(paramList, 10));
        localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          paramList = (am)localIterator.next();
          if ((paramList instanceof BaseFinderFeed)) {}
          for (paramList = com.tencent.mm.ac.c.rp(((BaseFinderFeed)paramList).feedObject.getFeedObject().id);; paramList = "")
          {
            ((Collection)localObject2).add(paramList);
            break;
          }
        }
        ae.i(paramObject, String.valueOf((List)localObject2));
      }
    }
  }
  
  public final void mergeInsert(IResponse<am> paramIResponse, d.g.a.b<? super IResponse<am>, z> paramb)
  {
    AppMethodBeat.i(202939);
    d.g.b.p.h(paramIResponse, "response");
    Object localObject = paramIResponse.getRequest();
    if ((localObject instanceof FinderTimelineFeedLoader.b))
    {
      if (!((FinderTimelineFeedLoader.b)localObject).skR) {
        super.mergeInsert(paramIResponse, paramb);
      }
      ae.i(this.skL.getTAG(), "[onFetchInsertedDone] isPrefetch=" + ((FinderTimelineFeedLoader.b)localObject).skR);
    }
    AppMethodBeat.o(202939);
  }
  
  public final void mergeLoadMore(final IResponse<am> paramIResponse, final d.g.a.b<? super IResponse<am>, z> paramb)
  {
    int i = 1;
    AppMethodBeat.i(202937);
    d.g.b.p.h(paramIResponse, "response");
    if ((paramIResponse instanceof FinderTimelineFeedLoader.d)) {
      this.skL.getDataListJustForAdapter().setBuffer((Collection)((FinderTimelineFeedLoader.d)paramIResponse).sjO);
    }
    final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
    localc.LNT = paramIResponse.getHasMore();
    Context localContext = ak.getContext();
    d.g.b.p.g(localContext, "MMApplicationContext.getContext()");
    localc.LNS = ((CharSequence)localContext.getResources().getString(2131759370));
    localc.LNR = 2;
    boolean bool;
    if (!paramIResponse.getHasMore())
    {
      bool = true;
      localc.iOP = bool;
      ae.i(this.skL.getTAG(), "[onFetchLoadMoreDone]  reason=".concat(String.valueOf(localc)));
      if (!paramIResponse.getHasMore()) {
        break label194;
      }
    }
    for (;;)
    {
      com.tencent.mm.ac.c.h((d.g.a.a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.l(i, paramIResponse.getIncrementList(), false, 12), localc, paramb, paramIResponse));
      AppMethodBeat.o(202937);
      return;
      bool = false;
      break;
      label194:
      i = 5;
    }
  }
  
  public final void mergeRefresh(final IResponse<am> paramIResponse, final d.g.a.b<? super IResponse<am>, z> paramb)
  {
    AppMethodBeat.i(202936);
    d.g.b.p.h(paramIResponse, "response");
    final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
    Object localObject;
    boolean bool;
    if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
    {
      localc.LNR = 1;
      localObject = this.skL.skJ;
      if (localObject != null) {
        ((d.g.a.b)localObject).invoke(paramIResponse);
      }
      if (paramIResponse.getPullType() == 0) {
        break label262;
      }
      bool = true;
      label79:
      localc.iOP = bool;
      localc.LNT = paramIResponse.getHasMore();
      if ((localc.actionType == 0) || (localc.actionType == 4) || (localc.actionType == 1))
      {
        if ((localc.LNU <= 0) && (this.skL.getDataListJustForAdapter().size() > 0)) {
          break label268;
        }
        localc.LNS = null;
      }
      label148:
      ae.i(this.skL.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
      if (!paramIResponse.getHasMore()) {
        break label303;
      }
    }
    label262:
    label268:
    label303:
    for (int i = 4;; i = 6)
    {
      com.tencent.mm.ac.c.h((d.g.a.a)new b(this, new com.tencent.mm.plugin.finder.feed.model.internal.l(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), localc, paramb, paramIResponse));
      AppMethodBeat.o(202936);
      return;
      localObject = ak.getContext();
      d.g.b.p.g(localObject, "MMApplicationContext.getContext()");
      localc.LNS = ((CharSequence)((Context)localObject).getResources().getString(2131766505));
      localc.LNR = -1;
      break;
      bool = false;
      break label79;
      localObject = ak.getContext();
      d.g.b.p.g(localObject, "MMApplicationContext.getContext()");
      localc.LNS = ((CharSequence)((Context)localObject).getResources().getString(2131766856));
      break label148;
    }
  }
  
  public final boolean needCleanWhenRefresh(List<? extends am> paramList)
  {
    AppMethodBeat.i(202943);
    d.g.b.p.h(paramList, "newList");
    AppMethodBeat.o(202943);
    return true;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    a(FinderTimelineFeedLoader.e parame, com.tencent.mm.plugin.finder.feed.model.internal.l paraml, RefreshLoadMoreLayout.c paramc, d.g.a.b paramb, IResponse paramIResponse)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(FinderTimelineFeedLoader.e parame, com.tencent.mm.plugin.finder.feed.model.internal.l paraml, RefreshLoadMoreLayout.c paramc, d.g.a.b paramb, IResponse paramIResponse)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader.e
 * JD-Core Version:    0.7.0.1
 */