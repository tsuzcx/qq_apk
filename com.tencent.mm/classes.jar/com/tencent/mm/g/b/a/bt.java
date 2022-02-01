package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bt
  extends a
{
  private long dVd;
  private String eaA;
  private String eaB;
  private long eaC;
  private long eaD;
  private String eaE;
  private long eaF;
  private long eaG;
  private String eax;
  private long eay;
  private long eaz;
  
  public final String RD()
  {
    AppMethodBeat.i(209237);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eax);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eay);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaG);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209237);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209238);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessinId:").append(this.eax);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperationTimestamp:").append(this.eay);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShootEntranceEndType:").append(this.eaz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsFeedId:").append(this.eaA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderFeedId:").append(this.eaB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HaveFinderUsername:").append(this.eaC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HavePostFinderVideo:").append(this.eaD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Wording:").append(this.eaE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EntraceExposeMaxTimes:").append(this.eaF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EntractExposeTimes:").append(this.eaG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209238);
    return localObject;
  }
  
  public final long Sv()
  {
    return this.eaC;
  }
  
  public final bt gB(long paramLong)
  {
    this.dVd = paramLong;
    return this;
  }
  
  public final bt gC(long paramLong)
  {
    this.eay = paramLong;
    return this;
  }
  
  public final bt gD(long paramLong)
  {
    this.eaz = paramLong;
    return this;
  }
  
  public final bt gE(long paramLong)
  {
    this.eaC = paramLong;
    return this;
  }
  
  public final bt gF(long paramLong)
  {
    this.eaD = paramLong;
    return this;
  }
  
  public final bt gG(long paramLong)
  {
    this.eaF = paramLong;
    return this;
  }
  
  public final bt gH(long paramLong)
  {
    this.eaG = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20747;
  }
  
  public final bt kI(String paramString)
  {
    AppMethodBeat.i(209233);
    this.eax = t("SessinId", paramString, true);
    AppMethodBeat.o(209233);
    return this;
  }
  
  public final bt kJ(String paramString)
  {
    AppMethodBeat.i(209234);
    this.eaA = t("SnsFeedId", paramString, true);
    AppMethodBeat.o(209234);
    return this;
  }
  
  public final bt kK(String paramString)
  {
    AppMethodBeat.i(209235);
    this.eaB = t("FinderFeedId", paramString, true);
    AppMethodBeat.o(209235);
    return this;
  }
  
  public final bt kL(String paramString)
  {
    AppMethodBeat.i(209236);
    this.eaE = t("Wording", paramString, true);
    AppMethodBeat.o(209236);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bt
 * JD-Core Version:    0.7.0.1
 */