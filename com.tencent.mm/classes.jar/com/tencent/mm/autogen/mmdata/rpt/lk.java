package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lk
  extends a
{
  private String iZT = "";
  private String iZU = "";
  private String iZV = "";
  private String iZW = "";
  private String ijk = "";
  public long ikE = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(368240);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368240);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368256);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ResignationWorkUsername:").append(this.iZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TakeOverWorkUsername:").append(this.iZU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WorkEnterpriseDescId:").append(this.iZV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WorkEnterpriseName:").append(this.iZW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368256);
    return localObject;
  }
  
  public final int getId()
  {
    return 19942;
  }
  
  public final lk um(String paramString)
  {
    AppMethodBeat.i(368185);
    this.iZT = F("ResignationWorkUsername", paramString, true);
    AppMethodBeat.o(368185);
    return this;
  }
  
  public final lk un(String paramString)
  {
    AppMethodBeat.i(368194);
    this.iZU = F("TakeOverWorkUsername", paramString, true);
    AppMethodBeat.o(368194);
    return this;
  }
  
  public final lk uo(String paramString)
  {
    AppMethodBeat.i(368204);
    this.iZV = F("WorkEnterpriseDescId", paramString, true);
    AppMethodBeat.o(368204);
    return this;
  }
  
  public final lk up(String paramString)
  {
    AppMethodBeat.i(368216);
    this.iZW = F("WorkEnterpriseName", paramString, true);
    AppMethodBeat.o(368216);
    return this;
  }
  
  public final lk uq(String paramString)
  {
    AppMethodBeat.i(368227);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(368227);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.lk
 * JD-Core Version:    0.7.0.1
 */