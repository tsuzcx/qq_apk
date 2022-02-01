package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ga
  extends a
{
  private long dKe = 0L;
  public long dON = 0L;
  private long dYT = 0L;
  private String dYa = "";
  private String eag = "";
  private long eai = 0L;
  private long ebp = 0L;
  public long ebq = 0L;
  private long ebr = 0L;
  private a efn;
  public long efo = 0L;
  public ga.b efp;
  
  public final String PV()
  {
    int j = -1;
    AppMethodBeat.i(195501);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.efn != null) {}
    for (int i = this.efn.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eai);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dKe);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.efo);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.efp != null) {
        i = this.efp.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dON);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(195501);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(195502);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.efn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eai);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.ebp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.ebq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.ebr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Ret:").append(this.efo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.efp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.dON);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195502);
    return localObject;
  }
  
  public final ga a(a parama)
  {
    this.efn = parama;
    return this;
  }
  
  public final int getId()
  {
    return 19986;
  }
  
  public final ga jA(long paramLong)
  {
    this.dKe = paramLong;
    return this;
  }
  
  public final ga jB(long paramLong)
  {
    AppMethodBeat.i(195499);
    this.ebq = paramLong;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(195499);
    return this;
  }
  
  public final ga jC(long paramLong)
  {
    AppMethodBeat.i(195500);
    this.ebr = paramLong;
    super.bb("EndTimeStampMs", this.ebr);
    AppMethodBeat.o(195500);
    return this;
  }
  
  public final ga jx(long paramLong)
  {
    this.dYT = paramLong;
    return this;
  }
  
  public final ga jy(long paramLong)
  {
    this.eai = paramLong;
    return this;
  }
  
  public final ga jz(long paramLong)
  {
    AppMethodBeat.i(195498);
    this.ebp = paramLong;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(195498);
    return this;
  }
  
  public final ga lM(String paramString)
  {
    AppMethodBeat.i(195496);
    this.dYa = t("InstanceId", paramString, true);
    AppMethodBeat.o(195496);
    return this;
  }
  
  public final ga lN(String paramString)
  {
    AppMethodBeat.i(195497);
    this.eag = t("AppId", paramString, true);
    AppMethodBeat.o(195497);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(195492);
      efq = new a("release", 0, 1);
      efr = new a("debug", 1, 2);
      efs = new a("demo", 2, 3);
      eft = new a[] { efq, efr, efs };
      AppMethodBeat.o(195492);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jh(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return efq;
      case 2: 
        return efr;
      }
      return efs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ga
 * JD-Core Version:    0.7.0.1
 */