package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class rt
  extends a
{
  public long ikE = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(149949);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ikE);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(149949);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(149950);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149950);
    return localObject;
  }
  
  public final int getId()
  {
    return 18278;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.rt
 * JD-Core Version:    0.7.0.1
 */