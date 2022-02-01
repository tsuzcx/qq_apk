package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mx
  extends a
{
  public String gWy = "";
  public long gef = 0L;
  public long gnP = 0L;
  public long gpj = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(149930);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gWy);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(149930);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(149931);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Status:").append(this.gpj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransferId:").append(this.gWy);
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
 * Qualified Name:     com.tencent.mm.f.b.a.mx
 * JD-Core Version:    0.7.0.1
 */