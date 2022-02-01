package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mb
  extends a
{
  public long gRK = 0L;
  private String gSH = "";
  public long gSI = 0L;
  private String gSJ = "";
  public long gSK = 0L;
  private String gcU = "";
  
  public final mb CA(String paramString)
  {
    AppMethodBeat.i(94851);
    this.gSH = z("EnterObjectId", paramString, true);
    AppMethodBeat.o(94851);
    return this;
  }
  
  public final mb CB(String paramString)
  {
    AppMethodBeat.i(94852);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(94852);
    return this;
  }
  
  public final mb CC(String paramString)
  {
    AppMethodBeat.i(94853);
    this.gSJ = z("ExposeUinList", paramString, true);
    AppMethodBeat.o(94853);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(94854);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gSH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRK);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(94854);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(94855);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterObjectId:").append(this.gSH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeUinCount:").append(this.gSI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeUinList:").append(this.gSJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewVideoCount:").append(this.gSK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InteractiveUserCount:").append(this.gRK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94855);
    return localObject;
  }
  
  public final int getId()
  {
    return 16843;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.mb
 * JD-Core Version:    0.7.0.1
 */