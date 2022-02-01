package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class rj
  extends a
{
  public long iyh = 0L;
  public long jvM = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(91241);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iyh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvM);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(91241);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(91242);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("clickScene:").append(this.iyh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("switchWay:").append(this.jvM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91242);
    return localObject;
  }
  
  public final int getId()
  {
    return 17573;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.rj
 * JD-Core Version:    0.7.0.1
 */