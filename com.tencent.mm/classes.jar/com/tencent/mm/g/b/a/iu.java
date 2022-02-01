package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iu
  extends a
{
  public String dTi = "";
  public long dVd = 0L;
  public long ega = 0L;
  private String eqt = "";
  public long eru = 0L;
  private String esR = "";
  public long esT = 0L;
  private long eua = 0L;
  private long eub = 0L;
  private long euc = 0L;
  public a exV;
  public c exW;
  public b exX;
  
  public final String RD()
  {
    int j = -1;
    AppMethodBeat.i(43668);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    if (this.exV != null)
    {
      i = this.exV.value;
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
      if (this.exW == null) {
        break label277;
      }
    }
    label277:
    for (int i = this.exW.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.exX != null) {
        i = this.exX.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ega);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dTi);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(43668);
      return localObject;
      i = -1;
      break;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43669);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.exV);
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
    ((StringBuffer)localObject).append("Ret:").append(this.exW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.exX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.ega);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.dTi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43669);
    return localObject;
  }
  
  public final iu a(a parama)
  {
    this.exV = parama;
    return this;
  }
  
  public final int getId()
  {
    return 15764;
  }
  
  public final iu oJ(long paramLong)
  {
    this.eru = paramLong;
    return this;
  }
  
  public final iu oK(long paramLong)
  {
    this.esT = paramLong;
    return this;
  }
  
  public final iu oL(long paramLong)
  {
    AppMethodBeat.i(43665);
    this.eua = paramLong;
    super.bf("CostTimeMs", this.eua);
    AppMethodBeat.o(43665);
    return this;
  }
  
  public final iu oM(long paramLong)
  {
    this.dVd = paramLong;
    return this;
  }
  
  public final iu oN(long paramLong)
  {
    AppMethodBeat.i(43666);
    this.eub = paramLong;
    super.bg("StartTimeStampMs", this.eub);
    AppMethodBeat.o(43666);
    return this;
  }
  
  public final iu oO(long paramLong)
  {
    AppMethodBeat.i(43667);
    this.euc = paramLong;
    super.bg("EndTimeStampMs", this.euc);
    AppMethodBeat.o(43667);
    return this;
  }
  
  public final iu rt(String paramString)
  {
    AppMethodBeat.i(43663);
    this.eqt = t("InstanceId", paramString, true);
    AppMethodBeat.o(43663);
    return this;
  }
  
  public final iu ru(String paramString)
  {
    AppMethodBeat.i(43664);
    this.esR = t("AppId", paramString, true);
    AppMethodBeat.o(43664);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43656);
      exY = new a("release", 0, 1);
      exZ = new a("debug", 1, 2);
      eya = new a("demo", 2, 3);
      eyb = new a[] { exY, exZ, eya };
      AppMethodBeat.o(43656);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jz(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return exY;
      case 2: 
        return exZ;
      }
      return eya;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43659);
      eyc = new b("sync", 0, 0);
      eyd = new b("async", 1, 1);
      eyf = new b[] { eyc, eyd };
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
      eyg = new c("ok", 0, 0);
      eyh = new c("common_fail", 1, 1);
      eyi = new c[] { eyg, eyh };
      AppMethodBeat.o(43662);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.iu
 * JD-Core Version:    0.7.0.1
 */