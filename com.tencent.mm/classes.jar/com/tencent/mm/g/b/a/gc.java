package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gc
  extends a
{
  public long dYT = 0L;
  public String dYa = "";
  public String eag = "";
  public long eai = 0L;
  private long ebp = 0L;
  public a efN;
  private long efO = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(43707);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.efN != null) {}
    for (int i = this.efN.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eai);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.efO);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43707);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43708);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.efN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eai);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.ebp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitingTimeMs:").append(this.efO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43708);
    return localObject;
  }
  
  public final int getId()
  {
    return 15853;
  }
  
  public final gc jL(long paramLong)
  {
    AppMethodBeat.i(43705);
    this.ebp = paramLong;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(43705);
    return this;
  }
  
  public final gc jM(long paramLong)
  {
    AppMethodBeat.i(43706);
    this.efO = paramLong;
    super.ba("WaitingTimeMs", this.efO);
    AppMethodBeat.o(43706);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43704);
      efP = new a("release", 0, 1);
      efQ = new a("debug", 1, 2);
      efR = new a("demo", 2, 3);
      efS = new a[] { efP, efQ, efR };
      AppMethodBeat.o(43704);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jj(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return efP;
      case 2: 
        return efQ;
      }
      return efR;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gc
 * JD-Core Version:    0.7.0.1
 */