package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ql
  extends a
{
  private String iWh = "";
  public long jrX;
  public long jrY;
  
  public final String aIE()
  {
    AppMethodBeat.i(369271);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrY);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369271);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369274);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ToUsername:").append(this.iWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Reason:").append(this.jrX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReasonDetail:").append(this.jrY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369274);
    return localObject;
  }
  
  public final int getId()
  {
    return 24979;
  }
  
  public final ql xF(String paramString)
  {
    AppMethodBeat.i(369268);
    this.iWh = F("ToUsername", paramString, true);
    AppMethodBeat.o(369268);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ql
 * JD-Core Version:    0.7.0.1
 */