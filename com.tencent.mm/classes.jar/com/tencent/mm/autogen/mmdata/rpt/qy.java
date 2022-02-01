package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qy
  extends a
{
  public String ijV = "";
  public String ilL = "";
  public String ilM = "";
  public String imU = "";
  public long juq = 0L;
  public long jur = 0L;
  public long jus = 0L;
  public long jut = 0L;
  public long juu = 0L;
  public long juv = 0L;
  public long juw = 0L;
  public long jux = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(369222);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jur);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jus);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jut);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jux);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369222);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369230);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Appid:").append(this.ilL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.imU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenScene:").append(this.juq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppVersion:").append(this.jur);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LocalAppVersion:").append(this.jus);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdateResult:").append(this.jut);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdateCostTimeInMs:").append(this.juu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FallbackWaitTimeInMs:").append(this.juv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.ijV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsWeakNet:").append(this.juw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FallbackScene:").append(this.jux);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369230);
    return localObject;
  }
  
  public final int getId()
  {
    return 20579;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.qy
 * JD-Core Version:    0.7.0.1
 */