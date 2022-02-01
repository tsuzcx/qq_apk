package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class by
  extends a
{
  private String dQt;
  private long dSa;
  private long dUY;
  private long eaJ;
  private long eaK;
  
  public final String RD()
  {
    AppMethodBeat.i(184186);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUY);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(184186);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(184187);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.dQt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MessageType:").append(this.eaJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.dSa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFloat:").append(this.eaK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dUY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184187);
    return localObject;
  }
  
  public final by Sw()
  {
    this.eaJ = 2L;
    return this;
  }
  
  public final by Sx()
  {
    this.dSa = 1L;
    return this;
  }
  
  public final by Sy()
  {
    this.eaK = 0L;
    return this;
  }
  
  public final by gW(long paramLong)
  {
    this.dUY = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19251;
  }
  
  public final by kY(String paramString)
  {
    AppMethodBeat.i(184185);
    this.dQt = t("sessionid", paramString, true);
    AppMethodBeat.o(184185);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.by
 * JD-Core Version:    0.7.0.1
 */