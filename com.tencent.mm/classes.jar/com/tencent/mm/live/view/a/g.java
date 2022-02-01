package com.tencent.mm.live.view.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/view/adapter/ShareRoomItem;", "", "username", "", "memberCount", "", "(Ljava/lang/String;I)V", "getMemberCount", "()I", "setMemberCount", "(I)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  int hQS;
  String username;
  
  public g(String paramString, int paramInt)
  {
    AppMethodBeat.i(246197);
    this.username = paramString;
    this.hQS = paramInt;
    AppMethodBeat.o(246197);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(246220);
    if (this == paramObject)
    {
      AppMethodBeat.o(246220);
      return true;
    }
    if (!(paramObject instanceof g))
    {
      AppMethodBeat.o(246220);
      return false;
    }
    paramObject = (g)paramObject;
    if (!s.p(this.username, paramObject.username))
    {
      AppMethodBeat.o(246220);
      return false;
    }
    if (this.hQS != paramObject.hQS)
    {
      AppMethodBeat.o(246220);
      return false;
    }
    AppMethodBeat.o(246220);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(246207);
    int i = this.username.hashCode();
    int j = this.hQS;
    AppMethodBeat.o(246207);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(246202);
    String str = "ShareRoomItem(username=" + this.username + ", memberCount=" + this.hQS + ')';
    AppMethodBeat.o(246202);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.a.g
 * JD-Core Version:    0.7.0.1
 */