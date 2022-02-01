package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ez
  extends a
{
  public long iFe;
  public long iGn;
  public long iGo;
  
  public final String aIE()
  {
    AppMethodBeat.i(367792);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iGn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGo);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367792);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367799);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("identity:").append(this.iGn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionType:").append(this.iFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("notificationType:").append(this.iGo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367799);
    return localObject;
  }
  
  public final int getId()
  {
    return 22554;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ez
 * JD-Core Version:    0.7.0.1
 */