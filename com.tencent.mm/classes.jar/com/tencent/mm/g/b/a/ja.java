package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ja
  extends a
{
  private String dTi;
  private long dVd;
  private long ega;
  private String esR;
  private long esT;
  private long eua;
  private long eub;
  private long euc;
  private int ezB;
  
  public final String RD()
  {
    AppMethodBeat.i(43729);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esR);
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
    ((StringBuffer)localObject).append(this.ezB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ega);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(43729);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43730);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("UserName:").append(this.dTi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
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
    ((StringBuffer)localObject).append("Ret:").append(this.ezB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.ega);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43730);
    return localObject;
  }
  
  public final int getId()
  {
    return 18866;
  }
  
  public final ja jG(int paramInt)
  {
    this.ezB = paramInt;
    return this;
  }
  
  public final ja pq(long paramLong)
  {
    this.esT = paramLong;
    return this;
  }
  
  public final ja pr(long paramLong)
  {
    AppMethodBeat.i(43726);
    this.eua = paramLong;
    super.bf("CostTimeMs", this.eua);
    AppMethodBeat.o(43726);
    return this;
  }
  
  public final ja ps(long paramLong)
  {
    this.dVd = paramLong;
    return this;
  }
  
  public final ja pt(long paramLong)
  {
    AppMethodBeat.i(43727);
    this.eub = paramLong;
    super.bg("StartTimeStampMs", this.eub);
    AppMethodBeat.o(43727);
    return this;
  }
  
  public final ja pu(long paramLong)
  {
    AppMethodBeat.i(43728);
    this.euc = paramLong;
    super.bg("EndTimeStampMs", this.euc);
    AppMethodBeat.o(43728);
    return this;
  }
  
  public final ja pv(long paramLong)
  {
    this.ega = paramLong;
    return this;
  }
  
  public final ja rD(String paramString)
  {
    AppMethodBeat.i(43724);
    this.dTi = t("UserName", paramString, true);
    AppMethodBeat.o(43724);
    return this;
  }
  
  public final ja rE(String paramString)
  {
    AppMethodBeat.i(43725);
    this.esR = t("AppId", paramString, true);
    AppMethodBeat.o(43725);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ja
 * JD-Core Version:    0.7.0.1
 */