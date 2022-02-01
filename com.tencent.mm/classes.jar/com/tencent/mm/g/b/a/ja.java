package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ja
  extends a
{
  public a eAD;
  private long eAE = 0L;
  public String esa = "";
  public long etb = 0L;
  public long euA = 0L;
  public String euy = "";
  private long evH = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(43707);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.eAD != null) {}
    for (int i = this.eAD.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eAE);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(43707);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43708);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eAD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.euA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.evH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitingTimeMs:").append(this.eAE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43708);
    return localObject;
  }
  
  public final int getId()
  {
    return 15853;
  }
  
  public final ja py(long paramLong)
  {
    AppMethodBeat.i(43705);
    this.evH = paramLong;
    super.bg("CostTimeMs", this.evH);
    AppMethodBeat.o(43705);
    return this;
  }
  
  public final ja pz(long paramLong)
  {
    AppMethodBeat.i(43706);
    this.eAE = paramLong;
    super.bg("WaitingTimeMs", this.eAE);
    AppMethodBeat.o(43706);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43704);
      eAF = new a("release", 0, 1);
      eAG = new a("debug", 1, 2);
      eAH = new a("demo", 2, 3);
      eAI = new a[] { eAF, eAG, eAH };
      AppMethodBeat.o(43704);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jG(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eAF;
      case 2: 
        return eAG;
      }
      return eAH;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ja
 * JD-Core Version:    0.7.0.1
 */