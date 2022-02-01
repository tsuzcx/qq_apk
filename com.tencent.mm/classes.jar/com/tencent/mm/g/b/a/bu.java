package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bu
  extends a
{
  private String dRJ = "";
  private long dWi;
  private long dWj;
  private long dWk;
  private long dWm;
  private String dYQ = "";
  private long ecc;
  
  public final String RC()
  {
    AppMethodBeat.i(184183);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecc);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(184183);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(184184);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.dRJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.dYQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dWm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dWi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.dWj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.dWk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RoleBeforeSwitch:").append(this.ecc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184184);
    return localObject;
  }
  
  public final bu gN(long paramLong)
  {
    this.dWm = paramLong;
    return this;
  }
  
  public final bu gO(long paramLong)
  {
    this.dWi = paramLong;
    return this;
  }
  
  public final bu gP(long paramLong)
  {
    this.dWj = paramLong;
    return this;
  }
  
  public final bu gQ(long paramLong)
  {
    this.dWk = paramLong;
    return this;
  }
  
  public final bu gR(long paramLong)
  {
    this.ecc = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19387;
  }
  
  public final bu kZ(String paramString)
  {
    AppMethodBeat.i(184181);
    this.dRJ = t("sessionid", paramString, true);
    AppMethodBeat.o(184181);
    return this;
  }
  
  public final bu la(String paramString)
  {
    AppMethodBeat.i(184182);
    this.dYQ = t("feedid", paramString, true);
    AppMethodBeat.o(184182);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bu
 * JD-Core Version:    0.7.0.1
 */