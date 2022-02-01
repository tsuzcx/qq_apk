package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bu
  extends a
{
  public long dNq;
  public long dNr = 0L;
  public long dNs = 0L;
  public long dNt = 0L;
  public long dNu;
  private String dNv = "";
  public long dNw;
  
  public final String PR()
  {
    AppMethodBeat.i(209956);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dNq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNw);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(209956);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(209957);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RecomdCount:").append(this.dNq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickMore:").append(this.dNr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecomdSelect:").append(this.dNs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OtherSelect:").append(this.dNt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitType:").append(this.dNu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TicketId:").append(this.dNv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OtherCount:").append(this.dNw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209957);
    return localObject;
  }
  
  public final int getId()
  {
    return 19450;
  }
  
  public final bu jP(String paramString)
  {
    AppMethodBeat.i(209955);
    this.dNv = t("TicketId", paramString, true);
    AppMethodBeat.o(209955);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bu
 * JD-Core Version:    0.7.0.1
 */