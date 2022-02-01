package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ap
  extends a
{
  private String dTr = "";
  private String dWh = "";
  private long dXO;
  private long dXP;
  private String dXQ = "";
  private String dXR = "";
  private long dXS;
  private long dXT;
  private String dXU = "";
  private long dXV;
  private long dXW;
  private long dXX;
  private long dXY;
  
  public final String RC()
  {
    AppMethodBeat.i(184152);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dXO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXY);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(184152);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(184153);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExpandType:").append(this.dXO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExpandCommentCount:").append(this.dXP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUsername:").append(this.dXQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentUsername:").append(this.dXR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentLikeCount:").append(this.dXS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTime:").append(this.dXT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentId:").append(this.dXU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubCommentCount:").append(this.dXV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.dXW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentRole:").append(this.dXX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedScene:").append(this.dXY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184153);
    return localObject;
  }
  
  public final ap dm(long paramLong)
  {
    this.dXO = paramLong;
    return this;
  }
  
  public final ap dn(long paramLong)
  {
    this.dXP = paramLong;
    return this;
  }
  
  public final ap jdMethod_do(long paramLong)
  {
    this.dXS = paramLong;
    return this;
  }
  
  public final ap dp(long paramLong)
  {
    this.dXT = paramLong;
    return this;
  }
  
  public final ap dq(long paramLong)
  {
    this.dXV = paramLong;
    return this;
  }
  
  public final ap dr(long paramLong)
  {
    this.dXW = paramLong;
    return this;
  }
  
  public final ap ds(long paramLong)
  {
    this.dXX = paramLong;
    return this;
  }
  
  public final ap dt(long paramLong)
  {
    this.dXY = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19421;
  }
  
  public final ap hX(String paramString)
  {
    AppMethodBeat.i(184147);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(184147);
    return this;
  }
  
  public final ap hY(String paramString)
  {
    AppMethodBeat.i(184148);
    this.dWh = t("FeedId", paramString, true);
    AppMethodBeat.o(184148);
    return this;
  }
  
  public final ap hZ(String paramString)
  {
    AppMethodBeat.i(184149);
    this.dXQ = t("FeedUsername", paramString, true);
    AppMethodBeat.o(184149);
    return this;
  }
  
  public final ap ia(String paramString)
  {
    AppMethodBeat.i(184150);
    this.dXR = t("CommentUsername", paramString, true);
    AppMethodBeat.o(184150);
    return this;
  }
  
  public final ap ib(String paramString)
  {
    AppMethodBeat.i(184151);
    this.dXU = t("CommentId", paramString, true);
    AppMethodBeat.o(184151);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ap
 * JD-Core Version:    0.7.0.1
 */