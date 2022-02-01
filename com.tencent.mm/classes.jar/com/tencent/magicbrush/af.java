package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 13}, fNZ={""}, fOa={"Lcom/tencent/magicbrush/V8RawPointer;", "", "isolatePtr", "", "contextPtr", "uvLoopPtr", "(JJJ)V", "getContextPtr", "()J", "getIsolatePtr", "getUvLoopPtr", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib-magicbrush-nano_release"})
public final class af
{
  final long cng;
  final long cnh;
  final long cni;
  
  public af(long paramLong1, long paramLong2, long paramLong3)
  {
    this.cng = paramLong1;
    this.cnh = paramLong2;
    this.cni = paramLong3;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this != paramObject)
    {
      bool1 = bool2;
      if (!(paramObject instanceof af)) {
        break label88;
      }
      paramObject = (af)paramObject;
      if (this.cng != paramObject.cng) {
        break label90;
      }
      i = 1;
      bool1 = bool2;
      if (i == 0) {
        break label88;
      }
      if (this.cnh != paramObject.cnh) {
        break label95;
      }
      i = 1;
      label58:
      bool1 = bool2;
      if (i == 0) {
        break label88;
      }
      if (this.cni != paramObject.cni) {
        break label100;
      }
    }
    label88:
    label90:
    label95:
    label100:
    for (int i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
      return bool1;
      i = 0;
      break;
      i = 0;
      break label58;
    }
  }
  
  public final int hashCode()
  {
    long l = this.cng;
    int i = (int)(l ^ l >>> 32);
    l = this.cnh;
    int j = (int)(l ^ l >>> 32);
    l = this.cni;
    return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140187);
    String str = "V8RawPointer(isolatePtr=" + this.cng + ", contextPtr=" + this.cnh + ", uvLoopPtr=" + this.cni + ")";
    AppMethodBeat.o(140187);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.af
 * JD-Core Version:    0.7.0.1
 */