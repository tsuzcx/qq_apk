package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 13}, gka={""}, gkb={"Lcom/tencent/magicbrush/V8RawPointer;", "", "isolatePtr", "", "contextPtr", "uvLoopPtr", "(JJJ)V", "getContextPtr", "()J", "getIsolatePtr", "getUvLoopPtr", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib-magicbrush-nano_release"})
public final class ai
{
  final long cys;
  final long cyt;
  final long cyu;
  
  public ai(long paramLong1, long paramLong2, long paramLong3)
  {
    this.cys = paramLong1;
    this.cyt = paramLong2;
    this.cyu = paramLong3;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this != paramObject)
    {
      bool1 = bool2;
      if (!(paramObject instanceof ai)) {
        break label88;
      }
      paramObject = (ai)paramObject;
      if (this.cys != paramObject.cys) {
        break label90;
      }
      i = 1;
      bool1 = bool2;
      if (i == 0) {
        break label88;
      }
      if (this.cyt != paramObject.cyt) {
        break label95;
      }
      i = 1;
      label58:
      bool1 = bool2;
      if (i == 0) {
        break label88;
      }
      if (this.cyu != paramObject.cyu) {
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
    long l = this.cys;
    int i = (int)(l ^ l >>> 32);
    l = this.cyt;
    int j = (int)(l ^ l >>> 32);
    l = this.cyu;
    return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140187);
    String str = "V8RawPointer(isolatePtr=" + this.cys + ", contextPtr=" + this.cyt + ", uvLoopPtr=" + this.cyu + ")";
    AppMethodBeat.o(140187);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.ai
 * JD-Core Version:    0.7.0.1
 */