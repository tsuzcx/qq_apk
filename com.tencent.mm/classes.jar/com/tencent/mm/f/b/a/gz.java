package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gz
  extends a
{
  private String gDS = "";
  private long gDT;
  private long gDU;
  private long gDV;
  private String gDw = "";
  private long gDx;
  private long gDy;
  private long gmT;
  private String grG = "";
  
  public final String agH()
  {
    AppMethodBeat.i(200068);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gDw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDV);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(200068);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(200069);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.gDw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.gDx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.grG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.gDS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.gmT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.gDT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.gDy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("replayStatusEnd:").append(this.gDU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("replayStatusBegin:").append(this.gDV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(200069);
    return localObject;
  }
  
  public final int getId()
  {
    return 19897;
  }
  
  public final gz pR(long paramLong)
  {
    this.gDx = paramLong;
    return this;
  }
  
  public final gz pS(long paramLong)
  {
    this.gmT = paramLong;
    return this;
  }
  
  public final gz pT(long paramLong)
  {
    this.gDT = paramLong;
    return this;
  }
  
  public final gz pU(long paramLong)
  {
    this.gDy = paramLong;
    return this;
  }
  
  public final gz pV(long paramLong)
  {
    this.gDU = paramLong;
    return this;
  }
  
  public final gz pW(long paramLong)
  {
    this.gDV = paramLong;
    return this;
  }
  
  public final gz vU(String paramString)
  {
    AppMethodBeat.i(200055);
    this.gDw = z("roomid", paramString, true);
    AppMethodBeat.o(200055);
    return this;
  }
  
  public final gz vV(String paramString)
  {
    AppMethodBeat.i(200058);
    this.grG = z("topic", paramString, true);
    AppMethodBeat.o(200058);
    return this;
  }
  
  public final gz vW(String paramString)
  {
    AppMethodBeat.i(200061);
    this.gDS = z("liveusername", paramString, true);
    AppMethodBeat.o(200061);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gz
 * JD-Core Version:    0.7.0.1
 */