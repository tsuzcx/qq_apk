package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class he
  extends a
{
  public long dWW = 0L;
  public long etr = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(91241);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etr);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(91241);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(91242);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("clickScene:").append(this.dWW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("switchWay:").append(this.etr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91242);
    return localObject;
  }
  
  public final int getId()
  {
    return 17573;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.he
 * JD-Core Version:    0.7.0.1
 */