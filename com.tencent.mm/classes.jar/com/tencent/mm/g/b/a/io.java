package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class io
  extends a
{
  public long dVd = 0L;
  private String eqt = "";
  public long eru = 0L;
  private String esR = "";
  public long esT = 0L;
  private String euG = "";
  private long eua = 0L;
  private long eub = 0L;
  private long euc = 0L;
  public long evB = 0L;
  public long evD = 0L;
  public long evE = 0L;
  private long evt = 0L;
  public io.a ewp;
  private String ewq = "";
  
  public final String RD()
  {
    AppMethodBeat.i(43629);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    if (this.ewp != null) {}
    for (int i = this.ewp.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
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
      ((StringBuffer)localObject).append(this.ewq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evB);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evt);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evE);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euG);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(43629);
      return localObject;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43630);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ewp);
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
    ((StringBuffer)localObject).append("package:").append(this.ewq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSize:").append(this.evB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadPageFrame:").append(this.evt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useCodeCache:").append(this.evE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineType:").append(this.evD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.euG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43630);
    return localObject;
  }
  
  public final int getId()
  {
    return 16005;
  }
  
  public final io os(long paramLong)
  {
    AppMethodBeat.i(43624);
    this.eua = paramLong;
    super.bf("CostTimeMs", this.eua);
    AppMethodBeat.o(43624);
    return this;
  }
  
  public final io ot(long paramLong)
  {
    AppMethodBeat.i(43625);
    this.eub = paramLong;
    super.bg("StartTimeStampMs", this.eub);
    AppMethodBeat.o(43625);
    return this;
  }
  
  public final io ou(long paramLong)
  {
    AppMethodBeat.i(43626);
    this.euc = paramLong;
    super.bg("EndTimeStampMs", this.euc);
    AppMethodBeat.o(43626);
    return this;
  }
  
  public final io ri(String paramString)
  {
    AppMethodBeat.i(43622);
    this.eqt = t("InstanceId", paramString, true);
    AppMethodBeat.o(43622);
    return this;
  }
  
  public final io rj(String paramString)
  {
    AppMethodBeat.i(43623);
    this.esR = t("AppId", paramString, true);
    AppMethodBeat.o(43623);
    return this;
  }
  
  public final io rk(String paramString)
  {
    AppMethodBeat.i(43627);
    this.ewq = t("package", paramString, true);
    AppMethodBeat.o(43627);
    return this;
  }
  
  public final io rl(String paramString)
  {
    AppMethodBeat.i(43628);
    this.euG = t("engineVersion", paramString, true);
    AppMethodBeat.o(43628);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.io
 * JD-Core Version:    0.7.0.1
 */