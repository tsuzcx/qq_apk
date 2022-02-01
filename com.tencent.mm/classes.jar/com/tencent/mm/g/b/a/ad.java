package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ad
  extends a
{
  private String dFe;
  private String dHM;
  private long dHN;
  private long dHO;
  private long dHP;
  private long dHY;
  private String dIg;
  private String dIh;
  private int dIw;
  private long dIx;
  
  public final String PR()
  {
    AppMethodBeat.i(184145);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIx);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(184145);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(184146);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickUI:").append(this.dIg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dHM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUsr:").append(this.dIh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dHN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.dHO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.dHP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickAll:").append(this.dIw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FullScreenCommentsArea:").append(this.dIx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184146);
    return localObject;
  }
  
  public final ad cE(long paramLong)
  {
    this.dHN = paramLong;
    return this;
  }
  
  public final ad cF(long paramLong)
  {
    this.dHO = paramLong;
    return this;
  }
  
  public final ad cG(long paramLong)
  {
    this.dHP = paramLong;
    return this;
  }
  
  public final ad cH(long paramLong)
  {
    this.dHY = paramLong;
    return this;
  }
  
  public final ad cI(long paramLong)
  {
    this.dIx = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19017;
  }
  
  public final ad gs(String paramString)
  {
    AppMethodBeat.i(184141);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(184141);
    return this;
  }
  
  public final ad gt(String paramString)
  {
    AppMethodBeat.i(184142);
    this.dIg = t("ClickUI", paramString, true);
    AppMethodBeat.o(184142);
    return this;
  }
  
  public final ad gu(String paramString)
  {
    AppMethodBeat.i(184143);
    this.dHM = t("FeedId", paramString, true);
    AppMethodBeat.o(184143);
    return this;
  }
  
  public final ad gv(String paramString)
  {
    AppMethodBeat.i(184144);
    this.dIh = t("FeedUsr", paramString, true);
    AppMethodBeat.o(184144);
    return this;
  }
  
  public final ad ic(int paramInt)
  {
    this.dIw = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ad
 * JD-Core Version:    0.7.0.1
 */