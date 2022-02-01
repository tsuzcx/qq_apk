package com.tencent.mm.plugin.image;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.storage.bt;

public final class c
  extends t
{
  private static c uJy;
  
  private c()
  {
    super(q.class);
  }
  
  public static bt azx()
  {
    AppMethodBeat.i(151491);
    g.ajA().aiF();
    bt localbt = ((com.tencent.mm.plugin.n.a.a)g.ab(com.tencent.mm.plugin.n.a.a.class)).azx();
    AppMethodBeat.o(151491);
    return localbt;
  }
  
  public static c dcR()
  {
    try
    {
      AppMethodBeat.i(151490);
      if (uJy == null) {
        uJy = new c();
      }
      c localc = uJy;
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