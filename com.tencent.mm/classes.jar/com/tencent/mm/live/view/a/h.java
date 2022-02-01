package com.tencent.mm.live.view.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/adapter/ShareRoomItem;", "", "username", "", "memberCount", "", "(Ljava/lang/String;I)V", "getMemberCount", "()I", "setMemberCount", "(I)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
public final class h
{
  int dRN;
  String username;
  
  public h(String paramString, int paramInt)
  {
    AppMethodBeat.i(208686);
    this.username = paramString;
    this.dRN = paramInt;
    AppMethodBeat.o(208686);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(208689);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((!p.j(this.username, paramObject.username)) || (this.dRN != paramObject.dRN)) {}
      }
    }
    else
    {
      AppMethodBeat.o(208689);
      return true;
    }
    AppMethodBeat.o(208689);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(208688);
    String str = this.username;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int j = this.dRN;
      AppMethodBeat.o(208688);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(208687);
    String str = "ShareRoomItem(username=" + this.username + ", memberCount=" + this.dRN + ")";
    AppMethodBeat.o(208687);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.a.h
 * JD-Core Version:    0.7.0.1
 */