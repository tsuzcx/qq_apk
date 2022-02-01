package com.tencent.mm.bf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.b.c;

public final class a
{
  private static final a hqs;
  public long hqr;
  
  static
  {
    AppMethodBeat.i(116858);
    hqs = new a();
    AppMethodBeat.o(116858);
  }
  
  public a()
  {
    AppMethodBeat.i(116857);
    if (g.afw())
    {
      this.hqr = u.aqL();
      AppMethodBeat.o(116857);
      return;
    }
    com.tencent.mm.sdk.b.a.ESL.b(new c() {});
    AppMethodBeat.o(116857);
  }
  
  public static a aAd()
  {
    return hqs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bf.a
 * JD-Core Version:    0.7.0.1
 */