package com.tencent.mm.plugin.finder.live.viewmodel.data;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveBattlePlayerInfo;", "", "username", "", "wecoinHot", "", "(Ljava/lang/String;J)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "getWecoinHot", "()J", "setWecoinHot", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public long Ebj;
  public String username;
  
  public e(String paramString, long paramLong)
  {
    this.username = paramString;
    this.Ebj = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(356574);
    if (this == paramObject)
    {
      AppMethodBeat.o(356574);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(356574);
      return false;
    }
    paramObject = (e)paramObject;
    if (!s.p(this.username, paramObject.username))
    {
      AppMethodBeat.o(356574);
      return false;
    }
    if (this.Ebj != paramObject.Ebj)
    {
      AppMethodBeat.o(356574);
      return false;
    }
    AppMethodBeat.o(356574);
    return true;
  }
  
  public final String getUsername()
  {
    return this.username;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(356567);
    if (this.username == null) {}
    for (int i = 0;; i = this.username.hashCode())
    {
      int j = q.a..ExternalSyntheticBackport0.m(this.Ebj);
      AppMethodBeat.o(356567);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(356560);
    String str = "FinderLiveBattlePlayerInfo(username=" + this.username + ", wecoinHot=" + this.Ebj + ')';
    AppMethodBeat.o(356560);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.e
 * JD-Core Version:    0.7.0.1
 */