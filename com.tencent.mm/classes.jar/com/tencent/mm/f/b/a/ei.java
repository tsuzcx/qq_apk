package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ei
  extends a
{
  private String gcU = "";
  private long gef;
  private String gjj = "";
  private String gjk = "";
  private long gjl;
  private String gjw = "";
  private String gqd = "";
  
  public final String agH()
  {
    AppMethodBeat.i(208205);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjl);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208205);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208207);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.gqd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Feedid:").append(this.gjw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.gjj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.gjk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.gjl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208207);
    return localObject;
  }
  
  public final int getId()
  {
    return 19956;
  }
  
  public final ei lr(long paramLong)
  {
    this.gef = paramLong;
    return this;
  }
  
  public final ei ls(long paramLong)
  {
    this.gjl = paramLong;
    return this;
  }
  
  public final ei sa(String paramString)
  {
    AppMethodBeat.i(208193);
    this.gqd = z("Username", paramString, true);
    AppMethodBeat.o(208193);
    return this;
  }
  
  public final ei sb(String paramString)
  {
    AppMethodBeat.i(208194);
    this.gjw = z("Feedid", paramString, true);
    AppMethodBeat.o(208194);
    return this;
  }
  
  public final ei sc(String paramString)
  {
    AppMethodBeat.i(208197);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(208197);
    return this;
  }
  
  public final ei sd(String paramString)
  {
    AppMethodBeat.i(208198);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(208198);
    return this;
  }
  
  public final ei se(String paramString)
  {
    AppMethodBeat.i(208201);
    this.gjk = z("ClickTabContextId", paramString, true);
    AppMethodBeat.o(208201);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ei
 * JD-Core Version:    0.7.0.1
 */