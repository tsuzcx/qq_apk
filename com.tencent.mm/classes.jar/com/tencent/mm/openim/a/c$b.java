package com.tencent.mm.openim.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;

public final class c$b
{
  public int action;
  public String cDz;
  String desc;
  public int gfI;
  public String gfJ;
  
  public final String wm(String paramString)
  {
    AppMethodBeat.i(128607);
    if (this.gfI == 1)
    {
      paramString = ((b)g.E(b.class)).bd(paramString, this.desc);
      AppMethodBeat.o(128607);
      return paramString;
    }
    paramString = this.desc;
    AppMethodBeat.o(128607);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.a.c.b
 * JD-Core Version:    0.7.0.1
 */