package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nc
  extends a
{
  private String eJx = "";
  private String eRc = "";
  private long eYW = 0L;
  private String eZj = "";
  private long eZk = 0L;
  private long ffZ = 0L;
  private long fga = 0L;
  private long fgb = 2L;
  private long fgc = 3L;
  private String fgd = "";
  private String fge = "";
  private long fgf = 0L;
  
  public final nc Al(String paramString)
  {
    AppMethodBeat.i(43755);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(43755);
    return this;
  }
  
  public final nc Am(String paramString)
  {
    AppMethodBeat.i(43757);
    this.eZj = x("PagePath", paramString, true);
    AppMethodBeat.o(43757);
    return this;
  }
  
  public final nc An(String paramString)
  {
    AppMethodBeat.i(43758);
    this.eRc = x("VideoUrl", paramString, true);
    AppMethodBeat.o(43758);
    return this;
  }
  
  public final nc Ao(String paramString)
  {
    AppMethodBeat.i(43759);
    this.fgd = x("ModelName", paramString, true);
    AppMethodBeat.o(43759);
    return this;
  }
  
  public final nc Ap(String paramString)
  {
    AppMethodBeat.i(43760);
    this.fge = x("ManuFacturer", paramString, true);
    AppMethodBeat.o(43760);
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(43761);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ffZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eZj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eZk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fga);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fge);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgf);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(43761);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43762);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eYW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTimeMs:").append(this.ffZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PagePath:").append(this.eZj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoUrl:").append(this.eRc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventId:").append(this.eZk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeviceCount:").append(this.fga);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CastResult:").append(this.fgb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProtocolType:").append(this.fgc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ModelName:").append(this.fgd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ManuFacturer:").append(this.fge);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoState:").append(this.fgf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43762);
    return localObject;
  }
  
  public final String getAppId()
  {
    return this.eJx;
  }
  
  public final int getId()
  {
    return 18144;
  }
  
  public final nc xA(long paramLong)
  {
    this.eZk = paramLong;
    return this;
  }
  
  public final nc xB(long paramLong)
  {
    this.fga = paramLong;
    return this;
  }
  
  public final nc xC(long paramLong)
  {
    this.fgb = paramLong;
    return this;
  }
  
  public final nc xD(long paramLong)
  {
    this.fgf = paramLong;
    return this;
  }
  
  public final nc xy(long paramLong)
  {
    this.eYW = paramLong;
    return this;
  }
  
  public final nc xz(long paramLong)
  {
    AppMethodBeat.i(43756);
    this.ffZ = paramLong;
    super.bi("EventTimeMs", this.ffZ);
    AppMethodBeat.o(43756);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.nc
 * JD-Core Version:    0.7.0.1
 */