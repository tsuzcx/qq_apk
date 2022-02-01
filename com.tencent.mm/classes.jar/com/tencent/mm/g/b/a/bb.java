package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bb
  extends a
{
  private String eiB = "";
  private String err = "";
  private long ers;
  private long ert;
  private long eru;
  private String erv = "";
  private long erw;
  private long erx;
  private long ery;
  private long erz;
  
  public final String abV()
  {
    AppMethodBeat.i(208845);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.err);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ers);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ert);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ery);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erz);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208845);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208846);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.err);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.ers);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.ert);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentPageName:").append(this.erv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.erw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedType:").append(this.erx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.ery);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.erz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208846);
    return localObject;
  }
  
  public final bb cX(long paramLong)
  {
    this.ers = paramLong;
    return this;
  }
  
  public final bb cY(long paramLong)
  {
    this.ert = paramLong;
    return this;
  }
  
  public final bb cZ(long paramLong)
  {
    this.eru = paramLong;
    return this;
  }
  
  public final bb da(long paramLong)
  {
    this.erw = paramLong;
    return this;
  }
  
  public final bb db(long paramLong)
  {
    this.erx = paramLong;
    return this;
  }
  
  public final bb dc(long paramLong)
  {
    this.ery = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19185;
  }
  
  public final bb iI(String paramString)
  {
    AppMethodBeat.i(208842);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(208842);
    return this;
  }
  
  public final bb iJ(String paramString)
  {
    AppMethodBeat.i(208843);
    this.err = x("FeedId", paramString, true);
    AppMethodBeat.o(208843);
    return this;
  }
  
  public final bb iK(String paramString)
  {
    AppMethodBeat.i(208844);
    this.erv = x("CurrentPageName", paramString, true);
    AppMethodBeat.o(208844);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bb
 * JD-Core Version:    0.7.0.1
 */