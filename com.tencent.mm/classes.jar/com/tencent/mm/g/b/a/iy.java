package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iy
  extends a
{
  private long dWt = 0L;
  private a eAd;
  public long eAe = 0L;
  public b eAf;
  public long ehL = 0L;
  private String esa = "";
  private long etb = 0L;
  private long euA = 0L;
  private String euy = "";
  private long evH = 0L;
  public long evI = 0L;
  private long evJ = 0L;
  
  public final String RC()
  {
    int j = -1;
    AppMethodBeat.i(221964);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.eAd != null) {}
    for (int i = this.eAd.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.eAe);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.eAf != null) {
        i = this.eAf.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ehL);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(221964);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(221965);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eAd);
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
    ((StringBuffer)localObject).append("Ret:").append(this.eAe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.eAf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.ehL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(221965);
    return localObject;
  }
  
  public final iy a(a parama)
  {
    this.eAd = parama;
    return this;
  }
  
  public final int getId()
  {
    return 19986;
  }
  
  public final iy pk(long paramLong)
  {
    this.etb = paramLong;
    return this;
  }
  
  public final iy pl(long paramLong)
  {
    this.euA = paramLong;
    return this;
  }
  
  public final iy pm(long paramLong)
  {
    AppMethodBeat.i(221961);
    this.evH = paramLong;
    super.bg("CostTimeMs", this.evH);
    AppMethodBeat.o(221961);
    return this;
  }
  
  public final iy pn(long paramLong)
  {
    this.dWt = paramLong;
    return this;
  }
  
  public final iy po(long paramLong)
  {
    AppMethodBeat.i(221962);
    this.evI = paramLong;
    super.bh("StartTimeStampMs", this.evI);
    AppMethodBeat.o(221962);
    return this;
  }
  
  public final iy pp(long paramLong)
  {
    AppMethodBeat.i(221963);
    this.evJ = paramLong;
    super.bh("EndTimeStampMs", this.evJ);
    AppMethodBeat.o(221963);
    return this;
  }
  
  public final iy rT(String paramString)
  {
    AppMethodBeat.i(221959);
    this.esa = t("InstanceId", paramString, true);
    AppMethodBeat.o(221959);
    return this;
  }
  
  public final iy rU(String paramString)
  {
    AppMethodBeat.i(221960);
    this.euy = t("AppId", paramString, true);
    AppMethodBeat.o(221960);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(221955);
      eAg = new a("release", 0, 1);
      eAh = new a("debug", 1, 2);
      eAi = new a("demo", 2, 3);
      eAj = new a[] { eAg, eAh, eAi };
      AppMethodBeat.o(221955);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jE(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eAg;
      case 2: 
        return eAh;
      }
      return eAi;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(221958);
      eAk = new b("sync", 0, 0);
      eAl = new b("async", 1, 1);
      eAm = new b[] { eAk, eAl };
      AppMethodBeat.o(221958);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.iy
 * JD-Core Version:    0.7.0.1
 */