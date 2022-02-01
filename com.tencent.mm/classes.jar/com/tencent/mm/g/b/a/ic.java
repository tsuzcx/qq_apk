package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ic
  extends a
{
  private long dPt;
  private String dQr;
  private long maW = 0L;
  private long maX;
  private String maY;
  private long maZ;
  private long mas;
  
  public final String PV()
  {
    AppMethodBeat.i(202438);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mas);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.maW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.maX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.maY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.maZ);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(202438);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(202439);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.dQr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.mas);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("waitCount:").append(this.maW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("allowConnect:").append(this.maX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceUin:").append(this.maY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCode:").append(this.dPt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("linkCount:").append(this.maZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(202439);
    return localObject;
  }
  
  public final ic aSV(String paramString)
  {
    AppMethodBeat.i(202437);
    this.dQr = t("roomid", paramString, true);
    AppMethodBeat.o(202437);
    return this;
  }
  
  public final int getId()
  {
    return 19894;
  }
  
  public final ic zQ(long paramLong)
  {
    this.mas = paramLong;
    return this;
  }
  
  public final ic zR(long paramLong)
  {
    this.maW = paramLong;
    return this;
  }
  
  public final ic zS(long paramLong)
  {
    this.maX = paramLong;
    return this;
  }
  
  public final ic zT(long paramLong)
  {
    this.maZ = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ic
 * JD-Core Version:    0.7.0.1
 */