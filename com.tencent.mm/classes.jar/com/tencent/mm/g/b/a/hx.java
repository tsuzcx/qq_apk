package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hx
  extends a
{
  private long dFd;
  private long dNI;
  
  public final String PV()
  {
    AppMethodBeat.i(203800);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dNI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFd);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203800);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203801);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Type:").append(this.dNI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dFd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203801);
    return localObject;
  }
  
  public final int getId()
  {
    return 19952;
  }
  
  public final hx zo(long paramLong)
  {
    this.dNI = paramLong;
    return this;
  }
  
  public final hx zp(long paramLong)
  {
    this.dFd = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hx
 * JD-Core Version:    0.7.0.1
 */