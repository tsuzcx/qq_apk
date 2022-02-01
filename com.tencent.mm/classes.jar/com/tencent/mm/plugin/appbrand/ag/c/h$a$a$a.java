package com.tencent.mm.plugin.appbrand.ag.c;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/thumb/ThumbCdnResourceLoader$Companion$CdnDownloadManager$SubTaskInfo;", "", "downloadOffset", "", "downloadLength", "(JJ)V", "getDownloadLength", "()J", "setDownloadLength", "(J)V", "getDownloadOffset", "setDownloadOffset", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h$a$a$a
{
  long utT;
  long utU;
  
  public h$a$a$a(long paramLong1, long paramLong2)
  {
    this.utT = paramLong1;
    this.utU = paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      if (this.utT != paramObject.utT) {
        return false;
      }
    } while (this.utU == paramObject.utU);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(317879);
    int i = q.a..ExternalSyntheticBackport0.m(this.utT);
    int j = q.a..ExternalSyntheticBackport0.m(this.utU);
    AppMethodBeat.o(317879);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(317861);
    String str = "SubTaskInfo(downloadOffset=" + this.utT + ", downloadLength=" + this.utU + ')';
    AppMethodBeat.o(317861);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.c.h.a.a.a
 * JD-Core Version:    0.7.0.1
 */