package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class mg
  extends a
{
  public String eJx = "";
  public String eWb = "";
  public long eXc = 0L;
  public long eYW = 0L;
  public long erW = 0L;
  private String faI = "";
  private long fac = 0L;
  public long fad = 0L;
  public long fae = 0L;
  public long fbC = 0L;
  public long fbD = 0L;
  public String fbE = "";
  public long fbF = 0L;
  public long fbG = 0L;
  public long fbH = 0L;
  public long fbI = 0L;
  public String fbJ = "";
  public String fbK = "";
  
  public final String abV()
  {
    AppMethodBeat.i(43573);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fbC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fac);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fad);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fae);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fbD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fbE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fbF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fbG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fbH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fbI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.faI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fbJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fbK);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(43573);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43574);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.fbC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eYW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.fac);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.fad);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.fae);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSize:").append(this.fbD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filePath:").append(this.fbE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineType:").append(this.fbF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useCodeCache:").append(this.fbG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useIsolatedContext:").append(this.fbH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("compileTime:").append(this.fbI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.faI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pluginAppid:").append(this.fbJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pluginVersion:").append(this.fbK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43574);
    return localObject;
  }
  
  public final mg ajd()
  {
    AppMethodBeat.i(43572);
    this.fae = Util.nowMilliSecond();
    super.bj("EndTimeStampMs", this.fae);
    AppMethodBeat.o(43572);
    return this;
  }
  
  public final int getId()
  {
    return 16007;
  }
  
  public final mg vQ(long paramLong)
  {
    AppMethodBeat.i(43570);
    this.fac = paramLong;
    super.bi("CostTimeMs", this.fac);
    AppMethodBeat.o(43570);
    return this;
  }
  
  public final mg vR(long paramLong)
  {
    AppMethodBeat.i(43571);
    this.fad = paramLong;
    super.bj("StartTimeStampMs", this.fad);
    AppMethodBeat.o(43571);
    return this;
  }
  
  public final mg zv(String paramString)
  {
    AppMethodBeat.i(177749);
    this.faI = x("engineVersion", paramString, true);
    AppMethodBeat.o(177749);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.mg
 * JD-Core Version:    0.7.0.1
 */