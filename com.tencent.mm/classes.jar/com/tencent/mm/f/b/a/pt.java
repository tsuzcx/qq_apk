package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pt
  extends a
{
  public long gHC = 0L;
  private long gYL = 0L;
  private long gYN = 0L;
  private String gfn = "";
  private String gmF = "";
  private long gnP = 0L;
  private long hcT = 0L;
  public long hcU = 0L;
  private long hcV = 0L;
  private a hhA;
  public long hhB = 0L;
  public b hhC;
  
  public final pt CV(long paramLong)
  {
    this.gYL = paramLong;
    return this;
  }
  
  public final pt CW(long paramLong)
  {
    this.gYN = paramLong;
    return this;
  }
  
  public final pt CX(long paramLong)
  {
    AppMethodBeat.i(267420);
    this.hcT = paramLong;
    super.bk("CostTimeMs", this.hcT);
    AppMethodBeat.o(267420);
    return this;
  }
  
  public final pt CY(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final pt CZ(long paramLong)
  {
    AppMethodBeat.i(267421);
    this.hcU = paramLong;
    super.bm("StartTimeStampMs", this.hcU);
    AppMethodBeat.o(267421);
    return this;
  }
  
  public final pt Da(long paramLong)
  {
    AppMethodBeat.i(267422);
    this.hcV = paramLong;
    super.bm("EndTimeStampMs", this.hcV);
    AppMethodBeat.o(267422);
    return this;
  }
  
  public final pt GM(String paramString)
  {
    AppMethodBeat.i(267418);
    this.gfn = z("InstanceId", paramString, true);
    AppMethodBeat.o(267418);
    return this;
  }
  
  public final pt GN(String paramString)
  {
    AppMethodBeat.i(267419);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(267419);
    return this;
  }
  
  public final pt a(a parama)
  {
    this.hhA = parama;
    return this;
  }
  
  public final String agH()
  {
    int j = -1;
    AppMethodBeat.i(267423);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    if (this.hhA != null) {}
    for (int i = this.hhA.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gYN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gnP);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcU);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcV);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hhB);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.hhC != null) {
        i = this.hhC.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gHC);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(267423);
      return localObject;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(267424);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.hhA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.gYN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.hcT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.hcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.hcV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Ret:").append(this.hhB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.hhC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.gHC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(267424);
    return localObject;
  }
  
  public final int getId()
  {
    return 19986;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(278401);
      hhD = new a("release", 0, 1);
      hhE = new a("debug", 1, 2);
      hhF = new a("demo", 2, 3);
      hhG = new a[] { hhD, hhE, hhF };
      AppMethodBeat.o(278401);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a oR(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return hhD;
      case 2: 
        return hhE;
      }
      return hhF;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(279798);
      hhH = new b("sync", 0, 0);
      hhI = new b("async", 1, 1);
      hhJ = new b[] { hhH, hhI };
      AppMethodBeat.o(279798);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pt
 * JD-Core Version:    0.7.0.1
 */