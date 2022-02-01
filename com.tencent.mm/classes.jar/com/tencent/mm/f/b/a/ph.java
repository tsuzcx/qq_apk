package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ph
  extends a
{
  public long gYL = 0L;
  public long gYM = 0L;
  public long gYN = 0L;
  private String gfn = "";
  private String gmF = "";
  public long gnP = 0L;
  public long hcB = 0L;
  private long hcT = 0L;
  public long hcU = 0L;
  public long hcV = 0L;
  private String hdA = "";
  private String heJ = "";
  private String heQ = "";
  public long heR = 0L;
  public long heu = 0L;
  public long hew = 0L;
  public long hex = 0L;
  public long hey = 0L;
  public long hez = 0L;
  
  public final ph BR(long paramLong)
  {
    AppMethodBeat.i(43593);
    this.hcT = paramLong;
    super.bk("CostTimeMs", this.hcT);
    AppMethodBeat.o(43593);
    return this;
  }
  
  public final ph BS(long paramLong)
  {
    AppMethodBeat.i(43594);
    this.hcU = paramLong;
    super.bm("StartTimeStampMs", this.hcU);
    AppMethodBeat.o(43594);
    return this;
  }
  
  public final ph BT(long paramLong)
  {
    AppMethodBeat.i(43595);
    this.hcV = paramLong;
    super.bm("EndTimeStampMs", this.hcV);
    AppMethodBeat.o(43595);
    return this;
  }
  
  public final ph BU(long paramLong)
  {
    this.heu = paramLong;
    return this;
  }
  
  public final ph BV(long paramLong)
  {
    this.hex = paramLong;
    return this;
  }
  
  public final ph BW(long paramLong)
  {
    this.hey = paramLong;
    return this;
  }
  
  public final ph BX(long paramLong)
  {
    this.hez = paramLong;
    return this;
  }
  
  public final ph BY(long paramLong)
  {
    this.heR = paramLong;
    return this;
  }
  
  public final ph Gc(String paramString)
  {
    AppMethodBeat.i(43591);
    this.gfn = z("InstanceId", paramString, true);
    AppMethodBeat.o(43591);
    return this;
  }
  
  public final ph Gd(String paramString)
  {
    AppMethodBeat.i(43592);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(43592);
    return this;
  }
  
  public final ph Ge(String paramString)
  {
    AppMethodBeat.i(43596);
    this.heQ = z("fileName", paramString, true);
    AppMethodBeat.o(43596);
    return this;
  }
  
  public final ph Gf(String paramString)
  {
    AppMethodBeat.i(43597);
    this.heJ = z("libVersion", paramString, true);
    AppMethodBeat.o(43597);
    return this;
  }
  
  public final ph Gg(String paramString)
  {
    AppMethodBeat.i(43598);
    this.hdA = z("engineVersion", paramString, true);
    AppMethodBeat.o(43598);
    return this;
  }
  
  public final long St()
  {
    return this.hcU;
  }
  
  public final long Su()
  {
    return this.hcV;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(43599);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hcT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hcV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hcB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.heQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.heJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.heu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hew);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hex);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hey);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hez);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hdA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.heR);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(43599);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43600);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.gYM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.gYN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.hcT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.hcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.hcV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.hcB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileName:").append(this.heQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("libVersion:").append(this.heJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSize:").append(this.heu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineType:").append(this.hew);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useCodeCache:").append(this.hex);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useIsolatedContext:").append(this.hey);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("compileTime:").append(this.hez);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.hdA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("codeCacheType:").append(this.heR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43600);
    return localObject;
  }
  
  public final int getId()
  {
    return 15815;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ph
 * JD-Core Version:    0.7.0.1
 */