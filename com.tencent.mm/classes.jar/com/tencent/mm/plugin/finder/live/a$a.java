package com.tencent.mm.plugin.finder.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLiveAdNoticeCache$CacheKey;", "", "username", "", "noticeId", "(Ljava/lang/String;Ljava/lang/String;)V", "getNoticeId", "()Ljava/lang/String;", "getUsername", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"})
public final class a$a
{
  private final String fwt;
  private final String username;
  
  public a$a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(268107);
    this.username = paramString1;
    this.fwt = paramString2;
    AppMethodBeat.o(268107);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(268110);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.h(this.username, paramObject.username)) || (!p.h(this.fwt, paramObject.fwt))) {}
      }
    }
    else
    {
      AppMethodBeat.o(268110);
      return true;
    }
    AppMethodBeat.o(268110);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(268109);
    String str = this.username;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.fwt;
      if (str != null) {
        j = str.hashCode();
      }
      AppMethodBeat.o(268109);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(268108);
    String str = "CacheKey(username=" + this.username + ", noticeId=" + this.fwt + ")";
    AppMethodBeat.o(268108);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.a.a
 * JD-Core Version:    0.7.0.1
 */