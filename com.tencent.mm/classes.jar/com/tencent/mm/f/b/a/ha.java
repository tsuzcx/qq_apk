package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ha
  extends a
{
  private long gDW = 0L;
  private long gDX;
  private String gDw = "";
  private long gDy;
  private long gmT;
  
  public final String agH()
  {
    AppMethodBeat.i(189769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gmT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDX);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(189769);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(189771);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.gmT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.gDw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reddot:").append(this.gDW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.gDy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PanelPage:").append(this.gDX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189771);
    return localObject;
  }
  
  public final ha ald()
  {
    this.gmT = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 19887;
  }
  
  public final ha pX(long paramLong)
  {
    this.gDy = paramLong;
    return this;
  }
  
  public final ha pY(long paramLong)
  {
    this.gDX = paramLong;
    return this;
  }
  
  public final ha vX(String paramString)
  {
    AppMethodBeat.i(189762);
    this.gDw = z("roomid", paramString, true);
    AppMethodBeat.o(189762);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ha
 * JD-Core Version:    0.7.0.1
 */