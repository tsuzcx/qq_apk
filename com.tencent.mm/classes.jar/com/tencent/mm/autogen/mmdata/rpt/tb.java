package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class tb
  extends a
{
  private String iEy = "";
  private String iXJ = "";
  public String ilK = "";
  public String ilM = "";
  private String imT = "";
  public long ind = 0L;
  public long iqr = 0L;
  private String irj = "";
  public tb.a jAH;
  public long jAI = 0L;
  public long jAJ = 0L;
  private String jAK = "";
  private String jAL = "";
  private String jAM = "";
  public int jAN;
  public long jAO;
  public long jAP;
  public String jAQ = "";
  public long jAq;
  public long jax = 0L;
  private long jyH = 0L;
  private long jyI = 0L;
  private long jyJ = 0L;
  private String jzR = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(43609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ind);
    ((StringBuffer)localObject).append(",");
    if (this.jAH != null) {}
    for (int i = this.jAH.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.iEy);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.irj);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jzR);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAM);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAO);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAP);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAQ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ilK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iXJ);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(43609);
      return localObject;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43610);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.ind);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.jAH);
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
    ((StringBuffer)localObject).append("networkType:").append(this.iEy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isLaunch:").append(this.jAI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.irj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("loadingType:").append(this.jAJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene_data:").append(this.jAK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.jAq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("path:").append(this.jzR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reload_referrer:").append(this.jAL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reload_reason:").append(this.jAM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("user_type:").append(this.jAN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("launchMode:").append(this.jAO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("coldStartMode:").append(this.jAP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("shortLink:").append(this.jAQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.ilK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SceneNote:").append(this.iXJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43610);
    return localObject;
  }
  
  public final tb gb(long paramLong)
  {
    AppMethodBeat.i(43606);
    this.jyI = paramLong;
    super.by("StartTimeStampMs", this.jyI);
    AppMethodBeat.o(43606);
    return this;
  }
  
  public final int getId()
  {
    return 16367;
  }
  
  public final tb zA(String paramString)
  {
    AppMethodBeat.i(43608);
    this.irj = F("UserName", paramString, true);
    AppMethodBeat.o(43608);
    return this;
  }
  
  public final tb zB(String paramString)
  {
    AppMethodBeat.i(368892);
    this.jAK = F("scene_data", paramString, true);
    AppMethodBeat.o(368892);
    return this;
  }
  
  public final tb zC(String paramString)
  {
    AppMethodBeat.i(368900);
    this.jzR = F("path", paramString, true);
    AppMethodBeat.o(368900);
    return this;
  }
  
  public final tb zD(String paramString)
  {
    AppMethodBeat.i(368907);
    this.jAL = F("reload_referrer", paramString, true);
    AppMethodBeat.o(368907);
    return this;
  }
  
  public final tb zE(String paramString)
  {
    AppMethodBeat.i(368914);
    this.jAM = F("reload_reason", paramString, true);
    AppMethodBeat.o(368914);
    return this;
  }
  
  public final tb zF(String paramString)
  {
    AppMethodBeat.i(368921);
    this.ilK = F("sessionId", paramString, true);
    AppMethodBeat.o(368921);
    return this;
  }
  
  public final tb zG(String paramString)
  {
    AppMethodBeat.i(368928);
    this.iXJ = F("SceneNote", paramString, true);
    AppMethodBeat.o(368928);
    return this;
  }
  
  public final tb zx(String paramString)
  {
    AppMethodBeat.i(43604);
    this.ilM = F("InstanceId", paramString, true);
    AppMethodBeat.o(43604);
    return this;
  }
  
  public final tb zy(String paramString)
  {
    AppMethodBeat.i(43605);
    this.imT = F("AppId", paramString, true);
    AppMethodBeat.o(43605);
    return this;
  }
  
  public final tb zz(String paramString)
  {
    AppMethodBeat.i(368881);
    this.iEy = F("networkType", paramString, true);
    AppMethodBeat.o(368881);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.tb
 * JD-Core Version:    0.7.0.1
 */