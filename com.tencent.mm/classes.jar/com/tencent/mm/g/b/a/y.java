package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class y
  extends a
{
  private String dHr;
  private String dJK;
  private String dJL;
  private String dJM;
  private long dJR;
  private long dJS;
  private long dJT;
  private int dKd;
  private long dKe;
  private long gox;
  
  public final String PV()
  {
    AppMethodBeat.i(184145);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gox);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(184145);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(184146);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickUI:").append(this.dJK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dJL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUsr:").append(this.dJM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dJR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.dJS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.dJT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickAll:").append(this.dKd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FullScreenCommentsArea:").append(this.gox);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184146);
    return localObject;
  }
  
  public final y cs(long paramLong)
  {
    this.dJR = paramLong;
    return this;
  }
  
  public final y ct(long paramLong)
  {
    this.dJS = paramLong;
    return this;
  }
  
  public final y cu(long paramLong)
  {
    this.dJT = paramLong;
    return this;
  }
  
  public final y cv(long paramLong)
  {
    this.dKe = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19017;
  }
  
  public final y gn(String paramString)
  {
    AppMethodBeat.i(184141);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(184141);
    return this;
  }
  
  public final y go(String paramString)
  {
    AppMethodBeat.i(184142);
    this.dJK = t("ClickUI", paramString, true);
    AppMethodBeat.o(184142);
    return this;
  }
  
  public final y gp(String paramString)
  {
    AppMethodBeat.i(184143);
    this.dJL = t("FeedId", paramString, true);
    AppMethodBeat.o(184143);
    return this;
  }
  
  public final y gq(String paramString)
  {
    AppMethodBeat.i(184144);
    this.dJM = t("FeedUsr", paramString, true);
    AppMethodBeat.o(184144);
    return this;
  }
  
  public final y is(int paramInt)
  {
    this.dKd = paramInt;
    return this;
  }
  
  public final y xC(long paramLong)
  {
    this.gox = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.y
 * JD-Core Version:    0.7.0.1
 */