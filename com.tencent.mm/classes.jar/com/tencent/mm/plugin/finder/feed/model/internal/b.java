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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "areContentsTheSame", "item1", "item2", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;)Z", "areItemsTheSame", "diff", "", "oldList", "", "newList", "diffDetectMoves", "finallyHandleMergeList", "srcList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/LinkedList;", "insertIndex", "", "cmd", "request", "findMergeIndex", "getChangePayload", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;)Ljava/lang/Object;", "getDiffCallback", "Landroid/support/v7/util/DiffUtil$Callback;", "getListUpdateCallback", "Landroid/support/v7/util/ListUpdateCallback;", "mergeDataAndNotify", "Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeResult;", "insList", "isNeedClear", "mergeInit", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "mergeInsert", "mergeLoadMore", "mergeRefresh", "needCleanWhenRefresh", "MergeDiffCallback", "plugin-finder_release"})
public abstract class b<T extends i>
{
  private final boolean DEBUG;
  
  public b()
  {
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    this.DEBUG = ((Boolean)com.tencent.mm.plugin.finder.storage.b.cHx().value()).booleanValue();
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger$MergeDiffCallback;", "Landroid/support/v7/util/DiffUtil$Callback;", "oldList", "", "newList", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;Ljava/util/List;Ljava/util/List;)V", "getNewList", "()Ljava/util/List;", "getOldList", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getChangePayload", "", "getNewListSize", "getOldListSize", "plugin-finder_release"})
  public final class a
    extends c.a
  {
    private final List<T> mMq;
    private final List<T> mMr;
    
    public a(List<? extends T> paramList)
    {
      AppMethodBeat.i(202560);
      this.mMq = paramList;
      this.mMr = localObject;
      AppMethodBeat.o(202560);
    }
    
    public final int aA()
    {
      AppMethodBeat.i(202557);
      int i = this.mMr.size();
      AppMethodBeat.o(202557);
      return i;
    }
    
    public final int az()
    {
      AppMethodBeat.i(202556);
      int i = this.mMq.size();
      AppMethodBeat.o(202556);
      return i;
    }
    
    public final Object h(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202559);
      Object localObject = b.this.getChangePayload((i)this.mMq.get(paramInt1), (i)this.mMr.get(paramInt2));
      AppMethodBeat.o(202559);
      return localObject;
    }
    
    public final boolean i(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202555);
      boolean bool = b.this.areItemsTheSame((i)this.mMq.get(paramInt1), (i)this.mMr.get(paramInt2));
      AppMethodBeat.o(202555);
      return bool;
    }
    
    public final boolean j(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202558);
      boolean bool = b.this.areContentsTheSame((i)this.mMq.get(paramInt1), (i)this.mMr.get(paramInt2));
      AppMethodBeat.o(202558);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.b
 * JD-Core Version:    0.7.0.1
 */