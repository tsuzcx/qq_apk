package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class if
  extends a
{
  public int iPH;
  public int iPf;
  public int ipH;
  
  public final String aIE()
  {
    AppMethodBeat.i(369211);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ipH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPH);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369211);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369214);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.ipH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionScene:").append(this.iPf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageType:").append(this.iPH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369214);
    return localObject;
  }
  
  public final int getId()
  {
    return 21769;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.if
 * JD-Core Version:    0.7.0.1
 */