package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gr
  extends a
{
  public long iFe;
  public String iLA = "";
  public long iLz;
  
  public final String aIE()
  {
    AppMethodBeat.i(369086);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iLz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLA);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369086);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369092);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("msgType:").append(this.iLz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionType:").append(this.iFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgId:").append(this.iLA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369092);
    return localObject;
  }
  
  public final int getId()
  {
    return 20849;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.gr
 * JD-Core Version:    0.7.0.1
 */