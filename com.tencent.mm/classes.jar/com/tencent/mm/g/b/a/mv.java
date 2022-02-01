package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mv
  extends a
{
  public long eJb = 0L;
  private String eJx = "";
  private String eWb = "";
  private long eXc = 0L;
  private long eYW = 0L;
  private long erW = 0L;
  private String faT = "";
  private long fac = 0L;
  public long fad = 0L;
  private long fae = 0L;
  private a feK;
  public c feL;
  public b feM;
  public long feN = 0L;
  private long fer = 0L;
  
  public final mv Ad(String paramString)
  {
    AppMethodBeat.i(43694);
    this.eWb = x("InstanceId", paramString, true);
    AppMethodBeat.o(43694);
    return this;
  }
  
  public final mv Ae(String paramString)
  {
    AppMethodBeat.i(43695);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(43695);
    return this;
  }
  
  public final mv Af(String paramString)
  {
    AppMethodBeat.i(43699);
    this.faT = x("username", paramString, true);
    AppMethodBeat.o(43699);
    return this;
  }
  
  public final mv a(a parama)
  {
    this.feK = parama;
    return this;
  }
  
  public final mv a(b paramb)
  {
    this.feM = paramb;
    return this;
  }
  
  public final mv a(c paramc)
  {
    this.feL = paramc;
    return this;
  }
  
  public final String abV()
  {
    int j = -1;
    AppMethodBeat.i(43700);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.feK != null)
    {
      i = this.feK.value;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eYW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fac);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.erW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fad);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fae);
      ((StringBuffer)localObject).append(",");
      if (this.feL == null) {
        break label309;
      }
    }
    label309:
    for (int i = this.feL.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.feM != null) {
        i = this.feM.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eJb);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.feN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.faT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fer);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(43700);
      return localObject;
      i = -1;
      break;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43701);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.feK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eYW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.fac);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.fad);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.fae);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Ret:").append(this.feL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.feM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.eJb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsNormalOpen:").append(this.feN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.faT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isParallel:").append(this.fer);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43701);
    return localObject;
  }
  
  public final mv ajl()
  {
    this.fer = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 15765;
  }
  
  public final mv xb(long paramLong)
  {
    this.eXc = paramLong;
    return this;
  }
  
  public final mv xc(long paramLong)
  {
    this.eYW = paramLong;
    return this;
  }
  
  public final mv xd(long paramLong)
  {
    AppMethodBeat.i(43696);
    this.fac = paramLong;
    super.bi("CostTimeMs", this.fac);
    AppMethodBeat.o(43696);
    return this;
  }
  
  public final mv xe(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final mv xf(long paramLong)
  {
    AppMethodBeat.i(43697);
    this.fad = paramLong;
    super.bj("StartTimeStampMs", this.fad);
    AppMethodBeat.o(43697);
    return this;
  }
  
  public final mv xg(long paramLong)
  {
    AppMethodBeat.i(43698);
    this.fae = paramLong;
    super.bj("EndTimeStampMs", this.fae);
    AppMethodBeat.o(43698);
    return this;
  }
  
  public final mv xh(long paramLong)
  {
    this.eJb = paramLong;
    return this;
  }
  
  public final mv xi(long paramLong)
  {
    this.feN = paramLong;
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43687);
      feO = new a("release", 0, 1);
      feP = new a("debug", 1, 2);
      feQ = new a("demo", 2, 3);
      feR = new a[] { feO, feP, feQ };
      AppMethodBeat.o(43687);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a mH(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return feO;
      case 2: 
        return feP;
      }
      return feQ;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43690);
      feS = new b("sync", 0, 0);
      feT = new b("async", 1, 1);
      feU = new b[] { feS, feT };
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
      feV = new c("ok", 0, 0);
      feW = new c("common_fail", 1, 1);
      feX = new c("bundle_null", 2, 2);
      feY = new c("jsapi_control_bytes_null", 3, 3);
      feZ = new c[] { feV, feW, feX, feY };
      AppMethodBeat.o(43693);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.mv
 * JD-Core Version:    0.7.0.1
 */