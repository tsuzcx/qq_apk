package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class sq
  extends a
{
  private String ilM = "";
  private String imT = "";
  public long ind = 0L;
  public long iqr = 0L;
  public long ixD = 0L;
  public long jax = 0L;
  private long jyH = 0L;
  private long jyI = 0L;
  public long jyJ = 0L;
  public long jyp = 0L;
  public sq.a jzl;
  public long jzm = 0L;
  private String jzn = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(43543);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ind);
    ((StringBuffer)localObject).append(",");
    if (this.jzl != null) {}
    for (int i = this.jzl.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.jyp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ixD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jzm);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jzn);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(43543);
      return localObject;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43544);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.ind);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.jzl);
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
    ((StringBuffer)localObject).append("isPreload:").append(this.jyp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.ixD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isGame:").append(this.jzm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.jzn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43544);
    return localObject;
  }
  
  public final sq aIZ()
  {
    AppMethodBeat.i(43542);
    this.jyJ = Util.nowMilliSecond();
    super.by("EndTimeStampMs", this.jyJ);
    AppMethodBeat.o(43542);
    return this;
  }
  
  public final sq fJ(long paramLong)
  {
    AppMethodBeat.i(43540);
    this.jyH = paramLong;
    super.bw("CostTimeMs", this.jyH);
    AppMethodBeat.o(43540);
    return this;
  }
  
  public final sq fK(long paramLong)
  {
    AppMethodBeat.i(43541);
    this.jyI = paramLong;
    super.by("StartTimeStampMs", this.jyI);
    AppMethodBeat.o(43541);
    return this;
  }
  
  public final int getId()
  {
    return 15814;
  }
  
  public final sq zf(String paramString)
  {
    AppMethodBeat.i(43538);
    this.ilM = F("InstanceId", paramString, true);
    AppMethodBeat.o(43538);
    return this;
  }
  
  public final sq zg(String paramString)
  {
    AppMethodBeat.i(43539);
    this.imT = F("AppId", paramString, true);
    AppMethodBeat.o(43539);
    return this;
  }
  
  public final sq zh(String paramString)
  {
    AppMethodBeat.i(368962);
    this.jzn = F("engineVersion", paramString, true);
    AppMethodBeat.o(368962);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sq
 * JD-Core Version:    0.7.0.1
 */