package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class al
  extends a
{
  private String dFJ;
  private long dHq;
  private long dLP;
  private long dLQ;
  private long dkQ;
  
  public final String PV()
  {
    AppMethodBeat.i(184186);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dkQ);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(184186);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(184187);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.dFJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MessageType:").append(this.dLP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.dHq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFloat:").append(this.dLQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dkQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184187);
    return localObject;
  }
  
  public final al dP(long paramLong)
  {
    this.dLP = paramLong;
    return this;
  }
  
  public final al dQ(long paramLong)
  {
    this.dHq = paramLong;
    return this;
  }
  
  public final al dR(long paramLong)
  {
    this.dLQ = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19251;
  }
  
  public final al hx(String paramString)
  {
    AppMethodBeat.i(184185);
    this.dFJ = t("sessionid", paramString, true);
    AppMethodBeat.o(184185);
    return this;
  }
  
  public final al zr(long paramLong)
  {
    this.dkQ = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.al
 * JD-Core Version:    0.7.0.1
 */