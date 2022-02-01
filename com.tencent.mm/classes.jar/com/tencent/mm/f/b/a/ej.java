package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ej
  extends a
{
  private String gcU = "";
  private String gjj = "";
  private String gjk = "";
  private long gjl;
  private String gmO = "";
  private long gpy;
  private String gxh = "";
  private long gxi;
  private String gxj = "";
  
  public final String agH()
  {
    AppMethodBeat.i(208642);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxj);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208642);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208643);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.gjj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.gjk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeItems:").append(this.gxh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCgiEnd:").append(this.gpy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.gmO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.gjl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalFriendLikeCnt:").append(this.gxi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterContextId:").append(this.gxj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208643);
    return localObject;
  }
  
  public final int getId()
  {
    return 19955;
  }
  
  public final ej lt(long paramLong)
  {
    this.gpy = paramLong;
    return this;
  }
  
  public final ej lu(long paramLong)
  {
    this.gjl = paramLong;
    return this;
  }
  
  public final ej lv(long paramLong)
  {
    this.gxi = paramLong;
    return this;
  }
  
  public final ej sf(String paramString)
  {
    AppMethodBeat.i(208634);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(208634);
    return this;
  }
  
  public final ej sg(String paramString)
  {
    AppMethodBeat.i(208635);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(208635);
    return this;
  }
  
  public final ej sh(String paramString)
  {
    AppMethodBeat.i(208636);
    this.gjk = z("ClickTabContextId", paramString, true);
    AppMethodBeat.o(208636);
    return this;
  }
  
  public final ej si(String paramString)
  {
    AppMethodBeat.i(208638);
    this.gxh = z("ExposeItems", paramString, true);
    AppMethodBeat.o(208638);
    return this;
  }
  
  public final ej sj(String paramString)
  {
    AppMethodBeat.i(208639);
    this.gmO = z("FeedId", paramString, true);
    AppMethodBeat.o(208639);
    return this;
  }
  
  public final ej sk(String paramString)
  {
    AppMethodBeat.i(208640);
    this.gxj = z("EnterContextId", paramString, true);
    AppMethodBeat.o(208640);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ej
 * JD-Core Version:    0.7.0.1
 */