package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ce
  extends a
{
  public long cRG = 0L;
  public long cYC = 0L;
  private String cZA = "";
  public long cZB = 0L;
  public long cZD = 0L;
  public ce.a daG;
  private String dar = "";
  private long dat = 0L;
  public long dau = 0L;
  public long dav = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(128684);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dar);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZB);
    ((StringBuffer)localObject).append(",");
    if (this.daG != null) {}
    for (int i = this.daG.value;; i = -1)
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
      AppMethodBeat.o(128684);
      return localObject;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128685);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dar);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.cZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.cZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.daG);
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
    AppMethodBeat.o(128685);
    return localObject;
  }
  
  public final ce eH(long paramLong)
  {
    AppMethodBeat.i(128681);
    this.dat = paramLong;
    super.ay("CostTimeMs", this.dat);
    AppMethodBeat.o(128681);
    return this;
  }
  
  public final ce eI(long paramLong)
  {
    AppMethodBeat.i(128682);
    this.dau = paramLong;
    super.az("StartTimeStampMs", this.dau);
    AppMethodBeat.o(128682);
    return this;
  }
  
  public final ce eJ(long paramLong)
  {
    AppMethodBeat.i(128683);
    this.dav = paramLong;
    super.az("EndTimeStampMs", this.dav);
    AppMethodBeat.o(128683);
    return this;
  }
  
  public final int getId()
  {
    return 16895;
  }
  
  public final ce hg(String paramString)
  {
    AppMethodBeat.i(128679);
    this.dar = t("InstanceId", paramString, true);
    AppMethodBeat.o(128679);
    return this;
  }
  
  public final ce hh(String paramString)
  {
    AppMethodBeat.i(128680);
    this.cZA = t("AppId", paramString, true);
    AppMethodBeat.o(128680);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ce
 * JD-Core Version:    0.7.0.1
 */