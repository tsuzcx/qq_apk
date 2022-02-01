package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bi
  extends a
{
  public long ila;
  public String ioS = "";
  public long irf;
  
  public final String aIE()
  {
    AppMethodBeat.i(368888);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ioS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irf);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368888);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368897);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomUsername:").append(this.ioS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserRole:").append(this.irf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368897);
    return localObject;
  }
  
  public final int getId()
  {
    return 24182;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.bi
 * JD-Core Version:    0.7.0.1
 */