package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iw
  extends a
{
  public String dUy = "";
  public long dWt = 0L;
  public long ehL = 0L;
  private String esa = "";
  public long etb = 0L;
  public long euA = 0L;
  private String euy = "";
  private long evH = 0L;
  private long evI = 0L;
  private long evJ = 0L;
  public a ezF;
  public c ezG;
  public b ezH;
  
  public final String RC()
  {
    int j = -1;
    AppMethodBeat.i(43668);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.ezF != null)
    {
      i = this.ezF.value;
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
      if (this.ezG == null) {
        break label277;
      }
    }
    label277:
    for (int i = this.ezG.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.ezH != null) {
        i = this.ezH.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ehL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dUy);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(43668);
      return localObject;
      i = -1;
      break;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43669);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ezF);
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
    ((StringBuffer)localObject).append("Ret:").append(this.ezG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.ezH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.ehL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.dUy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43669);
    return localObject;
  }
  
  public final iw a(a parama)
  {
    this.ezF = parama;
    return this;
  }
  
  public final int getId()
  {
    return 15764;
  }
  
  public final iw oW(long paramLong)
  {
    this.etb = paramLong;
    return this;
  }
  
  public final iw oX(long paramLong)
  {
    this.euA = paramLong;
    return this;
  }
  
  public final iw oY(long paramLong)
  {
    AppMethodBeat.i(43665);
    this.evH = paramLong;
    super.bg("CostTimeMs", this.evH);
    AppMethodBeat.o(43665);
    return this;
  }
  
  public final iw oZ(long paramLong)
  {
    this.dWt = paramLong;
    return this;
  }
  
  public final iw pa(long paramLong)
  {
    AppMethodBeat.i(43666);
    this.evI = paramLong;
    super.bh("StartTimeStampMs", this.evI);
    AppMethodBeat.o(43666);
    return this;
  }
  
  public final iw pb(long paramLong)
  {
    AppMethodBeat.i(43667);
    this.evJ = paramLong;
    super.bh("EndTimeStampMs", this.evJ);
    AppMethodBeat.o(43667);
    return this;
  }
  
  public final iw rO(String paramString)
  {
    AppMethodBeat.i(43663);
    this.esa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43663);
    return this;
  }
  
  public final iw rP(String paramString)
  {
    AppMethodBeat.i(43664);
    this.euy = t("AppId", paramString, true);
    AppMethodBeat.o(43664);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43656);
      ezI = new a("release", 0, 1);
      ezJ = new a("debug", 1, 2);
      ezK = new a("demo", 2, 3);
      ezL = new a[] { ezI, ezJ, ezK };
      AppMethodBeat.o(43656);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jB(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ezI;
      case 2: 
        return ezJ;
      }
      return ezK;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43659);
      ezM = new b("sync", 0, 0);
      ezN = new b("async", 1, 1);
      ezO = new b[] { ezM, ezN };
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
      ezP = new c("ok", 0, 0);
      ezQ = new c("common_fail", 1, 1);
      ezR = new c[] { ezP, ezQ };
      AppMethodBeat.o(43662);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.iw
 * JD-Core Version:    0.7.0.1
 */