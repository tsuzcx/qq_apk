package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.live.b.a.m;
import com.tencent.mm.protocal.protobuf.buq;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
final class i$a
  implements Runnable
{
  public static final a gPi;
  
  static
  {
    AppMethodBeat.i(212125);
    gPi = new a();
    AppMethodBeat.o(212125);
  }
  
  public final void run()
  {
    AppMethodBeat.i(212124);
    Object localObject = com.tencent.mm.kernel.g.ajB();
    p.g(localObject, "MMKernel.network()");
    localObject = ((b)localObject).aiU();
    g localg = g.gOr;
    long l = g.ans().Fsa;
    localg = g.gOr;
    ((q)localObject).b((n)new m(l, g.anm()));
    AppMethodBeat.o(212124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.b.i.a
 * JD-Core Version:    0.7.0.1
 */