package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jx
  extends a
{
  public long iPC;
  public long iUN;
  
  public final String aIE()
  {
    AppMethodBeat.i(368946);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iUN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPC);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368946);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368951);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OperationObject:").append(this.iUN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperationType:").append(this.iPC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368951);
    return localObject;
  }
  
  public final int getId()
  {
    return 21626;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.jx
 * JD-Core Version:    0.7.0.1
 */