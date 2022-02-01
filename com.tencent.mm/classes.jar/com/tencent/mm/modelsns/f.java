package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.q;
import com.tencent.mm.protocal.protobuf.bvm;
import java.util.Map;

public final class f
  implements k
{
  public bvm oUd;
  
  public f()
  {
    AppMethodBeat.i(233233);
    this.oUd = new bvm();
    AppMethodBeat.o(233233);
  }
  
  public final String bMC()
  {
    AppMethodBeat.i(233236);
    String str = q.bJ(2, q.a(this.oUd));
    AppMethodBeat.o(233236);
    return str;
  }
  
  public final void i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(233241);
    this.oUd = q.I(paramString + ".finder.detail", paramMap);
    AppMethodBeat.o(233241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.f
 * JD-Core Version:    0.7.0.1
 */