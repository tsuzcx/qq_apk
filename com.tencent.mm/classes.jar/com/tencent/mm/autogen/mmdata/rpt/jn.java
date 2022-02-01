package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jn
  extends a
{
  private String iTC = "";
  public int iTD;
  public int iTR;
  private String iTS = "";
  public String iTT = "";
  public String iTU = "";
  public String iTV = "";
  public String iTW = "";
  public String iTX = "";
  public String iTY = "";
  public String iTZ = "";
  public String iUa = "";
  public String iUb = "";
  public String iUc = "";
  public String iUd = "";
  public String iUe = "";
  public String iUf = "";
  public String iUg = "";
  private String iUh = "";
  private String iUi = "";
  public long iUj;
  public long iUk;
  
  public final String aIE()
  {
    AppMethodBeat.i(368553);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iTC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUk);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368553);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368563);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionKey:").append(this.iTC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportScene:").append(this.iTD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eventType:").append(this.iTR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("maasVersionCode:").append(this.iTS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("maasEventName:").append(this.iTT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("maasEventCode:").append(this.iTU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("maasEventMessage:").append(this.iTV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("maasExpand1:").append(this.iTW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("maasExpand2:").append(this.iTX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("maasExpand3:").append(this.iTY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("maasExpand4:").append(this.iTZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("maasExpand5:").append(this.iUa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("maasExpand6:").append(this.iUb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("maasExpand7:").append(this.iUc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("maasExpand8:").append(this.iUd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("maasExpand9:").append(this.iUe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("maasExpand10:").append(this.iUf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("maasNamed:").append(this.iUg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("asyncFuncName:").append(this.iUh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("asyncFuncResult:").append(this.iUi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("asyncFuncCallSpend:").append(this.iUj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("serialId:").append(this.iUk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368563);
    return localObject;
  }
  
  public final int getId()
  {
    return 24945;
  }
  
  public final jn sj(String paramString)
  {
    AppMethodBeat.i(368535);
    this.iTC = F("sessionKey", paramString, true);
    AppMethodBeat.o(368535);
    return this;
  }
  
  public final jn sk(String paramString)
  {
    AppMethodBeat.i(368537);
    this.iTS = F("maasVersionCode", paramString, true);
    AppMethodBeat.o(368537);
    return this;
  }
  
  public final jn sl(String paramString)
  {
    AppMethodBeat.i(368541);
    this.iUh = F("asyncFuncName", paramString, true);
    AppMethodBeat.o(368541);
    return this;
  }
  
  public final jn sm(String paramString)
  {
    AppMethodBeat.i(368546);
    this.iUi = F("asyncFuncResult", paramString, true);
    AppMethodBeat.o(368546);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.jn
 * JD-Core Version:    0.7.0.1
 */