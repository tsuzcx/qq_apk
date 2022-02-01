package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class z
  extends a
{
  private String dFe;
  private String dHM;
  private long dHN;
  private long dHO;
  private long dHP;
  private String dHQ;
  private long dHR;
  private long dHS;
  private long dHT;
  private long dHU;
  
  public final String PR()
  {
    AppMethodBeat.i(194882);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHU);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(194882);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(194883);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dHM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dHN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.dHO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.dHP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentPageName:").append(this.dHQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dHR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedType:").append(this.dHS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dHT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.dHU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194883);
    return localObject;
  }
  
  public final z cg(long paramLong)
  {
    this.dHN = paramLong;
    return this;
  }
  
  public final z ch(long paramLong)
  {
    this.dHO = paramLong;
    return this;
  }
  
  public final z ci(long paramLong)
  {
    this.dHP = paramLong;
    return this;
  }
  
  public final z cj(long paramLong)
  {
    this.dHR = paramLong;
    return this;
  }
  
  public final z ck(long paramLong)
  {
    this.dHS = paramLong;
    return this;
  }
  
  public final z cl(long paramLong)
  {
    this.dHT = paramLong;
    return this;
  }
  
  public final z fX(String paramString)
  {
    AppMethodBeat.i(194879);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(194879);
    return this;
  }
  
  public final z fY(String paramString)
  {
    AppMethodBeat.i(194880);
    this.dHM = t("FeedId", paramString, true);
    AppMethodBeat.o(194880);
    return this;
  }
  
  public final z fZ(String paramString)
  {
    AppMethodBeat.i(194881);
    this.dHQ = t("CurrentPageName", paramString, true);
    AppMethodBeat.o(194881);
    return this;
  }
  
  public final int getId()
  {
    return 19185;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.z
 * JD-Core Version:    0.7.0.1
 */