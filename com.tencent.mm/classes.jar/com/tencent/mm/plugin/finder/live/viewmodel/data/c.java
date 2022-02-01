package com.tencent.mm.plugin.finder.live.viewmodel.data;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/EventWrapper;", "", "event", "", "bundle", "Landroid/os/Bundle;", "anyData", "(Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/Object;)V", "getAnyData", "()Ljava/lang/Object;", "setAnyData", "(Ljava/lang/Object;)V", "getBundle", "()Landroid/os/Bundle;", "setBundle", "(Landroid/os/Bundle;)V", "getEvent", "()Ljava/lang/String;", "setEvent", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public Object Ebp;
  public Bundle bundle;
  public String event;
  
  public c(String paramString, Bundle paramBundle, Object paramObject)
  {
    this.event = paramString;
    this.bundle = paramBundle;
    this.Ebp = paramObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(356561);
    if (this == paramObject)
    {
      AppMethodBeat.o(356561);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(356561);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.event, paramObject.event))
    {
      AppMethodBeat.o(356561);
      return false;
    }
    if (!s.p(this.bundle, paramObject.bundle))
    {
      AppMethodBeat.o(356561);
      return false;
    }
    if (!s.p(this.Ebp, paramObject.Ebp))
    {
      AppMethodBeat.o(356561);
      return false;
    }
    AppMethodBeat.o(356561);
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(356555);
    int i;
    int j;
    if (this.event == null)
    {
      i = 0;
      if (this.bundle != null) {
        break label60;
      }
      j = 0;
      label25:
      if (this.Ebp != null) {
        break label71;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(356555);
      return (j + i * 31) * 31 + k;
      i = this.event.hashCode();
      break;
      label60:
      j = this.bundle.hashCode();
      break label25;
      label71:
      k = this.Ebp.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(356550);
    String str = "StateWrapper:" + this.event + ',' + this.bundle;
    AppMethodBeat.o(356550);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.c
 * JD-Core Version:    0.7.0.1
 */