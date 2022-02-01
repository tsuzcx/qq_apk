package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class jc
  extends a
{
  public long dVd = 0L;
  public String eqt = "";
  public long eru = 0L;
  public String esR = "";
  public long esT = 0L;
  public long etI = 0L;
  public String etv = "";
  private long eua = 0L;
  public long eub = 0L;
  public long euc = 0L;
  public long evK;
  public String evk = "";
  public long evm = 0L;
  public long evt = 0L;
  public long evv = 0L;
  public jc.a ezJ;
  
  public final String RD()
  {
    AppMethodBeat.i(43748);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    if (this.ezJ != null) {}
    for (int i = this.ezJ.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.etI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evt);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.etv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evm);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evK);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(43748);
      return localObject;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43749);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ezJ);
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
    ((StringBuffer)localObject).append("isPreload:").append(this.etI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadPageFrame:").append(this.evt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.etv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.evm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isFirstPageRenderingCacheAccepted:").append(this.evv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.evK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43749);
    return localObject;
  }
  
  public final jc Vq()
  {
    AppMethodBeat.i(43747);
    this.euc = bt.flT();
    super.bg("EndTimeStampMs", this.euc);
    AppMethodBeat.o(43747);
    return this;
  }
  
  public final int getId()
  {
    return 16011;
  }
  
  public final jc py(long paramLong)
  {
    AppMethodBeat.i(43745);
    this.eua = paramLong;
    super.bf("CostTimeMs", this.eua);
    AppMethodBeat.o(43745);
    return this;
  }
  
  public final jc pz(long paramLong)
  {
    AppMethodBeat.i(43746);
    this.eub = paramLong;
    super.bg("StartTimeStampMs", this.eub);
    AppMethodBeat.o(43746);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jc
 * JD-Core Version:    0.7.0.1
 */