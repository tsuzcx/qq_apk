package com.tencent.mm.plugin.finder.live.viewmodel.data;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/EventWrapper;", "", "event", "", "bundle", "Landroid/os/Bundle;", "anyData", "(Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/Object;)V", "getAnyData", "()Ljava/lang/Object;", "setAnyData", "(Ljava/lang/Object;)V", "getBundle", "()Landroid/os/Bundle;", "setBundle", "(Landroid/os/Bundle;)V", "getEvent", "()Ljava/lang/String;", "setEvent", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder-base_release"})
public final class c
{
  public Bundle bundle;
  public String event;
  public Object zew;
  
  public c(String paramString, Bundle paramBundle, Object paramObject)
  {
    this.event = paramString;
    this.bundle = paramBundle;
    this.zew = paramObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(260768);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((!p.h(this.event, paramObject.event)) || (!p.h(this.bundle, paramObject.bundle)) || (!p.h(this.zew, paramObject.zew))) {}
      }
    }
    else
    {
      AppMethodBeat.o(260768);
      return true;
    }
    AppMethodBeat.o(260768);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(260765);
    Object localObject = this.event;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.bundle;
      if (localObject == null) {
        break label80;
      }
    }
    label80:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.zew;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(260765);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(260763);
    String str = "StateWrapper:" + this.event + ',' + this.bundle;
    AppMethodBeat.o(260763);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.c
 * JD-Core Version:    0.7.0.1
 */