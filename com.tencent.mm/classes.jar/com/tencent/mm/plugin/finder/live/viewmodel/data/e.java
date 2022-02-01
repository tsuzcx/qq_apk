package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveBattlePlayerInfo;", "", "username", "", "wecoinHot", "", "(Ljava/lang/String;J)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "getWecoinHot", "()J", "setWecoinHot", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder-base_release"})
public final class e
{
  public String username;
  public long zeu;
  
  public e(String paramString, long paramLong)
  {
    this.username = paramString;
    this.zeu = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(258072);
    if (this != paramObject)
    {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        if ((!p.h(this.username, paramObject.username)) || (this.zeu != paramObject.zeu)) {}
      }
    }
    else
    {
      AppMethodBeat.o(258072);
      return true;
    }
    AppMethodBeat.o(258072);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(258071);
    String str = this.username;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = this.zeu;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(258071);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(258070);
    String str = "FinderLiveBattlePlayerInfo(username=" + this.username + ", wecoinHot=" + this.zeu + ")";
    AppMethodBeat.o(258070);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.e
 * JD-Core Version:    0.7.0.1
 */