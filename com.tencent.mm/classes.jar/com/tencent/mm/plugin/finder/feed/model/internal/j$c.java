package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$PageData;", "T", "A", "", "list", "Ljava/util/LinkedList;", "(Ljava/util/LinkedList;)V", "args", "getArgs", "()Ljava/lang/Object;", "setArgs", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getList", "()Ljava/util/LinkedList;", "component1", "copy", "decrement", "", "count", "", "equals", "", "other", "hashCode", "isEmpty", "size", "toString", "", "plugin-finder_release"})
public final class j$c<T, A>
{
  public final LinkedList<T> fBS;
  public A rov;
  
  public j$c(LinkedList<T> paramLinkedList)
  {
    AppMethodBeat.i(202266);
    this.fBS = paramLinkedList;
    AppMethodBeat.o(202266);
  }
  
  public final List<T> DK(int paramInt)
  {
    AppMethodBeat.i(202264);
    Object localObject = new LinkedList();
    Iterator localIterator = this.fBS.iterator();
    k.g(localIterator, "list.iterator()");
    int i = 0;
    while ((localIterator.hasNext()) && (i < paramInt))
    {
      ((LinkedList)localObject).add(localIterator.next());
      localIterator.remove();
      i += 1;
    }
    localObject = (List)localObject;
    AppMethodBeat.o(202264);
    return localObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(202268);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if (!k.g(this.fBS, paramObject.fBS)) {}
      }
    }
    else
    {
      AppMethodBeat.o(202268);
      return true;
    }
    AppMethodBeat.o(202268);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(202267);
    LinkedList localLinkedList = this.fBS;
    if (localLinkedList != null)
    {
      int i = localLinkedList.hashCode();
      AppMethodBeat.o(202267);
      return i;
    }
    AppMethodBeat.o(202267);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202265);
    StringBuilder localStringBuilder = new StringBuilder("PageData(size=").append(this.fBS.size()).append(" args=");
    Object localObject = this.rov;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(localObject.hashCode());; localObject = null)
    {
      localObject = localObject + ')';
      AppMethodBeat.o(202265);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.j.c
 * JD-Core Version:    0.7.0.1
 */