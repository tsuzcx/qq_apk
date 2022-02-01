package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.a.m;
import com.tencent.mm.protocal.protobuf.crq;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class o$a
  implements Runnable
{
  public static final a kvB;
  
  static
  {
    AppMethodBeat.i(194237);
    kvB = new a();
    AppMethodBeat.o(194237);
  }
  
  public final void run()
  {
    AppMethodBeat.i(194236);
    Object localObject = h.aHF();
    p.j(localObject, "MMKernel.network()");
    localObject = ((c)localObject).aGY();
    u localu = u.kwz;
    long l = u.aOr().klE;
    localu = u.kwz;
    ((t)localObject).b((q)new m(l, u.aOm()));
    AppMethodBeat.o(194236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.o.a
 * JD-Core Version:    0.7.0.1
 */