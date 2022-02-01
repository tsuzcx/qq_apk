package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class av
  extends a
{
  public int ipH;
  
  public final String aIE()
  {
    AppMethodBeat.i(63295);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ipH);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(63295);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(63296);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.ipH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(63296);
    return localObject;
  }
  
  public final int getId()
  {
    return 18884;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.av
 * JD-Core Version:    0.7.0.1
 */