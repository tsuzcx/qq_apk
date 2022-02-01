package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aa
  extends a
{
  private String dHr;
  private String dJL;
  private long dJR;
  private long dJS;
  private long dKY;
  private long dKn;
  private long dKp;
  private long dKq;
  private String dKr;
  private long dKs;
  private String dKt;
  private long huW;
  
  public final String PV()
  {
    AppMethodBeat.i(184158);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.huW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKY);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(184158);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(184159);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickAvatarScene:").append(this.dKq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderUsername:").append(this.dKr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRole:").append(this.dKs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.dKt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.dKn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dJR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.dJS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dJL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedScene:").append(this.dKp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewAvatarClickScene:").append(this.huW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.dKY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184159);
    return localObject;
  }
  
  public final aa cF(long paramLong)
  {
    this.dKn = paramLong;
    return this;
  }
  
  public final aa cG(long paramLong)
  {
    this.dJR = paramLong;
    return this;
  }
  
  public final aa cH(long paramLong)
  {
    this.dJS = paramLong;
    return this;
  }
  
  public final aa cI(long paramLong)
  {
    this.dKp = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19405;
  }
  
  public final aa gw(String paramString)
  {
    AppMethodBeat.i(184154);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(184154);
    return this;
  }
  
  public final aa gx(String paramString)
  {
    AppMethodBeat.i(184155);
    this.dKr = t("FinderUsername", paramString, true);
    AppMethodBeat.o(184155);
    return this;
  }
  
  public final aa gy(String paramString)
  {
    AppMethodBeat.i(184156);
    this.dKt = t("Username", paramString, true);
    AppMethodBeat.o(184156);
    return this;
  }
  
  public final aa gz(String paramString)
  {
    AppMethodBeat.i(184157);
    this.dJL = t("FeedId", paramString, true);
    AppMethodBeat.o(184157);
    return this;
  }
  
  public final aa yd(long paramLong)
  {
    this.dKs = paramLong;
    return this;
  }
  
  public final aa ye(long paramLong)
  {
    this.huW = paramLong;
    return this;
  }
  
  public final aa yf(long paramLong)
  {
    this.dKY = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.aa
 * JD-Core Version:    0.7.0.1
 */