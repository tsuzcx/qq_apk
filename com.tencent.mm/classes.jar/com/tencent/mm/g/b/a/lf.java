package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lf
  extends a
{
  public long ejA = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(149949);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejA);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(149949);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(149950);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149950);
    return localObject;
  }
  
  public final int getId()
  {
    return 18278;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.lf
 * JD-Core Version:    0.7.0.1
 */