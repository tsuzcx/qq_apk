package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gw
  extends a
{
  private long gDH = 0L;
  private long gDI;
  private String gDJ = "";
  private long gDK;
  private String gDw = "";
  private long gDx;
  private long gzc;
  
  public final String agH()
  {
    AppMethodBeat.i(198125);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gDw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDK);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(198125);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(198130);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.gDw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.gDx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("waitCount:").append(this.gDH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("allowConnect:").append(this.gDI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceUin:").append(this.gDJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCode:").append(this.gzc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("linkCount:").append(this.gDK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(198130);
    return localObject;
  }
  
  public final int getId()
  {
    return 19894;
  }
  
  public final gw pB(long paramLong)
  {
    this.gDx = paramLong;
    return this;
  }
  
  public final gw pC(long paramLong)
  {
    this.gDH = paramLong;
    return this;
  }
  
  public final gw pD(long paramLong)
  {
    this.gDI = paramLong;
    return this;
  }
  
  public final gw pE(long paramLong)
  {
    this.gDK = paramLong;
    return this;
  }
  
  public final gw vO(String paramString)
  {
    AppMethodBeat.i(198112);
    this.gDw = z("roomid", paramString, true);
    AppMethodBeat.o(198112);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gw
 * JD-Core Version:    0.7.0.1
 */