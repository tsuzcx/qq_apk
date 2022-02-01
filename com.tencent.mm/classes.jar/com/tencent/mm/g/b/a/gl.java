package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gl
  extends a
{
  public long dZv = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(149951);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZv);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(149951);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(149952);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.dZv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149952);
    return localObject;
  }
  
  public final int getId()
  {
    return 17875;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gl
 * JD-Core Version:    0.7.0.1
 */