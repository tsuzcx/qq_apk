package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mg
  extends a
{
  private long gTl;
  private long gTm;
  private long gTn;
  private long gTo;
  private String gcU = "";
  
  public final mg CJ(String paramString)
  {
    AppMethodBeat.i(223031);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(223031);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(223038);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTo);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(223038);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(223044);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PullStartTimeStamp:").append(this.gTl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PullEndTimeStamp:").append(this.gTm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.gTn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailedType:").append(this.gTo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(223044);
    return localObject;
  }
  
  public final int getId()
  {
    return 20205;
  }
  
  public final mg xa(long paramLong)
  {
    this.gTl = paramLong;
    return this;
  }
  
  public final mg xb(long paramLong)
  {
    this.gTm = paramLong;
    return this;
  }
  
  public final mg xc(long paramLong)
  {
    this.gTn = paramLong;
    return this;
  }
  
  public final mg xd(long paramLong)
  {
    this.gTo = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.mg
 * JD-Core Version:    0.7.0.1
 */