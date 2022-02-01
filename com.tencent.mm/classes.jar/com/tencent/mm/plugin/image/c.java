package com.tencent.mm.plugin.image;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.storage.bn;

public final class c
  extends t
{
  private static c tGL;
  
  private c()
  {
    super(o.class);
  }
  
  public static bn awI()
  {
    AppMethodBeat.i(151491);
    g.agP().afT();
    bn localbn = ((com.tencent.mm.plugin.n.a.a)g.ab(com.tencent.mm.plugin.n.a.a.class)).awI();
    AppMethodBeat.o(151491);
    return localbn;
  }
  
  public static c cTF()
  {
    try
    {
      AppMethodBeat.i(151490);
      if (tGL == null) {
        tGL = new c();
      }
      c localc = tGL;
      AppMethodBeat.o(151490);
      return localc;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.image.c
 * JD-Core Version:    0.7.0.1
 */