package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.a.v;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;)V", "cleanDataList", "", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "convertOpToReason", "op", "Lcom/tencent/mm/plugin/finder/feed/model/internal/UpdateOp;", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "findMergeIndex", "", "srcList", "Ljava/util/ArrayList;", "newList", "", "cmd", "request", "getListUpdateCallback", "Landroid/support/v7/util/ListUpdateCallback;", "merge", "Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeResult;", "mergeDataAndNotify", "insList", "isNeedClear", "", "mergeInit", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "mergeInsert", "mergeLoadMore", "mergeRefresh", "printList", "tag", "", "mmlist", "plugin-finder_release"})
public class BaseFeedLoader$a
  extends b<T>
{
  public void cleanDataList(DataBuffer<T> paramDataBuffer)
  {
    AppMethodBeat.i(203004);
    p.h(paramDataBuffer, "dataList");
    paramDataBuffer.clear();
    AppMethodBeat.o(203004);
  }
  
  public final void convertOpToReason(l<T> paraml, RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(203008);
    p.h(paraml, "op");
    p.h(paramc, "reason");
    paraml = mergeDataAndNotify(paraml.EN, paraml.slZ, paraml.isNeedClear, paraml.request);
    paramc.hQS = paraml;
    paramc.LNU = paraml.slP;
    AppMethodBeat.o(203008);
  }
  
  public int findMergeIndex(ArrayList<T> paramArrayList, List<? extends T> paramList, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(203003);
    p.h(paramArrayList, "srcList");
    p.h(paramList, "newList");
    if ((paramInt == 1) || (paramInt == 5))
    {
      paramInt = this.this$0.getDataList().size();
      AppMethodBeat.o(203003);
      return paramInt;
    }
    if ((paramInt == 2) || (paramInt == 6) || (paramInt == 4))
    {
      AppMethodBeat.o(203003);
      return 0;
    }
    AppMethodBeat.o(203003);
    return 0;
  }
  
  public android.support.v7.h.d getListUpdateCallback()
  {
    AppMethodBeat.i(203009);
    android.support.v7.h.d locald = (android.support.v7.h.d)new a(this);
    AppMethodBeat.o(203009);
    return locald;
  }
  
  protected final j merge(List<? extends T> paramList, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(203006);
    p.h(paramList, "newList");
    printList("newList", paramInt, paramList);
    DataBuffer localDataBuffer = this.this$0.getDataList();
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    paramList = ((Iterable)paramList).iterator();
    int i;
    while (paramList.hasNext())
    {
      i locali = (i)paramList.next();
      Object localObject = (List)localDataBuffer;
      i = 0;
      localObject = ((List)localObject).iterator();
      label95:
      int k;
      if (((Iterator)localObject).hasNext()) {
        if (((i)((Iterator)localObject).next()).a(locali) == 0)
        {
          j = 1;
          label128:
          if (j == 0) {
            break label223;
          }
          j = i;
          label137:
          localObject = (List)localLinkedList1;
          i = 0;
          localObject = ((List)localObject).iterator();
          label156:
          if (!((Iterator)localObject).hasNext()) {
            break label253;
          }
          if (((i)((Iterator)localObject).next()).a(locali) != 0) {
            break label238;
          }
          k = 1;
          label189:
          if (k == 0) {
            break label244;
          }
        }
      }
      for (;;)
      {
        if ((j != -1) || (i != -1)) {
          break label259;
        }
        localLinkedList1.add(locali);
        break;
        j = 0;
        break label128;
        label223:
        i += 1;
        break label95;
        j = -1;
        break label137;
        label238:
        k = 0;
        break label189;
        label244:
        i += 1;
        break label156;
        label253:
        i = -1;
      }
      label259:
      if (j != -1)
      {
        localDataBuffer.set(j, locali);
        localLinkedList2.add(Integer.valueOf(j));
      }
      else
      {
        ae.w(this.this$0.getTAG(), "newList exist a same feed[" + (i)localLinkedList1.get(i) + "], just ignore this feed=" + locali + " existIndex=" + j + " existIndexInIncrementList=" + i);
      }
    }
    printList("incrementList", paramInt, (List)localLinkedList1);
    int j = 0;
    boolean bool = false;
    if (localLinkedList1.size() > 0)
    {
      i = 1;
      if (i == 0) {
        break label551;
      }
    }
    label551:
    for (paramList = localLinkedList1;; paramList = null)
    {
      i = j;
      if (paramList != null)
      {
        i = findMergeIndex((ArrayList)localDataBuffer, (List)localLinkedList1, paramInt, paramObject);
        bool = finallyHandleMergeList((ArrayList)localDataBuffer, localLinkedList1, i, paramInt, paramObject);
        ae.i(this.this$0.getTAG(), "merge list index " + i + " incrementList:" + localLinkedList1.size() + " cmd=" + paramInt);
        localDataBuffer.addAll(i, (Collection)localLinkedList1);
      }
      paramList = new j(i, localLinkedList1.size(), localLinkedList2, bool);
      printList("dataList", paramInt, (List)this.this$0.getDataList());
      AppMethodBeat.o(203006);
      return paramList;
      i = 0;
      break;
    }
  }
  
  public j mergeDataAndNotify(int paramInt, List<? extends T> paramList, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(203005);
    if (paramList == null)
    {
      paramList = new j(new LinkedList());
      AppMethodBeat.o(203005);
      return paramList;
    }
    if (!paramBoolean)
    {
      ae.i(this.this$0.getTAG(), "nothing need to notify, just return. cmd=" + paramInt + " size =" + paramList.size());
      paramList = new j(new LinkedList());
      AppMethodBeat.o(203005);
      return paramList;
    }
    int j = this.this$0.getDataList().size();
    if (((paramInt == 4) || (paramInt == 3) || (paramInt == 7)) && (needCleanWhenRefresh(paramList)))
    {
      if (((Collection)paramList).isEmpty()) {
        break label410;
      }
      i = 1;
      if ((i != 0) || (paramInt == 7))
      {
        cleanDataList(this.this$0.getDataList());
        if (paramInt == 4) {
          this.this$0.dispatcher().av(0, j);
        }
      }
    }
    paramList = merge(paramList, paramInt, paramObject);
    paramObject = this.this$0.getTAG();
    StringBuilder localStringBuilder = new StringBuilder("mergeDataAndNotify insertIndex=").append(paramList.slO).append(" insertCount=").append(paramList.slP).append(" changeIndex=").append(paramList.slQ).append(' ').append("size: ").append(this.this$0.getDataList().size()).append(" isRemoveBeforeInsert=").append(paramList.slR).append(" loader:").append(getClass().getSimpleName()).append(" cmd:");
    l.a locala = l.sma;
    ae.i(paramObject, l.a.ES(paramInt) + '}');
    if (!((Collection)paramList.slQ).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (paramList.slP > 0)) {
        break label422;
      }
      ae.i(this.this$0.getTAG(), "just change all. cmd=".concat(String.valueOf(paramInt)));
      this.this$0.dispatcher().onChanged();
      AppMethodBeat.o(203005);
      return paramList;
      label410:
      i = 0;
      break;
    }
    label422:
    if ((paramInt == 3) || (paramInt == 2) || (paramInt == 6) || (paramInt == 7)) {
      this.this$0.dispatcher().onChanged();
    }
    for (;;)
    {
      AppMethodBeat.o(203005);
      return paramList;
      if (paramList.slR)
      {
        paramObject = this.this$0.dispatcher();
        paramInt = paramList.slO;
        paramObject.av(paramInt, j - paramInt);
      }
      this.this$0.dispatcher().au(paramList.slO, paramList.slP);
    }
  }
  
  public void mergeInit(final IResponse<T> paramIResponse, final d.g.a.b<? super IResponse<T>, z> paramb)
  {
    AppMethodBeat.i(202999);
    p.h(paramIResponse, "response");
    if (paramIResponse.getIncrementList() == null) {
      paramIResponse.setIncrementList((List)v.NhH);
    }
    String str = this.this$0.getTAG();
    StringBuilder localStringBuilder = new StringBuilder("initData dataFetch.initData ");
    Object localObject = paramIResponse.getIncrementList();
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((List)localObject).size());; localObject = null)
    {
      ae.i(str, localObject);
      c.h((a)new b(this, paramIResponse, paramb));
      AppMethodBeat.o(202999);
      return;
    }
  }
  
  public void mergeInsert(final IResponse<T> paramIResponse, final d.g.a.b<? super IResponse<T>, z> paramb)
  {
    AppMethodBeat.i(203002);
    p.h(paramIResponse, "response");
    Object localObject = RefreshLoadMoreLayout.c.LOa;
    localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.fUz());
    ((RefreshLoadMoreLayout.c)localObject).iOP = true;
    ((RefreshLoadMoreLayout.c)localObject).LNT = true;
    final l locall = new l(8, paramIResponse.getIncrementList(), false, 12);
    locall.request = paramIResponse.getRequest();
    c.h((a)new c(this, locall, (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
    AppMethodBeat.o(203002);
  }
  
  public void mergeLoadMore(final IResponse<T> paramIResponse, final d.g.a.b<? super IResponse<T>, z> paramb)
  {
    int i = 1;
    AppMethodBeat.i(203001);
    p.h(paramIResponse, "response");
    Object localObject = RefreshLoadMoreLayout.c.LOa;
    localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.fUy());
    List localList = paramIResponse.getIncrementList();
    boolean bool;
    if (localList != null)
    {
      bool = localList.isEmpty();
      ((RefreshLoadMoreLayout.c)localObject).iOP = bool;
      ((RefreshLoadMoreLayout.c)localObject).LNT = paramIResponse.getHasMore();
      if (!paramIResponse.getHasMore()) {
        break label121;
      }
    }
    for (;;)
    {
      c.h((a)new d(this, new l(i, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
      AppMethodBeat.o(203001);
      return;
      bool = true;
      break;
      label121:
      i = 5;
    }
  }
  
  public void mergeRefresh(final IResponse<T> paramIResponse, final d.g.a.b<? super IResponse<T>, z> paramb)
  {
    AppMethodBeat.i(203000);
    p.h(paramIResponse, "response");
    Object localObject = RefreshLoadMoreLayout.c.LOa;
    localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.fUx());
    if (paramIResponse.getHasMore()) {}
    for (int i = 2;; i = 6)
    {
      c.h((a)new e(this, new l(i, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
      AppMethodBeat.o(203000);
      return;
    }
  }
  
  public final void printList(String paramString, int paramInt, List<? extends T> paramList)
  {
    AppMethodBeat.i(203010);
    p.h(paramString, "tag");
    p.h(paramList, "mmlist");
    if (getDEBUG())
    {
      paramList = ((Iterable)paramList).iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        if (i < 0) {
          d.a.j.gkd();
        }
        localObject = (i)localObject;
        String str = this.this$0.getTAG();
        StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(" index ").append(i).append(" cmd:");
        l.a locala = l.sma;
        ae.i(str, l.a.ES(paramInt) + ' ' + localObject);
        i += 1;
      }
    }
    AppMethodBeat.o(203010);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger$getListUpdateCallback$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "positionStart", "", "itemCount", "payload", "", "onInserted", "onMoved", "p0", "p1", "onRemoved", "plugin-finder_release"})
  public static final class a
    implements android.support.v7.h.d
  {
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(202992);
      this.slq.this$0.dispatcher().f(paramInt1, paramInt2, paramObject);
      AppMethodBeat.o(202992);
    }
    
    public final void f(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202993);
      this.slq.this$0.dispatcher().au(paramInt1, paramInt2);
      AppMethodBeat.o(202993);
    }
    
    public final void k(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202994);
      this.slq.this$0.dispatcher().av(paramInt1, paramInt2);
      AppMethodBeat.o(202994);
    }
    
    public final void l(int paramInt1, int paramInt2) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class b
    extends q
    implements a<z>
  {
    b(BaseFeedLoader.a parama, IResponse paramIResponse, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class c
    extends q
    implements a<z>
  {
    c(BaseFeedLoader.a parama, l paraml, RefreshLoadMoreLayout.c paramc, d.g.a.b paramb, IResponse paramIResponse)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class d
    extends q
    implements a<z>
  {
    d(BaseFeedLoader.a parama, l paraml, RefreshLoadMoreLayout.c paramc, d.g.a.b paramb, IResponse paramIResponse)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class e
    extends q
    implements a<z>
  {
    e(BaseFeedLoader.a parama, l paraml, RefreshLoadMoreLayout.c paramc, d.g.a.b paramb, IResponse paramIResponse)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
 * JD-Core Version:    0.7.0.1
 */