package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eg
  extends a
{
  public String dKt = "";
  public long dON = 0L;
  public long dYT = 0L;
  public long dYU = 0L;
  public long dYV = 0L;
  public long dYW = 0L;
  public long dYX = 0L;
  public long dYY = 0L;
  public long dYZ = 0L;
  public String dYb = "";
  public String dZa;
  
  public final String PV()
  {
    AppMethodBeat.i(43458);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dON);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZa);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(43458);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43459);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.dKt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.dYb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsEncrypt:").append(this.dYU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.dON);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.dYV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RetryCount:").append(this.dYW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CmdSequence:").append(this.dYX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportId:").append(this.dYY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PackageType:").append(this.dYZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PackageKey:").append(this.dZa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43459);
    return localObject;
  }
  
  public final int getId()
  {
    return 16636;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.eg
 * JD-Core Version:    0.7.0.1
 */