package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class jb
  extends a
{
  public long dVd = 0L;
  public long eaw = 0L;
  private String eqt = "";
  public long eru = 0L;
  private String esR = "";
  public long esT = 0L;
  public long etI = 0L;
  private long eua = 0L;
  private long eub = 0L;
  public long euc = 0L;
  public jb.a ezC;
  public long ezD = 0L;
  private String ezE = "";
  
  public final String RD()
  {
    AppMethodBeat.i(43740);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    if (this.ezC != null) {}
    for (int i = this.ezC.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.etI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eaw);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ezD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ezE);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(43740);
      return localObject;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43741);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ezC);
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
    ((StringBuffer)localObject).append("isPreload:").append(this.etI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.eaw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.ezD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersionStr:").append(this.ezE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43741);
    return localObject;
  }
  
  public final jb Vp()
  {
    AppMethodBeat.i(43738);
    this.euc = bt.flT();
    super.bg("EndTimeStampMs", this.euc);
    AppMethodBeat.o(43738);
    return this;
  }
  
  public final int getId()
  {
    return 15813;
  }
  
  public final jb pw(long paramLong)
  {
    AppMethodBeat.i(43736);
    this.eua = paramLong;
    super.bf("CostTimeMs", this.eua);
    AppMethodBeat.o(43736);
    return this;
  }
  
  public final jb px(long paramLong)
  {
    AppMethodBeat.i(43737);
    this.eub = paramLong;
    super.bg("StartTimeStampMs", this.eub);
    AppMethodBeat.o(43737);
    return this;
  }
  
  public final jb rF(String paramString)
  {
    AppMethodBeat.i(43734);
    this.eqt = t("InstanceId", paramString, true);
    AppMethodBeat.o(43734);
    return this;
  }
  
  public final jb rG(String paramString)
  {
    AppMethodBeat.i(43735);
    this.esR = t("AppId", paramString, true);
    AppMethodBeat.o(43735);
    return this;
  }
  
  public final jb rH(String paramString)
  {
    AppMethodBeat.i(43739);
    this.ezE = t("engineVersionStr", paramString, true);
    AppMethodBeat.o(43739);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jb
 * JD-Core Version:    0.7.0.1
 */