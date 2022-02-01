package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/magicbrush/V8RawPointer;", "", "isolatePtr", "", "contextPtr", "uvLoopPtr", "(JJJ)V", "getContextPtr", "()J", "getIsolatePtr", "getUvLoopPtr", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib-magicbrush-nano_release"})
public final class ad
{
  final long cpZ;
  final long cqa;
  final long cqb;
  
  public ad(long paramLong1, long paramLong2, long paramLong3)
  {
    this.cpZ = paramLong1;
    this.cqa = paramLong2;
    this.cqb = paramLong3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof ad))
      {
        paramObject = (ad)paramObject;
        if ((this.cpZ != paramObject.cpZ) || (this.cqa != paramObject.cqa) || (this.cqb != paramObject.cqb)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    long l = this.cpZ;
    int i = (int)(l ^ l >>> 32);
    l = this.cqa;
    int j = (int)(l ^ l >>> 32);
    l = this.cqb;
    return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140187);
    String str = "V8RawPointer(isolatePtr=" + this.cpZ + ", contextPtr=" + this.cqa + ", uvLoopPtr=" + this.cqb + ")";
    AppMethodBeat.o(140187);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.ad
 * JD-Core Version:    0.7.0.1
 */