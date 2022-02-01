package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class fn
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
  private long ebq = 0L;
  public long ebr = 0L;
  public a ecR;
  public long ecS;
  public String ecr = "";
  public long ecs = 0L;
  public long ect = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(43581);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.ecR != null) {}
    for (int i = this.ecR.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.eaK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ect);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecS);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43581);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43582);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ecR);
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
    ((StringBuffer)localObject).append("networkType:").append(this.eaK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.ect);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.ecS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43582);
    return localObject;
  }
  
  public final fn Sa()
  {
    AppMethodBeat.i(43580);
    this.ebr = bt.eGO();
    super.bb("EndTimeStampMs", this.ebr);
    AppMethodBeat.o(43580);
    return this;
  }
  
  public final int getId()
  {
    return 16010;
  }
  
  public final fn iw(long paramLong)
  {
    AppMethodBeat.i(43578);
    this.ebp = paramLong;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(43578);
    return this;
  }
  
  public final fn ix(long paramLong)
  {
    AppMethodBeat.i(43579);
    this.ebq = paramLong;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(43579);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43577);
      ecT = new a("release", 0, 1);
      ecU = new a("debug", 1, 2);
      ecV = new a("demo", 2, 3);
      ecW = new a[] { ecT, ecU, ecV };
      AppMethodBeat.o(43577);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iV(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ecT;
      case 2: 
        return ecU;
      }
      return ecV;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fn
 * JD-Core Version:    0.7.0.1
 */