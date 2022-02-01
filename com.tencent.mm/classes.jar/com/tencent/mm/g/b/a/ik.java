package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class ik
  extends a
{
  public long dVd = 0L;
  public String eqt = "";
  public long eru = 0L;
  public String esR = "";
  public long esT = 0L;
  public long etI = 0L;
  public long etL = 0L;
  public String etv = "";
  private long eua = 0L;
  public long eub = 0L;
  public long euc = 0L;
  public long evK;
  public ik.a evP;
  public String evQ;
  public long evR;
  public long evc = 0L;
  public String evk = "";
  public long evl = 0L;
  public long evm = 0L;
  public long evn;
  public long evt = 0L;
  public long evu = 0L;
  public long evv = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(43589);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    if (this.evP != null) {}
    for (int i = this.evP.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.evk);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.etL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evl);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.etI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evt);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.etv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evu);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evm);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evc);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evQ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evR);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evn);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evK);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(43589);
      return localObject;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43590);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.evP);
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
    ((StringBuffer)localObject).append("path:").append(this.evk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.etL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPatch:").append(this.evl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.etI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadPageFrame:").append(this.evt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.etv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSplitCodeLib:").append(this.evu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.evm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isFirstPageRenderingCacheAccepted:").append(this.evv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showAd:").append(this.evc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("libVersion:").append(this.evQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("canShowLoadingAdvert:").append(this.evR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LoadingInEndT:").append(this.evn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.evK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43590);
    return localObject;
  }
  
  public final ik Vi()
  {
    AppMethodBeat.i(43588);
    this.euc = bt.flT();
    super.bg("EndTimeStampMs", this.euc);
    AppMethodBeat.o(43588);
    return this;
  }
  
  public final int getId()
  {
    return 16009;
  }
  
  public final ik nY(long paramLong)
  {
    AppMethodBeat.i(43586);
    this.eua = paramLong;
    super.bf("CostTimeMs", this.eua);
    AppMethodBeat.o(43586);
    return this;
  }
  
  public final ik nZ(long paramLong)
  {
    AppMethodBeat.i(43587);
    this.eub = paramLong;
    super.bg("StartTimeStampMs", this.eub);
    AppMethodBeat.o(43587);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ik
 * JD-Core Version:    0.7.0.1
 */