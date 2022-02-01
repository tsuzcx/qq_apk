package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kz
  extends a
{
  private long iGN;
  private String iJU = "";
  private String iLJ = "";
  private String iLK = "";
  public long iLL;
  private long ipo;
  private String iqO = "";
  private String iqP = "";
  private long izc;
  
  public final String aIE()
  {
    AppMethodBeat.i(368333);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqP);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368333);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368340);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionID:").append(this.iqO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageName:").append(this.iLJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTimeMs:").append(this.ipo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeMs:").append(this.iGN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitTimeMs:").append(this.izc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextID:").append(this.iJU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sid:").append(this.iLK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportType:").append(this.iLL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextID:").append(this.iqP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368340);
    return localObject;
  }
  
  public final kz fi(long paramLong)
  {
    AppMethodBeat.i(368300);
    this.ipo = paramLong;
    super.bw("StayTimeMs", this.ipo);
    AppMethodBeat.o(368300);
    return this;
  }
  
  public final kz fj(long paramLong)
  {
    AppMethodBeat.i(368305);
    this.iGN = paramLong;
    super.bw("EnterTimeMs", this.iGN);
    AppMethodBeat.o(368305);
    return this;
  }
  
  public final kz fk(long paramLong)
  {
    AppMethodBeat.i(368307);
    this.izc = paramLong;
    super.bw("ExitTimeMs", this.izc);
    AppMethodBeat.o(368307);
    return this;
  }
  
  public final int getId()
  {
    return 21835;
  }
  
  public final kz tU(String paramString)
  {
    AppMethodBeat.i(368290);
    this.iqO = F("SessionID", paramString, true);
    AppMethodBeat.o(368290);
    return this;
  }
  
  public final kz tV(String paramString)
  {
    AppMethodBeat.i(368295);
    this.iLJ = F("PageName", paramString, true);
    AppMethodBeat.o(368295);
    return this;
  }
  
  public final kz tW(String paramString)
  {
    AppMethodBeat.i(368313);
    this.iJU = F("ClickTabContextID", paramString, true);
    AppMethodBeat.o(368313);
    return this;
  }
  
  public final kz tX(String paramString)
  {
    AppMethodBeat.i(368320);
    this.iLK = F("Sid", paramString, true);
    AppMethodBeat.o(368320);
    return this;
  }
  
  public final kz tY(String paramString)
  {
    AppMethodBeat.i(368326);
    this.iqP = F("ContextID", paramString, true);
    AppMethodBeat.o(368326);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.kz
 * JD-Core Version:    0.7.0.1
 */