package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ac
  extends a
{
  public long cRI = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(77602);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cRI);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(77602);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(77603);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickScene:").append(this.cRI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(77603);
    return localObject;
  }
  
  public final int getId()
  {
    return 16867;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ac
 * JD-Core Version:    0.7.0.1
 */