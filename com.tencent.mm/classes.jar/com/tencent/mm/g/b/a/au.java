package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class au
  extends a
{
  public long dMP;
  public long dMQ = 0L;
  public long dMR = 0L;
  public long dMS = 0L;
  public long dMT;
  private String dMU = "";
  public long dMV;
  
  public final String PV()
  {
    AppMethodBeat.i(192595);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dMP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMV);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(192595);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(192596);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RecomdCount:").append(this.dMP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickMore:").append(this.dMQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecomdSelect:").append(this.dMR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OtherSelect:").append(this.dMS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitType:").append(this.dMT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TicketId:").append(this.dMU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OtherCount:").append(this.dMV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(192596);
    return localObject;
  }
  
  public final int getId()
  {
    return 19450;
  }
  
  public final au hL(String paramString)
  {
    AppMethodBeat.i(192594);
    this.dMU = t("TicketId", paramString, true);
    AppMethodBeat.o(192594);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.au
 * JD-Core Version:    0.7.0.1
 */