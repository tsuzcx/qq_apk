package com.tencent.mm.plugin.groupsolitaire.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class c$a
{
  String key = "";
  int num = 0;
  
  public c$a(c paramc, String paramString, int paramInt)
  {
    this.key = paramString;
    this.num = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(110368);
    paramObject = (a)paramObject;
    if (Util.isEqual(this.key, paramObject.key))
    {
      AppMethodBeat.o(110368);
      return true;
    }
    AppMethodBeat.o(110368);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(110367);
    int i = this.key.hashCode();
    AppMethodBeat.o(110367);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.b.c.a
 * JD-Core Version:    0.7.0.1
 */