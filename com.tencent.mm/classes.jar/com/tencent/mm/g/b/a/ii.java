package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class ii
  extends a
{
  public long dVd = 0L;
  public String eqt = "";
  public long eru = 0L;
  public String esR = "";
  public long esT = 0L;
  private String euG = "";
  private long eua = 0L;
  public long eub = 0L;
  public long euc = 0L;
  public long evA = 0L;
  public long evB = 0L;
  public String evC = "";
  public long evD = 0L;
  public long evE = 0L;
  public long evF = 0L;
  public long evG = 0L;
  public String evH;
  public String evI;
  
  public final String RD()
  {
    AppMethodBeat.i(43573);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evA);
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
    ((StringBuffer)localObject).append(this.evB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evI);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(43573);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43574);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.evA);
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
    ((StringBuffer)localObject).append("fileSize:").append(this.evB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filePath:").append(this.evC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineType:").append(this.evD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useCodeCache:").append(this.evE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useIsolatedContext:").append(this.evF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("compileTime:").append(this.evG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.euG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pluginAppid:").append(this.evH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pluginVersion:").append(this.evI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43574);
    return localObject;
  }
  
  public final ii Vg()
  {
    AppMethodBeat.i(43572);
    this.euc = bt.flT();
    super.bg("EndTimeStampMs", this.euc);
    AppMethodBeat.o(43572);
    return this;
  }
  
  public final int getId()
  {
    return 16007;
  }
  
  public final ii nU(long paramLong)
  {
    AppMethodBeat.i(43570);
    this.eua = paramLong;
    super.bf("CostTimeMs", this.eua);
    AppMethodBeat.o(43570);
    return this;
  }
  
  public final ii nV(long paramLong)
  {
    AppMethodBeat.i(43571);
    this.eub = paramLong;
    super.bg("StartTimeStampMs", this.eub);
    AppMethodBeat.o(43571);
    return this;
  }
  
  public final ii qV(String paramString)
  {
    AppMethodBeat.i(177749);
    this.euG = t("engineVersion", paramString, true);
    AppMethodBeat.o(177749);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ii
 * JD-Core Version:    0.7.0.1
 */