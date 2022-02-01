package com.tencent.mm.bf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.b.c;

public final class a
{
  private static final a iki;
  public long ikh;
  
  static
  {
    AppMethodBeat.i(116858);
    iki = new a();
    AppMethodBeat.o(116858);
  }
  
  public a()
  {
    AppMethodBeat.i(116857);
    if (g.ajx())
    {
      this.ikh = u.aAr();
      AppMethodBeat.o(116857);
      return;
    }
    com.tencent.mm.sdk.b.a.IbL.b(new c() {});
    AppMethodBeat.o(116857);
  }
  
  public static a aKe()
  {
    return iki;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bf.a
 * JD-Core Version:    0.7.0.1
 */