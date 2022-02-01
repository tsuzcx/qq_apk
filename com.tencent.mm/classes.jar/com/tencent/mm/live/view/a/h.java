package com.tencent.mm.live.view.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/view/adapter/ShareRoomItem;", "", "username", "", "memberCount", "", "(Ljava/lang/String;I)V", "getMemberCount", "()I", "setMemberCount", "(I)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
public final class h
{
  int dni;
  String username;
  
  public h(String paramString, int paramInt)
  {
    AppMethodBeat.i(190791);
    this.username = paramString;
    this.dni = paramInt;
    AppMethodBeat.o(190791);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(190794);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((!k.g(this.username, paramObject.username)) || (this.dni != paramObject.dni)) {}
      }
    }
    else
    {
      AppMethodBeat.o(190794);
      return true;
    }
    AppMethodBeat.o(190794);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(190793);
    String str = this.username;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int j = this.dni;
      AppMethodBeat.o(190793);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190792);
    String str = "ShareRoomItem(username=" + this.username + ", memberCount=" + this.dni + ")";
    AppMethodBeat.o(190792);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.a.h
 * JD-Core Version:    0.7.0.1
 */