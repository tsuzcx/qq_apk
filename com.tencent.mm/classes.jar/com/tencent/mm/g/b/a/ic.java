package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class ic
  extends a
{
  public long dVd = 0L;
  public long eaw = 0L;
  private String eqt = "";
  public long eru = 0L;
  private String esR = "";
  public long esT = 0L;
  public long etI = 0L;
  public ic.a euE;
  public long euF = 0L;
  private String euG = "";
  private long eua = 0L;
  private long eub = 0L;
  public long euc = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(43543);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    if (this.euE != null) {}
    for (int i = this.euE.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.euF);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euG);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(43543);
      return localObject;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43544);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.euE);
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
    ((StringBuffer)localObject).append("isGame:").append(this.euF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.euG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43544);
    return localObject;
  }
  
  public final ic UX()
  {
    AppMethodBeat.i(43542);
    this.euc = bt.flT();
    super.bg("EndTimeStampMs", this.euc);
    AppMethodBeat.o(43542);
    return this;
  }
  
  public final int getId()
  {
    return 15814;
  }
  
  public final ic nD(long paramLong)
  {
    AppMethodBeat.i(43540);
    this.eua = paramLong;
    super.bf("CostTimeMs", this.eua);
    AppMethodBeat.o(43540);
    return this;
  }
  
  public final ic nE(long paramLong)
  {
    AppMethodBeat.i(43541);
    this.eub = paramLong;
    super.bg("StartTimeStampMs", this.eub);
    AppMethodBeat.o(43541);
    return this;
  }
  
  public final ic qK(String paramString)
  {
    AppMethodBeat.i(43538);
    this.eqt = t("InstanceId", paramString, true);
    AppMethodBeat.o(43538);
    return this;
  }
  
  public final ic qL(String paramString)
  {
    AppMethodBeat.i(43539);
    this.esR = t("AppId", paramString, true);
    AppMethodBeat.o(43539);
    return this;
  }
  
  public final ic qM(String paramString)
  {
    AppMethodBeat.i(187825);
    this.euG = t("engineVersion", paramString, true);
    AppMethodBeat.o(187825);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ic
 * JD-Core Version:    0.7.0.1
 */