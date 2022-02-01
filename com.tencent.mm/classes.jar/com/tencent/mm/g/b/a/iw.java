package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iw
  extends a
{
  private long dVd = 0L;
  public long ega = 0L;
  private String eqt = "";
  private long eru = 0L;
  private String esR = "";
  private long esT = 0L;
  private long eua = 0L;
  public long eub = 0L;
  private long euc = 0L;
  private a eyu;
  public long eyv = 0L;
  public b eyw;
  
  public final String RD()
  {
    int j = -1;
    AppMethodBeat.i(187855);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    if (this.eyu != null) {}
    for (int i = this.eyu.value;; i = -1)
    {
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
      ((StringBuffer)localObject).append(this.eyv);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.eyw != null) {
        i = this.eyw.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ega);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(187855);
      return localObject;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(187856);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eyu);
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
    ((StringBuffer)localObject).append("Ret:").append(this.eyv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.eyw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.ega);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(187856);
    return localObject;
  }
  
  public final iw a(a parama)
  {
    this.eyu = parama;
    return this;
  }
  
  public final int getId()
  {
    return 19986;
  }
  
  public final iw oX(long paramLong)
  {
    this.eru = paramLong;
    return this;
  }
  
  public final iw oY(long paramLong)
  {
    this.esT = paramLong;
    return this;
  }
  
  public final iw oZ(long paramLong)
  {
    AppMethodBeat.i(187852);
    this.eua = paramLong;
    super.bf("CostTimeMs", this.eua);
    AppMethodBeat.o(187852);
    return this;
  }
  
  public final iw pa(long paramLong)
  {
    this.dVd = paramLong;
    return this;
  }
  
  public final iw pb(long paramLong)
  {
    AppMethodBeat.i(187853);
    this.eub = paramLong;
    super.bg("StartTimeStampMs", this.eub);
    AppMethodBeat.o(187853);
    return this;
  }
  
  public final iw pc(long paramLong)
  {
    AppMethodBeat.i(187854);
    this.euc = paramLong;
    super.bg("EndTimeStampMs", this.euc);
    AppMethodBeat.o(187854);
    return this;
  }
  
  public final iw ry(String paramString)
  {
    AppMethodBeat.i(187850);
    this.eqt = t("InstanceId", paramString, true);
    AppMethodBeat.o(187850);
    return this;
  }
  
  public final iw rz(String paramString)
  {
    AppMethodBeat.i(187851);
    this.esR = t("AppId", paramString, true);
    AppMethodBeat.o(187851);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(187846);
      eyx = new a("release", 0, 1);
      eyy = new a("debug", 1, 2);
      eyz = new a("demo", 2, 3);
      eyA = new a[] { eyx, eyy, eyz };
      AppMethodBeat.o(187846);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jC(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eyx;
      case 2: 
        return eyy;
      }
      return eyz;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(187849);
      eyB = new b("sync", 0, 0);
      eyC = new b("async", 1, 1);
      eyD = new b[] { eyB, eyC };
      AppMethodBeat.o(187849);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.iw
 * JD-Core Version:    0.7.0.1
 */