package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hv
  extends a
{
  public long iPe = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(149907);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iPe);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(149907);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(149908);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickScene:").append(this.iPe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149908);
    return localObject;
  }
  
  public final int getId()
  {
    return 16722;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.hv
 * JD-Core Version:    0.7.0.1
 */