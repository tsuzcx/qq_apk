package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iz
  extends a
{
  private long dWt = 0L;
  private a eAn;
  public c eAo;
  public b eAp;
  public long eAq = 0L;
  public long ehL = 0L;
  private String esa = "";
  private long etb = 0L;
  private long euA = 0L;
  private String euy = "";
  private long evH = 0L;
  public long evI = 0L;
  private long evJ = 0L;
  private String ewy = "";
  private long ezU = 0L;
  
  public final String RC()
  {
    int j = -1;
    AppMethodBeat.i(43700);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.eAn != null)
    {
      i = this.eAn.value;
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
      if (this.eAo == null) {
        break label309;
      }
    }
    label309:
    for (int i = this.eAo.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.eAp != null) {
        i = this.eAp.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ehL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eAq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewy);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ezU);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(43700);
      return localObject;
      i = -1;
      break;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43701);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eAn);
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
    ((StringBuffer)localObject).append("Ret:").append(this.eAo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.eAp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.ehL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsNormalOpen:").append(this.eAq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.ewy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isParallel:").append(this.ezU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43701);
    return localObject;
  }
  
  public final iz Vv()
  {
    this.ezU = 1L;
    return this;
  }
  
  public final iz a(a parama)
  {
    this.eAn = parama;
    return this;
  }
  
  public final iz a(b paramb)
  {
    this.eAp = paramb;
    return this;
  }
  
  public final iz a(c paramc)
  {
    this.eAo = paramc;
    return this;
  }
  
  public final int getId()
  {
    return 15765;
  }
  
  public final iz pq(long paramLong)
  {
    this.etb = paramLong;
    return this;
  }
  
  public final iz pr(long paramLong)
  {
    this.euA = paramLong;
    return this;
  }
  
  public final iz ps(long paramLong)
  {
    AppMethodBeat.i(43696);
    this.evH = paramLong;
    super.bg("CostTimeMs", this.evH);
    AppMethodBeat.o(43696);
    return this;
  }
  
  public final iz pt(long paramLong)
  {
    this.dWt = paramLong;
    return this;
  }
  
  public final iz pu(long paramLong)
  {
    AppMethodBeat.i(43697);
    this.evI = paramLong;
    super.bh("StartTimeStampMs", this.evI);
    AppMethodBeat.o(43697);
    return this;
  }
  
  public final iz pv(long paramLong)
  {
    AppMethodBeat.i(43698);
    this.evJ = paramLong;
    super.bh("EndTimeStampMs", this.evJ);
    AppMethodBeat.o(43698);
    return this;
  }
  
  public final iz pw(long paramLong)
  {
    this.ehL = paramLong;
    return this;
  }
  
  public final iz px(long paramLong)
  {
    this.eAq = paramLong;
    return this;
  }
  
  public final iz rV(String paramString)
  {
    AppMethodBeat.i(43694);
    this.esa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43694);
    return this;
  }
  
  public final iz rW(String paramString)
  {
    AppMethodBeat.i(43695);
    this.euy = t("AppId", paramString, true);
    AppMethodBeat.o(43695);
    return this;
  }
  
  public final iz rX(String paramString)
  {
    AppMethodBeat.i(43699);
    this.ewy = t("username", paramString, true);
    AppMethodBeat.o(43699);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43687);
      eAr = new a("release", 0, 1);
      eAs = new a("debug", 1, 2);
      eAt = new a("demo", 2, 3);
      eAu = new a[] { eAr, eAs, eAt };
      AppMethodBeat.o(43687);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jF(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eAr;
      case 2: 
        return eAs;
      }
      return eAt;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43690);
      eAv = new b("sync", 0, 0);
      eAw = new b("async", 1, 1);
      eAx = new b[] { eAv, eAw };
      AppMethodBeat.o(43690);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum c
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43693);
      eAy = new c("ok", 0, 0);
      eAz = new c("common_fail", 1, 1);
      eAA = new c("bundle_null", 2, 2);
      eAB = new c("jsapi_control_bytes_null", 3, 3);
      eAC = new c[] { eAy, eAz, eAA, eAB };
      AppMethodBeat.o(43693);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.iz
 * JD-Core Version:    0.7.0.1
 */