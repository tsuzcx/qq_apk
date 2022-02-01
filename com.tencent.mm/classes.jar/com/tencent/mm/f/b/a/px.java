package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class px
  extends a
{
  private long gHC;
  private long gYN;
  private String gjX = "";
  private String gmF = "";
  private long gnP;
  private long hcT;
  private long hcU;
  private long hcV;
  private int hiM;
  
  public final px Do(long paramLong)
  {
    this.gYN = paramLong;
    return this;
  }
  
  public final px Dp(long paramLong)
  {
    AppMethodBeat.i(43726);
    this.hcT = paramLong;
    super.bk("CostTimeMs", this.hcT);
    AppMethodBeat.o(43726);
    return this;
  }
  
  public final px Dq(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final px Dr(long paramLong)
  {
    AppMethodBeat.i(43727);
    this.hcU = paramLong;
    super.bm("StartTimeStampMs", this.hcU);
    AppMethodBeat.o(43727);
    return this;
  }
  
  public final px Ds(long paramLong)
  {
    AppMethodBeat.i(43728);
    this.hcV = paramLong;
    super.bm("EndTimeStampMs", this.hcV);
    AppMethodBeat.o(43728);
    return this;
  }
  
  public final px Dt(long paramLong)
  {
    this.gHC = paramLong;
    return this;
  }
  
  public final px GR(String paramString)
  {
    AppMethodBeat.i(43724);
    this.gjX = z("UserName", paramString, true);
    AppMethodBeat.o(43724);
    return this;
  }
  
  public final px GS(String paramString)
  {
    AppMethodBeat.i(43725);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(43725);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(43729);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hcT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hcV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hiM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHC);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(43729);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43730);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("UserName:").append(this.gjX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.gYN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.hcT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.hcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.hcV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Ret:").append(this.hiM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.gHC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43730);
    return localObject;
  }
  
  public final int getId()
  {
    return 18866;
  }
  
  public final px oV(int paramInt)
  {
    this.hiM = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.px
 * JD-Core Version:    0.7.0.1
 */