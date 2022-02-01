package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class im
  extends a
{
  private String dTi = "";
  private long dVd = 0L;
  private String eqt = "";
  private long eru = 0L;
  private String esR = "";
  private long esT = 0L;
  private String etv = "";
  private long eua = 0L;
  private long eub = 0L;
  private long euc = 0L;
  private long evK;
  private a evY;
  private long evZ = 0L;
  private String evk;
  private long ewa = 0L;
  private String ewb;
  private String ewc;
  private String ewd;
  private int ewe;
  
  public final String RD()
  {
    AppMethodBeat.i(43609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    if (this.evY != null) {}
    for (int i = this.evY.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.etv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evZ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dTi);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewa);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewb);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evk);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewc);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewe);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(43609);
      return localObject;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43610);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.evY);
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
    ((StringBuffer)localObject).append("networkType:").append(this.etv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isLaunch:").append(this.evZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.dTi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("loadingType:").append(this.ewa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene_data:").append(this.ewb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.evK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("path:").append(this.evk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reload_referrer:").append(this.ewc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reload_reason:").append(this.ewd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("user_type:").append(this.ewe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43610);
    return localObject;
  }
  
  public final String Uz()
  {
    return this.eqt;
  }
  
  public final im a(a parama)
  {
    this.evY = parama;
    return this;
  }
  
  public final int getId()
  {
    return 16367;
  }
  
  public final im jr(int paramInt)
  {
    this.ewe = paramInt;
    return this;
  }
  
  public final im oi(long paramLong)
  {
    this.eru = paramLong;
    return this;
  }
  
  public final im oj(long paramLong)
  {
    this.esT = paramLong;
    return this;
  }
  
  public final im ok(long paramLong)
  {
    this.dVd = paramLong;
    return this;
  }
  
  public final im ol(long paramLong)
  {
    AppMethodBeat.i(43606);
    this.eub = paramLong;
    super.bg("StartTimeStampMs", this.eub);
    AppMethodBeat.o(43606);
    return this;
  }
  
  public final im om(long paramLong)
  {
    this.evZ = paramLong;
    return this;
  }
  
  public final im on(long paramLong)
  {
    this.ewa = paramLong;
    return this;
  }
  
  public final im oo(long paramLong)
  {
    this.evK = paramLong;
    return this;
  }
  
  public final im rb(String paramString)
  {
    AppMethodBeat.i(43604);
    this.eqt = t("InstanceId", paramString, true);
    AppMethodBeat.o(43604);
    return this;
  }
  
  public final im rc(String paramString)
  {
    AppMethodBeat.i(43605);
    this.esR = t("AppId", paramString, true);
    AppMethodBeat.o(43605);
    return this;
  }
  
  public final im rd(String paramString)
  {
    AppMethodBeat.i(187840);
    this.etv = t("networkType", paramString, true);
    AppMethodBeat.o(187840);
    return this;
  }
  
  public final im re(String paramString)
  {
    AppMethodBeat.i(43608);
    this.dTi = t("UserName", paramString, true);
    AppMethodBeat.o(43608);
    return this;
  }
  
  public final im rf(String paramString)
  {
    AppMethodBeat.i(187841);
    this.evk = t("path", paramString, true);
    AppMethodBeat.o(187841);
    return this;
  }
  
  public final im rg(String paramString)
  {
    AppMethodBeat.i(187842);
    this.ewc = t("reload_referrer", paramString, true);
    AppMethodBeat.o(187842);
    return this;
  }
  
  public final im rh(String paramString)
  {
    AppMethodBeat.i(187843);
    this.ewd = t("reload_reason", paramString, true);
    AppMethodBeat.o(187843);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43603);
      ewf = new a("release", 0, 1);
      ewg = new a("debug", 1, 2);
      ewh = new a("demo", 2, 3);
      ewi = new a[] { ewf, ewg, ewh };
      AppMethodBeat.o(43603);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a js(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ewf;
      case 2: 
        return ewg;
      }
      return ewh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.im
 * JD-Core Version:    0.7.0.1
 */