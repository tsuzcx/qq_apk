package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qb
  extends a
{
  private String gRy = "";
  private long gYN = 0L;
  private String gmF = "";
  private String hca = "";
  private long hcb = 0L;
  private long hje = 0L;
  private long hjf = 0L;
  private long hjg = 2L;
  private long hjh = 3L;
  private String hji = "";
  private String hjj = "";
  private long hjk = 0L;
  
  public final qb DA(long paramLong)
  {
    this.hcb = paramLong;
    return this;
  }
  
  public final qb DB(long paramLong)
  {
    this.hjf = paramLong;
    return this;
  }
  
  public final qb DC(long paramLong)
  {
    this.hjg = paramLong;
    return this;
  }
  
  public final qb DD(long paramLong)
  {
    this.hjk = paramLong;
    return this;
  }
  
  public final qb Dy(long paramLong)
  {
    this.gYN = paramLong;
    return this;
  }
  
  public final qb Dz(long paramLong)
  {
    AppMethodBeat.i(43756);
    this.hje = paramLong;
    super.bk("EventTimeMs", this.hje);
    AppMethodBeat.o(43756);
    return this;
  }
  
  public final qb GW(String paramString)
  {
    AppMethodBeat.i(43755);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(43755);
    return this;
  }
  
  public final qb GX(String paramString)
  {
    AppMethodBeat.i(43757);
    this.hca = z("PagePath", paramString, true);
    AppMethodBeat.o(43757);
    return this;
  }
  
  public final qb GY(String paramString)
  {
    AppMethodBeat.i(43758);
    this.gRy = z("VideoUrl", paramString, true);
    AppMethodBeat.o(43758);
    return this;
  }
  
  public final qb GZ(String paramString)
  {
    AppMethodBeat.i(43759);
    this.hji = z("ModelName", paramString, true);
    AppMethodBeat.o(43759);
    return this;
  }
  
  public final qb Ha(String paramString)
  {
    AppMethodBeat.i(43760);
    this.hjj = z("ManuFacturer", paramString, true);
    AppMethodBeat.o(43760);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(43761);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hje);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hca);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hcb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hji);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjk);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(43761);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43762);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.gYN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTimeMs:").append(this.hje);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PagePath:").append(this.hca);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoUrl:").append(this.gRy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventId:").append(this.hcb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeviceCount:").append(this.hjf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CastResult:").append(this.hjg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProtocolType:").append(this.hjh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ModelName:").append(this.hji);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ManuFacturer:").append(this.hjj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoState:").append(this.hjk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43762);
    return localObject;
  }
  
  public final String getAppId()
  {
    return this.gmF;
  }
  
  public final int getId()
  {
    return 18144;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.qb
 * JD-Core Version:    0.7.0.1
 */