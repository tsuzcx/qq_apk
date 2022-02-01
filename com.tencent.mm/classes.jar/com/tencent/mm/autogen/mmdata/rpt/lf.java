package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lf
  extends a
{
  private String iZE = "";
  public long iuA = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(149913);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iZE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuA);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(149913);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(149914);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("chatRoomUserName:").append(this.iZE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149914);
    return localObject;
  }
  
  public final int getId()
  {
    return 15848;
  }
  
  public final lf uc(String paramString)
  {
    AppMethodBeat.i(149912);
    this.iZE = F("chatRoomUserName", paramString, true);
    AppMethodBeat.o(149912);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.lf
 * JD-Core Version:    0.7.0.1
 */