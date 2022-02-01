package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dz
  extends a
{
  public long dFd = 0L;
  public long dKe = 0L;
  public long dWC = 0L;
  public String dWD = "";
  
  public final String PV()
  {
    AppMethodBeat.i(149930);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWD);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(149930);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(149931);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Status:").append(this.dWC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransferId:").append(this.dWD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149931);
    return localObject;
  }
  
  public final int getId()
  {
    return 16440;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dz
 * JD-Core Version:    0.7.0.1
 */