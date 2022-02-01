package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fd
  extends a
{
  private String gcU = "";
  private long gef;
  private long gyb;
  
  public final String agH()
  {
    AppMethodBeat.i(209194);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209194);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209195);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotCount:").append(this.gyb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209195);
    return localObject;
  }
  
  public final int getId()
  {
    return 19947;
  }
  
  public final fd mV(long paramLong)
  {
    this.gyb = paramLong;
    return this;
  }
  
  public final fd mW(long paramLong)
  {
    this.gef = paramLong;
    return this;
  }
  
  public final fd tP(String paramString)
  {
    AppMethodBeat.i(209192);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(209192);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.fd
 * JD-Core Version:    0.7.0.1
 */