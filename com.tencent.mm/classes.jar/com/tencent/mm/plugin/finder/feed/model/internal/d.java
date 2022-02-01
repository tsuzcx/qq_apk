package com.tencent.mm.plugin.finder.feed.model.internal;

import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.h.a;
import androidx.recyclerview.widget.h.b;
import androidx.recyclerview.widget.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.d.a.b.a.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "areContentsTheSame", "item1", "item2", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;)Z", "areItemsTheSame", "diff", "", "oldList", "", "newList", "diffDetectMoves", "finallyHandleMergeList", "srcList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/LinkedList;", "insertIndex", "", "cmd", "request", "findMergeIndex", "getChangePayload", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;)Ljava/lang/Object;", "getDiffCallback", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "getListUpdateCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "mergeDataAndNotify", "Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeResult;", "insList", "isNeedClear", "mergeInit", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "mergeInsert", "mergeLoadMore", "mergeRefresh", "needCleanWhenRefresh", "MergeDiffCallback", "plugin-finder-base_release"})
public abstract class d<T extends k>
{
  private final boolean DEBUG;
  
  public d()
  {
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    this.DEBUG = ((Boolean)com.tencent.mm.plugin.finder.storage.d.dUz().aSr()).booleanValue();
  }
  
  public boolean areContentsTheSame(T paramT1, T paramT2)
  {
    p.k(paramT1, "item1");
    p.k(paramT2, "item2");
    return true;
  }
  
  public boolean areItemsTheSame(T paramT1, T paramT2)
  {
    p.k(paramT1, "item1");
    p.k(paramT2, "item2");
    return paramT1.a(paramT2) == 0;
  }
  
  public final void diff(List<? extends T> paramList1, List<? extends T> paramList2)
  {
    p.k(paramList1, "oldList");
    p.k(paramList2, "newList");
    paramList1 = h.a(getDiffCallback(paramList1, paramList2));
    p.j(paramList1, "DiffUtil.calculateDiff(g…llback(oldList, newList))");
    paramList1.a(getListUpdateCallback());
  }
  
  public boolean diffDetectMoves()
  {
    return false;
  }
  
  public boolean finallyHandleMergeList(ArrayList<T> paramArrayList, LinkedList<T> paramLinkedList, int paramInt1, int paramInt2, Object paramObject)
  {
    p.k(paramArrayList, "srcList");
    p.k(paramLinkedList, "newList");
    return false;
  }
  
  public int findMergeIndex(ArrayList<T> paramArrayList, List<? extends T> paramList, int paramInt, Object paramObject)
  {
    p.k(paramArrayList, "srcList");
    p.k(paramList, "newList");
    return 0;
  }
  
  public Object getChangePayload(T paramT1, T paramT2)
  {
    p.k(paramT1, "item1");
    p.k(paramT2, "item2");
    return null;
  }
  
  public final boolean getDEBUG()
  {
    return this.DEBUG;
  }
  
  public h.a getDiffCallback(List<? extends T> paramList1, List<? extends T> paramList2)
  {
    p.k(paramList1, "oldList");
    p.k(paramList2, "newList");
    return (h.a)new a(paramList1, paramList2);
  }
  
  public abstract s getListUpdateCallback();
  
  public abstract n mergeDataAndNotify(int paramInt, List<? extends T> paramList, boolean paramBoolean, Object paramObject);
  
  public abstract void mergeInit(IResponse<T> paramIResponse, b<? super IResponse<T>, x> paramb);
  
  public abstract void mergeInsert(IResponse<T> paramIResponse, b<? super IResponse<T>, x> paramb);
  
  public abstract void mergeLoadMore(IResponse<T> paramIResponse, b<? super IResponse<T>, x> paramb);
  
  public abstract void mergeRefresh(IResponse<T> paramIResponse, b<? super IResponse<T>, x> paramb);
  
  public boolean needCleanWhenRefresh(List<? extends T> paramList)
  {
    p.k(paramList, "newList");
    return true;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger$MergeDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "newList", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;Ljava/util/List;Ljava/util/List;)V", "getNewList", "()Ljava/util/List;", "getOldList", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getChangePayload", "", "getNewListSize", "getOldListSize", "plugin-finder-base_release"})
  public final class a
    extends h.a
  {
    private final List<T> rgi;
    private final List<T> rgj;
    
    public a(List<? extends T> paramList)
    {
      AppMethodBeat.i(258165);
      this.rgi = paramList;
      this.rgj = localObject;
      AppMethodBeat.o(258165);
    }
    
    public final Object Y(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(258164);
      Object localObject = d.this.getChangePayload((k)this.rgi.get(paramInt1), (k)this.rgj.get(paramInt2));
      AppMethodBeat.o(258164);
      return localObject;
    }
    
    public final boolean Z(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(258160);
      boolean bool = d.this.areItemsTheSame((k)this.rgi.get(paramInt1), (k)this.rgj.get(paramInt2));
      AppMethodBeat.o(258160);
      return bool;
    }
    
    public final boolean ab(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(258163);
      boolean bool = d.this.areContentsTheSame((k)this.rgi.get(paramInt1), (k)this.rgj.get(paramInt2));
      AppMethodBeat.o(258163);
      return bool;
    }
    
    public final int jL()
    {
      AppMethodBeat.i(258161);
      int i = this.rgi.size();
      AppMethodBeat.o(258161);
      return i;
    }
    
    public final int jM()
    {
      AppMethodBeat.i(258162);
      int i = this.rgj.size();
      AppMethodBeat.o(258162);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.d
 * JD-Core Version:    0.7.0.1
 */