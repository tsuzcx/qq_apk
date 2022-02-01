package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gu
  extends a
{
  public long dHY = 0L;
  public String dZT = "";
  public long eaM = 0L;
  public String ecm = "";
  public long eco = 0L;
  public a edu;
  private long edv = 0L;
  public long edw = 0L;
  public long edx = 0L;
  public long edy = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(43499);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.edu != null) {}
    for (int i = this.edu.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.edy);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43499);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43500);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.edu);
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
    ((StringBuffer)localObject).append("BootstepType:").append(this.edy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43500);
    return localObject;
  }
  
  public final int getId()
  {
    return 16900;
  }
  
  public final gu lv(long paramLong)
  {
    AppMethodBeat.i(43496);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(43496);
    return this;
  }
  
  public final gu lw(long paramLong)
  {
    AppMethodBeat.i(43497);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(43497);
    return this;
  }
  
  public final gu lx(long paramLong)
  {
    AppMethodBeat.i(43498);
    this.edx = paramLong;
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(43498);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43495);
      edz = new a("release", 0, 1);
      edA = new a("debug", 1, 2);
      edB = new a("demo", 2, 3);
      edC = new a[] { edz, edA, edB };
      AppMethodBeat.o(43495);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iJ(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return edz;
      case 2: 
        return edA;
      }
      return edB;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gu
 * JD-Core Version:    0.7.0.1
 */