package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class by
  extends a
{
  private String dRJ = "";
  private long dTq;
  private long dWo;
  private long ece;
  private long ecf;
  
  public final String RC()
  {
    AppMethodBeat.i(184186);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ece);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWo);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(184186);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(184187);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.dRJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MessageType:").append(this.ece);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.dTq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFloat:").append(this.ecf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dWo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184187);
    return localObject;
  }
  
  public final by Su()
  {
    this.ece = 2L;
    return this;
  }
  
  public final by Sv()
  {
    this.dTq = 1L;
    return this;
  }
  
  public final by Sw()
  {
    this.ecf = 0L;
    return this;
  }
  
  public final int getId()
  {
    return 19251;
  }
  
  public final by hb(long paramLong)
  {
    this.dWo = paramLong;
    return this;
  }
  
  public final by ll(String paramString)
  {
    AppMethodBeat.i(184185);
    this.dRJ = t("sessionid", paramString, true);
    AppMethodBeat.o(184185);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.by
 * JD-Core Version:    0.7.0.1
 */