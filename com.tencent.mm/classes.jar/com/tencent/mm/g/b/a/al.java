package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class al
  extends a
{
  private String dSb;
  private String dUR;
  private long dUS;
  private long dUT;
  private long dUU;
  private String dVN;
  private String dVO;
  private long dVd;
  private int dWe;
  private long dWf;
  
  public final String RD()
  {
    AppMethodBeat.i(184145);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWf);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(184145);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(184146);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickUI:").append(this.dVN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dUR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUsr:").append(this.dVO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dUS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.dUT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.dUU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickAll:").append(this.dWe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FullScreenCommentsArea:").append(this.dWf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184146);
    return localObject;
  }
  
  public final al cZ(long paramLong)
  {
    this.dUS = paramLong;
    return this;
  }
  
  public final al da(long paramLong)
  {
    this.dUT = paramLong;
    return this;
  }
  
  public final al db(long paramLong)
  {
    this.dUU = paramLong;
    return this;
  }
  
  public final al dc(long paramLong)
  {
    this.dVd = paramLong;
    return this;
  }
  
  public final al dd(long paramLong)
  {
    this.dWf = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19017;
  }
  
  public final al hC(String paramString)
  {
    AppMethodBeat.i(184141);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(184141);
    return this;
  }
  
  public final al hD(String paramString)
  {
    AppMethodBeat.i(184142);
    this.dVN = t("ClickUI", paramString, true);
    AppMethodBeat.o(184142);
    return this;
  }
  
  public final al hE(String paramString)
  {
    AppMethodBeat.i(184143);
    this.dUR = t("FeedId", paramString, true);
    AppMethodBeat.o(184143);
    return this;
  }
  
  public final al hF(String paramString)
  {
    AppMethodBeat.i(184144);
    this.dVO = t("FeedUsr", paramString, true);
    AppMethodBeat.o(184144);
    return this;
  }
  
  public final al in(int paramInt)
  {
    this.dWe = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.al
 * JD-Core Version:    0.7.0.1
 */