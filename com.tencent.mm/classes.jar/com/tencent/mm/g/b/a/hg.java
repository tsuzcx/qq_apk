package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class hg
  extends a
{
  public long dHY = 0L;
  public String dZT = "";
  public long eaM = 0L;
  public String ecQ = "";
  public String ecm = "";
  public long eco = 0L;
  public long edd = 0L;
  public long edg = 0L;
  private long edv = 0L;
  public long edw = 0L;
  public long edx = 0L;
  public long eeA;
  public long eeG = 0L;
  public long eeH = 0L;
  public long eeI = 0L;
  public long eeY;
  public long eep = 0L;
  public String eex = "";
  public long eey = 0L;
  public long eez = 0L;
  public a efd;
  public String efe;
  public long eff;
  
  public final String PR()
  {
    AppMethodBeat.i(43589);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.efd != null) {}
    for (int i = this.efd.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eco);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dHY);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edw);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edx);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eex);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edg);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eey);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeG);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecQ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eez);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eep);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.efe);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eff);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeY);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43589);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43590);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.efd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eco);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.edv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.edw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.edx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("path:").append(this.eex);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.edg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPatch:").append(this.eey);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.edd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadPageFrame:").append(this.eeG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.ecQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSplitCodeLib:").append(this.eeH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.eez);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isFirstPageRenderingCacheAccepted:").append(this.eeI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showAd:").append(this.eep);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("libVersion:").append(this.efe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("canShowLoadingAdvert:").append(this.eff);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LoadingInEndT:").append(this.eeA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.eeY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43590);
    return localObject;
  }
  
  public final hg SU()
  {
    AppMethodBeat.i(43588);
    this.edx = bs.eWj();
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(43588);
    return this;
  }
  
  public final int getId()
  {
    return 16009;
  }
  
  public final hg ma(long paramLong)
  {
    AppMethodBeat.i(43586);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(43586);
    return this;
  }
  
  public final hg mb(long paramLong)
  {
    AppMethodBeat.i(43587);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(43587);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43585);
      efg = new a("release", 0, 1);
      efh = new a("debug", 1, 2);
      efi = new a("demo", 2, 3);
      efj = new a[] { efg, efh, efi };
      AppMethodBeat.o(43585);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iU(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return efg;
      case 2: 
        return efh;
      }
      return efi;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hg
 * JD-Core Version:    0.7.0.1
 */