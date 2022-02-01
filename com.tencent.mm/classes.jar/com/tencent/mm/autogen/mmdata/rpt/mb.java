package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mb
  extends a
{
  public long iUt = 0L;
  public long jaU = 0L;
  public long jaV = 0L;
  public String jaW = "";
  public long jaX = 0L;
  public long jaY = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(368456);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iUt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaY);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368456);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368470);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ResType:").append(this.iUt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResSubType:").append(this.jaU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResVersion:").append(this.jaV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Network:").append(this.jaW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportId:").append(this.jaX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportKey:").append(this.jaY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368470);
    return localObject;
  }
  
  public final int getId()
  {
    return 15166;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.mb
 * JD-Core Version:    0.7.0.1
 */