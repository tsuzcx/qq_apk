package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ad
  extends a
{
  private String dSb;
  private String dUR;
  private long dUS;
  private long dUT;
  private long dUU;
  private String dUV;
  private long dUW;
  private long dUX;
  private long dUY;
  private long dUZ;
  
  public final String RD()
  {
    AppMethodBeat.i(209036);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUZ);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209036);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209037);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dUR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dUS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.dUT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.dUU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentPageName:").append(this.dUV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dUW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedType:").append(this.dUX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dUY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.dUZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209037);
    return localObject;
  }
  
  public final ad cl(long paramLong)
  {
    this.dUS = paramLong;
    return this;
  }
  
  public final ad cm(long paramLong)
  {
    this.dUT = paramLong;
    return this;
  }
  
  public final ad cn(long paramLong)
  {
    this.dUU = paramLong;
    return this;
  }
  
  public final ad co(long paramLong)
  {
    this.dUW = paramLong;
    return this;
  }
  
  public final ad cp(long paramLong)
  {
    this.dUX = paramLong;
    return this;
  }
  
  public final ad cq(long paramLong)
  {
    this.dUY = paramLong;
    return this;
  }
  
  public final ad gZ(String paramString)
  {
    AppMethodBeat.i(209033);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(209033);
    return this;
  }
  
  public final int getId()
  {
    return 19185;
  }
  
  public final ad ha(String paramString)
  {
    AppMethodBeat.i(209034);
    this.dUR = t("FeedId", paramString, true);
    AppMethodBeat.o(209034);
    return this;
  }
  
  public final ad hb(String paramString)
  {
    AppMethodBeat.i(209035);
    this.dUV = t("CurrentPageName", paramString, true);
    AppMethodBeat.o(209035);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ad
 * JD-Core Version:    0.7.0.1
 */