package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class io
  extends a
{
  public int ivK;
  
  public final String aIE()
  {
    AppMethodBeat.i(369180);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ivK);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369180);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369187);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ErrorType:").append(this.ivK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369187);
    return localObject;
  }
  
  public final int getId()
  {
    return 25017;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.io
 * JD-Core Version:    0.7.0.1
 */