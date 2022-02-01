package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gp
  extends a
{
  public long dPl = 0L;
  public long dVd = 0L;
  public long dWg = 0L;
  public String eoU = "";
  
  public final String RD()
  {
    AppMethodBeat.i(149930);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoU);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(149930);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(149931);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dPl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Status:").append(this.dWg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransferId:").append(this.eoU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149931);
    return localObject;
  }
  
  public final int getId()
  {
    return 16440;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gp
 * JD-Core Version:    0.7.0.1
 */