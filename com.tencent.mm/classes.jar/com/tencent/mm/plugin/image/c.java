package com.tencent.mm.plugin.image;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.storage.bk;

public final class c
  extends t
{
  private static c szb;
  
  private c()
  {
    super(o.class);
  }
  
  public static bk apT()
  {
    AppMethodBeat.i(151491);
    g.afz().aeD();
    bk localbk = ((com.tencent.mm.plugin.n.a.a)g.ab(com.tencent.mm.plugin.n.a.a.class)).apT();
    AppMethodBeat.o(151491);
    return localbk;
  }
  
  public static c cGv()
  {
    try
    {
      AppMethodBeat.i(151490);
      if (szb == null) {
        szb = new c();
      }
      c localc = szb;
      AppMethodBeat.o(151490);
      return localc;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.image.c
 * JD-Core Version:    0.7.0.1
 */