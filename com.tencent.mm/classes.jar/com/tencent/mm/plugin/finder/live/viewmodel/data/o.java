package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/ScreenDeviceData;", "", "displayName", "", "id", "(Ljava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  public final String displayName;
  private final String id;
  
  public o(String paramString1, String paramString2)
  {
    this.displayName = paramString1;
    this.id = paramString2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(356860);
    if (this == paramObject)
    {
      AppMethodBeat.o(356860);
      return true;
    }
    if (!(paramObject instanceof o))
    {
      AppMethodBeat.o(356860);
      return false;
    }
    paramObject = (o)paramObject;
    if (!s.p(this.displayName, paramObject.displayName))
    {
      AppMethodBeat.o(356860);
      return false;
    }
    if (!s.p(this.id, paramObject.id))
    {
      AppMethodBeat.o(356860);
      return false;
    }
    AppMethodBeat.o(356860);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(356849);
    int i;
    if (this.displayName == null)
    {
      i = 0;
      if (this.id != null) {
        break label46;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(356849);
      return i * 31 + j;
      i = this.displayName.hashCode();
      break;
      label46:
      j = this.id.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(356842);
    String str = "ScreenDeviceData(displayName=" + this.displayName + ", id=" + this.id + ')';
    AppMethodBeat.o(356842);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.o
 * JD-Core Version:    0.7.0.1
 */