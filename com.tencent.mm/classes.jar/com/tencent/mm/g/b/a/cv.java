package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class cv
  extends a
{
  public long cRG = 0L;
  public long cYC = 0L;
  private String cZA = "";
  public long cZB = 0L;
  public long cZD = 0L;
  public long daa = 0L;
  private String dar = "";
  private long dat = 0L;
  private long dau = 0L;
  public long dav = 0L;
  public cv.a ddz;
  
  public final String Ff()
  {
    AppMethodBeat.i(128881);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dar);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZB);
    ((StringBuffer)localObject).append(",");
    if (this.ddz != null) {}
    for (int i = this.ddz.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.daa);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cYC);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(128881);
      return localObject;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128882);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dar);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.cZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.cZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ddz);
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
    ((StringBuffer)localObject).append("isPreload:").append(this.daa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.cYC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(128882);
    return localObject;
  }
  
  public final cv Hi()
  {
    AppMethodBeat.i(128880);
    this.dav = bo.aoy();
    super.az("EndTimeStampMs", this.dav);
    AppMethodBeat.o(128880);
    return this;
  }
  
  public final cv fx(long paramLong)
  {
    AppMethodBeat.i(128878);
    this.dat = paramLong;
    super.ay("CostTimeMs", this.dat);
    AppMethodBeat.o(128878);
    return this;
  }
  
  public final cv fy(long paramLong)
  {
    AppMethodBeat.i(128879);
    this.dau = paramLong;
    super.az("StartTimeStampMs", this.dau);
    AppMethodBeat.o(128879);
    return this;
  }
  
  public final int getId()
  {
    return 15813;
  }
  
  public final cv hY(String paramString)
  {
    AppMethodBeat.i(128876);
    this.dar = t("InstanceId", paramString, true);
    AppMethodBeat.o(128876);
    return this;
  }
  
  public final cv hZ(String paramString)
  {
    AppMethodBeat.i(128877);
    this.cZA = t("AppId", paramString, true);
    AppMethodBeat.o(128877);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cv
 * JD-Core Version:    0.7.0.1
 */