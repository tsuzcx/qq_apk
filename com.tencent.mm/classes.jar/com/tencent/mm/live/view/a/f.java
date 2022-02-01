package com.tencent.mm.live.view.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/view/adapter/MembersData;", "", "username", "", "(Ljava/lang/String;)V", "getUsername", "()Ljava/lang/String;", "setUsername", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  String username;
  
  public f(String paramString)
  {
    AppMethodBeat.i(246196);
    this.username = paramString;
    AppMethodBeat.o(246196);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(246212);
    if (this == paramObject)
    {
      AppMethodBeat.o(246212);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(246212);
      return false;
    }
    paramObject = (f)paramObject;
    if (!s.p(this.username, paramObject.username))
    {
      AppMethodBeat.o(246212);
      return false;
    }
    AppMethodBeat.o(246212);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(246206);
    int i = this.username.hashCode();
    AppMethodBeat.o(246206);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(246201);
    String str = "MembersData(username=" + this.username + ')';
    AppMethodBeat.o(246201);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.a.f
 * JD-Core Version:    0.7.0.1
 */