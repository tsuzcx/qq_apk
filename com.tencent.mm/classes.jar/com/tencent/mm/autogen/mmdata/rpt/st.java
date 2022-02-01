package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class st
  extends a
{
  private String iEy = "";
  private String ilM = "";
  private String imT = "";
  public long ind = 0L;
  private String iqX = "";
  public long iqr = 0L;
  public long jax = 0L;
  private long jyH = 0L;
  public long jyI = 0L;
  public long jyJ = 0L;
  public long jyp = 0L;
  public long jys = 0L;
  public st.a jzE;
  public long jzF = 0L;
  public long jzG = 0L;
  public long jzH;
  public long jzI = 0L;
  public long jzJ = 0L;
  public long jzK = 0L;
  public long jzL = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(43560);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ind);
    ((StringBuffer)localObject).append(",");
    if (this.jzE != null) {}
    for (int i = this.jzE.value;; i = -1)
    {
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
      ((StringBuffer)localObject).append(this.iqX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jys);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iEy);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jzF);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jzG);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jzH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jzI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jzJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jzK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jzL);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(43560);
      return localObject;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43561);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.ind);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.jzE);
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
    ((StringBuffer)localObject).append("username:").append(this.iqX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.jys);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.jyp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.iEy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isContactSync:").append(this.jzF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isLaunchSync:").append(this.jzG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("phase:").append(this.jzH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showAd:").append(this.jzI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkShowAdTimeThreshold:").append(this.jzJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCheckJsApiInfoSync:").append(this.jzK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCheckAppidABTestInfoSync:").append(this.jzL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43561);
    return localObject;
  }
  
  public final st aJa()
  {
    AppMethodBeat.i(43557);
    this.jyJ = Util.nowMilliSecond();
    super.by("EndTimeStampMs", this.jyJ);
    AppMethodBeat.o(43557);
    return this;
  }
  
  public final st fL(long paramLong)
  {
    AppMethodBeat.i(43555);
    this.jyH = paramLong;
    super.bw("CostTimeMs", this.jyH);
    AppMethodBeat.o(43555);
    return this;
  }
  
  public final st fM(long paramLong)
  {
    AppMethodBeat.i(43556);
    this.jyI = paramLong;
    super.by("StartTimeStampMs", this.jyI);
    AppMethodBeat.o(43556);
    return this;
  }
  
  public final int getId()
  {
    return 18033;
  }
  
  public final st zm(String paramString)
  {
    AppMethodBeat.i(43553);
    this.ilM = F("InstanceId", paramString, true);
    AppMethodBeat.o(43553);
    return this;
  }
  
  public final st zn(String paramString)
  {
    AppMethodBeat.i(43554);
    this.imT = F("AppId", paramString, true);
    AppMethodBeat.o(43554);
    return this;
  }
  
  public final st zo(String paramString)
  {
    AppMethodBeat.i(43558);
    this.iqX = F("username", paramString, true);
    AppMethodBeat.o(43558);
    return this;
  }
  
  public final st zp(String paramString)
  {
    AppMethodBeat.i(43559);
    this.iEy = F("networkType", paramString, true);
    AppMethodBeat.o(43559);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.st
 * JD-Core Version:    0.7.0.1
 */