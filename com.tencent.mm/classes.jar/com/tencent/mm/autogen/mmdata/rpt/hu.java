package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hu
  extends a
{
  public long iDn;
  public long iOY;
  public long iOZ = 0L;
  public long iPa = 0L;
  public long iPb = 0L;
  private String iPc = "";
  public long iPd;
  
  public final String aIE()
  {
    AppMethodBeat.i(369277);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iOY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPd);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369277);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369284);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RecomdCount:").append(this.iOY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickMore:").append(this.iOZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecomdSelect:").append(this.iPa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OtherSelect:").append(this.iPb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitType:").append(this.iDn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TicketId:").append(this.iPc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OtherCount:").append(this.iPd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369284);
    return localObject;
  }
  
  public final int getId()
  {
    return 19450;
  }
  
  public final hu rH(String paramString)
  {
    AppMethodBeat.i(369275);
    this.iPc = F("TicketId", paramString, true);
    AppMethodBeat.o(369275);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.hu
 * JD-Core Version:    0.7.0.1
 */