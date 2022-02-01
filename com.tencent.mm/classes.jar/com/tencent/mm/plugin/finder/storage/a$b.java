package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/FinderActionStorage$FeedAndNonceId;", "", "feedId", "", "objectNonceId", "", "(JLjava/lang/String;)V", "getFeedId", "()J", "getObjectNonceId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"})
public final class a$b
{
  public final long duw;
  public final String objectNonceId;
  
  public a$b(long paramLong, String paramString)
  {
    AppMethodBeat.i(166881);
    this.duw = paramLong;
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
        if ((this.duw != paramObject.duw) || (!p.i(this.objectNonceId, paramObject.objectNonceId))) {}
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
    long l = this.duw;
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
    String str = "FeedAndNonceId(feedId=" + this.duw + ", objectNonceId=" + this.objectNonceId + ")";
    AppMethodBeat.o(166882);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.a.b
 * JD-Core Version:    0.7.0.1
 */