package com.tencent.mm.plugin.finder.conv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderGlobalPushNewXmlConsumer$NotificationInfo;", "", "id", "", "(I)V", "getId", "()I", "isInnerPush", "", "()Z", "setInnerPush", "(Z)V", "component1", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$d
{
  boolean AGm;
  final int id;
  
  public i$d(int paramInt)
  {
    this.id = paramInt;
    this.AGm = true;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof d)) {
        return false;
      }
      paramObject = (d)paramObject;
    } while (this.id == paramObject.id);
    return false;
  }
  
  public final int hashCode()
  {
    return this.id;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(336103);
    String str = this.id + '@' + this.AGm;
    AppMethodBeat.o(336103);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.i.d
 * JD-Core Version:    0.7.0.1
 */