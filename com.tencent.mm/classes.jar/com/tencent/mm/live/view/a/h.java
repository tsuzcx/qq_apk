package com.tencent.mm.live.view.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/view/adapter/ShareRoomItem;", "", "username", "", "memberCount", "", "(Ljava/lang/String;I)V", "getMemberCount", "()I", "setMemberCount", "(I)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
public final class h
{
  int dpx;
  String username;
  
  public h(String paramString, int paramInt)
  {
    AppMethodBeat.i(203553);
    this.username = paramString;
    this.dpx = paramInt;
    AppMethodBeat.o(203553);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203556);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((!k.g(this.username, paramObject.username)) || (this.dpx != paramObject.dpx)) {}
      }
    }
    else
    {
      AppMethodBeat.o(203556);
      return true;
    }
    AppMethodBeat.o(203556);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203555);
    String str = this.username;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int j = this.dpx;
      AppMethodBeat.o(203555);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203554);
    String str = "ShareRoomItem(username=" + this.username + ", memberCount=" + this.dpx + ")";
    AppMethodBeat.o(203554);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.view.a.h
 * JD-Core Version:    0.7.0.1
 */