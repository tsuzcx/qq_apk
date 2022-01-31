package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class cj
  extends a
{
  public long cRG = 0L;
  private String cZA = "";
  public long cZB = 0L;
  public long cZD = 0L;
  private String dar = "";
  private long dat = 0L;
  private long dau = 0L;
  public long dav = 0L;
  public cj.a dbh;
  public long dbi = 0L;
  private String dbj = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(128732);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dar);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZB);
    ((StringBuffer)localObject).append(",");
    if (this.dbh != null) {}
    for (int i = this.dbh.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.dbi);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dbj);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(128732);
      return localObject;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128733);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dar);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.cZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.cZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.dbh);
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
    ((StringBuffer)localObject).append("fileSize:").append(this.dbi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filePath:").append(this.dbj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(128733);
    return localObject;
  }
  
  public final cj Ha()
  {
    AppMethodBeat.i(128730);
    this.dav = bo.aoy();
    super.az("EndTimeStampMs", this.dav);
    AppMethodBeat.o(128730);
    return this;
  }
  
  public final cj eS(long paramLong)
  {
    AppMethodBeat.i(128728);
    this.dat = paramLong;
    super.ay("CostTimeMs", this.dat);
    AppMethodBeat.o(128728);
    return this;
  }
  
  public final cj eT(long paramLong)
  {
    AppMethodBeat.i(128729);
    this.dau = paramLong;
    super.az("StartTimeStampMs", this.dau);
    AppMethodBeat.o(128729);
    return this;
  }
  
  public final int getId()
  {
    return 16007;
  }
  
  public final cj hq(String paramString)
  {
    AppMethodBeat.i(128726);
    this.dar = t("InstanceId", paramString, true);
    AppMethodBeat.o(128726);
    return this;
  }
  
  public final cj hr(String paramString)
  {
    AppMethodBeat.i(128727);
    this.cZA = t("AppId", paramString, true);
    AppMethodBeat.o(128727);
    return this;
  }
  
  public final cj hs(String paramString)
  {
    AppMethodBeat.i(128731);
    this.dbj = t("filePath", paramString, true);
    AppMethodBeat.o(128731);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cj
 * JD-Core Version:    0.7.0.1
 */