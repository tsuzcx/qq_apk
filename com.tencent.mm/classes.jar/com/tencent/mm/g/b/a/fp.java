package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fp
  extends a
{
  public long dCQ = 0L;
  public long dHY = 0L;
  public long dIy = 0L;
  public String dYx = "";
  
  public final String PR()
  {
    AppMethodBeat.i(149930);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYx);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(149930);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(149931);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dCQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Status:").append(this.dIy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransferId:").append(this.dYx);
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
 * Qualified Name:     com.tencent.mm.g.b.a.fp
 * JD-Core Version:    0.7.0.1
 */