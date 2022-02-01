package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eh
  extends a
{
  private String gcU = "";
  private String gcV = "";
  private String gcW = "";
  private long gcY;
  private String gcZ = "";
  private long gda;
  private long gjl;
  
  public final String agH()
  {
    AppMethodBeat.i(209240);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gda);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209240);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209242);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.gcV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderContexId:").append(this.gcW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.gjl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventCode:").append(this.gcY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTime:").append(this.gcZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTarget:").append(this.gda);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209242);
    return localObject;
  }
  
  public final int getId()
  {
    return 21923;
  }
  
  public final eh lo(long paramLong)
  {
    this.gjl = paramLong;
    return this;
  }
  
  public final eh lp(long paramLong)
  {
    this.gcY = paramLong;
    return this;
  }
  
  public final eh lq(long paramLong)
  {
    this.gda = paramLong;
    return this;
  }
  
  public final eh rW(String paramString)
  {
    AppMethodBeat.i(209233);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(209233);
    return this;
  }
  
  public final eh rX(String paramString)
  {
    AppMethodBeat.i(209234);
    this.gcV = z("ClickTabContextid", paramString, true);
    AppMethodBeat.o(209234);
    return this;
  }
  
  public final eh rY(String paramString)
  {
    AppMethodBeat.i(209235);
    this.gcW = z("FinderContexId", paramString, true);
    AppMethodBeat.o(209235);
    return this;
  }
  
  public final eh rZ(String paramString)
  {
    AppMethodBeat.i(209237);
    this.gcZ = z("EventTime", paramString, true);
    AppMethodBeat.o(209237);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.eh
 * JD-Core Version:    0.7.0.1
 */