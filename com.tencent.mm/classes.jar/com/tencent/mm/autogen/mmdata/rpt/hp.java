package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hp
  extends a
{
  public long iOI;
  public long iOL;
  public String iOM = "";
  public int iON;
  public long ikE;
  public String imN = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369294);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iON);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369294);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369302);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.imN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LivesCnt:").append(this.iOL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionToLiveId:").append(this.iOM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTs:").append(this.iOI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsReddotShining:").append(this.iON);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369302);
    return localObject;
  }
  
  public final int getId()
  {
    return 21876;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.hp
 * JD-Core Version:    0.7.0.1
 */