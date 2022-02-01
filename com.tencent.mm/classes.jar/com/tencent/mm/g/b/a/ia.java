package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class ia
  extends a
{
  public long dWt = 0L;
  private String esa = "";
  public long euA = 0L;
  private String euy = "";
  private long evH = 0L;
  public long evI = 0L;
  public long evJ = 0L;
  public a evP;
  public long evQ = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(43509);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    if (this.evP != null) {}
    for (int i = this.evP.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
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
      ((StringBuffer)localObject).append(this.evQ);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(43509);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43510);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.evP);
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
    ((StringBuffer)localObject).append("IsPreload:").append(this.evQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43510);
    return localObject;
  }
  
  public final ia Vc()
  {
    AppMethodBeat.i(43508);
    this.evJ = bu.fpO();
    super.bh("EndTimeStampMs", this.evJ);
    AppMethodBeat.o(43508);
    return this;
  }
  
  public final int getId()
  {
    return 17111;
  }
  
  public final ia nE(long paramLong)
  {
    AppMethodBeat.i(43506);
    this.evH = paramLong;
    super.bg("CostTimeMs", this.evH);
    AppMethodBeat.o(43506);
    return this;
  }
  
  public final ia nF(long paramLong)
  {
    AppMethodBeat.i(43507);
    this.evI = paramLong;
    super.bh("StartTimeStampMs", this.evI);
    AppMethodBeat.o(43507);
    return this;
  }
  
  public final ia rd(String paramString)
  {
    AppMethodBeat.i(43504);
    this.esa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43504);
    return this;
  }
  
  public final ia re(String paramString)
  {
    AppMethodBeat.i(43505);
    this.euy = t("AppId", paramString, true);
    AppMethodBeat.o(43505);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43503);
      evR = new a("release", 0, 1);
      evS = new a("debug", 1, 2);
      evT = new a("demo", 2, 3);
      evU = new a[] { evR, evS, evT };
      AppMethodBeat.o(43503);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jf(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return evR;
      case 2: 
        return evS;
      }
      return evT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ia
 * JD-Core Version:    0.7.0.1
 */