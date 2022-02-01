package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bh
  extends a
{
  public long ijh;
  public long ila;
  public String ioS = "";
  public long ire;
  
  public final String aIE()
  {
    AppMethodBeat.i(368890);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ioS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ire);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijh);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368890);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368899);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomUsername:").append(this.ioS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("memberCount:").append(this.ire);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errCode:").append(this.ijh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368899);
    return localObject;
  }
  
  public final int getId()
  {
    return 24180;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.bh
 * JD-Core Version:    0.7.0.1
 */