package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gn
  extends a
{
  private String gCr = "";
  private String gcU = "";
  
  public final String agH()
  {
    AppMethodBeat.i(217980);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCr);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(217980);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(217984);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperationList:").append(this.gCr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(217984);
    return localObject;
  }
  
  public final int getId()
  {
    return 21767;
  }
  
  public final gn vA(String paramString)
  {
    AppMethodBeat.i(217976);
    this.gCr = z("OperationList", paramString, true);
    AppMethodBeat.o(217976);
    return this;
  }
  
  public final gn vz(String paramString)
  {
    AppMethodBeat.i(217973);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(217973);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gn
 * JD-Core Version:    0.7.0.1
 */