package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class jd
  extends a
{
  public long dWt = 0L;
  public a eBl;
  public long eBm = 0L;
  private String eBn = "";
  public long ebQ = 0L;
  private String esa = "";
  public long etb = 0L;
  public long euA = 0L;
  private String euy = "";
  private long evH = 0L;
  private long evI = 0L;
  public long evJ = 0L;
  public long evp = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(43740);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.eBl != null) {}
    for (int i = this.eBl.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.evp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebQ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eBm);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eBn);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(43740);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43741);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eBl);
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
    ((StringBuffer)localObject).append("isPreload:").append(this.evp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.ebQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.eBm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersionStr:").append(this.eBn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43741);
    return localObject;
  }
  
  public final jd Vx()
  {
    AppMethodBeat.i(43738);
    this.evJ = bu.fpO();
    super.bh("EndTimeStampMs", this.evJ);
    AppMethodBeat.o(43738);
    return this;
  }
  
  public final int getId()
  {
    return 15813;
  }
  
  public final jd pJ(long paramLong)
  {
    AppMethodBeat.i(43736);
    this.evH = paramLong;
    super.bg("CostTimeMs", this.evH);
    AppMethodBeat.o(43736);
    return this;
  }
  
  public final jd pK(long paramLong)
  {
    AppMethodBeat.i(43737);
    this.evI = paramLong;
    super.bh("StartTimeStampMs", this.evI);
    AppMethodBeat.o(43737);
    return this;
  }
  
  public final jd sa(String paramString)
  {
    AppMethodBeat.i(43734);
    this.esa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43734);
    return this;
  }
  
  public final jd sb(String paramString)
  {
    AppMethodBeat.i(43735);
    this.euy = t("AppId", paramString, true);
    AppMethodBeat.o(43735);
    return this;
  }
  
  public final jd sc(String paramString)
  {
    AppMethodBeat.i(43739);
    this.eBn = t("engineVersionStr", paramString, true);
    AppMethodBeat.o(43739);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43733);
      eBo = new a("release", 0, 1);
      eBp = new a("debug", 1, 2);
      eBq = new a("demo", 2, 3);
      eBr = new a[] { eBo, eBp, eBq };
      AppMethodBeat.o(43733);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jJ(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eBo;
      case 2: 
        return eBp;
      }
      return eBq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jd
 * JD-Core Version:    0.7.0.1
 */