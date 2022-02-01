package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ao
  extends a
{
  private String gcU = "";
  private String gjj = "";
  private String gjk = "";
  private long gjl;
  private String gjm = "";
  private String gjn = "";
  private String gjo = "";
  
  public final String agH()
  {
    AppMethodBeat.i(271620);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjo);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(271620);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(271621);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.gjj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.gjk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.gjl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.gjm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("rootCommentid:").append(this.gjn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("subCommentid:").append(this.gjo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(271621);
    return localObject;
  }
  
  public final ao cs(long paramLong)
  {
    this.gjl = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 23092;
  }
  
  public final ao je(String paramString)
  {
    AppMethodBeat.i(271613);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(271613);
    return this;
  }
  
  public final ao jf(String paramString)
  {
    AppMethodBeat.i(271615);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(271615);
    return this;
  }
  
  public final ao jg(String paramString)
  {
    AppMethodBeat.i(271616);
    this.gjk = z("ClickTabContextId", paramString, true);
    AppMethodBeat.o(271616);
    return this;
  }
  
  public final ao jh(String paramString)
  {
    AppMethodBeat.i(271617);
    this.gjm = z("feedid", paramString, true);
    AppMethodBeat.o(271617);
    return this;
  }
  
  public final ao ji(String paramString)
  {
    AppMethodBeat.i(271618);
    this.gjn = z("rootCommentid", paramString, true);
    AppMethodBeat.o(271618);
    return this;
  }
  
  public final ao jj(String paramString)
  {
    AppMethodBeat.i(271619);
    this.gjo = z("subCommentid", paramString, true);
    AppMethodBeat.o(271619);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ao
 * JD-Core Version:    0.7.0.1
 */