package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/base/DataChangeEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "centerFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getCenterFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setCenterFeed", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "centerFeedId", "", "getCenterFeedId", "()J", "setCenterFeedId", "(J)V", "centerMediaId", "", "getCenterMediaId", "()Ljava/lang/String;", "setCenterMediaId", "(Ljava/lang/String;)V", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "()I", "setFirstVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "payload", "", "getPayload", "()Ljava/lang/Object;", "setPayload", "(Ljava/lang/Object;)V", "getType", "setType", "component1", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b
{
  public static final a ANS;
  
  static
  {
    AppMethodBeat.i(165539);
    ANS = new a((byte)0);
    AppMethodBeat.o(165539);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(165541);
    if (this == paramObject)
    {
      AppMethodBeat.o(165541);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(165541);
      return false;
    }
    AppMethodBeat.o(165541);
    throw null;
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/base/DataChangeEvent$Companion;", "", "()V", "DATA_CHANGE", "", "DATA_INSERT", "DATA_LOAD_MORE", "DATA_REFRESH", "DATA_REMOVE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.a
 * JD-Core Version:    0.7.0.1
 */