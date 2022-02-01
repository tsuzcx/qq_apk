package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hh
  extends a
{
  public long dHY = 0L;
  private String dZT = "";
  public long eaM = 0L;
  private String ecm = "";
  public long eco = 0L;
  public long edd = 0L;
  private long edv = 0L;
  public long edw = 0L;
  public long edx = 0L;
  public long eeN = 0L;
  public long eeO = 0L;
  public long eeQ = 0L;
  public long eeR = 0L;
  public long eeS = 0L;
  public long eeT = 0L;
  private String eeU = "";
  private String efe = "";
  private String efk = "";
  public long efl = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(43599);
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
    ((StringBuffer)localObject).append(this.edd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeO);
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
    ((StringBuffer)localObject).append(this.efl);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(43599);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43600);
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
    ((StringBuffer)localObject).append("isPreload:").append(this.edd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileName:").append(this.efk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("libVersion:").append(this.efe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSize:").append(this.eeO);
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
    ((StringBuffer)localObject).append("codeCacheType:").append(this.efl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43600);
    return localObject;
  }
  
  public final long SK()
  {
    return this.edw;
  }
  
  public final long SL()
  {
    return this.edx;
  }
  
  public final int getId()
  {
    return 15815;
  }
  
  public final hh mc(long paramLong)
  {
    AppMethodBeat.i(43593);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(43593);
    return this;
  }
  
  public final hh md(long paramLong)
  {
    AppMethodBeat.i(43594);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(43594);
    return this;
  }
  
  public final hh me(long paramLong)
  {
    AppMethodBeat.i(43595);
    this.edx = paramLong;
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(43595);
    return this;
  }
  
  public final hh mf(long paramLong)
  {
    this.eeO = paramLong;
    return this;
  }
  
  public final hh mg(long paramLong)
  {
    this.eeR = paramLong;
    return this;
  }
  
  public final hh mh(long paramLong)
  {
    this.eeS = paramLong;
    return this;
  }
  
  public final hh mi(long paramLong)
  {
    this.eeT = paramLong;
    return this;
  }
  
  public final hh mj(long paramLong)
  {
    this.efl = paramLong;
    return this;
  }
  
  public final hh os(String paramString)
  {
    AppMethodBeat.i(43591);
    this.dZT = t("InstanceId", paramString, true);
    AppMethodBeat.o(43591);
    return this;
  }
  
  public final hh ot(String paramString)
  {
    AppMethodBeat.i(43592);
    this.ecm = t("AppId", paramString, true);
    AppMethodBeat.o(43592);
    return this;
  }
  
  public final hh ou(String paramString)
  {
    AppMethodBeat.i(43596);
    this.efk = t("fileName", paramString, true);
    AppMethodBeat.o(43596);
    return this;
  }
  
  public final hh ov(String paramString)
  {
    AppMethodBeat.i(43597);
    this.efe = t("libVersion", paramString, true);
    AppMethodBeat.o(43597);
    return this;
  }
  
  public final hh ow(String paramString)
  {
    AppMethodBeat.i(43598);
    this.eeU = t("engineVersion", paramString, true);
    AppMethodBeat.o(43598);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hh
 * JD-Core Version:    0.7.0.1
 */