package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class tk
  extends a
{
  public long iVU = 0L;
  private String ilM = "";
  private String imT = "";
  public long ind = 0L;
  public long iqr = 0L;
  public String irj = "";
  public a jCT;
  public c jCU;
  public b jCV;
  private String jCW = "";
  public long jax = 0L;
  private long jyH = 0L;
  private long jyI = 0L;
  private long jyJ = 0L;
  
  public final String aIE()
  {
    int j = -1;
    AppMethodBeat.i(43668);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ind);
    ((StringBuffer)localObject).append(",");
    if (this.jCT != null)
    {
      i = this.jCT.value;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jax);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iqr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyJ);
      ((StringBuffer)localObject).append(",");
      if (this.jCU == null) {
        break label293;
      }
    }
    label293:
    for (int i = this.jCU.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.jCV != null) {
        i = this.jCV.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iVU);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.irj);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jCW);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(43668);
      return localObject;
      i = -1;
      break;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43669);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.ind);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.jCT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.jax);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.jyH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.jyI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.jyJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Ret:").append(this.jCU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.jCV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.iVU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.irj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkTypeStr:").append(this.jCW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43669);
    return localObject;
  }
  
  public final int getId()
  {
    return 15764;
  }
  
  public final tk gl(long paramLong)
  {
    AppMethodBeat.i(43665);
    this.jyH = paramLong;
    super.bw("CostTimeMs", this.jyH);
    AppMethodBeat.o(43665);
    return this;
  }
  
  public final tk gm(long paramLong)
  {
    AppMethodBeat.i(43666);
    this.jyI = paramLong;
    super.by("StartTimeStampMs", this.jyI);
    AppMethodBeat.o(43666);
    return this;
  }
  
  public final tk gn(long paramLong)
  {
    AppMethodBeat.i(43667);
    this.jyJ = paramLong;
    super.by("EndTimeStampMs", this.jyJ);
    AppMethodBeat.o(43667);
    return this;
  }
  
  public final tk zO(String paramString)
  {
    AppMethodBeat.i(43663);
    this.ilM = F("InstanceId", paramString, true);
    AppMethodBeat.o(43663);
    return this;
  }
  
  public final tk zP(String paramString)
  {
    AppMethodBeat.i(43664);
    this.imT = F("AppId", paramString, true);
    AppMethodBeat.o(43664);
    return this;
  }
  
  public final tk zQ(String paramString)
  {
    AppMethodBeat.i(368825);
    this.jCW = F("NetworkTypeStr", paramString, true);
    AppMethodBeat.o(368825);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43656);
      jCX = new a("release", 0, 1);
      jCY = new a("debug", 1, 2);
      jCZ = new a("demo", 2, 3);
      jDa = new a[] { jCX, jCY, jCZ };
      AppMethodBeat.o(43656);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a pa(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return jCX;
      case 2: 
        return jCY;
      }
      return jCZ;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43659);
      jDb = new b("sync", 0, 0);
      jDc = new b("async", 1, 1);
      jDd = new b[] { jDb, jDc };
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
      jDe = new c("ok", 0, 0);
      jDf = new c("common_fail", 1, 1);
      jDg = new c[] { jDe, jDf };
      AppMethodBeat.o(43662);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.tk
 * JD-Core Version:    0.7.0.1
 */