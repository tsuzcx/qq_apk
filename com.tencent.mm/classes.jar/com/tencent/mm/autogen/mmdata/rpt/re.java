package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class re
  extends a
{
  public long iHe = 0L;
  public long iVU = 0L;
  public String ilL = "";
  public String imU = "";
  public long ind = 0L;
  public long jaX = 0L;
  public long jlJ = 0L;
  public long jvu = 0L;
  public long jvv = 0L;
  public long jvw = 0L;
  public String jvx = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(43458);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ind);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iHe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvx);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(43458);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43459);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.imU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.ilL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.ind);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsEncrypt:").append(this.jvu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.iVU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.jlJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RetryCount:").append(this.iHe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CmdSequence:").append(this.jvv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportId:").append(this.jaX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PackageType:").append(this.jvw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PackageKey:").append(this.jvx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43459);
    return localObject;
  }
  
  public final int getId()
  {
    return 16636;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.re
 * JD-Core Version:    0.7.0.1
 */