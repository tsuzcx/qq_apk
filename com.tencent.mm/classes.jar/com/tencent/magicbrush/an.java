package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/V8RawPointer;", "", "isolatePtr", "", "contextPtr", "uvLoopPtr", "(JJJ)V", "getContextPtr", "()J", "getIsolatePtr", "getUvLoopPtr", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
public final class an
{
  public final long eIH;
  public final long eII;
  public final long eIJ;
  
  public an(long paramLong1, long paramLong2, long paramLong3)
  {
    this.eIH = paramLong1;
    this.eII = paramLong2;
    this.eIJ = paramLong3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof an))
      {
        paramObject = (an)paramObject;
        if ((this.eIH != paramObject.eIH) || (this.eII != paramObject.eII) || (this.eIJ != paramObject.eIJ)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    long l = this.eIH;
    int i = (int)(l ^ l >>> 32);
    l = this.eII;
    int j = (int)(l ^ l >>> 32);
    l = this.eIJ;
    return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140187);
    String str = "V8RawPointer(isolatePtr=" + this.eIH + ", contextPtr=" + this.eII + ", uvLoopPtr=" + this.eIJ + ")";
    AppMethodBeat.o(140187);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.magicbrush.an
 * JD-Core Version:    0.7.0.1
 */