package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class rk
  extends a
{
  public long jvN = 0L;
  public long jvO = 0L;
  public String jvP = "";
  public String jvQ = "";
  public String jvR = "";
  public String jvS = "";
  public String jvT = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(91243);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jvN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvT);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(91243);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(91244);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PayType:").append(this.jvN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CallbackType:").append(this.jvO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceH5Url:").append(this.jvP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceAppUsername:").append(this.jvQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceAppPath:").append(this.jvR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppUsername:").append(this.jvS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppPath:").append(this.jvT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91244);
    return localObject;
  }
  
  public final int getId()
  {
    return 16310;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.rk
 * JD-Core Version:    0.7.0.1
 */