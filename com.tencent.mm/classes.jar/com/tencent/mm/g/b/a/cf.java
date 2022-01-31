package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cf
  extends a
{
  public long cRG = 0L;
  private String cZA = "";
  public long cZB = 0L;
  public long cZD = 0L;
  public cf.a daL;
  public long daM = 0L;
  private String dar = "";
  private long dat = 0L;
  public long dau = 0L;
  public long dav = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(128694);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dar);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZB);
    ((StringBuffer)localObject).append(",");
    if (this.daL != null) {}
    for (int i = this.daL.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cZD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dat);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cRG);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dau);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dav);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.daM);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(128694);
      return localObject;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128695);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dar);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.cZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.cZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.daL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.cZD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.dat);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.cRG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.dau);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.dav);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isFromAndroidRecents:").append(this.daM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(128695);
    return localObject;
  }
  
  public final cf eK(long paramLong)
  {
    AppMethodBeat.i(128691);
    this.dat = paramLong;
    super.ay("CostTimeMs", this.dat);
    AppMethodBeat.o(128691);
    return this;
  }
  
  public final cf eL(long paramLong)
  {
    AppMethodBeat.i(128692);
    this.dau = paramLong;
    super.az("StartTimeStampMs", this.dau);
    AppMethodBeat.o(128692);
    return this;
  }
  
  public final cf eM(long paramLong)
  {
    AppMethodBeat.i(128693);
    this.dav = paramLong;
    super.az("EndTimeStampMs", this.dav);
    AppMethodBeat.o(128693);
    return this;
  }
  
  public final int getId()
  {
    return 16898;
  }
  
  public final cf hi(String paramString)
  {
    AppMethodBeat.i(128689);
    this.dar = t("InstanceId", paramString, true);
    AppMethodBeat.o(128689);
    return this;
  }
  
  public final cf hj(String paramString)
  {
    AppMethodBeat.i(128690);
    this.cZA = t("AppId", paramString, true);
    AppMethodBeat.o(128690);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cf
 * JD-Core Version:    0.7.0.1
 */