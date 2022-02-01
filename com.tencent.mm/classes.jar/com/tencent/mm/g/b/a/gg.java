package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class gg
  extends a
{
  public long dKe = 0L;
  public long dYT = 0L;
  public String dYa = "";
  public String eaK = "";
  public long eaX = 0L;
  public String eag = "";
  public long eai = 0L;
  private long ebp = 0L;
  public long ebq = 0L;
  public long ebr = 0L;
  public long ecA = 0L;
  public long ecC = 0L;
  public long ecS;
  public String ecr = "";
  public long ect = 0L;
  public a egD;
  
  public final String PV()
  {
    AppMethodBeat.i(43748);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.egD != null) {}
    for (int i = this.egD.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.eaX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eaK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ect);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecC);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecS);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43748);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43749);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.egD);
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
    ((StringBuffer)localObject).append("isPreload:").append(this.eaX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadPageFrame:").append(this.ecA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.eaK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.ect);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isFirstPageRenderingCacheAccepted:").append(this.ecC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.ecS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43749);
    return localObject;
  }
  
  public final gg Sk()
  {
    AppMethodBeat.i(43747);
    this.ebr = bt.eGO();
    super.bb("EndTimeStampMs", this.ebr);
    AppMethodBeat.o(43747);
    return this;
  }
  
  public final int getId()
  {
    return 16011;
  }
  
  public final gg jY(long paramLong)
  {
    AppMethodBeat.i(43745);
    this.ebp = paramLong;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(43745);
    return this;
  }
  
  public final gg jZ(long paramLong)
  {
    AppMethodBeat.i(43746);
    this.ebq = paramLong;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(43746);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43744);
      egE = new a("release", 0, 1);
      egF = new a("debug", 1, 2);
      egG = new a("demo", 2, 3);
      egH = new a[] { egE, egF, egG };
      AppMethodBeat.o(43744);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jn(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return egE;
      case 2: 
        return egF;
      }
      return egG;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gg
 * JD-Core Version:    0.7.0.1
 */