package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ah
  extends a
{
  private String dFe;
  private String dHM;
  private long dIN;
  private long dIO;
  private String dIP;
  private String dIQ;
  private long dIR;
  private long dIS;
  private String dIT;
  private long dIU;
  private long dIV;
  private long dIW;
  private long dIX;
  
  public final String PR()
  {
    AppMethodBeat.i(184152);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dIN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIX);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(184152);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(184153);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExpandType:").append(this.dIN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExpandCommentCount:").append(this.dIO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dHM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUsername:").append(this.dIP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentUsername:").append(this.dIQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentLikeCount:").append(this.dIR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTime:").append(this.dIS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentId:").append(this.dIT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubCommentCount:").append(this.dIU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.dIV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentRole:").append(this.dIW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedScene:").append(this.dIX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184153);
    return localObject;
  }
  
  public final ah cP(long paramLong)
  {
    this.dIN = paramLong;
    return this;
  }
  
  public final ah cQ(long paramLong)
  {
    this.dIO = paramLong;
    return this;
  }
  
  public final ah cR(long paramLong)
  {
    this.dIR = paramLong;
    return this;
  }
  
  public final ah cS(long paramLong)
  {
    this.dIS = paramLong;
    return this;
  }
  
  public final ah cT(long paramLong)
  {
    this.dIU = paramLong;
    return this;
  }
  
  public final ah cU(long paramLong)
  {
    this.dIV = paramLong;
    return this;
  }
  
  public final ah cV(long paramLong)
  {
    this.dIW = paramLong;
    return this;
  }
  
  public final ah cW(long paramLong)
  {
    this.dIX = paramLong;
    return this;
  }
  
  public final ah gF(String paramString)
  {
    AppMethodBeat.i(184147);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(184147);
    return this;
  }
  
  public final ah gG(String paramString)
  {
    AppMethodBeat.i(184148);
    this.dHM = t("FeedId", paramString, true);
    AppMethodBeat.o(184148);
    return this;
  }
  
  public final ah gH(String paramString)
  {
    AppMethodBeat.i(184149);
    this.dIP = t("FeedUsername", paramString, true);
    AppMethodBeat.o(184149);
    return this;
  }
  
  public final ah gI(String paramString)
  {
    AppMethodBeat.i(184150);
    this.dIQ = t("CommentUsername", paramString, true);
    AppMethodBeat.o(184150);
    return this;
  }
  
  public final ah gJ(String paramString)
  {
    AppMethodBeat.i(184151);
    this.dIT = t("CommentId", paramString, true);
    AppMethodBeat.o(184151);
    return this;
  }
  
  public final int getId()
  {
    return 19421;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ah
 * JD-Core Version:    0.7.0.1
 */