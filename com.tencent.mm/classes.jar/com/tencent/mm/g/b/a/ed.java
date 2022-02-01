package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ed
  extends a
{
  private long eCA;
  private String els = "";
  private long ers;
  private long ert;
  private long eru;
  private long erw;
  private String euI = "";
  
  public final String abV()
  {
    AppMethodBeat.i(184183);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ers);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ert);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCA);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(184183);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(184184);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.euI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.erw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.ers);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.ert);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RoleBeforeSwitch:").append(this.eCA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184184);
    return localObject;
  }
  
  public final int getId()
  {
    return 19387;
  }
  
  public final ed lD(long paramLong)
  {
    this.erw = paramLong;
    return this;
  }
  
  public final ed lE(long paramLong)
  {
    this.ers = paramLong;
    return this;
  }
  
  public final ed lF(long paramLong)
  {
    this.ert = paramLong;
    return this;
  }
  
  public final ed lG(long paramLong)
  {
    this.eru = paramLong;
    return this;
  }
  
  public final ed lH(long paramLong)
  {
    this.eCA = paramLong;
    return this;
  }
  
  public final ed qJ(String paramString)
  {
    AppMethodBeat.i(184181);
    this.els = x("sessionid", paramString, true);
    AppMethodBeat.o(184181);
    return this;
  }
  
  public final ed qK(String paramString)
  {
    AppMethodBeat.i(184182);
    this.euI = x("feedid", paramString, true);
    AppMethodBeat.o(184182);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ed
 * JD-Core Version:    0.7.0.1
 */