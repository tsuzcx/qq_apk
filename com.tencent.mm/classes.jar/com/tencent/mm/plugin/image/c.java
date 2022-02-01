package com.tencent.mm.plugin.image;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.s.a.a;
import com.tencent.mm.storage.bz;

public final class c
  extends y
{
  private static c DNO;
  
  private c()
  {
    super(q.class);
  }
  
  public static bz bbT()
  {
    AppMethodBeat.i(151491);
    h.aHE().aGH();
    bz localbz = ((a)h.ae(a.class)).bbT();
    AppMethodBeat.o(151491);
    return localbz;
  }
  
  public static c eIA()
  {
    try
    {
      AppMethodBeat.i(151490);
      if (DNO == null) {
        DNO = new c();
      }
      c localc = DNO;
      AppMethodBeat.o(151490);
      return localc;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.image.c
 * JD-Core Version:    0.7.0.1
 */