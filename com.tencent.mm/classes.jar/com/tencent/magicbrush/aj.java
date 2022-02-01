package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/magicbrush/V8RawPointer;", "", "isolatePtr", "", "contextPtr", "uvLoopPtr", "(JJJ)V", "getContextPtr", "()J", "getIsolatePtr", "getUvLoopPtr", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib-magicbrush-nano_release"})
public final class aj
{
  final long cMA;
  final long cMB;
  final long cMz;
  
  public aj(long paramLong1, long paramLong2, long paramLong3)
  {
    this.cMz = paramLong1;
    this.cMA = paramLong2;
    this.cMB = paramLong3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof aj))
      {
        paramObject = (aj)paramObject;
        if ((this.cMz != paramObject.cMz) || (this.cMA != paramObject.cMA) || (this.cMB != paramObject.cMB)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    long l = this.cMz;
    int i = (int)(l ^ l >>> 32);
    l = this.cMA;
    int j = (int)(l ^ l >>> 32);
    l = this.cMB;
    return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140187);
    String str = "V8RawPointer(isolatePtr=" + this.cMz + ", contextPtr=" + this.cMA + ", uvLoopPtr=" + this.cMB + ")";
    AppMethodBeat.o(140187);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.aj
 * JD-Core Version:    0.7.0.1
 */