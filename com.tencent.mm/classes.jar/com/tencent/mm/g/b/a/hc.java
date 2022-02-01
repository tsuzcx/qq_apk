package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hc
  extends a
{
  private long dHY = 0L;
  public String dZT = "";
  public long eaM = 0L;
  public String ecm = "";
  public long eco = 0L;
  public long edd;
  public long edg;
  private long edv = 0L;
  public long edw = 0L;
  public long edx = 0L;
  public long eeA;
  public a eew;
  public String eex;
  public long eey;
  public long eez;
  
  public final String PR()
  {
    AppMethodBeat.i(186186);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.eew != null) {}
    for (int i = this.eew.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.edg);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eey);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eez);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeA);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(186186);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(186187);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eew);
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
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.edg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPatch:").append(this.eey);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.edd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.eez);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LoadingInEndT:").append(this.eeA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(186187);
    return localObject;
  }
  
  public final int getId()
  {
    return 19266;
  }
  
  public final hc lR(long paramLong)
  {
    AppMethodBeat.i(186183);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(186183);
    return this;
  }
  
  public final hc lS(long paramLong)
  {
    AppMethodBeat.i(186184);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(186184);
    return this;
  }
  
  public final hc lT(long paramLong)
  {
    AppMethodBeat.i(186185);
    this.edx = paramLong;
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(186185);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(186182);
      eeB = new a("release", 0, 1);
      eeC = new a("debug", 1, 2);
      eeD = new a("demo", 2, 3);
      eeE = new a[] { eeB, eeC, eeD };
      AppMethodBeat.o(186182);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iR(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eeB;
      case 2: 
        return eeC;
      }
      return eeD;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hc
 * JD-Core Version:    0.7.0.1
 */