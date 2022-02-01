package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class iz
  extends a
{
  public long dVd = 0L;
  public long ega = 0L;
  public String eqt = "";
  public long eru = 0L;
  public String esR = "";
  public long esT = 0L;
  public long etI = 0L;
  private long eua = 0L;
  public long eub = 0L;
  public long euc = 0L;
  public long evK;
  public long evm = 0L;
  public iz.a eza;
  public long ezb = 0L;
  public iz.c ezc;
  public iz.b ezd;
  public long eze = 0L;
  private long ezf = 0L;
  private long ezg = 0L;
  private long ezh = 0L;
  public long ezi;
  public long ezj;
  public long ezk;
  public long ezl;
  public iz.d ezm;
  public long ezn;
  
  public final String RD()
  {
    int j = -1;
    AppMethodBeat.i(43722);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    if (this.eza != null)
    {
      i = this.eza.value;
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
      ((StringBuffer)localObject).append(this.ezb);
      ((StringBuffer)localObject).append(",");
      if (this.ezc == null) {
        break label497;
      }
      i = this.ezc.value;
      label202:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.ezd == null) {
        break label502;
      }
    }
    label497:
    label502:
    for (int i = this.ezd.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ega);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eze);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ezf);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ezg);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.etI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ezh);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evm);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ezi);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ezj);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ezk);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ezl);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.ezm != null) {
        i = this.ezm.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ezn);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evK);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(43722);
      return localObject;
      i = -1;
      break;
      i = -1;
      break label202;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43723);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eza);
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
    ((StringBuffer)localObject).append("PkgSize:").append(this.ezb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLaunchSync:").append(this.ezc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsContactSync:").append(this.ezd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.ega);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasDownloadCode:").append(this.eze);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFirstDownload:").append(this.ezf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchType:").append(this.ezg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.etI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NonUICostTimeMs:").append(this.ezh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.evm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("launchReadyT:").append(this.ezi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("packageReadyT:").append(this.ezj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UIReadyT:").append(this.ezk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("requestType:").append(this.ezl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCheckJsApiInfoSync:").append(this.ezm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkJsApiInfoReadyT:").append(this.ezn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.evK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43723);
    return localObject;
  }
  
  public final iz Vo()
  {
    AppMethodBeat.i(43720);
    this.euc = bt.flT();
    super.bg("EndTimeStampMs", this.euc);
    AppMethodBeat.o(43720);
    return this;
  }
  
  public final int getId()
  {
    return 15766;
  }
  
  public final iz pn(long paramLong)
  {
    AppMethodBeat.i(43718);
    this.eua = paramLong;
    super.bf("CostTimeMs", this.eua);
    AppMethodBeat.o(43718);
    return this;
  }
  
  public final iz po(long paramLong)
  {
    AppMethodBeat.i(43719);
    this.eub = paramLong;
    super.bg("StartTimeStampMs", this.eub);
    AppMethodBeat.o(43719);
    return this;
  }
  
  public final iz pp(long paramLong)
  {
    AppMethodBeat.i(43721);
    this.ezh = paramLong;
    super.bf("NonUICostTimeMs", this.ezh);
    AppMethodBeat.o(43721);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.iz
 * JD-Core Version:    0.7.0.1
 */