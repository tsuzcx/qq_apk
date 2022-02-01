package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class mz
  extends a
{
  private String eJx = "";
  private String eWb = "";
  public long eXc = 0L;
  public long eYW = 0L;
  public long eZK = 0L;
  public long erW = 0L;
  public long evl = 0L;
  private long fac = 0L;
  private long fad = 0L;
  public long fae = 0L;
  public a ffI;
  public long ffJ = 0L;
  private String ffK = "";
  
  public final mz Ai(String paramString)
  {
    AppMethodBeat.i(43734);
    this.eWb = x("InstanceId", paramString, true);
    AppMethodBeat.o(43734);
    return this;
  }
  
  public final mz Aj(String paramString)
  {
    AppMethodBeat.i(43735);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(43735);
    return this;
  }
  
  public final mz Ak(String paramString)
  {
    AppMethodBeat.i(43739);
    this.ffK = x("engineVersionStr", paramString, true);
    AppMethodBeat.o(43739);
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(43740);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.ffI != null) {}
    for (int i = this.ffI.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.eZK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evl);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ffJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ffK);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(43740);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43741);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ffI);
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
    ((StringBuffer)localObject).append("isPreload:").append(this.eZK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.evl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.ffJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersionStr:").append(this.ffK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43741);
    return localObject;
  }
  
  public final mz ajn()
  {
    AppMethodBeat.i(43738);
    this.fae = Util.nowMilliSecond();
    super.bj("EndTimeStampMs", this.fae);
    AppMethodBeat.o(43738);
    return this;
  }
  
  public final int getId()
  {
    return 15813;
  }
  
  public final mz xu(long paramLong)
  {
    AppMethodBeat.i(43736);
    this.fac = paramLong;
    super.bi("CostTimeMs", this.fac);
    AppMethodBeat.o(43736);
    return this;
  }
  
  public final mz xv(long paramLong)
  {
    AppMethodBeat.i(43737);
    this.fad = paramLong;
    super.bj("StartTimeStampMs", this.fad);
    AppMethodBeat.o(43737);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43733);
      ffL = new a("release", 0, 1);
      ffM = new a("debug", 1, 2);
      ffN = new a("demo", 2, 3);
      ffO = new a[] { ffL, ffM, ffN };
      AppMethodBeat.o(43733);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a mL(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ffL;
      case 2: 
        return ffM;
      }
      return ffN;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.mz
 * JD-Core Version:    0.7.0.1
 */