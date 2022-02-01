package com.tencent.mm.plugin.appbrand.appstorage;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandEncryptKVStorageTransfer$Result;", "", "readTime", "", "writeTime", "size", "", "(JJI)V", "getReadTime", "()J", "setReadTime", "(J)V", "getSize", "()I", "getWriteTime", "setWriteTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class a$b
{
  long qLI;
  long qLJ;
  final int size;
  
  public a$b(long paramLong1, long paramLong2, int paramInt)
  {
    this.qLI = paramLong1;
    this.qLJ = paramLong2;
    this.size = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
      if (this.qLI != paramObject.qLI) {
        return false;
      }
      if (this.qLJ != paramObject.qLJ) {
        return false;
      }
    } while (this.size == paramObject.size);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(323246);
    int i = q.a..ExternalSyntheticBackport0.m(this.qLI);
    int j = q.a..ExternalSyntheticBackport0.m(this.qLJ);
    int k = this.size;
    AppMethodBeat.o(323246);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(323240);
    String str = "Result(readTime=" + this.qLI + ", writeTime=" + this.qLJ + ", size=" + this.size + ')';
    AppMethodBeat.o(323240);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.a.b
 * JD-Core Version:    0.7.0.1
 */