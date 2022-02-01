package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class te
  extends a
{
  private String ilM = "";
  private String imT = "";
  public long ind = 0L;
  public long iqr = 0L;
  private long jAa = 0L;
  public long jAh = 0L;
  public long jAj = 0L;
  public long jAk = 0L;
  public te.a jBe;
  private String jBf = "";
  private String jBg = "";
  public long jax = 0L;
  private long jyH = 0L;
  private long jyI = 0L;
  private long jyJ = 0L;
  private String jzn = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(43629);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ind);
    ((StringBuffer)localObject).append(",");
    if (this.jBe != null) {}
    for (int i = this.jBe.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.jBf);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAh);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAa);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAk);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAj);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jzn);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBg);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(43629);
      return localObject;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43630);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.ind);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.jBe);
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
    ((StringBuffer)localObject).append("package:").append(this.jBf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSize:").append(this.jAh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadPageFrame:").append(this.jAa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useCodeCache:").append(this.jAk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineType:").append(this.jAj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.jzn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lazyLoadKey:").append(this.jBg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43630);
    return localObject;
  }
  
  public final int getId()
  {
    return 16005;
  }
  
  public final te gf(long paramLong)
  {
    AppMethodBeat.i(43624);
    this.jyH = paramLong;
    super.bw("CostTimeMs", this.jyH);
    AppMethodBeat.o(43624);
    return this;
  }
  
  public final te gg(long paramLong)
  {
    AppMethodBeat.i(43625);
    this.jyI = paramLong;
    super.by("StartTimeStampMs", this.jyI);
    AppMethodBeat.o(43625);
    return this;
  }
  
  public final te gh(long paramLong)
  {
    AppMethodBeat.i(43626);
    this.jyJ = paramLong;
    super.by("EndTimeStampMs", this.jyJ);
    AppMethodBeat.o(43626);
    return this;
  }
  
  public final te zH(String paramString)
  {
    AppMethodBeat.i(43622);
    this.ilM = F("InstanceId", paramString, true);
    AppMethodBeat.o(43622);
    return this;
  }
  
  public final te zI(String paramString)
  {
    AppMethodBeat.i(43623);
    this.imT = F("AppId", paramString, true);
    AppMethodBeat.o(43623);
    return this;
  }
  
  public final te zJ(String paramString)
  {
    AppMethodBeat.i(43627);
    this.jBf = F("package", paramString, true);
    AppMethodBeat.o(43627);
    return this;
  }
  
  public final te zK(String paramString)
  {
    AppMethodBeat.i(43628);
    this.jzn = F("engineVersion", paramString, true);
    AppMethodBeat.o(43628);
    return this;
  }
  
  public final te zL(String paramString)
  {
    AppMethodBeat.i(368856);
    this.jBg = F("lazyLoadKey", paramString, true);
    AppMethodBeat.o(368856);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.te
 * JD-Core Version:    0.7.0.1
 */