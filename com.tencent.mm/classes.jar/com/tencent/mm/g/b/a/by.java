package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class by
  extends a
{
  private String cZA;
  private long cZB = 0L;
  private long cZD = 0L;
  private a cZJ;
  private long cZK = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(155901);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZB);
    ((StringBuffer)localObject).append(",");
    if (this.cZJ != null) {}
    for (int i = this.cZJ.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cZD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cZK);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(155901);
      return localObject;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(155902);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.cZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.cZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.cZJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.cZD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileAllocSize:").append(this.cZK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(155902);
    return localObject;
  }
  
  public final by a(a parama)
  {
    this.cZJ = parama;
    return this;
  }
  
  public final by eA(long paramLong)
  {
    this.cZD = paramLong;
    return this;
  }
  
  public final by eB(long paramLong)
  {
    this.cZK = paramLong;
    return this;
  }
  
  public final by ez(long paramLong)
  {
    this.cZB = paramLong;
    return this;
  }
  
  public final by gY(String paramString)
  {
    AppMethodBeat.i(155900);
    this.cZA = t("AppId", paramString, true);
    AppMethodBeat.o(155900);
    return this;
  }
  
  public final int getId()
  {
    return 17688;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(155899);
      cZL = new a("release", 0, 1);
      cZM = new a("debug", 1, 2);
      cZN = new a("demo", 2, 3);
      cZO = new a[] { cZL, cZM, cZN };
      AppMethodBeat.o(155899);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a gM(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return cZL;
      case 2: 
        return cZM;
      }
      return cZN;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.by
 * JD-Core Version:    0.7.0.1
 */