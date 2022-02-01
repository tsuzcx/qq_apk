package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ec
  extends a
{
  public long iBW;
  public long iBX;
  
  public final String aIE()
  {
    AppMethodBeat.i(368315);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iBW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBX);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368315);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368324);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("isOnDawang:").append(this.iBW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("netType:").append(this.iBX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368324);
    return localObject;
  }
  
  public final int getId()
  {
    return 22554;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ec
 * JD-Core Version:    0.7.0.1
 */