package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gi
  extends a
{
  private String dTK = "";
  private String eag = "";
  private long eai = 0L;
  private String eav = "";
  private long eaw = 0L;
  private long egN = 0L;
  private long egO = 0L;
  private long egP = 2L;
  private long egQ = 3L;
  private String egR = "";
  private String egS = "";
  private long egT = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(43761);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eai);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eav);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egT);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(43761);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43762);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eai);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTimeMs:").append(this.egN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PagePath:").append(this.eav);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoUrl:").append(this.dTK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventId:").append(this.eaw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeviceCount:").append(this.egO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CastResult:").append(this.egP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProtocolType:").append(this.egQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ModelName:").append(this.egR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ManuFacturer:").append(this.egS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoState:").append(this.egT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43762);
    return localObject;
  }
  
  public final String getAppId()
  {
    return this.eag;
  }
  
  public final int getId()
  {
    return 18144;
  }
  
  public final gi ka(long paramLong)
  {
    this.eai = paramLong;
    return this;
  }
  
  public final gi kb(long paramLong)
  {
    AppMethodBeat.i(43756);
    this.egN = paramLong;
    super.ba("EventTimeMs", this.egN);
    AppMethodBeat.o(43756);
    return this;
  }
  
  public final gi kc(long paramLong)
  {
    this.eaw = paramLong;
    return this;
  }
  
  public final gi kd(long paramLong)
  {
    this.egO = paramLong;
    return this;
  }
  
  public final gi ke(long paramLong)
  {
    this.egP = paramLong;
    return this;
  }
  
  public final gi kf(long paramLong)
  {
    this.egT = paramLong;
    return this;
  }
  
  public final gi lW(String paramString)
  {
    AppMethodBeat.i(43755);
    this.eag = t("AppId", paramString, true);
    AppMethodBeat.o(43755);
    return this;
  }
  
  public final gi lX(String paramString)
  {
    AppMethodBeat.i(43757);
    this.eav = t("PagePath", paramString, true);
    AppMethodBeat.o(43757);
    return this;
  }
  
  public final gi lY(String paramString)
  {
    AppMethodBeat.i(43758);
    this.dTK = t("VideoUrl", paramString, true);
    AppMethodBeat.o(43758);
    return this;
  }
  
  public final gi lZ(String paramString)
  {
    AppMethodBeat.i(43759);
    this.egR = t("ModelName", paramString, true);
    AppMethodBeat.o(43759);
    return this;
  }
  
  public final gi ma(String paramString)
  {
    AppMethodBeat.i(43760);
    this.egS = t("ManuFacturer", paramString, true);
    AppMethodBeat.o(43760);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gi
 * JD-Core Version:    0.7.0.1
 */