package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mo
  extends a
{
  private String eJx = "";
  private String eWb = "";
  private long eXc = 0L;
  private long eYW = 0L;
  private long erW = 0L;
  private long fac = 0L;
  private long fad = 0L;
  private long fae = 0L;
  private a fcG;
  private long fcH = 0L;
  private long fcI = 0L;
  private String fcJ = "";
  private long fcK = 0L;
  
  public final mo a(a parama)
  {
    this.fcG = parama;
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(43639);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.fcG != null) {}
    for (int i = this.fcG.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.fcH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fcI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fcJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fcK);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(43639);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43640);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.fcG);
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
    ((StringBuffer)localObject).append("processNum:").append(this.fcH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runtimeNum:").append(this.fcI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("distribution:").append(this.fcJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mmtoolsAlive:").append(this.fcK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43640);
    return localObject;
  }
  
  public final int getId()
  {
    return 18032;
  }
  
  public final mo wt(long paramLong)
  {
    this.eXc = paramLong;
    return this;
  }
  
  public final mo wu(long paramLong)
  {
    this.eYW = paramLong;
    return this;
  }
  
  public final mo wv(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final mo ww(long paramLong)
  {
    this.fcH = paramLong;
    return this;
  }
  
  public final mo wx(long paramLong)
  {
    this.fcI = paramLong;
    return this;
  }
  
  public final mo wy(long paramLong)
  {
    this.fcK = paramLong;
    return this;
  }
  
  public final mo zP(String paramString)
  {
    AppMethodBeat.i(43636);
    this.eWb = x("InstanceId", paramString, true);
    AppMethodBeat.o(43636);
    return this;
  }
  
  public final mo zQ(String paramString)
  {
    AppMethodBeat.i(43637);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(43637);
    return this;
  }
  
  public final mo zR(String paramString)
  {
    AppMethodBeat.i(43638);
    this.fcJ = x("distribution", paramString, true);
    AppMethodBeat.o(43638);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43635);
      fcL = new a("release", 0, 1);
      fcM = new a("debug", 1, 2);
      fcN = new a("demo", 2, 3);
      fcO = new a[] { fcL, fcM, fcN };
      AppMethodBeat.o(43635);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a mz(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return fcL;
      case 2: 
        return fcM;
      }
      return fcN;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.mo
 * JD-Core Version:    0.7.0.1
 */