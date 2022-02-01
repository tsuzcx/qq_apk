package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.g;
import com.tencent.mm.view.recyclerview.a;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil$VisibleFeedDataObj;", "", "feedDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "notFeedDataList", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "(Ljava/util/LinkedList;Ljava/util/LinkedList;)V", "getFeedDataList", "()Ljava/util/LinkedList;", "setFeedDataList", "(Ljava/util/LinkedList;)V", "getNotFeedDataList", "setNotFeedDataList", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
public final class p$b
{
  public LinkedList<g> sXC;
  public LinkedList<a> sXD;
  
  private p$b(LinkedList<g> paramLinkedList, LinkedList<a> paramLinkedList1)
  {
    AppMethodBeat.i(205138);
    this.sXC = paramLinkedList;
    this.sXD = paramLinkedList1;
    AppMethodBeat.o(205138);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205142);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.i(this.sXC, paramObject.sXC)) || (!p.i(this.sXD, paramObject.sXD))) {}
      }
    }
    else
    {
      AppMethodBeat.o(205142);
      return true;
    }
    AppMethodBeat.o(205142);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(205141);
    LinkedList localLinkedList = this.sXC;
    if (localLinkedList != null) {}
    for (int i = localLinkedList.hashCode();; i = 0)
    {
      localLinkedList = this.sXD;
      if (localLinkedList != null) {
        j = localLinkedList.hashCode();
      }
      AppMethodBeat.o(205141);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205140);
    String str = "VisibleFeedDataObj(feedDataList=" + this.sXC + ", notFeedDataList=" + this.sXD + ")";
    AppMethodBeat.o(205140);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.p.b
 * JD-Core Version:    0.7.0.1
 */