package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Result;", "", "readTime", "", "writeTime", "size", "", "(JJI)V", "getReadTime", "()J", "setReadTime", "(J)V", "getSize", "()I", "getWriteTime", "setWriteTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-appbrand-integration_release"})
final class e$b
{
  long rry;
  long rrz;
  final int size;
  
  public e$b(long paramLong1, long paramLong2, int paramInt)
  {
    this.rry = paramLong1;
    this.rrz = paramLong2;
    this.size = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.rry != paramObject.rry) || (this.rrz != paramObject.rrz) || (this.size != paramObject.size)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    long l = this.rry;
    int i = (int)(l ^ l >>> 32);
    l = this.rrz;
    return (i * 31 + (int)(l ^ l >>> 32)) * 31 + this.size;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(50212);
    String str = "Result(readTime=" + this.rry + ", writeTime=" + this.rrz + ", size=" + this.size + ")";
    AppMethodBeat.o(50212);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.e.b
 * JD-Core Version:    0.7.0.1
 */