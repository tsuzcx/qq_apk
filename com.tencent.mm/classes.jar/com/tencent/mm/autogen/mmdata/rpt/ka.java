package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ka
  extends a
{
  public long iNl;
  private long iVl;
  public String iVm = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368876);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iVl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVm);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368876);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368883);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.iVl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatType:").append(this.iNl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatNameStr:").append(this.iVm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368883);
    return localObject;
  }
  
  public final int getId()
  {
    return 22335;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ka
 * JD-Core Version:    0.7.0.1
 */