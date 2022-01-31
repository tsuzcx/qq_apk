package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ct
  extends a
{
  private String cZA = "";
  public long cZB = 0L;
  public long cZD = 0L;
  private String dar = "";
  private long dat = 0L;
  public a ddd;
  private long dde = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(128855);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dar);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZB);
    ((StringBuffer)localObject).append(",");
    if (this.ddd != null) {}
    for (int i = this.ddd.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cZD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dat);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dde);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(128855);
      return localObject;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128856);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dar);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.cZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.cZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ddd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.cZD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.dat);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitingTimeMs:").append(this.dde);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(128856);
    return localObject;
  }
  
  public final ct ft(long paramLong)
  {
    AppMethodBeat.i(128853);
    this.dat = paramLong;
    super.ay("CostTimeMs", this.dat);
    AppMethodBeat.o(128853);
    return this;
  }
  
  public final ct fu(long paramLong)
  {
    AppMethodBeat.i(128854);
    this.dde = paramLong;
    super.ay("WaitingTimeMs", this.dde);
    AppMethodBeat.o(128854);
    return this;
  }
  
  public final int getId()
  {
    return 15853;
  }
  
  public final ct hU(String paramString)
  {
    AppMethodBeat.i(128851);
    this.dar = t("InstanceId", paramString, true);
    AppMethodBeat.o(128851);
    return this;
  }
  
  public final ct hV(String paramString)
  {
    AppMethodBeat.i(128852);
    this.cZA = t("AppId", paramString, true);
    AppMethodBeat.o(128852);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(128850);
      ddf = new a("release", 0, 1);
      ddg = new a("debug", 1, 2);
      ddh = new a("demo", 2, 3);
      ddi = new a[] { ddf, ddg, ddh };
      AppMethodBeat.o(128850);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a hh(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ddf;
      case 2: 
        return ddg;
      }
      return ddh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ct
 * JD-Core Version:    0.7.0.1
 */