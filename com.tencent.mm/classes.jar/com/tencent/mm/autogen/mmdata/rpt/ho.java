package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ho
  extends a
{
  public long iOH;
  public long iOI;
  private String iOJ = "";
  public long ikE;
  private String imN = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369297);
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
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369297);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369303);
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
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369303);
    return localObject;
  }
  
  public final int getId()
  {
    return 22469;
  }
  
  public final ho rD(String paramString)
  {
    AppMethodBeat.i(369285);
    this.imN = F("ChatName", paramString, true);
    AppMethodBeat.o(369285);
    return this;
  }
  
  public final ho rE(String paramString)
  {
    AppMethodBeat.i(369288);
    this.iOJ = F("LiveIDList", paramString, true);
    AppMethodBeat.o(369288);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ho
 * JD-Core Version:    0.7.0.1
 */