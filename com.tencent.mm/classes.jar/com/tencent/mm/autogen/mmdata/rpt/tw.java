package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class tw
  extends a
{
  public long jvV = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(368264);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jvV);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368264);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368269);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.jvV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368269);
    return localObject;
  }
  
  public final int getId()
  {
    return 19540;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.tw
 * JD-Core Version:    0.7.0.1
 */