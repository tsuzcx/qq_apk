package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gi
  extends a
{
  public long iKS = 0L;
  public long ila = 0L;
  public long ixD = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(367970);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ixD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKS);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367970);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367975);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("type:").append(this.ixD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasReddot:").append(this.iKS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367975);
    return localObject;
  }
  
  public final int getId()
  {
    return 20673;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.gi
 * JD-Core Version:    0.7.0.1
 */