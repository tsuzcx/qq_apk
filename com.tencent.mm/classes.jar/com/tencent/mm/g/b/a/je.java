package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class je
  extends a
{
  public long dWt = 0L;
  public a eBs;
  public String esa = "";
  public long etb = 0L;
  public long euA = 0L;
  public String euy = "";
  private long evH = 0L;
  public long evI = 0L;
  public long evJ = 0L;
  public String evc = "";
  public long evp = 0L;
  public String ewR = "";
  public long ewT = 0L;
  public long exa = 0L;
  public long exc = 0L;
  public long exr;
  
  public final String RC()
  {
    AppMethodBeat.i(43748);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.eBs != null) {}
    for (int i = this.eBs.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.ewR);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exa);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evc);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exc);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exr);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(43748);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43749);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eBs);
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
    ((StringBuffer)localObject).append("path:").append(this.ewR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.evp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadPageFrame:").append(this.exa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.evc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.ewT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isFirstPageRenderingCacheAccepted:").append(this.exc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.exr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43749);
    return localObject;
  }
  
  public final je Vy()
  {
    AppMethodBeat.i(43747);
    this.evJ = bu.fpO();
    super.bh("EndTimeStampMs", this.evJ);
    AppMethodBeat.o(43747);
    return this;
  }
  
  public final int getId()
  {
    return 16011;
  }
  
  public final je pL(long paramLong)
  {
    AppMethodBeat.i(43745);
    this.evH = paramLong;
    super.bg("CostTimeMs", this.evH);
    AppMethodBeat.o(43745);
    return this;
  }
  
  public final je pM(long paramLong)
  {
    AppMethodBeat.i(43746);
    this.evI = paramLong;
    super.bh("StartTimeStampMs", this.evI);
    AppMethodBeat.o(43746);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43744);
      eBt = new a("release", 0, 1);
      eBu = new a("debug", 1, 2);
      eBv = new a("demo", 2, 3);
      eBw = new a[] { eBt, eBu, eBv };
      AppMethodBeat.o(43744);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jK(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eBt;
      case 2: 
        return eBu;
      }
      return eBv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.je
 * JD-Core Version:    0.7.0.1
 */