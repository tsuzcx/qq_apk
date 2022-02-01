package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lc
  extends a
{
  public int iYK;
  private String iYL = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368254);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iYK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYL);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368254);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368260);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Type:").append(this.iYK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VoiceID:").append(this.iYL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368260);
    return localObject;
  }
  
  public final int getId()
  {
    return 20551;
  }
  
  public final lc tZ(String paramString)
  {
    AppMethodBeat.i(368250);
    this.iYL = F("VoiceID", paramString, true);
    AppMethodBeat.o(368250);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.lc
 * JD-Core Version:    0.7.0.1
 */