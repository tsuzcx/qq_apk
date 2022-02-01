package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hj
  extends a
{
  public long dHY = 0L;
  public String dZT = "";
  public long eaM = 0L;
  public String ecm = "";
  public long eco = 0L;
  private long edv = 0L;
  private long edw = 0L;
  private long edx = 0L;
  public long eeO = 0L;
  public long eeQ = 0L;
  public long eeR = 0L;
  public String eeU = "";
  public String eex = "";
  public a efu;
  public String efv = "";
  
  public final String PR()
  {
    AppMethodBeat.i(43617);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.efu != null) {}
    for (int i = this.efu.value;; i = -1)
    {
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
      ((StringBuffer)localObject).append(this.eex);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.efv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeO);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeR);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeQ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeU);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43617);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43618);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.efu);
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
    ((StringBuffer)localObject).append("path:").append(this.eex);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("referrer:").append(this.efv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSize:").append(this.eeO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useCodeCache:").append(this.eeR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineType:").append(this.eeQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.eeU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43618);
    return localObject;
  }
  
  public final int getId()
  {
    return 16006;
  }
  
  public final hj mr(long paramLong)
  {
    AppMethodBeat.i(43614);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(43614);
    return this;
  }
  
  public final hj ms(long paramLong)
  {
    AppMethodBeat.i(43615);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(43615);
    return this;
  }
  
  public final hj mt(long paramLong)
  {
    AppMethodBeat.i(43616);
    this.edx = paramLong;
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(43616);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43613);
      efw = new a("release", 0, 1);
      efx = new a("debug", 1, 2);
      efy = new a("demo", 2, 3);
      efz = new a[] { efw, efx, efy };
      AppMethodBeat.o(43613);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iW(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return efw;
      case 2: 
        return efx;
      }
      return efy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hj
 * JD-Core Version:    0.7.0.1
 */