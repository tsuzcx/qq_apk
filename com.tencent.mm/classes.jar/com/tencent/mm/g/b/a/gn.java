package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gn
  extends a
{
  private long eaM = 0L;
  private String ecm;
  private a ecn;
  private long eco = 0L;
  private long ecp = 0L;
  private String ecq;
  
  public final String PR()
  {
    AppMethodBeat.i(43470);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.ecn != null) {}
    for (int i = this.ecn.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eco);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecq);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43470);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43471);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ecn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eco);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileOccupation:").append(this.ecp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DirPrefix:").append(this.ecq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43471);
    return localObject;
  }
  
  public final long SG()
  {
    return this.ecp;
  }
  
  public final String SH()
  {
    return this.ecq;
  }
  
  public final gn a(a parama)
  {
    this.ecn = parama;
    return this;
  }
  
  public final String getAppId()
  {
    return this.ecm;
  }
  
  public final int getId()
  {
    return 17687;
  }
  
  public final gn ll(long paramLong)
  {
    this.eaM = paramLong;
    return this;
  }
  
  public final gn lm(long paramLong)
  {
    this.eco = paramLong;
    return this;
  }
  
  public final gn ln(long paramLong)
  {
    this.ecp = paramLong;
    return this;
  }
  
  public final gn nW(String paramString)
  {
    AppMethodBeat.i(43469);
    this.ecm = t("AppId", paramString, true);
    AppMethodBeat.o(43469);
    return this;
  }
  
  public final gn nX(String paramString)
  {
    AppMethodBeat.i(180149);
    this.ecq = t("DirPrefix", paramString, true);
    AppMethodBeat.o(180149);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43468);
      ecr = new a("release", 0, 1);
      ecs = new a("debug", 1, 2);
      ect = new a("demo", 2, 3);
      ecu = new a[] { ecr, ecs, ect };
      AppMethodBeat.o(43468);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iE(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ecr;
      case 2: 
        return ecs;
      }
      return ect;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gn
 * JD-Core Version:    0.7.0.1
 */