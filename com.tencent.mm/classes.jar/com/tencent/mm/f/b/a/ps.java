package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class ps
  extends a
{
  public long gHC;
  private String gXM;
  public long gYL;
  public long gYN;
  private String gfn;
  private String gmF;
  public long gnP;
  private long hcT;
  private long hcU;
  private long hcV;
  public a hhp;
  public b hhq;
  private long hhr;
  private long hhs;
  
  public ps()
  {
    this.gfn = "";
    this.gmF = "";
    this.gYL = 0L;
    this.gYN = 0L;
    this.hcT = 0L;
    this.gnP = 0L;
    this.hcU = 0L;
    this.hcV = 0L;
    this.gHC = 0L;
    this.gXM = "";
    this.hhr = 0L;
  }
  
  public ps(String paramString)
  {
    AppMethodBeat.i(43676);
    this.gfn = "";
    this.gmF = "";
    this.gYL = 0L;
    this.gYN = 0L;
    this.hcT = 0L;
    this.gnP = 0L;
    this.hcU = 0L;
    this.hcV = 0L;
    this.gHC = 0L;
    this.gXM = "";
    this.hhr = 0L;
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 14) {
          break label283;
        }
        String[] arrayOfString = new String[14];
        Arrays.fill(arrayOfString, 0, 14, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label283:
    for (;;)
    {
      GJ(paramString[0]);
      GK(paramString[1]);
      this.gYL = Util.getLong(paramString[2], 0L);
      this.hhp = a.oP(Util.getInt(paramString[3], 0));
      this.gYN = Util.getLong(paramString[4], 0L);
      CP(Util.getLong(paramString[5], 0L));
      this.gnP = Util.getLong(paramString[6], 0L);
      CR(Util.getLong(paramString[7], 0L));
      CS(Util.getLong(paramString[8], 0L));
      this.hhq = b.oQ(Util.getInt(paramString[9], 0));
      this.gHC = Util.getLong(paramString[10], 0L);
      GL(paramString[11]);
      this.hhr = Util.getLong(paramString[12], 0L);
      this.hhs = Util.getLong(paramString[13], 0L);
      AppMethodBeat.o(43676);
      return;
    }
  }
  
  public final ps CN(long paramLong)
  {
    this.gYL = paramLong;
    return this;
  }
  
  public final ps CO(long paramLong)
  {
    this.gYN = paramLong;
    return this;
  }
  
  public final ps CP(long paramLong)
  {
    AppMethodBeat.i(43679);
    this.hcT = paramLong;
    super.bk("CostTimeMs", this.hcT);
    AppMethodBeat.o(43679);
    return this;
  }
  
  public final ps CQ(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final ps CR(long paramLong)
  {
    AppMethodBeat.i(43680);
    this.hcU = paramLong;
    super.bm("StartTimeStampMs", this.hcU);
    AppMethodBeat.o(43680);
    return this;
  }
  
  public final ps CS(long paramLong)
  {
    AppMethodBeat.i(43681);
    this.hcV = paramLong;
    super.bm("EndTimeStampMs", this.hcV);
    AppMethodBeat.o(43681);
    return this;
  }
  
  public final ps CT(long paramLong)
  {
    this.gHC = paramLong;
    return this;
  }
  
  public final ps CU(long paramLong)
  {
    this.hhs = paramLong;
    return this;
  }
  
  public final ps GJ(String paramString)
  {
    AppMethodBeat.i(43677);
    this.gfn = z("InstanceId", paramString, true);
    AppMethodBeat.o(43677);
    return this;
  }
  
  public final ps GK(String paramString)
  {
    AppMethodBeat.i(43678);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(43678);
    return this;
  }
  
  public final ps GL(String paramString)
  {
    AppMethodBeat.i(43682);
    this.gXM = z("username", paramString, true);
    AppMethodBeat.o(43682);
    return this;
  }
  
  public final long St()
  {
    return this.hcU;
  }
  
  public final long Su()
  {
    return this.hcV;
  }
  
  public final ps a(a parama)
  {
    this.hhp = parama;
    return this;
  }
  
  public final ps a(b paramb)
  {
    this.hhq = paramb;
    return this;
  }
  
  public final String agH()
  {
    int j = -1;
    AppMethodBeat.i(43683);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    if (this.hhp != null) {}
    for (int i = this.hhp.value;; i = -1)
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
      i = j;
      if (this.hhq != null) {
        i = this.hhq.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gHC);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gXM);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hhr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hhs);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(43683);
      return localObject;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43684);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.hhp);
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
    ((StringBuffer)localObject).append("Ret:").append(this.hhq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.gHC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.gXM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isParallel:").append(this.hhr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isUesd:").append(this.hhs);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43684);
    return localObject;
  }
  
  public final ps aoR()
  {
    this.hhr = 1L;
    return this;
  }
  
  public final String getAppId()
  {
    return this.gmF;
  }
  
  public final int getId()
  {
    return 15798;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43672);
      hht = new a("release", 0, 1);
      hhu = new a("debug", 1, 2);
      hhv = new a("demo", 2, 3);
      hhw = new a[] { hht, hhu, hhv };
      AppMethodBeat.o(43672);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a oP(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return hht;
      case 2: 
        return hhu;
      }
      return hhv;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43675);
      hhx = new b("ok", 0, 0);
      hhy = new b("common_fail", 1, 1);
      hhz = new b[] { hhx, hhy };
      AppMethodBeat.o(43675);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static b oQ(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return hhx;
      }
      return hhy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ps
 * JD-Core Version:    0.7.0.1
 */