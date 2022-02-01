package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lt
  extends a
{
  public long iPe = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(149922);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iPe);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(149922);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(149923);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickScene:").append(this.iPe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149923);
    return localObject;
  }
  
  public final int getId()
  {
    return 16871;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.lt
 * JD-Core Version:    0.7.0.1
 */