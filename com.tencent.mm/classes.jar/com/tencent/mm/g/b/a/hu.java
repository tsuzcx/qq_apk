package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hu
  extends a
{
  public String dZT = "";
  public long eaM = 0L;
  public String ecm = "";
  public long eco = 0L;
  private long edv = 0L;
  public a ehU;
  private long ehV = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(43707);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.ehU != null) {}
    for (int i = this.ehU.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eco);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ehV);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43707);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43708);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ehU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eco);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.edv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitingTimeMs:").append(this.ehV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43708);
    return localObject;
  }
  
  public final int getId()
  {
    return 15853;
  }
  
  public final hu nn(long paramLong)
  {
    AppMethodBeat.i(43705);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(43705);
    return this;
  }
  
  public final hu no(long paramLong)
  {
    AppMethodBeat.i(43706);
    this.ehV = paramLong;
    super.bc("WaitingTimeMs", this.ehV);
    AppMethodBeat.o(43706);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43704);
      ehW = new a("release", 0, 1);
      ehX = new a("debug", 1, 2);
      ehY = new a("demo", 2, 3);
      ehZ = new a[] { ehW, ehX, ehY };
      AppMethodBeat.o(43704);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jh(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ehW;
      case 2: 
        return ehX;
      }
      return ehY;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hu
 * JD-Core Version:    0.7.0.1
 */