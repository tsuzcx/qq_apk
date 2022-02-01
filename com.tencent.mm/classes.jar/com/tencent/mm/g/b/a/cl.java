package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cl
  extends a
{
  public long ecF;
  public long ecG = 0L;
  public long ecH = 0L;
  public long ecI = 0L;
  public long ecJ;
  private String ecK = "";
  public long ecL;
  
  public final String RD()
  {
    AppMethodBeat.i(219241);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecL);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(219241);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(219242);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RecomdCount:").append(this.ecF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickMore:").append(this.ecG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecomdSelect:").append(this.ecH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OtherSelect:").append(this.ecI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitType:").append(this.ecJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TicketId:").append(this.ecK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OtherCount:").append(this.ecL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(219242);
    return localObject;
  }
  
  public final int getId()
  {
    return 19450;
  }
  
  public final cl lL(String paramString)
  {
    AppMethodBeat.i(219240);
    this.ecK = t("TicketId", paramString, true);
    AppMethodBeat.o(219240);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cl
 * JD-Core Version:    0.7.0.1
 */