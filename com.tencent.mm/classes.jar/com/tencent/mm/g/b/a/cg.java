package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cg
  extends a
{
  public long cRG = 0L;
  public long cYC = 0L;
  private String cZA = "";
  public long cZB = 0L;
  public long cZD = 0L;
  public cg.a daR;
  private String dar = "";
  private long dat = 0L;
  public long dau = 0L;
  public long dav = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(128704);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dar);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZB);
    ((StringBuffer)localObject).append(",");
    if (this.daR != null) {}
    for (int i = this.daR.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cZD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dat);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cRG);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dau);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dav);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cYC);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(128704);
      return localObject;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128705);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dar);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.cZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.cZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.daR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.cZD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.dat);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.cRG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.dau);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.dav);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.cYC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(128705);
    return localObject;
  }
  
  public final cg eN(long paramLong)
  {
    AppMethodBeat.i(128701);
    this.dat = paramLong;
    super.ay("CostTimeMs", this.dat);
    AppMethodBeat.o(128701);
    return this;
  }
  
  public final cg eO(long paramLong)
  {
    AppMethodBeat.i(128702);
    this.dau = paramLong;
    super.az("StartTimeStampMs", this.dau);
    AppMethodBeat.o(128702);
    return this;
  }
  
  public final cg eP(long paramLong)
  {
    AppMethodBeat.i(128703);
    this.dav = paramLong;
    super.az("EndTimeStampMs", this.dav);
    AppMethodBeat.o(128703);
    return this;
  }
  
  public final int getId()
  {
    return 16899;
  }
  
  public final cg hk(String paramString)
  {
    AppMethodBeat.i(128699);
    this.dar = t("InstanceId", paramString, true);
    AppMethodBeat.o(128699);
    return this;
  }
  
  public final cg hl(String paramString)
  {
    AppMethodBeat.i(128700);
    this.cZA = t("AppId", paramString, true);
    AppMethodBeat.o(128700);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cg
 * JD-Core Version:    0.7.0.1
 */