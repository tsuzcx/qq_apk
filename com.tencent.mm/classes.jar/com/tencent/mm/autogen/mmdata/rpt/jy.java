package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jy
  extends a
{
  public long iUO;
  public long iUP;
  public long ila;
  private String inx = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368961);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUP);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368961);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368966);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errortype:").append(this.iUO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pageid:").append(this.iUP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368966);
    return localObject;
  }
  
  public final int getId()
  {
    return 19818;
  }
  
  public final jy sq(String paramString)
  {
    AppMethodBeat.i(368956);
    this.inx = F("sessionid", paramString, true);
    AppMethodBeat.o(368956);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.jy
 * JD-Core Version:    0.7.0.1
 */