package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class s
  extends a
{
  private String ilF = "";
  public long ilG;
  public long ilH;
  public long ilI;
  private String ilJ = "";
  private String ilK = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368608);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilK);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368608);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368616);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appId:").append(this.ilF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appType:").append(this.ilG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("aliveTime:").append(this.ilH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reason:").append(this.ilI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("flags:").append(this.ilJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.ilK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368616);
    return localObject;
  }
  
  public final int getId()
  {
    return 21804;
  }
  
  public final s ki(String paramString)
  {
    AppMethodBeat.i(368584);
    this.ilF = F("appId", paramString, true);
    AppMethodBeat.o(368584);
    return this;
  }
  
  public final s kj(String paramString)
  {
    AppMethodBeat.i(368593);
    this.ilJ = F("flags", paramString, true);
    AppMethodBeat.o(368593);
    return this;
  }
  
  public final s kk(String paramString)
  {
    AppMethodBeat.i(368600);
    this.ilK = F("sessionId", paramString, true);
    AppMethodBeat.o(368600);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.s
 * JD-Core Version:    0.7.0.1
 */