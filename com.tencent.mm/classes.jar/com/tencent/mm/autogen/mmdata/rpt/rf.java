package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class rf
  extends a
{
  public String ilL = "";
  public String ilM = "";
  public String imU = "";
  public long ind = 0L;
  public long jaX = 0L;
  public long jvw;
  public long jvy = 0L;
  public String jvz = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(43464);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ind);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilM);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(43464);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43465);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.imU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.ilL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.ind);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFirstHit:").append(this.jvy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportId:").append(this.jaX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PackageType:").append(this.jvw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ModuleName:").append(this.jvz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43465);
    return localObject;
  }
  
  public final int getId()
  {
    return 16634;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.rf
 * JD-Core Version:    0.7.0.1
 */