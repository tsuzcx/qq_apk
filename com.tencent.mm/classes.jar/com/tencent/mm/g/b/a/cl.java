package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cl
  extends a
{
  public long eea;
  public long eeb = 0L;
  public long eec = 0L;
  public long eed = 0L;
  public long eee;
  private String eef = "";
  public long eeg;
  
  public final String RC()
  {
    AppMethodBeat.i(209881);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eea);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eec);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eed);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eee);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeg);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(209881);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(209882);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RecomdCount:").append(this.eea);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickMore:").append(this.eeb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecomdSelect:").append(this.eec);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OtherSelect:").append(this.eed);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitType:").append(this.eee);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TicketId:").append(this.eef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OtherCount:").append(this.eeg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209882);
    return localObject;
  }
  
  public final int getId()
  {
    return 19450;
  }
  
  public final cl mc(String paramString)
  {
    AppMethodBeat.i(209880);
    this.eef = t("TicketId", paramString, true);
    AppMethodBeat.o(209880);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cl
 * JD-Core Version:    0.7.0.1
 */