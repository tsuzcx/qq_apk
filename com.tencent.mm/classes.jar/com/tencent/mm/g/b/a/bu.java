package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bu
  extends a
{
  public long cRG = 0L;
  public long cYV = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(80736);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cRG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYV);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(80736);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(80737);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.cRG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTime:").append(this.cYV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(80737);
    return localObject;
  }
  
  public final int getId()
  {
    return 15509;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bu
 * JD-Core Version:    0.7.0.1
 */