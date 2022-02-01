package com.tencent.mm.plugin.finder.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/FinderLiveAdNoticeCache$CacheKey;", "", "username", "", "noticeId", "(Ljava/lang/String;Ljava/lang/String;)V", "getNoticeId", "()Ljava/lang/String;", "getUsername", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  private final String hAR;
  private final String username;
  
  public a$a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(351209);
    this.username = paramString1;
    this.hAR = paramString2;
    AppMethodBeat.o(351209);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(351234);
    if (this == paramObject)
    {
      AppMethodBeat.o(351234);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(351234);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.username, paramObject.username))
    {
      AppMethodBeat.o(351234);
      return false;
    }
    if (!s.p(this.hAR, paramObject.hAR))
    {
      AppMethodBeat.o(351234);
      return false;
    }
    AppMethodBeat.o(351234);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(351225);
    int i = this.username.hashCode();
    int j = this.hAR.hashCode();
    AppMethodBeat.o(351225);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(351217);
    String str = "CacheKey(username=" + this.username + ", noticeId=" + this.hAR + ')';
    AppMethodBeat.o(351217);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.a.a
 * JD-Core Version:    0.7.0.1
 */