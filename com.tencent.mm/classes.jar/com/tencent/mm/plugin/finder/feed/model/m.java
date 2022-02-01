package com.tencent.mm.plugin.finder.feed.model;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.LongSparseArray;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.b.a;
import com.tencent.mm.plugin.finder.feed.model.internal.b.c;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.g;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.utils.n.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d;
import d.a.j;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "firstLoad", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "extraDataOp", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "", "getExtraDataOp", "()Lkotlin/jvm/functions/Function1;", "setExtraDataOp", "(Lkotlin/jvm/functions/Function1;)V", "getFirstLoad", "()I", "setFirstLoad", "(I)V", "isDebug", "", "value", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getScene", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "getStreamFetcher", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "bufferSize", "cleanDataList", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "finallyHandleMergeList", "srcList", "Ljava/util/ArrayList;", "newList", "Ljava/util/LinkedList;", "insertIndex", "cmd", "request", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "findMergeIndex", "", "isObservePostEvent", "mergeDataAndNotify", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher$MergeResult;", "insList", "isNeedClear", "needCleanWhenRefresh", "onDead", "onFetchInsertedDone", "response", "onFetchLoadMoreDone", "onFetchRefreshDone", "preloadMoreToBuffer", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "printVisibleFeeds", "hasVisibleFeeds", "Landroid/util/LongSparseArray;", "requestInsert", "requestLoadMore", "requestRefresh", "plugin-finder_release"})
public final class m
  extends BaseFinderFeedLoader
{
  private String TAG;
  private final boolean cuo;
  public RecyclerView fTr;
  private final com.tencent.mm.plugin.finder.feed.model.internal.c rne;
  public final com.tencent.mm.plugin.finder.cgi.fetcher.b rnh;
  public d.g.a.b<? super IResponse<BaseFinderFeed>, d.y> rni;
  private int rnj;
  
  public m(com.tencent.mm.plugin.finder.feed.model.internal.c paramc, int paramInt, anm paramanm)
  {
    super(null, paramanm, 1, null);
    AppMethodBeat.i(202219);
    this.rne = paramc;
    this.rnj = paramInt;
    this.TAG = "Finder.TimelineFeedLoader";
    this.rnh = new com.tencent.mm.plugin.finder.cgi.fetcher.b(this.rne.value, paramanm);
    boolean bool1 = bool2;
    if (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)
    {
      bool1 = bool2;
      if (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) {
        if (!com.tencent.mm.sdk.a.b.eUk()) {
          break label99;
        }
      }
    }
    label99:
    for (bool1 = bool2;; bool1 = false)
    {
      this.cuo = bool1;
      AppMethodBeat.o(202219);
      return;
    }
  }
  
  private static String a(LongSparseArray<?> paramLongSparseArray)
  {
    AppMethodBeat.i(202216);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = paramLongSparseArray.size();
    while (i < j)
    {
      localStringBuilder.append(com.tencent.mm.ac.c.pb(paramLongSparseArray.keyAt(i)) + ',');
      i += 1;
    }
    paramLongSparseArray = localStringBuilder.toString();
    d.g.b.k.g(paramLongSparseArray, "ss.toString()");
    AppMethodBeat.o(202216);
    return paramLongSparseArray;
  }
  
  public final void cleanDataList(DataBuffer<BaseFinderFeed> paramDataBuffer)
  {
    AppMethodBeat.i(202212);
    d.g.b.k.h(paramDataBuffer, "dataList");
    super.cleanDataList(paramDataBuffer);
    Object localObject = com.tencent.mm.ui.component.a.IrY;
    localObject = (FinderTabStreamUnreadVM)com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderTabStreamUnreadVM.class);
    int i = this.rnh.diw;
    paramDataBuffer = j.l((Iterable)paramDataBuffer);
    d.g.b.k.h(paramDataBuffer, "deprecatedList");
    com.tencent.mm.ac.c.b(null, (d.g.a.a)new FinderTabStreamUnreadVM.c((FinderTabStreamUnreadVM)localObject, i, paramDataBuffer));
    AppMethodBeat.o(202212);
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.e<Object, Object, com.tencent.mm.plugin.finder.feed.model.internal.h> createDataFetch(anm paramanm)
  {
    AppMethodBeat.i(202209);
    paramanm = (com.tencent.mm.plugin.finder.feed.model.internal.e)new w(this.rnh, this.rne, paramanm);
    AppMethodBeat.o(202209);
    return paramanm;
  }
  
  public final boolean finallyHandleMergeList(ArrayList<BaseFinderFeed> paramArrayList, LinkedList<BaseFinderFeed> paramLinkedList, int paramInt1, int paramInt2, i parami)
  {
    AppMethodBeat.i(202215);
    d.g.b.k.h(paramArrayList, "srcList");
    d.g.b.k.h(paramLinkedList, "newList");
    Object localObject1;
    Object localObject2;
    if ((paramInt2 == 8) && ((parami instanceof y)))
    {
      localObject1 = this.fTr;
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
          localObject1 = ((WxRecyclerAdapter)localObject1).JCM;
          if (localObject1 != null) {
            break label821;
          }
        }
        localObject1 = new LongSparseArray();
      }
    }
    label155:
    label176:
    label818:
    label821:
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
          break label249;
        }
        localObject4 = ((Iterator)localObject3).next();
        if (paramInt2 < 0) {
          j.fOc();
        }
        if (((LongSparseArray)localObject1).indexOfKey(((BaseFinderFeed)localObject4).lx()) < 0) {
          break label818;
        }
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        paramInt2 += 1;
        break label176;
        localObject1 = null;
        break;
        localObject2 = new LinkedList();
        break label155;
        label249:
        if (paramInt1 >= 0) {}
        int j;
        Object localObject5;
        for (int i = localLinkedList.size() - paramInt1 - 1;; i = 0)
        {
          j = ((y)parami).rnB - i;
          localObject3 = new LinkedList();
          localObject4 = new LinkedList();
          ((LinkedList)localObject4).addAll((Collection)paramLinkedList);
          ((LinkedList)localObject4).addAll((Collection)localObject2);
          ((LinkedList)localObject3).addAll((Collection)localObject4);
          localObject2 = ((LinkedList)localObject3).iterator();
          d.g.b.k.g(localObject2, "increment.iterator()");
          paramInt2 = 0;
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label423;
            }
            localObject5 = ((Iterator)localObject2).next();
            d.g.b.k.g(localObject5, "iterator.next()");
            if (((LongSparseArray)localObject1).indexOfKey(((BaseFinderFeed)localObject5).feedObject.getId()) >= 0) {
              break label815;
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
          d.g.b.k.g(localObject2, "after.subList(increment.size, after.size)");
          localObject5 = getTAG();
          StringBuilder localStringBuilder = new StringBuilder("[finallyHandleMergeList] feed=");
          Object localObject6 = ((y)parami).rdD;
          long l;
          if (localObject6 != null)
          {
            localObject6 = ((BaseFinderFeed)localObject6).feedObject;
            if (localObject6 != null)
            {
              l = ((FinderItem)localObject6).getId();
              ac.i((String)localObject5, com.tencent.mm.ac.c.pb(l) + ' ' + "rawBefore=" + localLinkedList.size() + " raw=" + paramArrayList.size() + " readIndex=" + paramInt1 + " unreadCount=" + i + " maxUnreadCount=" + ((y)parami).rnB + " limitUnreadCount=" + j + ' ' + "afterSize=" + ((LinkedList)localObject4).size() + " incrementCount=" + ((LinkedList)localObject3).size() + " remain=" + ((List)localObject2).size() + ' ' + "hasVisibleFeeds=" + a((LongSparseArray)localObject1));
              paramArrayList.clear();
              paramArrayList.addAll((Collection)localLinkedList);
              paramLinkedList.clear();
              paramLinkedList.addAll((Collection)localObject3);
              paramArrayList = n.rPN;
              paramInt2 = this.rnh.diw;
              paramLinkedList = (Iterable)localObject2;
              paramArrayList = (Collection)new ArrayList();
              paramLinkedList = paramLinkedList.iterator();
            }
          }
          for (;;)
          {
            label732:
            if (!paramLinkedList.hasNext()) {
              break label794;
            }
            parami = paramLinkedList.next();
            if (((LongSparseArray)localObject1).indexOfKey(((BaseFinderFeed)parami).lx()) < 0) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if (paramInt1 == 0) {
                break label792;
              }
              paramArrayList.add(parami);
              break label732;
              l = 0L;
              break;
            }
          }
          n.a(paramInt2, (List)paramArrayList, getContextObj());
          AppMethodBeat.o(202215);
          return true;
        }
      }
    }
  }
  
  public final int findMergeIndex(ArrayList<BaseFinderFeed> paramArrayList, List<? extends BaseFinderFeed> paramList, int paramInt, i parami)
  {
    AppMethodBeat.i(202214);
    d.g.b.k.h(paramArrayList, "srcList");
    d.g.b.k.h(paramList, "newList");
    int i;
    long l;
    label115:
    label119:
    int j;
    if ((paramInt == 8) && ((parami instanceof y)))
    {
      paramList = (List)paramArrayList;
      i = 0;
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        l = ((BaseFinderFeed)paramList.next()).feedObject.getId();
        Object localObject = ((y)parami).rdD;
        if (localObject != null)
        {
          localObject = ((BaseFinderFeed)localObject).feedObject;
          if ((localObject != null) && (l == ((FinderItem)localObject).getId()))
          {
            paramInt = 1;
            if (paramInt == 0) {
              break label478;
            }
            paramList = ((y)parami).rde;
            if (paramList == null) {
              break label493;
            }
            paramList = paramList.feedObject;
            if (paramList == null) {
              break label493;
            }
            paramList = Long.valueOf(paramList.getId());
            label149:
            localObject = this.fTr;
            if (localObject == null) {
              break label498;
            }
            paramList = n.rPN;
            paramList = Long.valueOf(n.b((RecyclerView)localObject, 0, 0, 14).dig);
            label180:
            parami = ((y)parami).rdD;
            if (parami == null) {
              break label501;
            }
            parami = parami.feedObject;
            if (parami == null) {
              break label501;
            }
            parami = Long.valueOf(parami.getId());
            label217:
            if (!(d.g.b.k.g(paramList, parami) ^ true)) {
              break label736;
            }
            parami = (List)paramArrayList;
            paramInt = 0;
            parami = parami.iterator();
            label245:
            if (!parami.hasNext()) {
              break label530;
            }
            l = ((BaseFinderFeed)parami.next()).feedObject.getId();
            if (paramList != null) {
              break label507;
            }
            label277:
            j = 0;
            label280:
            if (j == 0) {
              break label523;
            }
            label285:
            ac.i(getTAG(), "[findMergeIndex] centerFeedId=" + i + " newCenterIndex=" + paramInt);
          }
        }
      }
    }
    label478:
    label736:
    for (int n = paramInt;; n = i)
    {
      if (i != n) {
        com.tencent.mm.plugin.report.service.h.wUl.f(20198, new Object[] { Integer.valueOf(1) });
      }
      int i2;
      int k;
      int i1;
      for (;;)
      {
        i2 = Math.max(n, i);
        paramInt = Math.max(0, Math.min(paramArrayList.size(), i2));
        paramList = (Iterable)paramArrayList;
        k = 0;
        paramList = paramList.iterator();
        for (j = 0;; j = 2)
        {
          m = j;
          if (!paramList.hasNext()) {
            break label594;
          }
          parami = paramList.next();
          i1 = k + 1;
          if (k < 0) {
            j.fOc();
          }
          parami = (BaseFinderFeed)parami;
          if ((k < i2) || (!parami.feedObject.isRelatedItem())) {
            break;
          }
          paramInt += 1;
          m = paramInt;
          if (j != 0) {
            break label702;
          }
          k = i1;
        }
        paramInt = 0;
        break label115;
        i += 1;
        break;
        i = -1;
        break label119;
        label493:
        paramList = null;
        break label149;
        label498:
        break label180;
        label501:
        parami = null;
        break label217;
        label507:
        if (l != paramList.longValue()) {
          break label277;
        }
        j = 1;
        break label280;
        paramInt += 1;
        break label245;
        paramInt = -1;
        break label285;
        com.tencent.mm.plugin.report.service.h.wUl.f(20198, new Object[] { Integer.valueOf(2) });
      }
      int m = paramInt;
      if (k >= i2)
      {
        m = paramInt;
        if (!parami.feedObject.isRelatedItem())
        {
          m = j;
          if (j == 0) {
            m = 1;
          }
          if (m != 2) {
            break label712;
          }
        }
      }
      for (j = 0;; j = 1)
      {
        paramInt = j + paramInt;
        ac.i(getTAG(), "[findMergeIndex] requestIndex=" + i + " centerIndex=" + n + " fixIndex=" + i2 + " resultIndex=" + paramInt + " size=" + paramArrayList.size() + " source=" + m + ' ');
        AppMethodBeat.o(202214);
        return paramInt;
        k = i1;
        paramInt = m;
        break;
      }
      paramInt = super.findMergeIndex(paramArrayList, paramList, paramInt, parami);
      AppMethodBeat.o(202214);
      return paramInt;
    }
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final boolean isObservePostEvent()
  {
    AppMethodBeat.i(202210);
    if (this.rne != com.tencent.mm.plugin.finder.feed.model.internal.c.rob)
    {
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (com.tencent.mm.plugin.finder.storage.b.czT()) {}
    }
    else
    {
      AppMethodBeat.o(202210);
      return true;
    }
    AppMethodBeat.o(202210);
    return false;
  }
  
  public final b.c mergeDataAndNotify(int paramInt, List<? extends BaseFinderFeed> paramList, boolean paramBoolean, i parami)
  {
    AppMethodBeat.i(202213);
    Object localObject1;
    label96:
    Object localObject2;
    if (((parami instanceof y)) && (this.fTr != null))
    {
      localObject1 = ((y)parami).rdD;
      if (localObject1 != null)
      {
        localObject1 = ((BaseFinderFeed)localObject1).feedObject;
        if ((localObject1 != null) && (!((FinderItem)localObject1).isRelatedItem()))
        {
          localObject1 = ((y)parami).rdD;
          long l;
          int i;
          if (localObject1 != null)
          {
            l = ((BaseFinderFeed)localObject1).lx();
            localObject1 = this.fTr;
            if (localObject1 == null) {
              break label195;
            }
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            localObject2 = localObject1;
            if (!(localObject1 instanceof WxRecyclerAdapter)) {
              localObject2 = null;
            }
            localObject1 = (WxRecyclerAdapter)localObject2;
            if (localObject1 == null) {
              break label201;
            }
            localObject1 = (com.tencent.mm.view.recyclerview.e)d.c((d)localObject1, l);
            if (localObject1 == null) {
              break label201;
            }
            i = ((com.tencent.mm.view.recyclerview.e)localObject1).lv();
            label147:
            localObject1 = this.fTr;
            if (localObject1 == null) {
              break label207;
            }
          }
          label195:
          label201:
          label207:
          for (localObject1 = ((RecyclerView)localObject1).getLayoutManager();; localObject1 = null)
          {
            if (localObject1 != null) {
              break label213;
            }
            paramList = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
            AppMethodBeat.o(202213);
            throw paramList;
            l = 0L;
            break;
            localObject1 = null;
            break label96;
            i = -1;
            break label147;
          }
          label213:
          localObject1 = (LinearLayoutManager)localObject1;
          int j = ((LinearLayoutManager)localObject1).jW();
          int k = ((LinearLayoutManager)localObject1).jY();
          if ((i >= 0) && (j <= i) && (i <= k)) {}
          for (boolean bool = true;; bool = false)
          {
            ac.i(getTAG(), "[mergeDataAndNotify] position=" + i + " first=" + j + " last=" + k + " isConsume=" + bool);
            if (!bool) {
              break label468;
            }
            paramList = super.mergeDataAndNotify(paramInt, paramList, paramBoolean, parami);
            if (!this.cuo) {
              break label460;
            }
            parami = getTAG() + "#insert";
            localObject2 = (Iterable)getDataList();
            localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
            localObject2 = ((Iterable)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((Collection)localObject1).add(com.tencent.mm.ac.c.pb(((BaseFinderFeed)((Iterator)localObject2).next()).feedObject.getFeedObject().id));
            }
          }
          ac.i(parami, String.valueOf((List)localObject1));
          label460:
          AppMethodBeat.o(202213);
          return paramList;
          label468:
          if (paramList != null)
          {
            parami = g.rEP;
            g.uZ(l);
            parami = n.rPN;
            n.a(this.rnh.diw, paramList, getContextObj());
          }
          paramList = new b.c(new LinkedList());
          AppMethodBeat.o(202213);
          return paramList;
        }
      }
    }
    paramList = super.mergeDataAndNotify(paramInt, paramList, paramBoolean, parami);
    if (this.cuo)
    {
      if (!(parami instanceof y)) {
        break label676;
      }
      parami = getTAG() + "#insert";
      localObject2 = (Iterable)getDataList();
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(com.tencent.mm.ac.c.pb(((BaseFinderFeed)((Iterator)localObject2).next()).feedObject.getFeedObject().id));
      }
      ac.i(parami, String.valueOf((List)localObject1));
    }
    for (;;)
    {
      AppMethodBeat.o(202213);
      return paramList;
      label676:
      if ((this.rnh.diw == 4) && (paramInt == 1))
      {
        parami = getTAG() + "#loadMore";
        localObject2 = (Iterable)getDataList();
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(com.tencent.mm.ac.c.pb(((BaseFinderFeed)((Iterator)localObject2).next()).feedObject.getFeedObject().id));
        }
        ac.i(parami, String.valueOf((List)localObject1));
      }
      else if ((this.rnh.diw == 4) && (paramInt == 4))
      {
        parami = getTAG() + "#refresh";
        localObject2 = (Iterable)getDataList();
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(com.tencent.mm.ac.c.pb(((BaseFinderFeed)((Iterator)localObject2).next()).feedObject.getFeedObject().id));
        }
        ac.i(parami, String.valueOf((List)localObject1));
      }
    }
  }
  
  public final boolean needCleanWhenRefresh(List<? extends BaseFinderFeed> paramList)
  {
    AppMethodBeat.i(166053);
    d.g.b.k.h(paramList, "newList");
    DataBuffer localDataBuffer = getDataList();
    paramList = ((Iterable)paramList).iterator();
    label128:
    while (paramList.hasNext())
    {
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)paramList.next();
      Iterator localIterator = ((List)localDataBuffer).iterator();
      int i = 0;
      int j;
      if (localIterator.hasNext()) {
        if (((BaseFinderFeed)localIterator.next()).a((com.tencent.mm.plugin.finder.feed.model.internal.h)localBaseFinderFeed) == 0)
        {
          j = 1;
          label96:
          if (j == 0) {
            break label118;
          }
        }
      }
      for (;;)
      {
        if (i != -1) {
          break label128;
        }
        AppMethodBeat.o(166053);
        return true;
        j = 0;
        break label96;
        label118:
        i += 1;
        break;
        i = -1;
      }
    }
    AppMethodBeat.o(166053);
    return false;
  }
  
  public final void onDead()
  {
    AppMethodBeat.i(202218);
    super.onDead();
    this.rnh.qXf.dead();
    AppMethodBeat.o(202218);
  }
  
  public final void onFetchInsertedDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(202217);
    d.g.b.k.h(paramIResponse, "response");
    i locali = paramIResponse.getRequest();
    if ((locali instanceof y))
    {
      if (!((y)locali).rnC) {
        super.onFetchInsertedDone(paramIResponse);
      }
      ac.i(getTAG(), "[onFetchInsertedDone] isPrefetch=" + ((y)locali).rnC);
    }
    AppMethodBeat.o(202217);
  }
  
  public final void onFetchLoadMoreDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    int i = 1;
    AppMethodBeat.i(166054);
    d.g.b.k.h(paramIResponse, "response");
    if ((paramIResponse instanceof aa))
    {
      getDataListJustForAdapter().clearBuffer();
      getDataListJustForAdapter().addAllBuffer((Collection)((aa)paramIResponse).rmw);
    }
    RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
    localc.Jyb = paramIResponse.getHasMore();
    Context localContext = ai.getContext();
    d.g.b.k.g(localContext, "MMApplicationContext.getContext()");
    localc.Jya = ((CharSequence)localContext.getResources().getString(2131759370));
    localc.JxZ = 2;
    boolean bool;
    if (!paramIResponse.getHasMore())
    {
      bool = true;
      localc.isT = bool;
      ac.i(getTAG(), "[onFetchLoadMoreDone]  reason=".concat(String.valueOf(localc)));
      if (!paramIResponse.getHasMore()) {
        break label185;
      }
    }
    for (;;)
    {
      paramIResponse = new com.tencent.mm.plugin.finder.feed.model.internal.k(i, paramIResponse.getIncrementList(), false, 12);
      dispatcher().b(paramIResponse, localc);
      AppMethodBeat.o(166054);
      return;
      bool = false;
      break;
      label185:
      i = 5;
    }
  }
  
  public final void onFetchRefreshDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(166052);
    d.g.b.k.h(paramIResponse, "response");
    RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
    Object localObject;
    boolean bool;
    if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
    {
      localc.JxZ = 1;
      localObject = this.rni;
      if (localObject != null) {
        ((d.g.a.b)localObject).ay(paramIResponse);
      }
      if (paramIResponse.getPullType() == 0) {
        break label244;
      }
      bool = true;
      label75:
      localc.isT = bool;
      localc.Jyb = paramIResponse.getHasMore();
      if ((localc.actionType == 0) || (localc.actionType == 4) || (localc.actionType == 1))
      {
        if ((localc.Jyc <= 0) && (getDataListJustForAdapter().size() > 0)) {
          break label249;
        }
        localc.Jya = null;
      }
      label140:
      ac.i(getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
      if (!paramIResponse.getHasMore()) {
        break label284;
      }
    }
    label284:
    for (int i = 4;; i = 6)
    {
      paramIResponse = new com.tencent.mm.plugin.finder.feed.model.internal.k(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8);
      dispatcher().a(paramIResponse, localc);
      AppMethodBeat.o(166052);
      return;
      localObject = ai.getContext();
      d.g.b.k.g(localObject, "MMApplicationContext.getContext()");
      localc.Jya = ((CharSequence)((Context)localObject).getResources().getString(2131766505));
      localc.JxZ = -1;
      break;
      label244:
      bool = false;
      break label75;
      label249:
      localObject = ai.getContext();
      d.g.b.k.g(localObject, "MMApplicationContext.getContext()");
      localc.Jya = ((CharSequence)((Context)localObject).getResources().getString(2131766506));
      break label140;
    }
  }
  
  public final void requestInsert(i parami)
  {
    AppMethodBeat.i(202211);
    d.g.b.k.h(parami, "request");
    super.requestInsert(parami);
    ac.i(getTAG(), "requestInsert ".concat(String.valueOf(parami)));
    fetchData(parami);
    AppMethodBeat.o(202211);
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(166051);
    z localz = new z(2);
    ac.i(getTAG(), "requestLoadMore ".concat(String.valueOf(localz)));
    fetchData((i)localz);
    AppMethodBeat.o(166051);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(166050);
    requestRefresh((i)new z(this.rnj));
    AppMethodBeat.o(166050);
  }
  
  public final void requestRefresh(i parami)
  {
    AppMethodBeat.i(178295);
    d.g.b.k.h(parami, "request");
    parami = (z)parami;
    if (parami.rkK) {}
    for (parami.pullType = 4;; parami.pullType = this.rnj)
    {
      ac.i(getTAG(), "[requestRefresh] pullType=" + parami.pullType + "  hasPrefetch=" + parami.rkJ + " needToRefreshForPrefetch=" + parami.rkK);
      fetchData((i)parami);
      if (this.rnj == 0) {
        this.rnj = 1;
      }
      AppMethodBeat.o(178295);
      return;
    }
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(202208);
    d.g.b.k.h(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(202208);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$recyclerView$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "plugin-finder_release"})
  public static final class a
    implements View.OnAttachStateChangeListener
  {
    public a(RecyclerView paramRecyclerView) {}
    
    public final void onViewAttachedToWindow(View paramView)
    {
      Object localObject1 = null;
      AppMethodBeat.i(202207);
      d.g.b.k.h(paramView, "v");
      paramView = g.rEP;
      Object localObject2 = this.rnk.getAdapter();
      paramView = (View)localObject2;
      if (!(localObject2 instanceof WxRecyclerAdapter)) {
        paramView = null;
      }
      localObject2 = (WxRecyclerAdapter)paramView;
      paramView = localObject1;
      if (localObject2 != null) {
        paramView = ((WxRecyclerAdapter)localObject2).JCM;
      }
      g.c(paramView);
      AppMethodBeat.o(202207);
    }
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      Object localObject1 = null;
      AppMethodBeat.i(202206);
      d.g.b.k.h(paramView, "v");
      paramView = g.rEP;
      Object localObject2 = this.rnk.getAdapter();
      paramView = (View)localObject2;
      if (!(localObject2 instanceof WxRecyclerAdapter)) {
        paramView = null;
      }
      localObject2 = (WxRecyclerAdapter)paramView;
      paramView = localObject1;
      if (localObject2 != null) {
        paramView = ((WxRecyclerAdapter)localObject2).JCM;
      }
      g.b(paramView);
      AppMethodBeat.o(202206);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.m
 * JD-Core Version:    0.7.0.1
 */