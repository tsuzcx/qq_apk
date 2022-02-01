package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jc
  extends a
{
  private String dUy = "";
  private long dWt;
  private int eBk;
  private long ehL;
  private long euA;
  private String euy = "";
  private long evH;
  private long evI;
  private long evJ;
  
  public final String RC()
  {
    AppMethodBeat.i(43729);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehL);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(43729);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43730);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("UserName:").append(this.dUy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.euA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.evH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.evI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.evJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Ret:").append(this.eBk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.ehL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43730);
    return localObject;
  }
  
  public final int getId()
  {
    return 18866;
  }
  
  public final jc jI(int paramInt)
  {
    this.eBk = paramInt;
    return this;
  }
  
  public final jc pD(long paramLong)
  {
    this.euA = paramLong;
    return this;
  }
  
  public final jc pE(long paramLong)
  {
    AppMethodBeat.i(43726);
    this.evH = paramLong;
    super.bg("CostTimeMs", this.evH);
    AppMethodBeat.o(43726);
    return this;
  }
  
  public final jc pF(long paramLong)
  {
    this.dWt = paramLong;
    return this;
  }
  
  public final jc pG(long paramLong)
  {
    AppMethodBeat.i(43727);
    this.evI = paramLong;
    super.bh("StartTimeStampMs", this.evI);
    AppMethodBeat.o(43727);
    return this;
  }
  
  public final jc pH(long paramLong)
  {
    AppMethodBeat.i(43728);
    this.evJ = paramLong;
    super.bh("EndTimeStampMs", this.evJ);
    AppMethodBeat.o(43728);
    return this;
  }
  
  public final jc pI(long paramLong)
  {
    this.ehL = paramLong;
    return this;
  }
  
  public final jc rY(String paramString)
  {
    AppMethodBeat.i(43724);
    this.dUy = t("UserName", paramString, true);
    AppMethodBeat.o(43724);
    return this;
  }
  
  public final jc rZ(String paramString)
  {
    AppMethodBeat.i(43725);
    this.euy = t("AppId", paramString, true);
    AppMethodBeat.o(43725);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jc
 * JD-Core Version:    0.7.0.1
 */