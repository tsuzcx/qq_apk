package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class li
  extends a
{
  public String iZO = "";
  public String iZP = "";
  public long ila;
  
  public final String aIE()
  {
    AppMethodBeat.i(368152);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iZO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ila);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368152);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368156);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomID:").append(this.iZO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("oldRoomID:").append(this.iZP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ila);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368156);
    return localObject;
  }
  
  public final int getId()
  {
    return 20246;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.li
 * JD-Core Version:    0.7.0.1
 */