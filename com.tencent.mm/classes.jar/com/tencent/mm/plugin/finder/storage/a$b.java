package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderActionStorage$FeedAndNonceId;", "", "feedId", "", "objectNonceId", "", "(JLjava/lang/String;)V", "getFeedId", "()J", "getObjectNonceId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"})
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
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.feedId != paramObject.feedId) || (!p.j(this.objectNonceId, paramObject.objectNonceId))) {}
      }
    }
    else
    {
      AppMethodBeat.o(166884);
      return true;
    }
    AppMethodBeat.o(166884);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(166883);
    long l = this.feedId;
    int j = (int)(l ^ l >>> 32);
    String str = this.objectNonceId;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      AppMethodBeat.o(166883);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(166882);
    String str = "FeedAndNonceId(feedId=" + this.feedId + ", objectNonceId=" + this.objectNonceId + ")";
    AppMethodBeat.o(166882);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.a.b
 * JD-Core Version:    0.7.0.1
 */