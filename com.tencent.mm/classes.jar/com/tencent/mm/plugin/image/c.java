package com.tencent.mm.plugin.image;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import com.tencent.mm.storage.bz;

public final class c
  extends y
{
  private static c ynM;
  
  private c()
  {
    super(q.class);
  }
  
  public static bz aSV()
  {
    AppMethodBeat.i(151491);
    g.aAf().azk();
    bz localbz = ((com.tencent.mm.plugin.m.a.a)g.af(com.tencent.mm.plugin.m.a.a.class)).aSV();
    AppMethodBeat.o(151491);
    return localbz;
  }
  
  public static c dZD()
  {
    try
    {
      AppMethodBeat.i(151490);
      if (ynM == null) {
        ynM = new c();
      }
      c localc = ynM;
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