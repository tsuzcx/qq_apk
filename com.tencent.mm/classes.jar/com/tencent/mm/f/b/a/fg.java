package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fg
  extends a
{
  private String ggA = "";
  private long giq;
  private long gjl;
  private long gzq;
  private long gzr;
  
  public final String agH()
  {
    AppMethodBeat.i(184186);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjl);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(184186);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(184187);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MessageType:").append(this.gzq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFloat:").append(this.gzr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.gjl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184187);
    return localObject;
  }
  
  public final fg akx()
  {
    this.gzq = 2L;
    return this;
  }
  
  public final fg aky()
  {
    this.giq = 1L;
    return this;
  }
  
  public final fg akz()
  {
    this.gzr = 0L;
    return this;
  }
  
  public final int getId()
  {
    return 19251;
  }
  
  public final fg nf(long paramLong)
  {
    this.gjl = paramLong;
    return this;
  }
  
  public final fg tZ(String paramString)
  {
    AppMethodBeat.i(184185);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(184185);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.fg
 * JD-Core Version:    0.7.0.1
 */