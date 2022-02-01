package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ce
  extends a
{
  public long dPl = 0L;
  public long dVd = 0L;
  public long eca = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(120834);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eca);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(120834);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(120835);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dPl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.eca);
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
 * Qualified Name:     com.tencent.mm.g.b.a.ce
 * JD-Core Version:    0.7.0.1
 */