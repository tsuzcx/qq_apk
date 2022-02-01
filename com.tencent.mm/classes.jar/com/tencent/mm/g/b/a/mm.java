package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mm
  extends a
{
  private String eJx = "";
  private String eWb = "";
  public long eXc = 0L;
  public long eYW = 0L;
  public long erW = 0L;
  private String faI = "";
  private long fac = 0L;
  private long fad = 0L;
  private long fae = 0L;
  public long fbD = 0L;
  public long fbF = 0L;
  public long fbG = 0L;
  private long fbv = 0L;
  public a fcv;
  private String fcw = "";
  private String fcx = "";
  
  public final String abV()
  {
    AppMethodBeat.i(43629);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.fcv != null) {}
    for (int i = this.fcv.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.fcw);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbG);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbF);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.faI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fcx);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(43629);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43630);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.fcv);
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
    ((StringBuffer)localObject).append("package:").append(this.fcw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSize:").append(this.fbD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadPageFrame:").append(this.fbv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useCodeCache:").append(this.fbG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineType:").append(this.fbF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.faI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lazyLoadKey:").append(this.fcx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43630);
    return localObject;
  }
  
  public final int getId()
  {
    return 16005;
  }
  
  public final mm wq(long paramLong)
  {
    AppMethodBeat.i(43624);
    this.fac = paramLong;
    super.bi("CostTimeMs", this.fac);
    AppMethodBeat.o(43624);
    return this;
  }
  
  public final mm wr(long paramLong)
  {
    AppMethodBeat.i(43625);
    this.fad = paramLong;
    super.bj("StartTimeStampMs", this.fad);
    AppMethodBeat.o(43625);
    return this;
  }
  
  public final mm ws(long paramLong)
  {
    AppMethodBeat.i(43626);
    this.fae = paramLong;
    super.bj("EndTimeStampMs", this.fae);
    AppMethodBeat.o(43626);
    return this;
  }
  
  public final mm zK(String paramString)
  {
    AppMethodBeat.i(43622);
    this.eWb = x("InstanceId", paramString, true);
    AppMethodBeat.o(43622);
    return this;
  }
  
  public final mm zL(String paramString)
  {
    AppMethodBeat.i(43623);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(43623);
    return this;
  }
  
  public final mm zM(String paramString)
  {
    AppMethodBeat.i(43627);
    this.fcw = x("package", paramString, true);
    AppMethodBeat.o(43627);
    return this;
  }
  
  public final mm zN(String paramString)
  {
    AppMethodBeat.i(43628);
    this.faI = x("engineVersion", paramString, true);
    AppMethodBeat.o(43628);
    return this;
  }
  
  public final mm zO(String paramString)
  {
    AppMethodBeat.i(226088);
    this.fcx = x("lazyLoadKey", paramString, true);
    AppMethodBeat.o(226088);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43621);
      fcy = new a("release", 0, 1);
      fcz = new a("debug", 1, 2);
      fcA = new a("demo", 2, 3);
      fcB = new a[] { fcy, fcz, fcA };
      AppMethodBeat.o(43621);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a my(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return fcy;
      case 2: 
        return fcz;
      }
      return fcA;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.mm
 * JD-Core Version:    0.7.0.1
 */