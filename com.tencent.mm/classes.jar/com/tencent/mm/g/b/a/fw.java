package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fw
  extends a
{
  public String dJb = "";
  public long dQE = 0L;
  public long dXp = 0L;
  public String dZU = "";
  public long eaM = 0L;
  public long eaN = 0L;
  public long eaO = 0L;
  public long eaP = 0L;
  public long eaQ = 0L;
  public long eaR = 0L;
  public String eaS;
  
  public final String PR()
  {
    AppMethodBeat.i(43458);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dJb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaS);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(43458);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43459);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.dJb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.dZU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsEncrypt:").append(this.eaN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.dQE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.dXp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RetryCount:").append(this.eaO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CmdSequence:").append(this.eaP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportId:").append(this.eaQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PackageType:").append(this.eaR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PackageKey:").append(this.eaS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43459);
    return localObject;
  }
  
  public final int getId()
  {
    return 16636;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fw
 * JD-Core Version:    0.7.0.1
 */