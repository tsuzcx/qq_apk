package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gy
  extends a
{
  public long dHY = 0L;
  public String dZT = "";
  public long eaM = 0L;
  public long eaY = 0L;
  public String ecm = "";
  public long eco = 0L;
  public a edU;
  private long edv = 0L;
  public long edw = 0L;
  public long edx = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(43533);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.edU != null) {}
    for (int i = this.edU.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.eaY);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43533);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43534);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.edU);
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
    ((StringBuffer)localObject).append("type:").append(this.eaY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43534);
    return localObject;
  }
  
  public final int getId()
  {
    return 16899;
  }
  
  public final gy lG(long paramLong)
  {
    AppMethodBeat.i(43530);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(43530);
    return this;
  }
  
  public final gy lH(long paramLong)
  {
    AppMethodBeat.i(43531);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(43531);
    return this;
  }
  
  public final gy lI(long paramLong)
  {
    AppMethodBeat.i(43532);
    this.edx = paramLong;
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(43532);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43529);
      edV = new a("release", 0, 1);
      edW = new a("debug", 1, 2);
      edX = new a("demo", 2, 3);
      edY = new a[] { edV, edW, edX };
      AppMethodBeat.o(43529);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iN(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return edV;
      case 2: 
        return edW;
      }
      return edX;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gy
 * JD-Core Version:    0.7.0.1
 */