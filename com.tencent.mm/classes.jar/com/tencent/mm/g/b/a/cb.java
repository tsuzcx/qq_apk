package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cb
  extends a
{
  private String dSb = "";
  private long dSt = 0L;
  private String dVc;
  private long dYT = 0L;
  private String eaQ = "";
  private long eaR = 0L;
  private String eaS;
  private long eaT = 0L;
  private String eaU;
  
  public final String RD()
  {
    AppMethodBeat.i(210159);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaU);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(210159);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(210160);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageName:").append(this.eaQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTimeMs:").append(this.dSt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeMs:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitTimeMs:").append(this.eaR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dVc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sid:").append(this.eaS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportType:").append(this.eaT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderContextID:").append(this.eaU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(210160);
    return localObject;
  }
  
  public final long SA()
  {
    return this.dSt;
  }
  
  public final long SB()
  {
    return this.dYT;
  }
  
  public final long SC()
  {
    return this.eaR;
  }
  
  public final String SD()
  {
    return this.dVc;
  }
  
  public final String SE()
  {
    return this.eaS;
  }
  
  public final long SF()
  {
    return this.eaT;
  }
  
  public final String SG()
  {
    return this.eaU;
  }
  
  public final String Sz()
  {
    return this.eaQ;
  }
  
  public final int getId()
  {
    return 19943;
  }
  
  public final String getSessionId()
  {
    return this.dSb;
  }
  
  public final cb he(long paramLong)
  {
    AppMethodBeat.i(210153);
    this.dSt = paramLong;
    super.bf("StayTimeMs", this.dSt);
    AppMethodBeat.o(210153);
    return this;
  }
  
  public final cb hf(long paramLong)
  {
    AppMethodBeat.i(210154);
    this.dYT = paramLong;
    super.bf("EnterTimeMs", this.dYT);
    AppMethodBeat.o(210154);
    return this;
  }
  
  public final cb hg(long paramLong)
  {
    AppMethodBeat.i(210155);
    this.eaR = paramLong;
    super.bf("ExitTimeMs", this.eaR);
    AppMethodBeat.o(210155);
    return this;
  }
  
  public final cb hh(long paramLong)
  {
    this.eaT = paramLong;
    return this;
  }
  
  public final cb lh(String paramString)
  {
    AppMethodBeat.i(210151);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(210151);
    return this;
  }
  
  public final cb li(String paramString)
  {
    AppMethodBeat.i(210152);
    this.eaQ = t("PageName", paramString, true);
    AppMethodBeat.o(210152);
    return this;
  }
  
  public final cb lj(String paramString)
  {
    AppMethodBeat.i(210156);
    this.dVc = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(210156);
    return this;
  }
  
  public final cb lk(String paramString)
  {
    AppMethodBeat.i(210157);
    this.eaS = t("Sid", paramString, true);
    AppMethodBeat.o(210157);
    return this;
  }
  
  public final cb ll(String paramString)
  {
    AppMethodBeat.i(210158);
    this.eaU = t("FinderContextID", paramString, true);
    AppMethodBeat.o(210158);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cb
 * JD-Core Version:    0.7.0.1
 */