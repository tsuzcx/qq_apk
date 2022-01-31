package com.tencent.mm.bd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.b.a;

public final class b
{
  private static final b fNw;
  public long fNv;
  
  static
  {
    AppMethodBeat.i(1007);
    fNw = new b();
    AppMethodBeat.o(1007);
  }
  
  public b()
  {
    AppMethodBeat.i(1006);
    if (g.RG())
    {
      this.fNv = r.Zs();
      AppMethodBeat.o(1006);
      return;
    }
    a.ymk.b(new b.1(this));
    AppMethodBeat.o(1006);
  }
  
  public static b aiU()
  {
    return fNw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bd.b
 * JD-Core Version:    0.7.0.1
 */