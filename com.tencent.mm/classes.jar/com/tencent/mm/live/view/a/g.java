package com.tencent.mm.live.view.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/view/adapter/MembersData;", "", "username", "", "(Ljava/lang/String;)V", "getUsername", "()Ljava/lang/String;", "setUsername", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-logic_release"})
public final class g
{
  String username;
  
  public g(String paramString)
  {
    AppMethodBeat.i(213078);
    this.username = paramString;
    AppMethodBeat.o(213078);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(213081);
    if (this != paramObject)
    {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if (!p.i(this.username, paramObject.username)) {}
      }
    }
    else
    {
      AppMethodBeat.o(213081);
      return true;
    }
    AppMethodBeat.o(213081);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(213080);
    String str = this.username;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(213080);
      return i;
    }
    AppMethodBeat.o(213080);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(213079);
    String str = "MembersData(username=" + this.username + ")";
    AppMethodBeat.o(213079);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.a.g
 * JD-Core Version:    0.7.0.1
 */