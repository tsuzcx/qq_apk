package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mi
  extends a
{
  private long gTl;
  private long gTm;
  private long gTn;
  private String gTu = "";
  private long gTw;
  
  public final mi CK(String paramString)
  {
    AppMethodBeat.i(230579);
    this.gTu = z("WordVersion", paramString, true);
    AppMethodBeat.o(230579);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(230581);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gTl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTu);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(230581);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(230582);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PullStartTimeStamp:").append(this.gTl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PullEndTimeStamp:").append(this.gTm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.gTn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordSize:").append(this.gTw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordVersion:").append(this.gTu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(230582);
    return localObject;
  }
  
  public final int getId()
  {
    return 20203;
  }
  
  public final mi xe(long paramLong)
  {
    this.gTl = paramLong;
    return this;
  }
  
  public final mi xf(long paramLong)
  {
    this.gTm = paramLong;
    return this;
  }
  
  public final mi xg(long paramLong)
  {
    this.gTn = paramLong;
    return this;
  }
  
  public final mi xh(long paramLong)
  {
    this.gTw = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.mi
 * JD-Core Version:    0.7.0.1
 */