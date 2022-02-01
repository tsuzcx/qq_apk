package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pr
  extends a
{
  public long gHC = 0L;
  public long gYL = 0L;
  public long gYN = 0L;
  private String gfn = "";
  public String gjX = "";
  private String gmF = "";
  public long gnP = 0L;
  private long hcT = 0L;
  private long hcU = 0L;
  private long hcV = 0L;
  public a hhc;
  public c hhd;
  public b hhe;
  
  public final pr CH(long paramLong)
  {
    this.gYL = paramLong;
    return this;
  }
  
  public final pr CI(long paramLong)
  {
    this.gYN = paramLong;
    return this;
  }
  
  public final pr CJ(long paramLong)
  {
    AppMethodBeat.i(43665);
    this.hcT = paramLong;
    super.bk("CostTimeMs", this.hcT);
    AppMethodBeat.o(43665);
    return this;
  }
  
  public final pr CK(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final pr CL(long paramLong)
  {
    AppMethodBeat.i(43666);
    this.hcU = paramLong;
    super.bm("StartTimeStampMs", this.hcU);
    AppMethodBeat.o(43666);
    return this;
  }
  
  public final pr CM(long paramLong)
  {
    AppMethodBeat.i(43667);
    this.hcV = paramLong;
    super.bm("EndTimeStampMs", this.hcV);
    AppMethodBeat.o(43667);
    return this;
  }
  
  public final pr GH(String paramString)
  {
    AppMethodBeat.i(43663);
    this.gfn = z("InstanceId", paramString, true);
    AppMethodBeat.o(43663);
    return this;
  }
  
  public final pr GI(String paramString)
  {
    AppMethodBeat.i(43664);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(43664);
    return this;
  }
  
  public final pr a(a parama)
  {
    this.hhc = parama;
    return this;
  }
  
  public final String agH()
  {
    int j = -1;
    AppMethodBeat.i(43668);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    if (this.hhc != null)
    {
      i = this.hhc.value;
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
      if (this.hhd == null) {
        break label277;
      }
    }
    label277:
    for (int i = this.hhd.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.hhe != null) {
        i = this.hhe.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gHC);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gjX);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(43668);
      return localObject;
      i = -1;
      break;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43669);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.hhc);
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
    ((StringBuffer)localObject).append("Ret:").append(this.hhd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.hhe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.gHC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.gjX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43669);
    return localObject;
  }
  
  public final int getId()
  {
    return 15764;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43656);
      hhf = new a("release", 0, 1);
      hhg = new a("debug", 1, 2);
      hhh = new a("demo", 2, 3);
      hhi = new a[] { hhf, hhg, hhh };
      AppMethodBeat.o(43656);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a oO(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return hhf;
      case 2: 
        return hhg;
      }
      return hhh;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43659);
      hhj = new b("sync", 0, 0);
      hhk = new b("async", 1, 1);
      hhl = new b[] { hhj, hhk };
      AppMethodBeat.o(43659);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum c
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43662);
      hhm = new c("ok", 0, 0);
      hhn = new c("common_fail", 1, 1);
      hho = new c[] { hhm, hhn };
      AppMethodBeat.o(43662);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pr
 * JD-Core Version:    0.7.0.1
 */