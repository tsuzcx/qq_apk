package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/WxaAttrStorageNotifyEvent;", "Lcom/tencent/mm/sdk/event/IEvent;", "event", "", "eventId", "", "obj", "", "(Ljava/lang/String;ILjava/lang/Object;)V", "getEvent", "()Ljava/lang/String;", "getEventId", "()I", "getObj", "()Ljava/lang/Object;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "data-storage_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
  extends IEvent
{
  public final String event;
  private final int eventId;
  public final Object obj;
  
  public ae(String paramString, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(323302);
    this.event = paramString;
    this.eventId = paramInt;
    this.obj = paramObject;
    AppMethodBeat.o(323302);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(323314);
    if (this == paramObject)
    {
      AppMethodBeat.o(323314);
      return true;
    }
    if (!(paramObject instanceof ae))
    {
      AppMethodBeat.o(323314);
      return false;
    }
    paramObject = (ae)paramObject;
    if (!s.p(this.event, paramObject.event))
    {
      AppMethodBeat.o(323314);
      return false;
    }
    if (this.eventId != paramObject.eventId)
    {
      AppMethodBeat.o(323314);
      return false;
    }
    if (!s.p(this.obj, paramObject.obj))
    {
      AppMethodBeat.o(323314);
      return false;
    }
    AppMethodBeat.o(323314);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(323310);
    int j = this.event.hashCode();
    int k = this.eventId;
    if (this.obj == null) {}
    for (int i = 0;; i = this.obj.hashCode())
    {
      AppMethodBeat.o(323310);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(323306);
    String str = "WxaAttrStorageNotifyEvent(event=" + this.event + ", eventId=" + this.eventId + ", obj=" + this.obj + ')';
    AppMethodBeat.o(323306);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.ae
 * JD-Core Version:    0.7.0.1
 */