package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qx
  extends a
{
  public long iWR;
  public long ila;
  public long ixD;
  
  public final String aIE()
  {
    AppMethodBeat.i(369216);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixD);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369216);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369221);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomkey:").append(this.iWR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.ixD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369221);
    return localObject;
  }
  
  public final int getId()
  {
    return 23523;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.qx
 * JD-Core Version:    0.7.0.1
 */