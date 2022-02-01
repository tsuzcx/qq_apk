package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bw
  extends a
{
  private String dTr = "";
  private long dWi;
  private long dWj;
  private long dWk;
  private String dWl = "";
  private long dWm;
  private String dXm = "";
  private String dXn = "";
  private long dXo;
  private long dXp;
  private String dYQ = "";
  private long ecd;
  
  public final String RC()
  {
    AppMethodBeat.i(168919);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWk);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(168919);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(168920);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentPageName:").append(this.dWl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dWm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.dYQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedtype:").append(this.ecd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.dXm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.dXn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.dXo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.dXp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dWi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.dWj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.dWk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(168920);
    return localObject;
  }
  
  public final bw gT(long paramLong)
  {
    this.dWm = paramLong;
    return this;
  }
  
  public final bw gU(long paramLong)
  {
    this.ecd = paramLong;
    return this;
  }
  
  public final bw gV(long paramLong)
  {
    this.dWi = paramLong;
    return this;
  }
  
  public final bw gW(long paramLong)
  {
    this.dWj = paramLong;
    return this;
  }
  
  public final bw gX(long paramLong)
  {
    this.dWk = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19186;
  }
  
  public final bw lc(String paramString)
  {
    AppMethodBeat.i(168914);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(168914);
    return this;
  }
  
  public final bw ld(String paramString)
  {
    AppMethodBeat.i(168915);
    this.dWl = t("CurrentPageName", paramString, true);
    AppMethodBeat.o(168915);
    return this;
  }
  
  public final bw le(String paramString)
  {
    AppMethodBeat.i(168916);
    this.dYQ = t("feedid", paramString, true);
    AppMethodBeat.o(168916);
    return this;
  }
  
  public final bw lf(String paramString)
  {
    AppMethodBeat.i(168917);
    this.dXm = t("Tag", paramString, true);
    AppMethodBeat.o(168917);
    return this;
  }
  
  public final bw lg(String paramString)
  {
    AppMethodBeat.i(168918);
    this.dXn = t("TagId", paramString, true);
    AppMethodBeat.o(168918);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bw
 * JD-Core Version:    0.7.0.1
 */