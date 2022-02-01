package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hg
  extends a
{
  public String iNB = "";
  public long iNC;
  public long iND;
  public int iNE;
  public int iNF;
  public int iNG;
  public int iNH = 0;
  public int iNI = 0;
  
  public final String aIE()
  {
    AppMethodBeat.i(369036);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iNB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iND);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNI);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369036);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369043);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.iNB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterTime:").append(this.iNC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitTime:").append(this.iND);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasClickedPlus:").append(this.iNE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasClickedMinus:").append(this.iNF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasConfirmedChanges:").append(this.iNG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterFollowCount:").append(this.iNH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitFollowCount:").append(this.iNI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369043);
    return localObject;
  }
  
  public final int getId()
  {
    return 20247;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.hg
 * JD-Core Version:    0.7.0.1
 */