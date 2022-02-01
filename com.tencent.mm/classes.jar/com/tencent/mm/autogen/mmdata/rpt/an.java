package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class an
  extends a
{
  public long ila;
  public long ioU;
  
  public final String aIE()
  {
    AppMethodBeat.i(368544);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioU);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368544);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368549);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("redType:").append(this.ioU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368549);
    return localObject;
  }
  
  public final int getId()
  {
    return 24201;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.an
 * JD-Core Version:    0.7.0.1
 */