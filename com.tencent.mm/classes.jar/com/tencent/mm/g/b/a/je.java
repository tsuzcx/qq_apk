package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class je
  extends a
{
  private String elO = "";
  private String esR = "";
  private long esT = 0L;
  private String etg = "";
  private long eth = 0L;
  private long ezT = 0L;
  private long ezU = 0L;
  private long ezV = 2L;
  private long ezW = 3L;
  private String ezX = "";
  private String ezY = "";
  private long ezZ = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(43761);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eth);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezZ);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(43761);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43762);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.esT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTimeMs:").append(this.ezT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PagePath:").append(this.etg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoUrl:").append(this.elO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventId:").append(this.eth);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeviceCount:").append(this.ezU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CastResult:").append(this.ezV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProtocolType:").append(this.ezW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ModelName:").append(this.ezX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ManuFacturer:").append(this.ezY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoState:").append(this.ezZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43762);
    return localObject;
  }
  
  public final String getAppId()
  {
    return this.esR;
  }
  
  public final int getId()
  {
    return 18144;
  }
  
  public final je pA(long paramLong)
  {
    this.esT = paramLong;
    return this;
  }
  
  public final je pB(long paramLong)
  {
    AppMethodBeat.i(43756);
    this.ezT = paramLong;
    super.bf("EventTimeMs", this.ezT);
    AppMethodBeat.o(43756);
    return this;
  }
  
  public final je pC(long paramLong)
  {
    this.eth = paramLong;
    return this;
  }
  
  public final je pD(long paramLong)
  {
    this.ezU = paramLong;
    return this;
  }
  
  public final je pE(long paramLong)
  {
    this.ezV = paramLong;
    return this;
  }
  
  public final je pF(long paramLong)
  {
    this.ezZ = paramLong;
    return this;
  }
  
  public final je rI(String paramString)
  {
    AppMethodBeat.i(43755);
    this.esR = t("AppId", paramString, true);
    AppMethodBeat.o(43755);
    return this;
  }
  
  public final je rJ(String paramString)
  {
    AppMethodBeat.i(43757);
    this.etg = t("PagePath", paramString, true);
    AppMethodBeat.o(43757);
    return this;
  }
  
  public final je rK(String paramString)
  {
    AppMethodBeat.i(43758);
    this.elO = t("VideoUrl", paramString, true);
    AppMethodBeat.o(43758);
    return this;
  }
  
  public final je rL(String paramString)
  {
    AppMethodBeat.i(43759);
    this.ezX = t("ModelName", paramString, true);
    AppMethodBeat.o(43759);
    return this;
  }
  
  public final je rM(String paramString)
  {
    AppMethodBeat.i(43760);
    this.ezY = t("ManuFacturer", paramString, true);
    AppMethodBeat.o(43760);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.je
 * JD-Core Version:    0.7.0.1
 */