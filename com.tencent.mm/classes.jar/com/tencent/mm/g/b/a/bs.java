package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bs
  extends a
{
  public long cYR = 0L;
  public long cYS = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(56602);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cYR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYS);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(56602);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(56603);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.cYR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResetScece:").append(this.cYS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(56603);
    return localObject;
  }
  
  public final int getId()
  {
    return 15522;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bs
 * JD-Core Version:    0.7.0.1
 */