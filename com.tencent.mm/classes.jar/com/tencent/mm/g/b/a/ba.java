package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ba
  extends a
{
  private String dFY;
  private String dFe;
  private String dHM;
  private long dHT;
  private String dHX;
  private long dIM;
  private String dLB;
  private long dLC;
  private String dLD;
  
  public final String PR()
  {
    AppMethodBeat.i(195006);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLD);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(195006);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(195007);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dFY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dHX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeItems:").append(this.dLB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCgiEnd:").append(this.dIM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dHM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dHT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalFriendLikeCnt:").append(this.dLC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterContextId:").append(this.dLD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195007);
    return localObject;
  }
  
  public final ba eS(long paramLong)
  {
    this.dIM = paramLong;
    return this;
  }
  
  public final ba eT(long paramLong)
  {
    this.dHT = paramLong;
    return this;
  }
  
  public final ba eU(long paramLong)
  {
    this.dLC = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19955;
  }
  
  public final ba iE(String paramString)
  {
    AppMethodBeat.i(195000);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(195000);
    return this;
  }
  
  public final ba iF(String paramString)
  {
    AppMethodBeat.i(195001);
    this.dFY = t("ContextId", paramString, true);
    AppMethodBeat.o(195001);
    return this;
  }
  
  public final ba iG(String paramString)
  {
    AppMethodBeat.i(195002);
    this.dHX = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(195002);
    return this;
  }
  
  public final ba iH(String paramString)
  {
    AppMethodBeat.i(195003);
    this.dLB = t("ExposeItems", paramString, true);
    AppMethodBeat.o(195003);
    return this;
  }
  
  public final ba iI(String paramString)
  {
    AppMethodBeat.i(195004);
    this.dHM = t("FeedId", paramString, true);
    AppMethodBeat.o(195004);
    return this;
  }
  
  public final ba iJ(String paramString)
  {
    AppMethodBeat.i(195005);
    this.dLD = t("EnterContextId", paramString, true);
    AppMethodBeat.o(195005);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ba
 * JD-Core Version:    0.7.0.1
 */