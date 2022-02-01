package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ix
  extends a
{
  private long dVd = 0L;
  public long ega = 0L;
  private String eqt = "";
  private long eru = 0L;
  private String esR = "";
  private long esT = 0L;
  private String euR;
  private long eua = 0L;
  public long eub = 0L;
  private long euc = 0L;
  private a eyE;
  public c eyF;
  public b eyG;
  public long eyH = 0L;
  private long eyl = 0L;
  
  public final String RD()
  {
    int j = -1;
    AppMethodBeat.i(43700);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    if (this.eyE != null)
    {
      i = this.eyE.value;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.esT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eua);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dVd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eub);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euc);
      ((StringBuffer)localObject).append(",");
      if (this.eyF == null) {
        break label309;
      }
    }
    label309:
    for (int i = this.eyF.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.eyG != null) {
        i = this.eyG.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ega);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eyH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euR);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eyl);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(43700);
      return localObject;
      i = -1;
      break;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43701);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eyE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.esT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.eua);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.eub);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.euc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Ret:").append(this.eyF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.eyG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.ega);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsNormalOpen:").append(this.eyH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.euR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isParallel:").append(this.eyl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43701);
    return localObject;
  }
  
  public final ix Vn()
  {
    this.eyl = 1L;
    return this;
  }
  
  public final ix a(a parama)
  {
    this.eyE = parama;
    return this;
  }
  
  public final ix a(b paramb)
  {
    this.eyG = paramb;
    return this;
  }
  
  public final ix a(c paramc)
  {
    this.eyF = paramc;
    return this;
  }
  
  public final int getId()
  {
    return 15765;
  }
  
  public final ix pd(long paramLong)
  {
    this.eru = paramLong;
    return this;
  }
  
  public final ix pe(long paramLong)
  {
    this.esT = paramLong;
    return this;
  }
  
  public final ix pf(long paramLong)
  {
    AppMethodBeat.i(43696);
    this.eua = paramLong;
    super.bf("CostTimeMs", this.eua);
    AppMethodBeat.o(43696);
    return this;
  }
  
  public final ix pg(long paramLong)
  {
    this.dVd = paramLong;
    return this;
  }
  
  public final ix ph(long paramLong)
  {
    AppMethodBeat.i(43697);
    this.eub = paramLong;
    super.bg("StartTimeStampMs", this.eub);
    AppMethodBeat.o(43697);
    return this;
  }
  
  public final ix pi(long paramLong)
  {
    AppMethodBeat.i(43698);
    this.euc = paramLong;
    super.bg("EndTimeStampMs", this.euc);
    AppMethodBeat.o(43698);
    return this;
  }
  
  public final ix pj(long paramLong)
  {
    this.ega = paramLong;
    return this;
  }
  
  public final ix pk(long paramLong)
  {
    this.eyH = paramLong;
    return this;
  }
  
  public final ix rA(String paramString)
  {
    AppMethodBeat.i(43694);
    this.eqt = t("InstanceId", paramString, true);
    AppMethodBeat.o(43694);
    return this;
  }
  
  public final ix rB(String paramString)
  {
    AppMethodBeat.i(43695);
    this.esR = t("AppId", paramString, true);
    AppMethodBeat.o(43695);
    return this;
  }
  
  public final ix rC(String paramString)
  {
    AppMethodBeat.i(43699);
    this.euR = t("username", paramString, true);
    AppMethodBeat.o(43699);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43687);
      eyI = new a("release", 0, 1);
      eyJ = new a("debug", 1, 2);
      eyK = new a("demo", 2, 3);
      eyL = new a[] { eyI, eyJ, eyK };
      AppMethodBeat.o(43687);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jD(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eyI;
      case 2: 
        return eyJ;
      }
      return eyK;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43690);
      eyM = new b("sync", 0, 0);
      eyN = new b("async", 1, 1);
      eyO = new b[] { eyM, eyN };
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
      eyP = new c("ok", 0, 0);
      eyQ = new c("common_fail", 1, 1);
      eyR = new c("bundle_null", 2, 2);
      eyS = new c("jsapi_control_bytes_null", 3, 3);
      eyT = new c[] { eyP, eyQ, eyR, eyS };
      AppMethodBeat.o(43693);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ix
 * JD-Core Version:    0.7.0.1
 */