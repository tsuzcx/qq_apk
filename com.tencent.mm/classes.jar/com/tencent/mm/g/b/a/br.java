package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class br
  extends a
{
  public long dMW = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(149926);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dMW);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(149926);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(149927);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickScene:").append(this.dMW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149927);
    return localObject;
  }
  
  public final int getId()
  {
    return 16867;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.br
 * JD-Core Version:    0.7.0.1
 */