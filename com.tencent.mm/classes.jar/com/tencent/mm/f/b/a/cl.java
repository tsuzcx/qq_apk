package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cl
  extends a
{
  private String gjj = "";
  private String gjk = "";
  private long gjl;
  private String gpZ = "";
  
  public final String agH()
  {
    AppMethodBeat.i(209216);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gpZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjj);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209216);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209217);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("feedID:").append(this.gpZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.gjl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.gjk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.gjj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209217);
    return localObject;
  }
  
  public final cl fx(long paramLong)
  {
    this.gjl = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21726;
  }
  
  public final cl mx(String paramString)
  {
    AppMethodBeat.i(209213);
    this.gpZ = z("feedID", paramString, true);
    AppMethodBeat.o(209213);
    return this;
  }
  
  public final cl my(String paramString)
  {
    AppMethodBeat.i(209214);
    this.gjk = z("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209214);
    return this;
  }
  
  public final cl mz(String paramString)
  {
    AppMethodBeat.i(209215);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(209215);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.cl
 * JD-Core Version:    0.7.0.1
 */