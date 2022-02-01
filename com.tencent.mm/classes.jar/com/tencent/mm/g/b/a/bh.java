package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bh
  extends a
{
  private String dFe;
  private long dHN;
  private long dHO;
  private long dHP;
  private String dHQ;
  private long dHR;
  private String dIp;
  private String dIq;
  private long dIr;
  private long dIs;
  private String dLA;
  private long dLY;
  
  public final String PR()
  {
    AppMethodBeat.i(168919);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHP);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(168919);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(168920);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentPageName:").append(this.dHQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dHR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.dLA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedtype:").append(this.dLY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.dIp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.dIq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.dIr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.dIs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dHN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.dHO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.dHP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(168920);
    return localObject;
  }
  
  public final bh fs(long paramLong)
  {
    this.dHR = paramLong;
    return this;
  }
  
  public final bh ft(long paramLong)
  {
    this.dLY = paramLong;
    return this;
  }
  
  public final bh fu(long paramLong)
  {
    this.dHN = paramLong;
    return this;
  }
  
  public final bh fv(long paramLong)
  {
    this.dHO = paramLong;
    return this;
  }
  
  public final bh fw(long paramLong)
  {
    this.dHP = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19186;
  }
  
  public final bh jc(String paramString)
  {
    AppMethodBeat.i(168914);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(168914);
    return this;
  }
  
  public final bh jd(String paramString)
  {
    AppMethodBeat.i(168915);
    this.dHQ = t("CurrentPageName", paramString, true);
    AppMethodBeat.o(168915);
    return this;
  }
  
  public final bh je(String paramString)
  {
    AppMethodBeat.i(168916);
    this.dLA = t("feedid", paramString, true);
    AppMethodBeat.o(168916);
    return this;
  }
  
  public final bh jf(String paramString)
  {
    AppMethodBeat.i(168917);
    this.dIp = t("Tag", paramString, true);
    AppMethodBeat.o(168917);
    return this;
  }
  
  public final bh jg(String paramString)
  {
    AppMethodBeat.i(168918);
    this.dIq = t("TagId", paramString, true);
    AppMethodBeat.o(168918);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bh
 * JD-Core Version:    0.7.0.1
 */