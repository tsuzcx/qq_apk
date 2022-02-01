package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bjf;
import java.util.Map;

public final class f
  implements k
{
  public bjf mbj;
  
  public f()
  {
    AppMethodBeat.i(260120);
    this.mbj = new bjf();
    AppMethodBeat.o(260120);
  }
  
  public final String boV()
  {
    AppMethodBeat.i(260121);
    String str = com.tencent.mm.plugin.findersdk.a.k.bf(2, com.tencent.mm.plugin.findersdk.a.k.a(this.mbj));
    AppMethodBeat.o(260121);
    return str;
  }
  
  public final void i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(260123);
    this.mbj = com.tencent.mm.plugin.findersdk.a.k.B(paramString + ".finder.detail", paramMap);
    AppMethodBeat.o(260123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.f
 * JD-Core Version:    0.7.0.1
 */