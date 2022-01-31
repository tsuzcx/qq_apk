package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class cl
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
  public long dau = 0L;
  public long dav = 0L;
  public long dbp = 0L;
  private String dbq = "";
  public cl.a dbv;
  public long dbw = 0L;
  public long dbx = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(128756);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dar);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZB);
    ((StringBuffer)localObject).append(",");
    if (this.dbv != null) {}
    for (int i = this.dbv.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.dbw);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dbq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dbx);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(128756);
      return localObject;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128757);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dar);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.cZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.cZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.dbv);
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
    ((StringBuffer)localObject).append("isPreloadPageFrame:").append(this.dbw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkTypeStr:").append(this.dbq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSplitCodeLib:").append(this.dbx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(128757);
    return localObject;
  }
  
  public final cl Hc()
  {
    AppMethodBeat.i(128753);
    this.dav = bo.aoy();
    super.az("EndTimeStampMs", this.dav);
    AppMethodBeat.o(128753);
    return this;
  }
  
  public final cl eW(long paramLong)
  {
    AppMethodBeat.i(128751);
    this.dat = paramLong;
    super.ay("CostTimeMs", this.dat);
    AppMethodBeat.o(128751);
    return this;
  }
  
  public final cl eX(long paramLong)
  {
    AppMethodBeat.i(128752);
    this.dau = paramLong;
    super.az("StartTimeStampMs", this.dau);
    AppMethodBeat.o(128752);
    return this;
  }
  
  public final int getId()
  {
    return 16009;
  }
  
  public final cl hA(String paramString)
  {
    AppMethodBeat.i(128755);
    this.dbq = t("networkTypeStr", paramString, true);
    AppMethodBeat.o(128755);
    return this;
  }
  
  public final cl hx(String paramString)
  {
    AppMethodBeat.i(128749);
    this.dar = t("InstanceId", paramString, true);
    AppMethodBeat.o(128749);
    return this;
  }
  
  public final cl hy(String paramString)
  {
    AppMethodBeat.i(128750);
    this.cZA = t("AppId", paramString, true);
    AppMethodBeat.o(128750);
    return this;
  }
  
  public final cl hz(String paramString)
  {
    AppMethodBeat.i(128754);
    this.bKZ = t("path", paramString, true);
    AppMethodBeat.o(128754);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cl
 * JD-Core Version:    0.7.0.1
 */