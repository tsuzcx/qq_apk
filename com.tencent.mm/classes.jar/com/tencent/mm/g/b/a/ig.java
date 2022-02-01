package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ig
  extends a
{
  private long dVd = 0L;
  public String eqt = "";
  public long eru = 0L;
  public String esR = "";
  public long esT = 0L;
  public long etI;
  public long etL;
  private long eua = 0L;
  public long eub = 0L;
  public long euc = 0L;
  public ig.a evj;
  public String evk;
  public long evl;
  public long evm;
  public long evn;
  
  public final String RD()
  {
    AppMethodBeat.i(187838);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    if (this.evj != null) {}
    for (int i = this.evj.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.evm);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evn);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(187838);
      return localObject;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(187839);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.evj);
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
    ((StringBuffer)localObject).append("initProcess:").append(this.evm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LoadingInEndT:").append(this.evn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(187839);
    return localObject;
  }
  
  public final int getId()
  {
    return 19266;
  }
  
  public final ig nP(long paramLong)
  {
    AppMethodBeat.i(187835);
    this.eua = paramLong;
    super.bf("CostTimeMs", this.eua);
    AppMethodBeat.o(187835);
    return this;
  }
  
  public final ig nQ(long paramLong)
  {
    AppMethodBeat.i(187836);
    this.eub = paramLong;
    super.bg("StartTimeStampMs", this.eub);
    AppMethodBeat.o(187836);
    return this;
  }
  
  public final ig nR(long paramLong)
  {
    AppMethodBeat.i(187837);
    this.euc = paramLong;
    super.bg("EndTimeStampMs", this.euc);
    AppMethodBeat.o(187837);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ig
 * JD-Core Version:    0.7.0.1
 */