package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hz
  extends a
{
  public int iHU = 0;
  public int iPp = 0;
  public int ipH = 0;
  
  public final String aIE()
  {
    AppMethodBeat.i(369233);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ipH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iHU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPp);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369233);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369239);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.ipH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.iHU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsJoinCollectData:").append(this.iPp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369239);
    return localObject;
  }
  
  public final int getId()
  {
    return 21764;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.hz
 * JD-Core Version:    0.7.0.1
 */