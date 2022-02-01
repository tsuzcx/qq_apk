package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.g;
import com.tencent.mm.view.recyclerview.a;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil$VisibleFeedDataObj;", "", "feedDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "notFeedDataList", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "(Ljava/util/LinkedList;Ljava/util/LinkedList;)V", "getFeedDataList", "()Ljava/util/LinkedList;", "setFeedDataList", "(Ljava/util/LinkedList;)V", "getNotFeedDataList", "setNotFeedDataList", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
public final class p$b
{
  public LinkedList<g> sMr;
  public LinkedList<a> sMs;
  
  private p$b(LinkedList<g> paramLinkedList, LinkedList<a> paramLinkedList1)
  {
    AppMethodBeat.i(204518);
    this.sMr = paramLinkedList;
    this.sMs = paramLinkedList1;
    AppMethodBeat.o(204518);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204522);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.i(this.sMr, paramObject.sMr)) || (!p.i(this.sMs, paramObject.sMs))) {}
      }
    }
    else
    {
      AppMethodBeat.o(204522);
      return true;
    }
    AppMethodBeat.o(204522);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(204521);
    LinkedList localLinkedList = this.sMr;
    if (localLinkedList != null) {}
    for (int i = localLinkedList.hashCode();; i = 0)
    {
      localLinkedList = this.sMs;
      if (localLinkedList != null) {
        j = localLinkedList.hashCode();
      }
      AppMethodBeat.o(204521);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204520);
    String str = "VisibleFeedDataObj(feedDataList=" + this.sMr + ", notFeedDataList=" + this.sMs + ")";
    AppMethodBeat.o(204520);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.p.b
 * JD-Core Version:    0.7.0.1
 */