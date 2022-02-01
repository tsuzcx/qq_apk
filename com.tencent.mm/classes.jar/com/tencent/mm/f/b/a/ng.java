package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ng
  extends a
{
  private long gYC = 0L;
  private long gYD = 0L;
  private long gYE = 0L;
  private long gYF = 0L;
  private long gYG = 0L;
  private long gYH = 0L;
  private long gYI = 0L;
  private long gYJ = 0L;
  private String gdF = "";
  private String gfm = "";
  private String gfn = "";
  private String gqd = "";
  
  public final ng Eb(String paramString)
  {
    AppMethodBeat.i(274763);
    this.gfm = z("Appid", paramString, true);
    AppMethodBeat.o(274763);
    return this;
  }
  
  public final ng Ec(String paramString)
  {
    AppMethodBeat.i(274765);
    this.gqd = z("Username", paramString, true);
    AppMethodBeat.o(274765);
    return this;
  }
  
  public final ng Ed(String paramString)
  {
    AppMethodBeat.i(274767);
    this.gfn = z("InstanceId", paramString, true);
    AppMethodBeat.o(274767);
    return this;
  }
  
  public final ng Ee(String paramString)
  {
    AppMethodBeat.i(274768);
    this.gdF = z("NetType", paramString, true);
    AppMethodBeat.o(274768);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(274769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYJ);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(274769);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(274770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Appid:").append(this.gfm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.gqd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenScene:").append(this.gYC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppVersion:").append(this.gYD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LocalAppVersion:").append(this.gYE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdateResult:").append(this.gYF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdateCostTimeInMs:").append(this.gYG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FallbackWaitTimeInMs:").append(this.gYH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.gdF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsWeakNet:").append(this.gYI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FallbackScene:").append(this.gYJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(274770);
    return localObject;
  }
  
  public final int getId()
  {
    return 20579;
  }
  
  public final ng zl(long paramLong)
  {
    this.gYC = paramLong;
    return this;
  }
  
  public final ng zm(long paramLong)
  {
    this.gYD = paramLong;
    return this;
  }
  
  public final ng zn(long paramLong)
  {
    this.gYE = paramLong;
    return this;
  }
  
  public final ng zo(long paramLong)
  {
    this.gYF = paramLong;
    return this;
  }
  
  public final ng zp(long paramLong)
  {
    this.gYG = paramLong;
    return this;
  }
  
  public final ng zq(long paramLong)
  {
    this.gYH = paramLong;
    return this;
  }
  
  public final ng zr(long paramLong)
  {
    this.gYI = paramLong;
    return this;
  }
  
  public final ng zs(long paramLong)
  {
    this.gYJ = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ng
 * JD-Core Version:    0.7.0.1
 */