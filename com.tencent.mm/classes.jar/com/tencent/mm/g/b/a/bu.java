package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bu
  extends a
{
  private String dQt;
  private long dUS;
  private long dUT;
  private long dUU;
  private long dUW;
  private String dXz;
  private long eaH;
  
  public final String RD()
  {
    AppMethodBeat.i(184183);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaH);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(184183);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(184184);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.dQt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.dXz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dUW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dUS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.dUT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.dUU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RoleBeforeSwitch:").append(this.eaH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184184);
    return localObject;
  }
  
  public final bu gI(long paramLong)
  {
    this.dUW = paramLong;
    return this;
  }
  
  public final bu gJ(long paramLong)
  {
    this.dUS = paramLong;
    return this;
  }
  
  public final bu gK(long paramLong)
  {
    this.dUT = paramLong;
    return this;
  }
  
  public final bu gL(long paramLong)
  {
    this.dUU = paramLong;
    return this;
  }
  
  public final bu gM(long paramLong)
  {
    this.eaH = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19387;
  }
  
  public final bu kM(String paramString)
  {
    AppMethodBeat.i(184181);
    this.dQt = t("sessionid", paramString, true);
    AppMethodBeat.o(184181);
    return this;
  }
  
  public final bu kN(String paramString)
  {
    AppMethodBeat.i(184182);
    this.dXz = t("feedid", paramString, true);
    AppMethodBeat.o(184182);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bu
 * JD-Core Version:    0.7.0.1
 */