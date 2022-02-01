package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qd
  extends a
{
  public int iLt = -1;
  public int jqj = 0;
  
  public final String aIE()
  {
    AppMethodBeat.i(369026);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jqj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLt);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369026);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369034);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("configId:").append(this.jqj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("result:").append(this.iLt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369034);
    return localObject;
  }
  
  public final int getId()
  {
    return 20151;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.qd
 * JD-Core Version:    0.7.0.1
 */