package com.tencent.mm.plugin.finder.storage;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderActionStorage$FeedAndNonceId;", "", "feedId", "", "objectNonceId", "", "(JLjava/lang/String;)V", "getFeedId", "()J", "getObjectNonceId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
{
  public final long feedId;
  public final String objectNonceId;
  
  public a$b(long paramLong, String paramString)
  {
    AppMethodBeat.i(166881);
    this.feedId = paramLong;
    this.objectNonceId = paramString;
    AppMethodBeat.o(166881);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(166884);
    if (this == paramObject)
    {
      AppMethodBeat.o(166884);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(166884);
      return false;
    }
    paramObject = (b)paramObject;
    if (this.feedId != paramObject.feedId)
    {
      AppMethodBeat.o(166884);
      return false;
    }
    if (!s.p(this.objectNonceId, paramObject.objectNonceId))
    {
      AppMethodBeat.o(166884);
      return false;
    }
    AppMethodBeat.o(166884);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(166883);
    int i = q.a..ExternalSyntheticBackport0.m(this.feedId);
    int j = this.objectNonceId.hashCode();
    AppMethodBeat.o(166883);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(166882);
    String str = "FeedAndNonceId(feedId=" + this.feedId + ", objectNonceId=" + this.objectNonceId + ')';
    AppMethodBeat.o(166882);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.a.b
 * JD-Core Version:    0.7.0.1
 */