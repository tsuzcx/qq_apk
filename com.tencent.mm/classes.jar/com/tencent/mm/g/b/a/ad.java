package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ad
  extends a
{
  private String dTr = "";
  private String dWh = "";
  private long dWi;
  private long dWj;
  private long dWk;
  private String dWl = "";
  private long dWm;
  private long dWn;
  private long dWo;
  private long dWp;
  
  public final String RC()
  {
    AppMethodBeat.i(189064);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWp);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189064);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189065);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dWi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.dWj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.dWk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentPageName:").append(this.dWl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dWm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedType:").append(this.dWn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dWo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.dWp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189065);
    return localObject;
  }
  
  public final ad cl(long paramLong)
  {
    this.dWi = paramLong;
    return this;
  }
  
  public final ad cm(long paramLong)
  {
    this.dWj = paramLong;
    return this;
  }
  
  public final ad cn(long paramLong)
  {
    this.dWk = paramLong;
    return this;
  }
  
  public final ad co(long paramLong)
  {
    this.dWm = paramLong;
    return this;
  }
  
  public final ad cp(long paramLong)
  {
    this.dWn = paramLong;
    return this;
  }
  
  public final ad cq(long paramLong)
  {
    this.dWo = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19185;
  }
  
  public final ad hf(String paramString)
  {
    AppMethodBeat.i(189061);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(189061);
    return this;
  }
  
  public final ad hg(String paramString)
  {
    AppMethodBeat.i(189062);
    this.dWh = t("FeedId", paramString, true);
    AppMethodBeat.o(189062);
    return this;
  }
  
  public final ad hh(String paramString)
  {
    AppMethodBeat.i(189063);
    this.dWl = t("CurrentPageName", paramString, true);
    AppMethodBeat.o(189063);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ad
 * JD-Core Version:    0.7.0.1
 */