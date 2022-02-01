package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ht
  extends a
{
  public long iOS;
  public long iOT = 0L;
  public long iOU = 0L;
  public long iOV = 0L;
  public String iOW = "";
  public String iOX = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369276);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iOS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOX);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369276);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369281);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RecomdSuccess:").append(this.iOS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecomdFail:").append(this.iOT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("otherSuccess:").append(this.iOU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("otherFail:").append(this.iOV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sucRoomList:").append(this.iOW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ticketId:").append(this.iOX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369281);
    return localObject;
  }
  
  public final int getId()
  {
    return 19451;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ht
 * JD-Core Version:    0.7.0.1
 */