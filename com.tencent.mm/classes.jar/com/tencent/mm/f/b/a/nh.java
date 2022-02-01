package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nh
  extends a
{
  public long gYC = 0L;
  public long gYD = 0L;
  public long gYE = 0L;
  public long gYI = 0L;
  public long gYJ = 0L;
  public long gYK = 0L;
  private String gdF = "";
  private String gfm = "";
  private String gfn = "";
  private String gqd = "";
  
  public final nh Ef(String paramString)
  {
    AppMethodBeat.i(280059);
    this.gfm = z("Appid", paramString, true);
    AppMethodBeat.o(280059);
    return this;
  }
  
  public final nh Eg(String paramString)
  {
    AppMethodBeat.i(280060);
    this.gqd = z("Username", paramString, true);
    AppMethodBeat.o(280060);
    return this;
  }
  
  public final nh Eh(String paramString)
  {
    AppMethodBeat.i(280061);
    this.gdF = z("NetType", paramString, true);
    AppMethodBeat.o(280061);
    return this;
  }
  
  public final nh Ei(String paramString)
  {
    AppMethodBeat.i(280063);
    this.gfn = z("InstanceId", paramString, true);
    AppMethodBeat.o(280063);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(280064);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfn);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(280064);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(280065);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Appid:").append(this.gfm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.gqd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenScene:").append(this.gYC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppVersion:").append(this.gYD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LocalAppVersion:").append(this.gYE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FallbackScene:").append(this.gYJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitTimeInMs:").append(this.gYK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.gdF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsWeakNet:").append(this.gYI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(280065);
    return localObject;
  }
  
  public final long anR()
  {
    return this.gYC;
  }
  
  public final long anS()
  {
    return this.gYD;
  }
  
  public final long anT()
  {
    return this.gYE;
  }
  
  public final long anU()
  {
    return this.gYK;
  }
  
  public final String anV()
  {
    return this.gdF;
  }
  
  public final long anW()
  {
    return this.gYI;
  }
  
  public final String anX()
  {
    return this.gfn;
  }
  
  public final String getAppid()
  {
    return this.gfm;
  }
  
  public final int getId()
  {
    return 20572;
  }
  
  public final String getUsername()
  {
    return this.gqd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.nh
 * JD-Core Version:    0.7.0.1
 */