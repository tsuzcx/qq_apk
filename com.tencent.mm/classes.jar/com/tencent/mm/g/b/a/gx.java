package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gx
  extends a
{
  public long eqI;
  public long eqJ;
  public long eqK;
  public long eqL;
  public String eqM;
  public String eqN;
  public long eqO;
  private String eqP;
  private String eqQ;
  private String eqR;
  private String eqS;
  public long eqT;
  
  public final String RD()
  {
    AppMethodBeat.i(43454);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqT);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(43454);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43455);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterListTimeStamp:").append(this.eqI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LeaveListTimeStamp:").append(this.eqJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LeaveListType:").append(this.eqK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppidIndex:").append(this.eqL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppid:").append(this.eqM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppidName:").append(this.eqN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppidIsStar:").append(this.eqO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom1And5:").append(this.eqP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom6And10:").append(this.eqQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom11And15:").append(this.eqR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom16And20:").append(this.eqS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openSession:").append(this.eqT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43455);
    return localObject;
  }
  
  public final int getId()
  {
    return 18094;
  }
  
  public final gx pP(String paramString)
  {
    AppMethodBeat.i(43450);
    this.eqP = t("AppidFrom1And5", paramString, true);
    AppMethodBeat.o(43450);
    return this;
  }
  
  public final gx pQ(String paramString)
  {
    AppMethodBeat.i(43451);
    this.eqQ = t("AppidFrom6And10", paramString, true);
    AppMethodBeat.o(43451);
    return this;
  }
  
  public final gx pR(String paramString)
  {
    AppMethodBeat.i(43452);
    this.eqR = t("AppidFrom11And15", paramString, true);
    AppMethodBeat.o(43452);
    return this;
  }
  
  public final gx pS(String paramString)
  {
    AppMethodBeat.i(43453);
    this.eqS = t("AppidFrom16And20", paramString, true);
    AppMethodBeat.o(43453);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gx
 * JD-Core Version:    0.7.0.1
 */