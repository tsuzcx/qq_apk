package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hq
  extends a
{
  private long dFd;
  private String dHr;
  
  public final String PV()
  {
    AppMethodBeat.i(203758);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHr);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203758);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203759);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203759);
    return localObject;
  }
  
  public final hq aRZ(String paramString)
  {
    AppMethodBeat.i(203757);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(203757);
    return this;
  }
  
  public final int getId()
  {
    return 19954;
  }
  
  public final hq yM(long paramLong)
  {
    this.dFd = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hq
 * JD-Core Version:    0.7.0.1
 */