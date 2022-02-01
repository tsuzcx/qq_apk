package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class ik
  extends a
{
  public long dWt = 0L;
  public String esa = "";
  public long etb = 0L;
  public long euA = 0L;
  public String euy = "";
  private long evH = 0L;
  public long evI = 0L;
  public long evJ = 0L;
  private String ewn = "";
  public long exh = 0L;
  public long exi = 0L;
  public String exj = "";
  public long exk = 0L;
  public long exl = 0L;
  public long exm = 0L;
  public long exn = 0L;
  public String exo = "";
  public String exp = "";
  
  public final String RC()
  {
    AppMethodBeat.i(43573);
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
    ((StringBuffer)localObject).append(this.exi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exj);
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
    ((StringBuffer)localObject).append(this.exo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exp);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(43573);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43574);
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
    ((StringBuffer)localObject).append("fileSize:").append(this.exi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filePath:").append(this.exj);
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
    ((StringBuffer)localObject).append("pluginAppid:").append(this.exo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pluginVersion:").append(this.exp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43574);
    return localObject;
  }
  
  public final ik Vm()
  {
    AppMethodBeat.i(43572);
    this.evJ = bu.fpO();
    super.bh("EndTimeStampMs", this.evJ);
    AppMethodBeat.o(43572);
    return this;
  }
  
  public final int getId()
  {
    return 16007;
  }
  
  public final ik og(long paramLong)
  {
    AppMethodBeat.i(43570);
    this.evH = paramLong;
    super.bg("CostTimeMs", this.evH);
    AppMethodBeat.o(43570);
    return this;
  }
  
  public final ik oh(long paramLong)
  {
    AppMethodBeat.i(43571);
    this.evI = paramLong;
    super.bh("StartTimeStampMs", this.evI);
    AppMethodBeat.o(43571);
    return this;
  }
  
  public final ik rq(String paramString)
  {
    AppMethodBeat.i(177749);
    this.ewn = t("engineVersion", paramString, true);
    AppMethodBeat.o(177749);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ik
 * JD-Core Version:    0.7.0.1
 */