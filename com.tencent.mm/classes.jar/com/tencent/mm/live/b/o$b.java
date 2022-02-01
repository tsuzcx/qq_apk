package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.a.o;
import com.tencent.mm.protocal.protobuf.crq;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class o$b
  implements Runnable
{
  public static final b kvC;
  
  static
  {
    AppMethodBeat.i(200443);
    kvC = new b();
    AppMethodBeat.o(200443);
  }
  
  public final void run()
  {
    AppMethodBeat.i(200440);
    Object localObject1 = h.aHF();
    p.j(localObject1, "MMKernel.network()");
    localObject1 = ((c)localObject1).aGY();
    Object localObject2 = u.kwz;
    long l = u.aOr().klE;
    localObject2 = u.kwz;
    localObject2 = u.aOm();
    u localu = u.kwz;
    ((t)localObject1).b((q)new o(l, (String)localObject2, u.aOq()));
    AppMethodBeat.o(200440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.o.b
 * JD-Core Version:    0.7.0.1
 */