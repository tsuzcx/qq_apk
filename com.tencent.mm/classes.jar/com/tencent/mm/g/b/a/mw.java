package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mw
  extends a
{
  public String eJx = "";
  public String eWb = "";
  public long eXc = 0L;
  public long eYW = 0L;
  private long fac = 0L;
  public a ffa;
  private long ffb = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(43707);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.ffa != null) {}
    for (int i = this.ffa.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eYW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fac);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ffb);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(43707);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43708);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ffa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eYW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.fac);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitingTimeMs:").append(this.ffb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43708);
    return localObject;
  }
  
  public final int getId()
  {
    return 15853;
  }
  
  public final mw xj(long paramLong)
  {
    AppMethodBeat.i(43705);
    this.fac = paramLong;
    super.bi("CostTimeMs", this.fac);
    AppMethodBeat.o(43705);
    return this;
  }
  
  public final mw xk(long paramLong)
  {
    AppMethodBeat.i(43706);
    this.ffb = paramLong;
    super.bi("WaitingTimeMs", this.ffb);
    AppMethodBeat.o(43706);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43704);
      ffc = new a("release", 0, 1);
      ffd = new a("debug", 1, 2);
      ffe = new a("demo", 2, 3);
      fff = new a[] { ffc, ffd, ffe };
      AppMethodBeat.o(43704);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a mI(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ffc;
      case 2: 
        return ffd;
      }
      return ffe;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.mw
 * JD-Core Version:    0.7.0.1
 */