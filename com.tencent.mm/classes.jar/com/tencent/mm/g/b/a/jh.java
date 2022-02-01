package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jh
  extends a
{
  public long erT = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(149951);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erT);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(149951);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(149952);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.erT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149952);
    return localObject;
  }
  
  public final int getId()
  {
    return 17875;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jh
 * JD-Core Version:    0.7.0.1
 */