package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class if
  extends a
{
  private long gGt;
  private long gHW;
  private long gHX;
  private long gHY;
  private long gef;
  private String gjj = "";
  private long gnP;
  private long gsB;
  
  public final String agH()
  {
    AppMethodBeat.i(248534);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gGt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHY);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(248534);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(248535);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.gjj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserAction:").append(this.gHW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FullScreen:").append(this.gGt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TaskCount:").append(this.gHX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Duration:").append(this.gsB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterChatting:").append(this.gHY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(248535);
    return localObject;
  }
  
  public final int getId()
  {
    return 21920;
  }
  
  public final if sC(long paramLong)
  {
    this.gef = paramLong;
    return this;
  }
  
  public final if sD(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final if sE(long paramLong)
  {
    this.gHW = paramLong;
    return this;
  }
  
  public final if sF(long paramLong)
  {
    this.gGt = paramLong;
    return this;
  }
  
  public final if sG(long paramLong)
  {
    this.gHX = paramLong;
    return this;
  }
  
  public final if sH(long paramLong)
  {
    this.gsB = paramLong;
    return this;
  }
  
  public final if sI(long paramLong)
  {
    this.gHY = paramLong;
    return this;
  }
  
  public final if xO(String paramString)
  {
    AppMethodBeat.i(248531);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(248531);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.if
 * JD-Core Version:    0.7.0.1
 */