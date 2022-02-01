package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class if
  extends a
{
  public long dVd = 0L;
  private String eqt = "";
  public long eru = 0L;
  private String esR = "";
  public long esT = 0L;
  public long etI = 0L;
  public long etL = 0L;
  private String etv = "";
  private String euR = "";
  public if.a euY;
  public long euZ = 0L;
  private long eua = 0L;
  public long eub = 0L;
  public long euc = 0L;
  public long eva = 0L;
  public long evb;
  public long evc = 0L;
  public long evd = 0L;
  public long eve = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(43560);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    if (this.euY != null) {}
    for (int i = this.euY.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.euR);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.etL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.etI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.etv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euZ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eva);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evb);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evc);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eve);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(43560);
      return localObject;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43561);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.euY);
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
    ((StringBuffer)localObject).append("username:").append(this.euR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.etL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.etI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.etv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isContactSync:").append(this.euZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isLaunchSync:").append(this.eva);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("phase:").append(this.evb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showAd:").append(this.evc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkShowAdTimeThreshold:").append(this.evd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCheckJsApiInfoSync:").append(this.eve);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43561);
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
  
  public final if Va()
  {
    AppMethodBeat.i(43557);
    this.euc = bt.flT();
    super.bg("EndTimeStampMs", this.euc);
    AppMethodBeat.o(43557);
    return this;
  }
  
  public final if Vb()
  {
    this.etL = 0L;
    return this;
  }
  
  public final if Vc()
  {
    this.etI = 0L;
    return this;
  }
  
  public final if Vd()
  {
    this.eva = 2L;
    return this;
  }
  
  public final if Ve()
  {
    this.evb = 0L;
    return this;
  }
  
  public final if a(if.a parama)
  {
    this.euY = parama;
    return this;
  }
  
  public final int getId()
  {
    return 18033;
  }
  
  public final if nJ(long paramLong)
  {
    this.eru = paramLong;
    return this;
  }
  
  public final if nK(long paramLong)
  {
    this.esT = paramLong;
    return this;
  }
  
  public final if nL(long paramLong)
  {
    AppMethodBeat.i(43555);
    this.eua = paramLong;
    super.bf("CostTimeMs", this.eua);
    AppMethodBeat.o(43555);
    return this;
  }
  
  public final if nM(long paramLong)
  {
    this.dVd = paramLong;
    return this;
  }
  
  public final if nN(long paramLong)
  {
    AppMethodBeat.i(43556);
    this.eub = paramLong;
    super.bg("StartTimeStampMs", this.eub);
    AppMethodBeat.o(43556);
    return this;
  }
  
  public final if nO(long paramLong)
  {
    this.euZ = paramLong;
    return this;
  }
  
  public final if qR(String paramString)
  {
    AppMethodBeat.i(43553);
    this.eqt = t("InstanceId", paramString, true);
    AppMethodBeat.o(43553);
    return this;
  }
  
  public final if qS(String paramString)
  {
    AppMethodBeat.i(43554);
    this.esR = t("AppId", paramString, true);
    AppMethodBeat.o(43554);
    return this;
  }
  
  public final if qT(String paramString)
  {
    AppMethodBeat.i(43558);
    this.euR = t("username", paramString, true);
    AppMethodBeat.o(43558);
    return this;
  }
  
  public final if qU(String paramString)
  {
    AppMethodBeat.i(43559);
    this.etv = t("networkType", paramString, true);
    AppMethodBeat.o(43559);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.if
 * JD-Core Version:    0.7.0.1
 */