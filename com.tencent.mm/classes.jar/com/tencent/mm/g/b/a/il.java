package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class il
  extends a
{
  public long dVd = 0L;
  private String eqt = "";
  public long eru = 0L;
  private String esR = "";
  public long esT = 0L;
  public long etI = 0L;
  private String euG = "";
  private long eua = 0L;
  public long eub = 0L;
  public long euc = 0L;
  public long evA = 0L;
  public long evB = 0L;
  public long evD = 0L;
  public long evE = 0L;
  public long evF = 0L;
  public long evG = 0L;
  private String evQ = "";
  private String evW = "";
  public long evX = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(43599);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eua);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eub);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evX);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(43599);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43600);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.evA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.esT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.eua);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.eub);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.euc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.etI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileName:").append(this.evW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("libVersion:").append(this.evQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSize:").append(this.evB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineType:").append(this.evD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useCodeCache:").append(this.evE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useIsolatedContext:").append(this.evF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("compileTime:").append(this.evG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.euG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("codeCacheType:").append(this.evX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43600);
    return localObject;
  }
  
  public final long UY()
  {
    return this.eub;
  }
  
  public final long UZ()
  {
    return this.euc;
  }
  
  public final int getId()
  {
    return 15815;
  }
  
  public final il oa(long paramLong)
  {
    AppMethodBeat.i(43593);
    this.eua = paramLong;
    super.bf("CostTimeMs", this.eua);
    AppMethodBeat.o(43593);
    return this;
  }
  
  public final il ob(long paramLong)
  {
    AppMethodBeat.i(43594);
    this.eub = paramLong;
    super.bg("StartTimeStampMs", this.eub);
    AppMethodBeat.o(43594);
    return this;
  }
  
  public final il oc(long paramLong)
  {
    AppMethodBeat.i(43595);
    this.euc = paramLong;
    super.bg("EndTimeStampMs", this.euc);
    AppMethodBeat.o(43595);
    return this;
  }
  
  public final il od(long paramLong)
  {
    this.evB = paramLong;
    return this;
  }
  
  public final il oe(long paramLong)
  {
    this.evE = paramLong;
    return this;
  }
  
  public final il of(long paramLong)
  {
    this.evF = paramLong;
    return this;
  }
  
  public final il og(long paramLong)
  {
    this.evG = paramLong;
    return this;
  }
  
  public final il oh(long paramLong)
  {
    this.evX = paramLong;
    return this;
  }
  
  public final il qW(String paramString)
  {
    AppMethodBeat.i(43591);
    this.eqt = t("InstanceId", paramString, true);
    AppMethodBeat.o(43591);
    return this;
  }
  
  public final il qX(String paramString)
  {
    AppMethodBeat.i(43592);
    this.esR = t("AppId", paramString, true);
    AppMethodBeat.o(43592);
    return this;
  }
  
  public final il qY(String paramString)
  {
    AppMethodBeat.i(43596);
    this.evW = t("fileName", paramString, true);
    AppMethodBeat.o(43596);
    return this;
  }
  
  public final il qZ(String paramString)
  {
    AppMethodBeat.i(43597);
    this.evQ = t("libVersion", paramString, true);
    AppMethodBeat.o(43597);
    return this;
  }
  
  public final il ra(String paramString)
  {
    AppMethodBeat.i(43598);
    this.euG = t("engineVersion", paramString, true);
    AppMethodBeat.o(43598);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.il
 * JD-Core Version:    0.7.0.1
 */