package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dv
  extends a
{
  public long dFd = 0L;
  public long dVG = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(155377);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFd);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(155377);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(155378);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ThirdAppType:").append(this.dVG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dFd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(155378);
    return localObject;
  }
  
  public final int getId()
  {
    return 16996;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dv
 * JD-Core Version:    0.7.0.1
 */