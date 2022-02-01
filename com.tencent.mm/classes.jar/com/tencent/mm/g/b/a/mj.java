package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mj
  extends a
{
  private String eJx = "";
  private String eWb = "";
  public long eXc = 0L;
  public long eYW = 0L;
  public long eZK = 0L;
  public long erW = 0L;
  private String faI = "";
  private long fac = 0L;
  public long fad = 0L;
  public long fae = 0L;
  public long fbC = 0L;
  public long fbD = 0L;
  public long fbF = 0L;
  public long fbG = 0L;
  public long fbH = 0L;
  public long fbI = 0L;
  private String fbS = "";
  private String fbZ = "";
  public long fca = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(43599);
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
    ((StringBuffer)localObject).append(this.eZK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fbZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fbS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fbD);
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
    ((StringBuffer)localObject).append(this.fca);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(43599);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43600);
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
    ((StringBuffer)localObject).append("isPreload:").append(this.eZK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileName:").append(this.fbZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("libVersion:").append(this.fbS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSize:").append(this.fbD);
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
    ((StringBuffer)localObject).append("codeCacheType:").append(this.fca);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43600);
    return localObject;
  }
  
  public final long aiV()
  {
    return this.fad;
  }
  
  public final long aiW()
  {
    return this.fae;
  }
  
  public final mj ajg()
  {
    this.fbF = 5L;
    return this;
  }
  
  public final int getId()
  {
    return 15815;
  }
  
  public final mj vW(long paramLong)
  {
    AppMethodBeat.i(43593);
    this.fac = paramLong;
    super.bi("CostTimeMs", this.fac);
    AppMethodBeat.o(43593);
    return this;
  }
  
  public final mj vX(long paramLong)
  {
    AppMethodBeat.i(43594);
    this.fad = paramLong;
    super.bj("StartTimeStampMs", this.fad);
    AppMethodBeat.o(43594);
    return this;
  }
  
  public final mj vY(long paramLong)
  {
    AppMethodBeat.i(43595);
    this.fae = paramLong;
    super.bj("EndTimeStampMs", this.fae);
    AppMethodBeat.o(43595);
    return this;
  }
  
  public final mj vZ(long paramLong)
  {
    this.fbD = paramLong;
    return this;
  }
  
  public final mj wa(long paramLong)
  {
    this.fbG = paramLong;
    return this;
  }
  
  public final mj wb(long paramLong)
  {
    this.fbH = paramLong;
    return this;
  }
  
  public final mj wc(long paramLong)
  {
    this.fbI = paramLong;
    return this;
  }
  
  public final mj wd(long paramLong)
  {
    this.fca = paramLong;
    return this;
  }
  
  public final mj zA(String paramString)
  {
    AppMethodBeat.i(43598);
    this.faI = x("engineVersion", paramString, true);
    AppMethodBeat.o(43598);
    return this;
  }
  
  public final mj zw(String paramString)
  {
    AppMethodBeat.i(43591);
    this.eWb = x("InstanceId", paramString, true);
    AppMethodBeat.o(43591);
    return this;
  }
  
  public final mj zx(String paramString)
  {
    AppMethodBeat.i(43592);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(43592);
    return this;
  }
  
  public final mj zy(String paramString)
  {
    AppMethodBeat.i(43596);
    this.fbZ = x("fileName", paramString, true);
    AppMethodBeat.o(43596);
    return this;
  }
  
  public final mj zz(String paramString)
  {
    AppMethodBeat.i(43597);
    this.fbS = x("libVersion", paramString, true);
    AppMethodBeat.o(43597);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.mj
 * JD-Core Version:    0.7.0.1
 */