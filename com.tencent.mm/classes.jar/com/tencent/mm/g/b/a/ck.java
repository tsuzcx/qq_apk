package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class ck
  extends a
{
  private String bKZ = "";
  public long cRG = 0L;
  private String cZA = "";
  public long cZB = 0L;
  public long cZD = 0L;
  public long daa = 0L;
  public long dad = 0L;
  private String dar = "";
  private long dat = 0L;
  private long dau = 0L;
  public long dav = 0L;
  public ck.a dbo;
  public long dbp = 0L;
  private String dbq = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(128744);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dar);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZB);
    ((StringBuffer)localObject).append(",");
    if (this.dbo != null) {}
    for (int i = this.dbo.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.bKZ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dad);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dbp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.daa);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dbq);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(128744);
      return localObject;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128745);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dar);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.cZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.cZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.dbo);
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
    ((StringBuffer)localObject).append("path:").append(this.bKZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.dad);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPatch:").append(this.dbp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.daa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkTypeStr:").append(this.dbq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(128745);
    return localObject;
  }
  
  public final ck Hb()
  {
    AppMethodBeat.i(128741);
    this.dav = bo.aoy();
    super.az("EndTimeStampMs", this.dav);
    AppMethodBeat.o(128741);
    return this;
  }
  
  public final ck eU(long paramLong)
  {
    AppMethodBeat.i(128739);
    this.dat = paramLong;
    super.ay("CostTimeMs", this.dat);
    AppMethodBeat.o(128739);
    return this;
  }
  
  public final ck eV(long paramLong)
  {
    AppMethodBeat.i(128740);
    this.dau = paramLong;
    super.az("StartTimeStampMs", this.dau);
    AppMethodBeat.o(128740);
    return this;
  }
  
  public final int getId()
  {
    return 16010;
  }
  
  public final ck ht(String paramString)
  {
    AppMethodBeat.i(128737);
    this.dar = t("InstanceId", paramString, true);
    AppMethodBeat.o(128737);
    return this;
  }
  
  public final ck hu(String paramString)
  {
    AppMethodBeat.i(128738);
    this.cZA = t("AppId", paramString, true);
    AppMethodBeat.o(128738);
    return this;
  }
  
  public final ck hv(String paramString)
  {
    AppMethodBeat.i(128742);
    this.bKZ = t("path", paramString, true);
    AppMethodBeat.o(128742);
    return this;
  }
  
  public final ck hw(String paramString)
  {
    AppMethodBeat.i(128743);
    this.dbq = t("networkTypeStr", paramString, true);
    AppMethodBeat.o(128743);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ck
 * JD-Core Version:    0.7.0.1
 */