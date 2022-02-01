package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/magicbrush/V8RawPointer;", "", "isolatePtr", "", "contextPtr", "uvLoopPtr", "(JJJ)V", "getContextPtr", "()J", "getIsolatePtr", "getUvLoopPtr", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib-magicbrush-nano_release"})
public final class al
{
  final long cNm;
  final long cNn;
  final long cNo;
  
  public al(long paramLong1, long paramLong2, long paramLong3)
  {
    this.cNm = paramLong1;
    this.cNn = paramLong2;
    this.cNo = paramLong3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof al))
      {
        paramObject = (al)paramObject;
        if ((this.cNm != paramObject.cNm) || (this.cNn != paramObject.cNn) || (this.cNo != paramObject.cNo)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    long l = this.cNm;
    int i = (int)(l ^ l >>> 32);
    l = this.cNn;
    int j = (int)(l ^ l >>> 32);
    l = this.cNo;
    return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140187);
    String str = "V8RawPointer(isolatePtr=" + this.cNm + ", contextPtr=" + this.cNn + ", uvLoopPtr=" + this.cNo + ")";
    AppMethodBeat.o(140187);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.magicbrush.al
 * JD-Core Version:    0.7.0.1
 */