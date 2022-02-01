package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gr
  extends a
{
  public long dQB = 0L;
  public long dWt = 0L;
  public long dXy = 0L;
  public String eqB = "";
  
  public final String RC()
  {
    AppMethodBeat.i(149930);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqB);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(149930);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(149931);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Status:").append(this.dXy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransferId:").append(this.eqB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149931);
    return localObject;
  }
  
  public final int getId()
  {
    return 16440;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gr
 * JD-Core Version:    0.7.0.1
 */