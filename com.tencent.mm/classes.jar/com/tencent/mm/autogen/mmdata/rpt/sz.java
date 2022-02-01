package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class sz
  extends a
{
  public String iEy = "";
  public String ilM = "";
  public String imT = "";
  public long ind = 0L;
  public long iqr = 0L;
  public long jAa = 0L;
  public long jAb = 0L;
  public long jAc = 0L;
  public long jAq;
  public sz.a jAv;
  public String jAw = "";
  public long jAx;
  public long jAy = 0L;
  public long jAz;
  public long jax = 0L;
  private long jyH = 0L;
  public long jyI = 0L;
  public long jyJ = 0L;
  public long jyp = 0L;
  public long jys = 0L;
  public long jzI = 0L;
  public String jzR = "";
  public long jzS = 0L;
  public long jzT = 0L;
  public long jzU;
  
  public final String aIE()
  {
    AppMethodBeat.i(43589);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ind);
    ((StringBuffer)localObject).append(",");
    if (this.jAv != null) {}
    for (int i = this.jAv.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.jzR);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jys);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jzS);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAa);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iEy);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAb);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jzT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAc);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jzI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAw);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAx);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jzU);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAy);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAz);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(43589);
      return localObject;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43590);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.ind);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.jAv);
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
    ((StringBuffer)localObject).append("path:").append(this.jzR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.jys);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPatch:").append(this.jzS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.jyp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadPageFrame:").append(this.jAa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.iEy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSplitCodeLib:").append(this.jAb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.jzT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isFirstPageRenderingCacheAccepted:").append(this.jAc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showAd:").append(this.jzI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("libVersion:").append(this.jAw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("canShowLoadingAdvert:").append(this.jAx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LoadingInEndT:").append(this.jzU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.jAq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadSo:").append(this.jAy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("webviewType:").append(this.jAz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43590);
    return localObject;
  }
  
  public final sz aJe()
  {
    AppMethodBeat.i(43588);
    this.jyJ = Util.nowMilliSecond();
    super.by("EndTimeStampMs", this.jyJ);
    AppMethodBeat.o(43588);
    return this;
  }
  
  public final sz fW(long paramLong)
  {
    AppMethodBeat.i(43586);
    this.jyH = paramLong;
    super.bw("CostTimeMs", this.jyH);
    AppMethodBeat.o(43586);
    return this;
  }
  
  public final sz fX(long paramLong)
  {
    AppMethodBeat.i(43587);
    this.jyI = paramLong;
    super.by("StartTimeStampMs", this.jyI);
    AppMethodBeat.o(43587);
    return this;
  }
  
  public final int getId()
  {
    return 16009;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sz
 * JD-Core Version:    0.7.0.1
 */