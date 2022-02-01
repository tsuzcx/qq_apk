package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class mi
  extends a
{
  public String eJx = "";
  public String eWb = "";
  public long eXc = 0L;
  public long eYW = 0L;
  public long eZK = 0L;
  public long eZN = 0L;
  public long erW = 0L;
  public String exq = "";
  private long fac = 0L;
  public long fad = 0L;
  public long fae = 0L;
  public long fbM;
  public a fbR;
  public String fbS = "";
  public long fbT;
  public long fbU = 0L;
  public long fbe = 0L;
  public String fbm = "";
  public long fbn = 0L;
  public long fbo = 0L;
  public long fbp;
  public long fbv = 0L;
  public long fbw = 0L;
  public long fbx = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(43589);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.fbR != null) {}
    for (int i = this.fbR.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eYW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fac);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.erW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fad);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fae);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbm);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eZN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbn);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eZK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbw);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbo);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbx);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbe);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbS);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbM);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbU);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(43589);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43590);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.fbR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eYW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.fac);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.fad);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.fae);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("path:").append(this.fbm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.eZN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPatch:").append(this.fbn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.eZK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadPageFrame:").append(this.fbv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.exq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSplitCodeLib:").append(this.fbw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.fbo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isFirstPageRenderingCacheAccepted:").append(this.fbx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showAd:").append(this.fbe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("libVersion:").append(this.fbS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("canShowLoadingAdvert:").append(this.fbT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LoadingInEndT:").append(this.fbp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.fbM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadSo:").append(this.fbU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43590);
    return localObject;
  }
  
  public final mi ajf()
  {
    AppMethodBeat.i(43588);
    this.fae = Util.nowMilliSecond();
    super.bj("EndTimeStampMs", this.fae);
    AppMethodBeat.o(43588);
    return this;
  }
  
  public final int getId()
  {
    return 16009;
  }
  
  public final mi vU(long paramLong)
  {
    AppMethodBeat.i(43586);
    this.fac = paramLong;
    super.bi("CostTimeMs", this.fac);
    AppMethodBeat.o(43586);
    return this;
  }
  
  public final mi vV(long paramLong)
  {
    AppMethodBeat.i(43587);
    this.fad = paramLong;
    super.bj("StartTimeStampMs", this.fad);
    AppMethodBeat.o(43587);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43585);
      fbV = new a("release", 0, 1);
      fbW = new a("debug", 1, 2);
      fbX = new a("demo", 2, 3);
      fbY = new a[] { fbV, fbW, fbX };
      AppMethodBeat.o(43585);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a mu(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return fbV;
      case 2: 
        return fbW;
      }
      return fbX;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.mi
 * JD-Core Version:    0.7.0.1
 */