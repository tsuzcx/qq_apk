package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class pa
  extends a
{
  private String gXM = "";
  public long gYL = 0L;
  public long gYN = 0L;
  private String gfn = "";
  private String gmF = "";
  public long gnP = 0L;
  private String gtA = "";
  public long hcB = 0L;
  public long hcE = 0L;
  private long hcT = 0L;
  public long hcU = 0L;
  public long hcV = 0L;
  public pa.a hdR;
  public long hdS = 0L;
  public long hdT = 0L;
  public long hdU;
  public long hdV = 0L;
  public long hdW = 0L;
  public long hdX = 0L;
  public long hdY = 0L;
  
  public final pa BA(long paramLong)
  {
    this.gYL = paramLong;
    return this;
  }
  
  public final pa BB(long paramLong)
  {
    this.gYN = paramLong;
    return this;
  }
  
  public final pa BC(long paramLong)
  {
    AppMethodBeat.i(43555);
    this.hcT = paramLong;
    super.bk("CostTimeMs", this.hcT);
    AppMethodBeat.o(43555);
    return this;
  }
  
  public final pa BD(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final pa BE(long paramLong)
  {
    AppMethodBeat.i(43556);
    this.hcU = paramLong;
    super.bm("StartTimeStampMs", this.hcU);
    AppMethodBeat.o(43556);
    return this;
  }
  
  public final pa BF(long paramLong)
  {
    this.hdS = paramLong;
    return this;
  }
  
  public final pa FV(String paramString)
  {
    AppMethodBeat.i(43553);
    this.gfn = z("InstanceId", paramString, true);
    AppMethodBeat.o(43553);
    return this;
  }
  
  public final pa FW(String paramString)
  {
    AppMethodBeat.i(43554);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(43554);
    return this;
  }
  
  public final pa FX(String paramString)
  {
    AppMethodBeat.i(43558);
    this.gXM = z("username", paramString, true);
    AppMethodBeat.o(43558);
    return this;
  }
  
  public final pa FY(String paramString)
  {
    AppMethodBeat.i(43559);
    this.gtA = z("networkType", paramString, true);
    AppMethodBeat.o(43559);
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
  
  public final pa a(pa.a parama)
  {
    this.hdR = parama;
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(43560);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    if (this.hdR != null) {}
    for (int i = this.hdR.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.gXM);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcE);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcB);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gtA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hdS);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hdT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hdU);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hdV);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hdW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hdX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hdY);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(43560);
      return localObject;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43561);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.hdR);
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
    ((StringBuffer)localObject).append("username:").append(this.gXM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.hcE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.hcB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.gtA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isContactSync:").append(this.hdS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isLaunchSync:").append(this.hdT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("phase:").append(this.hdU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showAd:").append(this.hdV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkShowAdTimeThreshold:").append(this.hdW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCheckJsApiInfoSync:").append(this.hdX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCheckAppidABTestInfoSync:").append(this.hdY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43561);
    return localObject;
  }
  
  public final pa aoF()
  {
    AppMethodBeat.i(43557);
    this.hcV = Util.nowMilliSecond();
    super.bm("EndTimeStampMs", this.hcV);
    AppMethodBeat.o(43557);
    return this;
  }
  
  public final pa aoG()
  {
    this.hcE = 0L;
    return this;
  }
  
  public final pa aoH()
  {
    this.hcB = 0L;
    return this;
  }
  
  public final pa aoI()
  {
    this.hdT = 2L;
    return this;
  }
  
  public final pa aoJ()
  {
    this.hdU = 0L;
    return this;
  }
  
  public final int getId()
  {
    return 18033;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pa
 * JD-Core Version:    0.7.0.1
 */