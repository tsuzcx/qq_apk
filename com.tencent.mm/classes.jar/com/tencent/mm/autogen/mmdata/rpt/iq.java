package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iq
  extends a
{
  public long iPK;
  private String iQv = "";
  public long iQw;
  public long ioV = 0L;
  public long ipl;
  
  public final String aIE()
  {
    AppMethodBeat.i(368729);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQw);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368729);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368735);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionName:").append(this.iQv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadCount:").append(this.ipl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionType:").append(this.iPK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasEduWindow:").append(this.iQw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368735);
    return localObject;
  }
  
  public final int getId()
  {
    return 11090;
  }
  
  public final iq rT(String paramString)
  {
    AppMethodBeat.i(368721);
    this.iQv = F("SessionName", paramString, true);
    AppMethodBeat.o(368721);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.iq
 * JD-Core Version:    0.7.0.1
 */