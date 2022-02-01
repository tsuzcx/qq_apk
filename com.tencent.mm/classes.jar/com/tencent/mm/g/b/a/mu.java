package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mu
  extends a
{
  public long eJb = 0L;
  private String eJx = "";
  private String eWb = "";
  private long eXc = 0L;
  private long eYW = 0L;
  private long erW = 0L;
  private long fac = 0L;
  public long fad = 0L;
  private long fae = 0L;
  private a feA;
  public long feB = 0L;
  public b feC;
  
  public final mu Ab(String paramString)
  {
    AppMethodBeat.i(226095);
    this.eWb = x("InstanceId", paramString, true);
    AppMethodBeat.o(226095);
    return this;
  }
  
  public final mu Ac(String paramString)
  {
    AppMethodBeat.i(226096);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(226096);
    return this;
  }
  
  public final mu a(a parama)
  {
    this.feA = parama;
    return this;
  }
  
  public final String abV()
  {
    int j = -1;
    AppMethodBeat.i(226100);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.feA != null) {}
    for (int i = this.feA.value;; i = -1)
    {
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
      ((StringBuffer)localObject).append(this.feB);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.feC != null) {
        i = this.feC.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eJb);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(226100);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(226101);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.feA);
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
    ((StringBuffer)localObject).append("Ret:").append(this.feB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.feC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.eJb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(226101);
    return localObject;
  }
  
  public final int getId()
  {
    return 19986;
  }
  
  public final mu wV(long paramLong)
  {
    this.eXc = paramLong;
    return this;
  }
  
  public final mu wW(long paramLong)
  {
    this.eYW = paramLong;
    return this;
  }
  
  public final mu wX(long paramLong)
  {
    AppMethodBeat.i(226097);
    this.fac = paramLong;
    super.bi("CostTimeMs", this.fac);
    AppMethodBeat.o(226097);
    return this;
  }
  
  public final mu wY(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final mu wZ(long paramLong)
  {
    AppMethodBeat.i(226098);
    this.fad = paramLong;
    super.bj("StartTimeStampMs", this.fad);
    AppMethodBeat.o(226098);
    return this;
  }
  
  public final mu xa(long paramLong)
  {
    AppMethodBeat.i(226099);
    this.fae = paramLong;
    super.bj("EndTimeStampMs", this.fae);
    AppMethodBeat.o(226099);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(226091);
      feD = new a("release", 0, 1);
      feE = new a("debug", 1, 2);
      feF = new a("demo", 2, 3);
      feG = new a[] { feD, feE, feF };
      AppMethodBeat.o(226091);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a mG(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return feD;
      case 2: 
        return feE;
      }
      return feF;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(226094);
      feH = new b("sync", 0, 0);
      feI = new b("async", 1, 1);
      feJ = new b[] { feH, feI };
      AppMethodBeat.o(226094);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.mu
 * JD-Core Version:    0.7.0.1
 */