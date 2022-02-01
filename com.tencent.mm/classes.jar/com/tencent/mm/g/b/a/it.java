package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class it
  extends a
{
  public long dVd = 0L;
  private String eqt = "";
  public long eru = 0L;
  private String esR = "";
  public long esT = 0L;
  private String etv = "";
  public a exN;
  private String exO = "";
  public long exP = 0L;
  public long exQ = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(43652);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    if (this.exN != null) {}
    for (int i = this.exN.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.esT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exO);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exP);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exQ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.etv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eqt);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dVd);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(43652);
      return localObject;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43653);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.exN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.esT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Provider:").append(this.exO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Version:").append(this.exP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Stage:").append(this.exQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.etv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43653);
    return localObject;
  }
  
  public final it a(a parama)
  {
    this.exN = parama;
    return this;
  }
  
  public final int getId()
  {
    return 17120;
  }
  
  public final it oE(long paramLong)
  {
    this.eru = paramLong;
    return this;
  }
  
  public final it oF(long paramLong)
  {
    this.esT = paramLong;
    return this;
  }
  
  public final it oG(long paramLong)
  {
    this.exP = paramLong;
    return this;
  }
  
  public final it oH(long paramLong)
  {
    this.exQ = paramLong;
    return this;
  }
  
  public final it oI(long paramLong)
  {
    this.dVd = paramLong;
    return this;
  }
  
  public final it rp(String paramString)
  {
    AppMethodBeat.i(180162);
    this.esR = t("AppId", paramString, true);
    AppMethodBeat.o(180162);
    return this;
  }
  
  public final it rq(String paramString)
  {
    AppMethodBeat.i(180163);
    this.exO = t("Provider", paramString, true);
    AppMethodBeat.o(180163);
    return this;
  }
  
  public final it rr(String paramString)
  {
    AppMethodBeat.i(180164);
    this.etv = t("networkType", paramString, true);
    AppMethodBeat.o(180164);
    return this;
  }
  
  public final it rs(String paramString)
  {
    AppMethodBeat.i(180165);
    this.eqt = t("InstanceId", paramString, true);
    AppMethodBeat.o(180165);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43651);
      exR = new a("release", 0, 1);
      exS = new a("debug", 1, 2);
      exT = new a("demo", 2, 3);
      exU = new a[] { exR, exS, exT };
      AppMethodBeat.o(43651);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jy(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return exR;
      case 2: 
        return exS;
      }
      return exT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.it
 * JD-Core Version:    0.7.0.1
 */