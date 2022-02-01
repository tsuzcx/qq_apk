package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class go
  extends a
{
  private long eaM = 0L;
  private String ecm;
  private long eco = 0L;
  private a ecv;
  private long ecw = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(43476);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.ecv != null) {}
    for (int i = this.ecv.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eco);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecw);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43476);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43477);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ecv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eco);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileAllocSize:").append(this.ecw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43477);
    return localObject;
  }
  
  public final go a(a parama)
  {
    this.ecv = parama;
    return this;
  }
  
  public final int getId()
  {
    return 17688;
  }
  
  public final go lo(long paramLong)
  {
    this.eaM = paramLong;
    return this;
  }
  
  public final go lp(long paramLong)
  {
    this.eco = paramLong;
    return this;
  }
  
  public final go lq(long paramLong)
  {
    this.ecw = paramLong;
    return this;
  }
  
  public final go nY(String paramString)
  {
    AppMethodBeat.i(43475);
    this.ecm = t("AppId", paramString, true);
    AppMethodBeat.o(43475);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43474);
      ecx = new a("release", 0, 1);
      ecy = new a("debug", 1, 2);
      ecz = new a("demo", 2, 3);
      ecA = new a[] { ecx, ecy, ecz };
      AppMethodBeat.o(43474);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iF(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ecx;
      case 2: 
        return ecy;
      }
      return ecz;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.go
 * JD-Core Version:    0.7.0.1
 */