package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lg
  extends a
{
  public long iZF = 0L;
  public long iZG = 0L;
  public long isX = 0L;
  private String izT = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(149916);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.izT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.isX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZG);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(149916);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(149917);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionID:").append(this.izT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCode:").append(this.isX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCodeResult:").append(this.iZF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickAddContact:").append(this.iZG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149917);
    return localObject;
  }
  
  public final int getId()
  {
    return 15850;
  }
  
  public final lg ud(String paramString)
  {
    AppMethodBeat.i(149915);
    this.izT = F("sessionID", paramString, true);
    AppMethodBeat.o(149915);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.lg
 * JD-Core Version:    0.7.0.1
 */