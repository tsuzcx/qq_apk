package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fe
  extends a
{
  private String gcU = "";
  private String gjm = "";
  private long gmP;
  private long gmQ;
  private long gmR;
  private String gmS = "";
  private long gmT;
  private String goZ = "";
  private String gpa = "";
  private long gpb;
  private long gpc;
  private long gzp;
  
  public final String agH()
  {
    AppMethodBeat.i(168919);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmR);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(168919);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(168920);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentPageName:").append(this.gmS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.gmT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.gjm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedtype:").append(this.gzp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.goZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.gpa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.gpb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.gpc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.gmP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.gmQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.gmR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(168920);
    return localObject;
  }
  
  public final int getId()
  {
    return 19186;
  }
  
  public final fe mX(long paramLong)
  {
    this.gmT = paramLong;
    return this;
  }
  
  public final fe mY(long paramLong)
  {
    this.gzp = paramLong;
    return this;
  }
  
  public final fe mZ(long paramLong)
  {
    this.gmP = paramLong;
    return this;
  }
  
  public final fe na(long paramLong)
  {
    this.gmQ = paramLong;
    return this;
  }
  
  public final fe nb(long paramLong)
  {
    this.gmR = paramLong;
    return this;
  }
  
  public final fe tQ(String paramString)
  {
    AppMethodBeat.i(168914);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(168914);
    return this;
  }
  
  public final fe tR(String paramString)
  {
    AppMethodBeat.i(168915);
    this.gmS = z("CurrentPageName", paramString, true);
    AppMethodBeat.o(168915);
    return this;
  }
  
  public final fe tS(String paramString)
  {
    AppMethodBeat.i(168916);
    this.gjm = z("feedid", paramString, true);
    AppMethodBeat.o(168916);
    return this;
  }
  
  public final fe tT(String paramString)
  {
    AppMethodBeat.i(168917);
    this.goZ = z("Tag", paramString, true);
    AppMethodBeat.o(168917);
    return this;
  }
  
  public final fe tU(String paramString)
  {
    AppMethodBeat.i(168918);
    this.gpa = z("TagId", paramString, true);
    AppMethodBeat.o(168918);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.fe
 * JD-Core Version:    0.7.0.1
 */