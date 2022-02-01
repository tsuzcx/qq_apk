package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ge
  extends a
{
  private long dKe;
  private long dON;
  private String dTc;
  private String eag;
  private long eai;
  private long ebp;
  private long ebq;
  private long ebr;
  private int egv;
  
  public final String PV()
  {
    AppMethodBeat.i(43729);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eai);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dON);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(43729);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43730);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("UserName:").append(this.dTc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eai);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.ebp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.ebq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.ebr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Ret:").append(this.egv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.dON);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43730);
    return localObject;
  }
  
  public final int getId()
  {
    return 18866;
  }
  
  public final ge jQ(long paramLong)
  {
    this.eai = paramLong;
    return this;
  }
  
  public final ge jR(long paramLong)
  {
    AppMethodBeat.i(43726);
    this.ebp = paramLong;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(43726);
    return this;
  }
  
  public final ge jS(long paramLong)
  {
    this.dKe = paramLong;
    return this;
  }
  
  public final ge jT(long paramLong)
  {
    AppMethodBeat.i(43727);
    this.ebq = paramLong;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(43727);
    return this;
  }
  
  public final ge jU(long paramLong)
  {
    AppMethodBeat.i(43728);
    this.ebr = paramLong;
    super.bb("EndTimeStampMs", this.ebr);
    AppMethodBeat.o(43728);
    return this;
  }
  
  public final ge jV(long paramLong)
  {
    this.dON = paramLong;
    return this;
  }
  
  public final ge jl(int paramInt)
  {
    this.egv = paramInt;
    return this;
  }
  
  public final ge lR(String paramString)
  {
    AppMethodBeat.i(43724);
    this.dTc = t("UserName", paramString, true);
    AppMethodBeat.o(43724);
    return this;
  }
  
  public final ge lS(String paramString)
  {
    AppMethodBeat.i(43725);
    this.eag = t("AppId", paramString, true);
    AppMethodBeat.o(43725);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ge
 * JD-Core Version:    0.7.0.1
 */