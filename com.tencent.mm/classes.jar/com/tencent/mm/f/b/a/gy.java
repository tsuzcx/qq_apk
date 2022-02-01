package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gy
  extends a
{
  private String gDR = "";
  private String gDS = "";
  private String gDw = "";
  private long gDx;
  private long gDy;
  private long gDz;
  private long gmT;
  private String grG = "";
  
  public final String agH()
  {
    AppMethodBeat.i(196455);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gmT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDS);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(196455);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(196460);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.gmT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.gDw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.gDx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.grG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveuin:").append(this.gDR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.gDy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceCount:").append(this.gDz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.gDS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(196460);
    return localObject;
  }
  
  public final gy alc()
  {
    this.gmT = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 19896;
  }
  
  public final gy pO(long paramLong)
  {
    this.gDx = paramLong;
    return this;
  }
  
  public final gy pP(long paramLong)
  {
    this.gDy = paramLong;
    return this;
  }
  
  public final gy pQ(long paramLong)
  {
    this.gDz = paramLong;
    return this;
  }
  
  public final gy vR(String paramString)
  {
    AppMethodBeat.i(196446);
    this.gDw = z("roomid", paramString, true);
    AppMethodBeat.o(196446);
    return this;
  }
  
  public final gy vS(String paramString)
  {
    AppMethodBeat.i(196449);
    this.grG = z("topic", paramString, true);
    AppMethodBeat.o(196449);
    return this;
  }
  
  public final gy vT(String paramString)
  {
    AppMethodBeat.i(196453);
    this.gDS = z("liveusername", paramString, true);
    AppMethodBeat.o(196453);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gy
 * JD-Core Version:    0.7.0.1
 */