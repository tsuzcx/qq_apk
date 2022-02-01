package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ad;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.protocal.protobuf.bjg;

public final class b
  implements k
{
  public bjg mbf;
  
  public b()
  {
    AppMethodBeat.i(260299);
    this.mbf = new bjg();
    AppMethodBeat.o(260299);
  }
  
  public final String boV()
  {
    AppMethodBeat.i(260300);
    String str = com.tencent.mm.plugin.findersdk.a.k.bf(((ak)h.ag(ak.class)).getFinderSwitchApi().edS(), com.tencent.mm.plugin.findersdk.a.k.b(this.mbf));
    AppMethodBeat.o(260300);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.b
 * JD-Core Version:    0.7.0.1
 */