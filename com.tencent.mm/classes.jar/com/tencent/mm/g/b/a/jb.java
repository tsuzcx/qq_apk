package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class jb
  extends a
{
  public long dWt = 0L;
  public a eAJ;
  public long eAK = 0L;
  public c eAL;
  public b eAM;
  public long eAN = 0L;
  private long eAO = 0L;
  private long eAP = 0L;
  private long eAQ = 0L;
  public long eAR;
  public long eAS;
  public long eAT;
  public long eAU;
  public d eAV;
  public long eAW;
  public long ehL = 0L;
  public String esa = "";
  public long etb = 0L;
  public long euA = 0L;
  public String euy = "";
  private long evH = 0L;
  public long evI = 0L;
  public long evJ = 0L;
  public long evp = 0L;
  public long ewT = 0L;
  public long exr;
  
  public final String RC()
  {
    int j = -1;
    AppMethodBeat.i(43722);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.eAJ != null)
    {
      i = this.eAJ.value;
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
      ((StringBuffer)localObject).append(this.eAK);
      ((StringBuffer)localObject).append(",");
      if (this.eAL == null) {
        break label497;
      }
      i = this.eAL.value;
      label202:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.eAM == null) {
        break label502;
      }
    }
    label497:
    label502:
    for (int i = this.eAM.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ehL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eAN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eAO);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eAP);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eAQ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eAR);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eAS);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eAT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eAU);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.eAV != null) {
        i = this.eAV.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eAW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exr);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(43722);
      return localObject;
      i = -1;
      break;
      i = -1;
      break label202;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43723);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eAJ);
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
    ((StringBuffer)localObject).append("PkgSize:").append(this.eAK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLaunchSync:").append(this.eAL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsContactSync:").append(this.eAM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.ehL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasDownloadCode:").append(this.eAN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFirstDownload:").append(this.eAO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchType:").append(this.eAP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.evp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NonUICostTimeMs:").append(this.eAQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.ewT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("launchReadyT:").append(this.eAR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("packageReadyT:").append(this.eAS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UIReadyT:").append(this.eAT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("requestType:").append(this.eAU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCheckJsApiInfoSync:").append(this.eAV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkJsApiInfoReadyT:").append(this.eAW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.exr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43723);
    return localObject;
  }
  
  public final jb Vw()
  {
    AppMethodBeat.i(43720);
    this.evJ = bu.fpO();
    super.bh("EndTimeStampMs", this.evJ);
    AppMethodBeat.o(43720);
    return this;
  }
  
  public final int getId()
  {
    return 15766;
  }
  
  public final jb pA(long paramLong)
  {
    AppMethodBeat.i(43718);
    this.evH = paramLong;
    super.bg("CostTimeMs", this.evH);
    AppMethodBeat.o(43718);
    return this;
  }
  
  public final jb pB(long paramLong)
  {
    AppMethodBeat.i(43719);
    this.evI = paramLong;
    super.bh("StartTimeStampMs", this.evI);
    AppMethodBeat.o(43719);
    return this;
  }
  
  public final jb pC(long paramLong)
  {
    AppMethodBeat.i(43721);
    this.eAQ = paramLong;
    super.bg("NonUICostTimeMs", this.eAQ);
    AppMethodBeat.o(43721);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43711);
      eAX = new a("release", 0, 1);
      eAY = new a("debug", 1, 2);
      eAZ = new a("demo", 2, 3);
      eBa = new a[] { eAX, eAY, eAZ };
      AppMethodBeat.o(43711);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jH(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eAX;
      case 2: 
        return eAY;
      }
      return eAZ;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43714);
      eBb = new b("sync", 0, 0);
      eBc = new b("unsync", 1, 1);
      eBd = new b[] { eBb, eBc };
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
      eBe = new c("sync", 0, 0);
      eBf = new c("unsync", 1, 1);
      eBg = new c[] { eBe, eBf };
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
      AppMethodBeat.i(221968);
      eBh = new d("sync", 0, 0);
      eBi = new d("unsync", 1, 1);
      eBj = new d[] { eBh, eBi };
      AppMethodBeat.o(221968);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jb
 * JD-Core Version:    0.7.0.1
 */