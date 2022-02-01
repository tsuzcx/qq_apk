package com.tencent.mm.live.view.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/view/adapter/MembersData;", "", "username", "", "(Ljava/lang/String;)V", "getUsername", "()Ljava/lang/String;", "setUsername", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-logic_release"})
public final class g
{
  String username;
  
  public g(String paramString)
  {
    AppMethodBeat.i(190787);
    this.username = paramString;
    AppMethodBeat.o(190787);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(190790);
    if (this != paramObject)
    {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if (!k.g(this.username, paramObject.username)) {}
      }
    }
    else
    {
      AppMethodBeat.o(190790);
      return true;
    }
    AppMethodBeat.o(190790);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(190789);
    String str = this.username;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(190789);
      return i;
    }
    AppMethodBeat.o(190789);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190788);
    String str = "MembersData(username=" + this.username + ")";
    AppMethodBeat.o(190788);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.a.g
 * JD-Core Version:    0.7.0.1
 */