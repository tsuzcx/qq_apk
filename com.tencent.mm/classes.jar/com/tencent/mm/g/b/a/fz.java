package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fz
  extends a
{
  public long ebd = 0L;
  public long ebe = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(91241);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ebd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebe);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(91241);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(91242);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("clickScene:").append(this.ebd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("switchWay:").append(this.ebe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91242);
    return localObject;
  }
  
  public final int getId()
  {
    return 17573;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fz
 * JD-Core Version:    0.7.0.1
 */