package com.tencent.mm.plugin.finder.utils;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/PlayTimeCostRecord;", "", "clickTime", "", "clickToPlayTimeCost", "", "selectToPlayTimeCost", "(JII)V", "getClickTime", "()J", "getClickToPlayTimeCost", "()I", "setClickToPlayTimeCost", "(I)V", "getSelectToPlayTimeCost", "setSelectToPlayTimeCost", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bn
{
  int Gmo;
  int Gmp;
  final long tQb;
  
  public bn(long paramLong, int paramInt)
  {
    this.tQb = paramLong;
    this.Gmo = 0;
    this.Gmp = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof bn)) {
        return false;
      }
      paramObject = (bn)paramObject;
      if (this.tQb != paramObject.tQb) {
        return false;
      }
      if (this.Gmo != paramObject.Gmo) {
        return false;
      }
    } while (this.Gmp == paramObject.Gmp);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(333125);
    int i = q.a..ExternalSyntheticBackport0.m(this.tQb);
    int j = this.Gmo;
    int k = this.Gmp;
    AppMethodBeat.o(333125);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(333118);
    String str = "PlayTimeCostRecord(clickTime=" + this.tQb + ", clickToPlayTimeCost=" + this.Gmo + ", selectToPlayTimeCost=" + this.Gmp + ')';
    AppMethodBeat.o(333118);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.bn
 * JD-Core Version:    0.7.0.1
 */