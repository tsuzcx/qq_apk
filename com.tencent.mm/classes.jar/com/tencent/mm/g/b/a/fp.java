package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fp
  extends a
{
  public long dKe = 0L;
  public long dYT = 0L;
  private String dYa = "";
  public long eaX = 0L;
  private String eag = "";
  public long eai = 0L;
  private long ebp = 0L;
  public long ebq = 0L;
  public long ebr = 0L;
  public long ecH = 0L;
  public long ecI = 0L;
  public long ecK = 0L;
  public long ecL = 0L;
  public long ecM = 0L;
  public long ecN = 0L;
  private String ecO = "";
  private String ecY = "";
  private String ede = "";
  public long edf = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(43599);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eai);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ede);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edf);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(43599);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43600);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ecH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eai);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.ebp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.ebq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.ebr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.eaX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileName:").append(this.ede);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("libVersion:").append(this.ecY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSize:").append(this.ecI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineType:").append(this.ecK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useCodeCache:").append(this.ecL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useIsolatedContext:").append(this.ecM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("compileTime:").append(this.ecN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.ecO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("codeCacheType:").append(this.edf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43600);
    return localObject;
  }
  
  public final long RR()
  {
    return this.ebq;
  }
  
  public final long RS()
  {
    return this.ebr;
  }
  
  public final int getId()
  {
    return 15815;
  }
  
  public final fp iA(long paramLong)
  {
    AppMethodBeat.i(43593);
    this.ebp = paramLong;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(43593);
    return this;
  }
  
  public final fp iB(long paramLong)
  {
    AppMethodBeat.i(43594);
    this.ebq = paramLong;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(43594);
    return this;
  }
  
  public final fp iC(long paramLong)
  {
    AppMethodBeat.i(43595);
    this.ebr = paramLong;
    super.bb("EndTimeStampMs", this.ebr);
    AppMethodBeat.o(43595);
    return this;
  }
  
  public final fp iD(long paramLong)
  {
    this.ecI = paramLong;
    return this;
  }
  
  public final fp iE(long paramLong)
  {
    this.ecL = paramLong;
    return this;
  }
  
  public final fp iF(long paramLong)
  {
    this.ecM = paramLong;
    return this;
  }
  
  public final fp iG(long paramLong)
  {
    this.ecN = paramLong;
    return this;
  }
  
  public final fp iH(long paramLong)
  {
    this.edf = paramLong;
    return this;
  }
  
  public final fp ln(String paramString)
  {
    AppMethodBeat.i(43591);
    this.dYa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43591);
    return this;
  }
  
  public final fp lo(String paramString)
  {
    AppMethodBeat.i(43592);
    this.eag = t("AppId", paramString, true);
    AppMethodBeat.o(43592);
    return this;
  }
  
  public final fp lp(String paramString)
  {
    AppMethodBeat.i(43596);
    this.ede = t("fileName", paramString, true);
    AppMethodBeat.o(43596);
    return this;
  }
  
  public final fp lq(String paramString)
  {
    AppMethodBeat.i(43597);
    this.ecY = t("libVersion", paramString, true);
    AppMethodBeat.o(43597);
    return this;
  }
  
  public final fp lr(String paramString)
  {
    AppMethodBeat.i(43598);
    this.ecO = t("engineVersion", paramString, true);
    AppMethodBeat.o(43598);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fp
 * JD-Core Version:    0.7.0.1
 */