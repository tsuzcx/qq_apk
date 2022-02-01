package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/event/base/DataChangeEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "centerFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getCenterFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setCenterFeed", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "centerFeedId", "", "getCenterFeedId", "()J", "setCenterFeedId", "(J)V", "centerMediaId", "", "getCenterMediaId", "()Ljava/lang/String;", "setCenterMediaId", "(Ljava/lang/String;)V", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "()I", "setFirstVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "payload", "", "getPayload", "()Ljava/lang/Object;", "setPayload", "(Ljava/lang/Object;)V", "getType", "setType", "component1", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "plugin-finder-base_release"})
public final class a
  extends b
{
  public static final a xqF;
  
  static
  {
    AppMethodBeat.i(165539);
    xqF = new a((byte)0);
    AppMethodBeat.o(165539);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(165541);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        AppMethodBeat.o(165541);
        throw null;
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
    AppMethodBeat.o(165540);
    throw null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(165536);
    AppMethodBeat.o(165536);
    throw null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/event/base/DataChangeEvent$Companion;", "", "()V", "DATA_CHANGE", "", "DATA_INSERT", "DATA_LOAD_MORE", "DATA_REFRESH", "DATA_REMOVE", "plugin-finder-base_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.a
 * JD-Core Version:    0.7.0.1
 */