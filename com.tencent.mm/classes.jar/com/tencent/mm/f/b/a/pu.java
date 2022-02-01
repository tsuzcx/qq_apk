package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pu
  extends a
{
  public long gHC = 0L;
  private String gXM = "";
  private long gYL = 0L;
  private long gYN = 0L;
  private String gfn = "";
  private String gmF = "";
  private long gnP = 0L;
  private long hcT = 0L;
  public long hcU = 0L;
  private long hcV = 0L;
  private a hhK;
  public c hhL;
  public b hhM;
  public long hhN = 0L;
  private long hhr = 0L;
  
  public final pu Db(long paramLong)
  {
    this.gYL = paramLong;
    return this;
  }
  
  public final pu Dc(long paramLong)
  {
    this.gYN = paramLong;
    return this;
  }
  
  public final pu Dd(long paramLong)
  {
    AppMethodBeat.i(43696);
    this.hcT = paramLong;
    super.bk("CostTimeMs", this.hcT);
    AppMethodBeat.o(43696);
    return this;
  }
  
  public final pu De(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final pu Df(long paramLong)
  {
    AppMethodBeat.i(43697);
    this.hcU = paramLong;
    super.bm("StartTimeStampMs", this.hcU);
    AppMethodBeat.o(43697);
    return this;
  }
  
  public final pu Dg(long paramLong)
  {
    AppMethodBeat.i(43698);
    this.hcV = paramLong;
    super.bm("EndTimeStampMs", this.hcV);
    AppMethodBeat.o(43698);
    return this;
  }
  
  public final pu Dh(long paramLong)
  {
    this.gHC = paramLong;
    return this;
  }
  
  public final pu Di(long paramLong)
  {
    this.hhN = paramLong;
    return this;
  }
  
  public final pu GO(String paramString)
  {
    AppMethodBeat.i(43694);
    this.gfn = z("InstanceId", paramString, true);
    AppMethodBeat.o(43694);
    return this;
  }
  
  public final pu GP(String paramString)
  {
    AppMethodBeat.i(43695);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(43695);
    return this;
  }
  
  public final pu GQ(String paramString)
  {
    AppMethodBeat.i(43699);
    this.gXM = z("username", paramString, true);
    AppMethodBeat.o(43699);
    return this;
  }
  
  public final pu a(a parama)
  {
    this.hhK = parama;
    return this;
  }
  
  public final pu a(b paramb)
  {
    this.hhM = paramb;
    return this;
  }
  
  public final pu a(c paramc)
  {
    this.hhL = paramc;
    return this;
  }
  
  public final String agH()
  {
    int j = -1;
    AppMethodBeat.i(43700);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    if (this.hhK != null)
    {
      i = this.hhK.value;
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
      if (this.hhL == null) {
        break label309;
      }
    }
    label309:
    for (int i = this.hhL.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.hhM != null) {
        i = this.hhM.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gHC);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hhN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gXM);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hhr);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(43700);
      return localObject;
      i = -1;
      break;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43701);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.hhK);
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
    ((StringBuffer)localObject).append("Ret:").append(this.hhL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.hhM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.gHC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsNormalOpen:").append(this.hhN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.gXM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isParallel:").append(this.hhr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43701);
    return localObject;
  }
  
  public final pu aoS()
  {
    this.hhr = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 15765;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43687);
      hhO = new a("release", 0, 1);
      hhP = new a("debug", 1, 2);
      hhQ = new a("demo", 2, 3);
      hhR = new a[] { hhO, hhP, hhQ };
      AppMethodBeat.o(43687);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a oS(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return hhO;
      case 2: 
        return hhP;
      }
      return hhQ;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43690);
      hhS = new b("sync", 0, 0);
      hhT = new b("async", 1, 1);
      hhU = new b[] { hhS, hhT };
      AppMethodBeat.o(43690);
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
      AppMethodBeat.i(43693);
      hhV = new c("ok", 0, 0);
      hhW = new c("common_fail", 1, 1);
      hhX = new c("bundle_null", 2, 2);
      hhY = new c("jsapi_control_bytes_null", 3, 3);
      hhZ = new c[] { hhV, hhW, hhX, hhY };
      AppMethodBeat.o(43693);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pu
 * JD-Core Version:    0.7.0.1
 */