package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dl
  extends a
{
  private long gdX;
  private long gef;
  private String ggA = "";
  private String gjB = "";
  private String gjX = "";
  private String gjj = "";
  private String gjk = "";
  private String glD = "";
  private String glE = "";
  private long gnC;
  private long gnD;
  private String gnM = "";
  private String gnN = "";
  private String gnv = "";
  private long gti;
  private long gtl;
  
  public final String agH()
  {
    AppMethodBeat.i(209166);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gti);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnN);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209166);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209171);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("UserName:").append(this.gjX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LiveID:").append(this.glE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedID:").append(this.glD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTS:").append(this.gnD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.gnv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index:").append(this.gdX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterStatus:").append(this.gnC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.gjj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.gjk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.gjB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OnlineNum:").append(this.gti);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSessionId:").append(this.gtl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chnl_extra:").append(this.gnM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickSubTabContextId:").append(this.gnN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209171);
    return localObject;
  }
  
  public final int getId()
  {
    return 22648;
  }
  
  public final dl iK(long paramLong)
  {
    this.gnD = paramLong;
    return this;
  }
  
  public final dl iL(long paramLong)
  {
    this.gef = paramLong;
    return this;
  }
  
  public final dl iM(long paramLong)
  {
    this.gdX = paramLong;
    return this;
  }
  
  public final dl iN(long paramLong)
  {
    this.gnC = paramLong;
    return this;
  }
  
  public final dl iO(long paramLong)
  {
    this.gti = paramLong;
    return this;
  }
  
  public final dl pX(String paramString)
  {
    AppMethodBeat.i(209146);
    this.gjX = z("UserName", paramString, true);
    AppMethodBeat.o(209146);
    return this;
  }
  
  public final dl pY(String paramString)
  {
    AppMethodBeat.i(209147);
    this.glE = z("LiveID", paramString, true);
    AppMethodBeat.o(209147);
    return this;
  }
  
  public final dl pZ(String paramString)
  {
    AppMethodBeat.i(209148);
    this.glD = z("FeedID", paramString, true);
    AppMethodBeat.o(209148);
    return this;
  }
  
  public final dl qa(String paramString)
  {
    AppMethodBeat.i(209149);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(209149);
    return this;
  }
  
  public final dl qb(String paramString)
  {
    AppMethodBeat.i(209153);
    this.gnv = z("CommentScene", paramString, true);
    AppMethodBeat.o(209153);
    return this;
  }
  
  public final dl qc(String paramString)
  {
    AppMethodBeat.i(209159);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(209159);
    return this;
  }
  
  public final dl qd(String paramString)
  {
    AppMethodBeat.i(209161);
    this.gjk = z("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209161);
    return this;
  }
  
  public final dl qe(String paramString)
  {
    AppMethodBeat.i(209162);
    this.gjB = z("SessionBuffer", paramString, true);
    AppMethodBeat.o(209162);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.dl
 * JD-Core Version:    0.7.0.1
 */