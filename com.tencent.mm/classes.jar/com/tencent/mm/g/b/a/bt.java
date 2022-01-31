package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bt
  extends a
{
  public long cRI = 0L;
  public long cYT = 0L;
  public long cYU = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(77616);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cRI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYU);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(77616);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(77617);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickScene:").append(this.cRI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportValue:").append(this.cYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EntryScene:").append(this.cYU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(77617);
    return localObject;
  }
  
  public final int getId()
  {
    return 15661;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bt
 * JD-Core Version:    0.7.0.1
 */