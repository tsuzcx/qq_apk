package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class av
  extends a
{
  public long dMW = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(149907);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dMW);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(149907);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(149908);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickScene:").append(this.dMW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149908);
    return localObject;
  }
  
  public final int getId()
  {
    return 16722;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.av
 * JD-Core Version:    0.7.0.1
 */