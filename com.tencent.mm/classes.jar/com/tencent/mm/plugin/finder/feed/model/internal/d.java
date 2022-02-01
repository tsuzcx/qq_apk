package com.tencent.mm.plugin.finder.feed.model.internal;

import androidx.recyclerview.widget.g;
import androidx.recyclerview.widget.g.a;
import androidx.recyclerview.widget.g.b;
import androidx.recyclerview.widget.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.storage.config.a.a.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "areContentsTheSame", "item1", "item2", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;)Z", "areItemsTheSame", "diff", "", "oldList", "", "newList", "diffDetectMoves", "finallyHandleMergeList", "srcList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/LinkedList;", "insertIndex", "", "cmd", "request", "findMergeIndex", "getChangePayload", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;)Ljava/lang/Object;", "getDiffCallback", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "getListUpdateCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "mergeDataAndNotify", "Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeResult;", "insList", "isNeedClear", "mergeInit", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "mergeInsert", "mergeInsertSpecifiedLocation", "data", "Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeInsertData;", "mergeLoadMore", "mergeRefresh", "needCleanWhenRefresh", "MergeDiffCallback", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d<T extends k>
{
  private final boolean DEBUG;
  
  public d()
  {
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    this.DEBUG = ((Boolean)com.tencent.mm.plugin.finder.storage.d.eSY().bmg()).booleanValue();
  }
  
  public boolean areContentsTheSame(T paramT1, T paramT2)
  {
    s.u(paramT1, "item1");
    s.u(paramT2, "item2");
    return true;
  }
  
  public boolean areItemsTheSame(T paramT1, T paramT2)
  {
    s.u(paramT1, "item1");
    s.u(paramT2, "item2");
    return paramT1.a(paramT2) == 0;
  }
  
  public final void diff(List<? extends T> paramList1, List<? extends T> paramList2)
  {
    s.u(paramList1, "oldList");
    s.u(paramList2, "newList");
    paramList1 = g.a(getDiffCallback(paramList1, paramList2));
    s.s(paramList1, "calculateDiff(getDiffCallback(oldList, newList))");
    paramList1.a(getListUpdateCallback());
  }
  
  public boolean diffDetectMoves()
  {
    return false;
  }
  
  public boolean finallyHandleMergeList(ArrayList<T> paramArrayList, LinkedList<T> paramLinkedList, int paramInt1, int paramInt2, Object paramObject)
  {
    s.u(paramArrayList, "srcList");
    s.u(paramLinkedList, "newList");
    return false;
  }
  
  public int findMergeIndex(ArrayList<T> paramArrayList, List<? extends T> paramList, int paramInt, Object paramObject)
  {
    s.u(paramArrayList, "srcList");
    s.u(paramList, "newList");
    return 0;
  }
  
  public Object getChangePayload(T paramT1, T paramT2)
  {
    s.u(paramT1, "item1");
    s.u(paramT2, "item2");
    return null;
  }
  
  public final boolean getDEBUG()
  {
    return this.DEBUG;
  }
  
  public g.a getDiffCallback(List<? extends T> paramList1, List<? extends T> paramList2)
  {
    s.u(paramList1, "oldList");
    s.u(paramList2, "newList");
    return (g.a)new a(paramList1, paramList2);
  }
  
  public abstract q getListUpdateCallback();
  
  public abstract o mergeDataAndNotify(int paramInt, List<? extends T> paramList, boolean paramBoolean, Object paramObject);
  
  public abstract void mergeInit(IResponse<T> paramIResponse, b<? super IResponse<T>, ah> paramb);
  
  public abstract void mergeInsert(IResponse<T> paramIResponse, b<? super IResponse<T>, ah> paramb);
  
  public abstract void mergeInsertSpecifiedLocation(IResponse<T> paramIResponse, n paramn, b<? super IResponse<T>, ah> paramb);
  
  public abstract void mergeLoadMore(IResponse<T> paramIResponse, b<? super IResponse<T>, ah> paramb);
  
  public abstract void mergeRefresh(IResponse<T> paramIResponse, b<? super IResponse<T>, ah> paramb);
  
  public boolean needCleanWhenRefresh(List<? extends T> paramList)
  {
    s.u(paramList, "newList");
    return true;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger$MergeDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "newList", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;Ljava/util/List;Ljava/util/List;)V", "getNewList", "()Ljava/util/List;", "getOldList", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getChangePayload", "", "getNewListSize", "getOldListSize", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends g.a
  {
    private final List<T> uoj;
    private final List<T> uok;
    
    public a(List<? extends T> paramList)
    {
      AppMethodBeat.i(366547);
      this.uoj = paramList;
      this.uok = localObject;
      AppMethodBeat.o(366547);
    }
    
    public final int If()
    {
      AppMethodBeat.i(366560);
      int i = this.uoj.size();
      AppMethodBeat.o(366560);
      return i;
    }
    
    public final int Ig()
    {
      AppMethodBeat.i(366568);
      int i = this.uok.size();
      AppMethodBeat.o(366568);
      return i;
    }
    
    public final Object aT(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(366578);
      Object localObject = d.this.getChangePayload((k)this.uoj.get(paramInt1), (k)this.uok.get(paramInt2));
      AppMethodBeat.o(366578);
      return localObject;
    }
    
    public final boolean aU(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(366552);
      boolean bool = d.this.areItemsTheSame((k)this.uoj.get(paramInt1), (k)this.uok.get(paramInt2));
      AppMethodBeat.o(366552);
      return bool;
    }
    
    public final boolean aV(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(366572);
      boolean bool = d.this.areContentsTheSame((k)this.uoj.get(paramInt1), (k)this.uok.get(paramInt2));
      AppMethodBeat.o(366572);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.d
 * JD-Core Version:    0.7.0.1
 */