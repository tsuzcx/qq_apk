package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class pe
  extends a
{
  public long gYL = 0L;
  public long gYM = 0L;
  public long gYN = 0L;
  public String gfn = "";
  public String gmF = "";
  public long gnP = 0L;
  private long hcT = 0L;
  public long hcU = 0L;
  public long hcV = 0L;
  private String hdA = "";
  public String heA = "";
  public String heB = "";
  public long heu = 0L;
  public String hev = "";
  public long hew = 0L;
  public long hex = 0L;
  public long hey = 0L;
  public long hez = 0L;
  
  public final pe BL(long paramLong)
  {
    AppMethodBeat.i(43570);
    this.hcT = paramLong;
    super.bk("CostTimeMs", this.hcT);
    AppMethodBeat.o(43570);
    return this;
  }
  
  public final pe BM(long paramLong)
  {
    AppMethodBeat.i(43571);
    this.hcU = paramLong;
    super.bm("StartTimeStampMs", this.hcU);
    AppMethodBeat.o(43571);
    return this;
  }
  
  public final pe Gb(String paramString)
  {
    AppMethodBeat.i(177749);
    this.hdA = z("engineVersion", paramString, true);
    AppMethodBeat.o(177749);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(43573);
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
    ((StringBuffer)localObject).append(this.heu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hev);
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
    ((StringBuffer)localObject).append(this.heA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.heB);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(43573);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43574);
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
    ((StringBuffer)localObject).append("fileSize:").append(this.heu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filePath:").append(this.hev);
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
    ((StringBuffer)localObject).append("pluginAppid:").append(this.heA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pluginVersion:").append(this.heB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43574);
    return localObject;
  }
  
  public final pe aoL()
  {
    AppMethodBeat.i(43572);
    this.hcV = Util.nowMilliSecond();
    super.bm("EndTimeStampMs", this.hcV);
    AppMethodBeat.o(43572);
    return this;
  }
  
  public final int getId()
  {
    return 16007;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pe
 * JD-Core Version:    0.7.0.1
 */