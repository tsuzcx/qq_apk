package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class x
  extends a
{
  private long dHq;
  private String dHr;
  private String dJK;
  private String dJL;
  private String dJM;
  private long dJN;
  private long dJO;
  private String dJP;
  private long dJQ;
  private long dJR;
  private long dJS;
  private long dJT;
  private long dJU;
  private long dJV;
  private long dJW;
  private long dJX;
  private String dJY;
  private String dJZ;
  private long dKa;
  private long dKb;
  private long dKc;
  private String dLe;
  private String dMw;
  private long dRi;
  private String gnM;
  private long gnj;
  
  public final x NG(String paramString)
  {
    AppMethodBeat.i(203680);
    this.dLe = t("ContextId", paramString, true);
    AppMethodBeat.o(203680);
    return this;
  }
  
  public final x NH(String paramString)
  {
    AppMethodBeat.i(203681);
    this.dMw = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(203681);
    return this;
  }
  
  public final x NI(String paramString)
  {
    AppMethodBeat.i(203682);
    this.gnM = t("SessionBuffer", paramString, true);
    AppMethodBeat.o(203682);
    return this;
  }
  
  public final String PV()
  {
    AppMethodBeat.i(168891);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnM);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(168891);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(168892);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickUI:").append(this.dJK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dJL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUsr:").append(this.dJM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickType:").append(this.dJN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.dHq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LikeType:").append(this.dJO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReplyUsr:").append(this.dJP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReplyType:").append(this.dJQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dJR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.dJS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.dJT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriCommentCount:").append(this.dJU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedAuthorLikeCount:").append(this.dJV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedAuthorCommentCount:").append(this.dJW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedType:").append(this.dJX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.dJY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.dJZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.dKa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.dKb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dKc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSelf:").append(this.dRi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsShowRecWording:").append(this.gnj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dLe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dMw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.gnM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(168892);
    return localObject;
  }
  
  public final x cj(long paramLong)
  {
    this.dJN = paramLong;
    return this;
  }
  
  public final x ck(long paramLong)
  {
    this.dHq = paramLong;
    return this;
  }
  
  public final x cl(long paramLong)
  {
    this.dJO = paramLong;
    return this;
  }
  
  public final x cm(long paramLong)
  {
    this.dJQ = paramLong;
    return this;
  }
  
  public final x cn(long paramLong)
  {
    this.dJR = paramLong;
    return this;
  }
  
  public final x co(long paramLong)
  {
    this.dJS = paramLong;
    return this;
  }
  
  public final x cp(long paramLong)
  {
    this.dJT = paramLong;
    return this;
  }
  
  public final x cq(long paramLong)
  {
    this.dJX = paramLong;
    return this;
  }
  
  public final x cr(long paramLong)
  {
    this.dKc = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 18942;
  }
  
  public final x gg(String paramString)
  {
    AppMethodBeat.i(168884);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(168884);
    return this;
  }
  
  public final x gh(String paramString)
  {
    AppMethodBeat.i(168885);
    this.dJK = t("ClickUI", paramString, true);
    AppMethodBeat.o(168885);
    return this;
  }
  
  public final x gi(String paramString)
  {
    AppMethodBeat.i(168886);
    this.dJL = t("FeedId", paramString, true);
    AppMethodBeat.o(168886);
    return this;
  }
  
  public final x gj(String paramString)
  {
    AppMethodBeat.i(168887);
    this.dJM = t("FeedUsr", paramString, true);
    AppMethodBeat.o(168887);
    return this;
  }
  
  public final x gk(String paramString)
  {
    AppMethodBeat.i(168888);
    this.dJP = t("ReplyUsr", paramString, true);
    AppMethodBeat.o(168888);
    return this;
  }
  
  public final x gl(String paramString)
  {
    AppMethodBeat.i(168889);
    this.dJY = t("Tag", paramString, true);
    AppMethodBeat.o(168889);
    return this;
  }
  
  public final x gm(String paramString)
  {
    AppMethodBeat.i(168890);
    this.dJZ = t("TagId", paramString, true);
    AppMethodBeat.o(168890);
    return this;
  }
  
  public final x vB(long paramLong)
  {
    this.dRi = paramLong;
    return this;
  }
  
  public final x xc(long paramLong)
  {
    this.gnj = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.x
 * JD-Core Version:    0.7.0.1
 */