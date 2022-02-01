package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bm
  extends a
{
  private String dSb;
  private String dTd;
  private String dUR;
  private long dUY;
  private String dVc;
  private long dWu;
  private String dZK;
  private long dZL;
  private String dZM;
  
  public final String RD()
  {
    AppMethodBeat.i(209199);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZM);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209199);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209200);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dTd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dVc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeItems:").append(this.dZK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCgiEnd:").append(this.dWu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dUR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dUY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalFriendLikeCnt:").append(this.dZL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterContextId:").append(this.dZM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209200);
    return localObject;
  }
  
  public final bm fV(long paramLong)
  {
    this.dWu = paramLong;
    return this;
  }
  
  public final bm fW(long paramLong)
  {
    this.dUY = paramLong;
    return this;
  }
  
  public final bm fX(long paramLong)
  {
    this.dZL = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19955;
  }
  
  public final bm kc(String paramString)
  {
    AppMethodBeat.i(209193);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(209193);
    return this;
  }
  
  public final bm kd(String paramString)
  {
    AppMethodBeat.i(209194);
    this.dTd = t("ContextId", paramString, true);
    AppMethodBeat.o(209194);
    return this;
  }
  
  public final bm ke(String paramString)
  {
    AppMethodBeat.i(209195);
    this.dVc = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209195);
    return this;
  }
  
  public final bm kf(String paramString)
  {
    AppMethodBeat.i(209196);
    this.dZK = t("ExposeItems", paramString, true);
    AppMethodBeat.o(209196);
    return this;
  }
  
  public final bm kg(String paramString)
  {
    AppMethodBeat.i(209197);
    this.dUR = t("FeedId", paramString, true);
    AppMethodBeat.o(209197);
    return this;
  }
  
  public final bm kh(String paramString)
  {
    AppMethodBeat.i(209198);
    this.dZM = t("EnterContextId", paramString, true);
    AppMethodBeat.o(209198);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bm
 * JD-Core Version:    0.7.0.1
 */