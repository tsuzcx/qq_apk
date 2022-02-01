package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class fo
  extends a
{
  public long dKe = 0L;
  public long dYT = 0L;
  public String dYa = "";
  public String eaK = "";
  public long eaX = 0L;
  public String eag = "";
  public long eai = 0L;
  public long eba = 0L;
  private long ebp = 0L;
  public long ebq = 0L;
  public long ebr = 0L;
  public long ecA = 0L;
  public long ecB = 0L;
  public long ecC = 0L;
  public long ecS;
  public a ecX;
  public String ecY;
  public long ecZ;
  public long ecj = 0L;
  public String ecr = "";
  public long ecs = 0L;
  public long ect = 0L;
  public long ecu;
  
  public final String PV()
  {
    AppMethodBeat.i(43589);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.ecX != null) {}
    for (int i = this.ecX.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eai);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dKe);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eba);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecs);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eaX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eaK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecB);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ect);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecC);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecj);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecY);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecZ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecu);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecS);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43589);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43590);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ecX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eai);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.ebp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.ebq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.ebr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("path:").append(this.ecr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.eba);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPatch:").append(this.ecs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.eaX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadPageFrame:").append(this.ecA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.eaK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSplitCodeLib:").append(this.ecB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.ect);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isFirstPageRenderingCacheAccepted:").append(this.ecC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showAd:").append(this.ecj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("libVersion:").append(this.ecY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("canShowLoadingAdvert:").append(this.ecZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LoadingInEndT:").append(this.ecu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.ecS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43590);
    return localObject;
  }
  
  public final fo Sb()
  {
    AppMethodBeat.i(43588);
    this.ebr = bt.eGO();
    super.bb("EndTimeStampMs", this.ebr);
    AppMethodBeat.o(43588);
    return this;
  }
  
  public final int getId()
  {
    return 16009;
  }
  
  public final fo iy(long paramLong)
  {
    AppMethodBeat.i(43586);
    this.ebp = paramLong;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(43586);
    return this;
  }
  
  public final fo iz(long paramLong)
  {
    AppMethodBeat.i(43587);
    this.ebq = paramLong;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(43587);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43585);
      eda = new a("release", 0, 1);
      edb = new a("debug", 1, 2);
      edc = new a("demo", 2, 3);
      edd = new a[] { eda, edb, edc };
      AppMethodBeat.o(43585);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iW(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eda;
      case 2: 
        return edb;
      }
      return edc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fo
 * JD-Core Version:    0.7.0.1
 */