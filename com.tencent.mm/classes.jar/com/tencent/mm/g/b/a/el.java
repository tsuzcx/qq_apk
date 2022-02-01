package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class el
  extends a
{
  private String eCL = "";
  private long eCM = 0L;
  private String eCN = "";
  private long eCO = 0L;
  private String eCP = "";
  private String eiB = "";
  private long enH = 0L;
  private String erH = "";
  private String esZ = "";
  private String eta = "";
  private long ezg = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(220219);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eta);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(220219);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(220220);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageName:").append(this.eCL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTimeMs:").append(this.enH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeMs:").append(this.ezg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitTimeMs:").append(this.eCM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.erH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sid:").append(this.eCN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportType:").append(this.eCO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderContextID:").append(this.eCP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtraInfo:").append(this.esZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterSourceInfo:").append(this.eta);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(220220);
    return localObject;
  }
  
  public final String ack()
  {
    return this.erH;
  }
  
  public final String afB()
  {
    return this.eCL;
  }
  
  public final long afC()
  {
    return this.ezg;
  }
  
  public final long afD()
  {
    return this.eCM;
  }
  
  public final String afE()
  {
    return this.eCN;
  }
  
  public final long afF()
  {
    return this.eCO;
  }
  
  public final String afG()
  {
    return this.eCP;
  }
  
  public final String afH()
  {
    return this.eta;
  }
  
  public final long afo()
  {
    return this.enH;
  }
  
  public final String getExtraInfo()
  {
    return this.esZ;
  }
  
  public final int getId()
  {
    return 19943;
  }
  
  public final String getSessionId()
  {
    return this.eiB;
  }
  
  public final el ma(long paramLong)
  {
    AppMethodBeat.i(220211);
    this.enH = paramLong;
    super.bi("StayTimeMs", this.enH);
    AppMethodBeat.o(220211);
    return this;
  }
  
  public final el mb(long paramLong)
  {
    AppMethodBeat.i(220212);
    this.ezg = paramLong;
    super.bi("EnterTimeMs", this.ezg);
    AppMethodBeat.o(220212);
    return this;
  }
  
  public final el mc(long paramLong)
  {
    AppMethodBeat.i(220213);
    this.eCM = paramLong;
    super.bi("ExitTimeMs", this.eCM);
    AppMethodBeat.o(220213);
    return this;
  }
  
  public final el md(long paramLong)
  {
    this.eCO = paramLong;
    return this;
  }
  
  public final el re(String paramString)
  {
    AppMethodBeat.i(220209);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(220209);
    return this;
  }
  
  public final el rf(String paramString)
  {
    AppMethodBeat.i(220210);
    this.eCL = x("PageName", paramString, true);
    AppMethodBeat.o(220210);
    return this;
  }
  
  public final el rg(String paramString)
  {
    AppMethodBeat.i(220214);
    this.erH = x("ClickTabContextId", paramString, true);
    AppMethodBeat.o(220214);
    return this;
  }
  
  public final el rh(String paramString)
  {
    AppMethodBeat.i(220215);
    this.eCN = x("Sid", paramString, true);
    AppMethodBeat.o(220215);
    return this;
  }
  
  public final el ri(String paramString)
  {
    AppMethodBeat.i(220216);
    this.eCP = x("FinderContextID", paramString, true);
    AppMethodBeat.o(220216);
    return this;
  }
  
  public final el rj(String paramString)
  {
    AppMethodBeat.i(220217);
    this.esZ = x("ExtraInfo", paramString, true);
    AppMethodBeat.o(220217);
    return this;
  }
  
  public final el rk(String paramString)
  {
    AppMethodBeat.i(220218);
    this.eta = x("enterSourceInfo", paramString, true);
    AppMethodBeat.o(220218);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.el
 * JD-Core Version:    0.7.0.1
 */