package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gg
  extends a
{
  private String gCr = "";
  private String gcU = "";
  
  public final String agH()
  {
    AppMethodBeat.i(217239);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCr);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(217239);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(217240);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperationList:").append(this.gCr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(217240);
    return localObject;
  }
  
  public final int getId()
  {
    return 21771;
  }
  
  public final gg vt(String paramString)
  {
    AppMethodBeat.i(217236);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(217236);
    return this;
  }
  
  public final gg vu(String paramString)
  {
    AppMethodBeat.i(217238);
    this.gCr = z("OperationList", paramString, true);
    AppMethodBeat.o(217238);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gg
 * JD-Core Version:    0.7.0.1
 */