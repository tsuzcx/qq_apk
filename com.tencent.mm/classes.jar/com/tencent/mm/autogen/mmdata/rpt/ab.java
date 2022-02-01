package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ab
  extends a
{
  public long ikE;
  public String imN = "";
  public long imY;
  public long imZ;
  public long ina;
  public long inb;
  
  public final String aIE()
  {
    AppMethodBeat.i(368674);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ina);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inb);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368674);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368679);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.imN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.imY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberCount:").append(this.imZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("abcClickCount:").append(this.ina);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasSearch:").append(this.inb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368679);
    return localObject;
  }
  
  public final int getId()
  {
    return 22597;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ab
 * JD-Core Version:    0.7.0.1
 */