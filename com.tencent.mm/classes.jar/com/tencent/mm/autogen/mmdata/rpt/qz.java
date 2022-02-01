package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qz
  extends a
{
  public String ijV = "";
  public String ilL = "";
  public String ilM = "";
  public String imU = "";
  public long juq = 0L;
  public long jur = 0L;
  public long jus = 0L;
  public long juw = 0L;
  public long jux = 0L;
  public long juy = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(369248);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jur);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jus);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jux);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilM);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369248);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369253);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Appid:").append(this.ilL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.imU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenScene:").append(this.juq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppVersion:").append(this.jur);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LocalAppVersion:").append(this.jus);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FallbackScene:").append(this.jux);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitTimeInMs:").append(this.juy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.ijV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsWeakNet:").append(this.juw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369253);
    return localObject;
  }
  
  public final int getId()
  {
    return 20572;
  }
  
  public final qz xV(String paramString)
  {
    AppMethodBeat.i(369224);
    this.ilL = F("Appid", paramString, true);
    AppMethodBeat.o(369224);
    return this;
  }
  
  public final qz xW(String paramString)
  {
    AppMethodBeat.i(369229);
    this.imU = F("Username", paramString, true);
    AppMethodBeat.o(369229);
    return this;
  }
  
  public final qz xX(String paramString)
  {
    AppMethodBeat.i(369237);
    this.ijV = F("NetType", paramString, true);
    AppMethodBeat.o(369237);
    return this;
  }
  
  public final qz xY(String paramString)
  {
    AppMethodBeat.i(369242);
    this.ilM = F("InstanceId", paramString, true);
    AppMethodBeat.o(369242);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.qz
 * JD-Core Version:    0.7.0.1
 */