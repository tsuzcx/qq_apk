package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aj
  extends a
{
  private String dHr;
  private long dJR;
  private long dJS;
  private long dJT;
  private String dJY;
  private String dJZ;
  private String dKN;
  private long dKa;
  private long dKb;
  private long dKc;
  private String dLE;
  private long dLO;
  
  public final String PV()
  {
    AppMethodBeat.i(168919);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJT);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(168919);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(168920);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentPageName:").append(this.dKN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dKc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.dLE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedtype:").append(this.dLO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.dJY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.dJZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.dKa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.dKb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dJR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.dJS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.dJT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(168920);
    return localObject;
  }
  
  public final aj dH(long paramLong)
  {
    this.dKc = paramLong;
    return this;
  }
  
  public final aj dI(long paramLong)
  {
    this.dLO = paramLong;
    return this;
  }
  
  public final aj dJ(long paramLong)
  {
    this.dJR = paramLong;
    return this;
  }
  
  public final aj dK(long paramLong)
  {
    this.dJS = paramLong;
    return this;
  }
  
  public final aj dL(long paramLong)
  {
    this.dJT = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19186;
  }
  
  public final aj ho(String paramString)
  {
    AppMethodBeat.i(168914);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(168914);
    return this;
  }
  
  public final aj hp(String paramString)
  {
    AppMethodBeat.i(168915);
    this.dKN = t("CurrentPageName", paramString, true);
    AppMethodBeat.o(168915);
    return this;
  }
  
  public final aj hq(String paramString)
  {
    AppMethodBeat.i(168916);
    this.dLE = t("feedid", paramString, true);
    AppMethodBeat.o(168916);
    return this;
  }
  
  public final aj hr(String paramString)
  {
    AppMethodBeat.i(168917);
    this.dJY = t("Tag", paramString, true);
    AppMethodBeat.o(168917);
    return this;
  }
  
  public final aj hs(String paramString)
  {
    AppMethodBeat.i(168918);
    this.dJZ = t("TagId", paramString, true);
    AppMethodBeat.o(168918);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.aj
 * JD-Core Version:    0.7.0.1
 */