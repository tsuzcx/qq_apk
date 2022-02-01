package com.tencent.mm.plugin.finder.feed.model.internal;

import android.support.v7.h.c;
import android.support.v7.h.c.a;
import android.support.v7.h.c.b;
import android.support.v7.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.config.item.booleantype.a;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "areContentsTheSame", "item1", "item2", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;)Z", "areItemsTheSame", "diff", "", "oldList", "", "newList", "diffDetectMoves", "finallyHandleMergeList", "srcList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/LinkedList;", "insertIndex", "", "cmd", "request", "findMergeIndex", "getChangePayload", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;)Ljava/lang/Object;", "getDiffCallback", "Landroid/support/v7/util/DiffUtil$Callback;", "getListUpdateCallback", "Landroid/support/v7/util/ListUpdateCallback;", "mergeDataAndNotify", "Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeResult;", "insList", "isNeedClear", "mergeInit", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "mergeInsert", "mergeLoadMore", "mergeRefresh", "needCleanWhenRefresh", "MergeDiffCallback", "plugin-finder_release"})
public abstract class b<T extends i>
{
  private final boolean DEBUG;
  
  public b()
  {
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    this.DEBUG = ((Boolean)com.tencent.mm.plugin.finder.storage.b.cJw().value()).booleanValue();
  }
  
  public boolean areContentsTheSame(T paramT1, T paramT2)
  {
    p.h(paramT1, "item1");
    p.h(paramT2, "item2");
    return true;
  }
  
  public boolean areItemsTheSame(T paramT1, T paramT2)
  {
    p.h(paramT1, "item1");
    p.h(paramT2, "item2");
    return paramT1.a(paramT2) == 0;
  }
  
  public final void diff(List<? extends T> paramList1, List<? extends T> paramList2)
  {
    p.h(paramList1, "oldList");
    p.h(paramList2, "newList");
    paramList1 = c.a(getDiffCallback(paramList1, paramList2));
    p.g(paramList1, "DiffUtil.calculateDiff(g…llback(oldList, newList))");
    paramList1.a(getListUpdateCallback());
  }
  
  public boolean diffDetectMoves()
  {
    return false;
  }
  
  public boolean finallyHandleMergeList(ArrayList<T> paramArrayList, LinkedList<T> paramLinkedList, int paramInt1, int paramInt2, Object paramObject)
  {
    p.h(paramArrayList, "srcList");
    p.h(paramLinkedList, "newList");
    return false;
  }
  
  public int findMergeIndex(ArrayList<T> paramArrayList, List<? extends T> paramList, int paramInt, Object paramObject)
  {
    p.h(paramArrayList, "srcList");
    p.h(paramList, "newList");
    return 0;
  }
  
  public Object getChangePayload(T paramT1, T paramT2)
  {
    p.h(paramT1, "item1");
    p.h(paramT2, "item2");
    return null;
  }
  
  public final boolean getDEBUG()
  {
    return this.DEBUG;
  }
  
  public c.a getDiffCallback(List<? extends T> paramList1, List<? extends T> paramList2)
  {
    p.h(paramList1, "oldList");
    p.h(paramList2, "newList");
    return (c.a)new a(paramList1, paramList2);
  }
  
  public abstract d getListUpdateCallback();
  
  public abstract j mergeDataAndNotify(int paramInt, List<? extends T> paramList, boolean paramBoolean, Object paramObject);
  
  public abstract void mergeInit(IResponse<T> paramIResponse, d.g.a.b<? super IResponse<T>, z> paramb);
  
  public abstract void mergeInsert(IResponse<T> paramIResponse, d.g.a.b<? super IResponse<T>, z> paramb);
  
  public abstract void mergeLoadMore(IResponse<T> paramIResponse, d.g.a.b<? super IResponse<T>, z> paramb);
  
  public abstract void mergeRefresh(IResponse<T> paramIResponse, d.g.a.b<? super IResponse<T>, z> paramb);
  
  public boolean needCleanWhenRefresh(List<? extends T> paramList)
  {
    p.h(paramList, "newList");
    return true;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger$MergeDiffCallback;", "Landroid/support/v7/util/DiffUtil$Callback;", "oldList", "", "newList", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;Ljava/util/List;Ljava/util/List;)V", "getNewList", "()Ljava/util/List;", "getOldList", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getChangePayload", "", "getNewListSize", "getOldListSize", "plugin-finder_release"})
  public final class a
    extends c.a
  {
    private final List<T> mRt;
    private final List<T> mRu;
    
    public a(List<? extends T> paramList)
    {
      AppMethodBeat.i(203036);
      this.mRt = paramList;
      this.mRu = localObject;
      AppMethodBeat.o(203036);
    }
    
    public final int aA()
    {
      AppMethodBeat.i(203033);
      int i = this.mRu.size();
      AppMethodBeat.o(203033);
      return i;
    }
    
    public final int az()
    {
      AppMethodBeat.i(203032);
      int i = this.mRt.size();
      AppMethodBeat.o(203032);
      return i;
    }
    
    public final Object h(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(203035);
      Object localObject = b.this.getChangePayload((i)this.mRt.get(paramInt1), (i)this.mRu.get(paramInt2));
      AppMethodBeat.o(203035);
      return localObject;
    }
    
    public final boolean i(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(203031);
      boolean bool = b.this.areItemsTheSame((i)this.mRt.get(paramInt1), (i)this.mRu.get(paramInt2));
      AppMethodBeat.o(203031);
      return bool;
    }
    
    public final boolean j(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(203034);
      boolean bool = b.this.areContentsTheSame((i)this.mRt.get(paramInt1), (i)this.mRu.get(paramInt2));
      AppMethodBeat.o(203034);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.b
 * JD-Core Version:    0.7.0.1
 */