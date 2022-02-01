package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bf
  extends a
{
  private String dDw;
  private long dHN;
  private long dHO;
  private long dHP;
  private long dHR;
  private String dLA;
  private long dLX;
  
  public final String PR()
  {
    AppMethodBeat.i(184183);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dDw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLX);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(184183);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(184184);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.dDw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.dLA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dHR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dHN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.dHO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.dHP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RoleBeforeSwitch:").append(this.dLX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184184);
    return localObject;
  }
  
  public final bf fm(long paramLong)
  {
    this.dHR = paramLong;
    return this;
  }
  
  public final bf fn(long paramLong)
  {
    this.dHN = paramLong;
    return this;
  }
  
  public final bf fo(long paramLong)
  {
    this.dHO = paramLong;
    return this;
  }
  
  public final bf fp(long paramLong)
  {
    this.dHP = paramLong;
    return this;
  }
  
  public final bf fq(long paramLong)
  {
    this.dLX = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19387;
  }
  
  public final bf iZ(String paramString)
  {
    AppMethodBeat.i(184181);
    this.dDw = t("sessionid", paramString, true);
    AppMethodBeat.o(184181);
    return this;
  }
  
  public final bf ja(String paramString)
  {
    AppMethodBeat.i(184182);
    this.dLA = t("feedid", paramString, true);
    AppMethodBeat.o(184182);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bf
 * JD-Core Version:    0.7.0.1
 */