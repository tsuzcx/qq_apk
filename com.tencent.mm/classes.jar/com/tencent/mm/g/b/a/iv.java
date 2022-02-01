package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class iv
  extends a
{
  public long dVd;
  public long ega;
  private String eqt;
  public long eru;
  private String esR;
  public long esT;
  private String euR;
  private long eua;
  private long eub;
  private long euc;
  public a eyj;
  public b eyk;
  private long eyl;
  private long eym;
  
  public iv()
  {
    this.eqt = "";
    this.esR = "";
    this.eru = 0L;
    this.esT = 0L;
    this.eua = 0L;
    this.dVd = 0L;
    this.eub = 0L;
    this.euc = 0L;
    this.ega = 0L;
    this.eyl = 0L;
  }
  
  public iv(String paramString)
  {
    AppMethodBeat.i(43676);
    this.eqt = "";
    this.esR = "";
    this.eru = 0L;
    this.esT = 0L;
    this.eua = 0L;
    this.dVd = 0L;
    this.eub = 0L;
    this.euc = 0L;
    this.ega = 0L;
    this.eyl = 0L;
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 14) {
          break label277;
        }
        String[] arrayOfString = new String[14];
        Arrays.fill(arrayOfString, 0, 14, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label277:
    for (;;)
    {
      rv(paramString[0]);
      rw(paramString[1]);
      this.eru = bt.getLong(paramString[2], 0L);
      this.eyj = a.jA(bt.getInt(paramString[3], 0));
      this.esT = bt.getLong(paramString[4], 0L);
      oR(bt.getLong(paramString[5], 0L));
      this.dVd = bt.getLong(paramString[6], 0L);
      oT(bt.getLong(paramString[7], 0L));
      oU(bt.getLong(paramString[8], 0L));
      this.eyk = b.jB(bt.getInt(paramString[9], 0));
      this.ega = bt.getLong(paramString[10], 0L);
      rx(paramString[11]);
      this.eyl = bt.getLong(paramString[12], 0L);
      this.eym = bt.getLong(paramString[13], 0L);
      AppMethodBeat.o(43676);
      return;
    }
  }
  
  public final String RD()
  {
    int j = -1;
    AppMethodBeat.i(43683);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    if (this.eyj != null) {}
    for (int i = this.eyj.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.esT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eua);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dVd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eub);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euc);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.eyk != null) {
        i = this.eyk.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ega);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euR);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eyl);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eym);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(43683);
      return localObject;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43684);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eyj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.esT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.eua);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.eub);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.euc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Ret:").append(this.eyk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.ega);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.euR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isParallel:").append(this.eyl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isUesd:").append(this.eym);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43684);
    return localObject;
  }
  
  public final long UY()
  {
    return this.eub;
  }
  
  public final long UZ()
  {
    return this.euc;
  }
  
  public final iv Vm()
  {
    this.eyl = 1L;
    return this;
  }
  
  public final iv a(a parama)
  {
    this.eyj = parama;
    return this;
  }
  
  public final iv a(b paramb)
  {
    this.eyk = paramb;
    return this;
  }
  
  public final String getAppId()
  {
    return this.esR;
  }
  
  public final int getId()
  {
    return 15798;
  }
  
  public final iv oP(long paramLong)
  {
    this.eru = paramLong;
    return this;
  }
  
  public final iv oQ(long paramLong)
  {
    this.esT = paramLong;
    return this;
  }
  
  public final iv oR(long paramLong)
  {
    AppMethodBeat.i(43679);
    this.eua = paramLong;
    super.bf("CostTimeMs", this.eua);
    AppMethodBeat.o(43679);
    return this;
  }
  
  public final iv oS(long paramLong)
  {
    this.dVd = paramLong;
    return this;
  }
  
  public final iv oT(long paramLong)
  {
    AppMethodBeat.i(43680);
    this.eub = paramLong;
    super.bg("StartTimeStampMs", this.eub);
    AppMethodBeat.o(43680);
    return this;
  }
  
  public final iv oU(long paramLong)
  {
    AppMethodBeat.i(43681);
    this.euc = paramLong;
    super.bg("EndTimeStampMs", this.euc);
    AppMethodBeat.o(43681);
    return this;
  }
  
  public final iv oV(long paramLong)
  {
    this.ega = paramLong;
    return this;
  }
  
  public final iv oW(long paramLong)
  {
    this.eym = paramLong;
    return this;
  }
  
  public final iv rv(String paramString)
  {
    AppMethodBeat.i(43677);
    this.eqt = t("InstanceId", paramString, true);
    AppMethodBeat.o(43677);
    return this;
  }
  
  public final iv rw(String paramString)
  {
    AppMethodBeat.i(43678);
    this.esR = t("AppId", paramString, true);
    AppMethodBeat.o(43678);
    return this;
  }
  
  public final iv rx(String paramString)
  {
    AppMethodBeat.i(43682);
    this.euR = t("username", paramString, true);
    AppMethodBeat.o(43682);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43672);
      eyn = new a("release", 0, 1);
      eyo = new a("debug", 1, 2);
      eyp = new a("demo", 2, 3);
      eyq = new a[] { eyn, eyo, eyp };
      AppMethodBeat.o(43672);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jA(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eyn;
      case 2: 
        return eyo;
      }
      return eyp;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43675);
      eyr = new b("ok", 0, 0);
      eys = new b("common_fail", 1, 1);
      eyt = new b[] { eyr, eys };
      AppMethodBeat.o(43675);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static b jB(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return eyr;
      }
      return eys;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.iv
 * JD-Core Version:    0.7.0.1
 */