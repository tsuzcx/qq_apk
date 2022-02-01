package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class tr
  extends a
{
  private String ilM = "";
  private String imT = "";
  public long ind = 0L;
  public long iqr = 0L;
  public long ixD = 0L;
  public a jEG;
  public long jEH = 0L;
  private String jEI = "";
  public long jax = 0L;
  private long jyH = 0L;
  private long jyI = 0L;
  public long jyJ = 0L;
  public long jyp = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(43740);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ind);
    ((StringBuffer)localObject).append(",");
    if (this.jEG != null) {}
    for (int i = this.jEG.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jax);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iqr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ixD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jEH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jEI);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(43740);
      return localObject;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43741);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.ind);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.jEG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.jax);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.jyH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.jyI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.jyJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.jyp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.ixD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.jEH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersionStr:").append(this.jEI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43741);
    return localObject;
  }
  
  public final tr aJj()
  {
    AppMethodBeat.i(43738);
    this.jyJ = Util.nowMilliSecond();
    super.by("EndTimeStampMs", this.jyJ);
    AppMethodBeat.o(43738);
    return this;
  }
  
  public final tr gF(long paramLong)
  {
    AppMethodBeat.i(43736);
    this.jyH = paramLong;
    super.bw("CostTimeMs", this.jyH);
    AppMethodBeat.o(43736);
    return this;
  }
  
  public final tr gG(long paramLong)
  {
    AppMethodBeat.i(43737);
    this.jyI = paramLong;
    super.by("StartTimeStampMs", this.jyI);
    AppMethodBeat.o(43737);
    return this;
  }
  
  public final int getId()
  {
    return 15813;
  }
  
  public final tr zX(String paramString)
  {
    AppMethodBeat.i(43734);
    this.ilM = F("InstanceId", paramString, true);
    AppMethodBeat.o(43734);
    return this;
  }
  
  public final tr zY(String paramString)
  {
    AppMethodBeat.i(43735);
    this.imT = F("AppId", paramString, true);
    AppMethodBeat.o(43735);
    return this;
  }
  
  public final tr zZ(String paramString)
  {
    AppMethodBeat.i(43739);
    this.jEI = F("engineVersionStr", paramString, true);
    AppMethodBeat.o(43739);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43733);
      jEJ = new a("release", 0, 1);
      jEK = new a("debug", 1, 2);
      jEL = new a("demo", 2, 3);
      jEM = new a[] { jEJ, jEK, jEL };
      AppMethodBeat.o(43733);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a ph(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return jEJ;
      case 2: 
        return jEK;
      }
      return jEL;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.tr
 * JD-Core Version:    0.7.0.1
 */