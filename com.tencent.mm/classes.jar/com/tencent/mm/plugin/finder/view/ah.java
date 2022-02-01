package com.tencent.mm.plugin.finder.view;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/MentionContact;", "", "username", "", "nickname", "start", "", "length", "(Ljava/lang/String;Ljava/lang/String;JJ)V", "getLength", "()J", "matched", "", "getMatched", "()Z", "setMatched", "(Z)V", "getNickname", "()Ljava/lang/String;", "getStart", "setStart", "(J)V", "getUsername", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
{
  boolean FYw;
  public final long length;
  final String nickname;
  public long start;
  public final String username;
  
  public ah(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(344658);
    this.username = paramString1;
    this.nickname = paramString2;
    this.start = paramLong1;
    this.length = paramLong2;
    AppMethodBeat.o(344658);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(344679);
    if (this == paramObject)
    {
      AppMethodBeat.o(344679);
      return true;
    }
    if (!(paramObject instanceof ah))
    {
      AppMethodBeat.o(344679);
      return false;
    }
    paramObject = (ah)paramObject;
    if (!s.p(this.username, paramObject.username))
    {
      AppMethodBeat.o(344679);
      return false;
    }
    if (!s.p(this.nickname, paramObject.nickname))
    {
      AppMethodBeat.o(344679);
      return false;
    }
    if (this.start != paramObject.start)
    {
      AppMethodBeat.o(344679);
      return false;
    }
    if (this.length != paramObject.length)
    {
      AppMethodBeat.o(344679);
      return false;
    }
    AppMethodBeat.o(344679);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(344674);
    int i = this.username.hashCode();
    int j = this.nickname.hashCode();
    int k = q.a..ExternalSyntheticBackport0.m(this.start);
    int m = q.a..ExternalSyntheticBackport0.m(this.length);
    AppMethodBeat.o(344674);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(344666);
    String str = "MentionContact(username='" + this.username + "', nickname='" + this.nickname + "', start=" + this.start + ", length=" + this.length + ')';
    AppMethodBeat.o(344666);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.ah
 * JD-Core Version:    0.7.0.1
 */