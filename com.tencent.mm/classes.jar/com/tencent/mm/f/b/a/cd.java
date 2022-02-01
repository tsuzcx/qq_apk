package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cd
  extends a
{
  private String gcU = "";
  private String gjj = "";
  private String gjk = "";
  private String gmO = "";
  private long gmP;
  private long gmQ;
  private long gmR;
  private long gnP;
  private String goR = "";
  private String goS = "";
  private int gph;
  private long gpi;
  
  public final String agH()
  {
    AppMethodBeat.i(184145);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gph);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjk);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(184145);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(184146);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickUI:").append(this.goR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.gmO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUsr:").append(this.goS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.gmP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.gmQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.gmR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickAll:").append(this.gph);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FullScreenCommentsArea:").append(this.gpi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.gjj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.gjk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184146);
    return localObject;
  }
  
  public final cd eV(long paramLong)
  {
    this.gmP = paramLong;
    return this;
  }
  
  public final cd eW(long paramLong)
  {
    this.gmQ = paramLong;
    return this;
  }
  
  public final cd eX(long paramLong)
  {
    this.gmR = paramLong;
    return this;
  }
  
  public final cd eY(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final cd eZ(long paramLong)
  {
    this.gpi = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19017;
  }
  
  public final cd lP(String paramString)
  {
    AppMethodBeat.i(184141);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(184141);
    return this;
  }
  
  public final cd lQ(String paramString)
  {
    AppMethodBeat.i(184142);
    this.goR = z("ClickUI", paramString, true);
    AppMethodBeat.o(184142);
    return this;
  }
  
  public final cd lR(String paramString)
  {
    AppMethodBeat.i(184143);
    this.gmO = z("FeedId", paramString, true);
    AppMethodBeat.o(184143);
    return this;
  }
  
  public final cd lS(String paramString)
  {
    AppMethodBeat.i(184144);
    this.goS = z("FeedUsr", paramString, true);
    AppMethodBeat.o(184144);
    return this;
  }
  
  public final cd lT(String paramString)
  {
    AppMethodBeat.i(209630);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(209630);
    return this;
  }
  
  public final cd lU(String paramString)
  {
    AppMethodBeat.i(209632);
    this.gjk = z("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209632);
    return this;
  }
  
  public final cd lq(int paramInt)
  {
    this.gph = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.cd
 * JD-Core Version:    0.7.0.1
 */