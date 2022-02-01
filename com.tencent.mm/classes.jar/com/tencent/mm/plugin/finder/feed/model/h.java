package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.LongSparseArray;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c.a;
import com.tencent.mm.plugin.finder.feed.model.internal.c.c;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "firstLoad", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "extraDataOp", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "", "getExtraDataOp", "()Lkotlin/jvm/functions/Function1;", "setExtraDataOp", "(Lkotlin/jvm/functions/Function1;)V", "getFirstLoad", "()I", "setFirstLoad", "(I)V", "isDebug", "", "value", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getScene", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "getStreamFetcher", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "bufferSize", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "finallyHandleMergeList", "srcList", "Ljava/util/ArrayList;", "newList", "Ljava/util/LinkedList;", "insertIndex", "cmd", "request", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "findMergeIndex", "", "isObservePostEvent", "mergeDataAndNotify", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher$MergeResult;", "insList", "isNeedClear", "needCleanWhenRefresh", "onDead", "onFetchInsertedDone", "response", "onFetchLoadMoreDone", "onFetchRefreshDone", "preloadMoreToBuffer", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "printVisibleFeeds", "hasVisibleFeeds", "Landroid/util/LongSparseArray;", "requestInsert", "requestLoadMore", "requestRefresh", "plugin-finder_release"})
public final class h
  extends BaseFinderFeedLoader
{
  private final com.tencent.mm.plugin.finder.feed.model.internal.b KQj;
  public final com.tencent.mm.plugin.finder.cgi.a.b KQn;
  public d.g.a.b<? super IResponse<BaseFinderFeed>, y> KQo;
  private String TAG;
  private final boolean cxf;
  public RecyclerView fPw;
  private int qyG;
  
  public h(com.tencent.mm.plugin.finder.feed.model.internal.b paramb, int paramInt, dzp paramdzp)
  {
    super(null, paramdzp, 1, null);
    AppMethodBeat.i(198308);
    this.KQj = paramb;
    this.qyG = paramInt;
    this.TAG = "Finder.TimelineFeedLoader";
    this.KQn = new com.tencent.mm.plugin.finder.cgi.a.b(this.KQj.value, paramdzp);
    boolean bool1 = bool2;
    if (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)
    {
      bool1 = bool2;
      if (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) {
        if (!com.tencent.mm.sdk.a.b.eEQ()) {
          break label99;
        }
      }
    }
    label99:
    for (bool1 = bool2;; bool1 = false)
    {
      this.cxf = bool1;
      AppMethodBeat.o(198308);
      return;
    }
  }
  
  private static String a(LongSparseArray<?> paramLongSparseArray)
  {
    AppMethodBeat.i(198305);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = paramLongSparseArray.size();
    while (i < j)
    {
      localStringBuilder.append(com.tencent.mm.ad.c.ly(paramLongSparseArray.keyAt(i)) + ',');
      i += 1;
    }
    paramLongSparseArray = localStringBuilder.toString();
    k.g(paramLongSparseArray, "ss.toString()");
    AppMethodBeat.o(198305);
    return paramLongSparseArray;
  }
  
  public final f<Object, Object, com.tencent.mm.plugin.finder.feed.model.internal.i> createDataFetch(dzp paramdzp)
  {
    AppMethodBeat.i(198299);
    paramdzp = (f)new r(this.KQn, this.KQj, paramdzp);
    AppMethodBeat.o(198299);
    return paramdzp;
  }
  
  public final boolean finallyHandleMergeList(ArrayList<BaseFinderFeed> paramArrayList, LinkedList<BaseFinderFeed> paramLinkedList, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.feed.model.internal.j paramj)
  {
    AppMethodBeat.i(198304);
    k.h(paramArrayList, "srcList");
    k.h(paramLinkedList, "newList");
    Object localObject1;
    Object localObject2;
    if ((paramInt2 == 8) && ((paramj instanceof ab)))
    {
      localObject1 = this.fPw;
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
          localObject1 = ((WxRecyclerAdapter)localObject1).LEb;
          if (localObject1 != null) {
            break label806;
          }
        }
        localObject1 = new LongSparseArray();
      }
    }
    label152:
    label420:
    label806:
    for (;;)
    {
      LinkedList localLinkedList = new LinkedList((Collection)paramArrayList.subList(0, Math.min(paramInt1, paramArrayList.size())));
      Object localObject3;
      label173:
      Object localObject4;
      if (paramInt1 < paramArrayList.size())
      {
        localObject2 = new LinkedList((Collection)paramArrayList.subList(paramInt1, paramArrayList.size()));
        paramInt1 = -1;
        localObject3 = (Iterable)localLinkedList;
        paramInt2 = 0;
        localObject3 = ((Iterable)localObject3).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label246;
        }
        localObject4 = ((Iterator)localObject3).next();
        if (paramInt2 < 0) {
          d.a.j.fvx();
        }
        if (((LongSparseArray)localObject1).indexOfKey(((BaseFinderFeed)localObject4).bMs()) < 0) {
          break label803;
        }
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        paramInt2 += 1;
        break label173;
        localObject1 = null;
        break;
        localObject2 = new LinkedList();
        break label152;
        label246:
        if (paramInt1 >= 0) {}
        int j;
        Object localObject5;
        for (int i = localLinkedList.size() - paramInt1 - 1;; i = 0)
        {
          j = ((ab)paramj).KQu - i;
          localObject3 = new LinkedList();
          localObject4 = new LinkedList();
          ((LinkedList)localObject4).addAll((Collection)paramLinkedList);
          ((LinkedList)localObject4).addAll((Collection)localObject2);
          ((LinkedList)localObject3).addAll((Collection)localObject4);
          localObject2 = ((LinkedList)localObject3).iterator();
          k.g(localObject2, "increment.iterator()");
          paramInt2 = 0;
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label420;
            }
            localObject5 = ((Iterator)localObject2).next();
            k.g(localObject5, "iterator.next()");
            if (((LongSparseArray)localObject1).indexOfKey(((BaseFinderFeed)localObject5).feedObject.getId()) >= 0) {
              break label800;
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
          k.g(localObject2, "after.subList(increment.size, after.size)");
          localObject5 = getTAG();
          StringBuilder localStringBuilder = new StringBuilder("[finallyHandleMergeList] feed=");
          Object localObject6 = ((ab)paramj).qHv;
          long l;
          if (localObject6 != null)
          {
            localObject6 = ((BaseFinderFeed)localObject6).feedObject;
            if (localObject6 != null)
            {
              l = ((FinderItem)localObject6).getId();
              ad.i((String)localObject5, com.tencent.mm.ad.c.ly(l) + ' ' + "rawBefore=" + localLinkedList.size() + " raw=" + paramArrayList.size() + " readIndex=" + paramInt1 + " unreadCount=" + i + " maxUnreadCount=" + ((ab)paramj).KQu + " limitUnreadCount=" + j + ' ' + "afterSize=" + ((LinkedList)localObject4).size() + " incrementCount=" + ((LinkedList)localObject3).size() + " remain=" + ((List)localObject2).size() + ' ' + "hasVisibleFeeds=" + a((LongSparseArray)localObject1));
              paramArrayList.clear();
              paramArrayList.addAll((Collection)localLinkedList);
              paramLinkedList.clear();
              paramLinkedList.addAll((Collection)localObject3);
              paramArrayList = com.tencent.mm.plugin.finder.utils.i.qTa;
              paramLinkedList = (Iterable)localObject2;
              paramArrayList = (Collection)new ArrayList();
              paramLinkedList = paramLinkedList.iterator();
            }
          }
          for (;;)
          {
            label720:
            if (!paramLinkedList.hasNext()) {
              break label782;
            }
            paramj = paramLinkedList.next();
            if (((LongSparseArray)localObject1).indexOfKey(((BaseFinderFeed)paramj).bMs()) < 0) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if (paramInt1 == 0) {
                break label780;
              }
              paramArrayList.add(paramj);
              break label720;
              l = 0L;
              break;
            }
          }
          com.tencent.mm.plugin.finder.utils.i.a((List)paramArrayList, getContextObj());
          AppMethodBeat.o(198304);
          return true;
        }
      }
    }
  }
  
  public final int findMergeIndex(ArrayList<BaseFinderFeed> paramArrayList, List<? extends BaseFinderFeed> paramList, int paramInt, com.tencent.mm.plugin.finder.feed.model.internal.j paramj)
  {
    AppMethodBeat.i(198303);
    k.h(paramArrayList, "srcList");
    k.h(paramList, "newList");
    int i;
    Object localObject;
    label113:
    label117:
    int j;
    if ((paramInt == 8) && ((paramj instanceof ab)))
    {
      paramList = (List)paramArrayList;
      i = 0;
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        long l = ((BaseFinderFeed)paramList.next()).feedObject.getId();
        localObject = ((ab)paramj).qHv;
        if (localObject != null)
        {
          localObject = ((BaseFinderFeed)localObject).feedObject;
          if ((localObject != null) && (l == ((FinderItem)localObject).getId()))
          {
            paramInt = 1;
            if (paramInt == 0) {
              break label408;
            }
            paramList = ((ab)paramj).qsl;
            if (paramList == null) {
              break label423;
            }
            paramList = paramList.feedObject;
            if (paramList == null) {
              break label423;
            }
            paramList = Long.valueOf(paramList.getId());
            label147:
            localObject = ((ab)paramj).qHv;
            if (localObject == null) {
              break label428;
            }
            localObject = ((BaseFinderFeed)localObject).feedObject;
            if (localObject == null) {
              break label428;
            }
            localObject = Long.valueOf(((FinderItem)localObject).getId());
            label184:
            if (!(k.g(paramList, localObject) ^ true)) {
              break label632;
            }
            paramList = (List)paramArrayList;
            j = 0;
            paramList = paramList.iterator();
            label210:
            if (!paramList.hasNext()) {
              break label448;
            }
            l = ((BaseFinderFeed)paramList.next()).feedObject.getId();
            localObject = ((ab)paramj).qsl;
            if (localObject == null) {
              break label434;
            }
            localObject = ((BaseFinderFeed)localObject).feedObject;
            if ((localObject == null) || (l != ((FinderItem)localObject).getId())) {
              break label434;
            }
            paramInt = 1;
            label276:
            if (paramInt == 0) {
              break label439;
            }
          }
        }
      }
    }
    for (;;)
    {
      int i2 = Math.max(j, i);
      paramInt = Math.max(0, Math.min(paramArrayList.size(), i2));
      paramList = (Iterable)paramArrayList;
      int m = 0;
      paramList = paramList.iterator();
      int i1;
      for (int k = 0;; k = 2)
      {
        n = k;
        if (!paramList.hasNext()) {
          break label490;
        }
        paramj = paramList.next();
        i1 = m + 1;
        if (m < 0) {
          d.a.j.fvx();
        }
        paramj = (BaseFinderFeed)paramj;
        if ((m < i2) || (!paramj.feedObject.isRelatedItem())) {
          break;
        }
        paramInt += 1;
        n = paramInt;
        if (k != 0) {
          break label598;
        }
        m = i1;
      }
      paramInt = 0;
      break label113;
      label408:
      i += 1;
      break;
      i = -1;
      break label117;
      label423:
      paramList = null;
      break label147;
      label428:
      localObject = null;
      break label184;
      label434:
      paramInt = 0;
      break label276;
      label439:
      j += 1;
      break label210;
      label448:
      j = -1;
      continue;
      int n = paramInt;
      if (m >= i2)
      {
        n = paramInt;
        if (!paramj.feedObject.isRelatedItem())
        {
          n = k;
          if (k == 0) {
            n = 1;
          }
          label490:
          if (n != 2) {
            break label608;
          }
        }
      }
      label598:
      label608:
      for (k = 0;; k = 1)
      {
        paramInt = k + paramInt;
        ad.i(getTAG(), "[findMergeIndex] requestIndex=" + i + " centerIndex=" + j + " fixIndex=" + i2 + " resultIndex=" + paramInt + " size=" + paramArrayList.size() + " source=" + n + ' ');
        AppMethodBeat.o(198303);
        return paramInt;
        m = i1;
        paramInt = n;
        break;
      }
      paramInt = super.findMergeIndex(paramArrayList, paramList, paramInt, paramj);
      AppMethodBeat.o(198303);
      return paramInt;
      label632:
      j = i;
    }
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final boolean isObservePostEvent()
  {
    AppMethodBeat.i(198300);
    if (this.KQj != com.tencent.mm.plugin.finder.feed.model.internal.b.KQC)
    {
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (com.tencent.mm.plugin.finder.storage.b.fUw()) {}
    }
    else
    {
      AppMethodBeat.o(198300);
      return true;
    }
    AppMethodBeat.o(198300);
    return false;
  }
  
  public final c.c mergeDataAndNotify(int paramInt, List<? extends BaseFinderFeed> paramList, boolean paramBoolean, com.tencent.mm.plugin.finder.feed.model.internal.j paramj)
  {
    AppMethodBeat.i(198302);
    Object localObject1;
    label96:
    Object localObject2;
    if (((paramj instanceof ab)) && (this.fPw != null))
    {
      localObject1 = ((ab)paramj).qHv;
      if (localObject1 != null)
      {
        localObject1 = ((BaseFinderFeed)localObject1).feedObject;
        if ((localObject1 != null) && (!((FinderItem)localObject1).isRelatedItem()))
        {
          localObject1 = ((ab)paramj).qHv;
          long l;
          int i;
          if (localObject1 != null)
          {
            l = ((BaseFinderFeed)localObject1).bMs();
            localObject1 = this.fPw;
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
            localObject1 = (e)d.a((d)localObject1, l);
            if (localObject1 == null) {
              break label201;
            }
            i = ((e)localObject1).ln();
            label147:
            localObject1 = this.fPw;
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
            AppMethodBeat.o(198302);
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
          int j = ((LinearLayoutManager)localObject1).jO();
          int k = ((LinearLayoutManager)localObject1).jQ();
          if ((i >= 0) && (j <= i) && (i <= k)) {}
          for (boolean bool = true;; bool = false)
          {
            ad.i(getTAG(), "[mergeDataAndNotify] position=" + i + " first=" + j + " last=" + k + " isConsume=" + bool);
            if (!bool) {
              break label468;
            }
            paramList = super.mergeDataAndNotify(paramInt, paramList, paramBoolean, paramj);
            if (!this.cxf) {
              break label460;
            }
            paramj = getTAG() + "#insert";
            localObject2 = (Iterable)getDataList();
            localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
            localObject2 = ((Iterable)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((Collection)localObject1).add(com.tencent.mm.ad.c.ly(((BaseFinderFeed)((Iterator)localObject2).next()).feedObject.getFeedObject().id));
            }
          }
          ad.i(paramj, String.valueOf((List)localObject1));
          label460:
          AppMethodBeat.o(198302);
          return paramList;
          label468:
          if (paramList != null)
          {
            paramj = com.tencent.mm.plugin.finder.storage.data.i.KXv;
            com.tencent.mm.plugin.finder.storage.data.i.BX(l);
            paramj = com.tencent.mm.plugin.finder.utils.i.qTa;
            com.tencent.mm.plugin.finder.utils.i.a(paramList, getContextObj());
          }
          paramList = new c.c(new LinkedList());
          AppMethodBeat.o(198302);
          return paramList;
        }
      }
    }
    paramList = super.mergeDataAndNotify(paramInt, paramList, paramBoolean, paramj);
    if (this.cxf)
    {
      if (!(paramj instanceof ab)) {
        break label669;
      }
      paramj = getTAG() + "#insert";
      localObject2 = (Iterable)getDataList();
      localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(com.tencent.mm.ad.c.ly(((BaseFinderFeed)((Iterator)localObject2).next()).feedObject.getFeedObject().id));
      }
      ad.i(paramj, String.valueOf((List)localObject1));
    }
    for (;;)
    {
      AppMethodBeat.o(198302);
      return paramList;
      label669:
      if ((this.KQn.IoU == 4) && (paramInt == 1))
      {
        paramj = getTAG() + "#loadMore";
        localObject2 = (Iterable)getDataList();
        localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(com.tencent.mm.ad.c.ly(((BaseFinderFeed)((Iterator)localObject2).next()).feedObject.getFeedObject().id));
        }
        ad.i(paramj, String.valueOf((List)localObject1));
      }
      else if ((this.KQn.IoU == 4) && (paramInt == 4))
      {
        paramj = getTAG() + "#refresh";
        localObject2 = (Iterable)getDataList();
        localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(com.tencent.mm.ad.c.ly(((BaseFinderFeed)((Iterator)localObject2).next()).feedObject.getFeedObject().id));
        }
        ad.i(paramj, String.valueOf((List)localObject1));
      }
    }
  }
  
  public final boolean needCleanWhenRefresh(List<? extends BaseFinderFeed> paramList)
  {
    AppMethodBeat.i(166053);
    k.h(paramList, "newList");
    DataBuffer localDataBuffer = getDataList();
    paramList = ((Iterable)paramList).iterator();
    label95:
    label117:
    label127:
    while (paramList.hasNext())
    {
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)paramList.next();
      Iterator localIterator = ((List)localDataBuffer).iterator();
      int i = 0;
      int j;
      if (localIterator.hasNext()) {
        if (((BaseFinderFeed)localIterator.next()).a((com.tencent.mm.plugin.finder.feed.model.internal.i)localBaseFinderFeed) == 0)
        {
          j = 1;
          if (j == 0) {
            break label117;
          }
        }
      }
      for (;;)
      {
        if (i != -1) {
          break label127;
        }
        AppMethodBeat.o(166053);
        return true;
        j = 0;
        break label95;
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
    AppMethodBeat.i(198307);
    super.onDead();
    this.KQn.KJT.dead();
    AppMethodBeat.o(198307);
  }
  
  public final void onFetchInsertedDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(198306);
    k.h(paramIResponse, "response");
    com.tencent.mm.plugin.finder.feed.model.internal.j localj = paramIResponse.getRequest();
    if ((localj instanceof ab))
    {
      if (!((ab)localj).KQv) {
        super.onFetchInsertedDone(paramIResponse);
      }
      ad.i(getTAG(), "[onFetchInsertedDone] isPrefetch=" + ((ab)localj).KQv);
    }
    AppMethodBeat.o(198306);
  }
  
  public final void onFetchLoadMoreDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    int i = 1;
    AppMethodBeat.i(166054);
    k.h(paramIResponse, "response");
    if ((paramIResponse instanceof u))
    {
      getDataListJustForAdapter().clearBuffer();
      getDataListJustForAdapter().addAllBuffer((Collection)((u)paramIResponse).KPJ);
    }
    RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
    localc.HXq = paramIResponse.getHasMore();
    Context localContext = aj.getContext();
    k.g(localContext, "MMApplicationContext.getContext()");
    localc.HXp = ((CharSequence)localContext.getResources().getString(2131759370));
    localc.HXo = 2;
    boolean bool;
    if (!paramIResponse.getHasMore())
    {
      bool = true;
      localc.hSO = bool;
      ad.i(getTAG(), "[onFetchLoadMoreDone]  reason=".concat(String.valueOf(localc)));
      if (!paramIResponse.getHasMore()) {
        break label185;
      }
    }
    for (;;)
    {
      paramIResponse = new com.tencent.mm.plugin.finder.feed.model.internal.l(i, paramIResponse.getIncrementList(), false, 12);
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
    k.h(paramIResponse, "response");
    RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
    Object localObject;
    boolean bool;
    if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
    {
      localc.HXo = 1;
      localObject = this.KQo;
      if (localObject != null) {
        ((d.g.a.b)localObject).aA(paramIResponse);
      }
      if (paramIResponse.getPullType() == 0) {
        break label244;
      }
      bool = true;
      label75:
      localc.hSO = bool;
      localc.HXq = paramIResponse.getHasMore();
      if ((localc.actionType == 0) || (localc.actionType == 4) || (localc.actionType == 1))
      {
        if ((localc.HXr <= 0) && (getDataListJustForAdapter().size() > 0)) {
          break label249;
        }
        localc.HXp = null;
      }
      label140:
      ad.i(getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
      if (!paramIResponse.getHasMore()) {
        break label284;
      }
    }
    label284:
    for (int i = 4;; i = 6)
    {
      paramIResponse = new com.tencent.mm.plugin.finder.feed.model.internal.l(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8);
      dispatcher().a(paramIResponse, localc);
      AppMethodBeat.o(166052);
      return;
      localObject = aj.getContext();
      k.g(localObject, "MMApplicationContext.getContext()");
      localc.HXp = ((CharSequence)((Context)localObject).getResources().getString(2131766491));
      localc.HXo = -1;
      break;
      label244:
      bool = false;
      break label75;
      label249:
      localObject = aj.getContext();
      k.g(localObject, "MMApplicationContext.getContext()");
      localc.HXp = ((CharSequence)((Context)localObject).getResources().getString(2131766492));
      break label140;
    }
  }
  
  public final void requestInsert(com.tencent.mm.plugin.finder.feed.model.internal.j paramj)
  {
    AppMethodBeat.i(198301);
    k.h(paramj, "request");
    super.requestInsert(paramj);
    ad.i(getTAG(), "requestInsert ".concat(String.valueOf(paramj)));
    fetchData(paramj);
    AppMethodBeat.o(198301);
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(166051);
    t localt = new t(2);
    ad.i(getTAG(), "requestLoadMore ".concat(String.valueOf(localt)));
    fetchData((com.tencent.mm.plugin.finder.feed.model.internal.j)localt);
    AppMethodBeat.o(166051);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(166050);
    requestRefresh((com.tencent.mm.plugin.finder.feed.model.internal.j)new t(this.qyG));
    AppMethodBeat.o(166050);
  }
  
  public final void requestRefresh(com.tencent.mm.plugin.finder.feed.model.internal.j paramj)
  {
    AppMethodBeat.i(178295);
    k.h(paramj, "request");
    paramj = (t)paramj;
    if (paramj.qwM) {}
    for (paramj.pullType = 4;; paramj.pullType = this.qyG)
    {
      ad.i(getTAG(), "[requestRefresh] pullType=" + paramj.pullType + "  hasPrefetch=" + paramj.qwL + " needToRefreshForPrefetch=" + paramj.qwM);
      fetchData((com.tencent.mm.plugin.finder.feed.model.internal.j)paramj);
      if (this.qyG == 0) {
        this.qyG = 1;
      }
      AppMethodBeat.o(178295);
      return;
    }
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(198298);
    k.h(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(198298);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$recyclerView$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "plugin-finder_release"})
  public static final class a
    implements View.OnAttachStateChangeListener
  {
    public a(RecyclerView paramRecyclerView) {}
    
    public final void onViewAttachedToWindow(View paramView)
    {
      Object localObject1 = null;
      AppMethodBeat.i(198297);
      k.h(paramView, "v");
      paramView = com.tencent.mm.plugin.finder.storage.data.i.KXv;
      Object localObject2 = this.KQp.getAdapter();
      paramView = (View)localObject2;
      if (!(localObject2 instanceof WxRecyclerAdapter)) {
        paramView = null;
      }
      localObject2 = (WxRecyclerAdapter)paramView;
      paramView = localObject1;
      if (localObject2 != null) {
        paramView = ((WxRecyclerAdapter)localObject2).LEb;
      }
      com.tencent.mm.plugin.finder.storage.data.i.c(paramView);
      AppMethodBeat.o(198297);
    }
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      Object localObject1 = null;
      AppMethodBeat.i(198296);
      k.h(paramView, "v");
      paramView = com.tencent.mm.plugin.finder.storage.data.i.KXv;
      Object localObject2 = this.KQp.getAdapter();
      paramView = (View)localObject2;
      if (!(localObject2 instanceof WxRecyclerAdapter)) {
        paramView = null;
      }
      localObject2 = (WxRecyclerAdapter)paramView;
      paramView = localObject1;
      if (localObject2 != null) {
        paramView = ((WxRecyclerAdapter)localObject2).LEb;
      }
      com.tencent.mm.plugin.finder.storage.data.i.b(paramView);
      AppMethodBeat.o(198296);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.h
 * JD-Core Version:    0.7.0.1
 */