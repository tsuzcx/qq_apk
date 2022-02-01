package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gh
  extends a
{
  public long ikE;
  public long ixB;
  
  public final String aIE()
  {
    AppMethodBeat.i(367967);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ixB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367967);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367973);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Type:").append(this.ixB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367973);
    return localObject;
  }
  
  public final int getId()
  {
    return 19952;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.gh
 * JD-Core Version:    0.7.0.1
 */