package com.tencent.mm.plugin.game.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/data/MentionUserResultWrapper;", "", "atAllList", "", "Lcom/tencent/mm/plugin/game/chatroom/data/MentionUserWrapper;", "recentlyMentioned", "Lkotlin/Pair;", "", "admins", "members", "(Ljava/util/List;Lkotlin/Pair;Lkotlin/Pair;Lkotlin/Pair;)V", "getAdmins", "()Lkotlin/Pair;", "getAtAllList", "()Ljava/util/List;", "getMembers", "getRecentlyMentioned", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public final List<c> Ikg;
  public final r<Boolean, List<c>> Ikh;
  public final r<Boolean, List<c>> Iki;
  public final r<Boolean, List<c>> Ikj;
  
  private b(List<c> paramList, r<Boolean, ? extends List<c>> paramr1, r<Boolean, ? extends List<c>> paramr2, r<Boolean, ? extends List<c>> paramr3)
  {
    AppMethodBeat.i(275670);
    this.Ikg = paramList;
    this.Ikh = paramr1;
    this.Iki = paramr2;
    this.Ikj = paramr3;
    AppMethodBeat.o(275670);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(275703);
    if (this == paramObject)
    {
      AppMethodBeat.o(275703);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(275703);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.Ikg, paramObject.Ikg))
    {
      AppMethodBeat.o(275703);
      return false;
    }
    if (!s.p(this.Ikh, paramObject.Ikh))
    {
      AppMethodBeat.o(275703);
      return false;
    }
    if (!s.p(this.Iki, paramObject.Iki))
    {
      AppMethodBeat.o(275703);
      return false;
    }
    if (!s.p(this.Ikj, paramObject.Ikj))
    {
      AppMethodBeat.o(275703);
      return false;
    }
    AppMethodBeat.o(275703);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(275699);
    int i = this.Ikg.hashCode();
    int j = this.Ikh.hashCode();
    int k = this.Iki.hashCode();
    int m = this.Ikj.hashCode();
    AppMethodBeat.o(275699);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(275692);
    String str = "MentionUserResultWrapper(atAllList=" + this.Ikg + ", recentlyMentioned=" + this.Ikh + ", admins=" + this.Iki + ", members=" + this.Ikj + ')';
    AppMethodBeat.o(275692);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.d.b
 * JD-Core Version:    0.7.0.1
 */