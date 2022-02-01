package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kb
  extends a
{
  public String iVn = "";
  public long ila;
  
  public final String aIE()
  {
    AppMethodBeat.i(368896);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVn);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368896);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368904);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionInfo:").append(this.iVn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368904);
    return localObject;
  }
  
  public final int getId()
  {
    return 24832;
  }
  
  public final kb sr(String paramString)
  {
    AppMethodBeat.i(368887);
    this.iVn = F("actionInfo", paramString, true);
    AppMethodBeat.o(368887);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.kb
 * JD-Core Version:    0.7.0.1
 */