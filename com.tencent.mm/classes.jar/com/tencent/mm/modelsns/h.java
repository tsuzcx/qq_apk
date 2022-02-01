package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cwx;
import java.util.Map;

public final class h
  implements k
{
  public cwx mbk;
  
  public h()
  {
    AppMethodBeat.i(260818);
    this.mbk = new cwx();
    AppMethodBeat.o(260818);
  }
  
  public final String boV()
  {
    AppMethodBeat.i(260820);
    String str = com.tencent.mm.plugin.findersdk.a.k.a(this.mbk);
    AppMethodBeat.o(260820);
    return str;
  }
  
  public final void i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(260821);
    this.mbk = com.tencent.mm.plugin.findersdk.a.k.x(paramString, paramMap);
    AppMethodBeat.o(260821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.h
 * JD-Core Version:    0.7.0.1
 */