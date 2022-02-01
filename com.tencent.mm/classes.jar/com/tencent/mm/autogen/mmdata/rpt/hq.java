package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hq
  extends a
{
  public long iOO = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(63299);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iOO);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(63299);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(63300);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("reportScene:").append(this.iOO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(63300);
    return localObject;
  }
  
  public final int getId()
  {
    return 18526;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.hq
 * JD-Core Version:    0.7.0.1
 */