package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class al
  extends a
{
  private String dTr = "";
  private String dWh = "";
  private long dWi;
  private long dWj;
  private long dWk;
  private long dWt;
  private String dXd = "";
  private String dXe = "";
  private int dXw;
  private long dXx;
  
  public final String RC()
  {
    AppMethodBeat.i(184145);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXx);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(184145);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(184146);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickUI:").append(this.dXd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUsr:").append(this.dXe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dWi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.dWj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.dWk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickAll:").append(this.dXw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FullScreenCommentsArea:").append(this.dXx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184146);
    return localObject;
  }
  
  public final al cZ(long paramLong)
  {
    this.dWi = paramLong;
    return this;
  }
  
  public final al da(long paramLong)
  {
    this.dWj = paramLong;
    return this;
  }
  
  public final al db(long paramLong)
  {
    this.dWk = paramLong;
    return this;
  }
  
  public final al dc(long paramLong)
  {
    this.dWt = paramLong;
    return this;
  }
  
  public final al dd(long paramLong)
  {
    this.dXx = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19017;
  }
  
  public final al hK(String paramString)
  {
    AppMethodBeat.i(184141);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(184141);
    return this;
  }
  
  public final al hL(String paramString)
  {
    AppMethodBeat.i(184142);
    this.dXd = t("ClickUI", paramString, true);
    AppMethodBeat.o(184142);
    return this;
  }
  
  public final al hM(String paramString)
  {
    AppMethodBeat.i(184143);
    this.dWh = t("FeedId", paramString, true);
    AppMethodBeat.o(184143);
    return this;
  }
  
  public final al hN(String paramString)
  {
    AppMethodBeat.i(184144);
    this.dXe = t("FeedUsr", paramString, true);
    AppMethodBeat.o(184144);
    return this;
  }
  
  public final al ip(int paramInt)
  {
    this.dXw = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.al
 * JD-Core Version:    0.7.0.1
 */