package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.bv;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.findersdk.a.q;
import com.tencent.mm.protocal.protobuf.bvn;

public final class b
  implements k
{
  public bvn oTZ;
  
  public b()
  {
    AppMethodBeat.i(233228);
    this.oTZ = new bvn();
    AppMethodBeat.o(233228);
  }
  
  public final String bMC()
  {
    AppMethodBeat.i(233231);
    String str = q.bJ(((cn)h.az(cn.class)).getFinderSwitchApi().ffJ(), q.a(this.oTZ));
    AppMethodBeat.o(233231);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.b
 * JD-Core Version:    0.7.0.1
 */