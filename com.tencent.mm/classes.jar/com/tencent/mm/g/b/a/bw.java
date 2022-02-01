package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bw
  extends a
{
  private String dSb;
  private long dUS;
  private long dUT;
  private long dUU;
  private String dUV;
  private long dUW;
  private String dVW;
  private String dVX;
  private long dVY;
  private long dVZ;
  private String dXz;
  private long eaI;
  
  public final String RD()
  {
    AppMethodBeat.i(168919);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUU);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(168919);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(168920);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentPageName:").append(this.dUV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dUW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.dXz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedtype:").append(this.eaI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.dVW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.dVX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.dVY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.dVZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dUS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.dUT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.dUU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(168920);
    return localObject;
  }
  
  public final bw gO(long paramLong)
  {
    this.dUW = paramLong;
    return this;
  }
  
  public final bw gP(long paramLong)
  {
    this.eaI = paramLong;
    return this;
  }
  
  public final bw gQ(long paramLong)
  {
    this.dUS = paramLong;
    return this;
  }
  
  public final bw gR(long paramLong)
  {
    this.dUT = paramLong;
    return this;
  }
  
  public final bw gS(long paramLong)
  {
    this.dUU = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19186;
  }
  
  public final bw kP(String paramString)
  {
    AppMethodBeat.i(168914);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(168914);
    return this;
  }
  
  public final bw kQ(String paramString)
  {
    AppMethodBeat.i(168915);
    this.dUV = t("CurrentPageName", paramString, true);
    AppMethodBeat.o(168915);
    return this;
  }
  
  public final bw kR(String paramString)
  {
    AppMethodBeat.i(168916);
    this.dXz = t("feedid", paramString, true);
    AppMethodBeat.o(168916);
    return this;
  }
  
  public final bw kS(String paramString)
  {
    AppMethodBeat.i(168917);
    this.dVW = t("Tag", paramString, true);
    AppMethodBeat.o(168917);
    return this;
  }
  
  public final bw kT(String paramString)
  {
    AppMethodBeat.i(168918);
    this.dVX = t("TagId", paramString, true);
    AppMethodBeat.o(168918);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bw
 * JD-Core Version:    0.7.0.1
 */