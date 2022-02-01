package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pi
  extends a
{
  private long gYL = 0L;
  private long gYN = 0L;
  private String gfl = "";
  private String gfn = "";
  private String gjX = "";
  private String gmF = "";
  private long gnP = 0L;
  private String gtA = "";
  private long hcT = 0L;
  private long hcU = 0L;
  private long hcV = 0L;
  private long heD;
  private pi.a heS;
  private long heT = 0L;
  private long heU = 0L;
  private String heV = "";
  private String heW = "";
  private String heX = "";
  private int heY;
  private long heZ;
  private String hee = "";
  private long hfa;
  private String hfb = "";
  
  public final pi BZ(long paramLong)
  {
    this.gYL = paramLong;
    return this;
  }
  
  public final pi Ca(long paramLong)
  {
    this.gYN = paramLong;
    return this;
  }
  
  public final pi Cb(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final pi Cc(long paramLong)
  {
    AppMethodBeat.i(43606);
    this.hcU = paramLong;
    super.bm("StartTimeStampMs", this.hcU);
    AppMethodBeat.o(43606);
    return this;
  }
  
  public final pi Cd(long paramLong)
  {
    this.heT = paramLong;
    return this;
  }
  
  public final pi Ce(long paramLong)
  {
    this.heU = paramLong;
    return this;
  }
  
  public final pi Cf(long paramLong)
  {
    this.heD = paramLong;
    return this;
  }
  
  public final pi Cg(long paramLong)
  {
    this.heZ = paramLong;
    return this;
  }
  
  public final pi Ch(long paramLong)
  {
    this.hfa = paramLong;
    return this;
  }
  
  public final pi Gh(String paramString)
  {
    AppMethodBeat.i(43604);
    this.gfn = z("InstanceId", paramString, true);
    AppMethodBeat.o(43604);
    return this;
  }
  
  public final pi Gi(String paramString)
  {
    AppMethodBeat.i(43605);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(43605);
    return this;
  }
  
  public final pi Gj(String paramString)
  {
    AppMethodBeat.i(271061);
    this.gtA = z("networkType", paramString, true);
    AppMethodBeat.o(271061);
    return this;
  }
  
  public final pi Gk(String paramString)
  {
    AppMethodBeat.i(43608);
    this.gjX = z("UserName", paramString, true);
    AppMethodBeat.o(43608);
    return this;
  }
  
  public final pi Gl(String paramString)
  {
    AppMethodBeat.i(271063);
    this.hee = z("path", paramString, true);
    AppMethodBeat.o(271063);
    return this;
  }
  
  public final pi Gm(String paramString)
  {
    AppMethodBeat.i(271064);
    this.heW = z("reload_referrer", paramString, true);
    AppMethodBeat.o(271064);
    return this;
  }
  
  public final pi Gn(String paramString)
  {
    AppMethodBeat.i(271066);
    this.heX = z("reload_reason", paramString, true);
    AppMethodBeat.o(271066);
    return this;
  }
  
  public final pi Go(String paramString)
  {
    AppMethodBeat.i(271067);
    this.hfb = z("shortLink", paramString, true);
    AppMethodBeat.o(271067);
    return this;
  }
  
  public final pi Gp(String paramString)
  {
    AppMethodBeat.i(271068);
    this.gfl = z("sessionId", paramString, true);
    AppMethodBeat.o(271068);
    return this;
  }
  
  public final pi a(pi.a parama)
  {
    this.heS = parama;
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(43609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    if (this.heS != null) {}
    for (int i = this.heS.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.gtA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.heT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gjX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.heU);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.heV);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.heD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hee);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.heW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.heX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.heY);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.heZ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hfa);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hfb);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gfl);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(43609);
      return localObject;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43610);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.heS);
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
    ((StringBuffer)localObject).append("networkType:").append(this.gtA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isLaunch:").append(this.heT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.gjX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("loadingType:").append(this.heU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene_data:").append(this.heV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.heD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("path:").append(this.hee);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reload_referrer:").append(this.heW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reload_reason:").append(this.heX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("user_type:").append(this.heY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("launchMode:").append(this.heZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("coldStartMode:").append(this.hfa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("shortLink:").append(this.hfb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.gfl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43610);
    return localObject;
  }
  
  public final String anX()
  {
    return this.gfn;
  }
  
  public final int getId()
  {
    return 16367;
  }
  
  public final String getSessionId()
  {
    return this.gfl;
  }
  
  public final pi oG(int paramInt)
  {
    this.heY = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pi
 * JD-Core Version:    0.7.0.1
 */