package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class he
  extends a
{
  private String dHr;
  private String dJL;
  private long dJR;
  private long dJS;
  private long dJT;
  private long dJX;
  private String dKN;
  private long dKY;
  private long dKc;
  private long dkQ;
  
  public final he BJ(String paramString)
  {
    AppMethodBeat.i(203663);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(203663);
    return this;
  }
  
  public final he CJ(String paramString)
  {
    AppMethodBeat.i(203664);
    this.dJL = t("FeedId", paramString, true);
    AppMethodBeat.o(203664);
    return this;
  }
  
  public final he CK(String paramString)
  {
    AppMethodBeat.i(203665);
    this.dKN = t("CurrentPageName", paramString, true);
    AppMethodBeat.o(203665);
    return this;
  }
  
  public final String PV()
  {
    AppMethodBeat.i(203666);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dkQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKY);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203666);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203667);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dJL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dJR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.dJS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.dJT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentPageName:").append(this.dKN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dKc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedType:").append(this.dJX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dkQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.dKY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203667);
    return localObject;
  }
  
  public final he cE(long paramLong)
  {
    this.dJR = paramLong;
    return this;
  }
  
  public final he cR(long paramLong)
  {
    this.dJS = paramLong;
    return this;
  }
  
  public final he dU(long paramLong)
  {
    this.dJT = paramLong;
    return this;
  }
  
  public final he ew(long paramLong)
  {
    this.dKc = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19185;
  }
  
  public final he lD(long paramLong)
  {
    this.dJX = paramLong;
    return this;
  }
  
  public final he mC(long paramLong)
  {
    this.dkQ = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.he
 * JD-Core Version:    0.7.0.1
 */