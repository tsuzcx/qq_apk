package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/event/base/DataChangeEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "centerFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getCenterFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setCenterFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "centerFeedId", "", "getCenterFeedId", "()J", "setCenterFeedId", "(J)V", "centerMediaId", "", "getCenterMediaId", "()Ljava/lang/String;", "setCenterMediaId", "(Ljava/lang/String;)V", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "()I", "setFirstVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "payload", "", "getPayload", "()Ljava/lang/Object;", "setPayload", "(Ljava/lang/Object;)V", "getType", "setType", "component1", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "plugin-finder_release"})
public final class a
  extends b
{
  public static final a rZd;
  private int type;
  
  static
  {
    AppMethodBeat.i(165539);
    rZd = new a((byte)0);
    AppMethodBeat.o(165539);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(165541);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if (this.type != paramObject.type) {}
      }
    }
    else
    {
      AppMethodBeat.o(165541);
      return true;
    }
    AppMethodBeat.o(165541);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(165540);
    int i = this.type;
    AppMethodBeat.o(165540);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(165536);
    String str = "DataChangeEvent(type=" + this.type + ')';
    AppMethodBeat.o(165536);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/event/base/DataChangeEvent$Companion;", "", "()V", "DATA_CHANGE", "", "DATA_INSERT", "DATA_LOAD_MORE", "DATA_REFRESH", "DATA_REMOVE", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.a
 * JD-Core Version:    0.7.0.1
 */