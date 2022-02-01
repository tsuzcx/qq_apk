package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.b.c;

public final class a
{
  private static final a inb;
  public long ina;
  
  static
  {
    AppMethodBeat.i(116858);
    inb = new a();
    AppMethodBeat.o(116858);
  }
  
  public a()
  {
    AppMethodBeat.i(116857);
    if (g.ajM())
    {
      this.ina = v.aAH();
      AppMethodBeat.o(116857);
      return;
    }
    com.tencent.mm.sdk.b.a.IvT.b(new c() {});
    AppMethodBeat.o(116857);
  }
  
  public static a aKx()
  {
    return inb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.be.a
 * JD-Core Version:    0.7.0.1
 */