package com.tencent.mm.plugin.livelist;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livelist/MMLiveItemChangeObj;", "T", "Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;", "", "oldItem", "(Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;)V", "changeKey", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getChangeKey", "()Ljava/util/HashSet;", "setChangeKey", "(Ljava/util/HashSet;)V", "getOldItem", "()Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;", "Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;", "component1", "copy", "(Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;)Lcom/tencent/mm/plugin/livelist/MMLiveItemChangeObj;", "equals", "", "other", "hashCode", "", "toString", "plugin-livelist_release"})
public final class c<T extends b>
{
  private final T EhG;
  
  public c(T paramT)
  {
    AppMethodBeat.i(218067);
    this.EhG = paramT;
    AppMethodBeat.o(218067);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(218074);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if (!p.h(this.EhG, paramObject.EhG)) {}
      }
    }
    else
    {
      AppMethodBeat.o(218074);
      return true;
    }
    AppMethodBeat.o(218074);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(218073);
    b localb = this.EhG;
    if (localb != null)
    {
      int i = localb.hashCode();
      AppMethodBeat.o(218073);
      return i;
    }
    AppMethodBeat.o(218073);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(218070);
    String str = "MMLiveItemChangeObj(oldItem=" + this.EhG + ")";
    AppMethodBeat.o(218070);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.livelist.c
 * JD-Core Version:    0.7.0.1
 */