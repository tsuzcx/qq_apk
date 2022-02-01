package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class tu
  extends a
{
  public String imT = "";
  private long jEX = 0L;
  public long jEY = 0L;
  public long jEZ = 2L;
  private long jFa = 3L;
  public String jFb = "";
  public String jFc = "";
  public long jFd = 0L;
  public long jax = 0L;
  public String jjU = "";
  public String jxO = "";
  public long jxP = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(43761);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jax);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jEX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jEY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jEZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFd);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(43761);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43762);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.jax);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTimeMs:").append(this.jEX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PagePath:").append(this.jxO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoUrl:").append(this.jjU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventId:").append(this.jxP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeviceCount:").append(this.jEY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CastResult:").append(this.jEZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProtocolType:").append(this.jFa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ModelName:").append(this.jFb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ManuFacturer:").append(this.jFc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoState:").append(this.jFd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43762);
    return localObject;
  }
  
  public final tu gJ(long paramLong)
  {
    AppMethodBeat.i(43756);
    this.jEX = paramLong;
    super.bw("EventTimeMs", this.jEX);
    AppMethodBeat.o(43756);
    return this;
  }
  
  public final int getId()
  {
    return 18144;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.tu
 * JD-Core Version:    0.7.0.1
 */