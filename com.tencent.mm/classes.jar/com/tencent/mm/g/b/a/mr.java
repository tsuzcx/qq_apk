package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mr
  extends a
{
  private String eJx = "";
  private String eWb = "";
  private long eXc = 0L;
  private long eYW = 0L;
  private long erW = 0L;
  private String exq = "";
  private a fdU;
  private String fdV = "";
  private long fdW = 0L;
  private long fdX = 0L;
  
  public final mr a(a parama)
  {
    this.fdU = parama;
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(43652);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.fdU != null) {}
    for (int i = this.fdU.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eYW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdV);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eWb);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.erW);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(43652);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43653);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.fdU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eYW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Provider:").append(this.fdV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Version:").append(this.fdW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Stage:").append(this.fdX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.exq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43653);
    return localObject;
  }
  
  public final int getId()
  {
    return 17120;
  }
  
  public final mr wC(long paramLong)
  {
    this.eXc = paramLong;
    return this;
  }
  
  public final mr wD(long paramLong)
  {
    this.eYW = paramLong;
    return this;
  }
  
  public final mr wE(long paramLong)
  {
    this.fdW = paramLong;
    return this;
  }
  
  public final mr wF(long paramLong)
  {
    this.fdX = paramLong;
    return this;
  }
  
  public final mr wG(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final mr zS(String paramString)
  {
    AppMethodBeat.i(180162);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(180162);
    return this;
  }
  
  public final mr zT(String paramString)
  {
    AppMethodBeat.i(180163);
    this.fdV = x("Provider", paramString, true);
    AppMethodBeat.o(180163);
    return this;
  }
  
  public final mr zU(String paramString)
  {
    AppMethodBeat.i(180164);
    this.exq = x("networkType", paramString, true);
    AppMethodBeat.o(180164);
    return this;
  }
  
  public final mr zV(String paramString)
  {
    AppMethodBeat.i(180165);
    this.eWb = x("InstanceId", paramString, true);
    AppMethodBeat.o(180165);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43651);
      fdY = new a("release", 0, 1);
      fdZ = new a("debug", 1, 2);
      fea = new a("demo", 2, 3);
      feb = new a[] { fdY, fdZ, fea };
      AppMethodBeat.o(43651);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a mC(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return fdY;
      case 2: 
        return fdZ;
      }
      return fea;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.mr
 * JD-Core Version:    0.7.0.1
 */