package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nk
  extends a
{
  public long iCB;
  public long iGF;
  private String inx = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(367856);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCB);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367856);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367863);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("opType:").append(this.iGF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickType:").append(this.iCB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367863);
    return localObject;
  }
  
  public final int getId()
  {
    return 21182;
  }
  
  public final nk vI(String paramString)
  {
    AppMethodBeat.i(367849);
    this.inx = F("sessionid", paramString, true);
    AppMethodBeat.o(367849);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.nk
 * JD-Core Version:    0.7.0.1
 */