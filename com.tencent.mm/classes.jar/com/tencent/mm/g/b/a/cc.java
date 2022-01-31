package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cc
  extends a
{
  public long cRG = 0L;
  private String cZA = "";
  public long cZB = 0L;
  public long cZD = 0L;
  private String dar = "";
  public cc.a das;
  private long dat = 0L;
  public long dau = 0L;
  public long dav = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(128664);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dar);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZB);
    ((StringBuffer)localObject).append(",");
    if (this.das != null) {}
    for (int i = this.das.value;; i = -1)
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
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(128664);
      return localObject;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128665);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dar);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.cZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.cZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.das);
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
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(128665);
    return localObject;
  }
  
  public final cc eC(long paramLong)
  {
    AppMethodBeat.i(128661);
    this.dat = paramLong;
    super.ay("CostTimeMs", this.dat);
    AppMethodBeat.o(128661);
    return this;
  }
  
  public final cc eD(long paramLong)
  {
    AppMethodBeat.i(128662);
    this.dau = paramLong;
    super.az("StartTimeStampMs", this.dau);
    AppMethodBeat.o(128662);
    return this;
  }
  
  public final cc eE(long paramLong)
  {
    AppMethodBeat.i(128663);
    this.dav = paramLong;
    super.az("EndTimeStampMs", this.dav);
    AppMethodBeat.o(128663);
    return this;
  }
  
  public final int getId()
  {
    return 16900;
  }
  
  public final cc hc(String paramString)
  {
    AppMethodBeat.i(128659);
    this.dar = t("InstanceId", paramString, true);
    AppMethodBeat.o(128659);
    return this;
  }
  
  public final cc hd(String paramString)
  {
    AppMethodBeat.i(128660);
    this.cZA = t("AppId", paramString, true);
    AppMethodBeat.o(128660);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cc
 * JD-Core Version:    0.7.0.1
 */