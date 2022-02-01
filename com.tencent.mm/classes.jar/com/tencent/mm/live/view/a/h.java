package com.tencent.mm.live.view.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/view/adapter/ShareRoomItem;", "", "username", "", "memberCount", "", "(Ljava/lang/String;I)V", "getMemberCount", "()I", "setMemberCount", "(I)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
public final class h
{
  int dyW;
  String username;
  
  public h(String paramString, int paramInt)
  {
    AppMethodBeat.i(213082);
    this.username = paramString;
    this.dyW = paramInt;
    AppMethodBeat.o(213082);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(213085);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((!p.i(this.username, paramObject.username)) || (this.dyW != paramObject.dyW)) {}
      }
    }
    else
    {
      AppMethodBeat.o(213085);
      return true;
    }
    AppMethodBeat.o(213085);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(213084);
    String str = this.username;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int j = this.dyW;
      AppMethodBeat.o(213084);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(213083);
    String str = "ShareRoomItem(username=" + this.username + ", memberCount=" + this.dyW + ")";
    AppMethodBeat.o(213083);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.a.h
 * JD-Core Version:    0.7.0.1
 */