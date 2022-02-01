package com.tencent.mm.plugin.finder.uniComments;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/MentionContact;", "", "username", "", "nickname", "start", "", "length", "(Ljava/lang/String;Ljava/lang/String;JJ)V", "getLength", "()J", "matched", "", "getMatched", "()Z", "setMatched", "(Z)V", "getNickname", "()Ljava/lang/String;", "getStart", "setStart", "(J)V", "getUsername", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  boolean FYw;
  private final long length;
  final String nickname;
  long start;
  final String username;
  
  public a(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(341407);
    this.username = paramString1;
    this.nickname = paramString2;
    this.start = -1L;
    this.length = paramLong;
    AppMethodBeat.o(341407);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(341422);
    if (this == paramObject)
    {
      AppMethodBeat.o(341422);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(341422);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.username, paramObject.username))
    {
      AppMethodBeat.o(341422);
      return false;
    }
    if (!s.p(this.nickname, paramObject.nickname))
    {
      AppMethodBeat.o(341422);
      return false;
    }
    if (this.start != paramObject.start)
    {
      AppMethodBeat.o(341422);
      return false;
    }
    if (this.length != paramObject.length)
    {
      AppMethodBeat.o(341422);
      return false;
    }
    AppMethodBeat.o(341422);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(341416);
    int i = this.username.hashCode();
    int j = this.nickname.hashCode();
    int k = q.a..ExternalSyntheticBackport0.m(this.start);
    int m = q.a..ExternalSyntheticBackport0.m(this.length);
    AppMethodBeat.o(341416);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(341411);
    String str = "MentionContact(username='" + this.username + "', nickname='" + this.nickname + "', start=" + this.start + ", length=" + this.length + ')';
    AppMethodBeat.o(341411);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.a
 * JD-Core Version:    0.7.0.1
 */