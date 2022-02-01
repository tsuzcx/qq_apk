package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gw
  extends a
{
  private String dYc = "";
  private String ecB = "";
  private String erZ = "";
  private String esa = "";
  private long esb = 0L;
  private long esc = 0L;
  private long esd = 0L;
  private long ese = 0L;
  private long esf = 0L;
  private long esg = 0L;
  private long esh = 0L;
  private long esi = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(221920);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ese);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esi);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(221920);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(221921);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Appid:").append(this.erZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.dYc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenScene:").append(this.esb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppVersion:").append(this.esc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LocalAppVersion:").append(this.esd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdateResult:").append(this.ese);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdateCostTimeInMs:").append(this.esf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FallbackWaitTimeInMs:").append(this.esg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.ecB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsWeakNet:").append(this.esh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FallbackScene:").append(this.esi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(221921);
    return localObject;
  }
  
  public final int getId()
  {
    return 20579;
  }
  
  public final gw mj(long paramLong)
  {
    this.esb = paramLong;
    return this;
  }
  
  public final gw mk(long paramLong)
  {
    this.esc = paramLong;
    return this;
  }
  
  public final gw ml(long paramLong)
  {
    this.esd = paramLong;
    return this;
  }
  
  public final gw mm(long paramLong)
  {
    this.ese = paramLong;
    return this;
  }
  
  public final gw mn(long paramLong)
  {
    this.esf = paramLong;
    return this;
  }
  
  public final gw mo(long paramLong)
  {
    this.esg = paramLong;
    return this;
  }
  
  public final gw mp(long paramLong)
  {
    this.esh = paramLong;
    return this;
  }
  
  public final gw mq(long paramLong)
  {
    this.esi = paramLong;
    return this;
  }
  
  public final gw pY(String paramString)
  {
    AppMethodBeat.i(221916);
    this.erZ = t("Appid", paramString, true);
    AppMethodBeat.o(221916);
    return this;
  }
  
  public final gw pZ(String paramString)
  {
    AppMethodBeat.i(221917);
    this.dYc = t("Username", paramString, true);
    AppMethodBeat.o(221917);
    return this;
  }
  
  public final gw qa(String paramString)
  {
    AppMethodBeat.i(221918);
    this.esa = t("InstanceId", paramString, true);
    AppMethodBeat.o(221918);
    return this;
  }
  
  public final gw qb(String paramString)
  {
    AppMethodBeat.i(221919);
    this.ecB = t("NetType", paramString, true);
    AppMethodBeat.o(221919);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gw
 * JD-Core Version:    0.7.0.1
 */