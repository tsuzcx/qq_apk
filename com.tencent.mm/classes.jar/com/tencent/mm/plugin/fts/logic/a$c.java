package com.tencent.mm.plugin.fts.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/logic/FTS5SearchChatroomMemberLogic$ChatroomMemberObj;", "", "username", "", "memberList", "(Ljava/lang/String;Ljava/lang/String;)V", "getMemberList", "()Ljava/lang/String;", "getUsername", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$c
{
  final String HuL;
  final String username;
  
  public a$c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(265501);
    this.username = paramString1;
    this.HuL = paramString2;
    AppMethodBeat.o(265501);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(265512);
    if (this == paramObject)
    {
      AppMethodBeat.o(265512);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(265512);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.username, paramObject.username))
    {
      AppMethodBeat.o(265512);
      return false;
    }
    if (!s.p(this.HuL, paramObject.HuL))
    {
      AppMethodBeat.o(265512);
      return false;
    }
    AppMethodBeat.o(265512);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(265510);
    int i = this.username.hashCode();
    int j = this.HuL.hashCode();
    AppMethodBeat.o(265510);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(265503);
    String str = "ChatroomMemberObj(username=" + this.username + ", memberList=" + this.HuL + ')';
    AppMethodBeat.o(265503);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.logic.a.c
 * JD-Core Version:    0.7.0.1
 */