package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bvb;
import com.tencent.mm.protocal.protobuf.bvc;
import com.tencent.mm.sdk.platformtools.ab;

public final class e
  extends a<bvb, bvc>
{
  public e(bvb parambvb)
  {
    this.oin = parambvb;
  }
  
  protected final void bML()
  {
    AppMethodBeat.i(41991);
    ab.i("MicroMsg.CgiRequestWxaHB", "CgiRequestWxaHB.onCgiStart ");
    AppMethodBeat.o(41991);
  }
  
  protected final void bMM()
  {
    AppMethodBeat.i(41992);
    ab.i("MicroMsg.CgiRequestWxaHB", "CgiRequestWxaHB.onCgiEnd ");
    AppMethodBeat.o(41992);
  }
  
  public final int getFuncId()
  {
    return 2857;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmbiz-bin/wxahb/requestwxaapphb";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.e
 * JD-Core Version:    0.7.0.1
 */