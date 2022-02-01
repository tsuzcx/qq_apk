package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ci
  extends a
{
  private String gcU = "";
  private long ggh;
  private String gmO = "";
  private long gpH;
  private long gpI;
  private String gpJ = "";
  private String gpK = "";
  private long gpL;
  private long gpM;
  private String gpN = "";
  private long gpO;
  private long gpP;
  private long gpQ;
  
  public final String agH()
  {
    AppMethodBeat.i(184152);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gpH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpQ);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(184152);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(184153);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExpandType:").append(this.gpH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExpandCommentCount:").append(this.gpI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.gmO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUsername:").append(this.gpJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentUsername:").append(this.gpK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentLikeCount:").append(this.gpL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTime:").append(this.gpM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentId:").append(this.gpN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubCommentCount:").append(this.gpO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.ggh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentRole:").append(this.gpP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedScene:").append(this.gpQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184153);
    return localObject;
  }
  
  public final ci fl(long paramLong)
  {
    this.gpH = paramLong;
    return this;
  }
  
  public final ci fm(long paramLong)
  {
    this.gpI = paramLong;
    return this;
  }
  
  public final ci fn(long paramLong)
  {
    this.gpL = paramLong;
    return this;
  }
  
  public final ci fo(long paramLong)
  {
    this.gpM = paramLong;
    return this;
  }
  
  public final ci fp(long paramLong)
  {
    this.gpO = paramLong;
    return this;
  }
  
  public final ci fq(long paramLong)
  {
    this.ggh = paramLong;
    return this;
  }
  
  public final ci fr(long paramLong)
  {
    this.gpP = paramLong;
    return this;
  }
  
  public final ci fs(long paramLong)
  {
    this.gpQ = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19421;
  }
  
  public final ci mj(String paramString)
  {
    AppMethodBeat.i(184147);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(184147);
    return this;
  }
  
  public final ci mk(String paramString)
  {
    AppMethodBeat.i(184148);
    this.gmO = z("FeedId", paramString, true);
    AppMethodBeat.o(184148);
    return this;
  }
  
  public final ci ml(String paramString)
  {
    AppMethodBeat.i(184149);
    this.gpJ = z("FeedUsername", paramString, true);
    AppMethodBeat.o(184149);
    return this;
  }
  
  public final ci mm(String paramString)
  {
    AppMethodBeat.i(184150);
    this.gpK = z("CommentUsername", paramString, true);
    AppMethodBeat.o(184150);
    return this;
  }
  
  public final ci mn(String paramString)
  {
    AppMethodBeat.i(184151);
    this.gpN = z("CommentId", paramString, true);
    AppMethodBeat.o(184151);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ci
 * JD-Core Version:    0.7.0.1
 */