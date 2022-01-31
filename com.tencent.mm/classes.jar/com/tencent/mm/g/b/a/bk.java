package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bk
  extends a
{
  public long cRG = 0L;
  public long cRH = 0L;
  public long cXx = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(77607);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cRG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cRH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXx);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(77607);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(77608);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.cRG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.cRH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Status:").append(this.cXx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(77608);
    return localObject;
  }
  
  public final int getId()
  {
    return 16440;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bk
 * JD-Core Version:    0.7.0.1
 */