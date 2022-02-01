package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gw
  extends a
{
  public long dHY = 0L;
  public String dZT = "";
  public long eaM = 0L;
  public long eaY = 0L;
  public String ecm = "";
  public long eco = 0L;
  public a edJ;
  private long edv = 0L;
  public long edw = 0L;
  public long edx = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(43517);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.edJ != null) {}
    for (int i = this.edJ.value;; i = -1)
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
      AppMethodBeat.o(43517);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43518);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.edJ);
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
    AppMethodBeat.o(43518);
    return localObject;
  }
  
  public final int getId()
  {
    return 16895;
  }
  
  public final gw lA(long paramLong)
  {
    AppMethodBeat.i(43514);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(43514);
    return this;
  }
  
  public final gw lB(long paramLong)
  {
    AppMethodBeat.i(43515);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(43515);
    return this;
  }
  
  public final gw lC(long paramLong)
  {
    AppMethodBeat.i(43516);
    this.edx = paramLong;
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(43516);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43513);
      edK = new a("release", 0, 1);
      edL = new a("debug", 1, 2);
      edM = new a("demo", 2, 3);
      edN = new a[] { edK, edL, edM };
      AppMethodBeat.o(43513);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iL(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return edK;
      case 2: 
        return edL;
      }
      return edM;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gw
 * JD-Core Version:    0.7.0.1
 */