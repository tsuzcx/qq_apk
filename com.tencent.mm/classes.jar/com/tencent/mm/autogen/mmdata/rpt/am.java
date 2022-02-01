package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class am
  extends a
{
  public long ila;
  private String ioS = "";
  public long ioT;
  
  public final String aIE()
  {
    AppMethodBeat.i(368545);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ioS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioT);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368545);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368550);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomUsername:").append(this.ioS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openStatus:").append(this.ioT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368550);
    return localObject;
  }
  
  public final int getId()
  {
    return 24200;
  }
  
  public final am kB(String paramString)
  {
    AppMethodBeat.i(368540);
    this.ioS = F("roomUsername", paramString, true);
    AppMethodBeat.o(368540);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.am
 * JD-Core Version:    0.7.0.1
 */