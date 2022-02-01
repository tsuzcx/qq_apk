package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cb
  extends a
{
  private long dTJ = 0L;
  private String dTr = "";
  private String dWs = "";
  private String dXu = "";
  private String dXv = "";
  private long eam = 0L;
  private String ecl = "";
  private long ecm = 0L;
  private String ecn = "";
  private long eco = 0L;
  private String ecp = "";
  
  public final String RC()
  {
    AppMethodBeat.i(195799);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eam);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eco);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXv);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(195799);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(195800);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageName:").append(this.ecl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTimeMs:").append(this.dTJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeMs:").append(this.eam);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitTimeMs:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dWs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sid:").append(this.ecn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportType:").append(this.eco);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderContextID:").append(this.ecp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtraInfo:").append(this.dXu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterSourceInfo:").append(this.dXv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195800);
    return localObject;
  }
  
  public final long SA()
  {
    return this.ecm;
  }
  
  public final String SB()
  {
    return this.dWs;
  }
  
  public final String SC()
  {
    return this.ecn;
  }
  
  public final long SD()
  {
    return this.eco;
  }
  
  public final String SE()
  {
    return this.ecp;
  }
  
  public final String SF()
  {
    return this.dXv;
  }
  
  public final String Sx()
  {
    return this.ecl;
  }
  
  public final long Sy()
  {
    return this.dTJ;
  }
  
  public final long Sz()
  {
    return this.eam;
  }
  
  public final String getExtraInfo()
  {
    return this.dXu;
  }
  
  public final int getId()
  {
    return 19943;
  }
  
  public final String getSessionId()
  {
    return this.dTr;
  }
  
  public final cb hj(long paramLong)
  {
    AppMethodBeat.i(195791);
    this.dTJ = paramLong;
    super.bg("StayTimeMs", this.dTJ);
    AppMethodBeat.o(195791);
    return this;
  }
  
  public final cb hk(long paramLong)
  {
    AppMethodBeat.i(195792);
    this.eam = paramLong;
    super.bg("EnterTimeMs", this.eam);
    AppMethodBeat.o(195792);
    return this;
  }
  
  public final cb hl(long paramLong)
  {
    AppMethodBeat.i(195793);
    this.ecm = paramLong;
    super.bg("ExitTimeMs", this.ecm);
    AppMethodBeat.o(195793);
    return this;
  }
  
  public final cb hm(long paramLong)
  {
    this.eco = paramLong;
    return this;
  }
  
  public final cb lA(String paramString)
  {
    AppMethodBeat.i(195798);
    this.dXv = t("enterSourceInfo", paramString, true);
    AppMethodBeat.o(195798);
    return this;
  }
  
  public final cb lu(String paramString)
  {
    AppMethodBeat.i(195789);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(195789);
    return this;
  }
  
  public final cb lv(String paramString)
  {
    AppMethodBeat.i(195790);
    this.ecl = t("PageName", paramString, true);
    AppMethodBeat.o(195790);
    return this;
  }
  
  public final cb lw(String paramString)
  {
    AppMethodBeat.i(195794);
    this.dWs = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(195794);
    return this;
  }
  
  public final cb lx(String paramString)
  {
    AppMethodBeat.i(195795);
    this.ecn = t("Sid", paramString, true);
    AppMethodBeat.o(195795);
    return this;
  }
  
  public final cb ly(String paramString)
  {
    AppMethodBeat.i(195796);
    this.ecp = t("FinderContextID", paramString, true);
    AppMethodBeat.o(195796);
    return this;
  }
  
  public final cb lz(String paramString)
  {
    AppMethodBeat.i(195797);
    this.dXu = t("ExtraInfo", paramString, true);
    AppMethodBeat.o(195797);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cb
 * JD-Core Version:    0.7.0.1
 */