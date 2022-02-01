package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hm
  extends a
{
  private long dHY = 0L;
  private String dZT = "";
  private long eaM = 0L;
  private String ecm = "";
  private long eco = 0L;
  private long edv = 0L;
  private long edw = 0L;
  private long edx = 0L;
  private a efK;
  private long efL = 0L;
  private long efM = 0L;
  private String efN = "";
  private long efO = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(43639);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.efK != null) {}
    for (int i = this.efK.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.efL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.efM);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.efN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.efO);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43639);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43640);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.efK);
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
    ((StringBuffer)localObject).append("processNum:").append(this.efL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runtimeNum:").append(this.efM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("distribution:").append(this.efN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mmtoolsAlive:").append(this.efO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43640);
    return localObject;
  }
  
  public final hm a(a parama)
  {
    this.efK = parama;
    return this;
  }
  
  public final int getId()
  {
    return 18032;
  }
  
  public final hm mA(long paramLong)
  {
    this.efL = paramLong;
    return this;
  }
  
  public final hm mB(long paramLong)
  {
    this.efM = paramLong;
    return this;
  }
  
  public final hm mC(long paramLong)
  {
    this.efO = paramLong;
    return this;
  }
  
  public final hm mx(long paramLong)
  {
    this.eaM = paramLong;
    return this;
  }
  
  public final hm my(long paramLong)
  {
    this.eco = paramLong;
    return this;
  }
  
  public final hm mz(long paramLong)
  {
    this.dHY = paramLong;
    return this;
  }
  
  public final hm oF(String paramString)
  {
    AppMethodBeat.i(43636);
    this.dZT = t("InstanceId", paramString, true);
    AppMethodBeat.o(43636);
    return this;
  }
  
  public final hm oG(String paramString)
  {
    AppMethodBeat.i(43637);
    this.ecm = t("AppId", paramString, true);
    AppMethodBeat.o(43637);
    return this;
  }
  
  public final hm oH(String paramString)
  {
    AppMethodBeat.i(43638);
    this.efN = t("distribution", paramString, true);
    AppMethodBeat.o(43638);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43635);
      efP = new a("release", 0, 1);
      efQ = new a("debug", 1, 2);
      efR = new a("demo", 2, 3);
      efS = new a[] { efP, efQ, efR };
      AppMethodBeat.o(43635);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iY(int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hm
 * JD-Core Version:    0.7.0.1
 */