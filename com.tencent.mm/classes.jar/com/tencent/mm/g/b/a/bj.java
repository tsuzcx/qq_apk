package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bj
  extends a
{
  private String dDw;
  private long dFd;
  private long dHT;
  private long dLZ;
  private long dMa;
  
  public final String PR()
  {
    AppMethodBeat.i(184186);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dDw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHT);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(184186);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(184187);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.dDw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MessageType:").append(this.dLZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.dFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFloat:").append(this.dMa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dHT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184187);
    return localObject;
  }
  
  public final bj fA(long paramLong)
  {
    this.dLZ = paramLong;
    return this;
  }
  
  public final bj fB(long paramLong)
  {
    this.dFd = paramLong;
    return this;
  }
  
  public final bj fC(long paramLong)
  {
    this.dMa = paramLong;
    return this;
  }
  
  public final bj fD(long paramLong)
  {
    this.dHT = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19251;
  }
  
  public final bj jl(String paramString)
  {
    AppMethodBeat.i(184185);
    this.dDw = t("sessionid", paramString, true);
    AppMethodBeat.o(184185);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bj
 * JD-Core Version:    0.7.0.1
 */