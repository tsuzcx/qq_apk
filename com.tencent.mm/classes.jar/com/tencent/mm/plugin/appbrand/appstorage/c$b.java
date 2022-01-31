package com.tencent.mm.plugin.appbrand.appstorage;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Result;", "", "readTime", "", "writeTime", "size", "", "(JJI)V", "getReadTime", "()J", "setReadTime", "(J)V", "getSize", "()I", "getWriteTime", "setWriteTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-appbrand-integration_release"})
final class c$b
{
  long gZg;
  long gZh;
  final int size;
  
  public c$b(long paramLong1, long paramLong2, int paramInt)
  {
    this.gZg = paramLong1;
    this.gZh = paramLong2;
    this.size = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this != paramObject)
    {
      bool1 = bool2;
      if (!(paramObject instanceof b)) {
        break label87;
      }
      paramObject = (b)paramObject;
      if (this.gZg != paramObject.gZg) {
        break label89;
      }
      i = 1;
      bool1 = bool2;
      if (i == 0) {
        break label87;
      }
      if (this.gZh != paramObject.gZh) {
        break label94;
      }
      i = 1;
      label58:
      bool1 = bool2;
      if (i == 0) {
        break label87;
      }
      if (this.size != paramObject.size) {
        break label99;
      }
    }
    label87:
    label89:
    label94:
    label99:
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
    long l = this.gZg;
    int i = (int)(l ^ l >>> 32);
    l = this.gZh;
    return (i * 31 + (int)(l ^ l >>> 32)) * 31 + this.size;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(134480);
    String str = "Result(readTime=" + this.gZg + ", writeTime=" + this.gZh + ", size=" + this.size + ")";
    AppMethodBeat.o(134480);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.c.b
 * JD-Core Version:    0.7.0.1
 */