package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ji
  extends a
{
  public String imN = "";
  public long imY;
  public long imZ;
  
  public final String aIE()
  {
    AppMethodBeat.i(368555);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imZ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368555);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368562);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.imN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.imY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberCount:").append(this.imZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368562);
    return localObject;
  }
  
  public final int getId()
  {
    return 22595;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ji
 * JD-Core Version:    0.7.0.1
 */