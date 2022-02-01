package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class in
  extends a
{
  public long dWt = 0L;
  private String esa = "";
  public long etb = 0L;
  public long euA = 0L;
  private String euy = "";
  private long evH = 0L;
  public long evI = 0L;
  public long evJ = 0L;
  public long evp = 0L;
  private String ewn = "";
  private String exD = "";
  public long exE = 0L;
  public long exh = 0L;
  public long exi = 0L;
  public long exk = 0L;
  public long exl = 0L;
  public long exm = 0L;
  public long exn = 0L;
  private String exx = "";
  
  public final String RC()
  {
    AppMethodBeat.i(43599);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exE);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(43599);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43600);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.exh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.euA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.evH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.evI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.evJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.evp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileName:").append(this.exD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("libVersion:").append(this.exx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSize:").append(this.exi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineType:").append(this.exk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useCodeCache:").append(this.exl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useIsolatedContext:").append(this.exm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("compileTime:").append(this.exn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.ewn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("codeCacheType:").append(this.exE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43600);
    return localObject;
  }
  
  public final long Ve()
  {
    return this.evI;
  }
  
  public final long Vf()
  {
    return this.evJ;
  }
  
  public final in Vp()
  {
    this.exk = 5L;
    return this;
  }
  
  public final int getId()
  {
    return 15815;
  }
  
  public final in om(long paramLong)
  {
    AppMethodBeat.i(43593);
    this.evH = paramLong;
    super.bg("CostTimeMs", this.evH);
    AppMethodBeat.o(43593);
    return this;
  }
  
  public final in on(long paramLong)
  {
    AppMethodBeat.i(43594);
    this.evI = paramLong;
    super.bh("StartTimeStampMs", this.evI);
    AppMethodBeat.o(43594);
    return this;
  }
  
  public final in oo(long paramLong)
  {
    AppMethodBeat.i(43595);
    this.evJ = paramLong;
    super.bh("EndTimeStampMs", this.evJ);
    AppMethodBeat.o(43595);
    return this;
  }
  
  public final in op(long paramLong)
  {
    this.exi = paramLong;
    return this;
  }
  
  public final in oq(long paramLong)
  {
    this.exl = paramLong;
    return this;
  }
  
  public final in or(long paramLong)
  {
    this.exm = paramLong;
    return this;
  }
  
  public final in os(long paramLong)
  {
    this.exn = paramLong;
    return this;
  }
  
  public final in ot(long paramLong)
  {
    this.exE = paramLong;
    return this;
  }
  
  public final in rr(String paramString)
  {
    AppMethodBeat.i(43591);
    this.esa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43591);
    return this;
  }
  
  public final in rs(String paramString)
  {
    AppMethodBeat.i(43592);
    this.euy = t("AppId", paramString, true);
    AppMethodBeat.o(43592);
    return this;
  }
  
  public final in rt(String paramString)
  {
    AppMethodBeat.i(43596);
    this.exD = t("fileName", paramString, true);
    AppMethodBeat.o(43596);
    return this;
  }
  
  public final in ru(String paramString)
  {
    AppMethodBeat.i(43597);
    this.exx = t("libVersion", paramString, true);
    AppMethodBeat.o(43597);
    return this;
  }
  
  public final in rv(String paramString)
  {
    AppMethodBeat.i(43598);
    this.ewn = t("engineVersion", paramString, true);
    AppMethodBeat.o(43598);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.in
 * JD-Core Version:    0.7.0.1
 */