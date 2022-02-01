package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class mx
  extends a
{
  public long eJb = 0L;
  public String eJx = "";
  public String eWb = "";
  public long eXc = 0L;
  public long eYW = 0L;
  public long eZK = 0L;
  public long erW = 0L;
  private long fac = 0L;
  public long fad = 0L;
  public long fae = 0L;
  public long fbM;
  public long fbo = 0L;
  public a ffg;
  public long ffh = 0L;
  public c ffi;
  public b ffj;
  public long ffk = 0L;
  private long ffl = 0L;
  private long ffm = 0L;
  private long ffn = 0L;
  public long ffo;
  public long ffp;
  public long ffq;
  public long ffr;
  public d ffs;
  public long fft;
  
  public final String abV()
  {
    int j = -1;
    AppMethodBeat.i(43722);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.ffg != null)
    {
      i = this.ffg.value;
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
      ((StringBuffer)localObject).append(this.ffh);
      ((StringBuffer)localObject).append(",");
      if (this.ffi == null) {
        break label497;
      }
      i = this.ffi.value;
      label202:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.ffj == null) {
        break label502;
      }
    }
    label497:
    label502:
    for (int i = this.ffj.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eJb);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ffk);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ffl);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ffm);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eZK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ffn);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbo);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ffo);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ffp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ffq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ffr);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.ffs != null) {
        i = this.ffs.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fft);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbM);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(43722);
      return localObject;
      i = -1;
      break;
      i = -1;
      break label202;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43723);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ffg);
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
    ((StringBuffer)localObject).append("PkgSize:").append(this.ffh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLaunchSync:").append(this.ffi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsContactSync:").append(this.ffj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.eJb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasDownloadCode:").append(this.ffk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFirstDownload:").append(this.ffl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchType:").append(this.ffm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.eZK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NonUICostTimeMs:").append(this.ffn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.fbo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("launchReadyT:").append(this.ffo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("packageReadyT:").append(this.ffp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UIReadyT:").append(this.ffq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("requestType:").append(this.ffr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCheckJsApiInfoSync:").append(this.ffs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkJsApiInfoReadyT:").append(this.fft);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.fbM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43723);
    return localObject;
  }
  
  public final mx ajm()
  {
    AppMethodBeat.i(43720);
    this.fae = Util.nowMilliSecond();
    super.bj("EndTimeStampMs", this.fae);
    AppMethodBeat.o(43720);
    return this;
  }
  
  public final int getId()
  {
    return 15766;
  }
  
  public final mx xl(long paramLong)
  {
    AppMethodBeat.i(43718);
    this.fac = paramLong;
    super.bi("CostTimeMs", this.fac);
    AppMethodBeat.o(43718);
    return this;
  }
  
  public final mx xm(long paramLong)
  {
    AppMethodBeat.i(43719);
    this.fad = paramLong;
    super.bj("StartTimeStampMs", this.fad);
    AppMethodBeat.o(43719);
    return this;
  }
  
  public final mx xn(long paramLong)
  {
    AppMethodBeat.i(43721);
    this.ffn = paramLong;
    super.bi("NonUICostTimeMs", this.ffn);
    AppMethodBeat.o(43721);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43711);
      ffu = new a("release", 0, 1);
      ffv = new a("debug", 1, 2);
      ffw = new a("demo", 2, 3);
      ffx = new a[] { ffu, ffv, ffw };
      AppMethodBeat.o(43711);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a mJ(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ffu;
      case 2: 
        return ffv;
      }
      return ffw;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43714);
      ffy = new b("sync", 0, 0);
      ffz = new b("unsync", 1, 1);
      ffA = new b[] { ffy, ffz };
      AppMethodBeat.o(43714);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum c
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43717);
      ffB = new c("sync", 0, 0);
      ffC = new c("unsync", 1, 1);
      ffD = new c[] { ffB, ffC };
      AppMethodBeat.o(43717);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum d
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(226104);
      ffE = new d("sync", 0, 0);
      ffF = new d("unsync", 1, 1);
      ffG = new d[] { ffE, ffF };
      AppMethodBeat.o(226104);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.mx
 * JD-Core Version:    0.7.0.1
 */