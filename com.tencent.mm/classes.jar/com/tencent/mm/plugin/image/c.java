package com.tencent.mm.plugin.image;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.storage.bu;

public final class c
  extends u
{
  private static c uVl;
  
  private c()
  {
    super(q.class);
  }
  
  public static bu azN()
  {
    AppMethodBeat.i(151491);
    g.ajP().aiU();
    bu localbu = ((com.tencent.mm.plugin.n.a.a)g.ab(com.tencent.mm.plugin.n.a.a.class)).azN();
    AppMethodBeat.o(151491);
    return localbu;
  }
  
  public static c dfJ()
  {
    try
    {
      AppMethodBeat.i(151490);
      if (uVl == null) {
        uVl = new c();
      }
      c localc = uVl;
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