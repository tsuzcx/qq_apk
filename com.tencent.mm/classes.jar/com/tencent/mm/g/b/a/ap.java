package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ap
  extends a
{
  private String dSb;
  private String dUR;
  private long dWA;
  private long dWB;
  private String dWC;
  private long dWD;
  private long dWE;
  private long dWF;
  private long dWG;
  private long dWw;
  private long dWx;
  private String dWy;
  private String dWz;
  
  public final String RD()
  {
    AppMethodBeat.i(184152);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWG);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(184152);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(184153);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExpandType:").append(this.dWw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExpandCommentCount:").append(this.dWx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dUR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUsername:").append(this.dWy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentUsername:").append(this.dWz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentLikeCount:").append(this.dWA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTime:").append(this.dWB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentId:").append(this.dWC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubCommentCount:").append(this.dWD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.dWE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentRole:").append(this.dWF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedScene:").append(this.dWG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184153);
    return localObject;
  }
  
  public final ap dl(long paramLong)
  {
    this.dWw = paramLong;
    return this;
  }
  
  public final ap dm(long paramLong)
  {
    this.dWx = paramLong;
    return this;
  }
  
  public final ap dn(long paramLong)
  {
    this.dWA = paramLong;
    return this;
  }
  
  public final ap jdMethod_do(long paramLong)
  {
    this.dWB = paramLong;
    return this;
  }
  
  public final ap dp(long paramLong)
  {
    this.dWD = paramLong;
    return this;
  }
  
  public final ap dq(long paramLong)
  {
    this.dWE = paramLong;
    return this;
  }
  
  public final ap dr(long paramLong)
  {
    this.dWF = paramLong;
    return this;
  }
  
  public final ap ds(long paramLong)
  {
    this.dWG = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19421;
  }
  
  public final ap hP(String paramString)
  {
    AppMethodBeat.i(184147);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(184147);
    return this;
  }
  
  public final ap hQ(String paramString)
  {
    AppMethodBeat.i(184148);
    this.dUR = t("FeedId", paramString, true);
    AppMethodBeat.o(184148);
    return this;
  }
  
  public final ap hR(String paramString)
  {
    AppMethodBeat.i(184149);
    this.dWy = t("FeedUsername", paramString, true);
    AppMethodBeat.o(184149);
    return this;
  }
  
  public final ap hS(String paramString)
  {
    AppMethodBeat.i(184150);
    this.dWz = t("CommentUsername", paramString, true);
    AppMethodBeat.o(184150);
    return this;
  }
  
  public final ap hT(String paramString)
  {
    AppMethodBeat.i(184151);
    this.dWC = t("CommentId", paramString, true);
    AppMethodBeat.o(184151);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ap
 * JD-Core Version:    0.7.0.1
 */