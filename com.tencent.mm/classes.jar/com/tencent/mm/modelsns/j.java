package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.am;
import com.tencent.mm.protocal.protobuf.dbr;
import java.util.Map;

public final class j
  implements k
{
  public dbr mbm;
  
  public j()
  {
    AppMethodBeat.i(260151);
    this.mbm = new dbr();
    AppMethodBeat.o(260151);
  }
  
  public final String boV()
  {
    AppMethodBeat.i(260152);
    String str = am.a(this.mbm);
    AppMethodBeat.o(260152);
    return str;
  }
  
  public final void i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(260153);
    this.mbm = am.C(paramString, paramMap);
    AppMethodBeat.o(260153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.j
 * JD-Core Version:    0.7.0.1
 */