package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gb
  extends a
{
  public long iJM;
  private String iJN = "";
  private String iJO = "";
  private String iJU = "";
  public String iKi = "";
  private String iKj = "";
  private String iKk = "";
  public long iKl;
  public long iKm;
  public long ilI;
  private String ilK = "";
  private String iqP = "";
  private String iqX = "";
  private String ira = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368009);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iJM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ira);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilI);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368009);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368014);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RedDotCtrlType:").append(this.iJM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotTipsID:").append(this.ira);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoPath:").append(this.iJN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoParentPath:").append(this.iJO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoType:").append(this.iKi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("objectId:").append(this.iKj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.iqX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportExtInfo:").append(this.iKk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotActionType:").append(this.iKl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextID:").append(this.iqP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextID:").append(this.iJU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotActionTimeStamp:").append(this.iKm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.ilK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reason:").append(this.ilI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368014);
    return localObject;
  }
  
  public final int getId()
  {
    return 23587;
  }
  
  public final gb qC(String paramString)
  {
    AppMethodBeat.i(367979);
    this.ira = F("RedDotTipsID", paramString, true);
    AppMethodBeat.o(367979);
    return this;
  }
  
  public final gb qD(String paramString)
  {
    AppMethodBeat.i(367984);
    this.iJN = F("RedDotShowInfoPath", paramString, true);
    AppMethodBeat.o(367984);
    return this;
  }
  
  public final gb qE(String paramString)
  {
    AppMethodBeat.i(367989);
    this.iJO = F("RedDotShowInfoParentPath", paramString, true);
    AppMethodBeat.o(367989);
    return this;
  }
  
  public final gb qF(String paramString)
  {
    AppMethodBeat.i(367993);
    this.iKj = F("objectId", paramString, true);
    AppMethodBeat.o(367993);
    return this;
  }
  
  public final gb qG(String paramString)
  {
    AppMethodBeat.i(367997);
    this.iqX = F("username", paramString, true);
    AppMethodBeat.o(367997);
    return this;
  }
  
  public final gb qH(String paramString)
  {
    AppMethodBeat.i(368001);
    this.iKk = F("reportExtInfo", paramString, true);
    AppMethodBeat.o(368001);
    return this;
  }
  
  public final gb qI(String paramString)
  {
    AppMethodBeat.i(368004);
    this.iqP = F("ContextID", paramString, true);
    AppMethodBeat.o(368004);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.gb
 * JD-Core Version:    0.7.0.1
 */