package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class cw
  extends a
{
  private String bKZ = "";
  public long cRG = 0L;
  private String cZA = "";
  public long cZB = 0L;
  public long cZD = 0L;
  public long daa = 0L;
  private String dar = "";
  private long dat = 0L;
  private long dau = 0L;
  public long dav = 0L;
  private String dbq = "";
  public long dbw = 0L;
  public cw.a ddE;
  
  public final String Ff()
  {
    AppMethodBeat.i(128893);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dar);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZB);
    ((StringBuffer)localObject).append(",");
    if (this.ddE != null) {}
    for (int i = this.ddE.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.daa);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dbw);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dbq);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(128893);
      return localObject;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128894);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dar);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.cZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.cZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ddE);
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
    ((StringBuffer)localObject).append("isPreload:").append(this.daa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadPageFrame:").append(this.dbw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkTypeStr:").append(this.dbq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(128894);
    return localObject;
  }
  
  public final cw Hj()
  {
    AppMethodBeat.i(128890);
    this.dav = bo.aoy();
    super.az("EndTimeStampMs", this.dav);
    AppMethodBeat.o(128890);
    return this;
  }
  
  public final cw fA(long paramLong)
  {
    AppMethodBeat.i(128889);
    this.dau = paramLong;
    super.az("StartTimeStampMs", this.dau);
    AppMethodBeat.o(128889);
    return this;
  }
  
  public final cw fz(long paramLong)
  {
    AppMethodBeat.i(128888);
    this.dat = paramLong;
    super.ay("CostTimeMs", this.dat);
    AppMethodBeat.o(128888);
    return this;
  }
  
  public final int getId()
  {
    return 16011;
  }
  
  public final cw ia(String paramString)
  {
    AppMethodBeat.i(128886);
    this.dar = t("InstanceId", paramString, true);
    AppMethodBeat.o(128886);
    return this;
  }
  
  public final cw ib(String paramString)
  {
    AppMethodBeat.i(128887);
    this.cZA = t("AppId", paramString, true);
    AppMethodBeat.o(128887);
    return this;
  }
  
  public final cw ic(String paramString)
  {
    AppMethodBeat.i(128891);
    this.bKZ = t("path", paramString, true);
    AppMethodBeat.o(128891);
    return this;
  }
  
  public final cw ie(String paramString)
  {
    AppMethodBeat.i(128892);
    this.dbq = t("networkTypeStr", paramString, true);
    AppMethodBeat.o(128892);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cw
 * JD-Core Version:    0.7.0.1
 */