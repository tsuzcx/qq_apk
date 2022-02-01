package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.live.b.a.m;
import com.tencent.mm.protocal.protobuf.bvk;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class i$a
  implements Runnable
{
  public static final a gRQ;
  
  static
  {
    AppMethodBeat.i(215744);
    gRQ = new a();
    AppMethodBeat.o(215744);
  }
  
  public final void run()
  {
    AppMethodBeat.i(215743);
    Object localObject = com.tencent.mm.kernel.g.ajQ();
    p.g(localObject, "MMKernel.network()");
    localObject = ((b)localObject).ajj();
    g localg = g.gQZ;
    long l = g.anH().FKy;
    localg = g.gQZ;
    ((q)localObject).b((n)new m(l, g.anC()));
    AppMethodBeat.o(215743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.b.i.a
 * JD-Core Version:    0.7.0.1
 */