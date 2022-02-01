package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class py
  extends a
{
  public long gYL = 0L;
  public long gYN = 0L;
  private String gfn = "";
  private String gmF = "";
  public long gnP = 0L;
  public long grp = 0L;
  public long hcB = 0L;
  private long hcT = 0L;
  private long hcU = 0L;
  public long hcV = 0L;
  public py.a hiN;
  public long hiO = 0L;
  private String hiP = "";
  
  public final py Du(long paramLong)
  {
    AppMethodBeat.i(43736);
    this.hcT = paramLong;
    super.bk("CostTimeMs", this.hcT);
    AppMethodBeat.o(43736);
    return this;
  }
  
  public final py Dv(long paramLong)
  {
    AppMethodBeat.i(43737);
    this.hcU = paramLong;
    super.bm("StartTimeStampMs", this.hcU);
    AppMethodBeat.o(43737);
    return this;
  }
  
  public final py GT(String paramString)
  {
    AppMethodBeat.i(43734);
    this.gfn = z("InstanceId", paramString, true);
    AppMethodBeat.o(43734);
    return this;
  }
  
  public final py GU(String paramString)
  {
    AppMethodBeat.i(43735);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(43735);
    return this;
  }
  
  public final py GV(String paramString)
  {
    AppMethodBeat.i(43739);
    this.hiP = z("engineVersionStr", paramString, true);
    AppMethodBeat.o(43739);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(43740);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    if (this.hiN != null) {}
    for (int i = this.hiN.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gYN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gnP);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcU);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcV);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcB);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.grp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hiO);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hiP);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(43740);
      return localObject;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43741);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.hiN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.gYN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.hcT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.hcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.hcV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.hcB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.grp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.hiO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersionStr:").append(this.hiP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43741);
    return localObject;
  }
  
  public final py aoU()
  {
    AppMethodBeat.i(43738);
    this.hcV = Util.nowMilliSecond();
    super.bm("EndTimeStampMs", this.hcV);
    AppMethodBeat.o(43738);
    return this;
  }
  
  public final int getId()
  {
    return 15813;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.py
 * JD-Core Version:    0.7.0.1
 */