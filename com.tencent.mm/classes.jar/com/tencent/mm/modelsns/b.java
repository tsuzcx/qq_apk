package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.ac;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.protocal.protobuf.bcl;

public final class b
  implements j
{
  public bcl jld;
  
  public b()
  {
    AppMethodBeat.i(192722);
    this.jld = new bcl();
    AppMethodBeat.o(192722);
  }
  
  public final String bfF()
  {
    AppMethodBeat.i(192723);
    String str = l.bf(((aj)g.ah(aj.class)).getFinderSwitchApi().dCw(), l.b(this.jld));
    AppMethodBeat.o(192723);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsns.b
 * JD-Core Version:    0.7.0.1
 */