package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ta
  extends a
{
  private String ilM = "";
  private String imT = "";
  public long ind = 0L;
  public long ine = 0L;
  public long iqr = 0L;
  private String jAE = "";
  public long jAF = 0L;
  private String jAG = "";
  public long jAh = 0L;
  public long jAj = 0L;
  public long jAk = 0L;
  public long jAl = 0L;
  public long jAm = 0L;
  private String jAw = "";
  public long jax = 0L;
  private long jyH = 0L;
  public long jyI = 0L;
  public long jyJ = 0L;
  public long jyp = 0L;
  private String jzn = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(43599);
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
    ((StringBuffer)localObject).append(this.jyp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jAE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jAw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jAh);
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
    ((StringBuffer)localObject).append(this.jAF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jAG);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(43599);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43600);
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
    ((StringBuffer)localObject).append("isPreload:").append(this.jyp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileName:").append(this.jAE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("libVersion:").append(this.jAw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSize:").append(this.jAh);
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
    ((StringBuffer)localObject).append("codeCacheType:").append(this.jAF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("expt:").append(this.jAG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43600);
    return localObject;
  }
  
  public final ta fY(long paramLong)
  {
    AppMethodBeat.i(43593);
    this.jyH = paramLong;
    super.bw("CostTimeMs", this.jyH);
    AppMethodBeat.o(43593);
    return this;
  }
  
  public final ta fZ(long paramLong)
  {
    AppMethodBeat.i(43594);
    this.jyI = paramLong;
    super.by("StartTimeStampMs", this.jyI);
    AppMethodBeat.o(43594);
    return this;
  }
  
  public final ta ga(long paramLong)
  {
    AppMethodBeat.i(43595);
    this.jyJ = paramLong;
    super.by("EndTimeStampMs", this.jyJ);
    AppMethodBeat.o(43595);
    return this;
  }
  
  public final int getId()
  {
    return 15815;
  }
  
  public final ta zr(String paramString)
  {
    AppMethodBeat.i(43591);
    this.ilM = F("InstanceId", paramString, true);
    AppMethodBeat.o(43591);
    return this;
  }
  
  public final ta zs(String paramString)
  {
    AppMethodBeat.i(43592);
    this.imT = F("AppId", paramString, true);
    AppMethodBeat.o(43592);
    return this;
  }
  
  public final ta zt(String paramString)
  {
    AppMethodBeat.i(43596);
    this.jAE = F("fileName", paramString, true);
    AppMethodBeat.o(43596);
    return this;
  }
  
  public final ta zu(String paramString)
  {
    AppMethodBeat.i(43597);
    this.jAw = F("libVersion", paramString, true);
    AppMethodBeat.o(43597);
    return this;
  }
  
  public final ta zv(String paramString)
  {
    AppMethodBeat.i(43598);
    this.jzn = F("engineVersion", paramString, true);
    AppMethodBeat.o(43598);
    return this;
  }
  
  public final ta zw(String paramString)
  {
    AppMethodBeat.i(368957);
    this.jAG = F("expt", paramString, true);
    AppMethodBeat.o(368957);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ta
 * JD-Core Version:    0.7.0.1
 */