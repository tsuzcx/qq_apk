package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bj
  extends a
{
  public long cRH = 0L;
  public long cXw = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(73676);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cXw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cRH);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(73676);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(73677);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ThirdAppType:").append(this.cXw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.cRH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(73677);
    return localObject;
  }
  
  public final int getId()
  {
    return 16996;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bj
 * JD-Core Version:    0.7.0.1
 */