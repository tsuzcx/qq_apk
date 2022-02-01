package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iq
  extends a
{
  public long dWt = 0L;
  private String esa = "";
  public long etb = 0L;
  public long euA = 0L;
  private String euy = "";
  private long evH = 0L;
  private long evI = 0L;
  private long evJ = 0L;
  private String ewn = "";
  public a exY;
  private String exZ = "";
  private long exa = 0L;
  public long exi = 0L;
  public long exk = 0L;
  public long exl = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(43629);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.exY != null) {}
    for (int i = this.exY.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.exZ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exi);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exa);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exl);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exk);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewn);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(43629);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43630);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.exY);
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
    ((StringBuffer)localObject).append("package:").append(this.exZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSize:").append(this.exi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadPageFrame:").append(this.exa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useCodeCache:").append(this.exl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineType:").append(this.exk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.ewn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43630);
    return localObject;
  }
  
  public final int getId()
  {
    return 16005;
  }
  
  public final iq oF(long paramLong)
  {
    AppMethodBeat.i(43624);
    this.evH = paramLong;
    super.bg("CostTimeMs", this.evH);
    AppMethodBeat.o(43624);
    return this;
  }
  
  public final iq oG(long paramLong)
  {
    AppMethodBeat.i(43625);
    this.evI = paramLong;
    super.bh("StartTimeStampMs", this.evI);
    AppMethodBeat.o(43625);
    return this;
  }
  
  public final iq oH(long paramLong)
  {
    AppMethodBeat.i(43626);
    this.evJ = paramLong;
    super.bh("EndTimeStampMs", this.evJ);
    AppMethodBeat.o(43626);
    return this;
  }
  
  public final iq rD(String paramString)
  {
    AppMethodBeat.i(43622);
    this.esa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43622);
    return this;
  }
  
  public final iq rE(String paramString)
  {
    AppMethodBeat.i(43623);
    this.euy = t("AppId", paramString, true);
    AppMethodBeat.o(43623);
    return this;
  }
  
  public final iq rF(String paramString)
  {
    AppMethodBeat.i(43627);
    this.exZ = t("package", paramString, true);
    AppMethodBeat.o(43627);
    return this;
  }
  
  public final iq rG(String paramString)
  {
    AppMethodBeat.i(43628);
    this.ewn = t("engineVersion", paramString, true);
    AppMethodBeat.o(43628);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43621);
      eya = new a("release", 0, 1);
      eyb = new a("debug", 1, 2);
      eyc = new a("demo", 2, 3);
      eyd = new a[] { eya, eyb, eyc };
      AppMethodBeat.o(43621);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jw(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eya;
      case 2: 
        return eyb;
      }
      return eyc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.iq
 * JD-Core Version:    0.7.0.1
 */