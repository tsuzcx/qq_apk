package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ml
  extends a
{
  public String eJx = "";
  public String eWb = "";
  public long eXc = 0L;
  public long eYW = 0L;
  public long erW = 0L;
  public String faI = "";
  private long fac = 0L;
  private long fad = 0L;
  private long fae = 0L;
  public long fbD = 0L;
  public long fbF = 0L;
  public long fbG = 0L;
  public String fbm = "";
  public a fcp;
  public String fcq = "";
  
  public final String abV()
  {
    AppMethodBeat.i(43617);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.fcp != null) {}
    for (int i = this.fcp.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.fbm);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fcq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbG);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbF);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.faI);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(43617);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43618);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.fcp);
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
    ((StringBuffer)localObject).append("path:").append(this.fbm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("referrer:").append(this.fcq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSize:").append(this.fbD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useCodeCache:").append(this.fbG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineType:").append(this.fbF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.faI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43618);
    return localObject;
  }
  
  public final int getId()
  {
    return 16006;
  }
  
  public final ml wn(long paramLong)
  {
    AppMethodBeat.i(43614);
    this.fac = paramLong;
    super.bi("CostTimeMs", this.fac);
    AppMethodBeat.o(43614);
    return this;
  }
  
  public final ml wo(long paramLong)
  {
    AppMethodBeat.i(43615);
    this.fad = paramLong;
    super.bj("StartTimeStampMs", this.fad);
    AppMethodBeat.o(43615);
    return this;
  }
  
  public final ml wp(long paramLong)
  {
    AppMethodBeat.i(43616);
    this.fae = paramLong;
    super.bj("EndTimeStampMs", this.fae);
    AppMethodBeat.o(43616);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43613);
      fcr = new a("release", 0, 1);
      fcs = new a("debug", 1, 2);
      fct = new a("demo", 2, 3);
      fcu = new a[] { fcr, fcs, fct };
      AppMethodBeat.o(43613);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a mx(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return fcr;
      case 2: 
        return fcs;
      }
      return fct;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ml
 * JD-Core Version:    0.7.0.1
 */