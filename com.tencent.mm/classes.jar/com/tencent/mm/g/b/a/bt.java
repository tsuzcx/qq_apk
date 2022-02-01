package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bt
  extends a
{
  private long dWt;
  private long dZK;
  private String ebS = "";
  private long ebT;
  private long ebU;
  private String ebV = "";
  private String ebW = "";
  private long ebX;
  private long ebY;
  private String ebZ = "";
  private long eca;
  private long ecb;
  
  public final String RC()
  {
    AppMethodBeat.i(189272);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ebS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eca);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZK);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189272);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189273);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessinId:").append(this.ebS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperationTimestamp:").append(this.ebT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShootEntranceEndType:").append(this.ebU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsFeedId:").append(this.ebV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderFeedId:").append(this.ebW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HaveFinderUsername:").append(this.ebX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HavePostFinderVideo:").append(this.ebY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Wording:").append(this.ebZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EntraceExposeMaxTimes:").append(this.eca);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EntractExposeTimes:").append(this.ecb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeType:").append(this.dZK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189273);
    return localObject;
  }
  
  public final long St()
  {
    return this.ebX;
  }
  
  public final bt gF(long paramLong)
  {
    this.dWt = paramLong;
    return this;
  }
  
  public final bt gG(long paramLong)
  {
    this.ebT = paramLong;
    return this;
  }
  
  public final bt gH(long paramLong)
  {
    this.ebU = paramLong;
    return this;
  }
  
  public final bt gI(long paramLong)
  {
    this.ebX = paramLong;
    return this;
  }
  
  public final bt gJ(long paramLong)
  {
    this.ebY = paramLong;
    return this;
  }
  
  public final bt gK(long paramLong)
  {
    this.eca = paramLong;
    return this;
  }
  
  public final bt gL(long paramLong)
  {
    this.ecb = paramLong;
    return this;
  }
  
  public final bt gM(long paramLong)
  {
    this.dZK = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20747;
  }
  
  public final bt kV(String paramString)
  {
    AppMethodBeat.i(189268);
    this.ebS = t("SessinId", paramString, true);
    AppMethodBeat.o(189268);
    return this;
  }
  
  public final bt kW(String paramString)
  {
    AppMethodBeat.i(189269);
    this.ebV = t("SnsFeedId", paramString, true);
    AppMethodBeat.o(189269);
    return this;
  }
  
  public final bt kX(String paramString)
  {
    AppMethodBeat.i(189270);
    this.ebW = t("FinderFeedId", paramString, true);
    AppMethodBeat.o(189270);
    return this;
  }
  
  public final bt kY(String paramString)
  {
    AppMethodBeat.i(189271);
    this.ebZ = t("Wording", paramString, true);
    AppMethodBeat.o(189271);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bt
 * JD-Core Version:    0.7.0.1
 */