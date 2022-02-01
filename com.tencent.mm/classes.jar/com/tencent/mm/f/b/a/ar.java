package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ar
  extends a
{
  private String gcU = "";
  private long gjD;
  private long gjE;
  private long gjF;
  private long gjG;
  private long gjH;
  private long gjI;
  private long gjJ;
  private long gjK;
  private String gjL = "";
  private long gjM;
  private String gjj = "";
  
  public final String agH()
  {
    AppMethodBeat.i(208899);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjM);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208899);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208900);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReddotFlag:").append(this.gjD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLocation:").append(this.gjE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLocationPermission:").append(this.gjF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FollowInitPosition:").append(this.gjG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendInitPosition:").append(this.gjH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LBSInitPosition:").append(this.gjI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HotInitPosition:").append(this.gjJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTab:").append(this.gjK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterRedDotId:").append(this.gjL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.gjj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoRefresh:").append(this.gjM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208900);
    return localObject;
  }
  
  public final ar cA(long paramLong)
  {
    this.gjH = paramLong;
    return this;
  }
  
  public final ar cB(long paramLong)
  {
    this.gjI = paramLong;
    return this;
  }
  
  public final ar cC(long paramLong)
  {
    this.gjJ = paramLong;
    return this;
  }
  
  public final ar cD(long paramLong)
  {
    this.gjK = paramLong;
    return this;
  }
  
  public final ar cE(long paramLong)
  {
    this.gjM = paramLong;
    return this;
  }
  
  public final ar cw(long paramLong)
  {
    this.gjD = paramLong;
    return this;
  }
  
  public final ar cx(long paramLong)
  {
    this.gjE = paramLong;
    return this;
  }
  
  public final ar cy(long paramLong)
  {
    this.gjF = paramLong;
    return this;
  }
  
  public final ar cz(long paramLong)
  {
    this.gjG = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19025;
  }
  
  public final ar jo(String paramString)
  {
    AppMethodBeat.i(208895);
    this.gjL = z("EnterRedDotId", paramString, true);
    AppMethodBeat.o(208895);
    return this;
  }
  
  public final ar jp(String paramString)
  {
    AppMethodBeat.i(208896);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(208896);
    return this;
  }
  
  public final ar jq(String paramString)
  {
    AppMethodBeat.i(208897);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(208897);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ar
 * JD-Core Version:    0.7.0.1
 */