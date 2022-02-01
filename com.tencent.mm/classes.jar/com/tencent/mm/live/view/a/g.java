package com.tencent.mm.live.view.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/adapter/MembersData;", "", "username", "", "(Ljava/lang/String;)V", "getUsername", "()Ljava/lang/String;", "setUsername", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-logic_release"})
public final class g
{
  String username;
  
  public g(String paramString)
  {
    AppMethodBeat.i(208682);
    this.username = paramString;
    AppMethodBeat.o(208682);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(208685);
    if (this != paramObject)
    {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if (!p.j(this.username, paramObject.username)) {}
      }
    }
    else
    {
      AppMethodBeat.o(208685);
      return true;
    }
    AppMethodBeat.o(208685);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(208684);
    String str = this.username;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(208684);
      return i;
    }
    AppMethodBeat.o(208684);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(208683);
    String str = "MembersData(username=" + this.username + ")";
    AppMethodBeat.o(208683);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.a.g
 * JD-Core Version:    0.7.0.1
 */