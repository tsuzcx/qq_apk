package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/SyncGetImageModel$DynamicIconInfo;", "", "iconName", "", "iconNodeStartPos", "iconNodeEndPos", "(III)V", "getIconName", "()I", "getIconNodeEndPos", "getIconNodeStartPos", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cg$b
{
  final int EDZ;
  final int EEa;
  final int EEb;
  
  public cg$b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.EDZ = paramInt1;
    this.EEa = paramInt2;
    this.EEb = paramInt3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
      if (this.EDZ != paramObject.EDZ) {
        return false;
      }
      if (this.EEa != paramObject.EEa) {
        return false;
      }
    } while (this.EEb == paramObject.EEb);
    return false;
  }
  
  public final int hashCode()
  {
    return (this.EDZ * 31 + this.EEa) * 31 + this.EEb;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(332147);
    String str = "DynamicIconInfo(iconName=" + this.EDZ + ", iconNodeStartPos=" + this.EEa + ", iconNodeEndPos=" + this.EEb + ')';
    AppMethodBeat.o(332147);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.cg.b
 * JD-Core Version:    0.7.0.1
 */