package com.tencent.mm.live.view.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/view/adapter/ShareRoomItem;", "", "username", "", "memberCount", "", "(Ljava/lang/String;I)V", "getMemberCount", "()I", "setMemberCount", "(I)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
public final class h
{
  int fLk;
  String username;
  
  public h(String paramString, int paramInt)
  {
    AppMethodBeat.i(198242);
    this.username = paramString;
    this.fLk = paramInt;
    AppMethodBeat.o(198242);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198250);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((!p.h(this.username, paramObject.username)) || (this.fLk != paramObject.fLk)) {}
      }
    }
    else
    {
      AppMethodBeat.o(198250);
      return true;
    }
    AppMethodBeat.o(198250);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(198246);
    String str = this.username;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int j = this.fLk;
      AppMethodBeat.o(198246);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198244);
    String str = "ShareRoomItem(username=" + this.username + ", memberCount=" + this.fLk + ")";
    AppMethodBeat.o(198244);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.a.h
 * JD-Core Version:    0.7.0.1
 */