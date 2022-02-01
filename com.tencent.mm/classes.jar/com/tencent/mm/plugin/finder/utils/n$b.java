package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.g;
import com.tencent.mm.view.recyclerview.a;
import d.g.b.k;
import d.l;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil$VisibleFeedDataObj;", "", "feedDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "notFeedDataList", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "(Ljava/util/LinkedList;Ljava/util/LinkedList;)V", "getFeedDataList", "()Ljava/util/LinkedList;", "setFeedDataList", "(Ljava/util/LinkedList;)V", "getNotFeedDataList", "setNotFeedDataList", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
public final class n$b
{
  public LinkedList<g> rPP;
  public LinkedList<a> rPQ;
  
  private n$b(LinkedList<g> paramLinkedList, LinkedList<a> paramLinkedList1)
  {
    AppMethodBeat.i(203638);
    this.rPP = paramLinkedList;
    this.rPQ = paramLinkedList1;
    AppMethodBeat.o(203638);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203642);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!k.g(this.rPP, paramObject.rPP)) || (!k.g(this.rPQ, paramObject.rPQ))) {}
      }
    }
    else
    {
      AppMethodBeat.o(203642);
      return true;
    }
    AppMethodBeat.o(203642);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(203641);
    LinkedList localLinkedList = this.rPP;
    if (localLinkedList != null) {}
    for (int i = localLinkedList.hashCode();; i = 0)
    {
      localLinkedList = this.rPQ;
      if (localLinkedList != null) {
        j = localLinkedList.hashCode();
      }
      AppMethodBeat.o(203641);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203640);
    String str = "VisibleFeedDataObj(feedDataList=" + this.rPP + ", notFeedDataList=" + this.rPQ + ")";
    AppMethodBeat.o(203640);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.n.b
 * JD-Core Version:    0.7.0.1
 */