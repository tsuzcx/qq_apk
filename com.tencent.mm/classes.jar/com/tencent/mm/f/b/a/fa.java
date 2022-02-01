package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fa
  extends a
{
  private String ggA = "";
  private String gjm = "";
  private long gmP;
  private long gmQ;
  private long gmR;
  private long gmT;
  private long gzk;
  
  public final String agH()
  {
    AppMethodBeat.i(184183);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzk);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(184183);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(184184);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.gjm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.gmT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.gmP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.gmQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.gmR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RoleBeforeSwitch:").append(this.gzk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184184);
    return localObject;
  }
  
  public final int getId()
  {
    return 19387;
  }
  
  public final fa mP(long paramLong)
  {
    this.gmT = paramLong;
    return this;
  }
  
  public final fa mQ(long paramLong)
  {
    this.gmP = paramLong;
    return this;
  }
  
  public final fa mR(long paramLong)
  {
    this.gmQ = paramLong;
    return this;
  }
  
  public final fa mS(long paramLong)
  {
    this.gmR = paramLong;
    return this;
  }
  
  public final fa mT(long paramLong)
  {
    this.gzk = paramLong;
    return this;
  }
  
  public final fa tM(String paramString)
  {
    AppMethodBeat.i(184181);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(184181);
    return this;
  }
  
  public final fa tN(String paramString)
  {
    AppMethodBeat.i(184182);
    this.gjm = z("feedid", paramString, true);
    AppMethodBeat.o(184182);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.fa
 * JD-Core Version:    0.7.0.1
 */