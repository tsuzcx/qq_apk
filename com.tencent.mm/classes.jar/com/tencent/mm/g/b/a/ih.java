package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class ih
  extends a
{
  public long dWt = 0L;
  private String esa = "";
  public long etb = 0L;
  public long euA = 0L;
  private String euy = "";
  private long evH = 0L;
  public long evI = 0L;
  public long evJ = 0L;
  private String evc = "";
  public long evp = 0L;
  public long evs = 0L;
  public a ewF;
  public long ewG = 0L;
  public long ewH = 0L;
  public long ewI;
  public long ewJ = 0L;
  public long ewK = 0L;
  public long ewL = 0L;
  private String ewy = "";
  
  public final String RC()
  {
    AppMethodBeat.i(43560);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.ewF != null) {}
    for (int i = this.ewF.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.ewy);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evs);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evc);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewG);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewL);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(43560);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43561);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ewF);
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
    ((StringBuffer)localObject).append("username:").append(this.ewy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.evs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.evp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.evc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isContactSync:").append(this.ewG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isLaunchSync:").append(this.ewH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("phase:").append(this.ewI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showAd:").append(this.ewJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkShowAdTimeThreshold:").append(this.ewK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCheckJsApiInfoSync:").append(this.ewL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43561);
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
  
  public final ih Vg()
  {
    AppMethodBeat.i(43557);
    this.evJ = bu.fpO();
    super.bh("EndTimeStampMs", this.evJ);
    AppMethodBeat.o(43557);
    return this;
  }
  
  public final ih Vh()
  {
    this.evs = 0L;
    return this;
  }
  
  public final ih Vi()
  {
    this.evp = 0L;
    return this;
  }
  
  public final ih Vj()
  {
    this.ewH = 2L;
    return this;
  }
  
  public final ih Vk()
  {
    this.ewI = 0L;
    return this;
  }
  
  public final ih a(a parama)
  {
    this.ewF = parama;
    return this;
  }
  
  public final int getId()
  {
    return 18033;
  }
  
  public final ih nV(long paramLong)
  {
    this.etb = paramLong;
    return this;
  }
  
  public final ih nW(long paramLong)
  {
    this.euA = paramLong;
    return this;
  }
  
  public final ih nX(long paramLong)
  {
    AppMethodBeat.i(43555);
    this.evH = paramLong;
    super.bg("CostTimeMs", this.evH);
    AppMethodBeat.o(43555);
    return this;
  }
  
  public final ih nY(long paramLong)
  {
    this.dWt = paramLong;
    return this;
  }
  
  public final ih nZ(long paramLong)
  {
    AppMethodBeat.i(43556);
    this.evI = paramLong;
    super.bh("StartTimeStampMs", this.evI);
    AppMethodBeat.o(43556);
    return this;
  }
  
  public final ih oa(long paramLong)
  {
    this.ewG = paramLong;
    return this;
  }
  
  public final ih rm(String paramString)
  {
    AppMethodBeat.i(43553);
    this.esa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43553);
    return this;
  }
  
  public final ih rn(String paramString)
  {
    AppMethodBeat.i(43554);
    this.euy = t("AppId", paramString, true);
    AppMethodBeat.o(43554);
    return this;
  }
  
  public final ih ro(String paramString)
  {
    AppMethodBeat.i(43558);
    this.ewy = t("username", paramString, true);
    AppMethodBeat.o(43558);
    return this;
  }
  
  public final ih rp(String paramString)
  {
    AppMethodBeat.i(43559);
    this.evc = t("networkType", paramString, true);
    AppMethodBeat.o(43559);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43552);
      ewM = new a("release", 0, 1);
      ewN = new a("debug", 1, 2);
      ewO = new a("demo", 2, 3);
      ewP = new a[] { ewM, ewN, ewO };
      AppMethodBeat.o(43552);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jo(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ewM;
      case 2: 
        return ewN;
      }
      return ewO;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ih
 * JD-Core Version:    0.7.0.1
 */