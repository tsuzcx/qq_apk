package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ey
  extends a
{
  private String ijk = "";
  public long ikE;
  
  public final String aIE()
  {
    AppMethodBeat.i(367795);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367795);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367801);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367801);
    return localObject;
  }
  
  public final int getId()
  {
    return 19954;
  }
  
  public final ey pw(String paramString)
  {
    AppMethodBeat.i(367788);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(367788);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ey
 * JD-Core Version:    0.7.0.1
 */