package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hs
  extends a
{
  private String iOP = "";
  public long iOR;
  
  public final String aIE()
  {
    AppMethodBeat.i(184630);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iOP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOR);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(184630);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(184631);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Roomid:").append(this.iOP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrCode:").append(this.iOR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184631);
    return localObject;
  }
  
  public final int getId()
  {
    return 19352;
  }
  
  public final hs rG(String paramString)
  {
    AppMethodBeat.i(184629);
    this.iOP = F("Roomid", paramString, true);
    AppMethodBeat.o(184629);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.hs
 * JD-Core Version:    0.7.0.1
 */