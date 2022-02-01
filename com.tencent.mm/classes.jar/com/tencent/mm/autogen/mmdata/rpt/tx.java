package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class tx
  extends a
{
  public long jvV = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(149951);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jvV);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(149951);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(149952);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.jvV);
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
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.tx
 * JD-Core Version:    0.7.0.1
 */