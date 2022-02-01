package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class sm
  extends a
{
  private String ilM = "";
  private String imT = "";
  public long iqr = 0L;
  public long jax = 0L;
  private long jyH = 0L;
  public long jyI = 0L;
  public long jyJ = 0L;
  public sm.a jyP;
  public long jyQ = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(43509);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    if (this.jyP != null) {}
    for (int i = this.jyP.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jax);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iqr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyQ);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(43509);
      return localObject;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43510);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.jyP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.jax);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.jyH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.jyI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.jyJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPreload:").append(this.jyQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43510);
    return localObject;
  }
  
  public final sm aIY()
  {
    AppMethodBeat.i(43508);
    this.jyJ = Util.nowMilliSecond();
    super.by("EndTimeStampMs", this.jyJ);
    AppMethodBeat.o(43508);
    return this;
  }
  
  public final sm fy(long paramLong)
  {
    AppMethodBeat.i(43506);
    this.jyH = paramLong;
    super.bw("CostTimeMs", this.jyH);
    AppMethodBeat.o(43506);
    return this;
  }
  
  public final sm fz(long paramLong)
  {
    AppMethodBeat.i(43507);
    this.jyI = paramLong;
    super.by("StartTimeStampMs", this.jyI);
    AppMethodBeat.o(43507);
    return this;
  }
  
  public final int getId()
  {
    return 17111;
  }
  
  public final sm zd(String paramString)
  {
    AppMethodBeat.i(43504);
    this.ilM = F("InstanceId", paramString, true);
    AppMethodBeat.o(43504);
    return this;
  }
  
  public final sm ze(String paramString)
  {
    AppMethodBeat.i(43505);
    this.imT = F("AppId", paramString, true);
    AppMethodBeat.o(43505);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sm
 * JD-Core Version:    0.7.0.1
 */