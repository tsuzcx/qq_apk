package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.g;
import com.tencent.mm.plugin.finder.model.bo;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil$VisibleFeedDataObj;", "", "feedDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "notFeedDataList", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Ljava/util/LinkedList;Ljava/util/LinkedList;)V", "getFeedDataList", "()Ljava/util/LinkedList;", "setFeedDataList", "(Ljava/util/LinkedList;)V", "getNotFeedDataList", "setNotFeedDataList", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
public final class y$b
{
  public LinkedList<g> vXL;
  public LinkedList<bo> vXM;
  
  private y$b(LinkedList<g> paramLinkedList, LinkedList<bo> paramLinkedList1)
  {
    AppMethodBeat.i(253565);
    this.vXL = paramLinkedList;
    this.vXM = paramLinkedList1;
    AppMethodBeat.o(253565);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(253569);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.j(this.vXL, paramObject.vXL)) || (!p.j(this.vXM, paramObject.vXM))) {}
      }
    }
    else
    {
      AppMethodBeat.o(253569);
      return true;
    }
    AppMethodBeat.o(253569);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(253568);
    LinkedList localLinkedList = this.vXL;
    if (localLinkedList != null) {}
    for (int i = localLinkedList.hashCode();; i = 0)
    {
      localLinkedList = this.vXM;
      if (localLinkedList != null) {
        j = localLinkedList.hashCode();
      }
      AppMethodBeat.o(253568);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(253567);
    String str = "VisibleFeedDataObj(feedDataList=" + this.vXL + ", notFeedDataList=" + this.vXM + ")";
    AppMethodBeat.o(253567);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.y.b
 * JD-Core Version:    0.7.0.1
 */