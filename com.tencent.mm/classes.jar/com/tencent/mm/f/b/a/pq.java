package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pq
  extends a
{
  private long gYL = 0L;
  private long gYN = 0L;
  private String gfn = "";
  private String gmF = "";
  private long gnP = 0L;
  private String gtA = "";
  private a hgU;
  private String hgV = "";
  private long hgW = 0L;
  private long hgX = 0L;
  
  public final pq CC(long paramLong)
  {
    this.gYL = paramLong;
    return this;
  }
  
  public final pq CD(long paramLong)
  {
    this.gYN = paramLong;
    return this;
  }
  
  public final pq CE(long paramLong)
  {
    this.hgW = paramLong;
    return this;
  }
  
  public final pq CF(long paramLong)
  {
    this.hgX = paramLong;
    return this;
  }
  
  public final pq CG(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final pq GD(String paramString)
  {
    AppMethodBeat.i(180162);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(180162);
    return this;
  }
  
  public final pq GE(String paramString)
  {
    AppMethodBeat.i(180163);
    this.hgV = z("Provider", paramString, true);
    AppMethodBeat.o(180163);
    return this;
  }
  
  public final pq GF(String paramString)
  {
    AppMethodBeat.i(180164);
    this.gtA = z("networkType", paramString, true);
    AppMethodBeat.o(180164);
    return this;
  }
  
  public final pq GG(String paramString)
  {
    AppMethodBeat.i(180165);
    this.gfn = z("InstanceId", paramString, true);
    AppMethodBeat.o(180165);
    return this;
  }
  
  public final pq a(a parama)
  {
    this.hgU = parama;
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(43652);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    if (this.hgU != null) {}
    for (int i = this.hgU.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gYN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgV);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gtA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gfn);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gnP);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(43652);
      return localObject;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43653);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.hgU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.gYN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Provider:").append(this.hgV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Version:").append(this.hgW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Stage:").append(this.hgX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.gtA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43653);
    return localObject;
  }
  
  public final int getId()
  {
    return 17120;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43651);
      hgY = new a("release", 0, 1);
      hgZ = new a("debug", 1, 2);
      hha = new a("demo", 2, 3);
      hhb = new a[] { hgY, hgZ, hha };
      AppMethodBeat.o(43651);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a oN(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return hgY;
      case 2: 
        return hgZ;
      }
      return hha;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pq
 * JD-Core Version:    0.7.0.1
 */