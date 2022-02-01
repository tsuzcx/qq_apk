package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ej
  extends a
{
  public long dZl = 0L;
  public long dZm = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(91241);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZm);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(91241);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(91242);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("clickScene:").append(this.dZl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("switchWay:").append(this.dZm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91242);
    return localObject;
  }
  
  public final int getId()
  {
    return 17573;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ej
 * JD-Core Version:    0.7.0.1
 */