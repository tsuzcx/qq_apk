package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ao
  extends a
{
  public long dFd = 0L;
  public long dKe = 0L;
  public long dMB = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(120834);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMB);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(120834);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(120835);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.dMB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(120835);
    return localObject;
  }
  
  public final int getId()
  {
    return 17055;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ao
 * JD-Core Version:    0.7.0.1
 */