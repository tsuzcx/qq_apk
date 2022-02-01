package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hk
  extends a
{
  public long dHY = 0L;
  private String dZT = "";
  public long eaM = 0L;
  private String ecm = "";
  public long eco = 0L;
  private long edv = 0L;
  private long edw = 0L;
  private long edx = 0L;
  private long eeG = 0L;
  public long eeO = 0L;
  public long eeQ = 0L;
  public long eeR = 0L;
  private String eeU = "";
  public a efA;
  private String efB = "";
  
  public final String PR()
  {
    AppMethodBeat.i(43629);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.efA != null) {}
    for (int i = this.efA.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.efB);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeO);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeG);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeR);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeQ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeU);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43629);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43630);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.efA);
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
    ((StringBuffer)localObject).append("package:").append(this.efB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSize:").append(this.eeO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadPageFrame:").append(this.eeG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useCodeCache:").append(this.eeR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineType:").append(this.eeQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.eeU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43630);
    return localObject;
  }
  
  public final int getId()
  {
    return 16005;
  }
  
  public final hk mu(long paramLong)
  {
    AppMethodBeat.i(43624);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(43624);
    return this;
  }
  
  public final hk mv(long paramLong)
  {
    AppMethodBeat.i(43625);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(43625);
    return this;
  }
  
  public final hk mw(long paramLong)
  {
    AppMethodBeat.i(43626);
    this.edx = paramLong;
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(43626);
    return this;
  }
  
  public final hk oB(String paramString)
  {
    AppMethodBeat.i(43622);
    this.dZT = t("InstanceId", paramString, true);
    AppMethodBeat.o(43622);
    return this;
  }
  
  public final hk oC(String paramString)
  {
    AppMethodBeat.i(43623);
    this.ecm = t("AppId", paramString, true);
    AppMethodBeat.o(43623);
    return this;
  }
  
  public final hk oD(String paramString)
  {
    AppMethodBeat.i(43627);
    this.efB = t("package", paramString, true);
    AppMethodBeat.o(43627);
    return this;
  }
  
  public final hk oE(String paramString)
  {
    AppMethodBeat.i(43628);
    this.eeU = t("engineVersion", paramString, true);
    AppMethodBeat.o(43628);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43621);
      efC = new a("release", 0, 1);
      efD = new a("debug", 1, 2);
      efE = new a("demo", 2, 3);
      efF = new a[] { efC, efD, efE };
      AppMethodBeat.o(43621);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iX(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return efC;
      case 2: 
        return efD;
      }
      return efE;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hk
 * JD-Core Version:    0.7.0.1
 */