package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ai
  extends a
{
  private String dFJ;
  private long dJR;
  private long dJS;
  private long dJT;
  private long dKc;
  private String dLE;
  private long dLN;
  
  public final String PV()
  {
    AppMethodBeat.i(184183);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLN);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(184183);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(184184);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.dFJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.dLE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dKc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dJR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.dJS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.dJT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RoleBeforeSwitch:").append(this.dLN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184184);
    return localObject;
  }
  
  public final ai dC(long paramLong)
  {
    this.dKc = paramLong;
    return this;
  }
  
  public final ai dD(long paramLong)
  {
    this.dJR = paramLong;
    return this;
  }
  
  public final ai dE(long paramLong)
  {
    this.dJS = paramLong;
    return this;
  }
  
  public final ai dF(long paramLong)
  {
    this.dJT = paramLong;
    return this;
  }
  
  public final ai dG(long paramLong)
  {
    this.dLN = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19387;
  }
  
  public final ai hm(String paramString)
  {
    AppMethodBeat.i(184181);
    this.dFJ = t("sessionid", paramString, true);
    AppMethodBeat.o(184181);
    return this;
  }
  
  public final ai hn(String paramString)
  {
    AppMethodBeat.i(184182);
    this.dLE = t("feedid", paramString, true);
    AppMethodBeat.o(184182);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ai
 * JD-Core Version:    0.7.0.1
 */