package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ew
  extends a
{
  public long eEB;
  public long eEC = 0L;
  public long eED = 0L;
  public long eEE = 0L;
  private String eEF = "";
  public long eEG;
  public long ewL;
  
  public final String abV()
  {
    AppMethodBeat.i(194517);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eEB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eED);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEG);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(194517);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(194518);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RecomdCount:").append(this.eEB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickMore:").append(this.eEC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecomdSelect:").append(this.eED);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OtherSelect:").append(this.eEE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitType:").append(this.ewL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TicketId:").append(this.eEF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OtherCount:").append(this.eEG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194518);
    return localObject;
  }
  
  public final int getId()
  {
    return 19450;
  }
  
  public final ew rT(String paramString)
  {
    AppMethodBeat.i(194516);
    this.eEF = x("TicketId", paramString, true);
    AppMethodBeat.o(194516);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ew
 * JD-Core Version:    0.7.0.1
 */