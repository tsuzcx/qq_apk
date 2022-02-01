package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hm
  extends a
{
  public long dPl = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(149949);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dPl);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(149949);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(149950);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dPl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149950);
    return localObject;
  }
  
  public final int getId()
  {
    return 18278;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hm
 * JD-Core Version:    0.7.0.1
 */