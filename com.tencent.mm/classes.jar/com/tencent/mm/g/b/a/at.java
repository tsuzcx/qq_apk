package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class at
  extends a
{
  public long dMJ;
  public long dMK = 0L;
  public long dML = 0L;
  public long dMM = 0L;
  public String dMN = "";
  public String dMO = "";
  
  public final String PV()
  {
    AppMethodBeat.i(192592);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dMJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dML);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMO);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(192592);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(192593);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RecomdSuccess:").append(this.dMJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecomdFail:").append(this.dMK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("otherSuccess:").append(this.dML);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("otherFail:").append(this.dMM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sucRoomList:").append(this.dMN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ticketId:").append(this.dMO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(192593);
    return localObject;
  }
  
  public final int getId()
  {
    return 19451;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.at
 * JD-Core Version:    0.7.0.1
 */