package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iy
  extends a
{
  public String eqt = "";
  public long eru = 0L;
  public String esR = "";
  public long esT = 0L;
  private long eua = 0L;
  public iy.a eyU;
  private long eyV = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(43707);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    if (this.eyU != null) {}
    for (int i = this.eyU.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.esT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eua);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eyV);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(43707);
      return localObject;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43708);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eyU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.esT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.eua);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitingTimeMs:").append(this.eyV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43708);
    return localObject;
  }
  
  public final int getId()
  {
    return 15853;
  }
  
  public final iy pl(long paramLong)
  {
    AppMethodBeat.i(43705);
    this.eua = paramLong;
    super.bf("CostTimeMs", this.eua);
    AppMethodBeat.o(43705);
    return this;
  }
  
  public final iy pm(long paramLong)
  {
    AppMethodBeat.i(43706);
    this.eyV = paramLong;
    super.bf("WaitingTimeMs", this.eyV);
    AppMethodBeat.o(43706);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.iy
 * JD-Core Version:    0.7.0.1
 */