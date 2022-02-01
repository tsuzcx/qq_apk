package com.tencent.mm.plugin.finder.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/FinderLiveAdNoticeCache$CacheKey;", "", "username", "", "noticeId", "(Ljava/lang/String;Ljava/lang/String;)V", "getNoticeId", "()Ljava/lang/String;", "getUsername", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"})
public final class a$a
{
  private final String dDJ;
  private final String username;
  
  public a$a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(245774);
    this.username = paramString1;
    this.dDJ = paramString2;
    AppMethodBeat.o(245774);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(245777);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.j(this.username, paramObject.username)) || (!p.j(this.dDJ, paramObject.dDJ))) {}
      }
    }
    else
    {
      AppMethodBeat.o(245777);
      return true;
    }
    AppMethodBeat.o(245777);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(245776);
    String str = this.username;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.dDJ;
      if (str != null) {
        j = str.hashCode();
      }
      AppMethodBeat.o(245776);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(245775);
    String str = "CacheKey(username=" + this.username + ", noticeId=" + this.dDJ + ")";
    AppMethodBeat.o(245775);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.a.a
 * JD-Core Version:    0.7.0.1
 */