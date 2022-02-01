package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iq
  extends a
{
  private long dVd = 0L;
  private String eqt = "";
  private long eru = 0L;
  private String esR = "";
  private long esT = 0L;
  private long eua = 0L;
  private long eub = 0L;
  private long euc = 0L;
  private long ewA = 0L;
  private long ewB = 0L;
  private String ewC = "";
  private long ewD = 0L;
  private iq.a ewz;
  
  public final String RD()
  {
    AppMethodBeat.i(43639);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    if (this.ewz != null) {}
    for (int i = this.ewz.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.esT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eua);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dVd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eub);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euc);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewB);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewC);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewD);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(43639);
      return localObject;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43640);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ewz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.esT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.eua);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.eub);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.euc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("processNum:").append(this.ewA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runtimeNum:").append(this.ewB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("distribution:").append(this.ewC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mmtoolsAlive:").append(this.ewD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43640);
    return localObject;
  }
  
  public final iq a(iq.a parama)
  {
    this.ewz = parama;
    return this;
  }
  
  public final int getId()
  {
    return 18032;
  }
  
  public final iq oA(long paramLong)
  {
    this.ewD = paramLong;
    return this;
  }
  
  public final iq ov(long paramLong)
  {
    this.eru = paramLong;
    return this;
  }
  
  public final iq ow(long paramLong)
  {
    this.esT = paramLong;
    return this;
  }
  
  public final iq ox(long paramLong)
  {
    this.dVd = paramLong;
    return this;
  }
  
  public final iq oy(long paramLong)
  {
    this.ewA = paramLong;
    return this;
  }
  
  public final iq oz(long paramLong)
  {
    this.ewB = paramLong;
    return this;
  }
  
  public final iq rm(String paramString)
  {
    AppMethodBeat.i(43636);
    this.eqt = t("InstanceId", paramString, true);
    AppMethodBeat.o(43636);
    return this;
  }
  
  public final iq rn(String paramString)
  {
    AppMethodBeat.i(43637);
    this.esR = t("AppId", paramString, true);
    AppMethodBeat.o(43637);
    return this;
  }
  
  public final iq ro(String paramString)
  {
    AppMethodBeat.i(43638);
    this.ewC = t("distribution", paramString, true);
    AppMethodBeat.o(43638);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.iq
 * JD-Core Version:    0.7.0.1
 */