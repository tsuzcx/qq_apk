package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class io
  extends a
{
  private String dUy = "";
  private long dWt = 0L;
  private String esa = "";
  private long etb = 0L;
  private long euA = 0L;
  private String euy = "";
  private long evH = 0L;
  private long evI = 0L;
  private long evJ = 0L;
  private String evc = "";
  private String ewR = "";
  private a exF;
  private long exG = 0L;
  private long exH = 0L;
  private String exI = "";
  private String exJ = "";
  private String exK = "";
  private int exL;
  private long exM;
  private long exN;
  private long exr;
  
  public final String RC()
  {
    AppMethodBeat.i(43609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.exF != null) {}
    for (int i = this.exF.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.evc);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exG);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dUy);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewR);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exM);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exN);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(43609);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43610);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.exF);
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
    ((StringBuffer)localObject).append("networkType:").append(this.evc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isLaunch:").append(this.exG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.dUy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("loadingType:").append(this.exH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene_data:").append(this.exI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.exr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("path:").append(this.ewR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reload_referrer:").append(this.exJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reload_reason:").append(this.exK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("user_type:").append(this.exL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("launchMode:").append(this.exM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("coldStartMode:").append(this.exN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43610);
    return localObject;
  }
  
  public final String UF()
  {
    return this.esa;
  }
  
  public final io Vq()
  {
    this.exN = 0L;
    return this;
  }
  
  public final io a(a parama)
  {
    this.exF = parama;
    return this;
  }
  
  public final int getId()
  {
    return 16367;
  }
  
  public final io jt(int paramInt)
  {
    this.exL = paramInt;
    return this;
  }
  
  public final io oA(long paramLong)
  {
    this.exr = paramLong;
    return this;
  }
  
  public final io oB(long paramLong)
  {
    this.exM = paramLong;
    return this;
  }
  
  public final io ou(long paramLong)
  {
    this.etb = paramLong;
    return this;
  }
  
  public final io ov(long paramLong)
  {
    this.euA = paramLong;
    return this;
  }
  
  public final io ow(long paramLong)
  {
    this.dWt = paramLong;
    return this;
  }
  
  public final io ox(long paramLong)
  {
    AppMethodBeat.i(43606);
    this.evI = paramLong;
    super.bh("StartTimeStampMs", this.evI);
    AppMethodBeat.o(43606);
    return this;
  }
  
  public final io oy(long paramLong)
  {
    this.exG = paramLong;
    return this;
  }
  
  public final io oz(long paramLong)
  {
    this.exH = paramLong;
    return this;
  }
  
  public final io rA(String paramString)
  {
    AppMethodBeat.i(221950);
    this.ewR = t("path", paramString, true);
    AppMethodBeat.o(221950);
    return this;
  }
  
  public final io rB(String paramString)
  {
    AppMethodBeat.i(221951);
    this.exJ = t("reload_referrer", paramString, true);
    AppMethodBeat.o(221951);
    return this;
  }
  
  public final io rC(String paramString)
  {
    AppMethodBeat.i(221952);
    this.exK = t("reload_reason", paramString, true);
    AppMethodBeat.o(221952);
    return this;
  }
  
  public final io rw(String paramString)
  {
    AppMethodBeat.i(43604);
    this.esa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43604);
    return this;
  }
  
  public final io rx(String paramString)
  {
    AppMethodBeat.i(43605);
    this.euy = t("AppId", paramString, true);
    AppMethodBeat.o(43605);
    return this;
  }
  
  public final io ry(String paramString)
  {
    AppMethodBeat.i(221949);
    this.evc = t("networkType", paramString, true);
    AppMethodBeat.o(221949);
    return this;
  }
  
  public final io rz(String paramString)
  {
    AppMethodBeat.i(43608);
    this.dUy = t("UserName", paramString, true);
    AppMethodBeat.o(43608);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43603);
      exO = new a("release", 0, 1);
      exP = new a("debug", 1, 2);
      exQ = new a("demo", 2, 3);
      exR = new a[] { exO, exP, exQ };
      AppMethodBeat.o(43603);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a ju(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return exO;
      case 2: 
        return exP;
      }
      return exQ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.io
 * JD-Core Version:    0.7.0.1
 */