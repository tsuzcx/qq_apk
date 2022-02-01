package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class rc
  extends a
{
  public long juH;
  public long juI;
  public long juJ;
  public long juK;
  public String juL = "";
  public String juM = "";
  public long juN;
  private String juO = "";
  private String juP = "";
  private String juQ = "";
  private String juR = "";
  public long juS;
  
  public final String aIE()
  {
    AppMethodBeat.i(43454);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.juH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juS);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(43454);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43455);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterListTimeStamp:").append(this.juH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LeaveListTimeStamp:").append(this.juI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LeaveListType:").append(this.juJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppidIndex:").append(this.juK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppid:").append(this.juL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppidName:").append(this.juM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppidIsStar:").append(this.juN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom1And5:").append(this.juO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom6And10:").append(this.juP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom11And15:").append(this.juQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom16And20:").append(this.juR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openSession:").append(this.juS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43455);
    return localObject;
  }
  
  public final int getId()
  {
    return 18094;
  }
  
  public final rc yd(String paramString)
  {
    AppMethodBeat.i(43450);
    this.juO = F("AppidFrom1And5", paramString, true);
    AppMethodBeat.o(43450);
    return this;
  }
  
  public final rc ye(String paramString)
  {
    AppMethodBeat.i(43451);
    this.juP = F("AppidFrom6And10", paramString, true);
    AppMethodBeat.o(43451);
    return this;
  }
  
  public final rc yf(String paramString)
  {
    AppMethodBeat.i(43452);
    this.juQ = F("AppidFrom11And15", paramString, true);
    AppMethodBeat.o(43452);
    return this;
  }
  
  public final rc yg(String paramString)
  {
    AppMethodBeat.i(43453);
    this.juR = F("AppidFrom16And20", paramString, true);
    AppMethodBeat.o(43453);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.rc
 * JD-Core Version:    0.7.0.1
 */