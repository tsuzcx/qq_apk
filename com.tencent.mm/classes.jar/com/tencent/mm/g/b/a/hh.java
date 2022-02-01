package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hh
  extends a
{
  public long dVd = 0L;
  public long ebY = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(118318);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebY);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(118318);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(118319);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTime:").append(this.ebY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118319);
    return localObject;
  }
  
  public final int getId()
  {
    return 15509;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hh
 * JD-Core Version:    0.7.0.1
 */