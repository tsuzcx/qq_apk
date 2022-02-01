package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fu
  extends a
{
  private long ekr = 0L;
  private long enx = 0L;
  private long eny = 0L;
  private long enz = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(118488);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eny);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enz);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(118488);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(118489);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExposeViewId:").append(this.enx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickClearCount:").append(this.ekr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickRenewCount:").append(this.eny);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfDeleteVideo:").append(this.enz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118489);
    return localObject;
  }
  
  public final long TA()
  {
    return this.ekr;
  }
  
  public final long TB()
  {
    return this.eny;
  }
  
  public final int getId()
  {
    return 16913;
  }
  
  public final fu kX(long paramLong)
  {
    this.enx = paramLong;
    return this;
  }
  
  public final fu kY(long paramLong)
  {
    this.ekr = paramLong;
    return this;
  }
  
  public final fu kZ(long paramLong)
  {
    this.eny = paramLong;
    return this;
  }
  
  public final fu la(long paramLong)
  {
    this.enz = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fu
 * JD-Core Version:    0.7.0.1
 */