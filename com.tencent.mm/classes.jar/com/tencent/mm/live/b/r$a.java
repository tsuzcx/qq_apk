package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.a.m;
import com.tencent.mm.protocal.protobuf.civ;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class r$a
  implements Runnable
{
  public static final a hIh;
  
  static
  {
    AppMethodBeat.i(207657);
    hIh = new a();
    AppMethodBeat.o(207657);
  }
  
  public final void run()
  {
    AppMethodBeat.i(207656);
    Object localObject = g.aAg();
    p.g(localObject, "MMKernel.network()");
    localObject = ((b)localObject).azz();
    x localx = x.hJf;
    long l = x.aGr().hyH;
    localx = x.hJf;
    ((t)localObject).b((q)new m(l, x.aGm()));
    AppMethodBeat.o(207656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.b.r.a
 * JD-Core Version:    0.7.0.1
 */