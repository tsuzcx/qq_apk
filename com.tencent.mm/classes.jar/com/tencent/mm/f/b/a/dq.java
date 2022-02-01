package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dq
  extends a
{
  private String gcU = "";
  private long gef;
  
  public final String agH()
  {
    AppMethodBeat.i(207875);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(207875);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(207879);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207879);
    return localObject;
  }
  
  public final int getId()
  {
    return 19954;
  }
  
  public final dq jx(long paramLong)
  {
    this.gef = paramLong;
    return this;
  }
  
  public final dq qK(String paramString)
  {
    AppMethodBeat.i(207872);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(207872);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.dq
 * JD-Core Version:    0.7.0.1
 */