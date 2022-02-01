package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ht
  extends a
{
  private long dHY = 0L;
  public long dQE = 0L;
  private String dZT = "";
  private long eaM = 0L;
  private String ecm = "";
  private long eco = 0L;
  private long edv = 0L;
  public long edw = 0L;
  private long edx = 0L;
  private String eel;
  private a ehE;
  public c ehF;
  public b ehG;
  public long ehH = 0L;
  private long ehl = 0L;
  
  public final String PR()
  {
    int j = -1;
    AppMethodBeat.i(43700);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.ehE != null)
    {
      i = this.ehE.value;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eco);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dHY);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edw);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edx);
      ((StringBuffer)localObject).append(",");
      if (this.ehF == null) {
        break label309;
      }
    }
    label309:
    for (int i = this.ehF.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.ehG != null) {
        i = this.ehG.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dQE);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ehH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eel);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ehl);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43700);
      return localObject;
      i = -1;
      break;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43701);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ehE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eco);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.edv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.edw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.edx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Ret:").append(this.ehF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.ehG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.dQE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsNormalOpen:").append(this.ehH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.eel);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isParallel:").append(this.ehl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43701);
    return localObject;
  }
  
  public final ht Ta()
  {
    this.ehl = 1L;
    return this;
  }
  
  public final ht a(a parama)
  {
    this.ehE = parama;
    return this;
  }
  
  public final ht a(b paramb)
  {
    this.ehG = paramb;
    return this;
  }
  
  public final ht a(c paramc)
  {
    this.ehF = paramc;
    return this;
  }
  
  public final int getId()
  {
    return 15765;
  }
  
  public final ht nf(long paramLong)
  {
    this.eaM = paramLong;
    return this;
  }
  
  public final ht ng(long paramLong)
  {
    this.eco = paramLong;
    return this;
  }
  
  public final ht nh(long paramLong)
  {
    AppMethodBeat.i(43696);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(43696);
    return this;
  }
  
  public final ht ni(long paramLong)
  {
    this.dHY = paramLong;
    return this;
  }
  
  public final ht nj(long paramLong)
  {
    AppMethodBeat.i(43697);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(43697);
    return this;
  }
  
  public final ht nk(long paramLong)
  {
    AppMethodBeat.i(43698);
    this.edx = paramLong;
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(43698);
    return this;
  }
  
  public final ht nl(long paramLong)
  {
    this.dQE = paramLong;
    return this;
  }
  
  public final ht nm(long paramLong)
  {
    this.ehH = paramLong;
    return this;
  }
  
  public final ht oT(String paramString)
  {
    AppMethodBeat.i(43694);
    this.dZT = t("InstanceId", paramString, true);
    AppMethodBeat.o(43694);
    return this;
  }
  
  public final ht oU(String paramString)
  {
    AppMethodBeat.i(43695);
    this.ecm = t("AppId", paramString, true);
    AppMethodBeat.o(43695);
    return this;
  }
  
  public final ht oV(String paramString)
  {
    AppMethodBeat.i(43699);
    this.eel = t("username", paramString, true);
    AppMethodBeat.o(43699);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43687);
      ehI = new a("release", 0, 1);
      ehJ = new a("debug", 1, 2);
      ehK = new a("demo", 2, 3);
      ehL = new a[] { ehI, ehJ, ehK };
      AppMethodBeat.o(43687);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jg(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ehI;
      case 2: 
        return ehJ;
      }
      return ehK;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43690);
      ehM = new b("sync", 0, 0);
      ehN = new b("async", 1, 1);
      ehO = new b[] { ehM, ehN };
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
      ehP = new c("ok", 0, 0);
      ehQ = new c("common_fail", 1, 1);
      ehR = new c("bundle_null", 2, 2);
      ehS = new c("jsapi_control_bytes_null", 3, 3);
      ehT = new c[] { ehP, ehQ, ehR, ehS };
      AppMethodBeat.o(43693);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ht
 * JD-Core Version:    0.7.0.1
 */