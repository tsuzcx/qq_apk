package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iv
  extends a
{
  public long dWt = 0L;
  private String esa = "";
  public long etb = 0L;
  public long euA = 0L;
  private String euy = "";
  private String evc = "";
  public long ezA = 0L;
  public a ezx;
  private String ezy = "";
  public long ezz = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(43652);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.ezx != null) {}
    for (int i = this.ezx.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ezy);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ezz);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ezA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evc);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.esa);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dWt);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(43652);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43653);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ezx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.euA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Provider:").append(this.ezy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Version:").append(this.ezz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Stage:").append(this.ezA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.evc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43653);
    return localObject;
  }
  
  public final iv a(a parama)
  {
    this.ezx = parama;
    return this;
  }
  
  public final int getId()
  {
    return 17120;
  }
  
  public final iv oR(long paramLong)
  {
    this.etb = paramLong;
    return this;
  }
  
  public final iv oS(long paramLong)
  {
    this.euA = paramLong;
    return this;
  }
  
  public final iv oT(long paramLong)
  {
    this.ezz = paramLong;
    return this;
  }
  
  public final iv oU(long paramLong)
  {
    this.ezA = paramLong;
    return this;
  }
  
  public final iv oV(long paramLong)
  {
    this.dWt = paramLong;
    return this;
  }
  
  public final iv rK(String paramString)
  {
    AppMethodBeat.i(180162);
    this.euy = t("AppId", paramString, true);
    AppMethodBeat.o(180162);
    return this;
  }
  
  public final iv rL(String paramString)
  {
    AppMethodBeat.i(180163);
    this.ezy = t("Provider", paramString, true);
    AppMethodBeat.o(180163);
    return this;
  }
  
  public final iv rM(String paramString)
  {
    AppMethodBeat.i(180164);
    this.evc = t("networkType", paramString, true);
    AppMethodBeat.o(180164);
    return this;
  }
  
  public final iv rN(String paramString)
  {
    AppMethodBeat.i(180165);
    this.esa = t("InstanceId", paramString, true);
    AppMethodBeat.o(180165);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43651);
      ezB = new a("release", 0, 1);
      ezC = new a("debug", 1, 2);
      ezD = new a("demo", 2, 3);
      ezE = new a[] { ezB, ezC, ezD };
      AppMethodBeat.o(43651);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jA(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ezB;
      case 2: 
        return ezC;
      }
      return ezD;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.iv
 * JD-Core Version:    0.7.0.1
 */