package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ni
  extends a
{
  private long gYL = 0L;
  private long gYM = 0L;
  private long gYN = 0L;
  private long gYO = 0L;
  private long gYP = 0L;
  private long gYQ = 0L;
  private String gmF = "";
  
  public final ni Ej(String paramString)
  {
    AppMethodBeat.i(278889);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(278889);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(278890);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYQ);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(278890);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(278891);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.gYM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.gYN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CallPageType:").append(this.gYO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HalfPageOperation:").append(this.gYP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LicensePlateOperation:").append(this.gYQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(278891);
    return localObject;
  }
  
  public final long anY()
  {
    return this.gYQ;
  }
  
  public final int getId()
  {
    return 23342;
  }
  
  public final ni zt(long paramLong)
  {
    this.gYL = paramLong;
    return this;
  }
  
  public final ni zu(long paramLong)
  {
    this.gYM = paramLong;
    return this;
  }
  
  public final ni zv(long paramLong)
  {
    this.gYN = paramLong;
    return this;
  }
  
  public final ni zw(long paramLong)
  {
    this.gYO = paramLong;
    return this;
  }
  
  public final ni zx(long paramLong)
  {
    this.gYP = paramLong;
    return this;
  }
  
  public final ni zy(long paramLong)
  {
    this.gYQ = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ni
 * JD-Core Version:    0.7.0.1
 */