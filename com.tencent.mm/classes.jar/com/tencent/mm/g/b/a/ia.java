package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ia
  extends a
{
  public long dVd = 0L;
  public String eqt = "";
  public long eru = 0L;
  public String esR = "";
  public long esT = 0L;
  private long eua = 0L;
  public long eub = 0L;
  public long euc = 0L;
  public a eut;
  public long euu = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(43525);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    if (this.eut != null) {}
    for (int i = this.eut.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.euu);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(43525);
      return localObject;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43526);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eut);
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
    ((StringBuffer)localObject).append("isFromAndroidRecents:").append(this.euu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43526);
    return localObject;
  }
  
  public final int getId()
  {
    return 16898;
  }
  
  public final ia nx(long paramLong)
  {
    AppMethodBeat.i(43522);
    this.eua = paramLong;
    super.bf("CostTimeMs", this.eua);
    AppMethodBeat.o(43522);
    return this;
  }
  
  public final ia ny(long paramLong)
  {
    AppMethodBeat.i(43523);
    this.eub = paramLong;
    super.bg("StartTimeStampMs", this.eub);
    AppMethodBeat.o(43523);
    return this;
  }
  
  public final ia nz(long paramLong)
  {
    AppMethodBeat.i(43524);
    this.euc = paramLong;
    super.bg("EndTimeStampMs", this.euc);
    AppMethodBeat.o(43524);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43521);
      euv = new a("release", 0, 1);
      euw = new a("debug", 1, 2);
      eux = new a("demo", 2, 3);
      euy = new a[] { euv, euw, eux };
      AppMethodBeat.o(43521);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jf(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return euv;
      case 2: 
        return euw;
      }
      return eux;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ia
 * JD-Core Version:    0.7.0.1
 */