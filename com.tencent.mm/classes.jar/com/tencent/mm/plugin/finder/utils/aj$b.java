package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.g;
import com.tencent.mm.plugin.finder.model.bu;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil$VisibleFeedDataObj;", "", "feedDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "notFeedDataList", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Ljava/util/LinkedList;Ljava/util/LinkedList;)V", "getFeedDataList", "()Ljava/util/LinkedList;", "setFeedDataList", "(Ljava/util/LinkedList;)V", "getNotFeedDataList", "setNotFeedDataList", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
public final class aj$b
{
  public LinkedList<g> AGe;
  public LinkedList<bu> AGf;
  
  private aj$b(LinkedList<g> paramLinkedList, LinkedList<bu> paramLinkedList1)
  {
    AppMethodBeat.i(289224);
    this.AGe = paramLinkedList;
    this.AGf = paramLinkedList1;
    AppMethodBeat.o(289224);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(289228);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.h(this.AGe, paramObject.AGe)) || (!p.h(this.AGf, paramObject.AGf))) {}
      }
    }
    else
    {
      AppMethodBeat.o(289228);
      return true;
    }
    AppMethodBeat.o(289228);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(289227);
    LinkedList localLinkedList = this.AGe;
    if (localLinkedList != null) {}
    for (int i = localLinkedList.hashCode();; i = 0)
    {
      localLinkedList = this.AGf;
      if (localLinkedList != null) {
        j = localLinkedList.hashCode();
      }
      AppMethodBeat.o(289227);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(289226);
    String str = "VisibleFeedDataObj(feedDataList=" + this.AGe + ", notFeedDataList=" + this.AGf + ")";
    AppMethodBeat.o(289226);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.aj.b
 * JD-Core Version:    0.7.0.1
 */