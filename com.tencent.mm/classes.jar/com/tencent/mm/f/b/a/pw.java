package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class pw
  extends a
{
  public long gHC = 0L;
  public long gYL = 0L;
  public long gYN = 0L;
  public String gfn = "";
  public String gmF = "";
  public long gnP = 0L;
  public long hcB = 0L;
  private long hcT = 0L;
  public long hcU = 0L;
  public long hcV = 0L;
  public long heD;
  public long heg = 0L;
  public pw.a hig;
  public long hih = 0L;
  public pw.c hii;
  public pw.b hij;
  public long hik = 0L;
  private long hil = 0L;
  private long him = 0L;
  private long hin = 0L;
  public long hio;
  public long hip;
  public long hiq;
  public long hir;
  public pw.e his;
  public long hit;
  public pw.d hiu;
  public long hiv;
  
  public final pw Dl(long paramLong)
  {
    AppMethodBeat.i(43718);
    this.hcT = paramLong;
    super.bk("CostTimeMs", this.hcT);
    AppMethodBeat.o(43718);
    return this;
  }
  
  public final pw Dm(long paramLong)
  {
    AppMethodBeat.i(43719);
    this.hcU = paramLong;
    super.bm("StartTimeStampMs", this.hcU);
    AppMethodBeat.o(43719);
    return this;
  }
  
  public final pw Dn(long paramLong)
  {
    AppMethodBeat.i(43721);
    this.hin = paramLong;
    super.bk("NonUICostTimeMs", this.hin);
    AppMethodBeat.o(43721);
    return this;
  }
  
  public final String agH()
  {
    int j = -1;
    AppMethodBeat.i(43722);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    if (this.hig != null)
    {
      i = this.hig.value;
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
      ((StringBuffer)localObject).append(this.hih);
      ((StringBuffer)localObject).append(",");
      if (this.hii == null) {
        break label541;
      }
      i = this.hii.value;
      label202:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.hij == null) {
        break label546;
      }
      i = this.hij.value;
      label230:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gHC);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hik);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hil);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.him);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcB);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hin);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.heg);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hio);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hip);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hiq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hir);
      ((StringBuffer)localObject).append(",");
      if (this.his == null) {
        break label551;
      }
    }
    label541:
    label546:
    label551:
    for (int i = this.his.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hit);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.heD);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.hiu != null) {
        i = this.hiu.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hiv);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(43722);
      return localObject;
      i = -1;
      break;
      i = -1;
      break label202;
      i = -1;
      break label230;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43723);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.hig);
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
    ((StringBuffer)localObject).append("PkgSize:").append(this.hih);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLaunchSync:").append(this.hii);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsContactSync:").append(this.hij);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.gHC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasDownloadCode:").append(this.hik);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFirstDownload:").append(this.hil);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchType:").append(this.him);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.hcB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NonUICostTimeMs:").append(this.hin);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.heg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("launchReadyT:").append(this.hio);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("packageReadyT:").append(this.hip);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UIReadyT:").append(this.hiq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("requestType:").append(this.hir);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCheckJsApiInfoSync:").append(this.his);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkJsApiInfoReadyT:").append(this.hit);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.heD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCheckAppidABTestInfoSync:").append(this.hiu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkAppidABTestInfoReadyT:").append(this.hiv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43723);
    return localObject;
  }
  
  public final pw aoT()
  {
    AppMethodBeat.i(43720);
    this.hcV = Util.nowMilliSecond();
    super.bm("EndTimeStampMs", this.hcV);
    AppMethodBeat.o(43720);
    return this;
  }
  
  public final int getId()
  {
    return 15766;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pw
 * JD-Core Version:    0.7.0.1
 */