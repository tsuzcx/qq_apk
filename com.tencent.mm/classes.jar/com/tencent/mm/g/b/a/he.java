package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class he
  extends a
{
  public long dHY = 0L;
  public String dZT = "";
  public long eaM = 0L;
  public String ecm = "";
  public long eco = 0L;
  private long edv = 0L;
  public long edw = 0L;
  public long edx = 0L;
  public long eeN = 0L;
  public long eeO = 0L;
  public String eeP = "";
  public long eeQ = 0L;
  public long eeR = 0L;
  public long eeS = 0L;
  public long eeT = 0L;
  private String eeU = "";
  public String eeV;
  public String eeW;
  
  public final String PR()
  {
    AppMethodBeat.i(43573);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eco);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeW);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(43573);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43574);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eeN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eco);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.edv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.edw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.edx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSize:").append(this.eeO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filePath:").append(this.eeP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineType:").append(this.eeQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useCodeCache:").append(this.eeR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useIsolatedContext:").append(this.eeS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("compileTime:").append(this.eeT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.eeU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pluginAppid:").append(this.eeV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pluginVersion:").append(this.eeW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43574);
    return localObject;
  }
  
  public final he SS()
  {
    AppMethodBeat.i(43572);
    this.edx = bs.eWj();
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(43572);
    return this;
  }
  
  public final int getId()
  {
    return 16007;
  }
  
  public final he lW(long paramLong)
  {
    AppMethodBeat.i(43570);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(43570);
    return this;
  }
  
  public final he lX(long paramLong)
  {
    AppMethodBeat.i(43571);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(43571);
    return this;
  }
  
  public final he or(String paramString)
  {
    AppMethodBeat.i(177749);
    this.eeU = t("engineVersion", paramString, true);
    AppMethodBeat.o(177749);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.he
 * JD-Core Version:    0.7.0.1
 */