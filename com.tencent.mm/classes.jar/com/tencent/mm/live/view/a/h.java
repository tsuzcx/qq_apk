package com.tencent.mm.live.view.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/view/adapter/ShareRoomItem;", "", "username", "", "memberCount", "", "(Ljava/lang/String;I)V", "getMemberCount", "()I", "setMemberCount", "(I)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
public final class h
{
  int dAb;
  String username;
  
  public h(String paramString, int paramInt)
  {
    AppMethodBeat.i(216712);
    this.username = paramString;
    this.dAb = paramInt;
    AppMethodBeat.o(216712);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(216715);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((!p.i(this.username, paramObject.username)) || (this.dAb != paramObject.dAb)) {}
      }
    }
    else
    {
      AppMethodBeat.o(216715);
      return true;
    }
    AppMethodBeat.o(216715);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(216714);
    String str = this.username;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int j = this.dAb;
      AppMethodBeat.o(216714);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(216713);
    String str = "ShareRoomItem(username=" + this.username + ", memberCount=" + this.dAb + ")";
    AppMethodBeat.o(216713);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.a.h
 * JD-Core Version:    0.7.0.1
 */