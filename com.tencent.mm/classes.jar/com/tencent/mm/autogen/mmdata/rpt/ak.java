package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ak
  extends a
{
  public long ikE;
  
  public final String aIE()
  {
    AppMethodBeat.i(368604);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ikE);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368604);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368610);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368610);
    return localObject;
  }
  
  public final int getId()
  {
    return 24113;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ak
 * JD-Core Version:    0.7.0.1
 */