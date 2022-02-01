package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pz
  extends a
{
  public long ikE;
  public long jpU;
  
  public final String aIE()
  {
    AppMethodBeat.i(369061);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jpU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369061);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369068);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("TopCount:").append(this.jpU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369068);
    return localObject;
  }
  
  public final int getId()
  {
    return 23511;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.pz
 * JD-Core Version:    0.7.0.1
 */