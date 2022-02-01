package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class rg
  extends a
{
  public long iUz = 0L;
  public long jvA = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(369158);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iUz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvA);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369158);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369164);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OpType:").append(this.iUz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Success:").append(this.jvA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369164);
    return localObject;
  }
  
  public final int getId()
  {
    return 13071;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.rg
 * JD-Core Version:    0.7.0.1
 */