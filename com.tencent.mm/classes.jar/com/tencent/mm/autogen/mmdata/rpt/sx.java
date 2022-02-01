package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class sx
  extends a
{
  public String ilM = "";
  public String imT = "";
  public long ind = 0L;
  public long ine = 0L;
  public long iqr = 0L;
  public long jAh = 0L;
  public String jAi = "";
  public long jAj = 0L;
  public long jAk = 0L;
  public long jAl = 0L;
  public long jAm = 0L;
  public String jAn = "";
  public String jAo = "";
  public long jax = 0L;
  private long jyH = 0L;
  public long jyI = 0L;
  public long jyJ = 0L;
  private String jzn = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(43573);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ind);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ine);
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
    ((StringBuffer)localObject).append(this.jAh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jAi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jAj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jAk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jAl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jAm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jzn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jAn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jAo);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(43573);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43574);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.ind);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ine);
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
    ((StringBuffer)localObject).append("fileSize:").append(this.jAh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filePath:").append(this.jAi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineType:").append(this.jAj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useCodeCache:").append(this.jAk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useIsolatedContext:").append(this.jAl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("compileTime:").append(this.jAm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.jzn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pluginAppid:").append(this.jAn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pluginVersion:").append(this.jAo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43574);
    return localObject;
  }
  
  public final sx aJc()
  {
    AppMethodBeat.i(43572);
    this.jyJ = Util.nowMilliSecond();
    super.by("EndTimeStampMs", this.jyJ);
    AppMethodBeat.o(43572);
    return this;
  }
  
  public final sx fS(long paramLong)
  {
    AppMethodBeat.i(43570);
    this.jyH = paramLong;
    super.bw("CostTimeMs", this.jyH);
    AppMethodBeat.o(43570);
    return this;
  }
  
  public final sx fT(long paramLong)
  {
    AppMethodBeat.i(43571);
    this.jyI = paramLong;
    super.by("StartTimeStampMs", this.jyI);
    AppMethodBeat.o(43571);
    return this;
  }
  
  public final int getId()
  {
    return 16007;
  }
  
  public final sx zq(String paramString)
  {
    AppMethodBeat.i(177749);
    this.jzn = F("engineVersion", paramString, true);
    AppMethodBeat.o(177749);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sx
 * JD-Core Version:    0.7.0.1
 */