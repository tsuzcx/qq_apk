package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class rp
  extends a
{
  public long iqr = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(149942);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqr);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(149942);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(149943);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149943);
    return localObject;
  }
  
  public final int getId()
  {
    return 18564;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.rp
 * JD-Core Version:    0.7.0.1
 */