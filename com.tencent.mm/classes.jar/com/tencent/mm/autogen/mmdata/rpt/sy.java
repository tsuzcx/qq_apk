package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class sy
  extends a
{
  public String iEy = "";
  public String ilM = "";
  public String imT = "";
  public long ind = 0L;
  public long iqr = 0L;
  public sy.a jAp;
  public long jAq;
  public long jax = 0L;
  private long jyH = 0L;
  private long jyI = 0L;
  public long jyJ = 0L;
  public long jyp = 0L;
  public long jys = 0L;
  public String jzR = "";
  public long jzS = 0L;
  public long jzT = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(43581);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ind);
    ((StringBuffer)localObject).append(",");
    if (this.jAp != null) {}
    for (int i = this.jAp.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.iEy);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jzT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAq);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(43581);
      return localObject;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43582);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.ind);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.jAp);
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
    ((StringBuffer)localObject).append("networkType:").append(this.iEy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.jzT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.jAq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43582);
    return localObject;
  }
  
  public final sy aJd()
  {
    AppMethodBeat.i(43580);
    this.jyJ = Util.nowMilliSecond();
    super.by("EndTimeStampMs", this.jyJ);
    AppMethodBeat.o(43580);
    return this;
  }
  
  public final sy fU(long paramLong)
  {
    AppMethodBeat.i(43578);
    this.jyH = paramLong;
    super.bw("CostTimeMs", this.jyH);
    AppMethodBeat.o(43578);
    return this;
  }
  
  public final sy fV(long paramLong)
  {
    AppMethodBeat.i(43579);
    this.jyI = paramLong;
    super.by("StartTimeStampMs", this.jyI);
    AppMethodBeat.o(43579);
    return this;
  }
  
  public final int getId()
  {
    return 16010;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sy
 * JD-Core Version:    0.7.0.1
 */