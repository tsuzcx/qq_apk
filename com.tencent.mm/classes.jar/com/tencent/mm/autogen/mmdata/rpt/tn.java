package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class tn
  extends a
{
  public long iVU = 0L;
  public String ilM = "";
  public String imT = "";
  public long ind = 0L;
  public String iqX = "";
  public long iqr = 0L;
  private String jCW = "";
  public tn.a jDC;
  public c jDD;
  public b jDE;
  public long jDF = 0L;
  public long jDj = 0L;
  public long jax = 0L;
  private long jyH = 0L;
  public long jyI = 0L;
  private long jyJ = 0L;
  
  public final String aIE()
  {
    int j = -1;
    AppMethodBeat.i(43700);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ind);
    ((StringBuffer)localObject).append(",");
    if (this.jDC != null)
    {
      i = this.jDC.value;
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
      if (this.jDD == null) {
        break label325;
      }
    }
    label325:
    for (int i = this.jDD.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.jDE != null) {
        i = this.jDE.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iVU);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jDF);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iqX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jDj);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jCW);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(43700);
      return localObject;
      i = -1;
      break;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43701);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.ind);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.jDC);
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
    ((StringBuffer)localObject).append("Ret:").append(this.jDD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.jDE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.iVU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsNormalOpen:").append(this.jDF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.iqX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isParallel:").append(this.jDj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkTypeStr:").append(this.jCW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43701);
    return localObject;
  }
  
  public final int getId()
  {
    return 15765;
  }
  
  public final tn gu(long paramLong)
  {
    AppMethodBeat.i(43696);
    this.jyH = paramLong;
    super.bw("CostTimeMs", this.jyH);
    AppMethodBeat.o(43696);
    return this;
  }
  
  public final tn gv(long paramLong)
  {
    AppMethodBeat.i(43697);
    this.jyI = paramLong;
    super.by("StartTimeStampMs", this.jyI);
    AppMethodBeat.o(43697);
    return this;
  }
  
  public final tn gw(long paramLong)
  {
    AppMethodBeat.i(43698);
    this.jyJ = paramLong;
    super.by("EndTimeStampMs", this.jyJ);
    AppMethodBeat.o(43698);
    return this;
  }
  
  public final tn zV(String paramString)
  {
    AppMethodBeat.i(43695);
    this.imT = F("AppId", paramString, true);
    AppMethodBeat.o(43695);
    return this;
  }
  
  public final tn zW(String paramString)
  {
    AppMethodBeat.i(368782);
    this.jCW = F("NetworkTypeStr", paramString, true);
    AppMethodBeat.o(368782);
    return this;
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43690);
      jDK = new b("sync", 0, 0);
      jDL = new b("async", 1, 1);
      jDM = new b("preLaunch", 2, 2);
      jDN = new b[] { jDK, jDL, jDM };
      AppMethodBeat.o(43690);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum c
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43693);
      jDO = new c("ok", 0, 0);
      jDP = new c("common_fail", 1, 1);
      jDQ = new c("bundle_null", 2, 2);
      jDR = new c("jsapi_control_bytes_null", 3, 3);
      jDS = new c[] { jDO, jDP, jDQ, jDR };
      AppMethodBeat.o(43693);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.tn
 * JD-Core Version:    0.7.0.1
 */