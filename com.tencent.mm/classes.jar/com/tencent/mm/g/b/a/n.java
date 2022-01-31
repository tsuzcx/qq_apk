package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class n
  extends a
{
  public long cRI = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(77582);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cRI);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(77582);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(77583);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickScene:").append(this.cRI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(77583);
    return localObject;
  }
  
  public final int getId()
  {
    return 16722;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.n
 * JD-Core Version:    0.7.0.1
 */