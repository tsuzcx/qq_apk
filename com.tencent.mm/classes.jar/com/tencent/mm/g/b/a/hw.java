package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hw
  extends a
{
  private String dGd;
  private long dHY;
  private long dQE;
  private String ecm;
  private long eco;
  private long edv;
  private long edw;
  private long edx;
  private int eiB;
  
  public final String PR()
  {
    AppMethodBeat.i(43729);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dGd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eco);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQE);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(43729);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43730);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("UserName:").append(this.dGd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eco);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.edv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.edw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.edx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Ret:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.dQE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43730);
    return localObject;
  }
  
  public final int getId()
  {
    return 18866;
  }
  
  public final hw jj(int paramInt)
  {
    this.eiB = paramInt;
    return this;
  }
  
  public final hw ns(long paramLong)
  {
    this.eco = paramLong;
    return this;
  }
  
  public final hw nt(long paramLong)
  {
    AppMethodBeat.i(43726);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(43726);
    return this;
  }
  
  public final hw nu(long paramLong)
  {
    this.dHY = paramLong;
    return this;
  }
  
  public final hw nv(long paramLong)
  {
    AppMethodBeat.i(43727);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(43727);
    return this;
  }
  
  public final hw nw(long paramLong)
  {
    AppMethodBeat.i(43728);
    this.edx = paramLong;
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(43728);
    return this;
  }
  
  public final hw nx(long paramLong)
  {
    this.dQE = paramLong;
    return this;
  }
  
  public final hw oW(String paramString)
  {
    AppMethodBeat.i(43724);
    this.dGd = t("UserName", paramString, true);
    AppMethodBeat.o(43724);
    return this;
  }
  
  public final hw oX(String paramString)
  {
    AppMethodBeat.i(43725);
    this.ecm = t("AppId", paramString, true);
    AppMethodBeat.o(43725);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hw
 * JD-Core Version:    0.7.0.1
 */