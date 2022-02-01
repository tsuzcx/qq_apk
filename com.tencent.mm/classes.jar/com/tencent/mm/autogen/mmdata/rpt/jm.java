package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jm
  extends a
{
  public String iTC = "";
  public int iTD;
  public String iTE = "";
  public int iTF;
  public int iTG;
  public String iTH = "";
  public int iTI;
  public int iTJ;
  public String iTK = "";
  public int iTL;
  private String iTM = "";
  public String iTN = "";
  public String iTO = "";
  public int iTP;
  public long iTQ;
  
  public final String aIE()
  {
    AppMethodBeat.i(368534);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iTC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTQ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368534);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368538);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionKey:").append(this.iTC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportScene:").append(this.iTD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("importMediaInfo:").append(this.iTE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("importVideoNum:").append(this.iTF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("importImageNum:").append(this.iTG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exportMediaInfo:").append(this.iTH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("movieOption:").append(this.iTI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exportResultCode:").append(this.iTJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exportResultErrorMessage:").append(this.iTK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("creationResult:").append(this.iTL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exportTemplateId:").append(this.iTM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exportMusicId:").append(this.iTN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exportParams:").append(this.iTO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("entrance:").append(this.iTP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exportCallSpend:").append(this.iTQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368538);
    return localObject;
  }
  
  public final int getId()
  {
    return 24946;
  }
  
  public final jm si(String paramString)
  {
    AppMethodBeat.i(368532);
    this.iTM = F("exportTemplateId", paramString, true);
    AppMethodBeat.o(368532);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.jm
 * JD-Core Version:    0.7.0.1
 */