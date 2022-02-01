package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hn
  extends a
{
  public long iOH;
  public long iOI;
  private String iOJ = "";
  public long iOK;
  public long ikE;
  private String imN = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369290);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOK);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369290);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369298);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.imN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReddotType:").append(this.iOH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTs:").append(this.iOI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LiveIDList:").append(this.iOJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatRoomIsMute:").append(this.iOK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369298);
    return localObject;
  }
  
  public final int getId()
  {
    return 21799;
  }
  
  public final hn rB(String paramString)
  {
    AppMethodBeat.i(369279);
    this.imN = F("ChatName", paramString, true);
    AppMethodBeat.o(369279);
    return this;
  }
  
  public final hn rC(String paramString)
  {
    AppMethodBeat.i(369286);
    this.iOJ = F("LiveIDList", paramString, true);
    AppMethodBeat.o(369286);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.hn
 * JD-Core Version:    0.7.0.1
 */