package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hq
  extends a
{
  public String dGd = "";
  public long dHY = 0L;
  public long dQE = 0L;
  private String dZT = "";
  public long eaM = 0L;
  private String ecm = "";
  public long eco = 0L;
  private long edv = 0L;
  private long edw = 0L;
  private long edx = 0L;
  public a egW;
  public c egX;
  public b egY;
  
  public final String PR()
  {
    int j = -1;
    AppMethodBeat.i(43668);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.egW != null)
    {
      i = this.egW.value;
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
      if (this.egX == null) {
        break label277;
      }
    }
    label277:
    for (int i = this.egX.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.egY != null) {
        i = this.egY.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dQE);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dGd);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43668);
      return localObject;
      i = -1;
      break;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43669);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.egW);
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
    ((StringBuffer)localObject).append("Ret:").append(this.egX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.egY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.dQE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.dGd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43669);
    return localObject;
  }
  
  public final hq a(a parama)
  {
    this.egW = parama;
    return this;
  }
  
  public final int getId()
  {
    return 15764;
  }
  
  public final hq mL(long paramLong)
  {
    this.eaM = paramLong;
    return this;
  }
  
  public final hq mM(long paramLong)
  {
    this.eco = paramLong;
    return this;
  }
  
  public final hq mN(long paramLong)
  {
    AppMethodBeat.i(43665);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(43665);
    return this;
  }
  
  public final hq mO(long paramLong)
  {
    this.dHY = paramLong;
    return this;
  }
  
  public final hq mP(long paramLong)
  {
    AppMethodBeat.i(43666);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(43666);
    return this;
  }
  
  public final hq mQ(long paramLong)
  {
    AppMethodBeat.i(43667);
    this.edx = paramLong;
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(43667);
    return this;
  }
  
  public final hq oM(String paramString)
  {
    AppMethodBeat.i(43663);
    this.dZT = t("InstanceId", paramString, true);
    AppMethodBeat.o(43663);
    return this;
  }
  
  public final hq oN(String paramString)
  {
    AppMethodBeat.i(43664);
    this.ecm = t("AppId", paramString, true);
    AppMethodBeat.o(43664);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43656);
      egZ = new a("release", 0, 1);
      eha = new a("debug", 1, 2);
      ehb = new a("demo", 2, 3);
      ehc = new a[] { egZ, eha, ehb };
      AppMethodBeat.o(43656);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jc(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return egZ;
      case 2: 
        return eha;
      }
      return ehb;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43659);
      ehd = new b("sync", 0, 0);
      ehe = new b("async", 1, 1);
      ehf = new b[] { ehd, ehe };
      AppMethodBeat.o(43659);
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
      AppMethodBeat.i(43662);
      ehg = new c("ok", 0, 0);
      ehh = new c("common_fail", 1, 1);
      ehi = new c[] { ehg, ehh };
      AppMethodBeat.o(43662);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hq
 * JD-Core Version:    0.7.0.1
 */