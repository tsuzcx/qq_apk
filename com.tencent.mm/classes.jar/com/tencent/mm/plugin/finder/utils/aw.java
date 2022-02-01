package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/PlayTimeCostRecord;", "", "clickTime", "", "clickToPlayTimeCost", "", "selectToPlayTimeCost", "(JII)V", "getClickTime", "()J", "getClickToPlayTimeCost", "()I", "setClickToPlayTimeCost", "(I)V", "getSelectToPlayTimeCost", "setSelectToPlayTimeCost", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class aw
{
  int AJA;
  int AJB;
  final long qLu;
  
  public aw(long paramLong, int paramInt)
  {
    this.qLu = paramLong;
    this.AJA = 0;
    this.AJB = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof aw))
      {
        paramObject = (aw)paramObject;
        if ((this.qLu != paramObject.qLu) || (this.AJA != paramObject.AJA) || (this.AJB != paramObject.AJB)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    long l = this.qLu;
    return ((int)(l ^ l >>> 32) * 31 + this.AJA) * 31 + this.AJB;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(235242);
    String str = "PlayTimeCostRecord(clickTime=" + this.qLu + ", clickToPlayTimeCost=" + this.AJA + ", selectToPlayTimeCost=" + this.AJB + ")";
    AppMethodBeat.o(235242);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.aw
 * JD-Core Version:    0.7.0.1
 */