package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class is
  extends a
{
  private long dWt = 0L;
  private String esa = "";
  private long etb = 0L;
  private long euA = 0L;
  private String euy = "";
  private long evH = 0L;
  private long evI = 0L;
  private long evJ = 0L;
  private a eyj;
  private long eyk = 0L;
  private long eyl = 0L;
  private String eym = "";
  private long eyn = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(43639);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.eyj != null) {}
    for (int i = this.eyj.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dWt);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eyk);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eyl);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eym);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eyn);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(43639);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43640);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eyj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.euA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.evH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.evI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.evJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("processNum:").append(this.eyk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runtimeNum:").append(this.eyl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("distribution:").append(this.eym);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mmtoolsAlive:").append(this.eyn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43640);
    return localObject;
  }
  
  public final is a(a parama)
  {
    this.eyj = parama;
    return this;
  }
  
  public final int getId()
  {
    return 18032;
  }
  
  public final is oI(long paramLong)
  {
    this.etb = paramLong;
    return this;
  }
  
  public final is oJ(long paramLong)
  {
    this.euA = paramLong;
    return this;
  }
  
  public final is oK(long paramLong)
  {
    this.dWt = paramLong;
    return this;
  }
  
  public final is oL(long paramLong)
  {
    this.eyk = paramLong;
    return this;
  }
  
  public final is oM(long paramLong)
  {
    this.eyl = paramLong;
    return this;
  }
  
  public final is oN(long paramLong)
  {
    this.eyn = paramLong;
    return this;
  }
  
  public final is rH(String paramString)
  {
    AppMethodBeat.i(43636);
    this.esa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43636);
    return this;
  }
  
  public final is rI(String paramString)
  {
    AppMethodBeat.i(43637);
    this.euy = t("AppId", paramString, true);
    AppMethodBeat.o(43637);
    return this;
  }
  
  public final is rJ(String paramString)
  {
    AppMethodBeat.i(43638);
    this.eym = t("distribution", paramString, true);
    AppMethodBeat.o(43638);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43635);
      eyo = new a("release", 0, 1);
      eyp = new a("debug", 1, 2);
      eyq = new a("demo", 2, 3);
      eyr = new a[] { eyo, eyp, eyq };
      AppMethodBeat.o(43635);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jx(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eyo;
      case 2: 
        return eyp;
      }
      return eyq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.is
 * JD-Core Version:    0.7.0.1
 */