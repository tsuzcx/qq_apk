package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class im
  extends a
{
  public long dWt = 0L;
  public String esa = "";
  public long etb = 0L;
  public long euA = 0L;
  public String euy = "";
  private long evH = 0L;
  public long evI = 0L;
  public long evJ = 0L;
  public String evc = "";
  public long evp = 0L;
  public long evs = 0L;
  public long ewJ = 0L;
  public String ewR = "";
  public long ewS = 0L;
  public long ewT = 0L;
  public long ewU;
  public long exa = 0L;
  public long exb = 0L;
  public long exc = 0L;
  public long exr;
  public a exw;
  public String exx = "";
  public long exy;
  
  public final String RC()
  {
    AppMethodBeat.i(43589);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.exw != null) {}
    for (int i = this.exw.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dWt);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewR);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evs);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewS);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exa);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evc);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exb);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exc);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exx);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exy);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewU);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exr);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(43589);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43590);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.exw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.euA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.evH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.evI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.evJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("path:").append(this.ewR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.evs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPatch:").append(this.ewS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.evp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadPageFrame:").append(this.exa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.evc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSplitCodeLib:").append(this.exb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.ewT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isFirstPageRenderingCacheAccepted:").append(this.exc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showAd:").append(this.ewJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("libVersion:").append(this.exx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("canShowLoadingAdvert:").append(this.exy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LoadingInEndT:").append(this.ewU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.exr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43590);
    return localObject;
  }
  
  public final im Vo()
  {
    AppMethodBeat.i(43588);
    this.evJ = bu.fpO();
    super.bh("EndTimeStampMs", this.evJ);
    AppMethodBeat.o(43588);
    return this;
  }
  
  public final int getId()
  {
    return 16009;
  }
  
  public final im ok(long paramLong)
  {
    AppMethodBeat.i(43586);
    this.evH = paramLong;
    super.bg("CostTimeMs", this.evH);
    AppMethodBeat.o(43586);
    return this;
  }
  
  public final im ol(long paramLong)
  {
    AppMethodBeat.i(43587);
    this.evI = paramLong;
    super.bh("StartTimeStampMs", this.evI);
    AppMethodBeat.o(43587);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43585);
      exz = new a("release", 0, 1);
      exA = new a("debug", 1, 2);
      exB = new a("demo", 2, 3);
      exC = new a[] { exz, exA, exB };
      AppMethodBeat.o(43585);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a js(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return exz;
      case 2: 
        return exA;
      }
      return exB;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.im
 * JD-Core Version:    0.7.0.1
 */