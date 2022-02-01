package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bl
  extends a
{
  private String gcU = "";
  private long gjl;
  private String gmO = "";
  private long gmP;
  private long gmQ;
  private long gmR;
  private String gmS = "";
  private long gmT;
  private long gmU;
  private long gmV;
  
  public final String agH()
  {
    AppMethodBeat.i(209604);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmV);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209604);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209605);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.gmO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.gmP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.gmQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.gmR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentPageName:").append(this.gmS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.gmT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedType:").append(this.gmU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.gjl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.gmV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209605);
    return localObject;
  }
  
  public final bl dD(long paramLong)
  {
    this.gmP = paramLong;
    return this;
  }
  
  public final bl dE(long paramLong)
  {
    this.gmQ = paramLong;
    return this;
  }
  
  public final bl dF(long paramLong)
  {
    this.gmR = paramLong;
    return this;
  }
  
  public final bl dG(long paramLong)
  {
    this.gmT = paramLong;
    return this;
  }
  
  public final bl dH(long paramLong)
  {
    this.gmU = paramLong;
    return this;
  }
  
  public final bl dI(long paramLong)
  {
    this.gjl = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19185;
  }
  
  public final bl jR(String paramString)
  {
    AppMethodBeat.i(209598);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(209598);
    return this;
  }
  
  public final bl jS(String paramString)
  {
    AppMethodBeat.i(209600);
    this.gmO = z("FeedId", paramString, true);
    AppMethodBeat.o(209600);
    return this;
  }
  
  public final bl jT(String paramString)
  {
    AppMethodBeat.i(209601);
    this.gmS = z("CurrentPageName", paramString, true);
    AppMethodBeat.o(209601);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.bl
 * JD-Core Version:    0.7.0.1
 */