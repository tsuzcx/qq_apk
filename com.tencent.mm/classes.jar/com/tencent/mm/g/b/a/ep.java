package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ep
  extends a
{
  public long dKe = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(149942);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKe);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(149942);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(149943);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149943);
    return localObject;
  }
  
  public final int getId()
  {
    return 18564;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ep
 * JD-Core Version:    0.7.0.1
 */