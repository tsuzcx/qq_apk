package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ia
  extends a
{
  private String dVw = "";
  private String ecB = "";
  private long ecC = 0L;
  private String ecm = "";
  private long eco = 0L;
  private long eiT = 0L;
  private long eiU = 0L;
  private long eiV = 2L;
  private long eiW = 3L;
  private String eiX = "";
  private String eiY = "";
  private long eiZ = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(43761);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eco);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiZ);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(43761);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43762);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eco);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTimeMs:").append(this.eiT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PagePath:").append(this.ecB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoUrl:").append(this.dVw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventId:").append(this.ecC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeviceCount:").append(this.eiU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CastResult:").append(this.eiV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProtocolType:").append(this.eiW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ModelName:").append(this.eiX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ManuFacturer:").append(this.eiY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoState:").append(this.eiZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43762);
    return localObject;
  }
  
  public final String getAppId()
  {
    return this.ecm;
  }
  
  public final int getId()
  {
    return 18144;
  }
  
  public final ia nC(long paramLong)
  {
    this.eco = paramLong;
    return this;
  }
  
  public final ia nD(long paramLong)
  {
    AppMethodBeat.i(43756);
    this.eiT = paramLong;
    super.bc("EventTimeMs", this.eiT);
    AppMethodBeat.o(43756);
    return this;
  }
  
  public final ia nE(long paramLong)
  {
    this.ecC = paramLong;
    return this;
  }
  
  public final ia nF(long paramLong)
  {
    this.eiU = paramLong;
    return this;
  }
  
  public final ia nG(long paramLong)
  {
    this.eiV = paramLong;
    return this;
  }
  
  public final ia nH(long paramLong)
  {
    this.eiZ = paramLong;
    return this;
  }
  
  public final ia pb(String paramString)
  {
    AppMethodBeat.i(43755);
    this.ecm = t("AppId", paramString, true);
    AppMethodBeat.o(43755);
    return this;
  }
  
  public final ia pc(String paramString)
  {
    AppMethodBeat.i(43757);
    this.ecB = t("PagePath", paramString, true);
    AppMethodBeat.o(43757);
    return this;
  }
  
  public final ia pd(String paramString)
  {
    AppMethodBeat.i(43758);
    this.dVw = t("VideoUrl", paramString, true);
    AppMethodBeat.o(43758);
    return this;
  }
  
  public final ia pe(String paramString)
  {
    AppMethodBeat.i(43759);
    this.eiX = t("ModelName", paramString, true);
    AppMethodBeat.o(43759);
    return this;
  }
  
  public final ia pf(String paramString)
  {
    AppMethodBeat.i(43760);
    this.eiY = t("ManuFacturer", paramString, true);
    AppMethodBeat.o(43760);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ia
 * JD-Core Version:    0.7.0.1
 */