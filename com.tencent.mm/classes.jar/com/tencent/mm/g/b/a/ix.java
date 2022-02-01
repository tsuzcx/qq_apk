package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Arrays;

public final class ix
  extends a
{
  public long dWt;
  public long ehL;
  private String esa;
  public long etb;
  public long euA;
  private String euy;
  private long evH;
  private long evI;
  private long evJ;
  private String ewy;
  public a ezS;
  public b ezT;
  private long ezU;
  private long ezV;
  
  public ix()
  {
    this.esa = "";
    this.euy = "";
    this.etb = 0L;
    this.euA = 0L;
    this.evH = 0L;
    this.dWt = 0L;
    this.evI = 0L;
    this.evJ = 0L;
    this.ehL = 0L;
    this.ewy = "";
    this.ezU = 0L;
  }
  
  public ix(String paramString)
  {
    AppMethodBeat.i(43676);
    this.esa = "";
    this.euy = "";
    this.etb = 0L;
    this.euA = 0L;
    this.evH = 0L;
    this.dWt = 0L;
    this.evI = 0L;
    this.evJ = 0L;
    this.ehL = 0L;
    this.ewy = "";
    this.ezU = 0L;
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
      rQ(paramString[0]);
      rR(paramString[1]);
      this.etb = bu.getLong(paramString[2], 0L);
      this.ezS = a.jC(bu.getInt(paramString[3], 0));
      this.euA = bu.getLong(paramString[4], 0L);
      pe(bu.getLong(paramString[5], 0L));
      this.dWt = bu.getLong(paramString[6], 0L);
      pg(bu.getLong(paramString[7], 0L));
      ph(bu.getLong(paramString[8], 0L));
      this.ezT = b.jD(bu.getInt(paramString[9], 0));
      this.ehL = bu.getLong(paramString[10], 0L);
      rS(paramString[11]);
      this.ezU = bu.getLong(paramString[12], 0L);
      this.ezV = bu.getLong(paramString[13], 0L);
      AppMethodBeat.o(43676);
      return;
    }
  }
  
  public final String RC()
  {
    int j = -1;
    AppMethodBeat.i(43683);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.ezS != null) {}
    for (int i = this.ezS.value;; i = -1)
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
      i = j;
      if (this.ezT != null) {
        i = this.ezT.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ehL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewy);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ezU);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ezV);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(43683);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43684);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ezS);
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
    ((StringBuffer)localObject).append("Ret:").append(this.ezT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.ehL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.ewy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isParallel:").append(this.ezU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isUesd:").append(this.ezV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43684);
    return localObject;
  }
  
  public final long Ve()
  {
    return this.evI;
  }
  
  public final long Vf()
  {
    return this.evJ;
  }
  
  public final ix Vu()
  {
    this.ezU = 1L;
    return this;
  }
  
  public final ix a(a parama)
  {
    this.ezS = parama;
    return this;
  }
  
  public final ix a(b paramb)
  {
    this.ezT = paramb;
    return this;
  }
  
  public final String getAppId()
  {
    return this.euy;
  }
  
  public final int getId()
  {
    return 15798;
  }
  
  public final ix pc(long paramLong)
  {
    this.etb = paramLong;
    return this;
  }
  
  public final ix pd(long paramLong)
  {
    this.euA = paramLong;
    return this;
  }
  
  public final ix pe(long paramLong)
  {
    AppMethodBeat.i(43679);
    this.evH = paramLong;
    super.bg("CostTimeMs", this.evH);
    AppMethodBeat.o(43679);
    return this;
  }
  
  public final ix pf(long paramLong)
  {
    this.dWt = paramLong;
    return this;
  }
  
  public final ix pg(long paramLong)
  {
    AppMethodBeat.i(43680);
    this.evI = paramLong;
    super.bh("StartTimeStampMs", this.evI);
    AppMethodBeat.o(43680);
    return this;
  }
  
  public final ix ph(long paramLong)
  {
    AppMethodBeat.i(43681);
    this.evJ = paramLong;
    super.bh("EndTimeStampMs", this.evJ);
    AppMethodBeat.o(43681);
    return this;
  }
  
  public final ix pi(long paramLong)
  {
    this.ehL = paramLong;
    return this;
  }
  
  public final ix pj(long paramLong)
  {
    this.ezV = paramLong;
    return this;
  }
  
  public final ix rQ(String paramString)
  {
    AppMethodBeat.i(43677);
    this.esa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43677);
    return this;
  }
  
  public final ix rR(String paramString)
  {
    AppMethodBeat.i(43678);
    this.euy = t("AppId", paramString, true);
    AppMethodBeat.o(43678);
    return this;
  }
  
  public final ix rS(String paramString)
  {
    AppMethodBeat.i(43682);
    this.ewy = t("username", paramString, true);
    AppMethodBeat.o(43682);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43672);
      ezW = new a("release", 0, 1);
      ezX = new a("debug", 1, 2);
      ezY = new a("demo", 2, 3);
      ezZ = new a[] { ezW, ezX, ezY };
      AppMethodBeat.o(43672);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jC(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ezW;
      case 2: 
        return ezX;
      }
      return ezY;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43675);
      eAa = new b("ok", 0, 0);
      eAb = new b("common_fail", 1, 1);
      eAc = new b[] { eAa, eAb };
      AppMethodBeat.o(43675);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static b jD(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return eAa;
      }
      return eAb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ix
 * JD-Core Version:    0.7.0.1
 */