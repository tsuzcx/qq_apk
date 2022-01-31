package com.tencent.luggage.game.c;

import com.tencent.luggage.game.g.a;
import com.tencent.luggage.game.g.a.a;
import com.tencent.magicbrush.a.b;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class d
{
  private static final a.a bAf;
  
  static
  {
    AppMethodBeat.i(140361);
    bAf = new a.a();
    AppMethodBeat.o(140361);
  }
  
  public final void uD()
  {
    AppMethodBeat.i(140358);
    a.a(bAf, new d.1(this));
    AppMethodBeat.o(140358);
  }
  
  protected void uE()
  {
    AppMethodBeat.i(140359);
    long l = bo.yB();
    b.loadLibraries();
    ab.i("MicroMsg.MBLogDelegateRegistry", "dl: load magicbrush [%d]ms", new Object[] { Long.valueOf(bo.av(l)) });
    AppMethodBeat.o(140359);
  }
  
  protected final void uF()
  {
    AppMethodBeat.i(140360);
    uE();
    c.c.a(new d.2(this));
    AppMethodBeat.o(140360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.c.d
 * JD-Core Version:    0.7.0.1
 */