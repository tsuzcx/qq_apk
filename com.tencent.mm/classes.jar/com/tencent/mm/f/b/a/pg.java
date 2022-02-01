package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class pg
  extends a
{
  public long gYL = 0L;
  public long gYN = 0L;
  public String gfn = "";
  public String gmF = "";
  public long gnP = 0L;
  public String gtA = "";
  public long hcB = 0L;
  public long hcE = 0L;
  private long hcT = 0L;
  public long hcU = 0L;
  public long hcV = 0L;
  public long hdV = 0L;
  public long heD;
  public pg.a heI;
  public String heJ = "";
  public long heK;
  public long heL = 0L;
  public String hee = "";
  public long hef = 0L;
  public long heg = 0L;
  public long heh;
  public long hen = 0L;
  public long heo = 0L;
  public long hep = 0L;
  
  public final pg BP(long paramLong)
  {
    AppMethodBeat.i(43586);
    this.hcT = paramLong;
    super.bk("CostTimeMs", this.hcT);
    AppMethodBeat.o(43586);
    return this;
  }
  
  public final pg BQ(long paramLong)
  {
    AppMethodBeat.i(43587);
    this.hcU = paramLong;
    super.bm("StartTimeStampMs", this.hcU);
    AppMethodBeat.o(43587);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(43589);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    if (this.heI != null) {}
    for (int i = this.heI.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.hee);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcE);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hef);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcB);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hen);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gtA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.heo);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.heg);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hep);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hdV);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.heJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.heK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.heh);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.heD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.heL);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(43589);
      return localObject;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43590);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.heI);
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
    ((StringBuffer)localObject).append("path:").append(this.hee);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.hcE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPatch:").append(this.hef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.hcB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadPageFrame:").append(this.hen);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.gtA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSplitCodeLib:").append(this.heo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.heg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isFirstPageRenderingCacheAccepted:").append(this.hep);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showAd:").append(this.hdV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("libVersion:").append(this.heJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("canShowLoadingAdvert:").append(this.heK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LoadingInEndT:").append(this.heh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.heD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadSo:").append(this.heL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43590);
    return localObject;
  }
  
  public final pg aoN()
  {
    AppMethodBeat.i(43588);
    this.hcV = Util.nowMilliSecond();
    super.bm("EndTimeStampMs", this.hcV);
    AppMethodBeat.o(43588);
    return this;
  }
  
  public final int getId()
  {
    return 16009;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pg
 * JD-Core Version:    0.7.0.1
 */