package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ei
  extends a
{
  private long eCE;
  private long eCF;
  private String els = "";
  private long enl;
  private long ery;
  
  public final String abV()
  {
    AppMethodBeat.i(184186);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ery);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(184186);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(184187);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MessageType:").append(this.eCE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFloat:").append(this.eCF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.ery);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184187);
    return localObject;
  }
  
  public final ei afA()
  {
    this.eCF = 0L;
    return this;
  }
  
  public final ei afy()
  {
    this.eCE = 2L;
    return this;
  }
  
  public final ei afz()
  {
    this.enl = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 19251;
  }
  
  public final ei lS(long paramLong)
  {
    this.ery = paramLong;
    return this;
  }
  
  public final ei qV(String paramString)
  {
    AppMethodBeat.i(184185);
    this.els = x("sessionid", paramString, true);
    AppMethodBeat.o(184185);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ei
 * JD-Core Version:    0.7.0.1
 */