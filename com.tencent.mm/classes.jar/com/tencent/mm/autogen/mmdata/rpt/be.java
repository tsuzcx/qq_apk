package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class be
  extends a
{
  public long ila;
  public long iqN;
  private String iqO = "";
  private String iqP = "";
  public long iqQ;
  
  public final String aIE()
  {
    AppMethodBeat.i(368938);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqQ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368938);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368944);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionTimestamp:").append(this.iqN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.iqO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextID:").append(this.iqP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Entrance_Type:").append(this.iqQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368944);
    return localObject;
  }
  
  public final int getId()
  {
    return 21831;
  }
  
  public final be kX(String paramString)
  {
    AppMethodBeat.i(368924);
    this.iqO = F("SessionID", paramString, true);
    AppMethodBeat.o(368924);
    return this;
  }
  
  public final be kY(String paramString)
  {
    AppMethodBeat.i(368932);
    this.iqP = F("ContextID", paramString, true);
    AppMethodBeat.o(368932);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.be
 * JD-Core Version:    0.7.0.1
 */