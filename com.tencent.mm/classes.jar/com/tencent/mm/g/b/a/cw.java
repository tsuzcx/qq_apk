package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cw
  extends a
{
  private long dWm;
  private long eeW = 0L;
  private String eeu = "";
  private long eew;
  
  public final String RC()
  {
    AppMethodBeat.i(215514);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eew);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(215514);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(215515);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dWm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.eeu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reddot:").append(this.eeW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.eew);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(215515);
    return localObject;
  }
  
  public final cw SX()
  {
    this.dWm = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 19887;
  }
  
  public final cw iQ(long paramLong)
  {
    this.eew = paramLong;
    return this;
  }
  
  public final cw ms(String paramString)
  {
    AppMethodBeat.i(215513);
    this.eeu = t("roomid", paramString, true);
    AppMethodBeat.o(215513);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cw
 * JD-Core Version:    0.7.0.1
 */