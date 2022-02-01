package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jg
  extends a
{
  private long eBC = 0L;
  private long eBD = 0L;
  private long eBE = 2L;
  private long eBF = 3L;
  private String eBG = "";
  private String eBH = "";
  private long eBI = 0L;
  private String enw = "";
  private long euA = 0L;
  private String euN = "";
  private long euO = 0L;
  private String euy = "";
  
  public final String RC()
  {
    AppMethodBeat.i(43761);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBI);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(43761);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43762);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.euA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTimeMs:").append(this.eBC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PagePath:").append(this.euN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoUrl:").append(this.enw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventId:").append(this.euO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeviceCount:").append(this.eBD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CastResult:").append(this.eBE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProtocolType:").append(this.eBF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ModelName:").append(this.eBG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ManuFacturer:").append(this.eBH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoState:").append(this.eBI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43762);
    return localObject;
  }
  
  public final String getAppId()
  {
    return this.euy;
  }
  
  public final int getId()
  {
    return 18144;
  }
  
  public final jg pN(long paramLong)
  {
    this.euA = paramLong;
    return this;
  }
  
  public final jg pO(long paramLong)
  {
    AppMethodBeat.i(43756);
    this.eBC = paramLong;
    super.bg("EventTimeMs", this.eBC);
    AppMethodBeat.o(43756);
    return this;
  }
  
  public final jg pP(long paramLong)
  {
    this.euO = paramLong;
    return this;
  }
  
  public final jg pQ(long paramLong)
  {
    this.eBD = paramLong;
    return this;
  }
  
  public final jg pR(long paramLong)
  {
    this.eBE = paramLong;
    return this;
  }
  
  public final jg pS(long paramLong)
  {
    this.eBI = paramLong;
    return this;
  }
  
  public final jg sd(String paramString)
  {
    AppMethodBeat.i(43755);
    this.euy = t("AppId", paramString, true);
    AppMethodBeat.o(43755);
    return this;
  }
  
  public final jg se(String paramString)
  {
    AppMethodBeat.i(43757);
    this.euN = t("PagePath", paramString, true);
    AppMethodBeat.o(43757);
    return this;
  }
  
  public final jg sf(String paramString)
  {
    AppMethodBeat.i(43758);
    this.enw = t("VideoUrl", paramString, true);
    AppMethodBeat.o(43758);
    return this;
  }
  
  public final jg sg(String paramString)
  {
    AppMethodBeat.i(43759);
    this.eBG = t("ModelName", paramString, true);
    AppMethodBeat.o(43759);
    return this;
  }
  
  public final jg sh(String paramString)
  {
    AppMethodBeat.i(43760);
    this.eBH = t("ManuFacturer", paramString, true);
    AppMethodBeat.o(43760);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jg
 * JD-Core Version:    0.7.0.1
 */