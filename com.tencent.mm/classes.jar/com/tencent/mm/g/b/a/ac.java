package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ac
  extends a
{
  private String dJL;
  private String dJM;
  private long dJR;
  private long dJS;
  private long dJT;
  private long dJU;
  private long dJV;
  private long dJW;
  private long dJX;
  private String dJY;
  private String dJZ;
  private String dKI;
  private long dKJ;
  private long dKK;
  private String dKL;
  private String dKM;
  private String dKN;
  private long dKa;
  private long dKb;
  private long dKc;
  private String dLe;
  private String dMw;
  private String gnM;
  
  public final String PV()
  {
    AppMethodBeat.i(168900);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnM);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(168900);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(168901);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Sessionid:").append(this.dKI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardType:").append(this.dKJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardResult:").append(this.dKK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardId:").append(this.dKL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dJL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUsr:").append(this.dJM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardToUsr:").append(this.dKM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dJR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.dJS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.dJT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriCommentCount:").append(this.dJU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedAuthorLikeCount:").append(this.dJV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedAuthorCommentCount:").append(this.dJW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentPageName:").append(this.dKN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedType:").append(this.dJX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.dJY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.dJZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.dKa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.dKb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dKc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dMw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dLe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.gnM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(168901);
    return localObject;
  }
  
  public final ac aRM(String paramString)
  {
    AppMethodBeat.i(203742);
    this.dMw = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(203742);
    return this;
  }
  
  public final ac aRN(String paramString)
  {
    AppMethodBeat.i(203743);
    this.dLe = t("ContextId", paramString, true);
    AppMethodBeat.o(203743);
    return this;
  }
  
  public final ac aRO(String paramString)
  {
    AppMethodBeat.i(203744);
    this.gnM = t("SessionBuffer", paramString, true);
    AppMethodBeat.o(203744);
    return this;
  }
  
  public final ac cJ(long paramLong)
  {
    this.dKJ = paramLong;
    return this;
  }
  
  public final ac cK(long paramLong)
  {
    this.dKK = paramLong;
    return this;
  }
  
  public final ac cL(long paramLong)
  {
    this.dJR = paramLong;
    return this;
  }
  
  public final ac cM(long paramLong)
  {
    this.dJS = paramLong;
    return this;
  }
  
  public final ac cN(long paramLong)
  {
    this.dJT = paramLong;
    return this;
  }
  
  public final ac cO(long paramLong)
  {
    this.dJX = paramLong;
    return this;
  }
  
  public final ac cP(long paramLong)
  {
    this.dKc = paramLong;
    return this;
  }
  
  public final ac gE(String paramString)
  {
    AppMethodBeat.i(168893);
    this.dKI = t("Sessionid", paramString, true);
    AppMethodBeat.o(168893);
    return this;
  }
  
  public final ac gF(String paramString)
  {
    AppMethodBeat.i(168894);
    this.dJL = t("FeedId", paramString, true);
    AppMethodBeat.o(168894);
    return this;
  }
  
  public final ac gG(String paramString)
  {
    AppMethodBeat.i(168895);
    this.dJM = t("FeedUsr", paramString, true);
    AppMethodBeat.o(168895);
    return this;
  }
  
  public final ac gH(String paramString)
  {
    AppMethodBeat.i(168896);
    this.dKM = t("ForwardToUsr", paramString, true);
    AppMethodBeat.o(168896);
    return this;
  }
  
  public final ac gI(String paramString)
  {
    AppMethodBeat.i(168897);
    this.dKN = t("CurrentPageName", paramString, true);
    AppMethodBeat.o(168897);
    return this;
  }
  
  public final ac gJ(String paramString)
  {
    AppMethodBeat.i(168898);
    this.dJY = t("Tag", paramString, true);
    AppMethodBeat.o(168898);
    return this;
  }
  
  public final ac gK(String paramString)
  {
    AppMethodBeat.i(168899);
    this.dJZ = t("TagId", paramString, true);
    AppMethodBeat.o(168899);
    return this;
  }
  
  public final int getId()
  {
    return 18941;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ac
 * JD-Core Version:    0.7.0.1
 */