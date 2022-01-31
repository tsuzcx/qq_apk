package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bp
  extends a
{
  public long cYH = 0L;
  public long cYI = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(141124);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cYH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYI);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(141124);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(141125);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("clickScene:").append(this.cYH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("switchWay:").append(this.cYI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(141125);
    return localObject;
  }
  
  public final int getId()
  {
    return 17573;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bp
 * JD-Core Version:    0.7.0.1
 */